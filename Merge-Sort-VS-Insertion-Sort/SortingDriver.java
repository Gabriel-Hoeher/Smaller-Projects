import sorting.*;
public class SortingDriver {

    public static double[] generateRandomArray(int size) {
        double[] array = new double[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 100.0;
        }
        return array;
    }
    
    public static void main(String[] args) {
        for (int i = 10; i < 1000000; i*=10) {
            double[] array1 = generateRandomArray(i);
            double[] array2 = array1.clone();
            
            System.out.println("Size of array: " + i);

            // algorithm #1
            Sorter rSorter = new InsertionSort();
            rSorter.sort(array1);
            System.out.println("Insertion sort operations: " + rSorter.getOpCount());

            // algorithm #2
            Sorter mSorter = new MergeSort();
            mSorter.sort(array2);
            System.out.println("Merge sort operations: " + mSorter.getOpCount() + "\n");
        }
    }
} 
