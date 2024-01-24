package org.frolicbits.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceB {
    @Autowired
    private CacheManager cacheManager;

    public void updateContainerListsVersion() {
        log.info("ServiceB: Updating container lists version...");
        // Implement logic to update version field using Bitbucket API
        log.info("ServiceB: finished pulling bitbucket data...");
    }

    // Cacheable annotation is used to cache the result of this method
    @Cacheable(value = "imageVersionCache", key = "'imageVersion'")
    public void updateImageVersion(Deployment deployment) {
        // For demonstration purposes, let's update the imageTag of each container
        for (Container container : deployment.getContainers()) {
            // Update the imageTag based on some logic (e.g., appending "_new")
            container.setImageTag(container.getImageTag() + "_new");
        }
    }


    @Scheduled(cron = "0 */4 * * * ?")  // Run every 4 minutes
    public void scheduledClearImageVersionCache() {
        String cacheName = "imageVersionCache";
        cacheManager.getCache(cacheName).clear();
        log.info("Cache '" + cacheName + "' cleared at midnight.");
    }
}
