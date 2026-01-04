package com.huawei.hicloud.base.slice;

/* loaded from: classes6.dex */
public class StrLengthGetter implements LengthGetter<String> {
    private long amount;
    private long eSliceLength;
    private long lastSliceLength;

    public StrLengthGetter(long j10, long j11, long j12) {
        this.amount = j10;
        this.eSliceLength = j11;
        this.lastSliceLength = j12;
    }

    @Override // com.huawei.hicloud.base.slice.LengthGetter
    public long getLength(int i10, String str) {
        return ((long) i10) != this.amount - 1 ? this.eSliceLength : this.lastSliceLength;
    }
}
