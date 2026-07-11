package day0708;

public class PassCounter {
    public static void main(String[] args) {
        int score1 = 80;
        int score2 = 55;
        int score3 = 70;
        
        int passcount = 0;

        if(score1 >=60){
            passcount++;
        }

        if(score2 >=60){
            passcount++;
        }

        if(score3 >=60){
            passcount++;
        }
        System.out.println("Pass Count: " + passcount);
    }
}
