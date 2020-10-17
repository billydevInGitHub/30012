package billydev.exp045.list.longest.substring;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        String inputString = "abcdaop";
//        String inputString = "abcd";

        System.out.println("Longest substring with my origianl method is: "+longestSubStringMethod1MyOriginalMethod(inputString));
        System.out.println("Longest substring with my second try method (from hint) is: "+longestSubStringMethod2MyOriginalMethod(inputString));
    }

    private static int longestSubStringMethod2MyOriginalMethod(String inputString) {
        if (inputString == null||inputString.length()==0) {
            throw new RuntimeException("Input string is null or zero length");
        }

        Map<Character, Integer> charPositionMap= new HashMap<>();
        int i=0;
        int j=0;
        int longestSubStringLength=0;
        Character   currentChar=null; //??? need check if declaration need to be put outside the loop
        while (i < inputString.length()) {
            i++;
            currentChar = inputString.substring(i - 1, i).charAt(0);

            Integer position = charPositionMap.get(currentChar);
            longestSubStringLength=  longestSubStringLength < i - j?i-j:longestSubStringLength;
            if (position != null) {
                //need move j
                j= position;
            }
            charPositionMap.put(currentChar,i);
        }

        return longestSubStringLength;
    }

    private static String longestSubStringMethod1MyOriginalMethod(String inputString) {
        int maxLength=0;
        String longest="";
        for (int i = 1; i <=inputString.length(); i++) {
            for (int j = 0; j <i; j++) {
                char[] array = inputString.substring(j, i).toCharArray();
                System.out.println("array = " + String.valueOf(array));
                if(hasNoRepeat(array)){
                    if (array.length > maxLength) {
                        maxLength=array.length;
                        longest = new String(array);
                    }
                }
            }
        }
        return longest;
    }

    private static boolean hasNoRepeat(char[] array) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : array) {
            if(characterSet.contains(c)){
                return false;
            }else{
                characterSet.add(c);
            }
        }
        return true;
    }
}
