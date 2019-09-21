package rest;

import DTO.PersonsDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Person;
import utils.EMF_Creator;
import facades.PersonFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/startcode",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final PersonFacade FACADE = PersonFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
//    Gson gson = new Gson();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {

//{ 
//  "all" :[
//    {"fName":"Kurt","lName":"Wonnegut","phone":"12345678","id":0},
//    {"fName":"Peter","lName":"Hansen","phone":"12345678","id":1}
//  ] 
//};
//        return  "{\"fName\":\"Kurt\",\"lName\":\"Wonnegut\", phone:\"12345678\",\"id\":0}";
//        return "{\"msg\":\"Hello World\"}";
//        List<Person> persons = FACADE.getAllPersons();
//        return gson.toJson(persons);
        Person person = FACADE.addPerson("person1", "person1", "1234");
        return GSON.toJson(person);
    }
//    @Path("count")
//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    public String getRenameMeCount() {
//        long count = FACADE.getRenameMeCount();
//        //System.out.println("--------------->"+count);
//        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
//    }

}
