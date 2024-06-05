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
        int floor =-1;
        while(root != null){
            if(root.data == key){
                return root.data;
            }
            if(key < root.data){
                root = root.left;
            }else{
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node root=treeBuild(sc);
        int x=sc.nextInt();
        int result=findCeil(root,x);
        System.out.println("Floor is"+result);
    }
}