// Diameter --> the diameter of tree is the number of nodes on the longest path between two end nodes.
import java.util.*;
class Node
{
    int data;
    Node left,right;
    Node(int item){
        data=item;
        left =right =null;
    }
}
class DiameterOfBinaryTree{
    public static int diameter(Node root){
        int[] diameter=new int[1];
        height(root,diameter);
        return diameter[0];
    }
    public static int height(Node root,int[] diameter){
        if(root==null) return 0;

        int leftHeight=height(root.left,diameter);

        int rightHeight=height(root.right,diameter);

        diameter[0]=Math.max(diameter[0],leftHeight+rightHeight+1);

        return 1+Math.max(leftHeight,rightHeight);
    }
}