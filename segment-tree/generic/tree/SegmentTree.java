package generic.tree;

import java.util.function.BinaryOperator;

public class SegmentTree<T> extends BinaryTree<T> {

    T[] arr;
    BinaryOperator<T> binaryFunction;
    T functionIdentity;

    public SegmentTree(T[] arr, BinaryOperator<T> binaryFunction, T functionIdentity) {
        this.arr = arr;
        this.binaryFunction = binaryFunction;
        this.functionIdentity = functionIdentity;
        build();
    }

    protected void build() {

        TreeNode<T> root = buildRecursive(0, arr.length - 1);
        super.setRoot(root);

    }

    public TreeNode<T> buildRecursive(int left, int right) {
        if (left > right)
            return null;
        TreeNode<T> node = new TreeNode<>(left, right);
        if (left == right) {
            node.setVal(arr[left]);
            return node;
        }
        int mid = (left + right) / 2;
        TreeNode<T> leftChild = buildRecursive(left, mid);
        node.setLeftChild(leftChild);
        TreeNode<T> rightChild = buildRecursive(mid + 1, right);
        node.setRightChild(rightChild);
        node.setVal(binaryFunction.apply(leftChild.getVal(), rightChild.getVal()));
        return node;

    }

    public T query(int leftIndex, int rightIndex) {

        return queryRecursive(leftIndex, rightIndex, super.getRoot());
    }

    private T queryRecursive(int leftIndex, int rightIndex, TreeNode<T> node) {
        if (node == null)
            return functionIdentity;
        if (node.getLeftIndex() >= leftIndex && node.getRightIndex() <= rightIndex) {
            return node.getVal();
        }
        T lval = queryRecursive(leftIndex, rightIndex, node.getLeftChild());
        T rval = queryRecursive(leftIndex, rightIndex, node.getRightChild());
        return binaryFunction.apply(lval, rval);
    }

    public void update(int index, T val) {
        arr[index] = val;
        updateRecursive(index, val, super.getRoot());

    }

    public void updateRecursive(int index, T val, TreeNode<T> node) {

        if (node == null)
            return;

        if (node.getLeftIndex() == index && node.getRightIndex() == index) {
            node.setVal(val);
            return;
        }

        if (node.getLeftIndex() <= index && node.getRightIndex() >= index) {
            node.setVal(binaryFunction.apply(node.getVal(), val));
        }

        updateRecursive(index, val, node.getLeftChild());
        updateRecursive(index, val, node.getRightChild());

    }

}
