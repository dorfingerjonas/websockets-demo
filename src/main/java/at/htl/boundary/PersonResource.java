package at.htl.boundary;

import at.htl.control.PersonRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonRepository repository;

    @GET
    public Response findAll() {
        return Response
            .ok(repository.listAll())
            .build();
    }
}
