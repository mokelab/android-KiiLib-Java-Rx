package com.mokelab.demo.rx.observable;

import io.reactivex.Observable;

/**
 * Repository
 */
public class UserRepository {
    public Observable<User> getUser(int id) {
        return Observable.just(new User(id, "user-" + id));
    }
}
