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
class InsertNodeInBST{
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
    static Node insert(Node root,int key){
        if(root == null){
            return new Node(key);
        }
        Node current = root;
        Node parent = null;
        while(current != null){
            parent = current;
            if(key < current.data){
                current = current.left;
            }else if(key > current.data){
                current = current.right;
            }else{
                return root;
            }
        }
        if(key < parent.data){
            parent.left = new Node(key);
        }else{
            parent.right = new Node(key);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuild(sc);
        int key = sc.nextInt();
        root = insert(root, key);
        System.out.println("Node inserted successfully");
        sc.close();
    }
}