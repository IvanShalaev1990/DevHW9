package org.example.servise.impl;

import lombok.SneakyThrows;
import org.example.constance.Constance;
import org.example.exaptions.ImageNotFoundException;
import org.example.servise.HttpStatusChecker;
import org.example.util.PropertiesUtil;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusCheckerImpl implements HttpStatusChecker {
    @Override
    public String getStatusImage(int code) throws ImageNotFoundException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(PropertiesUtil.get(Constance.WEB_URI) + code))
                .GET()
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (isStatusCode404(response.statusCode())) {
            throw new ImageNotFoundException();
        }
        return PropertiesUtil.get(Constance.WEB_URI) + code + ".jpg";
    }

    private boolean isStatusCode404(int statusCode) {
        return statusCode == 404;
    }
}
