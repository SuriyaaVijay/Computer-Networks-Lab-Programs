import java.util.Scanner;
public class CheckSum {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter message 1 : ");
        String s;
        s = in.nextLine();
        System.out.print("Enter message 2 : ");
        String r;
        r = in.nextLine();
        byte[] arr1 = s.getBytes();
        byte[] arr2 = r.getBytes();
        int q1 = 0 , q2 = 0;
        String w1="",w2="";
        for(int i = 0 ; i < arr1.length ; i++){
            q1 += arr1[i];
            w1 += Integer.toBinaryString(arr1[i]);
            q2 += arr2[i];
            w2 += Integer.toBinaryString(arr2[i]);
        }
        System.out.println("Binary of Input String a : "+w1);
        System.out.println("Check Sum of "+s+" : "+ Integer.toBinaryString(q1));
        System.out.println();
        System.out.println();
        System.out.println("Binary of Input String b : "+w2);
        System.out.println("Check Sum of "+r+" : "+ Integer.toBinaryString(q2));
        if((q1 == q2) && q1 != 0 && q2 != 0) {
            System.out.println("\nCheck Sum matching!! No Error");
        }
        else{
            System.out.println("\nCheck Sum not matching!! Error found");
        }
    }
}
