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

        A lot of the code confusion in class stemmed from indexing
        Three formats have hyphens, one does not ...
        Two formats have parentheses, two do not ...
        So we don't know when these things are acceptable.

        Here's my idea:
        All four of the acceptable formats have different lengths
        "(425)-564-2856"    14 characters       format 14
        "(425)564-2856"     13 characters       format 13
        "425-564-2856"      12 characters       format 12
        "4255642856"        10 characters       format 10

        By first checking the string lengths we can ...
            A) Rule out anything that doesn't have the right length
            B) Know which format to check against
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

    // remember the default answer is true, we're looking to disqualify it
    public static boolean isPhone (String in)    {
        // we need two variables both declared inside the for-loop

        // disqualify strings with a length other than 10, 12, 13, or 14
        // if something has a different string length it's not a good format
        if (in.length() < 10 || in.length() == 11 || in.length() > 14)    {
            return false;
        }

        // format 14
        if (in.length() == 14)  {
            // check the position of the parentheses and hyphens
            if (in.charAt(0) == '('
                    && in.charAt(4) == ')'
                    && in.charAt(5) == '-'
                    && in.charAt(9) == '-') {
                // if it DOES have those values in the right places, do nothing
            }   else    {
                // it DOESN'T have those in the right places, it's disqualified
                return false;
            }
        }

        // format 13
        if (in.length() == 13)  {
            // check the position of the parentheses and hyphens
            if (in.charAt(0) == '(' && in.charAt(4) == ')' && in.charAt(8) == '-')  {
                // if it DOES have those values in the right places, do nothing
            }   else    {
                // it DOESN'T have those in the right places, it's disqualified
                return false;
            }
        }

        // format 12
        if (in.length() == 12)  {
            // check the position of the hyphens
            if (in.charAt(3) == '-' && in.charAt(7) == '-') {
                // if it DOES have those values in the right places, do nothing
            }   else    {
                // it DOESN'T have those in the right places, it's disqualified
                return false;
            }
        }

        // now pull out all the hyphens and parentheses, we're done with them
        in = in.replace("(","");
        in = in.replace(")","");
        in = in.replace("-","");

        System.out.println(in);
        // right now all acceptable formats coming in should look just like format 10

        // but we check the string length again to make sure it has exactly 10 characters
        // if it doesn't there may have been extra parentheses or hyphens hiding
        if (in.length() == 10)  {
            // do nothing
        }   else    {
            return false;
        }

        // disqualify if the first index is a zero or a one, that's not allowed
        if (in.charAt(0) == 0 || in.charAt(0) == 1) {
            return false;
        }

        // now we for-loop through the string, disqualifying it if we find a non-number
        for (int i = 0; i < in.length(); i++)   {
            char c = in.charAt(i);
            if (Character.isDigit(c)) {
                // if it IS a number, do nothing
            }   else    {
                // if it IS NOT a number, disqualify it
                return false;
            }
        }

        // if the string makes it through all this, it should be good to go
        return true;

    }   // end of isPhone method

}   // end of class
