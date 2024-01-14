package org.example.servise.impl;

import org.example.constance.Constance;
import org.example.exaptions.ImageNotFoundException;
import org.example.servise.HttpStatusChecker;
import org.example.servise.HttpStatusImageDownloader;
import org.example.util.PropertiesUtil;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;



public class HttpStatusImageDownloaderImpl implements HttpStatusImageDownloader {
    HttpStatusChecker statusChecker = new HttpStatusCheckerImpl();

    @Override
    public void downloadStatusImage(int code) throws ImageNotFoundException{
        statusChecker.getStatusImage(code);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(PropertiesUtil.get(Constance.WEB_URI) + code))
                .GET()
                .build();
        Path directory = Paths.get("C:\\GoITDev\\HW9\\Files\\Cat_Code_" + code + ".jpg");
        HttpResponse<Path> response = null;
        try {
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofFile(directory));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
