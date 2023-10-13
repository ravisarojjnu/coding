package generic.tree;

import java.util.function.BinaryOperator;

public class MaxSegmentTree<T> extends SegmentTree<T> {

    public MaxSegmentTree(T[] arr, BinaryOperator<T> maxFunction, T minValue) {
        super(arr, maxFunction, minValue);
    }

}
