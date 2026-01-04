package p647t4;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.text.Collator;
import java.util.Locale;

/* renamed from: t4.b */
/* loaded from: classes.dex */
public class C12936b extends C12935a implements Comparable<C12936b> {

    /* renamed from: j */
    public static Collator f58972j = Collator.getInstance(Locale.getDefault());

    /* renamed from: e */
    public String f58973e;

    /* renamed from: f */
    public String f58974f;

    /* renamed from: g */
    public long f58975g;

    /* renamed from: h */
    public long f58976h;

    /* renamed from: i */
    public String f58977i;

    @Override // java.lang.Comparable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(C12936b c12936b) {
        if (c12936b == null) {
            return 1;
        }
        if (m77674q(c12936b)) {
            return f58972j.compare(m77671i() == null ? "" : m77671i().toLowerCase(Locale.ENGLISH), c12936b.m77671i() != null ? c12936b.m77671i().toLowerCase(Locale.ENGLISH) : "");
        }
        if (!m77675r(c12936b)) {
            return 1;
        }
        long jM77672k = m77672k();
        long jM77672k2 = c12936b.m77672k();
        if (jM77672k == jM77672k2) {
            return f58972j.compare(m77671i() == null ? "" : m77671i().toLowerCase(Locale.ENGLISH), c12936b.m77671i() != null ? c12936b.m77671i().toLowerCase(Locale.ENGLISH) : "");
        }
        return f58972j.compare(String.valueOf(jM77672k2), String.valueOf(jM77672k));
    }

    @Override // p647t4.C12935a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12936b) || !super.equals(obj)) {
            return false;
        }
        C12936b c12936b = (C12936b) obj;
        return TextUtils.equals(m77671i() == null ? "" : m77671i().toLowerCase(Locale.ENGLISH), c12936b.m77671i() != null ? c12936b.m77671i().toLowerCase(Locale.ENGLISH) : "");
    }

    /* renamed from: f */
    public String m77669f() {
        return this.f58977i;
    }

    /* renamed from: h */
    public long m77670h() {
        return this.f58975g;
    }

    @Override // p647t4.C12935a
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.f58974f;
        return iHashCode + (str != null ? str.toLowerCase(Locale.ENGLISH).hashCode() : 0);
    }

    /* renamed from: i */
    public String m77671i() {
        return this.f58974f;
    }

    /* renamed from: k */
    public long m77672k() {
        return this.f58976h;
    }

    /* renamed from: p */
    public String m77673p() {
        return this.f58973e;
    }

    /* renamed from: q */
    public final boolean m77674q(C12936b c12936b) {
        if (c12936b == null) {
            return false;
        }
        return "doc".equals(c12936b.m77666a()) || "doc_sd".equals(c12936b.m77666a()) || "audio".equals(c12936b.m77666a()) || "audio_sd".equals(c12936b.m77666a());
    }

    /* renamed from: r */
    public final boolean m77675r(C12936b c12936b) {
        if (c12936b == null) {
            return false;
        }
        return "photo".equals(c12936b.m77666a()) || "photo_sd".equals(c12936b.m77666a()) || Constants.VIDEO_SUB_DIR.equals(c12936b.m77666a()) || "video_sd".equals(c12936b.m77666a());
    }
}
