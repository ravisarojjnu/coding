package generic;

import java.util.List;

import generic.tree.BinaryTree;
import generic.tree.TreeNode;

public class BinaryTreeDriver {
    public static void main(String args[]) {
        BinaryTree<Integer> btree = new BinaryTree<>();
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeftChild(new TreeNode<>(2));
        root.setRightChild(new TreeNode<>(3));
        root.getLeftChild().setLeftChild(new TreeNode<>(4));
        root.getLeftChild().setRightChild(new TreeNode<>(5));
        btree.setRoot(root);
        System.out.println();
        System.out.print("Level order traversal: ");
        List<Integer> levelOrderTraversal = btree.levelOrderTraversal();
        for (int x : levelOrderTraversal) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("inorder traversal: ");
        List<Integer> inorderTraversal = btree.inorderTraversal();
        for (int x : inorderTraversal) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("preorder traversal: ");
        List<Integer> preorderTraversal = btree.preorderTraversal();
        for (int x : preorderTraversal) {
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.print("postorder traversal: ");
        List<Integer> postorderTraversal = btree.postorderTraversal();
        for (int x : postorderTraversal) {
            System.out.print(x + " ");
        }
    }

}