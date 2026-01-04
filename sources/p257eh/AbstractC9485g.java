package p257eh;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: eh.g */
/* loaded from: classes4.dex */
public abstract class AbstractC9485g {

    /* renamed from: a */
    public SharedPreferences f47258a;

    public AbstractC9485g(Context context, String str) {
        this.f47258a = context.getSharedPreferences(str, 0);
    }

    /* renamed from: a */
    public String m59336a(String str, String str2) {
        try {
            return this.f47258a.getString(str, str2);
        } catch (Exception unused) {
            this.f47258a.edit().remove(str).commit();
            return str2;
        }
    }

    /* renamed from: b */
    public void m59337b(String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = this.f47258a.edit();
            editorEdit.putString(str, str2);
            editorEdit.commit();
        } catch (Exception e10) {
            C9490l.m59350b("BaseSharedPreference", "putString error!!key:" + str, e10);
        }
    }
}
