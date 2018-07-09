package com.ioc.artwork;

public interface ArtworkSender {

    void sendArtwok(String artworkPath, Recipient recipient);
    String getFriendlyName();
    String getShortName();

}
