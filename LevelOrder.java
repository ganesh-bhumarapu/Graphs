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
class LevelOrder{
    static ArrayList<Integer> levelOrder(Node root){
        Queue<Node> queue=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum=queue.size();
            for(int i=0;i<levelNum;i++){
                if(queue.peek().left!=null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right!=null)
                    queue.offer(queue.peek().right);
                ans.add(queue.poll().data);
            }
        }
        return ans;
    }
}