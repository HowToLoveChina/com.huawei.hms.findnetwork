package com.huawei.wearengine.device;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import p788xu.C13866a;

/* loaded from: classes9.dex */
public class Device implements Parcelable {
    public static final Parcelable.Creator<Device> CREATOR = new C8888a();

    /* renamed from: a */
    public String f45284a;

    /* renamed from: b */
    public String f45285b;

    /* renamed from: c */
    public String f45286c;

    /* renamed from: d */
    public int f45287d = -1;

    /* renamed from: e */
    public int f45288e;

    /* renamed from: f */
    public String f45289f;

    /* renamed from: com.huawei.wearengine.device.Device$a */
    public class C8888a implements Parcelable.Creator<Device> {
        @Override // android.os.Parcelable.Creator
        public Device createFromParcel(Parcel parcel) {
            Device device = new Device();
            if (parcel != null) {
                device.m56539r(parcel.readString());
                device.m56542v(parcel.readString());
                device.m56538q(parcel.readString());
                device.m56540s(parcel.readInt());
                device.m56537p(parcel.readInt());
                device.m56541t(parcel.readString());
            }
            return device;
        }

        @Override // android.os.Parcelable.Creator
        public Device[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new Device[0] : new Device[i10];
        }
    }

    /* renamed from: a */
    public String m56524a() {
        return C13866a.m83194a(this.f45289f);
    }

    /* renamed from: c */
    public int m56525c() {
        return C13866a.m83195b(this.f45289f);
    }

    /* renamed from: d */
    public String m56526d() {
        return this.f45286c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public int m56527e() {
        return C13866a.m83196c(this.f45289f);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        String str = this.f45285b;
        if (str == null || device.f45285b == null) {
            return false;
        }
        return str.equals(device.m56534m());
    }

    /* renamed from: f */
    public String m56528f() {
        return this.f45284a;
    }

    /* renamed from: g */
    public int m56529g() {
        return C13866a.m83197d(this.f45289f);
    }

    /* renamed from: h */
    public int m56530h() {
        return C13866a.m83198e(this.f45289f);
    }

    public int hashCode() {
        String str = this.f45285b;
        if (str != null) {
            return str.hashCode();
        }
        return -1;
    }

    /* renamed from: i */
    public String m56531i() {
        String strM83199f = C13866a.m83199f(this.f45289f);
        return TextUtils.isEmpty(strM83199f) ? this.f45289f : strM83199f;
    }

    /* renamed from: j */
    public int m56532j() {
        return C13866a.m83200g(this.f45289f);
    }

    /* renamed from: l */
    public String m56533l() {
        return C13866a.m83201h(this.f45289f);
    }

    /* renamed from: m */
    public String m56534m() {
        return this.f45285b;
    }

    /* renamed from: n */
    public boolean m56535n() {
        return this.f45288e == 2;
    }

    /* renamed from: o */
    public boolean m56536o() {
        return C13866a.m83202i(this.f45289f);
    }

    /* renamed from: p */
    public void m56537p(int i10) {
        this.f45288e = i10;
    }

    /* renamed from: q */
    public void m56538q(String str) {
        this.f45286c = str;
    }

    /* renamed from: r */
    public void m56539r(String str) {
        this.f45284a = str;
    }

    /* renamed from: s */
    public void m56540s(int i10) {
        this.f45287d = i10;
    }

    /* renamed from: t */
    public void m56541t(String str) {
        this.f45289f = str;
    }

    public String toString() {
        return "Device{mName='" + this.f45284a + "', mUuid='" + this.f45285b + "', mModel='" + this.f45286c + "', mProductType='" + this.f45287d + "', mConnectState='" + this.f45288e + "', mReservedness='" + m56531i() + "', mSoftwareVersion='" + m56533l() + "', isSupportOta='" + m56536o() + "', mP2pCapability='" + m56530h() + "', mMonitorCapability='" + m56527e() + "', mNotifyCapability='" + m56529g() + "', mSensorCapability='" + m56532j() + "', mDeviceCategory='" + m56524a() + "', mDeviceType='" + m56525c() + "'}";
    }

    /* renamed from: v */
    public void m56542v(String str) {
        this.f45285b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.f45284a);
        parcel.writeString(this.f45285b);
        parcel.writeString(this.f45286c);
        parcel.writeInt(this.f45287d);
        parcel.writeInt(this.f45288e);
        parcel.writeString(this.f45289f);
    }
}
