package lib.data.avatar.famous;

import java.util.List;

import lib.data.BaseReq;
import rx.Observable;

/**
 * Created by 军军 on 2017/8/8.
 */

public class FamousReq extends BaseReq {

    private static FamousReq _$;
    private FamousApi api;

    private FamousReq(){
        api = mRetrofit.create(FamousApi.class);
    }

    @Override
    protected String baseUrl() {
        return FamousApi.URL;
    }

    public static FamousReq $(){
        if(_$ == null){
            synchronized (FamousReq.class){
                _$ = new FamousReq();
            }
        }

        return _$;
    }

    public Observable<Rsp<List<Famous>>> search(String keyword){
        return api.search(FamousApi.apiKey,keyword);
    }

    public Observable<Rsp<Famous>> rand(){
        return api.randFamous(FamousApi.apiKey);
    }
}
