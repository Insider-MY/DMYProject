package com.lyd.newsstory.retortfit;

import com.lyd.newsstory.bean.MeiNvGson;
import com.lyd.newsstory.bean.NewsGson;



import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {

    @GET("{type}/")
    Observable <NewsGson> getNewsData(@Path("type") String type, @Query("key") String key, @Query("num") String num, @Query("page") int page);




    @GET("meinv/")
    Observable <MeiNvGson> getPictureData(@Query("key") String key, @Query("num") String num, @Query("page") int page);
}
