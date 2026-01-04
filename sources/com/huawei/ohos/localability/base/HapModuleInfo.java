package com.huawei.ohos.localability.base;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class HapModuleInfo implements Parcelable {
    public static final Parcelable.Creator<HapModuleInfo> CREATOR = new C6839a();

    /* renamed from: a */
    public String f31501a;

    /* renamed from: b */
    public int f31502b;

    /* renamed from: c */
    public String f31503c;

    /* renamed from: d */
    public String f31504d;

    /* renamed from: e */
    public String f31505e;

    /* renamed from: f */
    public int f31506f;

    /* renamed from: g */
    public int f31507g;

    /* renamed from: h */
    public EnumC6840b f31508h;

    /* renamed from: i */
    public List<String> f31509i;

    /* renamed from: j */
    public String f31510j;

    /* renamed from: com.huawei.ohos.localability.base.HapModuleInfo$a */
    public class C6839a implements Parcelable.Creator<HapModuleInfo> {
        @Override // android.os.Parcelable.Creator
        public HapModuleInfo createFromParcel(Parcel parcel) {
            return new HapModuleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HapModuleInfo[] newArray(int i10) {
            if (i10 >= 0) {
                return new HapModuleInfo[i10];
            }
            return null;
        }
    }

    /* renamed from: com.huawei.ohos.localability.base.HapModuleInfo$b */
    public enum EnumC6840b {
        UNKNOWN,
        ENTRY,
        FEATURE,
        SHARED
    }

    public HapModuleInfo() {
        this.f31502b = -1;
        this.f31508h = EnumC6840b.UNKNOWN;
        this.f31509i = new ArrayList();
    }

    /* renamed from: a */
    public String m38571a() {
        return this.f31501a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31501a);
        parcel.writeInt(this.f31502b);
        parcel.writeString(this.f31503c);
        parcel.writeString(this.f31504d);
        parcel.writeString(this.f31505e);
        parcel.writeInt(this.f31506f);
        parcel.writeInt(this.f31507g);
        parcel.writeInt(this.f31506f);
        parcel.writeInt(this.f31507g);
    }

    public HapModuleInfo(Parcel parcel) {
        this.f31502b = -1;
        this.f31508h = EnumC6840b.UNKNOWN;
        this.f31509i = new ArrayList();
        this.f31501a = parcel.readString();
        this.f31502b = parcel.readInt();
        this.f31503c = parcel.readString();
        this.f31504d = parcel.readString();
        this.f31505e = parcel.readString();
        parcel.readInt();
        parcel.readInt();
        this.f31506f = parcel.readInt();
        this.f31507g = parcel.readInt();
    }

    public HapModuleInfo(C6847e c6847e) throws JSONException {
        int iOptInt;
        String string;
        this.f31502b = -1;
        this.f31508h = EnumC6840b.UNKNOWN;
        this.f31509i = new ArrayList();
        this.f31501a = c6847e.f31569a;
        this.f31502b = c6847e.f31570b;
        this.f31503c = c6847e.f31572d;
        this.f31504d = c6847e.f31573e;
        this.f31505e = c6847e.f31574f;
        this.f31506f = c6847e.f31575g;
        this.f31507g = c6847e.f31576h;
        try {
            iOptInt = new JSONObject(c6847e.f31571c).optInt("moduleType", 0);
        } catch (JSONException unused) {
            iOptInt = 0;
        }
        if (iOptInt >= 0 && iOptInt < EnumC6840b.values().length) {
            this.f31508h = EnumC6840b.values()[iOptInt];
        }
        ArrayList arrayList = new ArrayList(0);
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(c6847e.f31571c).optJSONArray("dependencies");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i10));
                }
            }
        } catch (JSONException unused2) {
        }
        this.f31509i = arrayList;
        try {
            string = new JSONObject(c6847e.f31571c).getString("hashValue");
        } catch (JSONException unused3) {
            string = "";
        }
        this.f31510j = string;
    }
}
