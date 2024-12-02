package gfg.problemoftheday;

public class ImplementAtoi {
    public static void main(String[] args) {

        String string = "         12345gbhvfrhb";
        int result = myAtoi(string);
        System.out.println("Result: " + result);
    }

    private static int myAtoi(String s) {

        boolean flag = false;
        boolean negativeNumber = false;
        long result = 0;
        for(int i=0;i<s.length();i++){
            if(!flag && s.charAt(i)==45){
                negativeNumber = true;
                continue;
            }
            if(!flag && (s.charAt(i)==48 || s.charAt(i)==32)){
                continue;
            }
            if(s.charAt(i)>=48 && s.charAt(i)<=57){
                int digit = s.charAt(i)-'0';
                result = result*10 + digit;
                flag = true;
            }
           else {
               break;
            }
        }
        if (negativeNumber) {
            result = -result;
        }
        if (result > 2147483647) {
            result = 2147483647;
        }
        if (result < -2147483648) {
            result = -2147483648;
        }
        return (int) result;
    }
}
