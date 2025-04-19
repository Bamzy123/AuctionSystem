package org.auctionsystem.Dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private String userId;
    private String userName;

    public UserDto() {}

    public UserDto(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

}
