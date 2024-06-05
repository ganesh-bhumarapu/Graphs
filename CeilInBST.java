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
class CeilOfBST{
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
    static int findCeil(Node root,int key){
        if(root == null){
            return -1;
        }
        int ceil =-1;
        while(root != null){
            if(root.data == key){
                return root.data;
            }
            if(key < root.data){
                ceil = root.data;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return ceil;
    }
}