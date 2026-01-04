package com.huawei.wearengine.p2p;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes9.dex */
public class FileIdentificationParcel implements Parcelable {
    public static final Parcelable.Creator<FileIdentificationParcel> CREATOR = new C8895a();

    /* renamed from: a */
    public String f45326a;

    /* renamed from: b */
    public String f45327b;

    /* renamed from: c */
    public String f45328c;

    /* renamed from: com.huawei.wearengine.p2p.FileIdentificationParcel$a */
    public class C8895a implements Parcelable.Creator<FileIdentificationParcel> {
        @Override // android.os.Parcelable.Creator
        public FileIdentificationParcel createFromParcel(Parcel parcel) {
            FileIdentificationParcel fileIdentificationParcel = new FileIdentificationParcel();
            if (parcel != null) {
                fileIdentificationParcel.m56561d(parcel.readString());
                fileIdentificationParcel.m56559a(parcel.readString());
                fileIdentificationParcel.m56560c(parcel.readString());
            }
            return fileIdentificationParcel;
        }

        @Override // android.os.Parcelable.Creator
        public FileIdentificationParcel[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new FileIdentificationParcel[0] : new FileIdentificationParcel[i10];
        }
    }

    /* renamed from: a */
    public void m56559a(String str) {
        this.f45327b = str;
    }

    /* renamed from: c */
    public void m56560c(String str) {
        this.f45328c = str;
    }

    /* renamed from: d */
    public void m56561d(String str) {
        this.f45326a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.f45326a);
        parcel.writeString(this.f45327b);
        parcel.writeString(this.f45328c);
    }
}
