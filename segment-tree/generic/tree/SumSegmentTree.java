package generic.tree;

import java.util.function.BinaryOperator;

public class SumSegmentTree<T> extends SegmentTree<T> {

    T[] arr;
    BinaryOperator<T> addFunction;
    T zero;

    public SumSegmentTree(T[] arr, BinaryOperator<T> addFunction, T zero) {
        this.arr = arr;
        this.addFunction = addFunction;
        this.zero = zero;
        build();
    }

    @Override
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

    @Override
    public T query(int leftIndex, int rightIndex) {

        return queryRecursive(leftIndex, rightIndex, super.getRoot());
    }

    private T queryRecursive(int leftIndex, int rightIndex, TreeNode<T> node) {
        if (node == null)
            return zero;
        if (node.getLeftIndex() >= leftIndex && node.getRightIndex() <= rightIndex) {
            return node.getVal();
        }
        T lval = queryRecursive(leftIndex, rightIndex, node.getLeftChild());
        T rval = queryRecursive(leftIndex, rightIndex, node.getRightChild());
        return addFunction.apply(lval, rval);
    }

    @Override
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
            node.setVal(addFunction.apply(node.getVal(), val));
        }

        updateRecursive(index, val, node.getLeftChild());
        updateRecursive(index, val, node.getRightChild());

    }

}
