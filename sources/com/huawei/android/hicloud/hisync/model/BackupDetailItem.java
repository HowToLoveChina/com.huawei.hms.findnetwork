package com.huawei.android.hicloud.hisync.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;

/* loaded from: classes3.dex */
public class BackupDetailItem implements Parcelable {
    public static final Parcelable.Creator<BackupDetailItem> CREATOR = new C2802a();

    /* renamed from: d */
    public long f12230d;

    /* renamed from: f */
    public int f12232f;

    /* renamed from: h */
    public int f12234h;

    /* renamed from: i */
    public String f12235i;

    /* renamed from: j */
    public String f12236j;

    /* renamed from: k */
    public String f12237k;

    /* renamed from: a */
    public String f12227a = null;

    /* renamed from: b */
    public String f12228b = null;

    /* renamed from: c */
    public String f12229c = null;

    /* renamed from: e */
    public String f12231e = null;

    /* renamed from: g */
    public String f12233g = null;

    /* renamed from: l */
    public int f12238l = -1;

    /* renamed from: m */
    public String f12239m = "";

    /* renamed from: com.huawei.android.hicloud.hisync.model.BackupDetailItem$a */
    public class C2802a implements Parcelable.Creator<BackupDetailItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackupDetailItem createFromParcel(Parcel parcel) {
            BackupDetailItem backupDetailItem = new BackupDetailItem();
            backupDetailItem.m16391v(parcel.readString());
            backupDetailItem.m16369I(parcel.readString());
            backupDetailItem.m16372M(parcel.readString());
            backupDetailItem.m16386p(parcel.readInt());
            backupDetailItem.m16368A(parcel.readString());
            backupDetailItem.m16389s(parcel.readString());
            backupDetailItem.m16370K(parcel.readLong());
            backupDetailItem.m16390t(parcel.readInt());
            backupDetailItem.m16388r(parcel.readString());
            backupDetailItem.m16384n(parcel.readString());
            backupDetailItem.m16385o(parcel.readString());
            backupDetailItem.m16387q(parcel.readInt());
            backupDetailItem.m16371L(parcel.readString());
            return backupDetailItem;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackupDetailItem[] newArray(int i10) {
            return new BackupDetailItem[i10];
        }
    }

    /* renamed from: A */
    public void m16368A(String str) {
        this.f12231e = str;
    }

    /* renamed from: I */
    public void m16369I(String str) {
        this.f12228b = str;
    }

    /* renamed from: K */
    public void m16370K(long j10) {
        this.f12230d = j10;
    }

    /* renamed from: L */
    public void m16371L(String str) {
        this.f12239m = str;
    }

    /* renamed from: M */
    public void m16372M(String str) {
        this.f12229c = str;
    }

    /* renamed from: a */
    public void m16373a(CBSpaceDetail cBSpaceDetail) {
        m16369I(cBSpaceDetail.getDeviceName());
        m16389s(cBSpaceDetail.getDeviceID());
        m16390t(cBSpaceDetail.getDeviceType());
        m16368A(String.valueOf(cBSpaceDetail.getLastbackupTime()));
        if (cBSpaceDetail.isCurrent()) {
            m16386p(1);
        } else {
            m16386p(0);
        }
        m16370K(cBSpaceDetail.getSize());
        m16388r(cBSpaceDetail.getDeviceCategory());
        m16384n(cBSpaceDetail.getBackupDeviceId());
        m16371L(cBSpaceDetail.getTerminalType());
    }

    /* renamed from: c */
    public String m16374c() {
        return this.f12236j;
    }

    /* renamed from: d */
    public String m16375d() {
        return this.f12237k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public int m16376e() {
        return this.f12232f;
    }

    /* renamed from: f */
    public int m16377f() {
        return this.f12238l;
    }

    /* renamed from: g */
    public String m16378g() {
        return this.f12235i;
    }

    /* renamed from: h */
    public String m16379h() {
        return this.f12233g;
    }

    /* renamed from: i */
    public String m16380i() {
        return this.f12231e;
    }

    /* renamed from: j */
    public String m16381j() {
        return this.f12228b;
    }

    /* renamed from: l */
    public long m16382l() {
        return this.f12230d;
    }

    /* renamed from: m */
    public String m16383m() {
        return this.f12239m;
    }

    /* renamed from: n */
    public void m16384n(String str) {
        this.f12236j = str;
    }

    /* renamed from: o */
    public void m16385o(String str) {
        this.f12237k = str;
    }

    /* renamed from: p */
    public void m16386p(int i10) {
        this.f12232f = i10;
    }

    /* renamed from: q */
    public void m16387q(int i10) {
        this.f12238l = i10;
    }

    /* renamed from: r */
    public void m16388r(String str) {
        this.f12235i = str;
    }

    /* renamed from: s */
    public void m16389s(String str) {
        this.f12233g = str;
    }

    /* renamed from: t */
    public void m16390t(int i10) {
        this.f12234h = i10;
    }

    /* renamed from: v */
    public void m16391v(String str) {
        this.f12227a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12227a);
        parcel.writeString(this.f12228b);
        parcel.writeString(this.f12229c);
        parcel.writeInt(this.f12232f);
        parcel.writeString(this.f12231e);
        parcel.writeString(this.f12233g);
        parcel.writeLong(this.f12230d);
        parcel.writeInt(this.f12234h);
        parcel.writeString(this.f12235i);
        parcel.writeString(this.f12236j);
        parcel.writeString(this.f12237k);
        parcel.writeInt(this.f12238l);
        parcel.writeString(this.f12239m);
    }
}
