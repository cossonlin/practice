package algorithm;

public class PowerOfN {
    static boolean powerOfN(int test, int n){
        if (test==0 || test%n!=0)
            return false;
        if (test==1)
            return true;
        return powerOfN(test/n, n);
    }
    public static void main(String[] args) {
        boolean a = powerOfN(1000000000,1);
        System.out.print(a);
    }
}
