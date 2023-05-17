package checks;
import java.util.concurrent.atomic.AtomicInteger;
public class Checks {

    public static AtomicInteger count3 = new AtomicInteger();
    public static  AtomicInteger count4 = new AtomicInteger();
    public static AtomicInteger count5 = new AtomicInteger();
    public static boolean isPalindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }
    public static boolean isOneLetterWord(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1))
                return false;
        }
        return true;
    }
    public static boolean isAscendingOrder(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1))
                return false;
        }
        return true;
    }
     public static void countNum(int length){
        if(length == 3) {
            count3.getAndIncrement();
        } else if (length == 4) {
            count4.getAndIncrement();
        } else {
            count5.getAndIncrement();
        }
    }
}
