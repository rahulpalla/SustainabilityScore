import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class SustainabilityScoreCalc {

    public static void main (String [] args) throws FileNotFoundException {
        final double constant1 = 0.4;
        final double constant2 = 0.2;
        String USA = "USA";
        String Iceland = "Iceland";
        String UK = "UK";
        String China = "China";
        String France = "France";
        Scanner keyboard = new Scanner(System.in);
        File file1 = getInfo(keyboard);
        Scanner reader = new Scanner(file1);
        String categories = reader.nextLine();
        int [] usaFactors = getFactors(keyboard, file1, reader);
        reader.nextLine();
        int [] icelandFactors = getFactors(keyboard, file1, reader);
        reader.nextLine();
        int [] ukFactors = getFactors(keyboard, file1, reader);
        reader.nextLine();
        int [] chinaFactors = getFactors(keyboard, file1, reader);
        reader.nextLine();
        int [] franceFactors = getFactors(keyboard, file1, reader);
        int usScore = doCalc(usaFactors, constant1, constant2);
        int icelandScore = doCalc(icelandFactors, constant1, constant2);
        int ukScore = doCalc(ukFactors, constant1, constant2);
        int chinaScore = doCalc(chinaFactors, constant1, constant2);
        int franceScore = doCalc(franceFactors, constant1, constant2);
        System.out.println();
        System.out.println();
        printChart();
        System.out.println();
        System.out.println();
        printResults(USA, usaFactors, usScore);
        System.out.println();
        System.out.println();
        printResults(Iceland, icelandFactors, icelandScore);
        System.out.println();
        System.out.println();
        printResults(UK, ukFactors, ukScore);
        System.out.println();
        System.out.println();
        printResults(China, chinaFactors, chinaScore);
        System.out.println();
        System.out.println();
        printResults(France, franceFactors, franceScore);
        System.out.println();
        System.out.println();
    }
    public static File getInfo(Scanner keyboard){
        System.out.println();
        System.out.print("Type in \"CountryInfo.txt\": ");
        File file1 = new File(keyboard.next());
        return file1;
    }

    public static int [] getFactors(Scanner keyboard, File file1, Scanner reader) throws FileNotFoundException {
        String country = reader.next();
        int factor1 = reader.nextInt();
        int factor2 = reader.nextInt();
        int factor3 = reader.nextInt();
        int [] countryFactors = {factor1,factor2, factor3};
        return countryFactors;
    }

    public static int doCalc(int [] factors, double constant1, double constant2){
    int sustainanabilityScore =  (int) (factors[0]*(constant1) + factors[1]*(constant2) -
            factors[2]*(constant1));
    return sustainanabilityScore;
    }

    public static void printChart(){
        System.out.println("Sustainability Score Ratings:");
        System.out.println("0-9: F. Improvement necessary.");
        System.out.println("10-19: D. Can implement better practices.");
        System.out.println("20-29: C. Could do better but not the worst.");
        System.out.println("30-39: B. On the right path.");
        System.out.println("40-50: A. Amazing! Keep doing what you're doing!");
    }

    public static void printResults(String country, int[] factors, int score){
        System.out.println(country);
        System.out.println("Percent of Electricity coming from Renewable Sources: " +factors[0] + "%");
        System.out.println("Recycling Rate: " + factors[1]+ "%");
        System.out.println("Carbon Emissions: " + factors[2] + " metric tons per capita");
        System.out.println("Sustainability Score: " + score + "/50");
        outro(score);
    }

    public static void outro(int score){
        System.out.println();
        if(score >= 0 && score <= 9){
            System.out.println("Abysmal. Not worried about the environment at all.");
            System.out.println("Can implement many better practices. Switch to more renewable sources.");
            System.out.println("Protect the trees and limit deforestation. Join global climate organizations.");
            System.out.println("Drastically reduce carbon footprint and educate the public about greener practices.");
            System.out.println("Introduce rewards for green behavior such as carpool lanes for high" +
                    " occupancy vehicles as an incentives.");
            System.out.println("Make an effort to recycle more and pass bills that introduce benefits for " +
                    "businesses that recycle a certain amount.");
        }
        if(score>=10 && score <= 19 ){
            System.out.println("Bad, but not the worst. Not worried about the environment much.");
            System.out.println("Can benefit from greener practices. Switch to more renewable sources.");
            System.out.println("Limit deforestation and make an effort to recycle more. Watch carbon emissions and" +
                    "try to reduce footprint.");
        }
        if(score>=20 && score <= 29){
            System.out.println("Average. Not harming the environment too much but not helping it much either.");
            System.out.println("Try implementing more greener practices to help improve sustainability and reduce the " +
                    "dangers of climate change.");
        }
        if(score>=30 && score<=39){
            System.out.println("On the right track. Interested in helping sustainability and the environment.");
            System.out.println("Continue implementing green practices such as switching to more renewable sources" +
                    " and recycling more.");
        }
        if(score>=40 && score <=50){
            System.out.println("Doing amazing! Continue doing what you are doing and keep setting a great example " +
                    "for the rest of the world!");
        }
    }
}
