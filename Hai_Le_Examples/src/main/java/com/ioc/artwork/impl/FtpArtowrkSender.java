package com.ioc.artwork.impl;

import com.ioc.artwork.ArtworkSender;
import com.ioc.artwork.Recipient;

public class FtpArtowrkSender implements ArtworkSender {
    @Override
    public void sendArtwok(String artworkPath, Recipient recipient) {
        // Some code
    }

    @Override
    public String getFriendlyName() {
        return "File Transfer Protocol";
    }

    @Override
    public String getShortName() {
        return "ftp";
    }
}
