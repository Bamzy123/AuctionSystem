package org.auctionsystem.repositories;

import org.auctionsystem.models.AuctionItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AuctionItemRepository extends MongoRepository<AuctionItem, String> {
    List<AuctionItem> findByStatus(String status);
    List<AuctionItem> findByStartTimeBeforeAndEndTimeAfter(LocalDateTime start, LocalDateTime end);
}