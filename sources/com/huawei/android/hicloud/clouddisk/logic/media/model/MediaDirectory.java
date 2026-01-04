package com.huawei.android.hicloud.clouddisk.logic.media.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class MediaDirectory implements Parcelable {

    /* renamed from: a */
    public String f11807a;

    /* renamed from: b */
    public long f11808b;

    /* renamed from: c */
    public long f11809c;

    public MediaDirectory(String str, long j10, long j11) {
        this.f11807a = str;
        this.f11808b = j10;
        this.f11809c = j11;
    }

    /* renamed from: a */
    public long m15454a() {
        return this.f11809c;
    }

    /* renamed from: c */
    public long m15455c() {
        return this.f11808b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MediaDirectory [directoryName=" + this.f11807a + ", size=" + this.f11808b + ", count=" + this.f11809c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
    }
}
