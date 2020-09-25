package billydev.exp042.bt.traverse.postorder.nonrecursive;

//anwser is: 4526731  same as Exp039 ( recursive)

import java.util.HashSet;
import java.util.Set;
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


        outputNode(root);
        methodFromBlog(root);

    }

    private static void methodFromBlog(BNode p) {
        //https://clawhub.club/posts/2020/01/02/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95/%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93/#1-3-1%E3%80%81%E9%80%92%E5%BD%92%E5%AE%9E%E7%8E%B0
        if (p == null){
            return;
        }
        Stack<BNode> stack = new Stack<>();
        Stack<BNode> result = new Stack<>();
        while (!stack.empty() || p != null) {
            while (p != null) {
                stack.push(p);
                result.push(p);
                p = p.right;
            }
            if (!stack.empty()) {
                p = stack.pop().left;
            }
        }
        while (!result.empty()) {
            p = result.pop();
            System.out.println("p.element = " + p.element);
        }

    }

    private static void outputNode(BNode root ) {
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


