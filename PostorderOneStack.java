import java.util.Stack;

public class PostorderOneStack {

    Node root;

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    void postorder() {

        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node lastVisited = null;

        System.out.print("Postorder Traversal: ");

        while (current != null || !stack.isEmpty()) {

            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {

                Node peek = stack.peek();

                if (peek.right != null && lastVisited != peek.right) {
                    current = peek.right;
                } else {
                    System.out.print(peek.data + " ");
                    lastVisited = stack.pop();
                }
            }
        }

        System.out.println();
    }
}