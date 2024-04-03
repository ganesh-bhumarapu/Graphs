// Diameter --> the diameter of tree is the number of nodes on the longest path between two end nodes.

class Node
{
    int data;
    Node left,right;
    Node(int item){
        data=item;
        left =right =null;
    }
}
class DetermineIfTwoTreesAreIdentical{
    static boolean isIdentical(Node root1,Node root2){
        if(root1==null && root2==null) return true;

        if(root1==null || root2==null) return false;

        return (root1.data == root2.data) && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
    }
}