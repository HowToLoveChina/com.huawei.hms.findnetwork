package com.huawei.wearengine.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceSwitchSuggestDialog;

/* loaded from: classes9.dex */
public class Permission implements Parcelable {
    public static final Parcelable.Creator<Permission> CREATOR = new C8883a();

    /* renamed from: b */
    public static final Permission f45263b = new Permission("device_manager");

    /* renamed from: c */
    public static final Permission f45264c = new Permission(SpaceSwitchSuggestDialog.SCENE_ID_NOTIFY);

    /* renamed from: d */
    public static final Permission f45265d = new Permission("sensor");

    /* renamed from: e */
    public static final Permission f45266e = new Permission("motion_sensor");

    /* renamed from: f */
    public static final Permission f45267f = new Permission("wear_user_status");

    /* renamed from: g */
    public static final Permission f45268g = new Permission("device_sn");

    /* renamed from: a */
    public final String f45269a;

    /* renamed from: com.huawei.wearengine.auth.Permission$a */
    public class C8883a implements Parcelable.Creator<Permission> {
        @Override // android.os.Parcelable.Creator
        public Permission createFromParcel(Parcel parcel) {
            C8883a c8883a = null;
            return parcel == null ? new Permission("", c8883a) : new Permission(parcel.readString(), c8883a);
        }

        @Override // android.os.Parcelable.Creator
        public Permission[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new Permission[0] : new Permission[i10];
        }
    }

    public Permission(String str) {
        this.f45269a = str;
    }

    /* renamed from: a */
    public String m56498a() {
        return this.f45269a;
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
        parcel.writeString(this.f45269a);
    }

    public /* synthetic */ Permission(String str, C8883a c8883a) {
        this(str);
    }
}
