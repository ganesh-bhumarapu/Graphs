import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int item){
        this.data=item;
        this.left=null;
        this.right=null;
    }
}
class ChildrenSumPropertyOfBT {
    public static boolean isSumProperty(Node root) {
        if (root == null) return true;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            int sum = 0;
            if (root.left != null) {
                q.add(root.left);
                sum += root.left.data;
            }
            if (root.right != null) {
                q.add(root.right);
                sum += root.right.data;
            }
            if (sum != temp.data && sum != 0) {//sum !=0 is used for the leaf nodes whose value is null whose sum cannot produce the root
                return false;
            }
        }
        return true;
    }

    static Node treeBuild(Scanner sc) {
        System.out.println("enter the root element");
        return treeBuilderHelper(sc);
    }

    static Node treeBuilderHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("enter the left chiild of " + data + " :");
        root.left = treeBuilderHelper(sc);
        System.out.println("enter the right child of " + data + " :");
        root.right = treeBuilderHelper(sc);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node root=treeBuild(sc);
        sc.close();
        ChildrenSumPropertyOfBT x=new ChildrenSumPropertyOfBT();
        if (isSumProperty(root)) {
            System.out.println("The tree satisfies the Children Sum Property.");
        } else {
            System.out.println("The tree does not satisfy the Children Sum Property.");
        }
    }
}