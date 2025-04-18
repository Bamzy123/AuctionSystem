package org.auctionsystem.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter

@Document(collection = "bids")
public class Bid extends User{
    @Id
    private String bidId;

    @DBRef
    private User bidder;

    @DBRef
    private AuctionItem auctionItem;

    private double amount;
    private LocalDateTime timestamp;

    public Bid() {
    }

    public Bid(String bidId, User bidder, AuctionItem auctionItem, double amount,
               LocalDateTime timestamp) {
        this.bidId = bidId;
        this.bidder = bidder;
        this.auctionItem = auctionItem;
        this.amount = amount;
        this.timestamp = timestamp;
    }
}
