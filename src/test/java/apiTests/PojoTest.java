package apiTests;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class PojoTest {

    String zipUrl = "https://api.zippopotam.us/";


    @Test
    public void Test1() {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("zip", 22031)
                .when().get(zipUrl + "us/{zip}");

        // Birinci yöntem automatic

        PostCode zip22301 = response.body().as(PostCode.class);
        System.out.println(zip22301.getCountry());
        String latitude = zip22301.getPlaces().get(0).getLatitude();
        System.out.println(latitude);

        // ikinci yöntem manuel

     /*   Gson gson = new Gson();
        PostCode zip22032 = gson.fromJson(response.body().asString(), PostCode.class);
        System.out.println(zip22032.getCountry());*/

    }

}
