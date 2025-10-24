package com.celada;

public interface Subscriber<T> {
    void onNext(T next);
    String getName();
//    void onError(T next);
//    void onCancel(T next);
}
