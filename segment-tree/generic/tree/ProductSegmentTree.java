package generic.tree;

import java.util.function.BinaryOperator;

public class ProductSegmentTree<T> extends SegmentTree<T> {

    public ProductSegmentTree(T[] arr, BinaryOperator<T> productFunction, T one) {
        super(arr, productFunction, one);
    }
}
