package billydev.Exp039_BTTraversePostOrderRecursive;
/**
 * Answer is : 4526731
 * */
class BNode<T>{
    T element;
    BNode left;
    BNode right;
    public BNode(T element) {
        this(element, null, null);
    }

    public BNode(T element, BNode left, BNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}

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
    }

    private static void outputNode(BNode node) {
        if (node == null) {
            throw new RuntimeException("input node could not be null!");
        }
        if (node.left != null) {
            outputNode(node.left);
        }
        if (node.right != null) {
            outputNode(node.right);
        }
        System.out.print(" "+node.element);
    }
}
