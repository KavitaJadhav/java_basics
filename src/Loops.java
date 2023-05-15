import java.util.Arrays;

public class Loops {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        String[] chars = {"a", "b", "c", "d"};
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        System.out.println(Arrays.toString(chars));
    }
}
