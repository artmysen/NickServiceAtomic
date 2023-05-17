import static checks.Checks.*;

import java.util.Random;

public class Main {

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Thread palindrome = new Thread(() -> {         //Поток проверки на палиндром за исключением однобуквенных ников
            for (String text : texts) {
                if (isPalindrome(text) && !isOneLetterWord(text)) {
                    countNum(text.length());
                }
            }
        });
        palindrome.start();

        Thread oneLetterWord = new Thread(() -> {    //Поток проверки на однобуквенный ник
            for (String text : texts) {
                if (isOneLetterWord(text)) {
                    countNum(text.length());
                }
            }
        });
        oneLetterWord.start();

        Thread ascendingOrder = new Thread(() -> {   //Поток проверки на порядок букв по алфавиту за искл однобуквенных ников
            for (String text : texts) {
                if (!isOneLetterWord(text) && isAscendingOrder(text)) {
                    countNum(text.length());
                }
            }
        });
        ascendingOrder.start();

        palindrome.join();
        oneLetterWord.join();
        ascendingOrder.join();

        System.out.println("Красивых слов с длиной 3: " + count3 + " шт." );
        System.out.println("Красивых слов с длиной 4: " + count4 + " шт." );
        System.out.println("Красивых слов с длиной 5: " + count5 + " шт." );
    }
}