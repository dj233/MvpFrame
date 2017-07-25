package lib.data.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.v4.app.ActivityCompat;

public class DrawableConvert {

    private DrawableConvert(){

    }

    private static DrawableConvert _$;
    public static DrawableConvert $(){
        if(_$ == null){
            synchronized (DrawableConvert.class){
                _$ = new DrawableConvert();
            }
        }
        return _$;
    }


    public Bitmap fromDrawable(Drawable drawable){
        BitmapDrawable bd = (BitmapDrawable) drawable;
        return bd.getBitmap();
    }

    public Bitmap fromRes(Context ctx,@IdRes int resId){
        Resources res = ctx.getResources();
        return BitmapFactory.decodeResource(res,resId);
    }
}
