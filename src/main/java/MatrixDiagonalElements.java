import java.util.ArrayList;
import java.util.List;

public class MatrixDiagonalElements {

    public static void main(String[] args) {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(getDiagonalElements(input));
    }

    private static List<Integer> getDiagonalElements(int[][] input) {
        List<Integer> diagonalElementList = new ArrayList<Integer>();
        int rows = input.length;
        int columns = input[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                if (i == j){
                    diagonalElementList.add(input[i][j]);
                }
            }
        }
        return diagonalElementList;
    }

}
