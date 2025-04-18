package org.auctionsystem.services;

import org.auctionsystem.exceptions.BidMustBeHigherException;
import org.auctionsystem.exceptions.BiddingNotOpenException;
import org.auctionsystem.models.AuctionItem;
import org.auctionsystem.models.Bid;
import org.auctionsystem.exceptions.AuctionItemNotFoundException;
import org.auctionsystem.repositories.AuctionItemRepository;
import org.auctionsystem.repositories.BidRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BidService {
    private final BidRepository bidRepo;
    private final AuctionItemRepository auctionRepo;

    public BidService(BidRepository bidRepo, AuctionItemRepository auctionRepo) {
        this.bidRepo = bidRepo;
        this.auctionRepo = auctionRepo;
    }

    public Bid placeBid(String auctionId, Bid bid) {
        AuctionItem item = auctionRepo.findById(auctionId)
                .orElseThrow(() -> new AuctionItemNotFoundException("Auction item not found"));

        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(item.getStartTime()) || now.isAfter(item.getEndTime())) {
            throw new BiddingNotOpenException("Bidding not open for this auction");
        }

        List<Bid> bids = bidRepo.findByAuctionItemItemIdOrderByAmountDesc(item.getItemId());
        double highest = bids.isEmpty() ? item.getStartingPrice() : bids.get(0).getAmount();
        if (bid.getAmount() <= highest) throw new BidMustBeHigherException("Bid must be higher than current highest bid");

        bid.setTimestamp(now);
        bid.setAuctionItem(item);
        return bidRepo.save(bid);
    }

    public String getWinningBidder(String auctionId) {
        List<Bid> bids = bidRepo.findByAuctionItemItemIdOrderByAmountDesc(auctionId);
        return bids.isEmpty() ? "No bids" : bids.get(0).getBidder().getUserId();
    }
}