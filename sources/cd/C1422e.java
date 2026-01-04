package cd;

import com.huawei.android.hicloud.syncdrive.cloudsync.model.SliceObject;
import com.huawei.hicloud.base.slice.LengthGetter;

/* renamed from: cd.e */
/* loaded from: classes3.dex */
public class C1422e implements LengthGetter<SliceObject> {

    /* renamed from: a */
    public long f6177a;

    /* renamed from: b */
    public long f6178b;

    /* renamed from: c */
    public long f6179c;

    public C1422e(long j10, long j11, long j12) {
        this.f6177a = j10;
        this.f6178b = j11;
        this.f6179c = j12;
    }

    @Override // com.huawei.hicloud.base.slice.LengthGetter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getLength(int i10, SliceObject sliceObject) {
        return ((long) i10) != this.f6177a - 1 ? this.f6178b : this.f6179c;
    }
}
