package generic.tree;

public abstract class SegmentTree<T> extends BinaryTree<T> {
    abstract protected void build();

    abstract public void update(int index, T val);

    abstract public T query(int leftIndex, int rightIndex);

}
