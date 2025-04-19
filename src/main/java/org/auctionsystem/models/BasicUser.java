package org.auctionsystem.models;

public class BasicUser extends User {
    public BasicUser() {
        super();
    }

    public BasicUser(String userId, String username) {
        super(userId, username, null);
    }
}