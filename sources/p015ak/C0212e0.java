package p015ak;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import p399jk.AbstractC10896a;

/* renamed from: ak.e0 */
/* loaded from: classes6.dex */
public class C0212e0 {

    /* renamed from: ak.e0$a */
    public class a<T> extends TypeToken<List<T>> {
    }

    /* renamed from: a */
    public static void m1351a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().clear().commit();
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "clear exception: " + e10.toString());
        }
    }

    /* renamed from: b */
    public static void m1352b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            context.getSharedPreferences(str, 0).edit().clear().commit();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "clearSpCE exception: " + e10.toString());
        }
    }

    /* renamed from: c */
    public static void m1353c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0214f0.m1382b(C0213f.m1377a(), str, 0).edit().clear().commit();
    }

    /* renamed from: d */
    public static boolean m1354d(Context context, String str, String str2, boolean z10) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return z10;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            return sharedPreferences != null ? sharedPreferences.getBoolean(str2, z10) : z10;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "getBoolean exception: " + e10.toString());
            return z10;
        }
    }

    /* renamed from: e */
    public static boolean m1355e(Context context, String str, String str2, boolean z10) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return z10;
        }
        try {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, str, 0);
            return sharedPreferencesM1382b != null ? sharedPreferencesM1382b.getBoolean(str2, z10) : z10;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "getBooleanDE exception: " + e10.toString());
            return z10;
        }
    }

    /* renamed from: f */
    public static <T> List<T> m1356f(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return arrayList;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences == null) {
                return arrayList;
            }
            String string = sharedPreferences.getString(str2, "");
            return TextUtils.isEmpty(string) ? arrayList : (List) new Gson().fromJson(string, new a().getType());
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "putDataList exception: " + e10.toString());
            return arrayList;
        }
    }

    /* renamed from: g */
    public static int m1357g(Context context, String str, String str2, int i10) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return i10;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            return sharedPreferences != null ? sharedPreferences.getInt(str2, i10) : i10;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "getInt exception: " + e10.toString());
            return i10;
        }
    }

    /* renamed from: h */
    public static int m1358h(Context context, String str, String str2, int i10) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return i10;
        }
        try {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, str, 0);
            return sharedPreferencesM1382b != null ? sharedPreferencesM1382b.getInt(str2, i10) : i10;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "getIntDE exception: " + e10.toString());
            return i10;
        }
    }

    /* renamed from: i */
    public static long m1359i(Context context, String str, String str2, long j10) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return j10;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            return sharedPreferences != null ? sharedPreferences.getLong(str2, j10) : j10;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "getLong exception: " + e10.toString());
            return j10;
        }
    }

    /* renamed from: j */
    public static long m1360j(Context context, String str, String str2, long j10) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return j10;
        }
        try {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, str, 0);
            return sharedPreferencesM1382b != null ? sharedPreferencesM1382b.getLong(str2, j10) : j10;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "getLongDE exception: " + e10.toString());
            return j10;
        }
    }

    /* renamed from: k */
    public static long m1361k(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0L;
        }
        return C0214f0.m1382b(C0213f.m1377a(), str, 0).getLong(str2, 0L);
    }

    /* renamed from: l */
    public static SharedPreferences m1362l(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return context.getSharedPreferences(str, 0);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("SharedPreferenceUtil", "getSharedPreferences exception: " + e10.toString());
            }
        }
        return null;
    }

    /* renamed from: m */
    public static String m1363m(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str3;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            return sharedPreferences != null ? sharedPreferences.getString(str2, str3) : str3;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "getString exception: " + e10.toString());
            return str3;
        }
    }

    /* renamed from: n */
    public static String m1364n(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str3;
        }
        try {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, str, 0);
            return sharedPreferencesM1382b != null ? sharedPreferencesM1382b.getString(str2, str3) : str3;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "getStringDE exception: " + e10.toString());
            return str3;
        }
    }

    /* renamed from: o */
    public static void m1365o(Context context, String str, String str2, boolean z10) {
        SharedPreferences.Editor editorEdit;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
                return;
            }
            editorEdit.putBoolean(str2, z10).commit();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "putBoolean exception: " + e10.toString());
        }
    }

    /* renamed from: p */
    public static void m1366p(Context context, String str, String str2, boolean z10) {
        SharedPreferences.Editor editorEdit;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, str, 0);
            if (sharedPreferencesM1382b == null || (editorEdit = sharedPreferencesM1382b.edit()) == null) {
                return;
            }
            editorEdit.putBoolean(str2, z10).commit();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "putBooleanDE exception: " + e10.toString());
        }
    }

    /* renamed from: q */
    public static <T> void m1367q(Context context, String str, String str2, List<T> list) {
        SharedPreferences.Editor editorEdit;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || list == null || list.size() <= 0) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
                return;
            }
            editorEdit.putString(str2, new Gson().toJson(list)).commit();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "putDataList exception: " + e10.toString());
        }
    }

    /* renamed from: r */
    public static void m1368r(Context context, String str, String str2, int i10) {
        SharedPreferences.Editor editorEdit;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
                return;
            }
            editorEdit.putInt(str2, i10).commit();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "putInt exception: " + e10.toString());
        }
    }

    /* renamed from: s */
    public static void m1369s(Context context, String str, String str2, int i10) {
        SharedPreferences.Editor editorEdit;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, str, 0);
            if (sharedPreferencesM1382b == null || (editorEdit = sharedPreferencesM1382b.edit()) == null) {
                return;
            }
            editorEdit.putInt(str2, i10).commit();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "putIntDE exception: " + e10.toString());
        }
    }

    /* renamed from: t */
    public static void m1370t(Context context, String str, String str2, long j10) {
        SharedPreferences.Editor editorEdit;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
                return;
            }
            editorEdit.putLong(str2, j10).commit();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "putLong exception: " + e10.toString());
        }
    }

    /* renamed from: u */
    public static void m1371u(Context context, String str, String str2, long j10) {
        SharedPreferences.Editor editorEdit;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, str, 0);
            if (sharedPreferencesM1382b == null || (editorEdit = sharedPreferencesM1382b.edit()) == null) {
                return;
            }
            editorEdit.putLong(str2, j10).commit();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "putLongDE exception: " + e10.toString());
        }
    }

    /* renamed from: v */
    public static void m1372v(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
                return;
            }
            editorEdit.putString(str2, str3).commit();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "putString exception: " + e10.toString());
        }
    }

    /* renamed from: w */
    public static void m1373w(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, str, 0);
            if (sharedPreferencesM1382b == null || (editorEdit = sharedPreferencesM1382b.edit()) == null) {
                return;
            }
            editorEdit.putString(str2, str3).commit();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "putStringDE exception: " + e10.toString());
        }
    }

    /* renamed from: x */
    public static void m1374x(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().remove(str2).apply();
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "remove exception: " + e10.toString());
        }
    }

    /* renamed from: y */
    public static void m1375y(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, str, 0);
            if (sharedPreferencesM1382b != null) {
                sharedPreferencesM1382b.edit().remove(str2).apply();
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SharedPreferenceUtil", "remove DE exception: " + e10.toString());
        }
    }

    /* renamed from: z */
    public static void m1376z(String str, String str2, long j10) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        C0214f0.m1382b(C0213f.m1377a(), str, 0).edit().putLong(str2, j10).commit();
    }
}
