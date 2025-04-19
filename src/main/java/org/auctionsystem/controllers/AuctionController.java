package org.auctionsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.auctionsystem.Dtos.AuctionItemDto;
import org.auctionsystem.Dtos.DtoMapper;
import org.auctionsystem.Dtos.request.CreateAuctionRequest;
import org.auctionsystem.models.AuctionItem;
import org.auctionsystem.models.Bid;
import org.auctionsystem.services.AuctionService;
import org.auctionsystem.services.BidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auctions")
@RequiredArgsConstructor
public class AuctionController {
    private final AuctionService auctionService;
    private final BidService bidService;

    @PostMapping("/register")
    public ResponseEntity<AuctionItemDto> createAuction(@RequestBody CreateAuctionRequest req) {
        AuctionItem entity = DtoMapper.toAuctionItemEntity(new AuctionItemDto(
                null, req.getTitle(), req.getDescription(),
                req.getStartingPrice(), req.getStartTime(),
                req.getEndTime(), "Upcoming")
        );
        AuctionItem saved = auctionService.createAuction(entity);
        return ResponseEntity.ok(DtoMapper.toAuctionItemDto(saved));
    }

    @GetMapping("/login")
    public ResponseEntity<List<AuctionItemDto>> listAllAuctions() {
        List<AuctionItemDto> dtos = auctionService.getAllAuctions()
                .stream().map(DtoMapper::toAuctionItemDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
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