package Tree;

import Nodes.TreeNode;

import java.util.ArrayList;

public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int ... data){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int counter = 0;
        for (int i : data){
            arrayList.add(i);
        }
        while(counter != data.length){
            insert(arrayList.get(counter));
            counter++;
        }
    }


    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);

        if (root == null) {
            root = newNode;
        } else {
            TreeNode current = root;

            while (true) {
                if (data <= current.data) {
                    if (current.leftNode == null) {
                        current.leftNode = newNode;
                        break;
                    }
                    current = current.leftNode;
                } else if (data > current.data){
                    if (current.rightNode == null){
                        current.rightNode = newNode;
                        break;
                    }
                    current = current.rightNode;
                } else {
                    break;
                }
            }
        }
    }

    public void inorderTraversal(TreeNode current){
        if (current != null){
            inorderTraversal(current.leftNode);
            System.out.print(current.data + " ");
            inorderTraversal(current.rightNode);
        }
    }
    public void preorderTraversal(TreeNode current){
        if (current != null){
            System.out.print(current.data + " ");
            preorderTraversal(current.leftNode);
            preorderTraversal(current.rightNode);
        }
    }

    public void postorderTraversal(TreeNode current){
        if (current != null){
            postorderTraversal(current.leftNode);
            postorderTraversal(current.rightNode);
            System.out.print(current.data + " ");
        }
    }
}
