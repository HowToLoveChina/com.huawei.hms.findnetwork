package ga;

import com.huawei.android.hicloud.drive.cloudphoto.model.SliceObject;
import com.huawei.hicloud.base.slice.LengthGetter;

/* renamed from: ga.d */
/* loaded from: classes3.dex */
public class C9901d implements LengthGetter<SliceObject> {

    /* renamed from: a */
    public long f48595a;

    /* renamed from: b */
    public long f48596b;

    /* renamed from: c */
    public long f48597c;

    public C9901d(long j10, long j11, long j12) {
        this.f48595a = j10;
        this.f48596b = j11;
        this.f48597c = j12;
    }

    @Override // com.huawei.hicloud.base.slice.LengthGetter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getLength(int i10, SliceObject sliceObject) {
        return ((long) i10) != this.f48595a - 1 ? this.f48596b : this.f48597c;
    }
}
