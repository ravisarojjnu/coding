import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode leftChild;
    TreeNode rightChild;
    int leftIndex;
    int rightIndex;

    TreeNode() {
    }

    TreeNode(int leftIndex, int rightIndex) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }

}

class MaxSegmentTree {
    int[] arr;
    TreeNode root;

    MaxSegmentTree(int[] arr) {
        this.arr = arr;
        this.root = build(0, this.arr.length - 1);

    }

    int query(int l, int r) {
        return queryRecursive(l, r, root);

    }

    private int queryRecursive(int l, int r, TreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;
        if (node.leftIndex >= l && node.rightIndex <= r) {
            return node.val;
        }
        int lVal = queryRecursive(l, r, node.leftChild);
        int rVal = queryRecursive(l, r, node.rightChild);
        return max(lVal, rVal);
    }

    private TreeNode build(int l, int r) {
        if (l > r)
            return null;
        TreeNode node = new TreeNode(l, r);
        if (l == r) {
            node.val = this.arr[l];
            return node;

        }
        int mid = (l + r) / 2;
        TreeNode lNode = build(l, mid);
        TreeNode rNode = build(mid + 1, r);
        node.leftChild = lNode;
        node.rightChild = rNode;
        node.val = max(lNode.val, rNode.val);
        return node;

    }

    void update(int index, int val) {
        this.arr[index] = val;
        updateRecursive(index, val, root);

    }

    private void updateRecursive(int index, int val, TreeNode node) {
        if (node == null)
            return;

        if (node.leftIndex == node.rightIndex && node.leftIndex == index) {
            node.val = val;
            return;
        }

        if (node.leftIndex <= index && node.rightIndex >= index)
            node.val = max(node.val, val);

        updateRecursive(index, val, node.leftChild);
        updateRecursive(index, val, node.rightChild);
    }

    private int max(int val1, int val2) {
        if (val1 > val2)
            return val1;
        return val2;
    }

    void levelOrderTraversal() {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            System.out.print(node.val + " ");
            if (node.leftChild != null)
                queue.add(node.leftChild);
            if (node.rightChild != null)
                queue.add(node.rightChild);
        }
        System.out.println();

    }

}

public class MaxSegmentTreeDemo {

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        MaxSegmentTree tree = new MaxSegmentTree(arr);
        System.out.println("Level order traversal of the tree: ");
        tree.levelOrderTraversal();

        System.out.print("query the array for max value between 2,5: ");
        int val = tree.query(2, 5);
        System.out.println(val);

        System.out.print("query the array for max value between 0,2: ");
        int val2 = tree.query(0, 2);
        System.out.println(val2);

        System.out.println("Level order traversal before update of the tree at 3 with 10: ");
        tree.levelOrderTraversal();
        tree.update(3, 10);
        System.out.println("Level order traversal after update of the tree at 3 with 10: ");
        tree.levelOrderTraversal();

    }

}
