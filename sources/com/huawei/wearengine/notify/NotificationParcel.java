package com.huawei.wearengine.notify;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class NotificationParcel implements Parcelable {
    public static final Parcelable.Creator<NotificationParcel> CREATOR = new C8894a();

    /* renamed from: a */
    public int f45318a;

    /* renamed from: b */
    public String f45319b;

    /* renamed from: c */
    public String f45320c;

    /* renamed from: d */
    public String f45321d;

    /* renamed from: e */
    public HashMap<Integer, String> f45322e;

    /* renamed from: f */
    public int f45323f;

    /* renamed from: g */
    public int f45324g;

    /* renamed from: h */
    public String f45325h;

    /* renamed from: com.huawei.wearengine.notify.NotificationParcel$a */
    public class C8894a implements Parcelable.Creator<NotificationParcel> {
        @Override // android.os.Parcelable.Creator
        public NotificationParcel createFromParcel(Parcel parcel) {
            return new NotificationParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NotificationParcel[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new NotificationParcel[0] : new NotificationParcel[i10];
        }
    }

    public NotificationParcel(Parcel parcel) {
        this.f45324g = -1;
        this.f45325h = "";
        if (parcel == null) {
            return;
        }
        this.f45318a = parcel.readInt();
        this.f45319b = parcel.readString();
        this.f45320c = parcel.readString();
        this.f45321d = parcel.readString();
        this.f45322e = parcel.readHashMap(HashMap.class.getClassLoader());
        this.f45323f = parcel.readInt();
        this.f45324g = parcel.readInt();
        this.f45325h = parcel.readString();
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
        parcel.writeInt(this.f45318a);
        parcel.writeString(this.f45319b);
        parcel.writeString(this.f45320c);
        parcel.writeString(this.f45321d);
        parcel.writeMap(this.f45322e);
        parcel.writeInt(this.f45323f);
        parcel.writeInt(this.f45324g);
        parcel.writeString(this.f45325h);
    }
}
