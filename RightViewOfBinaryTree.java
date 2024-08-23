import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class RightViewOfBinaryTree{
    static void helper(Node node, ArrayList<Integer> ans, int level, int[] maxLevel){
        if(node == null){
            return;
        }
        if(maxLevel[0] < level){
            ans.add(node.data);
            maxLevel[0] = level;
        }
        helper(node.right, ans, level + 1, maxLevel);
        helper(node.left, ans, level + 1, maxLevel);
    }
    public static ArrayList<Integer> leftView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        int[] maxLevel = new int[1];
        maxLevel[0] = 0;
        helper(root, ans, 1, maxLevel);

        return ans;
    }
    public static Node treeBuilder(Scanner sc){
        System.out.println("Enter the root element");
        return treeBuildHelper(sc);
    }
    public static Node treeBuildHelper(Scanner sc) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuilder(sc);
        ArrayList<Integer> res = leftView(root);
        for(int i : res){
            System.out.print(res.get(i) + " ");
        }
    }
}