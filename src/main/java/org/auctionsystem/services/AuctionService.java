package org.auctionsystem.services;

import org.auctionsystem.exceptions.AuctionNotFoundException;
import org.auctionsystem.models.AuctionItem;
import org.auctionsystem.repositories.AuctionItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {
    private final AuctionItemRepository auctionRepo;

    public AuctionService(AuctionItemRepository auctionRepo) {
        this.auctionRepo = auctionRepo;
    }

    public AuctionItem createAuction(AuctionItem item) {
        item.setStatus("Upcoming");
        return auctionRepo.save(item);
    }

    public AuctionItem getAuctionById(String id) {
        return auctionRepo.findById(id)
                .orElseThrow(() -> new AuctionNotFoundException("Auction not found"));
    }

    public List<AuctionItem> getAllAuctions() {
        return auctionRepo.findAll();
    }

    public List<AuctionItem> getOngoing() {
        return auctionRepo.findByStartTimeBeforeAndEndTimeAfter(
                java.time.LocalDateTime.now(), java.time.LocalDateTime.now());
    }
}