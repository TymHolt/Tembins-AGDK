package com.tembins.tagdk.math;

/**
 * Resembles a 2 by 2 matrix and allows mathematical operations with it.
 */
public final class Matrix2f {

    public final float v00, v01;
    public final float v10, v11;

    /**
     * Initializes the matrix with the given field values. The matrix will look like this:
     *
     * | v00 v01 |
     * | v10 v11 |
     *
     * @param v00 A field value.
     * @param v01 A field value.
     * @param v10 A field value.
     * @param v11 A field value.
     */
    public Matrix2f(
            final float v00, final float v01,
            final float v10, final float v11) {
        this.v00 = v00;
        this.v01 = v01;
        this.v10 = v10;
        this.v11 = v11;
    }

    /**
     * Returns the matrix multiplication between this matrix and a given one. It is the
     * mathematical equivalent of (ThisMatrix * GivenMatrix).
     *
     * @param matrix The matrix to multiply with.
     * @return The resulting multiplied matrix.
     */
    public Matrix2f mul(final Matrix2f matrix) {
        return new Matrix2f(
                v00 * matrix.v00 + v01 * matrix.v10,
                v00 * matrix.v01 + v01 * matrix.v11,

                v10 * matrix.v00 + v11 * matrix.v10,
                v10 * matrix.v01 + v11 * matrix.v11);
    }

    /**
     * Returns the vector-matrix multiplication between this matrix and a given vector. It is the
     * mathematical equivalent of (ThisMatrix * GivenVector), hereby interpreting the vector as a
     * column vector/matrix.
     *
     * @param vector The (column) vector to multiply with.
     * @return The resulting vector.
     */
    public Vector2f mul(final Vector2f vector) {
        return new Vector2f(
                v00 * vector.x + v01 * vector.y,
                v10 * vector.x + v11 * vector.y);
    }

    /**
     * Returns this matrix as a one-dimensional array. The matrices values are stored in row-major
     * order.
     *
     * @return The matrices values mapped as a float array.
     */
    public float[] asArray() {
        return new float[] {
                v00, v01,
                v10, v11
        };
    }
}
