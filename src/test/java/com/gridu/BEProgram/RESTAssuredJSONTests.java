package com.gridu.BEProgram;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import com.gridu.BEProgram.entities.Dog;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RESTAssuredJSONTests {
    final static String ROOT_URI = "http://localhost:8000/api/v1";

    public String name;
    public String dateOfBirth;
    public Float height;
    public Float weight;

    @BeforeClass
    public void init() {
        name = "Liza";
        dateOfBirth = "2000-01-23";
        height = Float.parseFloat("30");
        weight = Float.parseFloat("40");
    }

    @Test
    public void shouldCheckResponseContentFromPostRequiest() {
        Response response = given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"name\": \"" + name + "\",\"dateOfBirth\": \"" + dateOfBirth + "\",\"height\": \"" + height + "\",\"weight\": \"" + weight + "\" }")
                .when()
                .post(ROOT_URI + "/dog");

        response.then().body("id", Matchers.any(Integer.class));
        response.then().body("name", Matchers.is(name));
        response.then().body("dateOfBirth", Matchers.is(dateOfBirth));
        response.then().body("height", Matchers.is(height));
        response.then().body("weight", Matchers.is(weight));
    }

    @Test
    public void shouldCheckResponseContentFromPutRequiest() {
        Response response1 = given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"name\": \"" + name + "\",\"dateOfBirth\": \"" + dateOfBirth + "\",\"height\": \"" + height + "\",\"weight\": \"" + weight + "\" }")
                .when()
                .post(ROOT_URI + "/dog");
        Integer id = response1.as(Dog.class).getId();
        String newName = "Lisa";
        Response response2 = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"id\": \"" + id + "\",\"name\": \"" + newName + "\",\"dateOfBirth\": \"" + dateOfBirth + "\",\"height\": \"" + height + "\",\"weight\": \"" + weight + "\" }")
                .when()
                .put(ROOT_URI + "/dog");

        response2.then().body("id", Matchers.is(id));
        response2.then().body("name", Matchers.is(newName));
        response2.then().body("dateOfBirth", Matchers.is(dateOfBirth));
        response2.then().body("height", Matchers.is(height));
        response2.then().body("weight", Matchers.is(weight));
    }

    @Test
    public void shouldCheckResponseContentFromGetRequiest() {
        Response response1 = given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"name\": \"" + name + "\",\"dateOfBirth\": \"" + dateOfBirth + "\",\"height\": \"" + height + "\",\"weight\": \"" + weight + "\" }")
                .when()
                .post(ROOT_URI + "/dog");

        Integer id = response1.as(Dog.class).getId();
        Response response2 = get(ROOT_URI + "/dog/" + id);

        response2.then().body("id", Matchers.is(id));
        response2.then().body("name", Matchers.is(name));
        response2.then().body("dateOfBirth", Matchers.is(dateOfBirth));
        response2.then().body("height", Matchers.is(height));
        response2.then().body("weight", Matchers.is(weight));
    }

    @Test
    public void delete_test() {
        Response response1 = given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"name\": \"" + name + "\",\"dateOfBirth\": \"" + dateOfBirth + "\",\"height\": \"" + height + "\",\"weight\": \"" + weight + "\" }")
                .when()
                .post(ROOT_URI + "/dog");

        Integer id = response1.as(Dog.class).getId();

        Response response = delete(ROOT_URI + "/dog/"+id);
        response = get(ROOT_URI + "/dogs");
        System.out.println(response.asString());
        response.then().body("id", Matchers.not(id));
    }
}

