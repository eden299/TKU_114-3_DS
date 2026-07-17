package day0715;

import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = inputText(sc);

        System.out.println("原始字元數：" + getOriginalLength(text));

        String trimmed = text.trim();
        System.out.println("有效字元數：" + getTrimmedLength(trimmed));

        String[] words = splitWords(trimmed);
        System.out.println("單字數量：" + words.length);

        System.out.println("英文母音總數：" + countVowels(trimmed));

        System.out.println("最長單字：" + findLongestWord(words));

        System.out.print("請輸入關鍵字：");
        String keyword = sc.nextLine();

        int count = countKeyword(words, keyword);
        System.out.println("關鍵字出現次數：" + count);

        sc.close();
    }

    public static String inputText(Scanner sc) {
        String text;

        while (true) {
            System.out.print("請輸入一行文字：");
            text = sc.nextLine();

            if (!text.trim().isEmpty()) {
                return text;
            }

            System.out.println("不可輸入空字串，請重新輸入！");
        }
    }

    public static int getOriginalLength(String text) {
        return text.length();
    }

    public static int getTrimmedLength(String text) {
        return text.length();
    }

    public static String[] splitWords(String text) {
        return text.split("\\s+");
    }

    public static int countVowels(String text) {
        int count = 0;
        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i'
                    || c == 'o' || c == 'u') {
                count++;
            }
        }

        return count;
    }

    public static String findLongestWord(String[] words) {
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest;
    }

    public static int countKeyword(String[] words, String keyword) {
        int count = 0;

        for (String word : words) {
            if (word.equalsIgnoreCase(keyword)) {
                count++;
            }
        }

        return count;
    }
}
