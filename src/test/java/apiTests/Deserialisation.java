package apiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class Deserialisation{

    String zipUrl = "http://api.zippopotam.us";

    @Test
    public void CollectionTest(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("zip", 22031)
                .when().get(zipUrl + "/us/{zip}");

        response.prettyPrint();

        // JSON to Java Collection: Deserialization, as() method
        Map<String,Object> postCode=response.body().as(Map.class);
        System.out.println(postCode);

        assertEquals(postCode.get("country"),"United States");
        assertEquals(postCode.get("post code"),"22031");

        List<Map<String, Object>> placesList= (List<Map<String, Object>>) postCode.get("places");
        assertEquals(placesList.get(0).get("state"),"Virginia");

        double expectedLatitude=38.8604;
        double actualLatitude= Double.parseDouble((String) placesList.get(0).get("latitude"));
        assertEquals(actualLatitude,expectedLatitude,0);

    }





}
