import java.util.Arrays;

public class Matrix {

    private final double[][] data;

    /* =======================
       Constructor
       ======================= */
    public Matrix(double[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Matrix cannot be empty");
        }

        this.data = new double[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, data[0].length);
        }
    }

    /* =======================
       Dimension helpers
       ======================= */
    public int rows() {
        return data.length;
    }

    public int cols() {
        return data[0].length;
    }

    /* =======================
       Safe getter
       ======================= */
    public double[][] getCopy() {
        double[][] copy = new double[rows()][cols()];
        for (int i = 0; i < rows(); i++) {
            System.arraycopy(data[i], 0, copy[i], 0, cols());
        }
        return copy;
    }

    /* =======================
       Validation
       ======================= */
    private void checkSameSize(Matrix other) {
        if (rows() != other.rows() || cols() != other.cols()) {
            throw new IllegalArgumentException("Matrices must have same dimensions");
        }
    }

    /* =======================
       Basic operations
       ======================= */
    public Matrix add(Matrix other) {
        checkSameSize(other);
        double[][] re = new double[rows()][cols()];

        for (int i = 0; i < rows(); i++)
            for (int j = 0; j < cols(); j++)
                re[i][j] = data[i][j] + other.data[i][j];

        return new Matrix(re);
    }

    public Matrix sub(Matrix other) {
        checkSameSize(other);
        double[][] re = new double[rows()][cols()];

        for (int i = 0; i < rows(); i++)
            for (int j = 0; j < cols(); j++)
                re[i][j] = data[i][j] - other.data[i][j];

        return new Matrix(re);
    }

    public Matrix scale(double scalar) {
        double[][] re = new double[rows()][cols()];

        for (int i = 0; i < rows(); i++)
            for (int j = 0; j < cols(); j++)
                re[i][j] = data[i][j] * scalar;

        return new Matrix(re);
    }

    /* =======================
       Matrix multiplication
       ======================= */
    public Matrix matMul(Matrix other) {
        if (cols() != other.rows()) {
            throw new IllegalArgumentException("Invalid matrix dimensions");
        }

        double[][] re = new double[rows()][other.cols()];

        for (int i = 0; i < rows(); i++)
            for (int j = 0; j < other.cols(); j++)
                for (int k = 0; k < cols(); k++)
                    re[i][j] += data[i][k] * other.data[k][j];

        return new Matrix(re);
    }

    /* =======================
       Overrides
       ======================= */
    @Override
    public String toString() {
        return Arrays.deepToString(data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Matrix)) return false;
        Matrix other = (Matrix) obj;
        return Arrays.deepEquals(data, other.data);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(data);
    }
}
