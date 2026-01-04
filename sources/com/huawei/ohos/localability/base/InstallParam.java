package com.huawei.ohos.localability.base;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class InstallParam implements Parcelable {
    public static final Parcelable.Creator<InstallParam> CREATOR = new C6842a();

    /* renamed from: a */
    public int f31516a;

    /* renamed from: b */
    public int f31517b;

    /* renamed from: c */
    public boolean f31518c;

    /* renamed from: d */
    public int f31519d;

    /* renamed from: e */
    public final Map<String, String> f31520e;

    /* renamed from: com.huawei.ohos.localability.base.InstallParam$a */
    public class C6842a implements Parcelable.Creator<InstallParam> {
        @Override // android.os.Parcelable.Creator
        public InstallParam createFromParcel(Parcel parcel) {
            return new InstallParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InstallParam[] newArray(int i10) {
            if (i10 >= 0) {
                return new InstallParam[i10];
            }
            return null;
        }
    }

    public InstallParam() {
        this.f31516a = -2;
        this.f31517b = 0;
        this.f31518c = false;
        this.f31519d = 1;
        this.f31520e = new HashMap();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f31516a);
        parcel.writeInt(this.f31517b);
        parcel.writeBoolean(this.f31518c);
        parcel.writeInt(this.f31519d);
    }

    public InstallParam(Parcel parcel) {
        this.f31516a = -2;
        this.f31517b = 0;
        this.f31518c = false;
        this.f31519d = 1;
        this.f31520e = new HashMap();
        this.f31516a = parcel.readInt();
        this.f31517b = parcel.readInt();
        this.f31518c = parcel.readBoolean();
        this.f31519d = parcel.readInt();
    }
}
