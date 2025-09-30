package Date_23_06_25;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode() {
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaximumBinaryTree654 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = insert(nums, 0);
        TreeNode root1 = constructMaximumBinaryTree(nums);
        Inorder(root);
        System.out.print("END");
        System.out.println();
        Preorder(root);
        System.out.print("END");
        System.out.println();
        Postorder(root);
        System.out.print("END");
        System.out.println();
        levelOrder(root);
        System.out.print("END");
        System.out.println();
        levelOrder(root1);
        System.out.print("END");
        System.out.println();
        System.out.println(binaryTreePaths(root1));
    }

    public static void Inorder(TreeNode node){
        if (node != null){
            Inorder(node.left);
            System.out.print(node.val + " -> ");
            Inorder(node.right);
        }
    }

    public static void Preorder(TreeNode node){
        if (node != null){
            System.out.print(node.val + " -> ");
            Inorder(node.left);
            Inorder(node.right);
        }
    }

    public static void Postorder(TreeNode node){
        if (node != null){
            Inorder(node.left);
            Inorder(node.right);
            System.out.print(node.val + " -> ");
        }
    }

    public static void levelOrder(TreeNode root) {
    if (root == null) return;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        System.out.print(node.val + " -> ");

        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
        }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return helperfunc(nums, 0, nums.length - 1);
    }

    public static TreeNode helperfunc(int[] nums, int left, int right){
        if (nums.length == 0) return null;
        if (left > right) return null;
        int maxIdx = left;
        for (int i = left + 1; i <= right; i++) if (nums[i] > nums[maxIdx]) maxIdx = i;
        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = helperfunc(nums, left, maxIdx - 1);
        node.right = helperfunc(nums, maxIdx + 1, right);
        return node;
    }

    public static TreeNode insert(int[] nums, int idx){
        if (nums.length == 0) return null;
        if (idx < nums.length){
            TreeNode node = new TreeNode(nums[idx]);
            node.left = insert(nums, 2*idx + 1);
            node.right = insert(nums, 2*idx + 2);
            return node;
        }
        return null;
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        //already the root is given, so we can directly jump into the helper function.
        List<String> list = new ArrayList<>();
        String path = "";
        path_er(root, path, list);
        return list;
    }
    
    public static void path_er (TreeNode root, String path, List<String> list){
        if (root == null) return;
        if (path.length() > 0) path += "->"; //formatting the string.
        //add the current node to the string
        path += root.val;

        //if a leaf node is encountered -- add the path to the list and break:-
        if (root.left == null && root.right == null){
            list.add(path);
            return;
        }
        //recurse further
        path_er(root.left, path, list);
        path_er(root.right, path, list);
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        return false;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
