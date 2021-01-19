/**
 * This class preforms merge sort
 * It is run through the Sorting Driver 
 * Subclass of Sorter
 * Part of sorting package
 * @author Gabriel Hoeher
 */

package sorting;
public class MergeSort extends Sorter {
    /**
     * Finds the size of the list and begins mergesort
     * @param list is the array of doubles created in the driver
     */
    public void sort(double[] list) {
        int size = list.length;
        this.countOp(1);
        mergeSort(list, size); 
    }

    /**
     * Preforms the seperation stage of merge sort
     * @param list is the double list passed through from sort
     * @param high is the max size
     * @return a list when theres only 1 number or everything has been merged
     */
    public double[] mergeSort(double[] list, int high) {
        if (high < 2) return list; //returns if cannot seperate

        int mid = high/2;
        this.countOp(1);

        double[] lower = new double[mid];
        double[] higher = new double [high - mid];
        double[] total = new double[high];
        this.countOp(3);

        //sets everything lower than mid in original list to lower
        for (int i = 0; i < mid; i++) {
            lower[i] = list[i];
            this.countOp(2);
        }
        //sets everything higher than mid in original list to higher
        for (int j = mid; j < high; j++) {
            higher[j - mid] = list[j];
            this.countOp(2);
        }

        //recursive calls till hits base case
        lower = mergeSort(lower, mid);
        higher = mergeSort(higher, high - mid);
        this.countOp(3);

        return (total = merge(lower, higher, total));
    }

    /**
     * Adds the lower and higher arrays to total
     * Runs through both always taking the lower first
     * Once one array has hit its max, adds the rest of the other array
     * @param lower array of numbers lower than mid
     * @param higher array of numbers higher than mid
     * @param total array that will be added to
     * @return total 
     */
    public double[] merge(double[] lower, double[] higher, double[] total) {
        int i = 0, j = 0;
        this.countOp(2);
        
        //takes lower number in each array and adds to total
        while (!hitMax(lower, i) && !hitMax(higher, j)) {
            if (lower[i] <= higher[j]) {
                total[i+j] = lower[i++];
            }
            else {total[i+j] = higher[j++];}
            this.countOp(1);
        }

        //once one array has hit its max
        while (hitMax(lower, i) && !hitMax(higher, j)) {total[i+j] = higher[j++]; this.countOp(1);}
        while (hitMax(higher, j) && !hitMax(lower, i)) {total[i+j] = lower[i++]; this.countOp(1);}

        return total;
    }

    /**
     * Finds if index has hit max
     * @param array double array
     * @param index either i or j
     * @return bool of it hitting max
     */
    public boolean hitMax(double[] array, int index) {
        if (array.length == index) return true;
        return false;
    }
}