package com.tembins.tagdk.graphics.util;

import android.opengl.GLES20;
import android.util.Log;

/**
 * Provides utility methods for dealing with OpenGL.
 */
public class OpenGLUtil {

    /**
     * Returns the oldest OpenGL error code if one exists. If none exists, GL_NO_ERROR will be
     * returned.
     *
     * @return The oldest OpenGL error code.
     */
    public static int getRawError() {
        return GLES20.glGetError();
    }

    /**
     * Returns the oldest OpenGL error if one exists. If none exists, null is returned.
     *
     *  @return The oldest OpenGL error or null if none exists.
     */
    public static OpenGLError getError() {
        final int rawErrorCode = getRawError();

        if(rawErrorCode == GLES20.GL_NO_ERROR)
            return null;

        return new OpenGLError(rawErrorCode);
    }

    /**
     * Clears all still existing OpenGL error codes.
     */
    public static void clearErrors(final boolean logErrors) {
        OpenGLError error = null;
        while((error = getError()) != null)
            Log.e("OpenGLUtil", "Encountered error while clearing error codes: " + error.category);
    }
}
