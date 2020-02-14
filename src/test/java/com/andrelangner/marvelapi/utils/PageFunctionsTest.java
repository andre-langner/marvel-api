package com.andrelangner.marvelapi.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PageFunctionsTest {

    @Test
    void getPageNumber() {
        int page = PageFunctions.getPageNumber(0, 100);
        Assert.assertEquals(page, 0);

        page = PageFunctions.getPageNumber(99, 100);
        Assert.assertEquals(page, 0);

        page = PageFunctions.getPageNumber(100, 100);
        Assert.assertEquals(page, 0);

        page = PageFunctions.getPageNumber(100, 100);
        Assert.assertEquals(page, 0);

        page = PageFunctions.getPageNumber(102, 100);
        Assert.assertEquals(page, 1);
    }
}