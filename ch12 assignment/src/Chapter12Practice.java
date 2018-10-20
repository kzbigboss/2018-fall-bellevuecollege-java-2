public class Chapter12Practice {

    public static void main(String arg[]) {
        //System.out.println(mystery6(4,3));
        //writeNums(5);
//        writeSquares(3);
//       System.out.println(multiplyEvens(3));
        //System.out.println(sumTo(3));
        System.out.print(quiz12(8));
    }

    public static int quiz12(int num){
        if (num >= 10){
            return 10;
        } else {
            return num * quiz12(num + 1);
        }
    }

    public static double sumTo(int n){
        if (n < 0){
            throw new IllegalArgumentException();
        }

        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            return ((double) 1 / n) + sumTo(n-1);
        }
    }

    public static int multiplyEvens(int n ){
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        if (n == 1){
            return 2;
        } else {
            int blah = 2 * multiplyEvens(n-1) * n;
            return blah;
        }
    }

    public static void writeSquares(int n ){
        if (n < 1){
            throw new IllegalArgumentException();
        }

        if (n == 1){
            System.out.print("1");
        } else if (n % 2 == 0){
            writeSquares(n-1);
            System.out.print(", " +n * n);
        } else {
            System.out.print(n * n + ", ");
            writeSquares(n-1);
        }

    }

    public static int mystery6(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else if (k > n) {
            return 0;
        } else {
            int first = mystery6(n - 1, k - 1);
            int second = mystery6(n - 1, k);
            return first + second;
        }
    }

    public static void writeNums(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }

        if (n == 1) {
            System.out.print("1");
        } else {
            writeNums(n - 1);
            System.out.print(", " + n);
        }
    }
}
