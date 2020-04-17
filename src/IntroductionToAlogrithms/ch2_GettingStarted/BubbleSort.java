package IntroductionToAlogrithms.ch2_GettingStarted;

public class BubbleSort {
    public static void bubbleSort(int A[]) {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = A.length - 1; j >= i + 1; j--) {
                if (A[j] < A[j - 1]) {
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                }
            }
        }
    }
}
