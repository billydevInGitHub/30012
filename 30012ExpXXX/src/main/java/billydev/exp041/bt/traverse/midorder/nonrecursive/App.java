package billydev.exp041.bt.traverse.midorder.nonrecursive;

//anwser is: 4251637  same as Exp038 ( recursive)

import java.util.*;

public class App {
    public static void main(String[] args) {
        BNode root = new BNode(1);
        root.left = new BNode(2);
        root.right = new BNode(3);
        root.left.left = new BNode(4);
        root.left.right = new BNode(5);
        root.right.left = new BNode(6);
        root.right.right = new BNode(7);

        Stack<BNode> stack = new Stack<BNode>();
        outputNode(root,stack);
        System.out.println("");
        methodFromBlog(root);
    }

    private static void outputNode(BNode root, Stack<BNode> stack) {
        //this is my own method
        stack.push(root);
          Set<BNode> setBNode = new HashSet<>();
          BNode bNode=root;

        while (!stack.isEmpty()) {
            bNode = stack.pop();
            if ((bNode.right != null)&&(!setBNode.contains(bNode.right))) {
                stack.push(bNode.right);
                setBNode.add(bNode.right);
            }
            if (bNode.left == null) {
                System.out.print(bNode.element);
            } else {
                if (!setBNode.contains(bNode.left)) {
                    stack.push(bNode);
                    setBNode.add(bNode);
                    stack.push(bNode.left);
                    setBNode.add(bNode.left);
                } else {
                    System.out.print(bNode.element);
                }
            }
        }
    }


    private static void methodFromBlog(BNode p) {
        if (p == null) {
            return;
        }
        Stack<BNode> stack = new Stack<>();
        while (!stack.empty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.print(p.element);
            p = p.right;
        }
    }
}


