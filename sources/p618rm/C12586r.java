package p618rm;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import hk.C10279b;
import java.io.File;
import p015ak.C0213f;

/* renamed from: rm.r */
/* loaded from: classes6.dex */
public class C12586r {

    /* renamed from: a */
    public static final String f57959a = File.separator;

    /* renamed from: a */
    public static String m75710a() {
        return C12583q.m75674j(0);
    }

    /* renamed from: b */
    public static String m75711b() {
        return m75717h() + f57959a + "cloudbackup";
    }

    /* renamed from: c */
    public static Context m75712c() {
        return C0213f.m1377a();
    }

    /* renamed from: d */
    public static String m75713d() {
        return m75710a() + "/Android/";
    }

    /* renamed from: e */
    public static String m75714e(String str, int i10) {
        return m75713d() + str;
    }

    /* renamed from: f */
    public static String m75715f(String str, String str2, int i10, String str3) {
        String strM75670f = C12583q.m75670f(i10, ICBUtil.ANDROID_DATA, str2);
        return (TextUtils.isEmpty(strM75670f) || TextUtils.isEmpty(str3) || !str3.startsWith(strM75670f)) ? str3 : str3.replace(strM75670f, m75714e(str, i10));
    }

    /* renamed from: g */
    public static String m75716g(String str, String str2, int i10, String str3) {
        String strM75670f = C12583q.m75670f(i10, ICBUtil.ANDROID_DATA, str2);
        String strM75714e = m75714e(str, i10);
        return (TextUtils.isEmpty(strM75714e) || TextUtils.isEmpty(str3) || !str3.startsWith(strM75714e)) ? str3 : str3.replace(strM75714e, strM75670f);
    }

    /* renamed from: h */
    public static String m75717h() {
        return C10279b.m63452a(m75712c().getFilesDir());
    }
}
