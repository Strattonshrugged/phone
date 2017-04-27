/**
 * Created by jared on 4/26/17.
 */

import java.util.*;

public class Phone {

    public static void main(String args[]) {
        /*
        Valid String Formats ...
        "4255642856"
        "425-564-2856"
        "(425)564-2856"
        "(425)-564-2856"

        This approach is more verbose than the class code
        But it may be simpler to understand and more airtight

        A lot of the code confusion in class stemmed from indexing
        Three formats have hyphens, one does not ...
        Two formats have parentheses, two do not ...
        So we don't know when these things are acceptable.

        Here's my idea:
        All four of the acceptable formats have different  lengths
        "4255642856"        10 characters       format A
        "425-564-2856"      12 characters       format B
        "(425)564-2856"     13 characters       format C
        "(425)-564-2856"    14 characters       format D

        By checking the string lengths we can ...
            A) Rule out anything that doesn't have the right length
            B) Know which format to check against

        Kept this simple: main method calling isPhone method
         */

        Scanner console = new Scanner(System.in);
        String input;
        boolean answer;

        while (true)    {
            System.out.println("Enter a number to be checked :");
            input = console.next();
            answer = isPhone(input);
            System.out.printf(input + "\t" + answer + "\n");
        }

    }   // end of main

    // the default answer is true, we're looking to disqualify it
    public static boolean isPhone (String in)    {
        char c;

        // disqualify strings with a length other than 10, 12, 13, or 14
        if (in.length() < 10 || in.length() == 11 || in.length() > 14)    {
            return false;
        }

        // format A for-loop
        if (in.length() == 10)    {
            // disqualify if first alphanumeric index is zero or one
            if (in.charAt(0) == 0 || in.charAt(0) == 1) {
                return false;
            }
            // loop through each character
            for (int i = 0; i < in.length(); i++)   {
                c = in.charAt(i);
                // disqualify if not a number
                if (Character.isDigit(c)) {
                    // nothing happens, it's a number
                }   else    {
                    // it's not a number
                    return false;
                }
            }
        } // end format A check

        // format B for-loop
        if (in.length() == 12)    {
            // disqualify if first alphanumeric index is zero or one
            if (in.charAt(0) == 0 || in.charAt(0) == 1) {
                return false;
            }
            // loop through each character
            for (int i = 0; i < in.length(); i++)   {
                // if it's where a hyphen should be
                if (i == 3 || i == 7)  {
                    // if there's not a hyphen there
                    if (in.charAt(i) != '-') {
                        // disqualify it
                        return false;
                    }
                // if it's all the other places where a number should be
                }   else    {
                    // check to see if it's a digit
                    if (Character.isDigit(in.charAt(i)))    {
                        // do nothing if it is a digit
                    }   else    {
                        // disqualify it if there is not a digit
                        return false;
                    }
                }
            }
        } // end format B check

        // format C for-loop
        if (in.length() == 13)    {
            // disqualify if first alphanumeric index is zero or one
            if (in.charAt(1) == 0 || in.charAt(1) == 1) {
                return false;
            }
            // loop through each character
            for (int i = 0; i < in.length(); i++)   {
                // check for left paranthesis
                if (i == 0) {
                    // check to make sure a left parenthesis is where it should be
                    if (in.charAt(i) != '(')    {
                        return false;
                    }
                }   else if (i == 4)    {
                    // check to make sure a right parenthesis is where it should be
                    if (in.charAt(i) != ')')    {
                        return false;
                    }
                }   else if (i == 8)    {
                    // check to make sure a hyphen is where it should be
                    if (in.charAt(i) != '-')    {
                        return false;
                    }
                }   else    {
                    // for everything 'else' check to make sure it's a digit
                    if (Character.isDigit(in.charAt(i)))    {
                        // do nothing if it is a digit
                    }   else    {
                        // disqualify it if there is not a digit
                        return false;
                    }
                }
            }
        } // end format C check

        // format D for-loop
        if (in.length() == 14) {
            // disqualify if first alphanumeric index is zero or one
            if (in.charAt(1) == 0 || in.charAt(1) == 1) {
                return false;
            }
            // loop through each character
            for (int i = 0; i < in.length(); i++) {
                // check for left paranthesis
                if (i == 0) {
                    // check to make sure a left parenthesis is where it should be
                    if (in.charAt(i) != '(') {
                        return false;
                    }
                } else if (i == 4) {
                    // check to make sure a right parenthesis is where it should be
                    if (in.charAt(i) != ')') {
                        return false;
                    }
                } else if (i == 5) {
                    // check to make sure first hyphen is where it should be
                    if (in.charAt(i) != '-') {
                        return false;
                    }
                } else if (i == 9) {
                    // check to make sure second hyphen is where it should be
                    if (in.charAt(i) != '-') {
                        return false;
                    }
                } else {
                    // for everything 'else' check to make sure it's a digit
                    if (Character.isDigit(in.charAt(i))) {
                        // do nothing if it is a digit
                    } else {
                        // disqualify it if there is not a digit
                        return false;
                    }
                }
            }
        } // end of format D check

        return true;

    }   // end of isPhone method

}   // end of class
