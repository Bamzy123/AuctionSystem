package org.auctionsystem.Dtos;

import org.auctionsystem.models.AuctionItem;
import org.auctionsystem.models.BasicUser;
import org.auctionsystem.models.Bid;
import org.auctionsystem.models.User;

public class DtoMapper {
    public static User toUserEntity(UserDto dto) {
        return new BasicUser(dto.getUserId(), dto.getUserName());
    }

    public static AuctionItemDto toAuctionItemDto(AuctionItem item) {
        return new AuctionItemDto(
                item.getItemId(), item.getTitle(), item.getDescription(),
                item.getStartingPrice(), item.getStartTime(),
                item.getEndTime(), item.getStatus()
        );
    }

    public static BidDto toBidDto(Bid bid) {
        return new BidDto(
                bid.getBidId(),
                bid.getBidder().getUserId(),
                bid.getAuctionItem().getItemId(),
                bid.getAmount(), bid.getTimestamp()
        );
    }

    public static AuctionItem toAuctionItemEntity(AuctionItemDto dto) {
        AuctionItem item = new AuctionItem();
        item.setItemId(dto.getItemId());
        item.setTitle(dto.getTitle());
        item.setDescription(dto.getDescription());
        item.setStartingPrice(dto.getStartingPrice());
        item.setStartTime(dto.getStartTime());
        item.setEndTime(dto.getEndTime());
        item.setStatus(dto.getStatus());
        return item;
    }
    public static Bid toBidEntity(BidDto dto) {
        Bid bid = new Bid();
        bid.setBidId(dto.getBidId());
        bid.setAmount(dto.getAmount());
        bid.setTimestamp(dto.getTimestamp());
        // bidder and auctionItem references should be set in service/controller by fetching entities
        return bid;
    }
}
