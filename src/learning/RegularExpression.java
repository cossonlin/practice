package learning;

public class RegularExpression {

    static String pattern = "^(?=.{6,16}$)[a-zA-Z][a-zA-Z\\d]*-?[A-Za-z\\d]+$";

    public static void main(String[] args) {
        String a = "Smith-Jaa1son";
        String b = "Smith-Ja-son";
        String c = "Smith Jason";
        String d = "Smith Jasonadadwadad";
        String e = "Smith-Jason12345";
        String f = "Smith Jaso1naadw";
        System.out.println(a.matches(pattern));
        System.out.println(b.matches(pattern));
        System.out.println(c.matches(pattern));
        System.out.println(d.matches(pattern));
        System.out.println(e.matches(pattern));
        System.out.println(f.matches(pattern));
    }
}
