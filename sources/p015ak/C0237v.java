package p015ak;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import p399jk.AbstractC10896a;

/* renamed from: ak.v */
/* loaded from: classes6.dex */
public class C0237v {
    /* renamed from: a */
    public static void m1659a() {
        try {
            SharedPreferences sharedPreferencesM1660b = m1660b(C0213f.m1377a(), "worry_free_space_check");
            if (sharedPreferencesM1660b != null) {
                sharedPreferencesM1660b.edit().clear().apply();
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("NotEnoughSpUtil", "clear exception: " + e10.toString());
        }
    }

    /* renamed from: b */
    public static SharedPreferences m1660b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return context.getSharedPreferences(str, 0);
    }

    /* renamed from: c */
    public static void m1661c() {
        SharedPreferences sharedPreferencesM1660b = m1660b(C0213f.m1377a(), "worry_free_space_check");
        if (sharedPreferencesM1660b == null) {
            AbstractC10896a.m65887i("NotEnoughSpUtil", "not enough sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1660b.edit();
        if (editorEdit == null) {
            AbstractC10896a.m65888w("NotEnoughSpUtil", "editor is null");
            return;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        AbstractC10896a.m65887i("NotEnoughSpUtil", "record not enough time sign recordTimes: " + strValueOf);
        editorEdit.putString("worry_free_space_check_fail", strValueOf).commit();
    }
}
