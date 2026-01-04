package p015ak;

import android.content.ContentValues;
import android.text.TextUtils;
import hk.C10278a;
import java.io.File;
import java.util.HashSet;

/* renamed from: ak.h0 */
/* loaded from: classes6.dex */
public abstract class AbstractC0218h0 {

    /* renamed from: a */
    public String f811a = null;

    /* renamed from: b */
    public String f812b = "";

    /* renamed from: a */
    public abstract void mo1452a();

    /* renamed from: b */
    public void m1453b() {
        mo1452a();
        String str = this.f811a;
        if (str != null) {
            m1455d(str);
            this.f811a = null;
        }
    }

    /* renamed from: c */
    public final boolean m1454c(File file) {
        File[] fileArrM63440f;
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrM63440f = C10278a.m63440f(file)) != null) {
            for (File file2 : fileArrM63440f) {
                m1454c(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: d */
    public boolean m1455d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m1454c(C10278a.m63442h(str));
    }

    /* renamed from: e */
    public String m1456e() {
        return this.f811a;
    }

    /* renamed from: f */
    public abstract boolean mo1457f(String str);

    /* renamed from: g */
    public abstract ContentValues[] mo1458g(String str);

    /* renamed from: h */
    public abstract ContentValues[] mo1459h(String str, String[] strArr, String str2, String[] strArr2, String str3);

    /* renamed from: i */
    public abstract HashSet<String> mo1460i(String str);

    /* renamed from: j */
    public abstract int mo1461j(String str, ContentValues contentValues);

    /* renamed from: k */
    public abstract int mo1462k(String str, ContentValues[] contentValuesArr);
}
