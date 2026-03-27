import java.util.*;

public class Problem64DaysOfMonth {
    public static void main(String[] args) {
        String[] strFullName = {"january", "febuary", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
        String[] strAbbreviation = {"jan.", "feb.", "mar.", "apr.", "may.", "jun.", "jul.", "aug.", "sep.", "oct.", "nov.", "dec."};
        String[] str3Letters = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};

        int iMonth, iYear;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the month (Full name, Abbreviation, 3 letters or number): ");
        while (true) {
            String month = sc.nextLine();
            try {
                iMonth = Integer.parseInt(month);
            } catch (NumberFormatException e1) {
                month = month.toLowerCase();
                int month1 = Arrays.asList(strFullName).indexOf(month);
                int month2 = Arrays.asList(strAbbreviation).indexOf(month);
                int month3 = Arrays.asList(str3Letters).indexOf(month);
                iMonth = 1 + Math.max(Math.max(month1, month2), month3);
            }
            if (iMonth < 1 || iMonth > 12) {
                System.out.print("You have entered an invalid month/month name, please try again: ");
            } else {
                break;
            }
        }

        System.out.print("Enter the year (4 digits): ");
        while (true) {
            String year = sc.nextLine();
            try {
                iYear = Integer.parseInt(year);
            } catch (NumberFormatException e1) {
                System.out.print("You have entered an invalid year, please try again: ");
                continue;
            }
            if (iYear < 1000 || iYear > 9999) {
                System.out.print("You have entered an invalid year, please try again: ");
            } else {
                break;
            }
        }

        int[] type1 = {1, 3, 5, 7, 8, 10, 12};

        if (iMonth != 2) {
            if (Arrays.asList(type1).indexOf(iMonth) != -1) {
                System.out.println("Month " + iMonth + " of year " + iYear + " has 31 days");
            } else {
                System.out.println("Month " + iMonth + " of year " + iYear + " has 30 days");
            }
        } else {
            if (iYear % 4 == 0) {
                if (iYear % 100 == 0 && iYear % 400 != 0) {
                    System.out.println("Month 2 of year " + iYear + " has 28 days");
                } else {
                    System.out.println("Month 2 of year " + iYear + " has 29 days");    
                }
            } else {
                System.out.println("Month 2 of year " + iYear + " has 28 days");    
            }
        }
        sc.close();
    }
}