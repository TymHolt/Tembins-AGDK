package com.tembins.tagdk.graphics.resource.tasks;

import com.tembins.tagdk.graphics.util.OpenGLError;

import java.io.IOException;

/**
 * Is used to give error feedback to the GraphicsResourceManager when executing loading tasks.
 */
public class ResourceLoadingException extends Exception {

    /**
     * Creates the exception with an error message built from the given parameters.
     *
     * @param resourceType The resource type that was failed to load.
     * @param resourceID The resource ID that was failed to load.
     * @param description A description of what went wrong.
     */
    public ResourceLoadingException(final ResourceType resourceType, final int resourceID, final String description) {
        super("Failed to load " + resourceType.name() + " (ID " + resourceID + "): " + description);
    }

    /**
     * Creates the exception with an error message built from the given parameters.
     *
     * @param resourceType The resource type that was failed to load.
     * @param resourceID The resource ID that was failed to load.
     * @param openGLError The error encountered.
     */
    public ResourceLoadingException(final ResourceType resourceType, final int resourceID, final OpenGLError openGLError) {
        this(resourceType, resourceID, "Unhandled OpenGL error " + openGLError.category);
    }

    /**
     * Creates the exception with an error message built from the given parameters.
     *
     * @param resourceType The resource type that was failed to load.
     * @param resourceID The resource ID that was failed to load.
     * @param ioException The IOException encountered.
     */
    public ResourceLoadingException(final ResourceType resourceType, final int resourceID, final IOException ioException) {
        this(resourceType, resourceID, "IOException encountered: " + ioException.getMessage());
    }
}
