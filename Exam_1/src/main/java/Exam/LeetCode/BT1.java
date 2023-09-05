package Exam.LeetCode;

// Cho mảng số nguyên nums, trả về true nếu trong mảng có phần tử lặp lại, trả về false nếu tất cả các phần tử đều khác nhau
public class BT1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(containsDuplicate(nums));
    }


    public static boolean containsDuplicate(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
