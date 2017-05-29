package me.jessyan.rxerrorhandler.handler.listener;

import android.content.Context;

/**
 * Created by jess on 9/2/16 13:58
 * Contact with jess.yan.effort@gmail.com
 */
public interface ResponseErrorListener {
    void handleResponseError(Context context, Throwable t);

    ResponseErrorListener EMPTY = new ResponseErrorListener() {
        @Override
        public void handleResponseError(Context context, Throwable t) {


        }
    };
}
