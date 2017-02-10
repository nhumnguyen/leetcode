import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] nums = new int[8];
        nums[0] = 2;
        nums[1] = 3;
        nums[2] = 3;
        nums[3] = 3;
        nums[4] = 1;
        nums[5] = 3;
        nums[6] = 0;
        nums[7] = 1;
        System.out.println("ans = " + majorityElement(nums));

        for (int i = 0; i < nums.length; i++) {
        System.out.println(nums[i]);}

    }

    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }


//    public String reverseString344(String s) { //.....//this method works but exceed time limit
//        int length = s.length();               //  ....//because String is immutable
                                               // .....So when we modify by string += will create a new String (with all char of old string)
//        int stop;                               // ...//which take a lot more time to run! :(
//        String string1 = "";
//        String string2 = "";
//
//        if (s.length() % 2 == 1) {
//            stop = s.length()/2 + 1; //length is odd
//            for (int i = 0; i < stop - 1; i++) {
//                string2 =  s.charAt(i) + string2;
//                string1 = string1 + s.charAt(length - (i + 1));
//            }
//            string1 = string1 + s.charAt(length/2);
//
//        } else {
//            stop = s.length()/2; //length is even
//            for (int i = 0; i < stop; i++) {
//                string2 =  s.charAt(i) + string2;
//                string1 = string1 + s.charAt(length - (i + 1));
//            }
//        }
//        return string1 + string2;
//    }




    public int findPeakElement162 (int[] nums) { //ACCEPTED
        //this is o(n), the optimal sol is o(logn), see on website
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1 || nums[0] > nums[1]) { //first element only check on rihgt
            return 0;
        }  else if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }  else if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return -1;

    }




     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x; }
     }


//    public ListNode addTwoNumbers445(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        ListNode ans = new ListNode(0);
//
//        ListNode l3 = new ListNode(0);
//        ListNode l4 = new ListNode(0);
//
//        addTwoNumHelper(l1, l3); //flip l1 and l2
//        addTwoNumHelper(l2, l4);
//
//        ListNode curr1 = l3.next;
//        ListNode curr2 = l4.next;
//
//        ListNode newNode = new ListNode(l3.val + l4.val);
//
//        if (newNode.val > 9) {
//            ans.next = new ListNode(newNode.val % 10);
//            ans.val = newNode.val % 10 % 10;
//            newNode = ans;
//        }
//
//
//        while (curr1 != null && curr2 != null) {
//            if (curr1 == null) {
//                ans.next = curr2;
//                curr2 = curr2.next;
//            } else if (curr2 == null) {
//                ans.next = curr1;
//                curr1 = curr1.next;
//            } else {
//                ListNode neww = new ListNode(0);
//                newNode.val = curr1.val + curr2.val;
//                if (neww.val > 9) {
//                    newNode.next = new ListNode(neww.val % 10);
//                    neww.val = neww.val % 10 % 10;
//                    newNode = neww.next;
//                    curr2 = curr2.next;
//                    curr1 = curr1.next;
//                }
//            }
//
//
//        }
//
//    }


    public static void addTwoNumHelper(ListNode list, ListNode ans) {
        if (list.next == null) {
            ans.val = list.val;
        } else {
            list = list.next;
            addTwoNumHelper(list, ans);
            ans.next = list;
        }

    }


    public static int[] twoSum1(int[] nums, int target) { //accepted
        int[] result = new int[2];
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(myMap.containsKey(target - nums[i])) {
                result[0] = myMap.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            myMap.put(nums[i], i);
        }
        return result;

    }


    public static int reverseBits190(int n) { //accepted
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result = result + (n & 1);
            n >>= 1;
        }
        return result;

    }



    public static boolean isHappy(int n) { //accepted
        Map<Integer, Integer> myMap = new HashMap<>();
        while (!myMap.containsKey(n)) {
            myMap.put(n, 0);
            int m = n;
            n = 0;
            while (m != 0) {
                n = n + (int) Math.pow(m % 10, 2);
                m = m / 10;
            }

            if (n == 1) {
                return true;
            }

        }
        return false;

    }


    public static ListNode deleteDuplicates(ListNode head) { //ACCEPTED
        if (head == null) return null;
        ListNode a = head;
        while (a != null) {
            if (a.next == null) return head;
            if (a.next.val == a.val) {
                a.next = a.next.next;
            } else {
                a = a.next;
            }
        }
            return head;


        //OR
//        if (head == null) return null;
//        ListNode a = head;
//        while (a != null && a.next != null) {
//            if (a.next.val == a.val) {
//                a.next = a.next.next;
//            } else {
//                a = a.next;
//            }
//        }
//        return head;
    }

    public static int arrangeCoins(int n) {
        int i = 1;
        while (i*(i + 1) / 2 <= n) {
            i++;
        }
        if (n - (i*(i + 1) / 2) == 0 ) {
            return i ;
        } else {
            return i - 1;
        }
    }


    public static int hammingDistance(int x, int y) { //accepted
        int mask = 1;
        int count = 0;
        for (int i = 0; i <= 32; i++) {
            int checkX = x & mask;
            int checkY = y & mask;
            x >>= 1;
            y >>=1;
            if (checkX != checkY) {
                count++;
            }
        }
        return count;


    }

    public static int totalHammingDistance(int[] nums) {
        int tot = 0;
        for (int i = 0; i < nums.length; i++) { //index of first num to compare
            for (int j = i + 1; j < nums.length; j++) {
                tot = tot + hammingDistance(nums[i], nums[j]);
            }
        }
        return tot;

    }


    public static int reverse7(int x) { //accepted
        boolean neg = false; //no need to check for negative bc mod of negative num is a neg
        if (x < 0) {
            neg = true;
            x = x * -1;
        }
        int ans = 0;
        while (x > 0) {
            int check = ans * 10 + (x % 10);

            //check for overflow: when ans is overflowed
            if ((check - (x % 10)) / 10 != ans) {
                return 0;
            }

            ans = check;
            x = x / 10;
        }
        return neg ? (ans * -1) : ans;
    }

    public static void moveZeroes(int[] nums) { //accepted
        int zeros = 0;
        int j = 0;
        int i = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int val = nums[j];
                nums[j] = 0;
                nums[i] = val;
                i++;
            }
            j++;
        }
    }



    public static boolean containsDuplicate217(int[] nums) {//accepted
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!myMap.containsKey(nums[i])) {
                myMap.put(nums[i], 0);
            } else {
                return true;
            }
        }
        return false;

    }


    public boolean containsNearbyDuplicate219(int[] nums, int k) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!myMap.containsKey(nums[i])) {
                myMap.put(nums[i], i);
            } else {
                if (i - myMap.get(nums[i]) <= k) {
                    return true;
                }
                myMap.put(nums[i], i);
            }
        }
        return false;

    }



    public boolean isValid20 (String s) {
        Stack<Character> openBrackets = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == '(' || x == '{' || x == '[') {
                openBrackets.push(x);
            } else if (openBrackets.isEmpty() ||
                    (x == ')' && openBrackets.pop() != '(') ||
                    (x == '}' && openBrackets.pop() !='{') ||
                    (x == ']' && openBrackets.pop() != '[')){
                return false;
            }
        }

        return openBrackets.isEmpty();

    }



