package com.celada;


import lombok.extern.java.Log;

@Log//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Publisher
        final ReactiveStream<String> stringStream = new ReactiveStream<>();
        final ReactiveStream<Integer> intStream = new ReactiveStream<>();

        // Subscribers
        final String subName1 = "Sub-1";
        final String subName2 = "Sub-2";
        final String subName3 = "Sub-3";
        final String subName4 = "Sub-4";

        final Subscriber<String> sub1 = new SubscriberImpl<>(str -> "Length: " + str.length(), subName1);
        final Subscriber<String> sub2 = new SubscriberImpl<>(String::toUpperCase, subName2);
        final Subscriber<Integer> sub3 = new SubscriberImpl<>(i -> "Value: " + i, subName3);
        final Subscriber<Integer> sub4 = new SubscriberImpl<>(i -> "Square: " + i * i, subName4);

        // Subscriptions
        stringStream
                .subscribe(sub1)
                .subscribe(sub2);

        intStream
                .subscribe(sub3)
                .subscribe(sub4);

        // Emissions
        stringStream.emit("hello world");
        stringStream.emit("this is a subscriber observer pattern");

        intStream.emit(5);
        intStream.emit(10);

        // Unsubscriptions
        stringStream.unsubscribe(sub1);
        intStream.unsubscribe(sub3);

        // Emissions
        stringStream.emit("hello world");
        stringStream.emit("this is a subscriber observer pattern");

        intStream.emit(5);
        intStream.emit(10);
    }
}