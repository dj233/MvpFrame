package lib.data.avatar.phrase;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface PhraseApi {
    String URL = "http://api.avatardata.cn/";
    String apiKey = "cf3a5cbb16774b43a6fc83997e1b2a6d";

    @GET("/ChengYu/Search")
    Observable<Rsp<List<PhraseId>>> search(@Query("key") String apiKey, @Query("keyWord") String keyword);

    @GET("/ChengYu/LookUp")
    Observable<Rsp<Phrase>> phraseById(@Query("key") String apiKey, @Query("id") String phraseId);

    @GET("/ChengYu/Random")
    Observable<Rsp<Phrase>> randPhrase(@Query("key") String apiKey);

}
