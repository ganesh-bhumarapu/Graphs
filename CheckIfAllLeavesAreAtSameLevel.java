import java.util.*;
class Node{
    int data;
    Node left,right;
    Node (int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
class CheckIfAllLeavesAreAtSameLevel{
    static class Pair{
        Node node;
        int hd;
        Pair(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    static boolean check(Node root){
        if(root == null){
            return true;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,1));
        while(!q.isEmpty()){
            Pair it=q.remove();
            int hd=it.hd;
            Node temp=it.node;
            if(temp.left != null){
                q.add(new Pair(temp.left,hd+1));
            }if(temp.right != null){
                q.add(new Pair(temp.right,hd+1));
            }if(temp.left == null && temp.right == null){
                ans.add(hd);
            }
        }
        int first=ans.get(0);
        for(int i=1;i<ans.size();i++){
            if(!ans.get(i).equals(first)){
                return true;
            }
        }
        return false;
    }
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
        return root;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node root=treeBuild(sc);
        boolean result=check(root);
        if(result){
            System.out.println("All leaves are at same level");
        }else{
            System.out.println("All leaves are not at same level");
        }
    }
}