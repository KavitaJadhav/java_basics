import java.util.Arrays;

public class ArrayReference {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] nums_cpy1 = nums;
        int[] nums_cpy2 = Arrays.copyOf(nums, nums.length);
        int[][] nestedNums = {{1, 2, 3, 4}, {5, 6, 7, 8}};

        nums[0] = 100;

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums_cpy1));
        System.out.println(Arrays.toString(nums_cpy2));
        System.out.println(Arrays.deepToString(nestedNums));
    }
}
