package com.learnjava.completablefuture.assignment3;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;

class StringLengthTest {

    @Test
    void helloWorld_withSize() {
        CompletableFuture<String> completableFuture = StringLength.helloWorld_withSize("Hello world");

        completableFuture.thenAccept(text -> {
            assertEquals("11 - Hello world", text);
            System.out.println(text);
        }).join();
    }
}