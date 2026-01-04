package p429kk;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/* renamed from: kk.c */
/* loaded from: classes6.dex */
public class C11060c {

    /* renamed from: a */
    public String f52234a;

    /* renamed from: b */
    public String f52235b;

    /* renamed from: c */
    public String f52236c;

    /* renamed from: d */
    public String f52237d;

    /* renamed from: e */
    public String f52238e;

    /* renamed from: f */
    public String f52239f;

    /* renamed from: g */
    public String f52240g;

    /* renamed from: h */
    public String f52241h;

    /* renamed from: i */
    public String f52242i;

    /* renamed from: j */
    public String f52243j;

    /* renamed from: k */
    public String f52244k;

    /* renamed from: l */
    public String f52245l;

    /* renamed from: m */
    public String f52246m;

    /* renamed from: o */
    public String f52248o;

    /* renamed from: r */
    public String f52251r;

    /* renamed from: n */
    public String f52247n = "0";

    /* renamed from: p */
    public String f52249p = "0";

    /* renamed from: q */
    public Map<String, String> f52250q = new HashMap();

    /* renamed from: A */
    public void m66635A(String str) {
        this.f52241h = str;
    }

    /* renamed from: B */
    public void m66636B(String str) {
        this.f52235b = str;
    }

    /* renamed from: C */
    public void m66637C(String str) {
        this.f52234a = str;
    }

    /* renamed from: D */
    public void m66638D(String str) {
        this.f52245l = str;
    }

    /* renamed from: E */
    public void m66639E(String str) {
        this.f52239f = str;
    }

    /* renamed from: F */
    public void m66640F(String str) {
        this.f52243j = str;
    }

    /* renamed from: G */
    public void m66641G(String str) {
        this.f52244k = str;
    }

    /* renamed from: H */
    public void m66642H(String str) {
        this.f52248o = str;
    }

    /* renamed from: I */
    public void m66643I(String str) {
        this.f52236c = str;
    }

    /* renamed from: J */
    public void m66644J(String str) {
        this.f52237d = str;
    }

    /* renamed from: a */
    public String m66645a() {
        return this.f52251r;
    }

    /* renamed from: b */
    public String m66646b() {
        return this.f52242i;
    }

    /* renamed from: c */
    public String m66647c() {
        return this.f52240g;
    }

    /* renamed from: d */
    public String m66648d() {
        return this.f52238e;
    }

    /* renamed from: e */
    public String m66649e() {
        return this.f52247n;
    }

    /* renamed from: f */
    public String m66650f() {
        return this.f52249p;
    }

    /* renamed from: g */
    public String m66651g() {
        return this.f52246m;
    }

    /* renamed from: h */
    public String m66652h() {
        return this.f52241h;
    }

    /* renamed from: i */
    public String m66653i() {
        return this.f52235b;
    }

    /* renamed from: j */
    public String m66654j() {
        return this.f52234a;
    }

    /* renamed from: k */
    public String m66655k() {
        return this.f52245l;
    }

    /* renamed from: l */
    public String m66656l() {
        return this.f52239f;
    }

    /* renamed from: m */
    public String m66657m() {
        return this.f52243j;
    }

    /* renamed from: n */
    public String m66658n() {
        return this.f52244k;
    }

    /* renamed from: o */
    public Map<String, String> m66659o() {
        return this.f52250q;
    }

    /* renamed from: p */
    public String m66660p() {
        return this.f52248o;
    }

    /* renamed from: q */
    public String m66661q() {
        return this.f52236c;
    }

    /* renamed from: r */
    public String m66662r() {
        return this.f52237d;
    }

    /* renamed from: s */
    public void m66663s(String str) {
        this.f52251r = str;
    }

    /* renamed from: t */
    public void m66664t(String str) {
        this.f52242i = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    /* renamed from: u */
    public void m66665u(String str) {
        this.f52240g = str;
    }

    /* renamed from: v */
    public void m66666v(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            this.f52242i = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f52240g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f52247n = str3;
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        this.f52241h = str4;
    }

    /* renamed from: w */
    public void m66667w(String str) {
        this.f52238e = str;
    }

    /* renamed from: x */
    public void m66668x(String str) {
        this.f52247n = str;
    }

    /* renamed from: y */
    public void m66669y(String str) {
        this.f52249p = str;
    }

    /* renamed from: z */
    public void m66670z(String str) {
        this.f52246m = str;
    }
}
