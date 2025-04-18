package org.auctionsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.auctionsystem.models.AuctionItem;
import org.auctionsystem.models.Bid;
import org.auctionsystem.services.AuctionService;
import org.auctionsystem.services.BidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
@RequiredArgsConstructor
public class AuctionController {
    private final AuctionService auctionService;
    private final BidService bidService;
    @PostMapping
    public ResponseEntity<AuctionItem> createAuction(@RequestBody AuctionItem item) {
        return ResponseEntity.ok(auctionService.createAuction(item));
    }
    @GetMapping
    public ResponseEntity<List<AuctionItem>> listAuctions() {
        return ResponseEntity.ok(auctionService.getAllAuctions());
    }
    @GetMapping("/ongoing")
    public ResponseEntity<List<AuctionItem>> ongoing() {
        return ResponseEntity.ok(auctionService.getOngoing());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AuctionItem> getById(@PathVariable String id) {
        return ResponseEntity.ok(auctionService.getAuctionById(id));
    }
    @PostMapping("/{id}/bid")
    public ResponseEntity<Bid> placeBid(@PathVariable String id, @RequestBody Bid bid) {
        return ResponseEntity.ok(bidService.placeBid(id, bid));
    }
    @GetMapping("/{id}/winner")
    public ResponseEntity<String> winner(@PathVariable String id) {
        return ResponseEntity.ok(bidService.getWinningBidder(id));
    }
}