package p495nm;

import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import java.util.HashMap;
import java.util.Map;
import p292fn.C9733f;
import p618rm.C12590s0;

/* renamed from: nm.l */
/* loaded from: classes6.dex */
public class C11731l {

    /* renamed from: a */
    public String f54271a;

    /* renamed from: b */
    public String f54272b;

    /* renamed from: c */
    public String f54273c;

    public C11731l(String str, String str2, String str3) {
        this.f54271a = str;
        this.f54273c = str3;
        this.f54272b = str2;
    }

    /* renamed from: a */
    public static String m70008a(StringBuilder sb2) {
        return sb2.length() <= 15 ? sb2.toString() : sb2.replace(6, sb2.length() - 6, "...").toString();
    }

    /* renamed from: g */
    public static void m70009g(StringBuilder sb2) {
        if (sb2.length() <= 4) {
            if (sb2.length() > 1) {
                int i10 = sb2.length() == 4 ? 2 : 1;
                sb2.replace(1, i10 + 1, "***".substring(0, i10));
                return;
            }
            return;
        }
        int length = sb2.length() - 3;
        int i11 = length / 2;
        if (i11 % 2 == 0) {
            i11 = length - i11;
        }
        sb2.replace(i11, i11 + 3, "***");
    }

    /* renamed from: h */
    public static C11731l m70010h(String str) {
        Map<String, String> mapM75858h2 = C12590s0.m75858h2(str);
        return new C11731l(mapM75858h2.get("appId"), mapM75858h2.get(ContentResource.FILE_NAME), mapM75858h2.get("dirPath"));
    }

    /* renamed from: i */
    public static String m70011i(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (C9733f.m60705z().m60720O("cloudBackupFileNameAnonymization")) {
            m70009g(sb2);
        }
        return m70008a(sb2);
    }

    /* renamed from: b */
    public String m70012b() {
        return m70013c(this.f54271a);
    }

    /* renamed from: c */
    public final String m70013c(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: d */
    public String m70014d() {
        return m70013c(this.f54273c);
    }

    /* renamed from: e */
    public String m70015e() {
        return m70011i(m70013c(this.f54272b));
    }

    /* renamed from: f */
    public String m70016f() {
        return m70013c(this.f54272b);
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("appId", m70012b());
        map.put(ContentResource.FILE_NAME, m70016f());
        map.put("dirPath", m70014d());
        return C12590s0.m75846e2(map);
    }
}
