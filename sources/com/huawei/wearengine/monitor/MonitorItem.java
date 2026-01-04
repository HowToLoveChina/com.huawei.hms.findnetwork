package com.huawei.wearengine.monitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes9.dex */
public class MonitorItem implements Parcelable {

    /* renamed from: a */
    public String f45317a;

    /* renamed from: b */
    public static final MonitorItem f45307b = new MonitorItem("connectionStatus");

    /* renamed from: c */
    public static final MonitorItem f45308c = new MonitorItem("wearStatus");

    /* renamed from: d */
    public static final MonitorItem f45309d = new MonitorItem("sleepStatus");

    /* renamed from: e */
    public static final MonitorItem f45310e = new MonitorItem("lowPower");

    /* renamed from: f */
    public static final MonitorItem f45311f = new MonitorItem("sportStatus");

    /* renamed from: g */
    public static final MonitorItem f45312g = new MonitorItem("powerStatus");

    /* renamed from: h */
    public static final MonitorItem f45313h = new MonitorItem("chargeStatus");

    /* renamed from: i */
    public static final MonitorItem f45314i = new MonitorItem("heartRateAlarm");

    /* renamed from: j */
    public static final MonitorItem f45315j = new MonitorItem("userAvailableKbytes");

    /* renamed from: k */
    public static final MonitorItem f45316k = new MonitorItem("powerMode");
    public static final Parcelable.Creator<MonitorItem> CREATOR = new C8893a();

    /* renamed from: com.huawei.wearengine.monitor.MonitorItem$a */
    public class C8893a implements Parcelable.Creator<MonitorItem> {
        @Override // android.os.Parcelable.Creator
        public MonitorItem createFromParcel(Parcel parcel) {
            MonitorItem monitorItem = new MonitorItem();
            if (parcel != null) {
                monitorItem.m56558c(parcel.readString());
            }
            return monitorItem;
        }

        @Override // android.os.Parcelable.Creator
        public MonitorItem[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new MonitorItem[0] : new MonitorItem[i10];
        }
    }

    public MonitorItem() {
    }

    public MonitorItem(String str) {
        this.f45317a = str;
    }

    /* renamed from: a */
    public String m56557a() {
        return this.f45317a;
    }

    /* renamed from: c */
    public void m56558c(String str) {
        this.f45317a = str;
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
        parcel.writeString(this.f45317a);
    }
}
