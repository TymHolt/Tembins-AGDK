package com.tembins.tagdk.graphics.resource;

import android.opengl.GLES20;

/**
 * Provides static wrappers for OpenGL texture flags.
 */
public final class TextureParameter {

    /**
     * The wrap mode of a texture, meaning its behavior if the uv coordinates are outside the
     * normalized space (0.0 - 1.0).
     */
    public enum WRAP {
        /**
         * Will repeat the texture if the uv coordinates are outside the normalized space.
         */
        REPEAT(GLES20.GL_REPEAT),

        /**
         * Will return the textures edge colors if the uv coordinates are outside the normalized
         * space.
         */
        CLAMP_TO_EDGE(GLES20.GL_CLAMP_TO_EDGE);

        public final int openGLID;

        WRAP(final int openGLID) {
            this.openGLID = openGLID;
        }
    }

    /**
     * The behavior of the texture when it gets up- or downscaled while rendering.
     */
    public enum FILTER {
        /**
         * WIll interpolate the colors.
         */
        LINEAR(GLES20.GL_LINEAR),

        /**
         * Will not interpolate and just use the nearest full color.
         */
        NEAREST(GLES20.GL_NEAREST);

        public final int openGLID;

        FILTER(final int openGLID) {
            this.openGLID = openGLID;
        }
    }
}
