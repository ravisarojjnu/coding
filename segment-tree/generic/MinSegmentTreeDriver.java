package generic;

import java.util.List;
import generic.tree.SegmentTree;
import generic.tree.MinSegmentTree;

public class MinSegmentTreeDriver {

    public static void main(String args[]) {
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        SegmentTree<Integer> tree = new MinSegmentTree<>(arr, Integer::min, Integer.MAX_VALUE);
        System.out.println();
        System.out.print("Level order traversal: ");
        List<Integer> levelOrderTraversal = tree.levelOrderTraversal();
        for (int x : levelOrderTraversal) {
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.print("query min Segment tree at range 2,5: ");
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
