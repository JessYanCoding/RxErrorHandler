/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.jessyan.rxerrorhandler.core;

import android.content.Context;

import me.jessyan.rxerrorhandler.handler.ErrorHandlerFactory;
import me.jessyan.rxerrorhandler.handler.listener.ResponseErrorListener;

/**
 * ================================================
 * Created by JessYan on 9/2/2016 13:27
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class RxErrorHandler {
    public final String TAG = this.getClass().getSimpleName();
    private ErrorHandlerFactory mHandlerFactory;

    private RxErrorHandler(Builder builder) {
        this.mHandlerFactory = builder.errorHandlerFactory;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ErrorHandlerFactory getHandlerFactory() {
        return mHandlerFactory;
    }

    public static final class Builder {
        private Context context;
        private ResponseErrorListener mResponseErrorListener;
        private ErrorHandlerFactory errorHandlerFactory;

        private Builder() {
        }

        public Builder with(Context context) {
            if (context == null)
                throw new NullPointerException("Context cannot be null");
            this.context = context;
            return this;
        }

        public Builder responseErrorListener(ResponseErrorListener responseErrorListener) {
            if (responseErrorListener == null)
                throw new NullPointerException("responseErrorListener cannot be null");
            this.mResponseErrorListener = responseErrorListener;
            return this;
        }

        public RxErrorHandler build() {
            if (context == null)
                throw new IllegalStateException("Context is required");

            if (mResponseErrorListener == null)
                throw new IllegalStateException("ResponseErrorListener is required");

            this.errorHandlerFactory = new ErrorHandlerFactory(context, mResponseErrorListener);

            return new RxErrorHandler(this);
        }
    }


}
