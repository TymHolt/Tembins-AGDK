package com.tembins.tagdk.math;

/**
 * Represents a three-dimensional vector, with final fields x, y and z.
 */
public final class Vector3f {

    public final float x, y, z;

    /**
     * Initializes the vector with the given input.
     *
     * @param x The value for x.
     * @param y The value for y.
     * @param z The value for z.          
     */
    public Vector3f(final float x, final float y, final float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns this vector, with its x, y and z field added to the given x, y and z field
     * respectively.
     *
     * @param x The value to add to this vectors x field.
     * @param y The value to add to this vectors y field.
     * @param z The value to add to this vectors z field.
     * @return A vector with the resulting added fields.
     */
    public Vector3f add(final float x, final float y, final float z) {
        return new Vector3f(this.x + x, this.y + y, this.z + z);
    }

    /**
     * Returns this vector, with its x, y and z field added to the given x, y and z field
     * respectively.
     *
     * @param vector The vector to add the x, y and z fields with.
     * @return A vector with the resulting added fields.
     */
    public Vector3f add(final Vector3f vector) {
        return add(vector.x, vector.y, vector.z);
    }

    /**
     * Returns this vector, with its x, y and z field all added to the given value.
     *
     * @param value The value to add to this vectors x, y and z fields.
     * @return A vector with the resulting added fields.
     */
    public Vector3f add(final float value) {
        return add(value, value, value);
    }

    /**
     * Returns this vector, with its x, y and z field subtracted by the given x, y and z field
     * respectively.
     *
     * @param x The value to subtract this vectors x field by.
     * @param y The value to subtract this vectors y field by.
     * @param z The value to subtract this vectors z field by.
     * @return A vector with the resulting subtracted fields.
     */
    public Vector3f sub(final float x, final float y, final float z) {
        return new Vector3f(this.x - x, this.y - y, this.z - z);
    }

    /**
     * Returns this vector, with its x, y and z field subtracted by the given vectors x, y and z
     * field respectively.
     *
     * @param vector The vector to subtract the x, y and z fields by.
     * @return A vector with the resulting subtracted fields.
     */
    public Vector3f sub(final Vector3f vector) {
        return sub(vector.x, vector.y, vector.z);
    }

    /**
     * Returns this vector, with its x, y and z field all subtracted by the given value.
     *
     * @param value The value to subtract this vectors x, y and z fields by.
     * @return A vector with the resulting subtracted fields.
     */
    public Vector3f sub(final float value) {
        return sub(value, value, value);
    }

    /**
     * Returns this vector, with its x, y and z field multiplied by the given x, y and z field
     * respectively.
     *
     * @param x The value to multiply this vectors x field by.
     * @param y The value to multiply this vectors y field by.
     * @param z The value to multiply this vectors z field by.
     * @return A vector with the resulting added fields.
     */
    public Vector3f mul(final float x, final float y, final float z) {
        return new Vector3f(this.x * x, this.y * y, this.z * z);
    }

    /**
     * Returns this vector, with its x, y and z field multiplied by the given vectors x, y and z
     * field respectively.
     *
     * @param vector The vector to multiply the x, y and z fields by.
     * @return A vector with the resulting multiplied fields.
     */
    public Vector3f mul(final Vector3f vector) {
        return mul(vector.x, vector.y, vector.z);
    }

    /**
     * Returns this vector, with its x, y and z fields all multiplied by the given factor.
     *
     * @param value The factor to multiply this vectors x, y and z fields by.
     * @return A vector with the resulting multiplied fields.
     */
    public Vector3f mul(final float value) {
        return mul(value, value, value);
    }

    /**
     * Returns this vector, with its x, y and z field divided by the given x, y and z field
     * respectively.
     *
     * @param x The value to divide this vectors x field by.
     * @param y The value to divide this this vectors y field by.
     * @param z The value to divide this this vectors z field by.
     * @return A vector with the divided fields.
     */
    public Vector3f div(final float x, final float y, final float z) {
        return new Vector3f(this.x / x, this.y / y, this.z / z);
    }

    /**
     * Returns this vector, with its x, y and z fields divided by the given vectors x, y and z field
     * respectively.
     *
     * @param vector The vector to divide the x, y and z fields by.
     * @return A vector with the divided fields.
     */
    public Vector3f div(final Vector3f vector) {
        return div(vector.x, vector.y, vector.z);
    }

    /**
     * Returns this vector, with its x, y and z fields all divided by the given value.
     *
     * @param value The value to divide this vectors x, y and z fields by.
     * @return A vector with the divided fields.
     */
    public Vector3f div(final float value) {
        return div(value, value, value);
    }

    /**
     * Returns the length of the vector.
     *
     * @return The vectors length.
     */
    public float length() {
        return x * x + y * y + z * z;
    }

    /**
     * Returns this vector with normalized fields, thus having a length of 1. If this vector has a length of 0, the
     * returned vector will also have a length of 0.
     *
     * @return This vector but normalized.
     */
    public Vector3f normalize() {
        final float length = length();
        return div(length != 0.0f ? length : 1.0f);
    }

    /**
     * Calculates the dot product between this vector and the given vector.
     *
     * @param vector The vector to calculate the dot product with,
     * @return The dot product of the two vectors.
     */
    public float dot(final Vector3f vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }
}
