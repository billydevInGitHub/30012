package billydev.exp043.bt.bfs;

//anwser is: 1234567

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        BNode root = new BNode(1);
        root.left = new BNode(2);
        root.right = new BNode(3);
        root.left.left = new BNode(4);
        root.left.right = new BNode(5);
        root.right.left = new BNode(6);
        root.right.right = new BNode(7);


        outputNodeBFS(root);

    }



    private static void outputNodeBFS(BNode root ) {

        if (root == null) {
            System.out.println("Empty tree!");
            return;
        }

        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BNode bNode=queue.poll();
            System.out.println("bNode = " + bNode.element);
            if (bNode.left != null) {
                queue.offer(bNode.left);
            }
            if (bNode.right != null) {
                queue.offer(bNode.right);
            }
        }

    }
}


