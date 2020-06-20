package other.BigDataSort;

public class SortNode implements Comparable{
    int val;
    int fileK;

    public SortNode(int val, int fileK) {
        this.val = val;
        this.fileK = fileK;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getFileK() {
        return fileK;
    }

    public void setFileK(int fileK) {
        this.fileK = fileK;
    }

    @Override
    public int compareTo(Object o) {
        SortNode node = (SortNode) o;
        return val - node.val;
    }
}
