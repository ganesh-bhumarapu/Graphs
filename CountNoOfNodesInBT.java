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
class CountNoOfNodesInBT{
    static Node treeBuild(Scanner sc){
        System.out.println("enter the root value");
        return treeBuildHelper(sc);
    }
    static Node treeBuildHelper(Scanner sc){
        int data=sc.nextInt();
        if(data==-1){
            return null;
        }
        Node root=new Node(data);
        System.out.println("enter the left child of "+data+" :");
        root.left=treeBuildHelper(sc);
        System.out.println("enter the right child of "+data+" :");
        root.right=treeBuildHelper(sc);
        return root;
    }
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftHt=getLeftHeight(root);
        int rightHt=getRightHeight(root);
        
        if(leftHt==rightHt){
            return (2<<(leftHt))-1;
        }
        else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
    public static int  getLeftHeight(Node root){
        int ht=0;
        while(root.left !=null){
            ht++;
            root=root.left;
        }
        return ht;
    }
    public static int getRightHeight(Node root){
        int ht=0;
        while(root.right!=null){
            ht++;
            root=root.right;
        }
        return ht;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node root=treeBuild(sc);
        sc.close();
        CountNoOfNodesInBT x=new CountNoOfNodesInBT();
        int res=x.countNodes(root);
        System.out.println(res);
    }
}