import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
class AllPathsFromRootToLeaf {
    static Node treeBuild(Scanner sc) {
        System.out.println("Enter root elements(use -1 for null");
        return treeBuildHelper(sc);
    }

    static Node treeBuildHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("enter left child of" + data + ":");
        root.left = treeBuildHelper(sc);
        System.out.println("enter right child of" + data + ":");
        root.right = treeBuildHelper(sc);
        return root;
    }

    static ArrayList<ArrayList<Integer>> findPathsToLeaves(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();// nested array list is used to store multiple paths
        if (root == null) {
            return ans;
        }
        ArrayList<Integer> currPath = new ArrayList<>();// used to store the current paths which are being explored
        getPathToLeaf(root, currPath, ans);// function used to find the path to leaf
        return ans;
    }

    static void getPathToLeaf(Node node, ArrayList<Integer> currPath, ArrayList<ArrayList<Integer>> ans) {
        if (node == null) return;
        currPath.add(node.data);// add node data to arraylist if it is not null
        if (node.left == null && node.right == null) {// check if the node left and right are null which indicates the leaf node
            ans.add(new ArrayList<>(currPath));// if it a leaf node then add that currpath to ans list
        } else {
            getPathToLeaf(node.left, currPath, ans);// check recursively on left side of the node till it reaches the leaf node
            getPathToLeaf(node.right, currPath, ans);// check recursively on right side of the node till it reaches the leaf node
        }
        currPath.remove(currPath.size() - 1);//if it reaches leaf node then backtrack to previous node to find another path to another leaf node
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuild(sc);
        AllPathsFromRootToLeaf x = new AllPathsFromRootToLeaf();
        ArrayList<ArrayList<Integer>> ans = findPathsToLeaves(root);
        System.out.println("Root to leaf paths");
        for (ArrayList<Integer> path : ans) {
            System.out.println(path);
        }
        sc.close();
    }
}