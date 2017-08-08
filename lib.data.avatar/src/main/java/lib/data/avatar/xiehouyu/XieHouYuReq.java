package lib.data.avatar.xiehouyu;

import java.util.List;

import lib.data.BaseReq;
import rx.Observable;

/**
 * Created by 军军 on 2017/8/8.
 */

public class XieHouYuReq extends BaseReq {

    private static XieHouYuReq _$;
    private XieHouYuApi api;

    private XieHouYuReq(){
        api = mRetrofit.create(XieHouYuApi.class);
    }

    @Override
    protected String baseUrl() {
        return XieHouYuApi.URL;
    }

    public static XieHouYuReq $(){
        if(_$ == null){
            synchronized (XieHouYuReq.class){
                _$ = new XieHouYuReq();
            }
        }

        return _$;
    }

    public Observable<Rsp<List<XieHouYu>>> search(String keyword){
        return api.search(XieHouYuApi.apiKey,keyword);
    }

    public Observable<Rsp<XieHouYu>> rand(){
        return api.randXieHouYu(XieHouYuApi.apiKey);
    }
}
