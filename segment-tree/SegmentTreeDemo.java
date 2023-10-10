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

class SegmentTree {

    private SegmentTreeNode root;
    private int[] arr;

    SegmentTree(int[] arr) {
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

public class SegmentTreeDemo {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        SegmentTree sgTree = new SegmentTree(arr);
        System.out.println("Level Order Traversal of: ");
        sgTree.levelOrderTraversal();

        // implement query method

    }

}