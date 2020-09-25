package billydev.exp041.bt.traverse.midorder.nonrecursive;

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

