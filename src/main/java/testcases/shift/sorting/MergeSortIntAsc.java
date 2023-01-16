package testcases.shift.sorting;

import testcases.shift.data.Data;

import java.io.IOException;

public class MergeSortIntAsc implements Sort<Integer> {

    @Override
    public Integer[] sort(Data<Integer> data) throws IOException {
        var array = data.insert();
        return sortMerge(array);
    }

    private Integer[] sortMerge(Integer[] array) {
        return sort(array, 0, array.length - 1);
    }

    private Integer[] sort(Integer[] array, int from, int to) {
        if (from == to) {
            return new Integer[]{array[from]};
        }
        int mid = (from + to) / 2;
        return merge(
                sort(array, from, mid),
                sort(array, mid + 1, to)
        );
    }

    private Integer[] merge(Integer[] left, Integer[] right) {
        int l = 0, r = 0, rsl = 0;
        Integer[] result = new Integer[left.length + right.length];
        while (rsl != result.length) {
            if (l == left.length) {
                result[rsl++] = right[r++];
            } else if (r == right.length) {
                result[rsl++] = left[l++];
            } else if (left[l] < right[r]) {
                result[rsl++] = left[l++];
            } else {
                result[rsl++] = right[r++];
            }
        }
        return result;
    }
}
