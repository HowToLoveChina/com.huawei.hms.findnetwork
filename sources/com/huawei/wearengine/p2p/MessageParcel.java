package com.huawei.wearengine.p2p;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

/* loaded from: classes9.dex */
public class MessageParcel implements Parcelable {
    public static final Parcelable.Creator<MessageParcel> CREATOR = new C8897a();

    /* renamed from: a */
    public int f45331a;

    /* renamed from: b */
    public byte[] f45332b;

    /* renamed from: c */
    public ParcelFileDescriptor f45333c;

    /* renamed from: d */
    public String f45334d;

    /* renamed from: e */
    public String f45335e;

    /* renamed from: f */
    public String f45336f;

    /* renamed from: com.huawei.wearengine.p2p.MessageParcel$a */
    public class C8897a implements Parcelable.Creator<MessageParcel> {
        @Override // android.os.Parcelable.Creator
        public MessageParcel createFromParcel(Parcel parcel) {
            MessageParcel messageParcel = new MessageParcel();
            if (parcel != null) {
                int i10 = parcel.readInt();
                messageParcel.m56577p(i10);
                if (MessageParcel.m56565i(i10)) {
                    messageParcel.m56572j(parcel.createByteArray());
                } else {
                    messageParcel.m56576o(parcel.readFileDescriptor());
                }
                messageParcel.m56574m(parcel.readString());
                messageParcel.m56573l(parcel.readString());
                messageParcel.m56575n(parcel.readString());
            }
            return messageParcel;
        }

        @Override // android.os.Parcelable.Creator
        public MessageParcel[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new MessageParcel[0] : new MessageParcel[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static boolean m56565i(int i10) {
        return i10 == 1;
    }

    /* renamed from: c */
    public byte[] m56566c() {
        byte[] bArr = this.f45332b;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    /* renamed from: d */
    public String m56567d() {
        return this.f45335e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String m56568e() {
        return this.f45334d;
    }

    /* renamed from: f */
    public String m56569f() {
        return this.f45336f;
    }

    /* renamed from: g */
    public ParcelFileDescriptor m56570g() {
        return this.f45333c;
    }

    /* renamed from: h */
    public int m56571h() {
        return this.f45331a;
    }

    /* renamed from: j */
    public void m56572j(byte[] bArr) {
        this.f45332b = bArr == null ? null : (byte[]) bArr.clone();
    }

    /* renamed from: l */
    public void m56573l(String str) {
        this.f45335e = str;
    }

    /* renamed from: m */
    public void m56574m(String str) {
        this.f45334d = str;
    }

    /* renamed from: n */
    public void m56575n(String str) {
        this.f45336f = str;
    }

    /* renamed from: o */
    public void m56576o(ParcelFileDescriptor parcelFileDescriptor) {
        this.f45333c = parcelFileDescriptor;
    }

    /* renamed from: p */
    public void m56577p(int i10) {
        this.f45331a = i10;
    }

    /* renamed from: q */
    public void m56578q(Parcel parcel) {
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.f45331a);
        if (this.f45331a == 1) {
            parcel.writeByteArray(this.f45332b);
        } else {
            ParcelFileDescriptor parcelFileDescriptor = this.f45333c;
            if (parcelFileDescriptor != null) {
                parcel.writeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            }
        }
        parcel.writeString(this.f45334d);
        parcel.writeString(this.f45335e);
        parcel.writeString(this.f45336f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        m56578q(parcel);
    }
}
