import java.util.HashMap;

public final class Roman {
    public static boolean checkForCorrect(String str){
        str = str.toUpperCase();
        for (char x: str.toCharArray()){
            if (x != 'I' &&
                x != 'V' &&
                x != 'X' &&
                x != 'L' &&
                x != 'C' &&
                x != 'D' &&
                x != 'M')
                return false;
        }
        return true;
    }

    public static int parseFromString(String str){
        var sum = 0;
        var length = str.length();
        var chars = str.toCharArray();
        for (var i = 0; i < length; i++){
            var value = valueOf(chars[i]);
            if (i + 1 < length){
                var nextValue = valueOf(chars[i + 1]);
                if(nextValue > value){
                    sum -= value;
                }
                else{
                    sum += value;
                }
            }
            else{
                sum += value;
            }
        }
        return sum;
    }

    public static String parseToString(int num){
        if(num <= 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();
        while (num!=0) {
            if (num>=1000) {
                sb.append("M");
                num-=1000;
            }
            else if (num>=900) {
                sb.append("CM");
                num-=900;
            }
            else if (num>=500) {
                sb.append("D");
                num-=500;
            }
            else if (num>=400) {
                sb.append("CD");
                num-=400;
            }
            else if (num>=100) {
                sb.append("C");
                num-=100;
            }
            else if (num>=90) {
                sb.append("XC");
                num-=90;
            }
            else if (num>=50) {
                sb.append("L");
                num-=50;
            }
            else if (num>=40) {
                sb.append("XL");
                num-=40;
            }
            else if(num>=10) {
                sb.append("X");
                num-=10;
            }
            else if(num==9) {
                sb.append("IX");
                num-=9;
            }
            else if(num>=5){
                sb.append("V");
                num-=5;
            }
            else if(num==4) {
                sb.append("IV");
                num-=4;
            }
            else if(num>=1) {
                sb.append("I");
                num-=1;
            }
        }
        return sb.toString();
    }

    private static int valueOf(char c){
        if (c == 'I')
            return 1;
        if (c == 'V')
            return 5;
        if (c == 'X')
            return 10;
        if (c == 'L')
            return 50;
        if (c == 'C')
            return 100;
        if (c == 'D')
            return 500;
        if (c == 'M')
            return 1000;

        throw new IllegalArgumentException();
    }
}
