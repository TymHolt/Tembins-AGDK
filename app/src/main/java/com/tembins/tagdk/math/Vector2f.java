package com.tembins.tagdk.math;

/**
 * Represents a two-dimensional vector, with final fields x and y.
 */
public final class Vector2f {

    public final float x, y;

    /**
     * Initializes the vector with the given input.
     *
     * @param x The value for x.
     * @param y The value for y.
     */
    public Vector2f(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns this vector, with its x and y field added to the given x and y field respectively.
     *
     * @param x The value to add to this vectors x field.
     * @param y The value to add to this vectors y field.
     * @return A vector with the resulting added fields.
     */
    public Vector2f add(final float x, final float y) {
        return new Vector2f(this.x + x, this.y + y);
    }

    /**
     * Returns this vector, with its x and y field added to the given vectors x and y field respectively.
     *
     * @param vector The vector to add the x and y fields with.
     * @return A vector with the resulting added fields.
     */
    public Vector2f add(final Vector2f vector) {
        return add(vector.x, vector.y);
    }

    /**
     * Returns this vector, with its x and y field both added to the given value.
     *
     * @param value The value to add to this vectors x and y fields.
     * @return A vector with the resulting added fields.
     */
    public Vector2f add(final float value) {
        return add(value, value);
    }

    /**
     * Returns this vector, with its x and y field subtracted by the given x and y field respectively.
     *
     * @param x The value to subtract this vectors x field by.
     * @param y The value to subtract this vectors y field by.
     * @return A vector with the resulting subtracted fields.
     */
    public Vector2f sub(final float x, final float y) {
        return new Vector2f(this.x - x, this.y - y);
    }

    /**
     * Returns this vector, with its x and y field subtracted by the given vectors x and y field respectively.
     *
     * @param vector The vector to subtract the x and y fields by.
     * @return A vector with the resulting subtracted fields.
     */
    public Vector2f sub(final Vector2f vector) {
        return sub(vector.x, vector.y);
    }

    /**
     * Returns this vector, with its x and y field both subtracted by the given value.
     *
     * @param value The value to subtract this vectors x and y fields by.
     * @return A vector with the resulting subtracted fields.
     */
    public Vector2f sub(final float value) {
        return sub(value, value);
    }

    /**
     * Returns this vector, with its x and y field multiplied by the given x and y field respectively.
     *
     * @param x The value to multiply this vectors x field by.
     * @param y The value to multiply this vectors y field by.
     * @return A vector with the resulting added fields.
     */
    public Vector2f mul(final float x, final float y) {
        return new Vector2f(this.x * x, this.y * y);
    }

    /**
     * Returns this vector, with its x and y field multiplied by the given vectors x and y field respectively.
     *
     * @param vector The vector to multiply the x and y fields by.
     * @return A vector with the resulting multiplied fields.
     */
    public Vector2f mul(final Vector2f vector) {
        return mul(vector.x, vector.y);
    }

    /**
     * Returns this vector, with its x and y field both multiplied by the given factor.
     *
     * @param value The factor to multiply this vectors x and y fields by.
     * @return A vector with the resulting multiplied fields.
     */
    public Vector2f mul(final float value) {
        return mul(value, value);
    }

    /**
     * Returns this vector, with its x and y field divided by the given x and y field respectively.
     *
     * @param x The value to divide this vectors x field by.
     * @param y The value to divide this this vectors y field by.
     * @return A vector with the divided fields.
     */
    public Vector2f div(final float x, final float y) {
        return new Vector2f(this.x / x, this.y / y);
    }

    /**
     * Returns this vector, with its x and y field divided by the given vectors x and y field respectively.
     *
     * @param vector The vector to divide the x and y fields by.
     * @return A vector with the divided fields.
     */
    public Vector2f div(final Vector2f vector) {
        return div(vector.x, vector.y);
    }

    /**
     * Returns this vector, with its x and y field both divided by the given value.
     *
     * @param value The value to divide this vectors x and y fields by.
     * @return A vector with the divided fields.
     */
    public Vector2f div(final float value) {
        return div(value, value);
    }

    /**
     * Returns the length of the vector.
     *
     * @return The vectors length.
     */
    public float length() {
        return x * x + y * y;
    }

    /**
     * Returns this vector with normalized fields, thus having a length of 1. If this vector has a length of 0, the
     * returned vector will also have a length of 0.
     *
     * @return This vector but normalized.
     */
    public Vector2f normalize() {
        final float length = length();
        return div(length != 0.0f ? length : 1.0f);
    }

    /**
     * Calculates the dot product between this vector and the given vector.
     *
     * @param vector The vector to calculate the dot product with,
     * @return The dot product of the two vectors.
     */
    public float dot(final Vector2f vector) {
        return x * vector.x + y * vector.y;
    }
}
