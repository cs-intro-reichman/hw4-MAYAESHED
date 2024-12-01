/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
        char ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (index == i) {
                ans = arr[i];
            }
        }
        return ans;
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) { // if the length is different the arrs are not equal
           return false; 
        }
        int i = 0;
        // the loop continues as long as the chars are alike
        while (i < arr1.length) { 
            if (charAt(arr1, i) == charAt(arr2, i)) {
                i ++;
            }
            else {
                return false;
            }
        }
        return true;
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        for (int index = 0; index < arr.length; index++) {
            if (charAt(arr, index) == ch) {
                return index;
            }
        }
        return -1;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for (int currentIndex = fromIndex; currentIndex < arr.length; currentIndex++) {
            if (charAt(arr, currentIndex) == ch) {
                return currentIndex;
            }
        } 
        return -1;
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        for (int lastIndex = (arr.length - 1); lastIndex >= 0; lastIndex --) {
            if (charAt(arr, lastIndex) == ch) {
                return lastIndex;
            }
        }
        return -1;
    }

    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
        int N = arr1.length + arr2.length;
        char [] concatedArray = new char [N];
        int j = arr1.length;
        for (int i = 0; i < arr1.length; i++) { 
            concatedArray[i] = arr1[i];
        }
        for (int i = 0; j < N; i++) {
            concatedArray[j] = arr2[i];
            j++;
        }
        return concatedArray;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        int N = endIndex - beginIndex;
        char[] sub = new char[N];
        int j = beginIndex;
        for (int i = 0; i < N ; i++) {
            sub[i] =arr [j];
            j++;
        }
        return sub;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        int N = arr.length - 1;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
           long hashCalc = (long) (arr[i] * Math.pow(7, N));
           sum += hashCalc;
           N --; 
        }
        return sum;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return -2; 
        }
        int minstringIndex = Math.min(str1.length(), str2.length());
        //compares each char
        for (int i = 0; i < minstringIndex; i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                return -1;
            } else if (str1.charAt(i) > str2.charAt(i)) {
                return 1;
            } 
        }
        if (str1.length() < str2.length()) {
            return -1;
        } else if (str1.length() > str2.length()) {
            return 1;
        }
        return 0;
    }
}
       


