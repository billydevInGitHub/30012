package billydev.Exp040_BTTraversePreorderNonRecursive;

import java.util.LinkedList;
import java.util.Stack;
//anwser is: 1 2 4 5 3 6 7  same as Exp037 ( recursive)

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
    }

    private static void outputNode(BNode root, Stack<BNode> stack) {
        stack.push(root);
        while (!stack.isEmpty()) {
            BNode bNode = stack.pop();
            System.out.print(bNode.element);
            if(bNode.right!=null){stack.push(bNode.right);}
            if(bNode.left!=null) {stack.push(bNode.left);}

        }
    }


}
