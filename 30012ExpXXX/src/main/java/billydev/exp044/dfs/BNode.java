package billydev.exp044.dfs;

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

