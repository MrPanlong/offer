package offer1;

/**
 * @ClassName: ConstructArr
 * @Date: 2022/7/24 17:26
 * @Author: panLong
 * @Description: 剑指 Offer 66. 构建乘积数组
 */

public class ConstructArr {
    public int[] constructArr(int[] arr){
        int[] res = new int[arr.length];
        for (int i = 0,cur = 1; i < arr.length; i++) {
            res[i] = cur;
            cur *= arr[i];
        }
        for (int i = arr.length - 1,cur = 1 ;i >= 0; i--) {
            res[i] *= cur;
            cur *= arr[i];
        }
        return res;
    }

    public int[] constructArr2(int[] arr){
        if(arr == null || arr.length == 0) {
            return arr;
        }
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i -1] * arr[i -1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * arr[i + 1];
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = right[i] * left[i];
        }
        return ans;
    }
}
