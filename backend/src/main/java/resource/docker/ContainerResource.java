package resource.docker;

import dto.docker.ContainerMinimalResponse;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.docker.ContainerService;

import java.util.Arrays;
import java.util.List;

@Path("/containers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContainerResource {

    @Inject
    ContainerService containerService;

    @GET
    @Transactional
    public Response getContainers() {
        List<ContainerMinimalResponse> response = containerService.getContainers().stream().map((container -> new ContainerMinimalResponse(
                container.getId(),
                Arrays.stream(container.getNames()).findFirst().orElse("unnamed").substring(1, container.getNames()[0].length()),
                container.getImage(),
                container.getState(),
                container.getCreated()
        ))).toList();

        return Response.ok().entity(response).build();
    }
}