package at.htl.boundary;

import at.htl.control.PersonRepository;
import at.htl.entity.Person;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Person person, @Context UriInfo uriInfo) {
        repository.persist(person);

        UriBuilder uri = uriInfo.getAbsolutePathBuilder().path("persons/" + person.id);

        return Response
            .created(uri.build())
            .build();
    }

}
