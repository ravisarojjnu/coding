
package generic.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
    private TreeNode<T> root;

    public List<T> levelOrderTraversal() {
        if (root == null)
            return null;
        List<TreeNode<T>> queue = new ArrayList<>();
        List<T> travseredList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.remove(0);
            travseredList.add(node.getVal());
            if (node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if (node.getRightChild() != null)
                queue.add(node.getRightChild());

        }
        return travseredList;

    }

    public List<T> inorderTraversal() {
        if (root == null)
            return null;

        List<TreeNode<T>> stack = new ArrayList<>();
        List<T> travseredList = new ArrayList<>();
        TreeNode<T> node = root;
        while (true) {
            if (node != null) {
                stack.add(node);
                node = node.getLeftChild();
            } else {
                if (!stack.isEmpty()) {
                    node = stack.remove(stack.size() - 1);
                    travseredList.add(node.getVal());
                    node = node.getRightChild();
                } else
                    break;
            }

        }
        return travseredList;

    }

    public List<T> preorderTraversal() {

        if (root == null)
            return null;
        List<TreeNode<T>> stack = new ArrayList<>();
        List<T> traveredList = new ArrayList<>();
        TreeNode<T> node = root.getLeftChild();
        traveredList.add(root.getVal());
        stack.add(root);
        while (true) {
            if (node != null) {
                traveredList.add(node.getVal());
                stack.add(node);
                node = node.getLeftChild();
            } else {
                if (!stack.isEmpty()) {
                    node = stack.remove(stack.size() - 1);
                    node = node.getRightChild();
                } else
                    break;

            }
        }
        return traveredList;
    }

    public List<T> postorderTraversal() {
        if (root == null)
            return null;

        List<T> traveredList = new ArrayList<>();
        postorderTraversalRecursive(root, traveredList);

        return traveredList;

    }

    private void postorderTraversalRecursive(TreeNode<T> node, List<T> traveredList) {
        if (node == null)
            return;
        postorderTraversalRecursive(node.getLeftChild(), traveredList);
        postorderTraversalRecursive(node.getRightChild(), traveredList);
        traveredList.add(node.getVal());

    }

    public int height() {
        return 0;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

}