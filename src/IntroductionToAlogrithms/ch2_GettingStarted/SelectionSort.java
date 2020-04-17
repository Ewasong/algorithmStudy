package IntroductionToAlogrithms.ch2_GettingStarted;

public class SelectionSort {
    public static void selectionSort(int A[]) {
        for (int i = 0; i < A.length - 1; i++) {
            int minIdex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIdex]) {
                    minIdex = j;
                }
            }
            int temp = A[i];
            A[i] = A[minIdex];
            A[minIdex] = temp;
        }
    }
}
