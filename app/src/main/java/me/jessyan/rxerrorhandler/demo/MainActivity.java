package me.jessyan.rxerrorhandler.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;
import me.jessyan.rxerrorhandler.handler.listener.ResponseErroListener;
import rx.Observable;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RxErrorHandler rxErrorHandler = RxErrorHandler
                .builder()
                .with(this)
                .responseErroListener(new ResponseErroListener() {
                    @Override
                    public void handleResponseError(Context context, Exception e) {
                        Log.w(TAG, "error handle");
                    }
                }).build();


        Observable
                .error(new Exception("erro"))
                .retryWhen(new RetryWithDelay(3, 2))//retry(http connect timeout)
                .subscribe(new ErrorHandleSubscriber<Object>(rxErrorHandler) {
                    @Override
                    public void onNext(Object o) {

                    }

                });
    }
}
