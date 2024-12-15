package com.tembins.tagdk.math;

/**
 * Resembles a 4 by 4 matrix and allows mathematical operations with it.
 */
public class Matrix4f {

    public final float v00, v01, v02, v03;
    public final float v10, v11, v12, v13;
    public final float v20, v21, v22, v23;
    public final float v30, v31, v32, v33;

    /**
     * Initializes the matrix with the given field values. The matrix will look like this:
     *
     * | v00 v01 v02 v03 |
     * | v10 v11 v12 v13 |
     * | v20 v21 v22 v23 |
     * | v30 v31 v32 v33 |
     *
     * @param v00 A field value.
     * @param v01 A field value.
     * @param v02 A field value.
     * @param v03 A field value.
     * @param v10 A field value.
     * @param v11 A field value.
     * @param v12 A field value.
     * @param v13 A field value.
     * @param v20 A field value.
     * @param v21 A field value.
     * @param v22 A field value.
     * @param v23 A field value.
     * @param v30 A field value.
     * @param v31 A field value.
     * @param v32 A field value.
     * @param v33 A field value.
     */
    public Matrix4f(
            final float v00, final float v01, final float v02, final float v03,
            final float v10, final float v11, final float v12, final float v13,
            final float v20, final float v21, final float v22, final float v23,
            final float v30, final float v31, final float v32, final float v33) {
        this.v00 = v00;
        this.v01 = v01;
        this.v02 = v02;
        this.v03 = v03;
        this.v10 = v10;
        this.v11 = v11;
        this.v12 = v12;
        this.v13 = v13;
        this.v20 = v20;
        this.v21 = v21;
        this.v22 = v22;
        this.v23 = v23;
        this.v30 = v30;
        this.v31 = v31;
        this.v32 = v32;
        this.v33 = v33;
    }

    /**
     * Returns the matrix multiplication between this matrix and a given one. It is the
     * mathematical equivalent of (ThisMatrix * GivenMatrix).
     *
     * @param matrix The matrix to multiply with.
     * @return The resulting multiplied matrix.
     */
    public Matrix4f mul(final Matrix4f matrix) {
        return new Matrix4f(
                v00 * matrix.v00 + v01 * matrix.v10 + v02 * matrix.v20 + v03 * matrix.v30,
                v00 * matrix.v01 + v01 * matrix.v11 + v02 * matrix.v21 + v03 * matrix.v31,
                v00 * matrix.v02 + v01 * matrix.v12 + v02 * matrix.v22 + v03 * matrix.v32,
                v00 * matrix.v03 + v01 * matrix.v13 + v02 * matrix.v23 + v03 * matrix.v33,

                v10 * matrix.v00 + v11 * matrix.v10 + v12 * matrix.v20 + v13 * matrix.v30,
                v10 * matrix.v01 + v11 * matrix.v11 + v12 * matrix.v21 + v13 * matrix.v31,
                v10 * matrix.v02 + v11 * matrix.v12 + v12 * matrix.v22 + v13 * matrix.v32,
                v10 * matrix.v03 + v11 * matrix.v13 + v12 * matrix.v23 + v13 * matrix.v33,

                v20 * matrix.v00 + v21 * matrix.v10 + v22 * matrix.v20 + v23 * matrix.v30,
                v20 * matrix.v01 + v21 * matrix.v11 + v22 * matrix.v21 + v23 * matrix.v31,
                v20 * matrix.v02 + v21 * matrix.v12 + v22 * matrix.v22 + v23 * matrix.v32,
                v20 * matrix.v03 + v21 * matrix.v13 + v22 * matrix.v23 + v23 * matrix.v33,

                v30 * matrix.v00 + v31 * matrix.v10 + v32 * matrix.v20 + v33 * matrix.v30,
                v30 * matrix.v01 + v31 * matrix.v11 + v32 * matrix.v21 + v33 * matrix.v31,
                v30 * matrix.v02 + v31 * matrix.v12 + v32 * matrix.v22 + v33 * matrix.v32,
                v30 * matrix.v03 + v31 * matrix.v13 + v32 * matrix.v23 + v33 * matrix.v33);
    }

    /**
     * Returns the vector-matrix multiplication between this matrix and a given vector. It is the
     * mathematical equivalent of (ThisMatrix * GivenVector), hereby interpreting the vector as a
     * column vector/matrix.
     *
     * @param vector The (column) vector to multiply with.
     * @return The resulting vector.
     */
    public Vector4f mul(final Vector4f vector) {
        return new Vector4f(
                v00 * vector.x + v01 * vector.y + v02 * vector.z + v03 * vector.w,
                v10 * vector.x + v11 * vector.y + v12 * vector.z + v13 * vector.w,
                v20 * vector.x + v21 * vector.y + v22 * vector.z + v23 * vector.w,
                v30 * vector.x + v31 * vector.y + v32 * vector.z + v33 * vector.w);
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
