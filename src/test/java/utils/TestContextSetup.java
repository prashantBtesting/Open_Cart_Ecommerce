package utils;

import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
    public TestBase base;
    public PageObjectManager POM;

    public TestContextSetup() throws IOException {
        base = new TestBase();
        POM = new PageObjectManager(base.initializeDriver());
    }

}
