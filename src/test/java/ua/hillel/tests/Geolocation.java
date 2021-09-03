package ua.hillel.tests;

import org.testng.annotations.Test;
import pageObjects.GeolocationPage;

public class Geolocation extends Base {
    @Test
    public void getGeolocation(){
        GeolocationPage geolocationPage = openSite()
                .goToGeolocationPage()
                .clickButtonWhereIAm();
        System.out.println("Latitude is " +geolocationPage.getLatitude()+ " Longitude is " +geolocationPage.getLongitude() );
    }
}
