package hu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import p787xt.C13865a;

/* renamed from: hu.b */
/* loaded from: classes5.dex */
public class C10343b {

    /* renamed from: a */
    public final Bundle f50031a;

    public C10343b() {
        this(new Bundle());
    }

    /* renamed from: a */
    public boolean m63679a(String str) {
        try {
            return this.f50031a.containsKey(str);
        } catch (Throwable unused) {
            C13865a.m83189c("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    /* renamed from: b */
    public Object m63680b(String str) {
        try {
            return this.f50031a.get(str);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "get exception: " + th2.getMessage(), true);
            return null;
        }
    }

    /* renamed from: c */
    public boolean m63681c(String str) {
        return m63682d(str, false);
    }

    /* renamed from: d */
    public boolean m63682d(String str, boolean z10) {
        try {
            return this.f50031a.getBoolean(str, z10);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getBoolean exception : " + th2.getMessage(), true);
            return z10;
        }
    }

    /* renamed from: e */
    public Bundle m63683e() {
        return this.f50031a;
    }

    /* renamed from: f */
    public Bundle m63684f(String str) {
        try {
            return this.f50031a.getBundle(str);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getBundle exception: " + th2.getMessage(), true);
            return null;
        }
    }

    /* renamed from: g */
    public float m63685g(String str, float f10) {
        try {
            return this.f50031a.getFloat(str, f10);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getFloat exception: " + th2.getMessage(), true);
            return f10;
        }
    }

    /* renamed from: h */
    public int m63686h(String str) {
        return m63687i(str, 0);
    }

    /* renamed from: i */
    public int m63687i(String str, int i10) {
        try {
            return this.f50031a.getInt(str, i10);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getInt exception: " + th2.getMessage(), true);
            return i10;
        }
    }

    /* renamed from: j */
    public long m63688j(String str) {
        return m63689k(str, 0L);
    }

    /* renamed from: k */
    public long m63689k(String str, long j10) {
        try {
            return this.f50031a.getLong(str, j10);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getLong exception: " + th2.getMessage(), true);
            return j10;
        }
    }

    /* renamed from: l */
    public <T extends Parcelable> T m63690l(String str) {
        try {
            return (T) this.f50031a.getParcelable(str);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getParcelable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    /* renamed from: m */
    public <T extends Parcelable> T m63691m(String str, Class<T> cls) {
        try {
            Parcelable parcelable = this.f50031a.getParcelable(str);
            if (cls.isInstance(parcelable)) {
                return cls.cast(parcelable);
            }
            return null;
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getParcelable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    /* renamed from: n */
    public <T extends Parcelable> ArrayList<T> m63692n(String str) {
        try {
            return this.f50031a.getParcelableArrayList(str);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getParcelableArrayList exception: " + th2.getMessage(), true);
            return null;
        }
    }

    /* renamed from: o */
    public Serializable m63693o(String str) {
        try {
            return this.f50031a.getSerializable(str);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getSerializable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    /* renamed from: p */
    public String m63694p(String str) {
        try {
            return this.f50031a.getString(str);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getString exception: " + th2.getMessage(), true);
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: q */
    public String m63695q(String str, String str2) {
        try {
            return this.f50031a.getString(str, str2);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getString exception: " + th2.getMessage(), true);
            return str2;
        }
    }

    /* renamed from: r */
    public ArrayList<String> m63696r(String str) {
        try {
            return this.f50031a.getStringArrayList(str);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "getStringArrayList exception: " + th2.getMessage(), true);
            return new ArrayList<>();
        }
    }

    /* renamed from: s */
    public Set<String> m63697s() {
        try {
            return this.f50031a.keySet();
        } catch (Throwable unused) {
            C13865a.m83189c("SafeBundle", "keySet exception.");
            return null;
        }
    }

    /* renamed from: t */
    public C10343b m63698t(String str, int i10) {
        try {
            this.f50031a.putInt(str, i10);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "putInt exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public String toString() {
        try {
            return this.f50031a.toString();
        } catch (Throwable unused) {
            C13865a.m83189c("SafeBundle", "toString exception.");
            return null;
        }
    }

    /* renamed from: u */
    public C10343b m63699u(String str, Parcelable parcelable) {
        try {
            this.f50031a.putParcelable(str, parcelable);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "putParcelable exception: " + th2.getMessage(), true);
        }
        return this;
    }

    /* renamed from: v */
    public C10343b m63700v(String str, Serializable serializable) {
        try {
            this.f50031a.putSerializable(str, serializable);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "putSerializable exception: " + th2.getMessage(), true);
        }
        return this;
    }

    /* renamed from: w */
    public C10343b m63701w(String str, String str2) {
        try {
            this.f50031a.putString(str, str2);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "putString exception: " + th2.getMessage(), true);
        }
        return this;
    }

    /* renamed from: x */
    public C10343b m63702x(String str, ArrayList<String> arrayList) {
        try {
            this.f50031a.putStringArrayList(str, arrayList);
        } catch (Throwable th2) {
            C13865a.m83191e("SafeBundle", "putStringArrayList exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public C10343b(Bundle bundle) {
        this.f50031a = bundle == null ? new Bundle() : bundle;
    }
}
