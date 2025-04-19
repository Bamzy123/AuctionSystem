package org.auctionsystem.Dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateAuctionRequest {
    private String title;
    private String description;
    private double startingPrice;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CreateAuctionRequest() {}
}
