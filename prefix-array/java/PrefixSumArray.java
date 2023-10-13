
import java.util.function.BinaryOperator;

public class PrefixSumArray<T> {
    T[] arr;
    T[] prefiArr;
    BinaryOperator<T> addFunction;
    BinaryOperator<T> subFunction;

    public PrefixSumArray(T[] arr, BinaryOperator<T> addFunction, BinaryOperator<T> subFunction) {
        this.arr = arr;
        this.prefiArr = arr.clone();
        this.addFunction = addFunction;
        this.subFunction = subFunction;
        build();

    }

    private void build() {

        for (int i = 1; i < arr.length; i++) {
            this.prefiArr[i] = addFunction.apply(this.prefiArr[i], this.prefiArr[i - 1]);
        }

    }

    public T query(int left, int right) {

        if (left > right || right > arr.length || left < 0)
            return null;
        if (left == 0) {
            return prefiArr[right];
        }
        T sum = subFunction.apply(prefiArr[right], prefiArr[left - 1]);
        return sum;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5, 5 };
        BinaryOperator<Integer> subtract = (val1, val2) -> val1 - val2;
        PrefixSumArray<Integer> psa = new PrefixSumArray<Integer>(arr, Integer::sum, subtract);
        int val = psa.query(2, 4);
        System.out.println(val);
    }

}
