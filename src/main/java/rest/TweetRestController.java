package rest;


import entity.Tweet;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/tweets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TweetRestController {

    @POST
    @Transactional
    public Tweet create(Tweet twit) {
        Tweet.persist(twit);
        return twit;
    }

    @GET
    @Path("/{id}")
    public Tweet getById(@PathParam("id") long id) {
        Tweet tweet = Tweet.findById(id);
        return Optional.ofNullable(tweet).orElseThrow(() -> new EntityNotFoundException("Tweet not found"));
    }

    @GET
    public List<Tweet> getAllByUsername(@QueryParam("username") String username) {
        List<Tweet> result = Tweet.list("username", Sort.descending("id"), username);
        return result;
    }
}
