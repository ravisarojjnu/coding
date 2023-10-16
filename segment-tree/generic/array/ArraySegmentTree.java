
public class ArraySegmentTree {

    int[] arr;
    int[] segmentArr;

    public ArraySegmentTree(int[] arr) {
        this.arr = arr;
        this.segmentArr = new int[arr.length * 2 - 1];
        build();
    }

    private void build() {
        buildRecursive(0, arr.length - 1, 0);

    }

    private int buildRecursive(int left, int right, int nodeIndex) {
        if (left > right)
            return 0;
        if (left == right) {
            segmentArr[nodeIndex] = arr[left];
            return arr[left];
        }
        int mid = (left + right) / 2;
        int lval = buildRecursive(left, mid, nodeIndex * 2 + 1);
        int rval = buildRecursive(mid + 1, right, nodeIndex * 2 + 2);
        int s = rval + lval;
        segmentArr[nodeIndex] = s;
        return s;

    }

    public int query(int left, int right) {
        return queryRecursive(left, right, 0, 0, arr.length - 1);

    }

    private int queryRecursive(int left, int right, int nodeIndex, int l, int r) {
        if (l > r)
            return 0;

        if (r < left || l > right)
            return 0;

        if (left <= l && right >= r)
            return segmentArr[nodeIndex];
        int mid = (l + r) / 2;
        int lval = queryRecursive(left, right, nodeIndex * 2 + 1, l, mid);
        int rval = queryRecursive(left, right, nodeIndex * 2 + 2, mid + 1, r);
        return lval + rval;

    }

    public void printSegmentArray() {
        for (int i = 0; i < segmentArr.length; i++) {
            System.out.print(segmentArr[i] + " ");
        }
        System.out.println();
    }

}
