package IntroductionToAlogrithms.RedBlackTree;

/**
 * Created by 81929 on 2018/7/23.
 */
public class RedBlackTreeNode {
    private Integer key;

    private RedBlackTreeNode left;
    private RedBlackTreeNode right;
    private RedBlackTreeNode parent;
    private Integer color;


    private boolean nilFlag;


    public static final RedBlackTreeNode nil = new RedBlackTreeNode(true);
    public static final Integer colorBlack = 1;
    public static final Integer colorRed = 2;

    public  RedBlackTreeNode(){

    }

    private RedBlackTreeNode(boolean nilFlag){
        this.nilFlag = nilFlag;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setNilFlag(boolean nilFlag) {
        this.nilFlag = nilFlag;
    }

    public RedBlackTreeNode getLeft() {
        return left;
    }

    public void setLeft(RedBlackTreeNode left) {
        this.left = left;
    }

    public RedBlackTreeNode getRight() {
        return right;
    }

    public void setRight(RedBlackTreeNode right) {
        this.right = right;
    }

    public RedBlackTreeNode getParent() {
        return parent;
    }

    public void setParent(RedBlackTreeNode parent) {
        this.parent = parent;
    }

    public boolean isNilFlag() {
        return nilFlag;
    }

    public static RedBlackTreeNode getNil() {
        return nil;
    }

}
