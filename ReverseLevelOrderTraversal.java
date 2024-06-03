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
class ReverseLevelOrderTraversal{
    public static ArrayList<Integer> reverseLevelOrder(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        LinkedList<Integer> ans=new LinkedList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.poll();
            for(int i=0;i<size;i++){
                Node current=q.poll();
                ans.addFirst(current.data);
                if(current.right != null){
                    q.add(current.right);
                }
                if(current.left != null){
                    q.add(current.left);
                }
            }
        }
        return new ArrayList<>(ans);
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
        return root;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node root=treeBuild(sc);
        ArrayList<Integer> result=reverseLevelOrder(root);
        System.out.println("Reverse level order traversal: "+result);
    }
}