package org.auctionsystem.exceptions;

public class AuctionItemNotFoundException extends RuntimeException{
    public AuctionItemNotFoundException(String auctionItemNotFound) {
        super(auctionItemNotFound);
    }
}