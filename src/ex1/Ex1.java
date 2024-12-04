package ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */


    public static int number2Int(String num) {

        // add your code here
        String digits = "0123456789ABCDEFG";
        String num1 = num.split("b")[0];
        int base;
        if (num.split("b").length == 2) {
          base =  digits.indexOf(num.split("b")[1]);
        } else {
            base = 10;
        }
        int ans = 0;
        for (int i = 0; i < num1.length(); i++) {
            int n = digits.indexOf(num1.charAt(i));
            ans += n*Math.pow(base, num1.length() - 1 - i);
        }

        return ans;


    }



            private static int getDigitValue(char digitChar) {
                if (digitChar >= '0' && digitChar <= '9') {
                    return digitChar - '0';
                } else if (digitChar >= 'A' && digitChar <= 'G') {
                    return digitChar - 'A' + 10;
                } else {
                    return -1;
                }
            }

            public static void main(String[] args) {

            }





    ////////////////////
    /**
     * This static function checks if the given String (a) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        if (a == null || a.length() < 3)
            return false;
        if (a.charAt(a.length() - 2) != 'b')
            return false;
        if (!isBase(a.charAt(a.length() - 1)))
            return false;
        char base = a.charAt(a.length() - 1);
        for (int i = 0; i < a.length() - 2; i++) {
            if (!isDigit(a.charAt(i)) || a.charAt(i) >= base)
                return false;
        }
        return true;
    }

    private static boolean isBase(char c) {
        if (c >= '2' && c <= '9') {
            return true;
        }
        if (c >= 'A' && c <= 'G') {
            return true;
        }
        return false;
    }


    private static boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'A' && c <= 'F') {
            return true;
        }
        return false;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16)
            return "";
        if (num == 0)
            return "0b" + digitToChar(base);
        String number = "";
        while (num > 0) {
            number = digitToChar(num % base) + number;
            num /= base;
        }
        return number + 'b' + digitToChar(base);
    }

    private static char digitToChar(int digit) {
        if (10 <= digit && digit <= 16)
            return (char) ('A' + (digit - 10));
        return (char) ('0' + digit);
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here
        int a = number2Int(n1);
        int b = number2Int(n2);
        if (a!=b){
            return false;
        }

    ////////////////////
        return ans;
}

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        // add your code here
        int currentMaxIndex = 0;
        for (int i=0; i<arr.length; i++) {
            if (number2Int(arr[currentMaxIndex])<number2Int(arr[i])){
                currentMaxIndex = i;
            }
        }

        ///////////////////
        return currentMaxIndex;
    }

}