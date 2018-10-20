// This program reads an input file of preferences and find a stable marriage
// scenario.  The algorithm gives preference to either men or women depending
// upon whether this call is made from main:
//      makeMatches(men, women);
// or whether this call is made:
//      makeMatches(women, men);

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StableMarriage2 {
    public static final String LIST_END = "END";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("What is the input file? ");
        //TODO replace once done testing
        String fileName = "/Users/kazzazmk/Repos/2018-fall-bellevuecollege-java-2/ch11 assignment/short.dat"; //console.nextLine();
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

        while (stillOpen(list1)) {
            // create a list of people who need to assignments passed through
            List<Person> needToAssign = new ArrayList<>();
            for (Person subject : list1) {
                if (subject.hasChoices() && !subject.hasPartner()) {
                    needToAssign.add(subject);
                }
            }

            // go through the list
            Iterator<Person> it = needToAssign.iterator();
            while (it.hasNext()) {
                // assign the current subject to the left side of the marriage
                Person leftSide = it.next();

                // figure out who is leftSide's most preferred spouse
                Person rightSide = list2.get(leftSide.getFirstChoice());

                // unassign rightSide partner if a partner exists
                if (rightSide.hasPartner()){
                    list1.get(rightSide.getPartner()).erasePartner();
                }

                // set marriage assignment
                leftSide.setPartner(list2.indexOf(rightSide));
                rightSide.setPartner(list1.indexOf(leftSide));

                // remove rightSide availability from other leftSide lists
                for (Person subject : list1){
                    if (!subject.equals(leftSide)){
                        subject.getChoices().remove(list2.indexOf(rightSide));
                    }
                }

                // remove less desirable people from rightSide list
                int partnerRank = rightSide.getChoices().indexOf(rightSide.getPartner());
                System.out.println();




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

    public static boolean stillOpen(List<Person> list) {
        for (Person subject : list) {
            if (!subject.hasPartner() && subject.hasChoices()) {
                return true;
            }
        }

        return false;
    }

}
