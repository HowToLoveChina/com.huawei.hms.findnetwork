package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class IntentCheckUtils {
    private static final String TAG = "IntentCheckUtils";
    private static final String TYPE_IMAGE = "image/*,video/*";

    public static Intent createGalleryIntent(Context context) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setTypeAndNormalize(TYPE_IMAGE);
        return getSystemIntent(intent, context);
    }

    private static Intent getSystemIntent(Intent intent, Context context) throws Throwable {
        if (intent != null && context != null) {
            try {
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                PackageManager packageManager = context.getPackageManager();
                if (listQueryIntentActivities == null) {
                    return null;
                }
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    String str = it.next().activityInfo.packageName;
                    if ((packageManager.getApplicationInfo(str, 0).flags & 1) != 0) {
                        intent.setPackage(str);
                        return intent;
                    }
                }
            } catch (Throwable unused) {
                FaqLogger.m51836d(TAG, "getSystemIntent error");
            }
        }
        return null;
    }
}
