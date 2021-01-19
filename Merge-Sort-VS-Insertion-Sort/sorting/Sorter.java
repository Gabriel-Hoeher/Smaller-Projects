package sorting;
public abstract class Sorter {
    private long opCount = 0L;

    public long getOpCount() {
        return this.opCount;
    }

    protected void resetOpCount() {
        this.opCount = 0L;
    }
    /**
     * Changed to reduce total calls
     * @param amount is added to opCount
     */
    protected void countOp(int amount) {
        this.opCount += amount;
    }

    public abstract void sort(double[] list);
}