// This program reads an input file of preferences and find a stable marriage
// scenario.  The algorithm gives preference to either men or women depending
// upon whether this call is made from main:
//      makeMatches(men, women);
// or whether this call is made:
//      makeMatches(women, men);

import java.io.*;
import java.util.*;

public class StableMarriage {
    public static final String LIST_END = "END";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("What is the input file? ");
        String fileName = "/Users/kazzazmk/Repos/2018-fall-bellevuecollege-java-2/ch11 assignment/src/short.dat"; //console.nextLine(); //replace once done testing
        Scanner input = new Scanner(new File(fileName));
        System.out.println();

        List<Person> men = readHalf(input);
        List<Person> women = readHalf(input);
        //makeMatches(men, women);




        //writeList(men, women, "Matches for men");
        //writeList(women, men, "Matches for women");
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
        setAllFree(list1);
        setAllFree(list2);

        while (subjectAvailable(list1)){
            for (Person subject : list1){
                subject.setPartner(subject.getFirstChoice()); // set first choice
            }
        }
    }

    public static void setAllFree(List<Person> list){
        // cycle through a list of people and set them all free
        for (Person subject : list){
            subject.erasePartner();
        }
    }

    public static boolean subjectAvailable(List<Person> list){
        // cycle through a list of people to determine if anyone
        // is still single and has preferences available

        for (Person subject : list){
            if (!subject.hasPartner() && subject.hasChoices()){
                return true;
            }
        }
        return false;

    }

    public static void writeList(List<Person> list1,  List<Person> list2,
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

    public static void dropAfterRank(Person target, int matchRank){
        // intent: drop Person's preferences that follow their
        // current match's rank


    }
}
