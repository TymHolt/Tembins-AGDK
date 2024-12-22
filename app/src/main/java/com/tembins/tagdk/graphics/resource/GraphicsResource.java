package com.tembins.tagdk.graphics.resource;

public final class GraphicsResource {

    int oglID;

    GraphicsResource(final int oglID) {
        this.oglID = oglID;
    }

    public int getOGLID() {
        return oglID;
    }
}
