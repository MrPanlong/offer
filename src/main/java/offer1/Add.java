package offer1;

/**
 * @ClassName: Add
 * @Date: 2022/7/24 17:34
 * @Author: panLong
 * @Description: TODO
 */

public class Add {
    public int add(int a, int b) {
        //当进位为0时跳出
        while (b != 0) {
            //c = 进位
            int c = (a & b) << 1;
            //a = 非进位和
            a = b;
            //b = 进位
            b = c;
        }
        return a;
    }
}
