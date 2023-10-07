package utils;

import pageObjects.PageObjectManager;

import java.io.IOException;

public class TextContextSetup {
TestBase base;
PageObjectManager POM;
TextContextSetup() throws IOException {
    base =new TestBase();
    POM =new PageObjectManager(base.initializeDriver());
}

}
