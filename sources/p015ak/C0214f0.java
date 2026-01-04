package p015ak;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import p399jk.AbstractC10896a;

/* renamed from: ak.f0 */
/* loaded from: classes6.dex */
public class C0214f0 {
    /* renamed from: a */
    public static Context m1381a(Context context, String str) {
        Context contextM1378b = C0213f.m1378b();
        SharedPreferences sharedPreferences = contextM1378b.getSharedPreferences("move2DE_records", 0);
        if (sharedPreferences.getBoolean(str, false)) {
            return contextM1378b;
        }
        if (!contextM1378b.moveDatabaseFrom(context, str)) {
            AbstractC10896a.m65888w("SPUtilDE", "moveDatabase4DE failed");
            return context;
        }
        AbstractC10896a.m65885d("SPUtilDE", "moveDatabase4DE success");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(str, true);
        editorEdit.apply();
        return contextM1378b;
    }

    /* renamed from: b */
    public static SharedPreferences m1382b(Context context, String str, int i10) {
        if (context == null) {
            AbstractC10896a.m65886e("SPUtilDE", "getSharedPreferences context is null");
            return null;
        }
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences("move2DE_records", 0);
        if (sharedPreferences.getBoolean(str, false)) {
            context = contextCreateDeviceProtectedStorageContext;
        } else if (contextCreateDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, true);
            editorEdit.apply();
            context = contextCreateDeviceProtectedStorageContext;
        } else {
            AbstractC10896a.m65886e("SPUtilDE", "Failed to move shared preference");
        }
        return context.getSharedPreferences(str, i10);
    }

    @TargetApi(24)
    /* renamed from: c */
    public static Context m1383c(Context context, String str) {
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        if (!contextCreateDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
            AbstractC10896a.m65886e("ContentValues", "failed to migrate shared pref:" + str);
        }
        AbstractC10896a.m65887i("ContentValues", "in N, migrate ok");
        return contextCreateDeviceProtectedStorageContext;
    }
}
