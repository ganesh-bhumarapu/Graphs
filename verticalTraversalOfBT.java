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
class verticalTraversalOfBT {
    static class Pair{
        Node node;
        int hd;
        Pair(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    static ArrayList<Integer> verticalOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            Node current = temp.node;
            int hd = temp.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, new ArrayList<>());// it creates a new ArrayList for storing the elements that contain the same hd value in order
            }
            map.get(hd).add(current.data);// the data will be addede to the existing arraylist
            if (current.left != null) {
                q.add(new Pair(current.left, hd - 1));
            }
            if (current.right != null) {
                q.add(new Pair(current.right, hd + 1));
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ans.addAll(entry.getValue());
        }
        return ans;
    }
    static Node treeBuild(Scanner sc) {
        System.out.println("enter the root element");
        return treeBuilderHelper(sc);
    }

    static Node treeBuilderHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("enter the left chiild of " + data + " :");
        root.left = treeBuilderHelper(sc);
        System.out.println("enter the right child of " + data + " :");
        root.right = treeBuilderHelper(sc);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node root=treeBuild(sc);
        ArrayList<Integer> res=verticalOrder(root);
        for(int val: res){
            System.out.print(val+" ");
        }
    }
}