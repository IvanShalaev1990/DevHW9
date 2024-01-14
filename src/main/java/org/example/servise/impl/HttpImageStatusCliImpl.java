package org.example.servise.impl;

import org.example.exaptions.ImageNotFoundException;
import org.example.servise.HttpImageStatusCli;
import org.example.servise.HttpStatusImageDownloader;

import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class HttpImageStatusCliImpl implements HttpImageStatusCli {
    HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloaderImpl();

    @Override
    public void askStatus() {
        int code = 0;
        Scanner scanner = new Scanner(System.in);

            System.out.println("Enter HTTP status code:");
            while (scanner.hasNext()) {
                try {
                    code = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter valid number");
                    continue;
                }
                try {
                    imageDownloader.downloadStatusImage(code);
                    System.out.println("Image wos successfully downloaded.");
                } catch (ImageNotFoundException e) {
                    System.out.println("There is not image for HTTP status " + code);
                }
                System.out.println("Enter HTTP status code:");
            }
        }
    }

