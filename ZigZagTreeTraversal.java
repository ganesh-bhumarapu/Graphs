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
class ZigZagTreeTraversal{
    static ArrayList<Integer> zigzagTraversal(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        if(root==null) return ans;

        queue.offer(root);
        boolean LeftToRight=true;

        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                if(LeftToRight) temp.add(node.data);// if LeftToRight is true add it normally to temp list
                else temp.add(0,node.data);// if it is false then add the data at front i.e at zeroth index by that it will reverse the list

                if(node.left!=null)  queue.offer(node.left);

                if(node.right!=null) queue.offer(node.right);
            }
            ans.addAll(temp);
            LeftToRight=!LeftToRight;// after every traversal change it
        }
        return ans;
    }
}