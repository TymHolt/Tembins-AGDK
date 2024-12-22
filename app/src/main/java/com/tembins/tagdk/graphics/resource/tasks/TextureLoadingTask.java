package com.tembins.tagdk.graphics.resource.tasks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

import com.tembins.tagdk.graphics.resource.TextureParameter;
import com.tembins.tagdk.graphics.util.OpenGLError;
import com.tembins.tagdk.graphics.util.OpenGLUtil;

/**
 * This class represents a task which, when executed, loads a texture from the resource directory.
 */
public final class TextureLoadingTask implements LoadingTask {

    private final int resourceID;
    private final TextureParameter.WRAP wrapParameter;
    private final TextureParameter.FILTER filterParameter;

    /**
     * Initializes the task with the following parameters:
     *
     * @param resourceID The ID of the resource to load as a texture.
     * @param wrapParameter How the loaded texture should behave when exceeding its bounds.
     * @param filterParameter How the loaded texture should behave when resizing.
     */
    public TextureLoadingTask(final int resourceID, final TextureParameter.WRAP wrapParameter,
                              final TextureParameter.FILTER filterParameter) {
        this.resourceID = resourceID;
        this.wrapParameter = wrapParameter;
        this.filterParameter = filterParameter;
    }

    /**
     * Executes the task, thus loading the texture. This method will erase all recent OpenGL errors
     * as it tries to give as much feedback as possible should the loading fail.
     *
     * @param context The app context for accessing the resource directory.
     * @return The OpenGL ID of the loaded texture.
     * @throws ResourceLoadingException If something goes wrong.
     */
    @Override
    public int load(final Context context) throws ResourceLoadingException {
        OpenGLUtil.clearErrors(true);

        final int[] textureIDs = new int[1];
        GLES20.glGenTextures(1, textureIDs, 0);
        int textureID = textureIDs[0];

        if(textureID == 0) {
            String description = "Texture generation failed!";
            final OpenGLError openGLError = OpenGLUtil.getError();

            if(openGLError != null)
                description += " (OpenGL Error " + openGLError.category + ")";

            throw new ResourceLoadingException(ResourceType.TEXTURE, resourceID, description);
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceID, options);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureID);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, wrapParameter.openGLID);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, wrapParameter.openGLID);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, filterParameter.openGLID);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, filterParameter.openGLID);

        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);
        bitmap.recycle();

        final OpenGLError openGLError = OpenGLUtil.getError();
        if(openGLError != null)
            throw new ResourceLoadingException(ResourceType.TEXTURE, resourceID, openGLError);

        return textureID;
    }

    /**
     * Returns the resource type this task loads.
     *
     * @return ResourceType.TEXTURE
     */
    @Override
    public ResourceType getLoadedResourceType() {
        return ResourceType.TEXTURE;
    }
}
