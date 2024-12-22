package com.tembins.tagdk.graphics.resource.tasks;

import android.content.Context;

public interface LoadingTask {

    int load(final Context context) throws ResourceLoadingException;
    ResourceType getLoadedResourceType();
}
