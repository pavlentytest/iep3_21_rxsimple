package ru.samsung.itschool.mdev;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Main {

    public static void main(String[] args) {

        Observable<String> myobservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                // логика
                int i = 0;
                while(i<5) {
                    emitter.onNext("Return value from Observable: "+i);
                    i++;
                }
                emitter.onComplete();
            }
        });

        Observer<String> myobserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed!");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("Get value: "+s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed!");
            }
        };

        myobservable.subscribe(myobserver);
    }
}
