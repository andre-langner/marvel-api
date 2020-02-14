package com.andrelangner.marvelapi.utils;

public class PageFunctions {

    public static int getPageNumber(int offset, int limit) {
        if (offset == 0) { return 0; }

        return (int) Math.ceil((double) offset / limit) - 1;
    }
}
