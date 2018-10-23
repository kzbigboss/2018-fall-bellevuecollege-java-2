// Mark Kazzaz
// Bellvue College CS211 Fall Quarter
// Assignment 4 - Chapter 11
// 2018-10-19

// This program reads an input file of preferences and find a stable marriage
// scenario.  The algorithm gives preference to either men or women depending
// upon whether this call is made from main:
//      makeMatches(men, women);
// or whether this call is made:
//      makeMatches(women, men);

import java.io.*;
import java.util.*;

public class StableMarriageOriginal {
    public static final String LIST_END = "END";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("What is the input file? ");
        String fileName = console.nextLine();
        Scanner input = new Scanner(new File(fileName));
        System.out.println();

        List<Person> men = readHalf(input);
        List<Person> women = readHalf(input);
        makeMatches(men, women);

        writeList(men, women, "Matches for men");
        writeList(women, men, "Matches for women");
    }

    public static Person readPerson(String line) {
        int index = line.indexOf(":");
        Person result = new Person(line.substring(0, index));
        Scanner data = new Scanner(line.substring(index + 1));
        while (data.hasNextInt()) {
            result.addChoice(data.nextInt());
        }
        return result;
    }

    public static List<Person> readHalf(Scanner input) {
        List<Person> result = new ArrayList<Person>();
        String line = input.nextLine();
        while (!line.equals(LIST_END)) {
            result.add(readPerson(line));
            line = input.nextLine();
        }
        return result;
    }

    public static void makeMatches(List<Person> list1, List<Person> list2) {
        // when starting to make matches, first make sure everyone
        // is listed as free.
        setAllFree(list1);
        setAllFree(list2);

        // create two sets of people and preferences, make it generic
        // enough to enable the client to switch men/women groups
        HashMap<Person, List<Integer>> marriageLeftSide = new HashMap<>();
        HashMap<Person, List<Integer>> marriageRightSide = new HashMap<>();
        addToSide(list1, marriageLeftSide);
        addToSide(list2, marriageRightSide);

        // create a list of leftside of the marriage to cycle through
        List<Person> needToAssign = new ArrayList<Person>();
        needToAssign.addAll(list1);
        ListIterator<Person> it = needToAssign.listIterator();

        // Begin loop to assign couples
        //
        // while needToAssign still contains people to process


        while (it.hasNext()) {
            // cycle through people currently on the need to assign list
            Person leftSide = it.next();

            // record what number the leftSide person is from
            // the list of people
            Integer leftSideNumber = list1.indexOf(leftSide);

            // record who is the most preferred match and record their number
            Person rightSide = list2.get(marriageLeftSide.get(leftSide).get(0));
            Integer rightSideNumber = list2.indexOf(rightSide);

            // if rightside has partner, set the partner free
            if (rightSide.hasPartner()) {
                Person p = list1.get(rightSide.getPartner());
                p.erasePartner();
            }

            // set left and right to be each other's partners
            leftSide.setPartner(rightSideNumber);
            rightSide.setPartner(leftSideNumber);

            // remove rightSide's availability from other leftSide's lists
            for (Person otherLeftSide : marriageLeftSide.keySet()) {
                if (!otherLeftSide.equals(leftSide)) {
                    List<Integer> updateList = marriageLeftSide.get(otherLeftSide);
                    updateList.remove(marriageLeftSide.get(leftSide).get(0));
                }
            }

            // update rightSide's preferences leaving only more preferred matches in the list
            List<Integer> updateList = marriageRightSide.get(rightSide);
            int leftRankInRight = updateList.indexOf(leftSideNumber);

            // for (start to end in rightSide preferences : remove i);
            for (int i = leftRankInRight + 1; i < updateList.size(); i++) {
                updateList.remove(i);
            }

            // Update the mapping for the right side after removing
            // for less preferable matches
            marriageRightSide.put(rightSide, updateList);

            // make lists updates
            it.remove(); //remove current person from list
            for (Person subject : list1){
                if (subject.hasChoices() && !subject.hasPartner()){
                    it.add(subject);
                }
            }

        }


    }

    public static void addToSide(List<Person> list, HashMap<Person, List<Integer>> map) {
        for (Person subject : list) {
            map.put(subject, subject.getChoices());
        }
    }

    public static void setAllFree(List<Person> list) {
        // cycle through a list of people and set them all free
        for (Person subject : list) {
            subject.erasePartner();
        }
    }

    public static void writeList(List<Person> list1, List<Person> list2,
                                 String title) {
        System.out.println(title);
        System.out.println("Name           Choice  Partner");
        System.out.println("--------------------------------------");
        int sum = 0;
        int count = 0;
        for (Person p : list1) {
            System.out.printf("%-15s", p.getName());
            if (!p.hasPartner()) {
                System.out.println("  --    nobody");
            } else {
                int rank = p.getPartnerRank();
                sum += rank;
                count++;
                System.out.printf("%4d    %s\n", rank,
                        list2.get(p.getPartner()).getName());
            }
        }
        System.out.println("Mean choice = " + (double) sum / count);
        System.out.println();
    }

}
