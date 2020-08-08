package com.zero.rxjava2;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

/**
 * 冷： 观察者订阅了，才会开始执行发射数据流的代码
 * Observable  和 Observer 是一对一的关系
 * 对 Cold Observable 而已，有多个Observer的时候，
 * 它们各自的事件是独立的
 * 事件是什么？
 *  事件类型         作用
 *   onNext()        观察者会回调它的onNext()方法
 *   onError()        onError事件发送之后，其他事件不会继续发送
 *   onComplete()     onComplete事件发送之后，其他事件不会继续发送
 */
public class ColdObservableDemo {

    public static void main(String ... args){
            //TODO:

        //创建一个"冷"的被观察者
        Observable<Long> observable = Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> emitter) throws Exception {
                Observable.interval(10, TimeUnit.MILLISECONDS,
                        Schedulers.computation())
                        .take(Integer.MAX_VALUE)
                        .subscribe(emitter::onNext);
            }
        }).observeOn(Schedulers.newThread());

//        ((ConnectableObservable<Long>) observable).connect();

        observable.subscribe(new io.reactivex.functions.Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("consumer1: " + aLong);
            }
        });

        observable.subscribe(new io.reactivex.functions.Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("    consumer2: " + aLong);
            }
        });

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        observable.subscribe(new io.reactivex.functions.Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("            consumer3: " + aLong);
            }
        });

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
