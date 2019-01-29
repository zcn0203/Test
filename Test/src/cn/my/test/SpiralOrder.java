package cn.my.test;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    /**
     * 螺旋矩阵
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     * <p>
     * 输入:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        List<Integer> list = spiralOrder(matrix);

        System.out.println(list.toString());
        //Thread

    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int minCol = 0;
        int maxCol = matrix[0].length-1;
        int minRow = 0;
        int maxRow = matrix.length-1;
        int col = 0;
        int row = 0;
        int max = (maxCol+1)*(maxRow+1);
        System.out.println(max);

        int flag = 0;

        while(max>0&&maxCol>=minCol&&maxRow>=minRow){
            //上
            if(row==minRow&&maxCol>=minCol&&maxRow>=minRow){
                for(int i = minCol; i<=maxCol; i++){
                    System.out.println("上"+flag);
                    list.add(matrix[minRow][i]);
                    col++;
                    max--;
                }
                flag++;
                col--;
                minRow++;
                minCol--;
            }

            //下
            if(row==maxRow&&maxCol>=minCol&&maxRow>=minRow){
                for(int i = maxCol; i>=minCol; i--){
                    System.out.println("下"+flag);
                    list.add(matrix[maxRow][i]);
                    col--;
                    max--;
                }
                flag++;
                maxCol++;
                maxRow--;
            }

            //左
            if(col==minCol&&maxCol>=minCol&&maxRow>=minRow){
                for(int i = maxRow; i>minRow; i--){
                    System.out.println("左"+flag);
                    list.add(matrix[i][minCol]);
                    row--;
                    max--;
                }
                flag++;
                maxRow++;
                minCol++;
            }

            //右
            if(col==maxCol&&maxCol>=minCol&&maxRow>=minRow){
                for(int i = minRow; i<=maxRow; i++){
                    System.out.println("右"+flag);
                    list.add(matrix[i][maxCol]);
                    row++;
                    max--;
                }
                flag++;
                minRow--;
                maxCol--;
            }

            if(flag == 4){
                System.out.println("is flag");
                minRow++;
                //minCol++;
                maxRow--;
                maxCol--;
                flag = 0;
            }

        }

        return list;

    }

}
