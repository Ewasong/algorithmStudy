package IntroductionToAlogrithms.ch2_GettingStarted;

public class SortTest {
    public static void main(String[] args) {
        int[] a = {1, 4, 3, 5, 7, 3, 2};
//        InsertionSort.insertionSort(a);

//        MergeSort.mergeSort(a, 0, a.length - 1);
//        BubbleSort.bubbleSort(a);
        SelectionSort.selectionSort(a);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

    }

}
