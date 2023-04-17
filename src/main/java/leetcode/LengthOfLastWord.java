package leetcode;

/**
 * @author: Egor Bekhterev
 * @date: 17.04.2023
 * @project: test_cases_offers
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        var arr = s.trim().split(" ");
        return  arr[arr.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Today is a nice day"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}
