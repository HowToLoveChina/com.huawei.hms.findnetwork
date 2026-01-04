package com.huawei.hms.videokit.player;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class CacheInfo implements Parcelable {
    public static final Parcelable.Creator<CacheInfo> CREATOR = new C6527a();

    /* renamed from: a */
    private String f30222a;

    /* renamed from: b */
    private String f30223b;

    /* renamed from: c */
    private String f30224c;

    /* renamed from: d */
    private int f30225d;

    /* renamed from: e */
    private int f30226e;

    /* renamed from: f */
    private int f30227f;

    /* renamed from: g */
    private int f30228g;

    /* renamed from: com.huawei.hms.videokit.player.CacheInfo$a */
    public class C6527a implements Parcelable.Creator<CacheInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CacheInfo createFromParcel(Parcel parcel) {
            return new CacheInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CacheInfo[] newArray(int i10) {
            return new CacheInfo[i10];
        }
    }

    public CacheInfo() {
    }

    public CacheInfo(Parcel parcel) {
        this.f30222a = parcel.readString();
        this.f30223b = parcel.readString();
        this.f30224c = parcel.readString();
        this.f30225d = parcel.readInt();
        this.f30226e = parcel.readInt();
        this.f30227f = parcel.readInt();
        this.f30228g = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppId() {
        return this.f30224c;
    }

    public int getCacheSize() {
        return this.f30227f;
    }

    public int getHeight() {
        return this.f30226e;
    }

    public String getPlayParam() {
        return this.f30223b;
    }

    public String getUrl() {
        return this.f30222a;
    }

    public int getVideoFormat() {
        return this.f30228g;
    }

    public int getWidth() {
        return this.f30225d;
    }

    public void setAppId(String str) {
        this.f30224c = str;
    }

    public void setCacheSize(int i10) {
        this.f30227f = i10;
    }

    public void setHeight(int i10) {
        this.f30226e = i10;
    }

    public void setPlayParam(String str) {
        this.f30223b = str;
    }

    public void setUrl(String str) {
        this.f30222a = str;
    }

    public void setVideoFormat(int i10) {
        this.f30228g = i10;
    }

    public void setWidth(int i10) {
        this.f30225d = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f30222a);
        parcel.writeString(this.f30223b);
        parcel.writeString(this.f30224c);
        parcel.writeInt(this.f30225d);
        parcel.writeInt(this.f30226e);
        parcel.writeInt(this.f30227f);
        parcel.writeInt(this.f30228g);
    }

    public CacheInfo(String str, int i10) {
        this.f30222a = str;
        this.f30227f = i10;
    }

    public CacheInfo(String str, int i10, int i11) {
        this.f30222a = str;
        this.f30225d = i10;
        this.f30226e = i11;
    }

    public CacheInfo(String str, String str2, int i10, int i11) {
        this.f30223b = str;
        this.f30224c = str2;
        this.f30225d = i10;
        this.f30226e = i11;
    }

    public CacheInfo(String str, String str2, int i10, int i11, int i12) {
        this.f30223b = str;
        this.f30224c = str2;
        this.f30225d = i10;
        this.f30226e = i11;
        this.f30228g = i12;
    }
}
