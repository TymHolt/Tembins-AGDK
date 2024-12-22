package com.tembins.tagdk.graphics.resource.tasks;

import android.content.Context;
import android.opengl.GLES20;

import com.tembins.tagdk.graphics.util.OpenGLError;
import com.tembins.tagdk.graphics.util.OpenGLUtil;
import com.tembins.tagdk.util.resource.TextResourceLoader;

import java.io.IOException;

/**
 * This class represents a task which, when executed, loads a shader program from its source files
 * in the resource directory.
 */
public final class ShaderLoadingTask implements LoadingTask{

    private final int vertexShaderResourceID, fragmentShaderResourceID;

    /**
     * Initializes the task with the following parameters:
     *
     * @param vertexShaderResourceID The resource ID of the vertex shader to load.
     * @param fragmentShaderResourceID The resource ID of the fragment shader to load.
     */
    public ShaderLoadingTask(final int vertexShaderResourceID, final int fragmentShaderResourceID) {
        this.vertexShaderResourceID = vertexShaderResourceID;
        this.fragmentShaderResourceID = fragmentShaderResourceID;
    }

    /**
     * Executes the task, thus loading the shaders. This method will erase all recent OpenGL errors
     * as it tries to give as much feedback as possible should the loading fail. Note that all
     * errors regarding the shader program itself will be reported using the vertex shaders
     * resource ID.
     *
     * @param context The app context for accessing the resource directory.
     * @return The OpenGL ID of the loaded shader program.
     * @throws ResourceLoadingException If something goes wrong.
     */
    @Override
    public int load(final Context context) throws ResourceLoadingException {
        OpenGLUtil.clearErrors(true);

        final int vertexShaderID = loadShader(context, GLES20.GL_VERTEX_SHADER, vertexShaderResourceID);
        final int fragmentShaderID = loadShader(context, GLES20.GL_FRAGMENT_SHADER, fragmentShaderResourceID);
        final int programID = GLES20.glCreateProgram();

        GLES20.glAttachShader(programID, vertexShaderID);
        GLES20.glAttachShader(programID, fragmentShaderID);
        GLES20.glLinkProgram(programID);

        final int[] linkSuccess = new int[1];
        GLES20.glGetProgramiv(programID, GLES20.GL_LINK_STATUS, linkSuccess, 0);

        if(linkSuccess[0] == GLES20.GL_FALSE) {
            final String log = GLES20.glGetProgramInfoLog(programID);
            GLES20.glDeleteProgram(programID);
            GLES20.glDeleteShader(vertexShaderID);
            GLES20.glDeleteShader(fragmentShaderID);
            throw new ResourceLoadingException(ResourceType.SHADER, vertexShaderResourceID, "Linking log: " + log);
        }

        // The shaders itself are no longer needed after linking
        GLES20.glDetachShader(programID, vertexShaderID);
        GLES20.glDetachShader(programID, fragmentShaderID);
        GLES20.glDeleteShader(vertexShaderID);
        GLES20.glDeleteShader(fragmentShaderID);

        final OpenGLError openGLError = OpenGLUtil.getError();
        if(openGLError != null)
            throw new ResourceLoadingException(ResourceType.SHADER, vertexShaderResourceID, openGLError);

        return programID;
    }

    /**
     * Loads and compiles a single shader, either a vertex or fragment shader, from a given resource
     * ID.
     *
     * @param context The context to access the resources.
     * @param shaderType The OpenGL ID of the shader type to load.
     * @param resourceID The resource ID to load.
     * @return The OpenGL ID of the loaded shader.
     * @throws ResourceLoadingException If loading or compilation fails.
     */
    private static int loadShader(final Context context, final int shaderType, final int resourceID)
            throws ResourceLoadingException {
        try {
            final String shaderSource = TextResourceLoader.loadTextResource(context, resourceID);
            final int shaderID = GLES20.glCreateShader(shaderType);
            GLES20.glShaderSource(shaderID, shaderSource);
            GLES20.glCompileShader(shaderID);

            // Shader compilation will not result in an OpenGL error, separate checks needed:
            final int[] compileSuccess = new int[1];
            GLES20.glGetShaderiv(shaderID, GLES20.GL_COMPILE_STATUS, compileSuccess, 0);

            if(compileSuccess[0] == GLES20.GL_FALSE) {
                final String log = GLES20.glGetShaderInfoLog(shaderID);
                throw new ResourceLoadingException(ResourceType.SHADER, resourceID, "Compilation log: " + log);
            }

            return shaderID;
        } catch(IOException ioException) {
            throw new ResourceLoadingException(ResourceType.SHADER, resourceID, ioException);
        }
    }

    /**
     * Returns the resource type this task loads.
     *
     * @return ResourceType.SHADER
     */
    @Override
    public ResourceType getLoadedResourceType() {
        return ResourceType.SHADER;
    }
}
