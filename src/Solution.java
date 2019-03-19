
class TreeNode1 {
    int data;
    TreeNode1 left, right;
}

class Solution {

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1();
        root.data = 1;
        root.left = new TreeNode1();
        root.left.data = 1;

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode1 root) {
        return isValidBST(root, null);
    }

    public static boolean isValidBST(TreeNode1 root, TreeNode1 prev) {
        if (root == null)
            return true;

        if (isValidBST(root.left, prev)) {
            if (prev != null && root.data <= prev.data) {
                return false;
            }
            prev = root;
        } else {
            return false;
        }

        return isValidBST(root.right, prev);
    }
}
