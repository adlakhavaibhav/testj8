package com.nm.rest.resource;

import com.nm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;


/**
 * Created by adlakhavaibhav on 20/11/14.
 */
@Component
@Path("/test")
public class TestResource {


    @Autowired
    private TestService testService;

    @GET
    @Path("/one")
    @Produces("text/plain")
    public Response one() {
        return Response.ok(testService.testCall()).build();
    }

    @GET
    @Path("/two")
    @Produces("application/json")
    public Response two() {

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        return Response.ok(testService.testPojo()).build();
    }
}
