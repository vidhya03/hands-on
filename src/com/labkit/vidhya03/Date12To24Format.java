package com.labkit.vidhya03;

import java.io.*;
        import java.math.*;
        import java.text.*;
        import java.util.*;
        import java.util.regex.*;

public class Date12To24Format {

    /*
     * Complete the timeConversion function below.
     *
     *
     * Sample Input 0
     * 07:05:45PM
     * Sample Output 0
     * 19:05:45
     *
     *
     *
     *
     *
     *
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */

        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
        Date date = null;
        try {
            date = parseFormat.parse(s);
        } catch (ParseException e) {
            return "";
        }
        return displayFormat.format(date);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = "07:05:45PM";

        String result = timeConversion(s);

        System.out.println("result = " + result);

        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
        Date date = null;
        try {
            date = parseFormat.parse("10:30 PM");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));
    }
}
