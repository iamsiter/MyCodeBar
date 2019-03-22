package com.java8;

public class DateDiffCalc {

    static class Date {
        int d, m, y;

        public Date(int d, int m, int y) {
            this.d = d;
            this.m = m;
            this.y = y;
        }

    }

    static int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static int countLeapYears(Date d) {

        /*These are the conditions for a leap year :
          The year is evenly divisible by 4;
          If the year can be evenly divided by 100, it is NOT a leap year, unless;
          The year is also evenly divisible by 400. Then it is a leap year.*/

        int years = d.y;

        if (d.m <= 2) {
            years--;
        }

        return years / 4 - years / 100 + years / 400;
    }

    static int getDifference(Date dt1, Date dt2) {

        int n1 = dt1.y * 365 + dt1.d;

        for (int i = 0; i < dt1.m - 1; i++) {
            n1 += monthDays[i];
        }

        n1 += countLeapYears(dt1); //extra day

        int n2 = dt2.y * 365 + dt2.d;
        for (int i = 0; i < dt2.m - 1; i++) {
            n2 += monthDays[i];
        }
        n2 += countLeapYears(dt2); //extra day

        return (n2 - n1);
    }

    public static void main(String[] args) {
        Date dt1 = new Date(1, 2, 2000);
        Date dt2 = new Date(1, 2, 2004);
        System.out.println("Difference between two dates is " +
                getDifference(dt1, dt2));
    }
}
