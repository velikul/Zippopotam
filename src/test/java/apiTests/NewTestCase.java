package apiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class NewTestCase {

    String hrUrl="54.91.210.3:1000/ords/hr";

    @Test
    public void Test1(){

        Response response= given().accept(ContentType.JSON)
                .and().queryParam("q","{\"job_id\":\"AD_VP\"}")
                .when().get(hrUrl+"/employees");

        response.prettyPrint();



    }




}
