package com.example.web.resource;

import com.example.persistence.entity.Sample;
import com.example.persistence.repository.SampleRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/samples")
@ApplicationScoped
public class SampleResource {

    @Inject
    private SampleRepository sampleRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(sampleRepository.findAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Sample sample, @Context UriInfo uriInfo) {
        sampleRepository.insert(sample);
        URI location = uriInfo.getAbsolutePathBuilder().path(sample.getId().toString()).build();
        return Response.created(location).build();
    }
}
