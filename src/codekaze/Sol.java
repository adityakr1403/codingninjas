package codekaze;

public class Sol {
    static long maxiAnd(int n, int[] a){
        int msb = 31;
        for (int x: a) {
            int numberOfLeadingZeros = Integer.numberOfLeadingZeros(x);
            int currMSB = 31 - numberOfLeadingZeros;
            if (currMSB < msb) {
                msb = currMSB;
            }
        }
        long result = 0L;
        while (msb-->0){
            result = (result << 1) + 1;
        }
        return result;
    }


    static int secretCode(int n, int[] a){
        for (int i = 2; i < n; i++) {
            int sum = a[i] + a[i-1] + a[i-2];
            if (sum % 10 == 0){
                return 1;
            }
        }
        return 0;
    }

    static long[] countOperations(int n, int[] a, long x, int q, int[][] queries){
        long[] result = new long[q];
        for (int i = 0; i < q; i++) {
            int[] query = queries[i];
            a[query[0]] = query[1];

        }
        return result;
    }


    static int[] binaryQueries(int n, int[] a, int q, int[][] queries){
        int[] result = new int[q];
        int[] a_or = new int[n];
        a_or[0] = a[0];
        for (int i = 1; i < n; i++) {
            a_or[i] = a[i] | a_or[i-1];
        }
        for (int i = 0; i < q; i++) {
            int[] query = queries[i];
            int x = a_or[query[1]] - a_or[query[0]];
            result[i] = x ^ query[2];
        }
        return result;
    }
}
