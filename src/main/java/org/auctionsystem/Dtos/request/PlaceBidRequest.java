package org.auctionsystem.Dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceBidRequest {
    private String bidderId;
    private double amount;

    public PlaceBidRequest() {}
}