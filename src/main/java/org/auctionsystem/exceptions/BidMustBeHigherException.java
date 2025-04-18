package org.auctionsystem.exceptions;

public class BidMustBeHigherException extends RuntimeException {
    public BidMustBeHigherException(String message) {
        super(message);
    }
}
