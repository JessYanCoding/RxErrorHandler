# RxErrorHandler
[![License](http://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square)](http://www.apache.org/licenses/LICENSE-2.0)

##error handle of Rxjava

##Step 1
```
  RxErrorHandler rxErrorHandler = RxErrorHandler 
                .builder()
                .with(this)
                .responseErroListener(new ResponseErroListener() {
                    @Override
                    public void handleResponseError(Context context, Exception e) {
                        Log.w(TAG, "error handle");
                    } 
                }).build();
```

##Step 2
```
  Observable
            .error(new Exception("erro"))
            .retryWhen(new RetryWithDelay(3, 2))//retry(http connect timeout) 
            .subscribe(new ErrorHandleSubscriber<Object>(rxErrorHandler) {
                    @Override
                    public void onNext(Object o) {

                    }

                });
```

##About Me 
* **Email**: jess.yan.effort@gmail.com   

##License
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
