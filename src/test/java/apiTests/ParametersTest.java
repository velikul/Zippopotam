package apiTests;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import org.hamcrest.Matchers;
import org.junit.Test;


import org.junit.Test;

public class ParametersTest {

    String zipUrl = "http://api.zippopotam.us";

    @Test
    public void pathTest() {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("zip", 22031)
                .when().get(zipUrl + "/us/{zip}");

        JsonPath jsonPath = response.jsonPath();

        response.prettyPrint();

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json");
        assertTrue(response.header("server").equalsIgnoreCase("cloudflare"));
        assertTrue(response.headers().hasHeaderWithName("Report-To"));

        assertEquals(response.path("\'post code\'"), "22031");
        assertEquals(response.path("country"), "United States");
        assertEquals(response.path("\'country abbreviation\'"), "US");
        assertEquals(response.path("places[0].\'place name\'"), "Fairfax");
        assertEquals(jsonPath.getString("places[0].state"), "Virginia");
        assertEquals(jsonPath.getString("places[0].latitude"), "38.8604");

    }

    @Test
    public void HamcrestWithZipApi() {

        given().log().all().accept(ContentType.JSON)
                .and().pathParam("zip", 22031)
                .when().get(zipUrl + "/us/{zip}")
                .then().assertThat().statusCode(200).and().contentType("application/json")
                .and().assertThat().header("Server",equalTo("cloudflare"))
                .and().header("Report-To",notNullValue())
                .log().all()
                .body("country", equalTo("United States"),
                        "'post code'", equalTo("22031"),
                        "places[0].state", equalTo("Virginia"),
                        "'country abbreviation'", equalTo("US"),
                        "places[0].\'place name\'", equalTo("Fairfax"),
                        "places[0].latitude",equalTo("38.8604"));


    }

    @Test
    public void negativeTest(){

        given().log().all().accept(ContentType.JSON).
        and().pathParam("zip",50000).and()
        .when().get(zipUrl+"/us/{zip}")
        .then().assertThat().statusCode(404).and().contentType("application/json");
    }
}
