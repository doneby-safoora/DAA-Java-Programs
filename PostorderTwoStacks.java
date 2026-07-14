import java.util.Stack;

public class PostorderTwoStacks {

    Node root;

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    void postorder() {

        if (root == null)
            return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {

            Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null)
                stack1.push(current.left);

            if (current.right != null)
                stack1.push(current.right);
        }

        System.out.print("Postorder Traversal: ");

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }

        System.out.println();
    }
}