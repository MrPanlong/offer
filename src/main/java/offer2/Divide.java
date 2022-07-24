package offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Divide
 * @Date: 2022/7/24 16:32
 * @Author: panLong
 * @Description: 剑指 Offer II 001. 整数除法
 */

public class Divide {

    public static int divide(int a, int b) {
        //考虑被除数为最小值的情况
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
        }
        //考虑除数最小数的情况
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        //考虑被除数为0的情况
        if (a == 0) {
            return 0;
        }
        //一般情况 适用二分查找
        //将所有的正数取相反数 这样就只需要考虑一种情况
        boolean rev = false;
        if (a > 0) {
            a = -a;
            rev = !rev;
        }
        if (b > 0) {
            b = -b;
            rev = !rev;
        }
        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            //注意溢出 并且不能使用除法
            int mid = left + (right - left) / 2;
            boolean check = quickAdd(b, mid, a);
            if (check) {
                //注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return rev ? -ans : ans;
    }

    private static boolean quickAdd(int y, int z, int x) {
        //x 和 y 是负数 z 是正数
        //需要判断z * y >= x是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                //需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                //需要保证 add + ad >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            //不能使用除法
            z >>= 1;
        }
        return true;
    }

    public int divide2(int a, int b) {
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        if (a == 0) {
            return 0;
        }
        boolean rev = false;
        if (a > 0) {
            a = -a;
            rev = !rev;
        }
        if (b > 0) {
            b = -b;
            rev = !rev;
        }
        List<Integer> candidates = new ArrayList<>();
        candidates.add(b);
        int index = 0;
        while (candidates.get(index) >= a - candidates.get(index)) {
            candidates.add(candidates.get(index) + candidates.get(index));
            ++index;
        }
        int ans = 0;
        for (int i = candidates.size() - 1; i >= 0; i--) {
            if (candidates.get(i) >= a) {
                ans += 1 << i;
                a -= candidates.get(i);
            }
        }
        return rev ? -ans : ans;
    }
}
