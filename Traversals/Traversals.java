import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        List<T> preorderList = new ArrayList<>();
        preRecursion(root, preorderList);
        return preorderList;
    }

    private void preRecursion(TreeNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        else {
            list.add(node.getData());
            preRecursion(node.getLeft(), list);
            preRecursion(node.getRight(), list);
        }
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        List<T> inorderList = new ArrayList<>();
        inRecursion(root, inorderList);
        return inorderList;
    }

    private void inRecursion(TreeNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        else {
            inRecursion(node.getLeft(), list);
            list.add(node.getData());
            inRecursion(node.getRight(), list);
        }
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        List<T> postorderList = new ArrayList<>();
        postRecursion(root, postorderList);
        return postorderList;
    }

    private void postRecursion(TreeNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        else {
            postRecursion(node.getLeft(), list);
            postRecursion(node.getRight(), list);
            list.add(node.getData());
        }
    }
}