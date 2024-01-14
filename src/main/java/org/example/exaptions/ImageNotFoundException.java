package org.example.exaptions;

public class ImageNotFoundException extends Exception{
    public ImageNotFoundException(){}
    public ImageNotFoundException(String message){
        super(message);
    }
    public ImageNotFoundException(Throwable cause){
        super(cause);
    }
    public ImageNotFoundException(String message,Throwable cause){
        super(message, cause);
    }
}
