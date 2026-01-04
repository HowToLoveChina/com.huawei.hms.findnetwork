package com.huawei.wearengine.device;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes9.dex */
public class TransparentCommandParcel implements Parcelable {
    public static final Parcelable.Creator<TransparentCommandParcel> CREATOR = new C8891a();

    /* renamed from: a */
    public int f45295a;

    /* renamed from: b */
    public String f45296b;

    /* renamed from: c */
    public String f45297c;

    /* renamed from: d */
    public String f45298d;

    /* renamed from: e */
    public byte[] f45299e;

    /* renamed from: f */
    public int f45300f;

    /* renamed from: g */
    public boolean f45301g;

    /* renamed from: h */
    public String f45302h;

    /* renamed from: com.huawei.wearengine.device.TransparentCommandParcel$a */
    public class C8891a implements Parcelable.Creator<TransparentCommandParcel> {
        @Override // android.os.Parcelable.Creator
        public TransparentCommandParcel createFromParcel(Parcel parcel) {
            TransparentCommandParcel transparentCommandParcel = new TransparentCommandParcel();
            if (parcel != null) {
                transparentCommandParcel.m56550d(parcel.readInt());
                transparentCommandParcel.m56555i(parcel.readString());
                transparentCommandParcel.m56548a(parcel.readString());
                transparentCommandParcel.m56551e(parcel.readString());
                transparentCommandParcel.m56549c(parcel.createByteArray());
                transparentCommandParcel.m56554h(parcel.readInt());
                transparentCommandParcel.m56553g(parcel.readByte() != 0);
                transparentCommandParcel.m56552f(parcel.readString());
            }
            return transparentCommandParcel;
        }

        @Override // android.os.Parcelable.Creator
        public TransparentCommandParcel[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new TransparentCommandParcel[0] : new TransparentCommandParcel[i10];
        }
    }

    /* renamed from: a */
    public void m56548a(String str) {
        this.f45297c = str;
    }

    /* renamed from: c */
    public void m56549c(byte[] bArr) {
        if (bArr != null) {
            this.f45299e = (byte[]) bArr.clone();
        } else {
            this.f45299e = null;
        }
    }

    /* renamed from: d */
    public void m56550d(int i10) {
        this.f45295a = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void m56551e(String str) {
        this.f45298d = str;
    }

    /* renamed from: f */
    public void m56552f(String str) {
        this.f45302h = str;
    }

    /* renamed from: g */
    public void m56553g(boolean z10) {
        this.f45301g = z10;
    }

    /* renamed from: h */
    public void m56554h(int i10) {
        this.f45300f = i10;
    }

    /* renamed from: i */
    public void m56555i(String str) {
        this.f45296b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.f45295a);
        parcel.writeString(this.f45296b);
        parcel.writeString(this.f45297c);
        parcel.writeString(this.f45298d);
        parcel.writeByteArray(this.f45299e);
        parcel.writeInt(this.f45300f);
        parcel.writeByte(this.f45301g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f45302h);
    }
}
