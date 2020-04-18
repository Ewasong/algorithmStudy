package IntroductionToAlogrithms.RedBlackTree;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

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

    public RedBlackTreeNode() {
    }

    public RedBlackTreeNode(boolean nilFlag) {
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

    public static RedBlackTreeNode getNode(RedBlackTree tree, Integer key) {
        return null;

    }

    public static RedBlackTreeNode find(RedBlackTreeNode node, Integer key) {
        return null;
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


    /**
     * 插入
     *
     * @param tree
     * @param z
     */
    public void insert(RedBlackTree tree, RedBlackTreeNode z) {
        RedBlackTreeNode x = tree.getRoot();
        RedBlackTreeNode y = nil;

        while (x != nil) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        z.left = nil;
        z.right = nil;
        if (y == nil) {
            tree.setRoot(z);
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.color = colorRed;
        insertFixUp(tree, z);
    }

    /**
     * 插入维护
     * @param tree
     * @param z
     */
    public void insertFixUp(RedBlackTree tree, RedBlackTreeNode z) {
        //因为z是红色，所以只有z的父亲是红色，才需要维护
        while (z.parent.color == colorRed) {
            //z的父亲是左儿子的情况(因为z的parent是红色的，那么一定有z的祖父, 不会报空指针)
            if(z.parent == z.parent.parent.left) {
                //y是z的叔叔
                RedBlackTreeNode y = z.parent.parent.right;
                //情况1，如果叔结点是红色
                if (y.color == colorRed) {
                    // 把z的父亲染色成为黑色
                    z.parent.color = colorBlack;
                    /** 因为z的父亲染成黑色，但是z的祖父的左边黑高就加 1,导致违反性质
                     * 所以这里把z的祖父染成红色，z的叔叔染成黑色，那么就可以保证z的祖父以及子树满足红黑树性质
                     **/
                    y.color = colorBlack;
                    y.parent.parent.color = colorRed;

                    //因为z的祖父已经满足性质了，要维护的只是z祖父的祖先们
                    z = z.parent.parent;
                } else if (z == z.parent.right) {
                    //情况2 叔结点黑色，z是父亲的右边儿子
                    // 此时直接在z的父亲上做左旋，变成第3情况
                    z = z.parent;
                    leftRotate(tree, z);
                }
                // 情况3 叔结点是黑色 (情况1和情况2处理后都成为了情况3)
                // 把父亲染色成为黑色，把祖父染成红色，此时左边黑高多了1，右旋祖父维护平衡
                z.parent.color = colorBlack;
                z.parent.parent.color = colorRed;

                rightRotate(tree, z.parent.parent);
            } else {
                // z的父亲是右(直接把左儿子的代码复制过来，然后左右调换即可。
                //y是z的叔叔
                RedBlackTreeNode y = z.parent.parent.left;
                //情况1，如果叔结点是红色
                if (y.color == colorRed) {
                    // 把z的父亲染色成为黑色
                    z.parent.color = colorBlack;
                    /** 因为z的父亲染成黑色，但是z的祖父的左边黑高就加 1,导致违反性质
                     * 所以这里把z的祖父染成红色，z的叔叔染成黑色，那么就可以保证z的祖父以及子树满足红黑树性质
                     **/
                    y.color = colorBlack;
                    y.parent.parent.color = colorRed;

                    //因为z的祖父已经满足性质了，要维护的只是z祖父的祖先们
                    z = z.parent.parent;
                } else if (z == z.parent.left) {
                    //情况2 叔结点黑色，z是父亲的左边儿子
                    // 此时直接在z的父亲上做右旋，变成第3情况
                    z = z.parent;
                    rightRotate(tree, z);
                }
                // 情况3 叔结点是黑色 (情况1和情况2处理后都成为了情况3)
                // 把父亲染色成为黑色，把祖父染成红色，此时左边黑高多了1，左旋祖父维护平衡
                z.parent.color = colorBlack;
                z.parent.parent.color = colorRed;

                leftRotate(tree, z.parent.parent);
            }
        }

        //维护结束后，把根节点设置为黑色
        tree.getRoot().color = colorBlack;
    }

    /**
     * 删除
     * @param tree
     * @param z
     */
    public void delete(RedBlackTree tree, RedBlackTreeNode z) {
        RedBlackTreeNode y = z;
        int yOrinalColor = y.color;
        RedBlackTreeNode x = null;
        if (z.left == nil) {
            //如果左节点是叶结点，只需要把右子树提到z的位置即可
            x = z.right;
            transplant(tree, z, z.right);
        } else if(z.right == nil) {
            //如果右结点点是叶结点，只需要把左子树提到z的位置即可
            x = z.left;
            transplant(tree, z, z.left);
        } else {
            //如果两个都不是叶结点，那么找到右子树最小y
            y = minimum(z.right);
            yOrinalColor = y.color;
            x = y.right;
            //如果y就是z的右儿子
            if (y.parent == z) {
                //这里有点奇怪，为什么要设置y.right.parent = y,是为了处理叶结点么
                x.parent = y;
            } else {
                //如果y不是z的儿子，那么将y的右儿子提升到y的位置
                transplant(tree, y, y.right);
                y.right.parent = y;
            }
            //将z替换成y
            transplant(tree, z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        //如果y是黑色，那么需要修正
        if (yOrinalColor == colorBlack) {
            deleteFixUp(tree, x);
        }
    }

    public void deleteFixUp(RedBlackTree tree, RedBlackTreeNode x) {
        while (x != tree.getRoot() && x.color == colorBlack) {
            if (x == x.parent.left) {
                RedBlackTreeNode w = x.parent.right;
                //情况1 兄弟节点是红色
                if (w.color == colorRed) {
                    //把兄弟节点染黑，父亲节点染红，然后在父亲节点做左旋，w重新指向x的兄弟节点
                    w.color = colorBlack;
                    x.parent.color = colorRed;
                    leftRotate(tree, x.parent);
                    w = x.parent.right;
                }
                //情况2 兄弟节点的儿子全是黑色
                if (w.left.color == colorBlack && w.right.color == colorBlack) {
                    //此时把w染红，然后x指向父亲结点
                    w.color = colorRed;
                    x = x.parent;
                } else {
                    //情况3 w的右儿子是黑色，左孩子是红色
                    if (w.right.color == colorBlack) {
                        //此时把w左儿子染黑，w再右旋，然后w又指向x的兄弟节点
                        w.left.color = colorBlack;
                        w.color = colorRed;

                        rightRotate(tree, w);
                        w = x.parent.right;
                    }
                    //情况4 w的右儿子是红色
                    //此时w变为父亲的颜色
                    w.color = x.parent.color;
                    //父亲变为黑色
                    x.parent.color = colorBlack;
                    //w的右儿子变成黑色
                    w.right.color = colorBlack;
                    //在x父亲做左旋
                    leftRotate(tree, x.parent);
                    //结束
                    x = tree.getRoot();
                }
            } else {
                RedBlackTreeNode w = x.parent.left;
                if (w.color == colorRed) {
                    w.color = colorBlack;
                    x.parent.color = colorRed;
                    rightRotate(tree, x.parent);
                    w = x.parent.left;
                }

                if (w.left.color == colorBlack && w.right.color == colorBlack) {
                    w.color = colorRed;
                    x = x.parent;
                } else {
                    if (w.left.color == colorBlack) {
                        w.right.color = colorBlack;
                        w.color = colorRed;
                        leftRotate(tree, w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = colorBlack;
                    w.right.color = colorBlack;
                    rightRotate(tree, x.parent);
                    x = tree.getRoot();
                }
            }
        }
        //如果x是根节点，需要保证根节点为黑色
        x.color = colorBlack;
    }

    /**
     * 查找x及其子树下最小的一个结点
     * @param x
     * @return
     */
    public RedBlackTreeNode minimum(RedBlackTreeNode x) {
        while (x.left != nil) {
            x = x.left;
        }
        return x;
    }

    /***
     * 把v移动到u的位置(只是针对u的父亲)
     * @param tree
     * @param u
     * @param v
     */
    public void transplant(RedBlackTree tree, RedBlackTreeNode u, RedBlackTreeNode v) {
        if (u.parent == nil) {
            tree.setRoot(v);
        } else if(u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }
}
