package ua.hillel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Hovers extends Base {
    @Test
    public void getNameByHover() {
        List<String> usersName=openSite()
                .goToHovers()
                .getUserNames();
        Assert.assertTrue(usersName.size()==3);
    }
}


