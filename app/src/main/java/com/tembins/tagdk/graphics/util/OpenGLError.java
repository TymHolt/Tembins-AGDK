package com.tembins.tagdk.graphics.util;

import android.opengl.GLES20;

/**
 * Represents an OpenGL error code.
 */
public final class OpenGLError {

    public final int code;
    public final String category;

    /**
     * Initializes with the given error code.
     *
     * @param errorCode The code to represent.
     */
    public OpenGLError(final int errorCode) {
        code = errorCode;
        category = getCodeCategory(errorCode);
    }

    /**
     * Creates a string representation of the given error code. Returns "Unknown Error" if the code
     * is not known or not valid.
     *
     * @param errorCode The error code.
     * @return A string representation of the error code.
     */
    private static String getCodeCategory(final int errorCode) {
        switch(errorCode) {
            case GLES20.GL_NO_ERROR: return "GL_NO_ERROR";
            case GLES20.GL_INVALID_ENUM: return "GL_INVALID_ENUM";
            case GLES20.GL_INVALID_VALUE: return "GL_INVALID_VALUE";
            case GLES20.GL_INVALID_OPERATION: return "GL_INVALID_OPERATION";
            case GLES20.GL_OUT_OF_MEMORY: return "GL_OUT_OF_MEMORY";
            case GLES20.GL_INVALID_FRAMEBUFFER_OPERATION: return "GL_INVALID_FRAMEBUFFER_OPERATION";
            default: return "Unknown Error";
        }
    }
}
