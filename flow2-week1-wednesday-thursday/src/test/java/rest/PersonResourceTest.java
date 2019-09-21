//package rest;
//
//import DTO.PersonDTO;
//import entities.Person;
//import utils.EMF_Creator;
//import io.restassured.RestAssured;
//import static io.restassured.RestAssured.given;
//import io.restassured.parsing.Parser;
//import java.net.URI;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.ws.rs.core.UriBuilder;
//import org.glassfish.grizzly.http.server.HttpServer;
//import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
//import org.glassfish.jersey.server.ResourceConfig;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.containsInAnyOrder;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.notNullValue;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import utils.EMF_Creator.DbSelector;
//import utils.EMF_Creator.Strategy;
//
//
////Uncomment the line below, to temporarily disable this test
////@Disabled
//public class PersonResourceTest {
//
//    private static final int SERVER_PORT = 7777;
//    private static final String SERVER_URL = "http://localhost/api";
//    private static Person p1, p2;
//    //Read this line from a settings-file  since used several places
//    private static final String TEST_DB = "jdbc:mysql://localhost:3307/startcode_test";
//
//    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
//    private static HttpServer httpServer;
//    private static EntityManagerFactory emf;
//
//    static HttpServer startServer() {
//        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
//        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//        EMF_Creator.setIsIntegrationWithDB(true);
//        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.CREATE);
//        httpServer = startServer();
//        
//        //Setup RestAssured
//        RestAssured.baseURI = SERVER_URL;
//        RestAssured.port = SERVER_PORT;
//        RestAssured.defaultParser = Parser.JSON;
//    }
//    
//    @AfterAll
//    public static void closeTestServer(){
//        //System.in.read();
//         httpServer.shutdownNow();
//         EMF_Creator.setIsIntegrationTestWithDB(false);
//    }
//    
////     Setup the DataBase (used by the test-server and this test) in a known state BEFORE EACH TEST
////    TODO -- Make sure to change the script below to use YOUR OWN entity class
//    @BeforeEach
//    public void setUp() {
//        EntityManager em = emf.createEntityManager();
//        p1 = new Person("Kim", "Hansen", "12345678");
//        p1 = new Person("Pia", "Hansen", "11111111");
//        try {
//            em.getTransaction().begin();
//            
//            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
//            em.persist(p1);
//            em.persist(p2);
//            em.persist(new Person("Some txt","More text"));
//            em.persist(new Person("aaa","bbb"));
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//    
//    @Test
//    public void testServerIsUp() {
//        System.out.println("Testing is server UP");
//        given().when().get("/person").then().statusCode(200);
//    }
//   
//    public void getAllPersons() throws Exception {
//        List<PersonDTO> personsDtos;
//        
//        personsDtos = given()
//                .contentType("application/json")
//                .when()
//                .get("/person/all")
//                .then()
//                .extract().body().jsonPath().getList("all", PersonDTO.class);
//        PersonDTO p1DTO = new PersonDTO(p1);
//        PersonDTO p2DTO = new PersonDTO(p2);
//        assertThat(personsDtos, containsInAnyOrder(p1DTO, p2DTO));
//    }
//    
//    public void addPerson() throws Exception {
//        given()
//                .contentType("application/json")
//                .body(new PersonDTO("ib", "xxx","123"))
//                .when()
//                .post("person")
//                .then()
//                .body("fName", equalTo("ib"))
//                .body("lName", equalTo("xxx"))
//                .body("id",notNullValue());
//                           
//    }
//}
