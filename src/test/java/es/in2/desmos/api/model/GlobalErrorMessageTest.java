package es.in2.desmos.api.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GlobalErrorMessageTest {

    @Test
    void testBuilderAndAccessors() {
        // Arrange
        String title = "Error Title";
        String message = "Error Message";
        String path = "/error/path";
        // Act
        GlobalErrorMessage globalErrorMessage = GlobalErrorMessage.builder()
                .title(title)
                .message(message)
                .path(path)
                .build();
        // Assert
        assertEquals(title, globalErrorMessage.title());
        assertEquals(message, globalErrorMessage.message());
        assertEquals(path, globalErrorMessage.path());
    }

}