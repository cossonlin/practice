package learning;

public class TryFinally {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static String test() {
        String i = "0";
        try {
            i = "10";
            return i;
        } finally {
            i = "12";
            System.out.println("finally trumps return.");
            return i;
        }
    }
}
