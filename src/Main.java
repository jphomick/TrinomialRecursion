import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the depth of the Trinomial Triangle:");
        int depth = read.nextInt();
        int girth = (depth * 2) - 1;
        String tabs = "\t";
        if (depth > 8) {
            tabs = "\t\t";
        }
        for (int i = 1; i <= depth; i++) {
            for (int j = 1; j <= girth; j++) {
                int val = getValue(girth, depth, i, j);
                if (val == 0) {
                    System.out.print(" " + tabs);
                } else {
                    if (val >= 1000) {
                        System.out.print(val + "\t");
                    } else {
                        System.out.print(val + tabs);
                    }
                }
            }
            System.out.println();
        }
    }

    private static int getValue(int girth, int depth, int row, int column) {
        if (!isValid(girth, depth, row, column)) {
            return 0;
        } else if (row == 1) {
            return 1;
        } else {
            return getValue(girth, depth, row - 1, column - 1)
                    + getValue(girth, depth, row - 1, column)
                    + getValue(girth, depth, row - 1, column + 1);
        }
    }

    private static boolean isValid(int girth, int depth, int row, int column) {
        if (row < 1 || column < 1 || row > depth || column > girth) {
            return false;
        }
        int area = depth - row;
        if (area == 0) {
            return true;
        }
        if (column <= area || column > girth - area) {
            return false;
        } else {
            return true;
        }
    }
}
