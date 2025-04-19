package org.auctionsystem.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BidDto {
    private String bidId;
    private String bidderId;
    private String auctionItemId;
    private double amount;
    private LocalDateTime timestamp;

    public BidDto() {}
    public BidDto(String bidId, String bidderId, String auctionItemId,
                  double amount, LocalDateTime timestamp) {
        this.bidId = bidId;
        this.bidderId = bidderId;
        this.auctionItemId = auctionItemId;
        this.amount = amount;
        this.timestamp = timestamp;
    }
}