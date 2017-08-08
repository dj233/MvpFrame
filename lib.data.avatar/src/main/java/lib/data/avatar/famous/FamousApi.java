package lib.data.avatar.famous;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface FamousApi {
    String URL = "http://api.avatardata.cn/";
    String apiKey = "a0f7957329e94817a3b9ae59cfa8629d";

    @GET("/ChengYu/Search")
    Observable<Rsp<List<Famous>>> search(@Query("key") String apiKey, @Query("keyWord") String keyword);

    @GET("/ChengYu/Random")
    Observable<Rsp<Famous>> randFamous(@Query("key") String apiKey);

}
