import java.util.ArrayList;
import java.util.List;

class SegmentTreeNode {
    private int val = 0;
    private SegmentTreeNode leftChild;
    private SegmentTreeNode rightChild;
    private int leftIndex;
    private int rightIndex;

    SegmentTreeNode(int leftIndex, int rightIndex) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public SegmentTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(SegmentTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public SegmentTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(SegmentTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getLeftIndex() {
        return leftIndex;
    }

    public void setLeftIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }

}

class SumSegmentTree {

    private SegmentTreeNode root;
    private int[] arr;

    SumSegmentTree(int[] arr) {
        this.arr = arr;

        build();

    }

    private void build() {

        this.root = buildRecursive(0, this.arr.length - 1);

    }

    private SegmentTreeNode buildRecursive(int leftIndex, int rightIndex) {
        SegmentTreeNode node = new SegmentTreeNode(leftIndex, rightIndex);
        if (leftIndex == rightIndex)
            node.setVal(arr[leftIndex]);

        else {
            int mid = (leftIndex + rightIndex) / 2;
            SegmentTreeNode leftChild = buildRecursive(leftIndex, mid);
            SegmentTreeNode rightChild = buildRecursive(mid + 1, rightIndex);
            node.setLeftChild(leftChild);
            node.setRightChild(rightChild);
            int val = leftChild.getVal() + rightChild.getVal();
            node.setVal(val);
        }

        return node;
    }

    public int query(int l, int r) {

        if (root == null)
            return 0;
        return queryRecursive(root, l, r);

    }

    public void update(int index, int val) {
        if (root == null)
            return;
        updateRecursive(0, this.arr.length - 1, index, val, root);

    }

    private void updateRecursive(int left, int right, int index, int val, SegmentTreeNode node) {
        if (node == null)
            return;

        if (node.getLeftIndex() == node.getRightIndex() && node.getLeftIndex() == index) {
            node.setVal(val);
            return;
        }

        if (node.getLeftIndex() <= index && node.getRightIndex() >= index)
            node.setVal(node.getVal() + val);

        int mid = (left + right) / 2;
        updateRecursive(left, mid, index, val, node.getLeftChild());
        updateRecursive(mid + 1, right, index, val, node.getRightChild());

    }

    private int queryRecursive(SegmentTreeNode node, int l, int r) {
        if (node == null)
            return 0;

        if (node.getLeftIndex() >= l && node.getRightIndex() <= r)
            return node.getVal();

        int lsum = queryRecursive(node.getLeftChild(), l, r);
        int rsum = queryRecursive(node.getRightChild(), l, r);
        return lsum + rsum;
    }

    public void levelOrderTraversal() {
        List<SegmentTreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            SegmentTreeNode node = queue.remove(0);
            System.out.print(node.getVal() + " ");
            if (node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if (node.getRightChild() != null)
                queue.add(node.getRightChild());
        }
        System.out.println();
    }

    public SegmentTreeNode getRoot() {
        return root;
    }

    public void setRoot(SegmentTreeNode root) {
        this.root = root;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

}

public class SumSegmentTreeDemo {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        SumSegmentTree sgTree = new SumSegmentTree(arr);
        System.out.println("Level Order Traversal of: ");
        sgTree.levelOrderTraversal();

        int sum = sgTree.query(1, 3);
        System.out.println("Range[1,3] sum: " + sum);
        int sum2 = sgTree.query(3, 7);
        System.out.println("Range[3,7] sum: " + sum2);

        System.out.println("Level Order Traversal before update index 6 with 10: ");
        sgTree.levelOrderTraversal();

        sgTree.update(6, 10);

        System.out.println("Level Order Traversal after update index 6 with 10: ");
        sgTree.levelOrderTraversal();

    }

}