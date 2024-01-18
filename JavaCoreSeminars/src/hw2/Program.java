package hw2;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        int[] array = {1,3,0,0,5};
        System.out.println("Task 1: ");
        System.out.println(countEvens(array));
        System.out.println("Task 2: ");
        System.out.println(findDifference(array));
        System.out.println("Task 3: ");
        System.out.println(isTwoZero(array));
        System.out.println("Task 4: ");
        int[][] matrix = getSpiralMatrix(4,6);
        showMatrix(matrix);

    }

    static int countEvens (int[] array){
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                res++;
            }
        }
        return res;
    }

    static int findDifference(int[] array){
        int max = Arrays.stream(array).max().getAsInt();

        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return max - min;
    }

    static boolean isTwoZero(int[] array){
        final int NUM = 0;
        int prev = array[0], next = array[1];
        for (int i = 1; i < array.length - 1; i++) {
            if (prev == NUM && next == NUM){
                return true;
            }
            prev = array[i];
            next = array[i+1];
        }
        return false;
    }

    static void showMatrix (int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static  int[][] getSpiralMatrix(int N, int M){
        int[][] matrix = new int[N][M];
        int Ibeg = 0, Ifin = 0, Jbeg = 0, Jfin = 0;

        int count = 1;
        int i = 0;
        int j = 0;

        while (count <= N * M){
            matrix[i][j] = count;
            if (i == Ibeg && j < M - Jfin - 1)
                ++j;
            else if (j == M - Jfin - 1 && i < N - Ifin - 1)
                ++i;
            else if (i == N - Ifin - 1 && j > Jbeg)
                --j;
            else
                --i;

            if ((i == Ibeg + 1) && (j == Jbeg) && (Jbeg != M - Jfin - 1)){
                ++Ibeg;
                ++Ifin;
                ++Jbeg;
                ++Jfin;
            }
            ++count;
        }
        return matrix;
    }

}
