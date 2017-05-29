package me.jessyan.rxerrorhandler.handler;

import android.content.Context;

import me.jessyan.rxerrorhandler.handler.listener.ResponseErrorListener;

/**
 * Created by jess on 9/2/16 13:47
 * Contact with jess.yan.effort@gmail.com
 */
public class ErrorHandlerFactory {
    public final String TAG = this.getClass().getSimpleName();
    private Context mContext;
    private ResponseErrorListener mResponseErrorListener;

    public ErrorHandlerFactory(Context mContext, ResponseErrorListener mResponseErrorListener) {
        this.mResponseErrorListener = mResponseErrorListener;
        this.mContext = mContext;
    }

    /**
     *  处理错误
     * @param throwable
     */
    public void handleError(Throwable throwable) {
        mResponseErrorListener.handleResponseError(mContext, throwable);
    }
}
