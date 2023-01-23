package testcases.shift.sorting;

import java.io.IOException;

public class MergeSortStringAsc implements Sort<String> {

    @Override
    public String[] sort(String[] array) {
        return sortMerge(array);
    }

    private String[] sortMerge(String[] array) {
        return sort(array, 0, array.length - 1);
    }

    private String[] sort(String[] array, int from, int to) {
        if (from == to) {
            return new String[]{array[from]};
        }
        int mid = from + (to - from) / 2;
        return merge(
                sort(array, from, mid),
                sort(array, mid + 1, to)
        );
    }

    private String[] merge(String[] left, String[] right) {
        int l = 0, r = 0, rsl = 0;
        String[] result = new String[left.length + right.length];
        while (rsl != result.length) {
            if (l == left.length) {
                result[rsl++] = right[r++];
            } else if (r == right.length) {
                result[rsl++] = left[l++];
            } else if (left[l].compareTo(right[r]) < 0) {
                result[rsl++] = left[l++];
            } else {
                result[rsl++] = right[r++];
            }
        }
        return result;
    }
}
