//Karl Savinskiy

import java.util.Scanner;

public class JDF {

    public static void main(String[] args) {
        // Get the array from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date in format YYYY/MM/DD:");
        String dateAr = scanner.nextLine();
        // String dateAr = "2000/12/31";
        // Split the date array
        String[] splitedDate = dateAr.split("/");
        int year = Integer.parseInt(splitedDate[0]);
        int month = Integer.parseInt(splitedDate[1]);
        int date = Integer.parseInt(splitedDate[2]);

        String resultJDF = converterJDF(year, month, date);
        
        System.out.println("The Julian date for " + dateAr + " is " +  resultJDF + ".");

        
    }

    public static String converterJDF(int year, int month, int date){

        // Leap year checking
        int[] daysInMonthNotLeap = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysInMonthLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leap = false;

        if (year % 4 == 0){
            if (year % 100 == 0){
                if (year % 400 == 0){
                    leap = true;
                }
            } else {
                leap = true;
            }
         } 

        // Calculate the final result

        String resultJDF = "";

        // add the years
        int years = year % 100;

        // add the days
        int days = 0;

        if (leap){
            for ( int i = 0; i < month - 1; i++){
                days += daysInMonthLeap[i];
            }
        } else {
            for ( int i = 0; i < month - 1; i++){
                days += daysInMonthNotLeap[i];
            }
        }

        days += date;
        // to add leading 0's if they will be needed
        resultJDF = String.format("%02d%03d", years, days);

        return resultJDF;
    }
}
