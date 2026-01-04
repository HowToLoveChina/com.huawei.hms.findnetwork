package p717vs;

import com.huawei.riemann.common.api.location.CityTileCallback;
import us.C13246a;

/* renamed from: vs.a */
/* loaded from: classes8.dex */
public final class C13486a implements CityTileCallback {

    /* renamed from: a */
    public C13246a f60717a;

    /* renamed from: b */
    public int f60718b;

    /* renamed from: c */
    public int f60719c;

    public C13486a(int i10, int i11) {
        this.f60718b = i10;
        this.f60719c = i11;
        this.f60717a = new C13246a(i10, i11);
    }

    @Override // com.huawei.riemann.common.api.location.CityTileCallback
    public final byte[] get(long j10) {
        if (this.f60717a == null) {
            this.f60717a = new C13246a(this.f60718b, this.f60719c);
        }
        return this.f60717a.m79633a(j10);
    }
}
