package com.bootcamp.clinic.exception;

public class RoomNotFound extends RuntimeException {
    public RoomNotFound() {
        super("Room not found.");
    }

    public RoomNotFound(String message) {
        super(message);
    }
}
