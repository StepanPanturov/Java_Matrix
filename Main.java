public class Main {
    public static void main(String[] arg) {
        Matrix a = new Matrix(2, 2);
        System.out.println("Матрица A:");
        a.completion();
        a.print_matrix();

        Matrix b = new Matrix(2, 2);
        System.out.println("Матрица B:");
        b.completion();
        b.print_matrix();

        Matrix t = b.trans();
        System.out.println("Транспонированная матрица B:");
        t.print_matrix();

        Matrix s = b.sum(a);
        System.out.println("Матрица S = A + B:");
        s.print_matrix();

        Matrix d = a.differ(b);
        System.out.println("Матрица D = A - B:");
        d.print_matrix();

        Matrix p = a.product(b);
        System.out.println("Матрица P = A * B:");
        p.print_matrix();
    }
}
