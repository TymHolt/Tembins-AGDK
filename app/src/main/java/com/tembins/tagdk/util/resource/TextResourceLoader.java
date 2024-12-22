package com.tembins.tagdk.util.resource;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class provides utility functions to load text resources.
 */
public final class TextResourceLoader {

    /**
     * Loads a given resourceID as a string.
     *
     * @param context The context needed to access the resources.
     * @param resourceID The ID of the resource to load.
     * @return A string containing the loaded resources data.
     * @throws IOException If the loading fails due to IO errors.
     */
    public static String loadTextResource(final Context context, final int resourceID) throws IOException {
        InputStream inputStream = context.getResources().openRawResource(resourceID);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();

        int readChar;
        while((readChar = bufferedReader.read()) != -1)
            stringBuilder.append((char) readChar);

        bufferedReader.close();
        return stringBuilder.toString();
    }
}
