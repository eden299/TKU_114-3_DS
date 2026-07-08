package day0707;
import java.util.Scanner;
public class WhileInputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("請輸入整數:");
        int num = sc.nextInt();

        while (num != 0) {
            System.out.println("輸入了:" + num);

            System.out.println("請在輸入一個整數:");
            num = sc.nextInt();
            
        }
        System.out.println("輸入為0 程式結束");

        sc.close();
    }
}
