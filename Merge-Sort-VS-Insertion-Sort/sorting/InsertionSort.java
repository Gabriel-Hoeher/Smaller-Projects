/**
 * This class implements insertion sort
 * It is run through the Sorting Driver 
 * Subclass of Sorter
 * Part of sorting package
 * @author Gabriel Hoeher
 */

package sorting;
public class InsertionSort extends Sorter {
    /**
     * Preforms insertion sort 
     * @param list double array passed from sorting driver
     */
    public void sort(double[] list) {
        //sets j and key then runs while loop
        for (int i = 1; i < list.length; i++) {
            int j = i - 1;
            double key = list[i];

            //swaps list places until j is negative or key is larger
            while (j >= 0 && list[j] > key) {
                list[j+1] = list[j];
                j -= 1;
                this.countOp(2);
            }   
            //completes the swap by replacing key
            list[j+1] = key;
            this.countOp(1);
        }
    }
}