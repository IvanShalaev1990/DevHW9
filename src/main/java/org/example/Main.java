package org.example;


import org.example.exaptions.ImageNotFoundException;
import org.example.servise.HttpImageStatusCli;
import org.example.servise.HttpStatusImageDownloader;
import org.example.servise.impl.HttpImageStatusCliImpl;
import org.example.servise.impl.HttpStatusImageDownloaderImpl;

import java.nio.file.FileAlreadyExistsException;

public class Main {
    public static void main(String[] args) throws FileAlreadyExistsException, ImageNotFoundException {
        HttpImageStatusCli statusCli = new HttpImageStatusCliImpl();
        statusCli.askStatus();
    }
}