package lib.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.text.TextUtils;

public class IntentUtils {

    public static void launchAppDetail(Context context,String appPkg, String marketPkg) {
        try {
            if (TextUtils.isEmpty(appPkg)) return;
            Uri uri = Uri.parse("market://details?id=" + appPkg);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (!TextUtils.isEmpty(marketPkg)) {
                intent.setPackage(marketPkg);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void launchThisAppDetail(Context context,String marketPkg){
        String appPkg = context.getPackageName();
        launchAppDetail(context,appPkg,marketPkg);
    }

    public static void launchAppTencent(Context context,String appPkg) {
        launchAppDetail(context,appPkg,"com.tencent.android.qqdownloader");
    }

    public static void launchThisAppTencent(Context context) {
        launchThisAppDetail(context,"com.tencent.android.qqdownloader");
    }


    public static void shareImager(Context context, int imgResId,String content){
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, resourceIdToUri(context,imgResId));
        shareIntent.setType("image/jpeg");
        context.startActivity(Intent.createChooser(shareIntent, content));
    }

    private static final String ANDROID_RESOURCE = "android.resource://";
    private static final String FOREWARD_SLASH = "/";

    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }
}
