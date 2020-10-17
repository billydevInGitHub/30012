package billydev.exp044.dfs;

//anwser is: 1245367 the same as

import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        BNode root = new BNode(1);
        root.left = new BNode(2);
        root.right = new BNode(3);
        root.left.left = new BNode(4);
        root.left.right = new BNode(5);
        root.right.left = new BNode(6);
        root.right.right = new BNode(7);


        if (root == null) {
            System.out.println("Empty tree!");
            return;
        }
        outputNodeDFS(root);

    }



    private static void outputNodeDFS(BNode bNode ) {

        System.out.println("bNode.element = " + bNode.element);
        if (bNode.left != null) {
            outputNodeDFS(bNode.left);
        }
        if (bNode.right != null) {
            outputNodeDFS(bNode.right);
        }


    }
}


