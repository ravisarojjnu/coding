package generic.tree;

import java.util.function.BinaryOperator;

public class ProductSegmentTree<T> extends SegmentTree<T> {

    public ProductSegmentTree(T[] arr, BinaryOperator<T> productFunction, BinaryOperator<T> divFunction, T one) {
        super(arr, productFunction, divFunction, one);
    }
}
