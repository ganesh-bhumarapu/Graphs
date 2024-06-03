import java.util.*;
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class lowestCommonAncestor {
    static Node LCA(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
    static Node treeBuild(Scanner sc){
        System.out.println("Enter the root element");
        return treeBuilderHelper(sc);
    }
    static Node treeBuilderHelper(Scanner sc){
        int data=sc.nextInt();
        if(data == -1){
            return null;
        }
        Node root=new Node(data);
        System.out.println("enter the left child of "+data +" :");
        root.left=treeBuilderHelper(sc);
        System.out.println("enter the right child of "+ data+" :");
        root.right=treeBuilderHelper(sc);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node root=treeBuild(sc);
        System.out.println("Enter the first node value:");
        int n1 = sc.nextInt();
        System.out.println("Enter the second node value:");
        int n2 = sc.nextInt();

        Node lca = LCA(root, n1, n2);
        if (lca != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + lca.data);
        } else {
            System.out.println("LCA does not exist for the given nodes.");
        }
    }
}