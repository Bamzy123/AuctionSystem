package org.auctionsystem.exceptions;

public class BiddingNotOpenException extends RuntimeException {
    public BiddingNotOpenException(String message) {
        super(message);
    }
}
