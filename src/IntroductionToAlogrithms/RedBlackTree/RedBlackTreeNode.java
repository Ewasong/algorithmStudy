package IntroductionToAlogrithms.RedBlackTree;

/**
 * Created by 81929 on 2018/7/23.
 */
public class RedBlackTreeNode {
    private Integer key;

    private Object val;

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

    public  RedBlackTreeNode(boolean nilFlag){
        this.nilFlag = nilFlag;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    /***
     * 左旋
     * @param tree
     * @param nodeX
     */
    public static void leftRotate(RedBlackTree tree, RedBlackTreeNode x) {
        RedBlackTreeNode y = x.right;
        //首先把y的左儿子移动给x
        x.right = y.left;
        if (y.left != nil) {
            y.left.parent = x;
        }
        //然后因为y要替代x的位置，所以y的parent要替换为x.parent
        y.parent = x.parent;
        //如果x是根节点，那么旋转后y就是根节点
        //如果x是左儿子，那么y也是右儿子
        //如果x是右儿子，那么y也是右儿子
        if (x.parent == nil) {
            tree.setRoot(y);
        } else if (x == x.parent.left) {

            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        //x变成y的左儿子
        y.left = x;
        x.parent = y;
    }

    /***
     * 右旋
     * @param tree
     * @param nodeY
     */
    public static void rightRotate(RedBlackTree tree, RedBlackTreeNode y) {
        RedBlackTreeNode x = y.left;
        //首先把x的右儿子移动到y的左儿子
        y.left = x.right;
        if (x.right != nil) {
            x.right.parent = y;
        }

        y.parent = x;
        if (y.parent == nil) {
            tree.setRoot(x);
        } else if (y.parent.left == y) {
            y.parent.left = y;
        } else {
            y.parent.right = y;
        }
        // y 变成x的儿子
        x.right = y;
        y.parent = x;
    }

//    /***
//     * 插入
//     * @param tree
//     * @param nodeZ
//     */
//    public static void insert(RedBlackTree tree, RedBlackTreeNode nodeZ){
//        RedBlackTreeNode nodeY = RedBlackTreeNode.nil;
//        RedBlackTreeNode nodeX = tree.getRoot();
//        while (nodeX != RedBlackTreeNode.nil){
//            nodeY = nodeX;
//            if(nodeZ.getKey() < nodeX.getKey()){
//                nodeX = nodeX.getLeft();
//            }
//            else {
//                nodeX = nodeX.getRight();
//            }
//        }
//
//        nodeZ.setParent(nodeY);
//        if(nodeY == RedBlackTreeNode.nil){
//            tree.setRoot(nodeZ);
//        }
//        else if(nodeZ.getKey() < nodeY.getKey()){
//            nodeY.setLeft(nodeZ);
//        }
//        else {
//            nodeY.setRight(nodeZ);
//        }
//        nodeZ.setLeft(RedBlackTreeNode.nil);
//        nodeZ.setRight(RedBlackTreeNode.nil);
//        nodeZ.setColor(RedBlackTreeNode.colorRed);
//        insertFixUp(tree, nodeZ);
//    }
//
//    /***
//     * 插入-修正
//     * @param tree
//     * @param nodeZ
//     */
//    public static void insertFixUp(RedBlackTree tree, RedBlackTreeNode nodeZ){
//        while (nodeZ.getParent().getColor().equals(RedBlackTreeNode.colorRed)){
//            if(nodeZ.getParent() == nodeZ.getParent().getParent().getLeft()){
//                RedBlackTreeNode nodeY = nodeZ.getParent().getParent().getRight();
//                if(nodeY.getColor().equals(RedBlackTreeNode.colorRed)){
//                    nodeZ.getParent().setColor(RedBlackTreeNode.colorBlack);                    //case 1
//                    nodeY.setColor(RedBlackTreeNode.colorBlack);                                //case 1
//                    nodeZ.getParent().getParent().setColor(RedBlackTreeNode.colorRed);          //case 1
//                    nodeZ = nodeZ.getParent().getParent();                                      //case 1
//                }
//                else if(nodeZ == nodeZ.getParent().getRight()){
//                    nodeZ = nodeZ.getParent();                                                  //case 2
//                    leftRotate(tree, nodeZ);                                                    //case 2
//                }
//                nodeZ.getParent().setColor(RedBlackTreeNode.colorBlack);                        //case 3
//                nodeZ.getParent().getParent().setColor(RedBlackTreeNode.colorRed);              //case 3
//                rightRotate(tree, nodeZ);
//            }
//            else {
//                RedBlackTreeNode nodeY = nodeZ.getParent().getParent().getLeft();
//                if(nodeY.getColor().equals(RedBlackTreeNode.colorRed)){
//                    nodeZ.getParent().setColor(RedBlackTreeNode.colorBlack);                    //case 1
//                    nodeY.setColor(RedBlackTreeNode.colorBlack);                                //case 1
//                    nodeZ.getParent().getParent().setColor(RedBlackTreeNode.colorRed);          //case 1
//                    nodeZ = nodeZ.getParent().getParent();                                      //case 1
//                }
//                else if(nodeZ == nodeZ.getParent().getLeft()){
//                    nodeZ = nodeZ.getParent();                                                  //case 2
//                    rightRotate(tree, nodeZ);                                                   //case 2
//                }
//                nodeZ.getParent().setColor(RedBlackTreeNode.colorBlack);                        //case 3
//                nodeZ.getParent().getParent().setColor(RedBlackTreeNode.colorRed);              //case 3
//                leftRotate(tree, nodeZ);
//            }
//        }
//        tree.getRoot().setColor(RedBlackTreeNode.colorBlack);
//    }
}
