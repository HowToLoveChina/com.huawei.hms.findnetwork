package p006a5;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Set;

/* renamed from: a5.c */
/* loaded from: classes.dex */
public abstract class AbstractC0048c extends C0046a {

    /* renamed from: e */
    public static volatile boolean f114e = false;

    /* renamed from: b */
    public String f116b;

    /* renamed from: c */
    public String f117c;

    /* renamed from: a */
    public String f115a = "";

    /* renamed from: d */
    public Locale f118d = Locale.ENGLISH;

    /* renamed from: e */
    public static void m182e() {
        f114e = false;
    }

    /* renamed from: q */
    public static boolean m183q() {
        return f114e;
    }

    /* renamed from: x */
    public static void m184x() {
        f114e = true;
    }

    /* renamed from: A */
    public synchronized int m185A(String str, ContentValues contentValues) {
        return mo187C(str, contentValues);
    }

    /* renamed from: B */
    public abstract int mo186B(String str, ContentValues[] contentValuesArr, Handler.Callback callback, Object obj);

    /* renamed from: C */
    public abstract int mo187C(String str, ContentValues contentValues);

    /* renamed from: f */
    public final boolean m188f(File file) {
        if (file == null) {
            return true;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        File parentFile = file.getParentFile();
        return (parentFile.exists() && parentFile.isDirectory()) ? file.mkdir() : m188f(file.getParentFile());
    }

    /* renamed from: g */
    public boolean m189g(File file) throws IOException {
        if (file == null || file.exists()) {
            return true;
        }
        return file.getParentFile().exists() ? file.createNewFile() : m188f(file.getParentFile());
    }

    /* renamed from: h */
    public void m190h() {
        mo170b();
        String str = this.f116b;
        if (str != null) {
            m192j(str);
            this.f116b = null;
        }
    }

    /* renamed from: i */
    public final boolean m191i(File file) {
        File[] fileArrListFiles;
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                m191i(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: j */
    public boolean m192j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m191i(new File(str));
    }

    /* renamed from: k */
    public String m193k() {
        return this.f117c;
    }

    /* renamed from: l */
    public abstract Cursor mo194l(String str, String[] strArr, String str2, String[] strArr2, String str3);

    /* renamed from: m */
    public String mo195m() {
        return this.f115a;
    }

    /* renamed from: n */
    public String m196n() {
        return this.f116b;
    }

    /* renamed from: o */
    public String m197o() {
        return m196n();
    }

    /* renamed from: p */
    public String m198p() {
        if (this.f116b == null) {
            return null;
        }
        return new File(this.f116b).getParent();
    }

    /* renamed from: r */
    public synchronized ContentValues[] m199r(String str) {
        return mo201t(str, null, null, null, null);
    }

    /* renamed from: s */
    public synchronized ContentValues[] m200s(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return mo201t(str, strArr, str2, strArr2, str3);
    }

    /* renamed from: t */
    public abstract ContentValues[] mo201t(String str, String[] strArr, String str2, String[] strArr2, String str3);

    /* renamed from: u */
    public abstract Set<String> mo202u(String str);

    /* renamed from: v */
    public abstract int mo203v(String str);

    /* renamed from: w */
    public void m204w(int i10, int i11, int i12, Handler.Callback callback, Object obj) {
        if (callback != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.arg1 = i11;
            messageObtain.arg2 = i12;
            messageObtain.obj = obj;
            callback.handleMessage(messageObtain);
        }
    }

    /* renamed from: y */
    public void m205y(String str) {
        this.f117c = str;
    }

    /* renamed from: z */
    public void m206z(String str) {
        this.f116b = str;
    }
}
