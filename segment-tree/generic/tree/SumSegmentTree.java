package generic.tree;

import java.util.function.BinaryOperator;

public class SumSegmentTree<T> extends SegmentTree<T> {

    public SumSegmentTree(T[] arr, BinaryOperator<T> addFunction, T zero) {
        super(arr, addFunction, zero);
    }
}
