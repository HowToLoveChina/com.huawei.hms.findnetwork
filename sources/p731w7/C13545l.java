package p731w7;

import com.huawei.android.hicloud.album.service.hihttp.rest.Response;
import p701v6.AbstractC13354a;

/* renamed from: w7.l */
/* loaded from: classes2.dex */
public class C13545l<T> implements Response<T> {

    /* renamed from: a */
    public final T f60934a;

    /* renamed from: b */
    public final long f60935b;

    /* renamed from: c */
    public AbstractC13539f<?, T> f60936c;

    /* renamed from: d */
    public AbstractC13354a f60937d;

    public C13545l(AbstractC13539f<?, T> abstractC13539f, T t10, long j10) {
        this.f60936c = abstractC13539f;
        this.f60934a = t10;
        this.f60935b = j10;
        this.f60937d = abstractC13539f.m81456u();
    }

    @Override // com.huawei.android.hicloud.album.service.hihttp.rest.Response
    /* renamed from: a */
    public int mo15149a() {
        AbstractC13539f<?, T> abstractC13539f = this.f60936c;
        if (abstractC13539f != null) {
            return abstractC13539f.m81454s();
        }
        return -1;
    }

    @Override // com.huawei.android.hicloud.album.service.hihttp.rest.Response
    /* renamed from: b */
    public long mo15150b() {
        return this.f60935b;
    }

    @Override // com.huawei.android.hicloud.album.service.hihttp.rest.Response
    /* renamed from: c */
    public boolean mo15151c() {
        return this.f60936c != null && m81471d() && this.f60936c.m81454s() == 0;
    }

    /* renamed from: d */
    public boolean m81471d() {
        int iM81472e = m81472e();
        return iM81472e == 200 || iM81472e == 206;
    }

    /* renamed from: e */
    public int m81472e() {
        AbstractC13354a abstractC13354a = this.f60937d;
        if (abstractC13354a != null) {
            return abstractC13354a.m80110i();
        }
        return -1;
    }

    @Override // com.huawei.android.hicloud.album.service.hihttp.rest.Response
    public T get() {
        return this.f60934a;
    }
}
