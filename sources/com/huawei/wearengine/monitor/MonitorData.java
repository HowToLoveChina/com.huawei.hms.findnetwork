package com.huawei.wearengine.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class MonitorData implements Parcelable {
    public static final Parcelable.Creator<MonitorData> CREATOR = new C8892a();

    /* renamed from: a */
    public boolean f45303a;

    /* renamed from: b */
    public int f45304b;

    /* renamed from: c */
    public String f45305c;

    /* renamed from: d */
    public HashMap<String, MonitorData> f45306d;

    /* renamed from: com.huawei.wearengine.monitor.MonitorData$a */
    public class C8892a implements Parcelable.Creator<MonitorData> {
        @Override // android.os.Parcelable.Creator
        public MonitorData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            return new MonitorData(parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readHashMap(HashMap.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public MonitorData[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new MonitorData[0] : new MonitorData[i10];
        }
    }

    public MonitorData(boolean z10, int i10, String str, HashMap<String, MonitorData> map) {
        this.f45303a = z10;
        this.f45304b = i10;
        this.f45305c = str;
        this.f45306d = map;
    }

    /* renamed from: a */
    public int m56556a() {
        return this.f45304b;
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
        parcel.writeInt(this.f45303a ? 1 : 0);
        parcel.writeInt(this.f45304b);
        parcel.writeString(this.f45305c);
        parcel.writeMap(this.f45306d);
    }
}
