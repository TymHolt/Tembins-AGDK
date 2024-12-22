package com.tembins.tagdk.math;

/**
 * Resembles a 3 by 3 matrix and allows mathematical operations with it.
 */
public final class Matrix3f {

    public final float v00, v01, v02;
    public final float v10, v11, v12;
    public final float v20, v21, v22;

    /**
     * Initializes the matrix with the given field values. The matrix will look like this:
     *
     * | v00 v01 v02 |
     * | v10 v11 v12 |
     * | v20 v21 v22 |
     *
     * @param v00 A field value.
     * @param v01 A field value.
     * @param v02 A field value.
     * @param v10 A field value.
     * @param v11 A field value.
     * @param v12 A field value.
     * @param v20 A field value.
     * @param v21 A field value.
     * @param v22 A field value.
     */
    public Matrix3f(
            final float v00, final float v01, final float v02,
            final float v10, final float v11, final float v12,
            final float v20, final float v21, final float v22) {
        this.v00 = v00;
        this.v01 = v01;
        this.v02 = v02;
        this.v10 = v10;
        this.v11 = v11;
        this.v12 = v12;
        this.v20 = v20;
        this.v21 = v21;
        this.v22 = v22;
    }

    /**
     * Returns the matrix multiplication between this matrix and a given one. It is the
     * mathematical equivalent of (ThisMatrix * GivenMatrix).
     *
     * @param matrix The matrix to multiply with.
     * @return The resulting multiplied matrix.
     */
    public Matrix3f mul(final Matrix3f matrix) {
        return new Matrix3f(
                v00 * matrix.v00 + v01 * matrix.v10 + v02 * matrix.v20,
                v00 * matrix.v01 + v01 * matrix.v11 + v02 * matrix.v21,
                v00 * matrix.v02 + v01 * matrix.v12 + v02 * matrix.v22,

                v10 * matrix.v00 + v11 * matrix.v10 + v12 * matrix.v20,
                v10 * matrix.v01 + v11 * matrix.v11 + v12 * matrix.v21,
                v10 * matrix.v02 + v11 * matrix.v12 + v12 * matrix.v22,

                v20 * matrix.v00 + v21 * matrix.v10 + v22 * matrix.v20,
                v20 * matrix.v01 + v21 * matrix.v11 + v22 * matrix.v21,
                v20 * matrix.v02 + v21 * matrix.v12 + v22 * matrix.v22);
    }

    /**
     * Returns the vector-matrix multiplication between this matrix and a given vector. It is the
     * mathematical equivalent of (ThisMatrix * GivenVector), hereby interpreting the vector as a
     * column vector/matrix.
     *
     * @param vector The (column) vector to multiply with.
     * @return The resulting vector.
     */
    public Vector3f mul(final Vector3f vector) {
        return new Vector3f(
                v00 * vector.x + v01 * vector.y + v02 * vector.z,
                v10 * vector.x + v11 * vector.y + v12 * vector.z,
                v20 * vector.x + v21 * vector.y + v22 * vector.z);
    }

    /**
     * Returns this matrix as a one-dimensional array. The matrices values are stored in row-major
     * order.
     *
     * @return The matrices values mapped as a float array.
     */
    public float[] asArray() {
        return new float[] {
                v00, v01, v02,
                v10, v11, v12,
                v20, v21, v22
        };
    }
}
