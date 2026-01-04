package p820yr;

import android.text.TextUtils;
import com.huawei.location.activity.C6738e;
import java.util.Arrays;
import java.util.UUID;

/* renamed from: yr.b */
/* loaded from: classes8.dex */
public class C14038b {

    /* renamed from: a */
    public String f62809a;

    /* renamed from: b */
    public String f62810b;

    /* renamed from: c */
    public String f62811c;

    /* renamed from: d */
    public String f62812d;

    /* renamed from: e */
    public String f62813e;

    /* renamed from: f */
    public String f62814f;

    /* renamed from: g */
    public String[] f62815g;

    /* renamed from: yr.b$b */
    public static class b {

        /* renamed from: a */
        public final C14038b f62816a;

        public b(String str, String str2, String str3, String str4) {
            C14038b c14038b = new C14038b();
            this.f62816a = c14038b;
            str4 = TextUtils.isEmpty(str4) ? UUID.randomUUID().toString() : str4;
            c14038b.m84216q(str2);
            c14038b.m84215p(str4);
            c14038b.m84212m(str3);
            c14038b.m84211l(str);
        }

        /* renamed from: a */
        public C14038b m84217a() {
            return this.f62816a;
        }

        /* renamed from: b */
        public b m84218b(String[] strArr) {
            this.f62816a.m84210k(strArr);
            return this;
        }

        /* renamed from: c */
        public b m84219c(String str) {
            this.f62816a.m84213n(str);
            return this;
        }

        /* renamed from: d */
        public b m84220d(String str) {
            this.f62816a.m84214o(str);
            return this;
        }
    }

    public C14038b() {
    }

    /* renamed from: f */
    public String[] m84205f() {
        String[] strArr = this.f62815g;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    /* renamed from: g */
    public String m84206g() {
        return this.f62809a;
    }

    /* renamed from: h */
    public String m84207h() {
        return this.f62812d;
    }

    /* renamed from: i */
    public String m84208i() {
        return this.f62811c;
    }

    /* renamed from: j */
    public String m84209j() {
        return this.f62810b;
    }

    /* renamed from: k */
    public final void m84210k(String[] strArr) {
        this.f62815g = strArr;
    }

    /* renamed from: l */
    public final void m84211l(String str) {
        this.f62809a = str;
    }

    /* renamed from: m */
    public void m84212m(String str) {
        this.f62812d = str;
    }

    /* renamed from: n */
    public final void m84213n(String str) {
        this.f62811c = str;
    }

    /* renamed from: o */
    public final void m84214o(String str) {
        this.f62810b = str;
    }

    /* renamed from: p */
    public void m84215p(String str) {
        this.f62814f = str;
    }

    /* renamed from: q */
    public final void m84216q(String str) {
        this.f62813e = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SignMessageReq{method='");
        sb2.append(this.f62809a);
        sb2.append("', query='");
        sb2.append(this.f62810b);
        sb2.append("', payload='");
        sb2.append(this.f62811c);
        sb2.append("', url='");
        sb2.append(this.f62813e);
        sb2.append("', tid='");
        return C6738e.m38291a(sb2, this.f62814f, "'}");
    }
}
