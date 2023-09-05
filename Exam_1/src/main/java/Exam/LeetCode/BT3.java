package Exam.LeetCode;

import java.util.regex.Pattern;

// Cho một chuỗi, chuyển đổi tất cả chữ hoa thành chữ thường, loại bỏ số và ký tự khác, và phải đối xứng
public class BT3 {
    public static final String REGEX_LETTER = "^[a-zA-Z0-9]$";

    public static void main(String[] args) {
        String s = "1234567!!#@!%@ abcdefedcba";
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            if(checkIsLetterOrNumber(String.valueOf(s.charAt(i)))) {
                s2 += String.valueOf(s.charAt(i));
            }
        }
        s2 = s2.toLowerCase();
        System.out.println(checkPalindrome(s2));
    }

    public static boolean checkIsLetterOrNumber(String s){
        return Pattern.matches(REGEX_LETTER,s);
    }
    public static boolean checkPalindrome (String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }







}
