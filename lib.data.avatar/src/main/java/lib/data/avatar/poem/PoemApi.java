package lib.data.avatar.poem;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface PoemApi {
    String URL = "http://api.avatardata.cn/";
    String apiKey = "6f4215f72d9940e2a39315c71540c5aa";

    @GET("/TangShiSongCi/Search")
    Observable<Rsp<List<PoemId>>> search(@Query("key") String apiKey, @Query("keyWord") String keyword);

    @GET("/TangShiSongCi/LookUp")
    Observable<Rsp<Poem>> poemById(@Query("key") String apiKey,@Query("id") String poemId);

    @GET("/TangShiSongCi/Random")
    Observable<Rsp<Poem>> randPoem(@Query("key") String apiKey);

}