//    public static boolean canWinNim292(int n) {
//        Map<Integer, Boolean> sim = new HashMap<>();
//        return helperCanwin (sim, n);
//
//    }

//    private Boolean helperCanwin(Map<Integer, Boolean> sim, int n) {
//        if (sim.containsKey(n)) {
//            return sim.get(n);
//        }
//
//        if (n == 1 || n ==2 || n == 3) {
//            sim.put(n, true);
//            return true;
//        }
//
//        Boolean nhu = helperCanwin(sim, n - 1) || helperCanwin(sim, n-2) || helperCanwin(sim, n-3);
//        sim.put(n, nhu);
//        return nhu;
//    }


//...................................................................


    private  int helperAddDigits(int ans, int num) {
        if (num < 10) {
            return num;
        }
        ans = 0;

        while (num != 0) {
            ans = ans + (num % 10);
            num = num / 10;
        }
        return helperAddDigits(ans, ans);
    }
//...................................................................


    public String reverseVowels345(String s) { //accepted
        char[] string = s.toCharArray();
        int i = 0;
        int j = string.length - 1;
        char x = ' ';
        char y = ' ';
        Boolean xChanged = false;
        Boolean yChanged = false;
        while (i <= j) {
            if (string[i] == 'a' || string[i] == 'e' || string[i] == 'i' || string[i] == 'o' || string[i] == 'u'
                    || string[i] == 'a' - 32 || string[i] == 'e' - 32 || string[i] == 'i' - 32
                    || string[i] == 'o' - 32 || string[i] == 'u' - 32) {
                 x = string[i];
                xChanged = true;
            } else {
                i++;
            }


            if (string[j] == 'a' || string[j] == 'e' || string[j] == 'i' || string[j] == 'o' || string[j] == 'u'
                    || string[j] == 'a' - 32 || string[j] == 'e' - 32 || string[j] == 'i' - 32
                    || string[j] == 'o' - 32 || string[j] == 'u' - 32) {
                y = string[j];
                yChanged = true;
            } else {
                j--;
            }


            if (xChanged && yChanged) {
                string[i] = y;
                string[j] = x;
                xChanged = false;
                yChanged = false;
                i++;
                j--;
            }
        }

        return new String(string);

    }


    public int majorityElement169(int[] nums) { //accepted

        Map<Integer, Integer> myMap = new HashMap<>();
        int ans = nums[0];
        int max = 0;
        int val = 1;
        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(nums[i])) {
                val = myMap.get(nums[i]) + 1;
                myMap.put(nums[i], myMap.get(nums[i]) + 1);
            } else {
                myMap.put(nums[i], 1);
                val = 1;
            }

            if (val > max) {
                ans = nums[i];
                max = val;
            }
        }
        return ans;
    }


    public static int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            System.out.println("i = " + i);
            System.out.println("major = " + major);
            System.out.println("count = " + count);
            System.out.println("-----------------------------");

        }
        return major;
    }



    public static int minMoves(int[] nums) { //accepted
        if (nums.length == 1) return 0;
        Arrays.sort(nums);

        int count = nums[nums.length - 1] - nums[0];
        for(int i = nums.length - 1; i > 1; i--) {
            nums[i - 1] = nums[i - 1] + count;
            count = count + nums[i - 1] - nums[i];
        }
        return count;
    }



    public int lengthOfLastWord58(String s) {
        if (s.isEmpty()) return 0;
            char[] x = s.toCharArray();
        int i = s.length() - 1;
        if (x[i] == ' ') i--;
        int count = 0;
        while (i >= 0 && x[i] != ' '  ) {
            count++;
            i--;
        }
        return count;
    }


    public static List<Integer> findDisappearedNumbers448(int[] nums) { //accepted
        Map<Integer, Integer> mySet = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            mySet.put(nums[i], 0);
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!mySet.containsKey(i)) {
                ans.add(i);
            }
        }
        return ans;

    }



    public static String addStrings(String num1, String num2) {
        Map<Character, Integer> myMap = new HashMap<>();
        char start = '0';
        for (int i = 0; i < 10; i++) {
            myMap.put(start, i);
            start++;
        }

        long sum1 = 0;
        int j = 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            sum1 += myMap.get(num1.charAt(i)) * j;
            j *= 10;
        }
        System.out.println(sum1);

        j = 1;
        long sum2 = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            sum2 += myMap.get(num2.charAt(i)) * j;
            j *= 10;
        }
        System.out.println(sum2);
        long ans = sum1 + sum2;
        return Long.toString(ans);

    }



    public static int findRadius475 (int[] houses, int[] heaters) { //accepted
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0; //house index
        int j = 0; //heaters index
        int maxDiff = 0;
        while (i < houses.length) {
            while ( j + 1 < heaters.length && Math.abs(heaters[j] - houses[i]) >= Math.abs(heaters[j + 1] - houses[i])) {
                j++;
                //System.out.println("j = " + j);

            }
            int currDiff = Math.abs(heaters[j] - houses[i]);
            maxDiff = Math.max(maxDiff, currDiff);
//            System.out.println(maxDiff);

            if (j == heaters.length - 1) {
                return Math.max(maxDiff, Math.abs(heaters[j] - houses[houses.length-1]));
            }
            i++;
        }
        return maxDiff;
    }


    public static List<Integer> findDuplicates442(int[] nums) {
        if (nums == null || nums.length == 1) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int curr = nums[0];
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == curr) {
                list.add(nums[i]);
            } else {
                curr = nums[i];
            }
        }
        return list;
    }



//    public static List<List<Integer>> threeSum15(int[] nums) {
//        List<List<Integer>> myList = new ArrayList<>();
//        Map<Integer, Map<Integer,Boolean>> map = new HashMap<Integer, Map<Integer,Boolean>>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if(!map.containsKey(nums[i])) {
//                Map<Integer,Boolean> a = new HashMap<>();
//                a.put(i, true);
//                map.put(nums[i], a);
//            } else {
//                Map<Integer,Boolean> a = map.get(nums[i]);
//                a.put(i, true);
//                map.put(nums[i], a);
//            }
//        }
//
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                int target = (nums[i] + nums[j]) * -1;
//                if(map.containsKey(target)) {
//                    Map<Integer,Boolean> b = map.get(target);
//                    if(map.get(target) == true && b.get(j) == true) {
//                        List<Integer> list = Arrays.asList(nums[i], nums[j], target);
//                        myList.add(list);
//                        b.put(i, false);
//                        b.put(j, false);
//                    }
//
//                }
//            }
//        }
//        return myList;
//
//    }

}

