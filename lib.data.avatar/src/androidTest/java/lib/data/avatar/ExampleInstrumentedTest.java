package lib.data.avatar;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

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

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private static final String TAG = "Net";

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("lib.data.avatar.test", appContext.getPackageName());
    }

    @Test
    public void testReq(){
        testFamouse();
    }

    @Test
    public void testFamouse(){
        FamousReq.$().rand().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Rsp<Famous>>() {
            @Override
            public void call(Rsp<Famous> famousRsp) {
                System.out.println("Famous Size : " + famousRsp.toString());
            }
        });

        FamousReq.$().search("成功").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Rsp<List<Famous>>>() {
            @Override
            public void call(Rsp<List<Famous>> listRsp) {
                System.out.println("Famous Size : " + listRsp.toString());
            }
        });
    }

    @Test
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

    @Test
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
