package lib.data.avatar.poem;

import java.util.List;

import lib.data.BaseReq;
import rx.Observable;

/**
 * Created by 军军 on 2017/8/8.
 */

public class PoemReq extends BaseReq {

    private static PoemReq _$;
    private PoemApi api;

    private PoemReq(){
        api = mRetrofit.create(PoemApi.class);
    }

    @Override
    protected String baseUrl() {
        return PoemApi.URL;
    }

    public static PoemReq $(){
        if(_$ == null){
            synchronized (PoemReq.class){
                _$ = new PoemReq();
            }
        }

        return _$;
    }

    public Observable<Rsp<List<PoemId>>> search(String keyword){
        return api.search(PoemApi.apiKey,keyword);
    }

    public Observable<Rsp<Poem>> byId(String poemId){
        return api.poemById(PoemApi.apiKey,poemId);
    }

    public Observable<Rsp<Poem>> rand(){
        return api.randPoem(PoemApi.apiKey);
    }
}
