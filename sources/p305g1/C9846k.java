package p305g1;

import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import p274f1.InterfaceC9643d;
import p481n1.C11590b;

/* renamed from: g1.k */
/* loaded from: classes.dex */
public class C9846k {

    /* renamed from: e */
    public static String f48398e = C11590b.m69185b(InterfaceC9643d.class);

    /* renamed from: f */
    public static final Map<String, String> f48399f = new a();

    /* renamed from: a */
    public final String f48400a;

    /* renamed from: b */
    public final Class<?>[] f48401b;

    /* renamed from: c */
    public C9842g f48402c = null;

    /* renamed from: d */
    public boolean f48403d;

    /* renamed from: g1.k$a */
    public static class a extends HashMap<String, String> {
        public a() {
            put("int", "I");
            put("boolean", "Z");
            put("byte", CloudBackupConstant.UserPackageInfo.ONE_T_MEMBER);
            put("char", "C");
            put("short", CloudBackupConstant.UserPackageInfo.SILVER_MEMBER);
            put("float", "F");
            put("long", RequestOptions.AD_CONTENT_CLASSIFICATION_J);
            put("double", "D");
        }
    }

    public C9846k(String str, Class<?>[] clsArr) {
        this.f48400a = str;
        this.f48401b = clsArr;
    }

    /* renamed from: a */
    public final boolean m61203a(C9845j c9845j, String str) {
        String strM61199c = c9845j.m61199c();
        StringBuilder sb2 = new StringBuilder();
        while (strM61199c.endsWith(C6010m7.f27500n)) {
            sb2.append('[');
            strM61199c = strM61199c.substring(0, strM61199c.length() - 2);
        }
        if (sb2.length() != 0) {
            Map<String, String> map = f48399f;
            if (map.containsKey(strM61199c)) {
                sb2.append(map.get(strM61199c));
                strM61199c = sb2.toString();
            } else {
                sb2.append('L');
                sb2.append(strM61199c);
                sb2.append(';');
                strM61199c = sb2.toString();
            }
        }
        return strM61199c.equals(str);
    }

    /* renamed from: b */
    public String[] m61204b() {
        C9842g c9842g = this.f48402c;
        return (c9842g == null || !c9842g.f48374e) ? new String[0] : c9842g.m61179a().split(",");
    }

    /* renamed from: c */
    public boolean m61205c() {
        return this.f48403d;
    }

    /* renamed from: d */
    public void m61206d(String str) {
        if (f48398e.equals(str)) {
            this.f48403d = true;
        }
    }

    /* renamed from: e */
    public C9842g m61207e(int i10, String str, String str2) {
        if (this.f48402c != null || !str.equals(this.f48400a)) {
            return null;
        }
        C9845j[] c9845jArrM61195a = C9845j.m61195a(str2);
        int i11 = 0;
        for (C9845j c9845j : c9845jArrM61195a) {
            String strM61199c = c9845j.m61199c();
            if (strM61199c.equals("long") || strM61199c.equals("double")) {
                i11++;
            }
        }
        if (c9845jArrM61195a.length != this.f48401b.length) {
            return null;
        }
        for (int i12 = 0; i12 < c9845jArrM61195a.length; i12++) {
            if (!m61203a(c9845jArrM61195a[i12], this.f48401b[i12].getName())) {
                return null;
            }
        }
        C9842g c9842g = new C9842g(!Modifier.isStatic(i10) ? 1 : 0, c9845jArrM61195a.length + i11);
        this.f48402c = c9842g;
        return c9842g;
    }
}
