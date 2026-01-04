package com.huawei.ohos.localability.base;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class BundleInfo implements Parcelable {
    public static final Parcelable.Creator<BundleInfo> CREATOR = new C6828a();

    /* renamed from: a */
    public String f31439a;

    /* renamed from: b */
    public String f31440b;

    /* renamed from: c */
    public String f31441c;

    /* renamed from: d */
    public int f31442d;

    /* renamed from: e */
    public boolean f31443e;

    /* renamed from: f */
    public String f31444f;

    /* renamed from: g */
    public String f31445g;

    /* renamed from: h */
    public String f31446h;

    /* renamed from: i */
    public int f31447i;

    /* renamed from: j */
    public String f31448j;

    /* renamed from: k */
    public int f31449k;

    /* renamed from: l */
    public boolean f31450l;

    /* renamed from: m */
    public boolean f31451m;

    /* renamed from: n */
    public int f31452n;

    /* renamed from: o */
    public int f31453o;

    /* renamed from: p */
    public String f31454p;

    /* renamed from: q */
    public boolean f31455q;

    /* renamed from: r */
    public boolean f31456r;

    /* renamed from: s */
    public boolean f31457s;

    /* renamed from: t */
    public boolean f31458t;

    /* renamed from: u */
    public boolean f31459u;

    /* renamed from: v */
    public String f31460v;

    /* renamed from: w */
    public String f31461w;

    /* renamed from: x */
    public boolean f31462x;

    /* renamed from: y */
    public int f31463y;

    /* renamed from: z */
    public List<HapModuleInfo> f31464z;

    /* renamed from: com.huawei.ohos.localability.base.BundleInfo$a */
    public class C6828a implements Parcelable.Creator<BundleInfo> {
        @Override // android.os.Parcelable.Creator
        public BundleInfo createFromParcel(Parcel parcel) {
            return new BundleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BundleInfo[] newArray(int i10) {
            if (i10 >= 0) {
                return new BundleInfo[i10];
            }
            return null;
        }
    }

    public BundleInfo() {
        this.f31439a = "";
        this.f31440b = "";
        this.f31441c = "";
        this.f31442d = -1;
        this.f31443e = false;
        new C6844a();
        this.f31444f = "";
        this.f31445g = "";
        this.f31446h = "";
        this.f31447i = 0;
        this.f31448j = "";
        this.f31449k = 0;
        this.f31450l = false;
        this.f31451m = false;
        this.f31452n = 0;
        this.f31453o = 0;
        this.f31454p = "";
        this.f31455q = false;
        this.f31456r = false;
        this.f31457s = false;
        this.f31458t = true;
        this.f31459u = false;
        this.f31460v = "";
        this.f31461w = "";
        this.f31462x = false;
        this.f31463y = 0;
        this.f31464z = new ArrayList(0);
    }

    /* renamed from: a */
    public String m38542a() {
        return this.f31461w;
    }

    /* renamed from: c */
    public List<HapModuleInfo> m38543c() {
        return this.f31464z;
    }

    /* renamed from: d */
    public int m38544d() {
        return this.f31453o;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public int m38545e() {
        return this.f31452n;
    }

    /* renamed from: f */
    public String m38546f() {
        return this.f31439a;
    }

    /* renamed from: g */
    public int m38547g() {
        return this.f31447i;
    }

    /* renamed from: h */
    public String m38548h() {
        return this.f31448j;
    }

    /* renamed from: i */
    public boolean m38549i() {
        return this.f31451m;
    }

    /* renamed from: j */
    public boolean m38550j() {
        return this.f31450l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31439a);
        parcel.writeString(this.f31440b);
        parcel.writeString(this.f31445g);
        parcel.writeString(this.f31448j);
        parcel.writeInt(this.f31447i);
        parcel.writeInt(this.f31452n);
        parcel.writeInt(this.f31452n);
    }

    public BundleInfo(Parcel parcel) {
        this.f31439a = "";
        this.f31440b = "";
        this.f31441c = "";
        this.f31442d = -1;
        this.f31443e = false;
        new C6844a();
        this.f31444f = "";
        this.f31445g = "";
        this.f31446h = "";
        this.f31447i = 0;
        this.f31448j = "";
        this.f31449k = 0;
        this.f31450l = false;
        this.f31451m = false;
        this.f31452n = 0;
        this.f31453o = 0;
        this.f31454p = "";
        this.f31455q = false;
        this.f31456r = false;
        this.f31457s = false;
        this.f31458t = true;
        this.f31459u = false;
        this.f31460v = "";
        this.f31461w = "";
        this.f31462x = false;
        this.f31463y = 0;
        this.f31464z = new ArrayList(0);
        this.f31439a = parcel.readString();
        this.f31440b = parcel.readString();
        this.f31445g = parcel.readString();
        this.f31448j = parcel.readString();
        this.f31447i = parcel.readInt();
        this.f31452n = parcel.readInt();
        this.f31453o = parcel.readInt();
    }

    public BundleInfo(C6846d c6846d) {
        this.f31439a = "";
        this.f31440b = "";
        this.f31441c = "";
        this.f31442d = -1;
        this.f31443e = false;
        new C6844a();
        this.f31444f = "";
        this.f31445g = "";
        this.f31446h = "";
        this.f31447i = 0;
        this.f31448j = "";
        this.f31449k = 0;
        this.f31450l = false;
        this.f31451m = false;
        this.f31452n = 0;
        this.f31453o = 0;
        this.f31454p = "";
        this.f31455q = false;
        this.f31456r = false;
        this.f31457s = false;
        this.f31458t = true;
        this.f31459u = false;
        this.f31460v = "";
        this.f31461w = "";
        this.f31462x = false;
        this.f31463y = 0;
        this.f31464z = new ArrayList(0);
        this.f31439a = c6846d.f31545a;
        this.f31440b = c6846d.f31546b;
        this.f31445g = c6846d.f31551g;
        this.f31447i = c6846d.f31553i;
        this.f31448j = c6846d.f31554j;
        this.f31452n = c6846d.f31556l;
        this.f31453o = c6846d.f31557m;
        this.f31449k = c6846d.f31555k;
        this.f31450l = new JSONObject(c6846d.f31567w).optBoolean("multiFrameworkBundle", false);
        this.f31451m = new JSONObject(c6846d.f31567w).optInt("entryInstallationFree", -1) == 1;
        this.f31463y = new JSONObject(c6846d.f31567w).optInt("bundleType", 0);
        this.f31454p = c6846d.f31558n;
        this.f31455q = c6846d.f31559o;
        this.f31456r = c6846d.f31560p;
        this.f31457s = c6846d.f31561q;
        this.f31458t = c6846d.f31562r;
        this.f31459u = c6846d.f31563s;
        this.f31460v = c6846d.f31564t;
        this.f31441c = c6846d.f31547c;
        this.f31442d = c6846d.f31548d;
        this.f31444f = c6846d.f31550f;
        this.f31446h = c6846d.f31552h;
        this.f31443e = c6846d.f31549e;
        this.f31461w = c6846d.f31565u;
        this.f31462x = c6846d.f31566v;
        List<C6847e> list = c6846d.f31568x;
        if (list != null) {
            Iterator<C6847e> it = list.iterator();
            while (it.hasNext()) {
                this.f31464z.add(new HapModuleInfo(it.next()));
            }
        }
    }
}
