package generic;

import java.util.List;
import java.util.function.BinaryOperator;

import generic.tree.SegmentTree;
import generic.tree.ProductSegmentTree;

public class ProductSegmentTreeDriver {

    public static void main(String args[]) {
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        BinaryOperator<Integer> product = (val1, val2) -> val1 * val2;
        SegmentTree<Integer> tree = new ProductSegmentTree<>(arr, product, 1);
        System.out.println();
        System.out.print("Level order traversal: ");
        List<Integer> levelOrderTraversal = tree.levelOrderTraversal();
        for (int x : levelOrderTraversal) {
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.print("query product Segment tree at range 2,5: ");
        Integer val = tree.query(2, 5);
        System.out.println(val);

        System.out.print("Level order traversal before update at 3, 10: ");
        levelOrderTraversal = tree.levelOrderTraversal();
        for (int x : levelOrderTraversal) {
            System.out.print(x + " ");
        }
        System.out.println();
        tree.update(3, 10);
        System.out.print("Level order traversal after update at 3, 10: ");
        levelOrderTraversal = tree.levelOrderTraversal();
        for (int x : levelOrderTraversal) {
            System.out.print(x + " ");
        }

    }

}
