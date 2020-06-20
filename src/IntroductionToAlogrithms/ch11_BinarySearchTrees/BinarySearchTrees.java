package IntroductionToAlogrithms.ch11_BinarySearchTrees;

public class BinarySearchTrees {
    public BinarySearchTreesNode root;

    public class BinarySearchTreesNode {
        public int key;
        public BinarySearchTreesNode left;
        public BinarySearchTreesNode right;
        public BinarySearchTreesNode parent;
    }
    public BinarySearchTreesNode search(BinarySearchTreesNode x, int k) {
        if (x == null || k == x.key) {
            return x;
        }
        if (k < x.key) {
            return search(x.left, k);
        } else {
            return search(x.right, k);
        }
    }

    public BinarySearchTreesNode search2(BinarySearchTreesNode x, int k) {
        while (x != null && k != x.key) {
            if (k < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    public BinarySearchTreesNode minNode(BinarySearchTreesNode x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    public BinarySearchTreesNode maxNode(BinarySearchTreesNode x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    public void insert(BinarySearchTrees T, BinarySearchTreesNode z) {
        BinarySearchTreesNode y = null;
        BinarySearchTreesNode x = T.root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            T.root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    public void delete(BinarySearchTrees T, BinarySearchTreesNode z) {
        if (z.left == null) {
            translant(T, z, z.right);
        } else if (z.right == null) {
            translant(T, z, z.left);
        } else {
            BinarySearchTreesNode y = minNode(z);
            if (y.parent != z) {
                translant(T, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            translant(T, z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

    public void translant(BinarySearchTrees T, BinarySearchTreesNode u, BinarySearchTreesNode v) {
        if (u.parent == null) {
            T.root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }
}