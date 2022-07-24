package offer1;

/**
 * @ClassName: StrToInt
 * @Date: 2022/7/24 17:19
 * @Author: panLong
 * @Description: 剑指 Offer 67. 把字符串转换成整数
 */

public class StrToInt {
    public int strToInt(String str){
        char[] ch = str.trim().toCharArray();
        if(ch.length == 0) {
            return 0;
        }
        int res = 0,bndry = Integer.MAX_VALUE / 10;
        int i = 1,sigh = 1;
        if(ch[0] == '-'){
            sigh = -1;
        }else if(ch[0] != '+'){
            i=0;
        }
        for (int j = i; j < ch.length; j++) {
            if(ch[j] < '0' || ch[j] > '9'){
                break;
            }
            if(res > bndry || res == bndry && ch[j] >'7'){
                return sigh == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (ch[j] - '0');
        }
        return sigh * res;
    }
}
