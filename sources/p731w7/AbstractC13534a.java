package p731w7;

import com.huawei.android.hicloud.album.service.hihttp.able.Cancelable;
import com.huawei.android.hicloud.album.service.hihttp.able.Finishable;
import com.huawei.android.hicloud.album.service.hihttp.able.Startable;
import p731w7.AbstractC13534a;

/* renamed from: w7.a */
/* loaded from: classes2.dex */
public abstract class AbstractC13534a<T extends AbstractC13534a> implements Comparable<AbstractC13534a>, Startable, Cancelable, Finishable {

    /* renamed from: b */
    public int f60902b;

    /* renamed from: a */
    public EnumC13538e f60901a = EnumC13538e.DEFAULT;

    /* renamed from: c */
    public boolean f60903c = false;

    /* renamed from: d */
    public boolean f60904d = false;

    /* renamed from: e */
    public boolean f60905e = false;

    /* renamed from: e */
    public void mo81428e() {
        if (this.f60905e) {
            return;
        }
        this.f60905e = true;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.lang.Comparable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final int compareTo(AbstractC13534a abstractC13534a) {
        int iOrdinal;
        int iOrdinal2;
        EnumC13538e enumC13538eM81431i = m81431i();
        EnumC13538e enumC13538eM81431i2 = abstractC13534a.m81431i();
        if (enumC13538eM81431i == enumC13538eM81431i2) {
            iOrdinal = m81432k();
            iOrdinal2 = abstractC13534a.m81432k();
        } else {
            iOrdinal = enumC13538eM81431i2.ordinal();
            iOrdinal2 = enumC13538eM81431i.ordinal();
        }
        return iOrdinal - iOrdinal2;
    }

    /* renamed from: h */
    public void m81430h() {
        this.f60904d = true;
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public EnumC13538e m81431i() {
        return this.f60901a;
    }

    /* renamed from: k */
    public int m81432k() {
        return this.f60902b;
    }

    /* renamed from: p */
    public boolean m81433p() {
        return this.f60905e;
    }

    /* renamed from: q */
    public T m81434q(int i10) {
        this.f60902b = i10;
        return this;
    }

    /* renamed from: r */
    public void m81435r() {
        this.f60903c = true;
    }
}
