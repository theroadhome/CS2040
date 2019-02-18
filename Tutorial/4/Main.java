class Main {
    public int sum(int n) {
        if (n == 1) {
            return n;
        } else {
            return n + sum(n-1);
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int[] row: matrix) {
            for (int col: row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private void paintBucketFill(int[][] matrix, int row, int col, int colour, int original) {
        if (matrix[row][col] == original) {
            matrix[row][col] = colour;
            if (row < matrix.length) {
                paintBucketFill(matrix, row+1, col, colour, original);
            }
            if (col < matrix[0].length) {
                paintBucketFill(matrix, row, col+1, colour, original);
            }
            if (row > 0) {
                paintBucketFill(matrix, row-1, col, colour, original);
            }
            if (col > 0) {
                paintBucketFill(matrix, row, col-1, colour, original);
            }
        }
    }

    public void paintBucketFill(int[][] matrix, int row, int col, int colour) {
        int original_colour = matrix[row][col];
        if (original_colour != colour) {
            paintBucketFill(matrix, row, col, colour, original_colour);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[][] colourMatrix = {
            {1, 1, 1, 1, 2, 2, 2, 1},
            {1, 1, 1, 0, 0, 0, 0, 2},
            {2, 1, 0, 0, 0, 0, 2, 2},
            {1, 0, 0, 0, 0, 0, 2, 2},
            {2, 0, 0, 2, 2, 2, 1, 1},
            {2, 0, 0, 2, 2, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 2}
        };
        System.out.println("Before fill...");
        main.printMatrix(colourMatrix);
        System.out.println();
        main.paintBucketFill(colourMatrix, 2, 3, 2);
        System.out.println("After fill...");
        main.printMatrix(colourMatrix);
    }
}
