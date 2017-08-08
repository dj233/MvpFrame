package lib.data.avatar.xiehouyu;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface XieHouYuApi {
    String URL = "http://api.avatardata.cn/";
    String apiKey = "bed825fcd1fb44c3bf04d66eb0cf8f68";

    @GET("/XieHouYu/Search")
    Observable<Rsp<List<XieHouYu>>> search(@Query("key") String apiKey, @Query("keyWord") String keyword);

    @GET("/XieHouYu/Random")
    Observable<Rsp<XieHouYu>> randXieHouYu(@Query("key") String apiKey);

}
