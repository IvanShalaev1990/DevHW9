package org.example.servise;

import org.example.exaptions.ImageNotFoundException;

public interface HttpStatusChecker {
    String getStatusImage(int code) throws ImageNotFoundException;
}
