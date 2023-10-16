
public class ArraySumSegmentTreeDriver {

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArraySegmentTree tree = new ArraySegmentTree(arr);
        System.out.println();
        System.out.print("Level order traversal: ");
        tree.printSegmentArray();

        System.out.println();
        System.out.print("query Sum Segment tree at range 2,5: ");
        Integer val = tree.query(2, 5);
        System.out.println(val);

        System.out.println();
        System.out.print("query Sum Segment tree at range 4,4: ");
        val = tree.query(4, 4);
        System.out.println(val);

        // System.out.print("Level order traversal before update at 3, 10: ");
        // levelOrderTraversal = tree.levelOrderTraversal();
        // for (int x : levelOrderTraversal) {
        // System.out.print(x + " ");
        // }
        // System.out.println();
        // tree.update(3, 10);
        // System.out.print("Level order traversal after update at 3, 10: ");
        // levelOrderTraversal = tree.levelOrderTraversal();
        // for (int x : levelOrderTraversal) {
        // System.out.print(x + " ");
        // }

    }

}
