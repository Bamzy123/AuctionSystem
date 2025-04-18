package org.auctionsystem.exceptions;

public class AuctionNotFoundException extends RuntimeException{
    public AuctionNotFoundException(String auctionNotFound) {
        super(auctionNotFound);
    }
}