public class Chapter12Practice {

    public static void main (String arg[]){
        System.out.println(mystery6(7,1));
    }

    public static int mystery6(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else if (k > n) {
            return 0;
        } else {
            return mystery6(n - 1, k - 1) + mystery6(n - 1, k);
        }
    }

}
