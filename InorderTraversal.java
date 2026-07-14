import java.util.Stack;

public class InorderTraversal {

    Node root;

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    void inorder() {

        Stack<Node> stack = new Stack<>();
        Node current = root;

        System.out.print("Inorder Traversal: ");

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");

            current = current.right;
        }

        System.out.println();
    }
}