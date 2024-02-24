public class HofstadterSequence {

    public static int hofstadterFemale(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return n - hofstadterFemale(n - 1);
        }
    }

    public static int hofstadterMale(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 0;
        } else {
            return n - hofstadterMale(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.print("F: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(hofstadterFemale(i) + " ");
        }

        System.out.println();

        System.out.print("M: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(hofstadterMale(i) + " ");
        }
    }
}
