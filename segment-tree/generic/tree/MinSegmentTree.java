package generic.tree;

import java.util.function.BinaryOperator;

public class MinSegmentTree<T> extends SegmentTree<T> {

    public MinSegmentTree(T[] arr, BinaryOperator<T> minFunction, T maxValue) {
        super(arr, minFunction, maxValue);
    }

}
