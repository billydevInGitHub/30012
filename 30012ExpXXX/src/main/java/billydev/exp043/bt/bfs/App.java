package billydev.exp043.bt.bfs;

//anwser is: 4526731  same as Exp039 ( recursive)

import java.util.HashSet;
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
        //this is my own method
        Stack<BNode> stack = new Stack<BNode>();
        BNode bNode=root;
        HashSet<BNode> hashSet = new HashSet<>();
        stack.push(bNode);
        while (!stack.isEmpty()) {
            bNode=stack.pop();
            if (hashSet.contains(bNode)) {
                System.out.println(bNode.element);
            }else{

                if (bNode.right != null) {
                    stack.push(bNode);
                    //only checked (like check if right is null or not) node need to be added to hashSet
                    hashSet.add(bNode);
                    stack.push(bNode.right);
//                    hashSet.add(bNode.right);//not added to hashSet as this is a node not checked
                    if (bNode.left != null) {
                        stack.push(bNode.left);
                    }
                }else{
                    if (bNode.left == null) {
                        System.out.println(bNode.element);
                    } else {
                        stack.push(bNode.left);
//                        hashSet.add(bNode.left);
                    }
                }
            }


        }
    }
}


