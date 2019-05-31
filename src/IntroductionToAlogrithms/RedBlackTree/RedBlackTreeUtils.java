package IntroductionToAlogrithms.RedBlackTree;

/**
 * Created by 81929 on 2018/7/23.
 */
public class RedBlackTreeUtils {
    /***
     * 左旋
     * @param tree
     * @param nodeX
     */
    public static void leftRotate(RedBlackTree tree, RedBlackTreeNode nodeX) {
        RedBlackTreeNode nodeY = nodeX.getRight();
        RedBlackTreeNode nodeB = nodeY.getLeft();
        RedBlackTreeNode xParent = nodeX.getParent();

        //先设置父亲
        nodeY.setParent(xParent);
        nodeX.setParent(nodeY);
        if (nodeB != RedBlackTreeNode.nil) {
            nodeB.setParent(nodeX);
        }
        //再设置儿子
        nodeY.setLeft(nodeX);
        nodeX.setRight(nodeB);

        if (xParent.getParent() == RedBlackTreeNode.nil){
            tree.setRoot(nodeY);
        }
        else if (nodeX == xParent.getLeft()) {
            xParent.setLeft(nodeY);
        } else if (nodeX == xParent.getRight()){
            xParent.setRight(nodeY);
        }
    }

    /***
     * 右旋
     * @param tree
     * @param nodeY
     */
    public static void rightRotate(RedBlackTree tree, RedBlackTreeNode nodeY) {
        RedBlackTreeNode nodeX = nodeY.getLeft();
        RedBlackTreeNode nodeB = nodeX.getRight();
        RedBlackTreeNode yParent = nodeY.getParent();

        //设置父亲
        nodeX.setParent(yParent);
        nodeY.setParent(nodeX);
        if(nodeB != RedBlackTreeNode.nil){
            nodeB.setParent(nodeY);
        }

        //再设置儿子
        nodeX.setRight(nodeY);
        nodeY.setLeft(nodeB);
        if(yParent == RedBlackTreeNode.nil){
            tree.setRoot(nodeX);
        }
        else if(nodeY == yParent.getLeft()){
            yParent.setLeft(nodeX);
        }
        else if(nodeY == yParent.getRight()){
            yParent.setRight(nodeX);
        }
    }

    /***
     * 插入
     * @param tree
     * @param nodeZ
     */
    public static void insert(RedBlackTree tree, RedBlackTreeNode nodeZ){
        RedBlackTreeNode nodeY = RedBlackTreeNode.nil;
        RedBlackTreeNode nodeX = tree.getRoot();
        while (nodeX != RedBlackTreeNode.nil){
            nodeY = nodeX;
            if(nodeZ.getKey() < nodeX.getKey()){
                nodeX = nodeX.getLeft();
            }
            else {
                nodeX = nodeX.getRight();
            }
        }

        nodeZ.setParent(nodeY);
        if(nodeY == RedBlackTreeNode.nil){
            tree.setRoot(nodeZ);
        }
        else if(nodeZ.getKey() < nodeY.getKey()){
             nodeY.setLeft(nodeZ);
        }
        else {
            nodeY.setRight(nodeZ);
        }
        nodeZ.setLeft(RedBlackTreeNode.nil);
        nodeZ.setRight(RedBlackTreeNode.nil);
        nodeZ.setColor(RedBlackTreeNode.colorRed);
        insertFixUp(tree, nodeZ);
    }

    /***
     * 插入-修正
     * @param tree
     * @param nodeZ
     */
    public static void insertFixUp(RedBlackTree tree, RedBlackTreeNode nodeZ){
        while (nodeZ.getParent().getColor().equals(RedBlackTreeNode.colorRed)){
            if(nodeZ.getParent() == nodeZ.getParent().getParent().getLeft()){
                RedBlackTreeNode nodeY = nodeZ.getParent().getParent().getRight();
                if(nodeY.getColor().equals(RedBlackTreeNode.colorRed)){
                    nodeZ.getParent().setColor(RedBlackTreeNode.colorBlack);                    //case 1
                    nodeY.setColor(RedBlackTreeNode.colorBlack);                                //case 1
                    nodeZ.getParent().getParent().setColor(RedBlackTreeNode.colorRed);          //case 1
                    nodeZ = nodeZ.getParent().getParent();                                      //case 1
                }
                else if(nodeZ == nodeZ.getParent().getRight()){
                    nodeZ = nodeZ.getParent();                                                  //case 2
                    leftRotate(tree, nodeZ);                                                    //case 2
                }
                nodeZ.getParent().setColor(RedBlackTreeNode.colorBlack);                        //case 3
                nodeZ.getParent().getParent().setColor(RedBlackTreeNode.colorRed);              //case 3
                rightRotate(tree, nodeZ);
            }
            else {
                RedBlackTreeNode nodeY = nodeZ.getParent().getParent().getLeft();
                if(nodeY.getColor().equals(RedBlackTreeNode.colorRed)){
                    nodeZ.getParent().setColor(RedBlackTreeNode.colorBlack);                    //case 1
                    nodeY.setColor(RedBlackTreeNode.colorBlack);                                //case 1
                    nodeZ.getParent().getParent().setColor(RedBlackTreeNode.colorRed);          //case 1
                    nodeZ = nodeZ.getParent().getParent();                                      //case 1
                }
                else if(nodeZ == nodeZ.getParent().getLeft()){
                    nodeZ = nodeZ.getParent();                                                  //case 2
                    rightRotate(tree, nodeZ);                                                   //case 2
                }
                nodeZ.getParent().setColor(RedBlackTreeNode.colorBlack);                        //case 3
                nodeZ.getParent().getParent().setColor(RedBlackTreeNode.colorRed);              //case 3
                leftRotate(tree, nodeZ);
            }
        }
        tree.getRoot().setColor(RedBlackTreeNode.colorBlack);
    }

}