package com.tembins.tagdk.graphics.resource.tasks;

import android.content.Context;
import android.opengl.GLES30;

import com.tembins.tagdk.graphics.util.OpenGLError;
import com.tembins.tagdk.graphics.util.OpenGLUtil;
import com.tembins.tagdk.util.resource.TextResourceLoader;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * This class represents a task which, when executed, loads a mesh from the resource directory.
 */
public final class MeshLoadingTask implements LoadingTask {

    private final int resourceID;

    /**
     * Initializes the task with the following parameters:
     *
     * @param resourceID The resource to load the mesh from.
     */
    public MeshLoadingTask(final int resourceID) {
        this.resourceID = resourceID;
    }

    /**
     * Executes the task, thus loading the mesh. This method will erase all recent OpenGL errors
     * as it tries to give as much feedback as possible should the loading fail.
     *
     * @param context The app context for accessing the resource directory.
     * @return The OpenGL ID of the loaded mesh.
     * @throws ResourceLoadingException If something goes wrong.
     */
    @Override
    public int load(Context context) throws ResourceLoadingException {
        OpenGLUtil.clearErrors(true);

        try {
            final String objSource = TextResourceLoader.loadTextResource(context, resourceID);
            // TODO Integrate OBJ loader library
        } catch (IOException exception) {
            throw new ResourceLoadingException(ResourceType.MESH, resourceID, exception);
        }

        final OpenGLError openGLError = OpenGLUtil.getError();
        if(openGLError != null)
            throw new ResourceLoadingException(ResourceType.SHADER, resourceID, openGLError);

        throw new RuntimeException("OBJ loading not yet integrated!"); // return 0;
    }

    // TODO Check if stride is correct or needs to be smth else
    private static int loadVAO(final float[][] data, final int[] elementsPerVertex, final short[] indices) {
        final int[] vaoIDs = new int[1];
        GLES30.glGenVertexArrays(vaoIDs.length, vaoIDs, 0);

        final int vaoID = vaoIDs[0];
        GLES30.glBindVertexArray(vaoID);

        //final int[] vboIDs = new int[data.length];
        for(int index = 0; index < data.length; index++) {
            //vboIDs[index] = loadVBO(data[index], dataStrides[index], index);
            loadVBO(data[index], elementsPerVertex[index], index);
        }

        GLES30.glBindVertexArray(0);
        return vaoID;
    }

    private static final int BYTES_PER_FLOAT = 4;

    private static int loadVBO(final float[] data, final int elementsPerVertex, final int vboIndex) {
        final int[] vboIDs = new int[1];
        GLES30.glGenBuffers(vboIDs.length, vboIDs, 0);
        final int vboID = vboIDs[0];

        // TODO Check if id not 0

        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, vboID);

        final int dataSizeBytes = data.length * BYTES_PER_FLOAT;
        final FloatBuffer dataBuffer = createFloatBuffer(data);
        GLES30.glBufferData(GLES30.GL_ARRAY_BUFFER, dataSizeBytes, dataBuffer, GLES30.GL_STATIC_DRAW);

        // TODO Check if this call must come after all other VBOs (including indices) are bound?
        GLES30.glEnableVertexAttribArray(vboIndex);
        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, vboID);
        GLES30.glVertexAttribPointer(vboIndex, elementsPerVertex, GLES30.GL_FLOAT, false, 0, 0);

        return vboID;
    }

    private static FloatBuffer createFloatBuffer(final float[] array) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(array.length * BYTES_PER_FLOAT);
        byteBuffer.order(ByteOrder.nativeOrder());

        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        floatBuffer.put(array);
        floatBuffer.position(0);

        return floatBuffer;
    }

    private static final int BYTES_PER_SHORT = 2;

    private static int loadElementVBO(final short[] indexData) {
        final int[] vboIDs = new int[1];
        GLES30.glGenBuffers(vboIDs.length, vboIDs, 0);
        final int vboID = vboIDs[0];

        // TODO Check if id not 0

        GLES30.glBindBuffer(GLES30.GL_ELEMENT_ARRAY_BUFFER, vboID);

        final int dataSizeBytes = indexData.length * BYTES_PER_SHORT;
        final ShortBuffer dataBuffer = createShortBuffer(indexData);
        GLES30.glBufferData(GLES30.GL_ELEMENT_ARRAY_BUFFER, dataSizeBytes, dataBuffer, GLES30.GL_STATIC_DRAW);

        return vboID;
    }

    private static ShortBuffer createShortBuffer(final short[] array) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(array.length * BYTES_PER_SHORT);
        byteBuffer.order(ByteOrder.nativeOrder());

        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        shortBuffer.put(array);
        shortBuffer.position(0);

        return shortBuffer;
    }

    /**
     * Returns the resource type this task loads.
     *
     * @return ResourceType.MESH
     */
    @Override
    public ResourceType getLoadedResourceType() {
        return ResourceType.MESH;
    }
}
