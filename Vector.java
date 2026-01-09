import java.util.Arrays;

public class Vector {

    private final double[] data;

    /* =======================
       Constructor
       ======================= */
    public Vector(double[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Vector cannot be empty");
        }
        this.data = Arrays.copyOf(data, data.length);
    }

    /* =======================
       Helpers
       ======================= */
    public int size() {
        return data.length;
    }

    public double[] getCopy() {
        return Arrays.copyOf(data, data.length);
    }

    private void checkSameSize(Vector other) {
        if (size() != other.size()) {
            throw new IllegalArgumentException("Vectors must have same size");
        }
    }

    /* =======================
       Operations
       ======================= */
    public Vector add(Vector other) {
        checkSameSize(other);
        double[] re = new double[size()];

        for (int i = 0; i < size(); i++)
            re[i] = data[i] + other.data[i];

        return new Vector(re);
    }

    public Vector sub(Vector other) {
        checkSameSize(other);
        double[] re = new double[size()];

        for (int i = 0; i < size(); i++)
            re[i] = data[i] - other.data[i];

        return new Vector(re);
    }

    public Vector scale(double scalar) {
        double[] re = new double[size()];

        for (int i = 0; i < size(); i++)
            re[i] = data[i] * scalar;

        return new Vector(re);
    }

    public double dot(Vector other) {
        checkSameSize(other);
        double sum = 0;

        for (int i = 0; i < size(); i++)
            sum += data[i] * other.data[i];

        return sum;
    }

    public double magnitude() {
        return Math.sqrt(dot(this));
    }

    public Vector normalize() {
        double mag = magnitude();
        if (mag == 0) {
            throw new ArithmeticException("Cannot normalize zero vector");
        }
        return scale(1.0 / mag);
    }

    /* =======================
       Overrides
       ======================= */
    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vector)) return false;
        Vector other = (Vector) obj;
        return Arrays.equals(data, other.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}
