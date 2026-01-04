package p344hp;

import android.graphics.drawable.Drawable;
import java.text.Collator;
import java.util.Objects;
import p818yp.C14034a;

/* renamed from: hp.a */
/* loaded from: classes.dex */
public class C10332a implements Comparable<C10332a> {

    /* renamed from: a */
    public String f50006a;

    /* renamed from: b */
    public String f50007b;

    /* renamed from: c */
    public Drawable f50008c;

    /* renamed from: d */
    public long f50009d;

    /* renamed from: e */
    public boolean f50010e;

    /* renamed from: f */
    public String f50011f;

    /* renamed from: g */
    public long f50012g;

    /* renamed from: h */
    public int f50013h;

    /* renamed from: i */
    public boolean f50014i = false;

    /* renamed from: A */
    public void m63611A(String str) {
        this.f50011f = str;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C10332a c10332a) {
        String lowerCase = m63614e() == null ? "" : m63614e().toLowerCase(C14034a.f62797a);
        String lowerCase2 = c10332a.m63614e() != null ? c10332a.m63614e().toLowerCase(C14034a.f62797a) : "";
        if (c10332a.f50010e) {
            return m63616h() == c10332a.m63616h() ? Collator.getInstance().compare(lowerCase, lowerCase2) : m63616h() > c10332a.m63616h() ? -1 : 1;
        }
        int iMin = Math.min(m63617i() / 30, 6);
        int iMin2 = Math.min(c10332a.m63617i() / 30, 6);
        return (iMin <= 0 || iMin2 <= 0) ? (iMin == 0 && iMin2 == 0) ? m63617i() != c10332a.m63617i() ? m63617i() > c10332a.m63617i() ? -1 : 1 : m63616h() == c10332a.m63616h() ? Collator.getInstance().compare(lowerCase, lowerCase2) : m63616h() > c10332a.m63616h() ? -1 : 1 : iMin > 0 ? -1 : 1 : iMin != iMin2 ? iMin > iMin2 ? -1 : 1 : m63616h() == c10332a.m63616h() ? Collator.getInstance().compare(lowerCase, lowerCase2) : m63616h() > c10332a.m63616h() ? -1 : 1;
    }

    /* renamed from: b */
    public Drawable m63613b() {
        return this.f50008c;
    }

    /* renamed from: e */
    public String m63614e() {
        return this.f50007b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof C10332a)) {
            return Objects.equals(this.f50006a, ((C10332a) obj).f50006a);
        }
        return false;
    }

    /* renamed from: f */
    public String m63615f() {
        return this.f50006a;
    }

    /* renamed from: h */
    public long m63616h() {
        return this.f50009d;
    }

    public int hashCode() {
        String str = this.f50006a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    /* renamed from: i */
    public int m63617i() {
        return this.f50013h;
    }

    /* renamed from: k */
    public long m63618k() {
        return this.f50012g;
    }

    /* renamed from: p */
    public String m63619p() {
        return this.f50011f;
    }

    /* renamed from: q */
    public boolean m63620q() {
        return this.f50014i;
    }

    /* renamed from: r */
    public boolean m63621r() {
        return this.f50010e;
    }

    /* renamed from: s */
    public void m63622s(Drawable drawable) {
        this.f50008c = drawable;
    }

    /* renamed from: t */
    public void m63623t(String str) {
        this.f50007b = str;
    }

    /* renamed from: u */
    public void m63624u(String str) {
        this.f50006a = str;
    }

    /* renamed from: v */
    public void m63625v(long j10) {
        this.f50009d = j10;
    }

    /* renamed from: w */
    public void m63626w(boolean z10) {
        this.f50014i = z10;
    }

    /* renamed from: x */
    public void m63627x(int i10) {
        this.f50013h = i10;
    }

    /* renamed from: y */
    public void m63628y(long j10) {
        this.f50012g = j10;
    }

    /* renamed from: z */
    public void m63629z(boolean z10) {
        this.f50010e = z10;
    }
}
