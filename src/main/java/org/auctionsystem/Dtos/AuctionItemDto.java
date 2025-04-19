package org.auctionsystem.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuctionItemDto {
    private String itemId;
    private String title;
    private String description;
    private double startingPrice;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    public AuctionItemDto() {}
    public AuctionItemDto(String itemId, String title, String description,
                          double startingPrice, LocalDateTime startTime,
                          LocalDateTime endTime, String status) {
        this.itemId = itemId;
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }
}