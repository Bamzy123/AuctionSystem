package org.auctionsystem.repositories;

import org.auctionsystem.models.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BidRepository extends MongoRepository<Bid, String> {
    List<Bid> findByAuctionItemItemIdOrderByAmountDesc(String itemId);
}