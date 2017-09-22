# RxErrorHandler
[ ![Bintray](https://img.shields.io/badge/bintray-v2.1.0-brightgreen.svg) ](https://bintray.com/jessyancoding/maven/rxerrorhandler/2.1.0/link)
[ ![Build Status](https://travis-ci.org/JessYanCoding/RxErrorHandler.svg?branch=master) ](https://travis-ci.org/JessYanCoding/RxErrorHandler)
[ ![API](https://img.shields.io/badge/API-15%2B-blue.svg?style=flat-square) ](https://developer.android.com/about/versions/android-4.0.3.html)
[ ![License](http://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square) ](http://www.apache.org/licenses/LICENSE-2.0)

## Error Handle Of Rxjava

## Download

``` gradle
compile 'me.jessyan:rxerrorhandler:2.1.0' //rxjava2

compile 'me.jessyan:rxerrorhandler:1.0.1' //rxjava1
```

## Initialization

``` java
  RxErrorHandler rxErrorHandler = RxErrorHandler 
                .builder()
                .with(this)
                .responseErrorListener(new ResponseErrorListener() {
                    @Override
                    public void handleResponseError(Context context, Throwable t) {
                        if (t instanceof UnknownHostException) {
                            //do something ...
                        } else if (t instanceof SocketTimeoutException) {
                            //do something ...
                        } else {
                            //handle other Exception ...
                        }
                        Log.w(TAG, "Error handle");
                    }
                }).build();
```

## Usage

``` java
  Observable
            .error(new Exception("Error"))
            .retryWhen(new RetryWithDelay(3, 2))//retry(http connect timeout) 
            .subscribe(new ErrorHandleSubscriber<Object>(rxErrorHandler) {
                    @Override
                    public void onNext(Object o) {

                    }

                });

  //Backpressure
  Flowable
          .error(new Exception("Error"))
          .retryWhen(new RetryWithDelayOfFlowable(3, 2))//retry(http connect timeout)
          .subscribe(new ErrorHandleSubscriberOfFlowable<Object>(rxErrorHandler) {
                   @Override
               public void onNext(Object o) {

                  }
               });
```


## About Me
* **Email**: <jess.yan.effort@gmail.com>  
* **Home**: <http://jessyan.me>
* **掘金**: <https://gold.xitu.io/user/57a9dbd9165abd0061714613>
* **简书**: <http://www.jianshu.com/u/1d0c0bc634db>  

## License
``` 
 Copyright 2016, jessyan               
  
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at   

       http://www.apache.org/licenses/LICENSE-2.0  

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License. 
```
