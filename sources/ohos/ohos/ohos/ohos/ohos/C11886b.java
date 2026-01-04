package ohos.ohos.ohos.ohos.ohos;

import android.util.Log;
import p625rx.C12646m;

/* renamed from: ohos.ohos.ohos.ohos.ohos.b */
/* loaded from: classes9.dex */
public class C11886b {
    /* renamed from: a */
    public static C11885a m71380a(C11896l c11896l) {
        if (c11896l == null || c11896l.mo71384d() == null) {
            Log.e("AbilityDataConverter", "convertToShellInfo param invalid");
            return null;
        }
        C11885a c11885a = new C11885a();
        c11885a.f54940a = c11896l;
        Log.d("AbilityDataConverter", "convertToAbilityData begin bundleName:" + c11896l.mo71383c() + ",className:" + c11896l.mo71384d());
        String strM76176d = C12646m.m76176d();
        if (strM76176d == null || "".equals(strM76176d) || strM76176d.equals("1.0")) {
            c11885a.f54941b = c11896l.mo71383c();
            c11885a.f54942c = m71381b(c11896l);
            return c11885a;
        }
        c11885a.f54942c = (c11896l.mo71433h() == null || c11896l.mo71433h().isEmpty() || c11896l.mo71433h().equals(c11896l.mo71384d())) ? m71381b(c11896l) : c11896l.mo71433h();
        String strMo71383c = c11896l instanceof C11902z ? ((C11902z) c11896l).f55135z : null;
        if (strMo71383c == null || strMo71383c.isEmpty() || strMo71383c.equals(c11896l.mo71383c())) {
            strMo71383c = c11896l.mo71383c();
        }
        c11885a.f54941b = strMo71383c;
        Log.d("AbilityDataConverter", "convertToAbilityData result bundleName:" + c11885a.f54941b + ",className:" + c11885a.f54942c);
        return c11885a;
    }

    /* renamed from: b */
    public static String m71381b(C11896l c11896l) {
        String strMo71384d;
        String str;
        int iOrdinal = c11896l.mo71392n().ordinal();
        if (iOrdinal == 1) {
            strMo71384d = c11896l.mo71384d();
            str = "ShellActivity";
        } else if (iOrdinal == 2) {
            strMo71384d = c11896l.mo71384d();
            str = "ShellService";
        } else {
            if (iOrdinal != 3) {
                Log.w("AbilityDataConverter", "convertToAbilityData unknown type");
                return "";
            }
            strMo71384d = c11896l.mo71384d();
            str = "ShellProvider";
        }
        return strMo71384d.concat(str);
    }
}
