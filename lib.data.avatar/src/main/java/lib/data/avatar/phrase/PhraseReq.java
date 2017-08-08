package lib.data.avatar.phrase;

import java.util.List;

import lib.data.BaseReq;
import rx.Observable;

/**
 * Created by 军军 on 2017/8/8.
 */

public class PhraseReq extends BaseReq {

    private static PhraseReq _$;
    private PhraseApi api;

    private PhraseReq(){
        api = mRetrofit.create(PhraseApi.class);
    }

    @Override
    protected String baseUrl() {
        return PhraseApi.URL;
    }

    public static PhraseReq $(){
        if(_$ == null){
            synchronized (PhraseReq.class){
                _$ = new PhraseReq();
            }
        }

        return _$;
    }

    public Observable<Rsp<List<PhraseId>>> search(String keyword){
        return api.search(PhraseApi.apiKey,keyword);
    }

    public Observable<Rsp<Phrase>> byId(String poemId){
        return api.phraseById(PhraseApi.apiKey,poemId);
    }

    public Observable<Rsp<Phrase>> rand(){
        return api.randPhrase(PhraseApi.apiKey);
    }
}
