package service.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ContainerService {

    @Inject
    DockerClient docker;

    public List<Container> getContainers() {
        return docker.listContainersCmd().withShowAll(true).exec();
    }

    public Container getContainerById(String containerId) {
        List<Container> containers = getContainers();
        for (Container container : containers) {
            if (container.getId().equals(containerId)) {
                return container;
            }
        }
        return null;
    }

    public void restartContainer(String containerId) {
        docker.restartContainerCmd(containerId).exec();
    }

    public void stopContainer(String containerId) {
        docker.stopContainerCmd(containerId).exec();
    }

    public void killContainer(String containerId) {
        docker.killContainerCmd(containerId).exec();
    }

    public void removeContainer(String containerId) {
        docker.removeContainerCmd(containerId).exec();
    }
}
