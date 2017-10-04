package pl.mareksowa.models;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuLoaderTest {
    private static MenuLoader menuLoader;

    @BeforeClass
    public static void start(){
        menuLoader = new MenuLoader();
    }

    @AfterClass
    public static void stop(){
        menuLoader = null;
    }

    @Test
    public void loadMenuTest(){
        assertNotNull(menuLoader.getMainCourseMenu());
        assertNotNull(menuLoader.getSmallMenu());
    }
}
