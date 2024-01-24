package org.frolicbits.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServiceA {

    @Autowired
    private ServiceB serviceB;


    @Cacheable(value = "deploymentListCache", key = "'deploymentList'")
    public List<Deployment> getAllDeployments() {
        // Seed some dummy data for demonstration purposes
        List<Container> containers1 = List.of(
                new Container("Container1", "2022-01-01", "v1", "repo1", "tag1"),
                new Container("Container2", "2022-01-02", "v2", "repo2", "tag2")
                // Add more containers as needed
        );

        List<Container> containers2 = List.of(
                new Container("Container3", "2022-01-03", "v3", "repo3", "tag3"),
                new Container("Container4", "2022-01-04", "v4", "repo4", "tag4")
                // Add more containers as needed
        );

        Deployment deployment1 = new Deployment("Deployment1", containers1);
        Deployment deployment2 = new Deployment("Deployment2", containers2);

        return List.of(deployment1, deployment2);
    }

    // CacheEvict annotation is used to conditionally clear the cache


    // This method is called by the scheduled method
    public void performScheduledUpdate() {
        // Fetch all deployments
        List<Deployment> deployments = getAllDeployments();

        // Update each deployment and containers
        for (Deployment deployment : deployments) {
            // Implement logic to update deployment and containers data (excluding imageVersion)

            // Check if there is a change in container data
            boolean containerDataChanged = checkContainerDataChanged(deployment);

            // Call ServiceB to handle imageVersion update
            serviceB.updateImageVersion(deployment);

            // Conditionally clear the cache only if there is a change in container data
            if (containerDataChanged) {
                clearDeploymentListCache();
            }
        }
    }

    // CacheEvict annotation is used to conditionally clear the cache
    @CacheEvict(value = "deploymentListCache", key = "'deploymentList'")
    public void clearDeploymentListCache() {
        log.info("Cache 'deploymentListCache' cleared manually.");
    }

    // Scheduled method that calls the no-arg method
    @Scheduled(cron = "0 * * * * ?")  // Run every minute
    public void scheduledUpdateDeployments() {
        performScheduledUpdate();
    }

    private boolean checkContainerDataChanged(Deployment deployment) {
        // Implement logic to check if there is a change in container data
        // For demonstration purposes, let's assume a change if the first container's imageTag is "tag1"
        return deployment.getContainers().stream()
                .anyMatch(container -> "tag1".equals(container.getImageTag()));
    }


}

