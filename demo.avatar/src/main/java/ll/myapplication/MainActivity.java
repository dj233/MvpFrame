package ll.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import lib.data.avatar.famous.Famous;
import lib.data.avatar.famous.FamousReq;
import lib.data.avatar.famous.Rsp;
import lib.data.avatar.phrase.Phrase;
import lib.data.avatar.phrase.PhraseId;
import lib.data.avatar.phrase.PhraseReq;
import lib.data.avatar.poem.Poem;
import lib.data.avatar.poem.PoemId;
import lib.data.avatar.poem.PoemReq;
import lib.data.avatar.xiehouyu.XieHouYu;
import lib.data.avatar.xiehouyu.XieHouYuReq;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Net";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        testReq();
    }


    
    public void testReq(){
        testFamouse();
    }

    
    public void testFamouse(){
        FamousReq.$().rand().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Rsp<Famous>>() {
            @Override
            public void call(Rsp<Famous> famousRsp) {
                Log.e(TAG,"Framous : " + famousRsp.toString());
            }
        });

        FamousReq.$().search("成功").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Rsp<List<Famous>>>() {
            @Override
            public void call(Rsp<List<Famous>> listRsp) {
                Log.e(TAG,"Famous Size : " + listRsp.toString());
            }
        });
    }

    
    public void testPhrase(){
        PhraseReq.$().search("快").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<lib.data.avatar.phrase.Rsp<List<PhraseId>>>() {
            @Override
            public void call(lib.data.avatar.phrase.Rsp<List<PhraseId>> listRsp) {

            }
        });

        PhraseReq.$().byId("").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<lib.data.avatar.phrase.Rsp<Phrase>>() {
            @Override
            public void call(lib.data.avatar.phrase.Rsp<Phrase> phraseRsp) {

            }
        });

        PhraseReq.$().rand().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<lib.data.avatar.phrase.Rsp<Phrase>>() {
            @Override
            public void call(lib.data.avatar.phrase.Rsp<Phrase> phraseRsp) {

            }
        });
    }

    
    public void testPoem(){
        PoemReq.$().rand().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<lib.data.avatar.poem.Rsp<Poem>>() {
            @Override
            public void call(lib.data.avatar.poem.Rsp<Poem> poemRsp) {

            }
        });

        PoemReq.$().search("春").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<lib.data.avatar.poem.Rsp<List<PoemId>>>() {
            @Override
            public void call(lib.data.avatar.poem.Rsp<List<PoemId>> listRsp) {

            }
        });

        PoemReq.$().byId("").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<lib.data.avatar.poem.Rsp<Poem>>() {
            @Override
            public void call(lib.data.avatar.poem.Rsp<Poem> poemRsp) {

            }
        });
    }

    public void testXieHouYu(){
        XieHouYuReq.$().search("鬼").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<lib.data.avatar.xiehouyu.Rsp<List<XieHouYu>>>() {
            @Override
            public void call(lib.data.avatar.xiehouyu.Rsp<List<XieHouYu>> listRsp) {

            }
        });

        XieHouYuReq.$().rand().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<lib.data.avatar.xiehouyu.Rsp<XieHouYu>>() {
            @Override
            public void call(lib.data.avatar.xiehouyu.Rsp<XieHouYu> xieHouYuRsp) {

            }
        });
    }
}
