import java.util.Random;


public class Matrix {
    private int row, col;
    private ComplexNumber[][] elem;
    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.elem = new ComplexNumber[row][col];
    }

    public void completion() {
        Random random  = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.elem[i][j] = new ComplexNumber(random.nextInt(-10,11), random.nextInt(-10,11));
            }
        }
    }

    public void initial(int row, int col, ComplexNumber num) {
        elem[row][col] = num;
    }

    public Matrix sum(Matrix other) {
        if (this.row != other.row || this.col != other.col) {
            System.out.println("Ошибка: матрицы имеют разный размер.");
            return null;
        }
        Matrix newMatrix = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newMatrix.initial(i, j, this.elem[i][j].add(other.elem[i][j]));
            }
        }
        return newMatrix;
    }

    public Matrix differ(Matrix other) {
        if (this.row != other.row || this.col != other.col) {
            System.out.println("Ошибка: матрицы имеют разный размер.");
            return null;
        }
        Matrix newMatrix = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newMatrix.initial(i, j, this.elem[i][j].sub(other.elem[i][j]));
            }
        }
        return newMatrix;
    }

    public Matrix trans() {
        Matrix newMatrix = new Matrix(col, row);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newMatrix.initial(j, i, this.elem[i][j]);
            }
        }
        return newMatrix;
    }

    public Matrix product(Matrix other) {
        if (this.col != other.row) {
            System.out.println("Ошибка: количество столбцов в первой матрице не равно количеству строк во второй матрице.");
            return null;
        }
        Matrix newMatrix = new Matrix(this.row, other.col);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < other.col; j++) {
                ComplexNumber sum_elem = new ComplexNumber(0, 0);
                for (int k = 0; k < this.col; k++) {
                    sum_elem = sum_elem.add(this.elem[i][k].mult(other.elem[k][j]));
                }
                newMatrix.initial(i, j, sum_elem);
            }
        }
        return newMatrix;
    }

    public void print_matrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("\t");
                elem[i][j].print_elem();
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
