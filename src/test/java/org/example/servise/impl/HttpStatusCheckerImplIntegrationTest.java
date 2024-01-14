package org.example.servise.impl;

import org.example.exaptions.ImageNotFoundException;
import org.example.servise.HttpStatusChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HttpStatusCheckerImplIntegrationTest {
    private HttpStatusChecker statusChecker;

    @BeforeEach
    void setUp() {
        statusChecker = new HttpStatusCheckerImpl();
    }
    @Test
    void testThatGetStatusImageThrowImageNotFoundExceptionWhenIncorrectParamsReceived(){
        assertThrows(ImageNotFoundException.class, () -> {
            statusChecker.getStatusImage(9999);
        });

    }

    @ParameterizedTest
    @MethodSource("getStatusImageReturnCorrectLink")
    void testThatGetStatusImageReturnCorrectLinkWhenCorrectParamsReceived(int input, String expected) throws ImageNotFoundException {
        assertThat(statusChecker.getStatusImage(input))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> getStatusImageReturnCorrectLink() {
        return Stream.of(
                Arguments.of(100, "https://http.cat/100.jpg"),
                Arguments.of(200, "https://http.cat/200.jpg"),
                Arguments.of(300, "https://http.cat/300.jpg")
        );
    }

}