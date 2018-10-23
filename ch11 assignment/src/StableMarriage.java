// Mark Kazzaz
// Bellevue College CS211 Fall Quarter
// Assignment 4 - Chapter 11
// 2018-10-23

// This program reads an input file of preferences and find a stable marriage
// scenario.  The algorithm gives preference to either men or women depending
// upon whether this call is made from main:
//      makeMatches(men, women);
// or whether this call is made:
//      makeMatches(women, men);

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StableMarriage {
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

        //setAllNotFree(list1); // for testing only

        setAllFree(list1);
        setAllFree(list2);

        while (stillOpen(list1)) {
            // create a list of people who need to assignments passed through
            List<Person> needToAssign = new ArrayList<>();
            for (Person subject : list1) {
                if (subject.hasChoices() && !subject.hasPartner()) {
                    needToAssign.add(subject);
                }
            }

            // grab the first person as the left side of the marriage
            Person leftSide = needToAssign.get(0);
            Integer leftSideNumber = list1.indexOf(leftSide);

            // figure out who the right side of the marriage is
            Person rightSide = list2.get(leftSide.getChoices().get(0));
            Integer rightSideNumber = list2.indexOf(rightSide);

            // if rightSide currently has a spouse, unassign them
            if (rightSide.hasPartner()) {
                list1.get(rightSide.getPartner()).erasePartner();
            }

            // set the engagement between left and right side
            leftSide.setPartner(list2.indexOf(rightSide));
            rightSide.setPartner(list1.indexOf(leftSide));

            // step through rightSide's preference list and remove
            // less preferred matches from both rightSide and otherLeftSide
            int leftSideRank = rightSide.getChoices().indexOf(leftSideNumber);
            ArrayList<Integer> otherLeftSide = new ArrayList<Integer>();

            for (int i = leftSideRank + 1; i < rightSide.getChoices().size(); i++){
                otherLeftSide.add(rightSide.getChoices().get(i));
            }

            // drop choices from rightSide
            rightSide.getChoices().removeAll(otherLeftSide);

            // drop rightSide availability from otherLeftSides
            for (int subject : otherLeftSide){
                list1.get(subject).getChoices().remove(rightSideNumber);
            }

        }


    }

    public static void setAllFree(List<Person> list) {
        // cycle through a list of people and set them all free
        for (Person subject : list) {
            subject.erasePartner();
        }
    }

    public static void setAllNotFree(List<Person> list) {
        // for testing purposes only
        // setting all people to be assigned to person 0
        for (Person subject : list) {
            subject.setPartner(0);
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

    public static boolean stillOpen(List<Person> list) {
        for (Person subject : list) {
            if (!subject.hasPartner() && subject.hasChoices()) {
                return true;
            }
        }

        return false;
    }

}
