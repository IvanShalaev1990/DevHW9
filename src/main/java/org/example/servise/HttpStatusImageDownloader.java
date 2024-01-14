package org.example.servise;

import org.example.exaptions.ImageNotFoundException;

import java.nio.file.FileAlreadyExistsException;

public interface HttpStatusImageDownloader {
    void downloadStatusImage(int code)throws ImageNotFoundException;
}
