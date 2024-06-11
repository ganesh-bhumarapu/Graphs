// 1 -> first find the path from root node to the given node
// 2 -> then store the path in the list
// 3 -> by considering thr k value check for the kth ancestor in the list
// 4 -> formula to find the kth ancestor is (kth ancestor = listSize -k -1)
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
class KthAncestorInTree{
    static Node treeBuild(Scanner sc){
        System.out.println("Enter the root element");
        return treeBuilderHelper(sc);
    }
    static Node treeBuilderHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
    }
        Node root=new Node(data);
        System.out.println("enter the left child of "+data +" :");
        root.left=treeBuilderHelper(sc);
        System.out.println("enter the right child of "+ data+" :");
        root.right=treeBuilderHelper(sc);
    }
    public static boolean getPath(Node root, List<Integer> res, int x){
        if(root == null){
            return false;
        }
        res.add(root.data);
        if(root.data == x){
            return true;
        }
        if(getPath(root.left, res, x) || getPath(root.right, res, x)){
            return true;
        }
        res.remove(res.size() - 1);// backtrack if the leaf node is not the requried node
        return false;
    }
    public static List<Integer> solve(Node root, int x){
        List<Integer> res=new ArrayList<>();

        if(root == null){
            return res;
        }
        getPath(root, res, x);
        return res;
    }
    public static int kthAncestor(Node root, int x, int node){
        List<Integer> res=solve(root, node);

        int index = res.size() -k -1;
        if(index >=0){
            return res.get(index);
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuild(sc);
        int k = sc.nextInt();
        int node = sc.nextInt();
        int ancestor = kthAncestor(root, k, node);
        System.out.println(ancestor);
        sc.close();
    }
}