package day0708;

import java.util.Scanner;

public class QuantityValidation {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入商品數量（>0）：");
        int quantity = sc.nextInt();

        while (quantity <= 0 ) {
            System.out.print("數量不合格，請重新輸入（>0）：");
            quantity = sc.nextInt();
        }

        System.out.println("quantity of goods: " + quantity);

        sc.close();
    }
}
