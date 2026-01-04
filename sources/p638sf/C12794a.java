package p638sf;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import p013ah.C0198c;
import p015ak.C0214f0;

/* renamed from: sf.a */
/* loaded from: classes4.dex */
public class C12794a {
    /* renamed from: a */
    public static void m76762a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "cmdreportretry", 0).edit();
        editorEdit.remove(str);
        editorEdit.commit();
    }

    /* renamed from: b */
    public static String m76763b(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            String string = C0214f0.m1382b(context, "cmdreportretry", 0).getString(str, null);
            if (!TextUtils.isEmpty(string)) {
                return C0198c.m1097a(context, string);
            }
        }
        return null;
    }

    /* renamed from: c */
    public static void m76764c(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "cmdreportretry", 0).edit();
        editorEdit.putString(str, C0198c.m1098b(context, str2));
        editorEdit.commit();
    }
}
