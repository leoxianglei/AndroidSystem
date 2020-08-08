package com.zero.rxjavademo;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. 创建一个Observable  可被观察的
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                if(!emitter.isDisposed()){
                    emitter.onNext("hello rxjava2");
                    emitter.onNext("小伙伴们，你们好");
                }
                emitter.onComplete();
            }
        });
        //2. 创建一个Observer 观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("Zero","onSubscribe: " + d);
            }

            @Override
            public void onNext(String s) {
                Log.i("Zero","onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("Zero","onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i("Zero","onComplete ");
            }
        };
        //3 观察者通过订阅(subscribe)被观察者 把它们连接到一起
        //observer(观察者) 订阅 observable(被观察者)
        observable.subscribe(observer);

    }
}
