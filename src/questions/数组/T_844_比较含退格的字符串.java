package questions.数组;



public class T_844_比较含退格的字符串 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("nzp#o#g", "b#nzp#o#g"));
    }
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int count1 = 0;
        int count2 = 0;
        while (true) {  // 这里是true而不是 i>=0 && j>=0,因为可能那个剩余的字串也是全部无效的
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    count1++;
                } else {
                    if (count1 > 0) {
                        count1--;
                    } else {
                        break;
                    }
                }
                i--;
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    count2++;
                } else {
                    if (count2 > 0) {
                        count2--;
                    } else {
                        break;
                    }
                }
                j--;
            }
            if (i < 0 || j < 0) {
                break;
            }
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return i < 0 && j < 0;
    }
}
