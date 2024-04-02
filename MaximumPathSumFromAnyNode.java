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
class MaximumPathSumFromAnyNode{
    int findMaxSum(Node root){
        int[] maxValue=new int[1];
        maxValue[0]=Integer.MIN_VALUE;
        maxValuePath(root,maxValue);
        return maxValue[0];
    }
    static int maxValuePath(Node root,int[] maxValue){
        if(root==null)  return 0;

        int leftMaxValue=Math.max(0,maxValuePath((root.left,maxValue));// ignores the negative node and returns 0

        int rightMaxValue=Math.max(0,maxValuePath(root.right,maxValue));

        maxValue[0]=Math.max(maxValue[0],leftMaxValue+rightMaxValue+root.data);

        return root.data + Math.max(leftMaxValue,rightMaxValue);
    }
}