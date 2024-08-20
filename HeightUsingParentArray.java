import java.util.*;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class HeightUsingParentArray {
    public static int findHeight(int n, int[] arr) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        Node root = null;
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                root = nodes[i];
            } else {
                Node parentNode = nodes[arr[i]];
                if (parentNode.left == null) {
                    parentNode.left = nodes[i];
                } else if (parentNode.right == null) {
                    parentNode.right = nodes[i];
                }
            }
        }

        return calculateHeight(root);
    }

    private static int calculateHeight(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int height = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            while (levelSize > 0) {
                Node current = q.poll();
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
                levelSize--;
            }
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findHeight(n, arr));
    }
}
