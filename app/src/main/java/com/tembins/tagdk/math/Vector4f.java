package com.tembins.tagdk.math;

/**
 * Represents a four-dimensional vector, with final fields x, y, z and w.
 */
public final class Vector4f {

    public final float x, y, z, w;

    /**
     * Initializes the vector with the given input.
     *
     * @param x The value for x.
     * @param y The value for y.
     * @param z The value for z.
     * @param z The value for w.
     */
    public Vector4f(final float x, final float y, final float z, final float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Returns this vector, with its x, y, z and w fields added to the given x, y, z and w field
     * respectively.
     *
     * @param x The value to add to this vectors x field.
     * @param y The value to add to this vectors y field.
     * @param z The value to add to this vectors z field.
     * @param w The value to add to this vectors z field.
     * @return A vector with the resulting added fields.
     */
    public Vector4f add(final float x, final float y, final float z, float w) {
        return new Vector4f(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    /**
     * Returns this vector, with its x, y, z and w fields added to the given x, y, z and w fields
     * respectively.
     *
     * @param vector The vector to add the x, y, z and w fields with.
     * @return A vector with the resulting added fields.
     */
    public Vector4f add(final Vector4f vector) {
        return add(vector.x, vector.y, vector.z, vector.w);
    }

    /**
     * Returns this vector, with its x, y, z and w field all added to the given value.
     *
     * @param value The value to add to this vectors x, y, z and w fields.
     * @return A vector with the resulting added fields.
     */
    public Vector4f add(final float value) {
        return add(value, value, value, value);
    }

    /**
     * Returns this vector, with its x, y, z and w field subtracted by the given x, y, z and w field
     * respectively.
     *
     * @param x The value to subtract this vectors x field by.
     * @param y The value to subtract this vectors y field by.
     * @param z The value to subtract this vectors z field by.
     * @param w The value to subtract this vectors w field by.
     * @return A vector with the resulting subtracted fields.
     */
    public Vector4f sub(final float x, final float y, final float z, final float w) {
        return new Vector4f(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    /**
     * Returns this vector, with its x, y, z and w fields subtracted by the given vectors x, y, z
     * and w field respectively.
     *
     * @param vector The vector to subtract the x, y, z and w fields by.
     * @return A vector with the resulting subtracted fields.
     */
    public Vector4f sub(final Vector4f vector) {
        return sub(vector.x, vector.y, vector.z, vector.w);
    }

    /**
     * Returns this vector, with its x, y, z and w fields all subtracted by the given value.
     *
     * @param value The value to subtract this vectors x, y, z and w fields by.
     * @return A vector with the resulting subtracted fields.
     */
    public Vector4f sub(final float value) {
        return sub(value, value, value, value);
    }

    /**
     * Returns this vector, with its x, y, z and w field multiplied by the given x, y, z and w field
     * respectively.
     *
     * @param x The value to multiply this vectors x field by.
     * @param y The value to multiply this vectors y field by.
     * @param z The value to multiply this vectors z field by.
     * @param w The value to multiply this vectors z field by.
     * @return A vector with the resulting added fields.
     */
    public Vector4f mul(final float x, final float y, final float z, final float w) {
        return new Vector4f(this.x * x, this.y * y, this.z * z, this.w * w);
    }

    /**
     * Returns this vector, with its x, y, z and w field multiplied by the given vectors x, y, z
     * and w field respectively.
     *
     * @param vector The vector to multiply the x, y, z and w fields by.
     * @return A vector with the resulting multiplied fields.
     */
    public Vector4f mul(final Vector4f vector) {
        return mul(vector.x, vector.y, vector.z, vector.w);
    }

    /**
     * Returns this vector, with its x, y, z and w fields all multiplied by the given factor.
     *
     * @param value The factor to multiply this vectors x, y, z and w fields by.
     * @return A vector with the resulting multiplied fields.
     */
    public Vector4f mul(final float value) {
        return mul(value, value, value, value);
    }

    /**
     * Returns this vector, with its x, y, z and w field divided by the given x, y, z and w field
     * respectively.
     *
     * @param x The value to divide this vectors x field by.
     * @param y The value to divide this this vectors y field by.
     * @param z The value to divide this this vectors z field by.
     * @param w The value to divide this this vectors w field by.
     * @return A vector with the divided fields.
     */
    public Vector4f div(final float x, final float y, final float z, final float w) {
        return new Vector4f(this.x / x, this.y / y, this.z / z, this.w / w);
    }

    /**
     * Returns this vector, with its x, y and z fields divided by the given vectors x, y, z and w
     * field respectively.
     *
     * @param vector The vector to divide the x, y, z and w fields by.
     * @return A vector with the divided fields.
     */
    public Vector4f div(final Vector4f vector) {
        return div(vector.x, vector.y, vector.z, vector.w);
    }

    /**
     * Returns this vector, with its x, y, z and w fields all divided by the given value.
     *
     * @param value The value to divide this vectors x, y, z and w fields by.
     * @return A vector with the divided fields.
     */
    public Vector4f div(final float value) {
        return div(value, value, value, value);
    }

    /**
     * Returns the length of the vector.
     *
     * @return The vectors length.
     */
    public float length() {
        return x * x + y * y + z * z + w * w;
    }

    /**
     * Returns this vector with normalized fields, thus having a length of 1. If this vector has a length of 0, the
     * returned vector will also have a length of 0.
     *
     * @return This vector but normalized.
     */
    public Vector4f normalize() {
        final float length = length();
        return div(length != 0.0f ? length : 1.0f);
    }

    /**
     * Calculates the dot product between this vector and the given vector.
     *
     * @param vector The vector to calculate the dot product with,
     * @return The dot product of the two vectors.
     */
    public float dot(final Vector4f vector) {
        return x * vector.x + y * vector.y + z * vector.z + w * vector.w;
    }
}
