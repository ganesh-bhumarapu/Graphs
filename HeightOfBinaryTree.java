import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        this.data = item;
        this.left = null;
        this.right = null;
    }
}

class HeightOfBinaryTree {
    static Node treeBuild(Scanner sc) {
        System.out.println("Enter the root value:");
        return treeBuildHelper(sc);
    }

    static Node treeBuildHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter the left child of " + data + " (enter -1 for no child):");
        root.left = treeBuildHelper(sc);
        System.out.println("Enter the right child of " + data + " (enter -1 for no child):");
        root.right = treeBuildHelper(sc);
        return root;
    }

    static int height(Node node) {
        if (node == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int height = 0;
        while (!q.isEmpty()) {
            int nodeCount = q.size();  // Correctly initialize nodeCount
            height++;
            for (int i = 0; i < nodeCount; i++) {
                Node temp = q.poll();  // Dequeue the node
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node node = treeBuild(sc);
        System.out.println("The height of the binary tree is: " + height(node));
        sc.close();
    }
}
