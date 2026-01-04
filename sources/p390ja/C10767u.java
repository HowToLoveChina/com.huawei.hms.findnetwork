package p390ja;

import com.huawei.android.hicloud.drive.clouddisk.model.SliceObject;
import com.huawei.hicloud.base.slice.LengthGetter;

/* renamed from: ja.u */
/* loaded from: classes3.dex */
public class C10767u implements LengthGetter<SliceObject> {

    /* renamed from: a */
    public long f51483a;

    /* renamed from: b */
    public long f51484b;

    /* renamed from: c */
    public long f51485c;

    public C10767u(long j10, long j11, long j12) {
        this.f51483a = j10;
        this.f51484b = j11;
        this.f51485c = j12;
    }

    @Override // com.huawei.hicloud.base.slice.LengthGetter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getLength(int i10, SliceObject sliceObject) {
        return ((long) i10) != this.f51483a - 1 ? this.f51484b : this.f51485c;
    }
}
