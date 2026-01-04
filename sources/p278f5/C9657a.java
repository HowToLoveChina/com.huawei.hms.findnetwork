package p278f5;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.backup.filelogic.appdata.model.AppSizeBean;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.hicloud.notification.constants.HNConstants;

/* renamed from: f5.a */
/* loaded from: classes.dex */
public class C9657a {
    /* renamed from: a */
    public static void m60321a(Context context) {
        if (context == null) {
            C2111d.m12657m("LoadCacheHelper", "clearAppSizeCache, context is null");
        } else {
            C2111d.m12653i("LoadCacheHelper", "clearAppSizeCache");
            context.getSharedPreferences(HNConstants.C4907SP.APP_SIZE, 0).edit().clear().apply();
        }
    }

    /* renamed from: b */
    public static AppSizeBean m60322b(Context context, String str) {
        if (context == null || str == null) {
            C2111d.m12657m("LoadCacheHelper", "getAppSize, param is null");
            return null;
        }
        String string = context.getSharedPreferences(HNConstants.C4907SP.APP_SIZE, 0).getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return (AppSizeBean) new Gson().fromJson(string, AppSizeBean.class);
        } catch (JsonSyntaxException e10) {
            C2111d.m12649e("LoadCacheHelper", "getAppSize JsonSyntaxException ", e10.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static void m60323c(Context context, String str, AppSizeBean appSizeBean) {
        if (context == null || str == null || appSizeBean == null) {
            C2111d.m12657m("LoadCacheHelper", "saveAppSize, param is null");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(HNConstants.C4907SP.APP_SIZE, 0).edit();
        editorEdit.putString(str, new Gson().toJson(appSizeBean));
        editorEdit.apply();
    }
}
