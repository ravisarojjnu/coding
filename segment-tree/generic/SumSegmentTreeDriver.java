package generic;

import java.util.List;
import generic.tree.SegmentTree;
import generic.tree.SumSegmentTree;

public class SumSegmentTreeDriver {

    public static void main(String args[]) {
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        SegmentTree<Integer> tree = new SumSegmentTree<>(arr, Integer::sum, 0);
        System.out.println();
        System.out.print("Level order traversal: ");
        List<Integer> levelOrderTraversal = tree.levelOrderTraversal();
        for (int x : levelOrderTraversal) {
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.print("query Sum Segment tree at range 2,5: ");
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
