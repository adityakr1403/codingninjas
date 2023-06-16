package priorityQ;

import java.util.Arrays;

public class Pq {

    public static void inplaceHolderDelete(int[] arr, int lastIndex) {
        int end = lastIndex - 1;
        int parentIndex = 0;

        int minElement = arr[0];

        arr[parentIndex] = arr[lastIndex];
        arr[lastIndex] = minElement;

        int c1 = 2 * parentIndex + 1;
        int c2 = 2 * parentIndex + 2;

        while (c1 < lastIndex && c2 < lastIndex && (arr[parentIndex] > arr[c1] || arr[parentIndex] > arr[c2])) {

                int temp = Math.min(arr[parentIndex], Math.min(arr[c1], arr[c2]));
                if (temp == arr[c1]) {
                    arr[c1] = arr[parentIndex];
                    arr[parentIndex] = temp;
                    parentIndex = c1;

                } else if (temp == arr[c2]) {
                    arr[c2] = arr[parentIndex];
                    arr[parentIndex] = temp;
                    parentIndex = c2;

                }
                c1 = 2 * parentIndex + 1;
                c2 = 2 * parentIndex + 2;
            }

    }

    public static void inplaceHolderHelperInsert(int[] arr, int childIndex) {
        int parentIndex = (childIndex - 1) / 2;
        while (arr[childIndex] < arr[parentIndex] && parentIndex >= 0) {
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[childIndex];
            arr[childIndex] = temp;

            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
    }

    public static void inplaceHeapSort(int[] arr) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given input itself.
         * Taking input and printing output is handled automatically.
         */

        int start = 0;
        int childIndex = 1;
//        insert
        while (childIndex < arr.length) {
            inplaceHolderHelperInsert(arr, childIndex);
            childIndex++;
        }
        System.out.println(Arrays.toString(arr));


//    delete
        int last = arr.length - 1;
        while (last > 0) {
            inplaceHolderDelete(arr,last);
            last--;
        }
    }

}
