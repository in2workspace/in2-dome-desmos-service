package es.in2.desmos.infrastructure.configs;

import es.in2.desmos.infrastructure.configs.BrokerConfig;
import es.in2.desmos.infrastructure.configs.properties.BrokerProperties;
import es.in2.desmos.infrastructure.configs.properties.NgsiLdSubscriptionProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrokerConfigTests {

    @Mock
    private BrokerProperties brokerProperties;

    @Mock
    private NgsiLdSubscriptionProperties ngsiLdSubscriptionProperties;

    @InjectMocks
    private BrokerConfig brokerConfig;

    @Test
    void getNotificationEndpointReturnsCorrectEndpoint() {
        // Arrange
        String expectedEndpoint = "https://example.com/api/v1/notifications/broker";
        when(ngsiLdSubscriptionProperties.notificationEndpoint()).thenReturn(expectedEndpoint);
        // Act
        String actualEndpoint = brokerConfig.getNotificationEndpoint();
        // Assert
        assertEquals(expectedEndpoint, actualEndpoint);
    }

    @Test
    void getEntityTypesReturnsCorrectEntities() {
        // Arrange
        List<String> expectedEntityTypes = List.of("ProductOffering", "Catalogue", "Category");
        when(ngsiLdSubscriptionProperties.entityTypes()).thenReturn(expectedEntityTypes);
        // Act
        List<String> actualEntityTypes = brokerConfig.getEntityTypes();
        // Assert
        assertEquals(expectedEntityTypes, actualEntityTypes);
    }

    @Test
    void getEntitiesExternalDomainReturnsCorrectDomain() {
        // Arrange
        String externalDomain = "https://example.com";
        String entitiesPath = "/ngsi-ld/v1/entities";
        when(brokerProperties.externalDomain()).thenReturn(externalDomain);
        when(brokerProperties.paths()).thenReturn(new BrokerProperties.BrokerPathProperties(
                "/ngsi-ld/v1/entities",
                "/ngsi-ld/v1/subscriptions",
                "/ngsi-ld/v1/temporal/entities"
        ));
        // Act
        String actualDomain = brokerConfig.getEntitiesExternalDomain();
        // Assert
        assertEquals(externalDomain + entitiesPath, actualDomain);
    }

    @Test
    void getExternalDomainReturnsCorrectDomain() {
        // Arrange
        String expectedDomain = "https://example.com";
        when(brokerProperties.externalDomain()).thenReturn(expectedDomain);
        // Act
        String actualDomain = brokerConfig.getExternalDomain();
        // Assert
        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    void getEntitiesPathReturnsCorrectPath() {
        // Arrange
        String expectedPath = "/ngsi-ld/v1/entities";
        when(brokerProperties.paths()).thenReturn(new BrokerProperties.BrokerPathProperties(
                "/ngsi-ld/v1/entities",
                "/ngsi-ld/v1/subscriptions",
                "/ngsi-ld/v1/temporal/entities"
        ));
        // Act
        String actualPath = brokerConfig.getEntitiesPath();
        // Assert
        assertEquals(expectedPath, actualPath);
    }

    @Test
    void getSubscriptionsPathReturnsCorrectPath() {
        // Arrange
        String expectedPath = "/ngsi-ld/v1/subscriptions";
        when(brokerProperties.paths()).thenReturn(new BrokerProperties.BrokerPathProperties(
                "/ngsi-ld/v1/entities",
                "/ngsi-ld/v1/subscriptions",
                "/ngsi-ld/v1/temporal/entities"
        ));
        // Act
        String actualPath = brokerConfig.getSubscriptionsPath();
        // Assert
        assertEquals(expectedPath, actualPath);
    }

    @Test
    void getTemporalPathReturnsCorrectPath() {
        // Arrange
        String expectedPath = "/ngsi-ld/v1/temporal/entities";
        when(brokerProperties.paths()).thenReturn(new BrokerProperties.BrokerPathProperties(
                "/ngsi-ld/v1/entities",
                "/ngsi-ld/v1/subscriptions",
                "/ngsi-ld/v1/temporal/entities"
        ));
        // Act
        String actualPath = brokerConfig.getTemporalPath();
        // Assert
        assertEquals(expectedPath, actualPath);
    }

}
