import java.util.Stack;

public class PreorderTraversal {

    Node root;

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    void preorder() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        System.out.print("Preorder Traversal: ");

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }

        System.out.println();
    }
}