import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

//    public static int lengthOfLongestSubsetWithZeroSum(int[] arr) {
//        // Write your code here
//
//    }
    public static int getPairsWithDifferenceK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
                continue;
            }
            map.put(x, 1);
        }
        int result = 0;
        for (int x : map.keySet()) {
            int comp = x - k;
            if (k != 0 && map.containsKey(comp)) {
                result = result + map.get(x) * map.get(comp);

            } else {
                result = result + (map.get(x) * (map.get(x) - 1)) / 2;
            }
        }
        return result;
    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        Map<Integer, Boolean> flag = new LinkedHashMap<>();
        for (int x : arr) {
            flag.put(x, true);
        }
        ArrayList<Integer> result = new ArrayList<>();
        int length = 1;
        for (Integer x : arr) {
            if (flag.get(x)) {
//                check upwards
                int i = x;
                int count = 1;
                while (flag.containsKey(++i)) {
                    count++;

                }

                if (count > length) {
                    length = count;
                    result = new ArrayList<>();
                    result.add(x);
                    result.add(i - 1);
                }
            }
        }
        return result;
    }

    public static String uniqueChar(String str) {

        StringBuilder newStr = new StringBuilder();
        Map<Character, Boolean> strMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (strMap.containsKey(c)) {
                continue;
            }
            strMap.put(c, true);
            newStr.append(c);
        }
        return newStr.toString();
    }

    public static void printIntersection(int[] arr1, int[] arr2) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int x : arr1) {
            if (frequency.containsKey(x)) {
                frequency.put(x, frequency.get(x) + 1);
                continue;
            }
            frequency.put(x, 1);
        }

        for (int x : arr2) {
            if (frequency.containsKey(x)) {
                int count = frequency.get(x);
                if (count > 0) {
                    System.out.println(x);
                    frequency.put(x, count - 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }
}