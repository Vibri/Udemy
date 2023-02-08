package com.learnjava.completablefuture.assignment3;

import java.util.concurrent.CompletableFuture;

public class StringLength {

    public static CompletableFuture<String> helloWorld_withSize(final String text) {
        return CompletableFuture.supplyAsync(() -> {
            int legth = text.length();
            StringBuilder builder = new StringBuilder(Integer.toString(legth));
            builder.append(" - ");
            builder.append(text);
            return builder.toString();
        });
    }
}
