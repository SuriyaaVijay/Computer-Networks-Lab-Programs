public class CRC {
    public static String xor(char q1 , char q2){
        if(q1 == q2) return "0";
        else return "1";
    }
    public static String bin(String divident , String divisor , int flag){
        if(flag == 1) {
            for (int j = 0; j < divisor.length(); j++) {
                divident += 0;
            }
        }
        String res = "";
        String ans = "";
        for(int i = 0 ; i < divisor.length() ; i++) {
            res += divident.charAt(i);
        }
        int i = 0;
        for(int j = divisor.length() ; j < divident.length() ; ) {
            if(res.charAt(i) == '0') {
                while(j < divident.length() && i < res.length() && res.charAt(i) == '0') {
                    i++;
                    res += divident.charAt(j);
                    j++;
                }
            }
            if(j >= divident.length()) break;
            for(int w = 0 ; w < divisor.length() ; w++) {
                ans += xor(res.charAt(i) , divisor.charAt(w));
                i++;
            }
            res = ans;
            ans = "";
            i = 0;
        }
        String real_ans = "";
        for(i = res.length()-divisor.length() ; i < res.length() ; i++){
            real_ans += res.charAt(i);
        }
        return real_ans;
    }
    public static void main(String[] args){
        String s = "1010101010";
        String d = "11001";
        System.out.println("Data : "+s);
        System.out.println("Key : "+d);
        System.out.println("Remainder : " + bin(s,d,1));s += bin(s,d,1);
        System.out.println("\nNew Data after appending : " + s);
        System.out.println("Again doing XOR division!\n");
        System.out.println("Remainder : " + bin(s,d,0));
    }
}