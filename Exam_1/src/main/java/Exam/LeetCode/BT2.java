package Exam.LeetCode;

// Cho [x,y] biểu thị tọa độ của một điểm, kiểm tra các điểm này có thẳng hàng trong mặt phẳng x,y hay không
public class BT2 {
    public static void main(String[] args) {
        int[][] number1 = {{1, 1}, {2, 2}, {3, 3}};
        int[][] number2 = {{1, 2}, {2, 3}, {3, 4}};
        int[][] number3 = {{1, 2}, {2, 2}, {3, 3}};
        System.out.println(checkStraightLine(number1));
        System.out.println(checkStraightLine(number2));
        System.out.println(checkStraightLine(number3));
    }

    public static boolean checkStraightLine(int[][] array) {
        int x0 = array[0][0];
        int y0 = array[0][1];
        int x1 = array[1][0];
        int y1 = array[1][1];
        for (int i = 2; i < array.length; i++) {
            int x = array[i][0];
            int y = array[i][1];
            if ((x - x0) * (y1 - y0) != (y - y0) * (x1 - x0)) {
                return false;
            }
        }
        return true;
    }
}
