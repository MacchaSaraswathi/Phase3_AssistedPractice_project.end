package phase3.end.project;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class petStoreAPITest {
	
	@Test
	 public void testGetPetById() {
	 // Set up the base URI
	 RestAssured.baseURI = "https://petstore.swagger.io/v2";
	 // Perform GET request to get pet by ID
	 given()
	 .pathParam("petId", 1)
	 .when()
	 .get("/pet/{petId}")
	 .then()
	 .log().all() // Log all details of the response
	 .statusCode(200)
	 .body("id", equalTo(1))
	 .body("name", equalTo("Fido"))
	 .body("status", equalTo("available"));
	 }
	 @Test
	 public void testAddNewPet() {
	 RestAssured.baseURI = "https://petstore.swagger.io/v2";
	 
	 given()
	 .header("Content-Type", "application/json")
	 .body("{ \"id\": 101, \"category\": { \"id\": 1, \"name\": \"Dogs\" }, \"name\": \"Buddy\", \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"string\" } ],	\"status\": \"available\" }")
	 .when()
	 .post("/pet")
	 .then()
	 .statusCode(200)
	 .body("name", equalTo("Buddy"))
	 .body("status", equalTo("available"));
	 }
	 @Test
	 public void testUpdatePetStatus() {
	 RestAssured.baseURI = "https://petstore.swagger.io/v2";
	 
	 given()
	 .header("Content-Type", "application/json")
	 .body("{ \"id\": 101, \"status\": \"sold\" }")
	 .when()
	 .put("/pet")
	 .then()
	 .statusCode(200)
	 .body("status", equalTo("sold"));
	 }

	
	

}
