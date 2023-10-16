package generic.tree;

import java.util.function.BinaryOperator;

public class SegmentTree<T> extends BinaryTree<T> {

    T[] arr;
    BinaryOperator<T> addFunction;
    BinaryOperator<T> subtractFunction;
    T functionIdentity;

    public SegmentTree(T[] arr, BinaryOperator<T> addFunction, BinaryOperator<T> subtractFunction, T functionIdentity) {
        this.arr = arr;
        this.addFunction = addFunction;
        this.subtractFunction = subtractFunction;
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
        node.setVal(addFunction.apply(leftChild.getVal(), rightChild.getVal()));
        return node;

    }

    public T query(int leftIndex, int rightIndex) {

        return queryRecursive(leftIndex, rightIndex, super.getRoot());
    }

    private T queryRecursive(int leftIndex, int rightIndex, TreeNode<T> node) {

        System.out.println("-" + node.getLeftIndex() + " " + node.getRightIndex());

        if ((node.getRightIndex() < leftIndex) || node.getLeftIndex() > rightIndex)
            return functionIdentity;

        if (node.getLeftIndex() >= leftIndex && node.getRightIndex() <= rightIndex) {
            return node.getVal();
        }

        T lval = queryRecursive(leftIndex, rightIndex, node.getLeftChild());
        T rval = queryRecursive(leftIndex, rightIndex, node.getRightChild());
        return addFunction.apply(lval, rval);
    }

    public void update(int index, T val) {
        T diff = subtractFunction.apply(val, arr[index]);
        arr[index] = val;
        updateRecursive(index, diff, super.getRoot());

    }

    public void updateRecursive(int index, T val, TreeNode<T> node) {

        if (node == null)
            return;

        System.out.println("-" + node.getLeftIndex() + " " + node.getRightIndex());

        if ((node.getRightIndex() < index) || node.getLeftIndex() > index)
            return;

        if (node.getLeftIndex() == index && node.getRightIndex() == index) {
            node.setVal(addFunction.apply(node.getVal(), val));
            return;
        }

        if (node.getLeftIndex() <= index && node.getRightIndex() >= index) {
            node.setVal(addFunction.apply(node.getVal(), val));
        }

        updateRecursive(index, val, node.getLeftChild());
        updateRecursive(index, val, node.getRightChild());

    }

    public void updateRange(int left, int right, T val) {
        // we can update the array also but updating the tree only
        updateRangeRecursive(left, right, val, super.getRoot());

    }

    private void updateRangeRecursive(int left, int right, T val, TreeNode<T> node) {
        if (node == null)
            return;

        if (node.getLeftIndex() <= left && node.getRightIndex() >= left)
            node.setVal(addFunction.apply(node.getVal(), val));

        updateRangeRecursive(left, right, val, super.getRoot());
    }

}
