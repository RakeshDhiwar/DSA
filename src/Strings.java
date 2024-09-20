import java.util.Scanner;

public class Strings {
    //Palindrome Check O(n)
    public static void Palindrome (String str) {
        int length = str.length()-1;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(length-i)){
                System.out.println("Not a Palindrome");
                return;
            }
        }
        System.out.println("Palindrome");
    }

    // Shortest Path to reach destination
    public static void Shortestpath (String str) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'E') x++;
            else if (str.charAt(i) == 'W') x--;
            else if (str.charAt(i) == 'N') y++;
            else if (str.charAt(i) == 'S') y--;
        }

        System.out.println("Shortest path : "+Math.sqrt((x*x)+(y*y)));
    }

    //To convert all first char to string in a sentence to capital form.
    public static String toupperCase (String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    //Compress string ( "aaaabbbccdddd" --> "a4b3c2d4")
    public static  String compreesString (String str) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
               count++;
               i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(Integer.toString(count));
            }

        }
        return sb.toString();
    }

    // How many lowercase Characters
    public static String countlower (String str) {
        Integer count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) count++;
        }
        return count.toString();
    }



    public static void main(String[] args) {
//        char arr[] = {'a','b','c','d'};
//        String str = "abcd";
//        String str2 = new String("XYZ");

//         STRINGS ARE IMMUTABLE

//         Input
//        Scanner sc  = new Scanner(System.in);
//        String name = sc.next();
//        String Sentence = sc.nextLine();

//        Length as a function
//        int length = str2.length();




//        String Str = "racecarrake";
//        Palindrome(Str);

//        String Str = "WNEENESENNN";
//        Shortestpath(Str);


//        String pool concept
//        String str1 = "Rk";
//        String str2 = "Rk";
//        String str3 = new String("Rk");
//
//        if (str1 == str2) System.out.println("s1 == s2");
//        if (str1 != str2) System.out.println("s1 != s2");
//        if (str1 == str3) System.out.println("s1 == s3");
//        if (str1 != str3) System.out.println("s1 != s3");
//
//        if (str1.equals(str3)) System.out.println("s1==s3");

//        String str = "Helloworld";
//        System.out.println(str.substring(0,5));
//        System.out.println(str.subSequence(0,5));

//        String fruits[] = {"apple","mango","banana"};
//        String largest = fruits[0];
//        for (int i = 1; i < fruits.length; i++) {
//            if(largest.compareTo(fruits[i]) < 0){
//                largest = fruits[i];
//            }
//        }
//        System.out.println(largest);

//        StringBuilder sb = new StringBuilder("");
//        for (char ch = 'a'; ch<='z'; ch++) {
//            sb.append(ch);
//        }
//        System.out.println(sb);
//        System.out.println(sb.length());
//        .toString() -- to convert to String
//        Character class is used then we can convert it into the string using tostring method

//        String str = "hello! its dhiwar";
//        System.out.println(toupperCase(str));

//        String str = "aaaabbbccdddd";
//        System.out.println(compreesString(str));

        String str = "Hello Dear";
        System.out.println(countlower(str));
    }
}
