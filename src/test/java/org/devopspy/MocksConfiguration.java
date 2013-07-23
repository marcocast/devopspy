package org.devopspy;

import static org.mockito.Mockito.mock;

import org.devopspy.notificators.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@ImportResource({"classpath*:resthubContext.xml", "classpath*:applicationContext.xml"})
@Profile("test")
public class MocksConfiguration {
    @Bean(name = "notificationService")
    public NotificationService mockedNotificationService() {
        return mock(NotificationService.class);
    }
    
}
