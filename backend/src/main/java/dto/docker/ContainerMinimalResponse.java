package dto.docker;

public record ContainerMinimalResponse(
        String id,
        String name,
        String image,
        String state,
        Long created
) {

}