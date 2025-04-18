package org.auctionsystem.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter

@Document(collection = "auctionItems")
public class AuctionItem extends User{
    @Id
    private String itemId;
    private String title;
    private String description;
    private double startingPrice;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    public AuctionItem() {}

    public AuctionItem(String itemId, String title, String description, double startingPrice,
                       LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.itemId = itemId;
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public double getCurrentHighestBid() {
        return startingPrice;
    }
}
