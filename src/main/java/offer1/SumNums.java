package offer1;

/**
 * @ClassName: SumNums
 * @Date: 2022/7/24 20:30
 * @Author: panLong
 * @Description: TODO
 */

public class SumNums {
    public int sumNums(int n){
        if(n == 1) {
            return 1;
        }
        return n + sumNums(n - 1);
    }
}
