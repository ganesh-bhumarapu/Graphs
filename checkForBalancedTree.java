class Node
{
    int data;
    Node left,right;
    Node(int item){
        data=item;
        left =right =null;
    }
}
class checkForBalancedTree{
    boolean isBalancedTree(Node root){
        return dfsHeight(root)!=-1;
    }
    static int dfsHeight(Node root){
        if(root==null) return 0;
        int leftHeight=dfsHeight(root.left);
        if(leftHeight ==-1) return -1;
        int rightHeight=dfsHeight(root.right);
        if(rightHeight==-1) return -1;

        if(Math.abs(leftHeight-rightHeight)>1) return -1;

        return Math.max(leftHeight,rightHeight)+1;
    }
}