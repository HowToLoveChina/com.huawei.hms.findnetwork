package com.huawei.hms.videokit.player;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class InitBitrateParam implements Parcelable {
    public static final Parcelable.Creator<InitBitrateParam> CREATOR = new C6528a();

    /* renamed from: a */
    private int f30229a;

    /* renamed from: b */
    private int f30230b;

    /* renamed from: c */
    private int f30231c;

    /* renamed from: d */
    private int f30232d;

    /* renamed from: com.huawei.hms.videokit.player.InitBitrateParam$a */
    public class C6528a implements Parcelable.Creator<InitBitrateParam> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InitBitrateParam createFromParcel(Parcel parcel) {
            return new InitBitrateParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InitBitrateParam[] newArray(int i10) {
            return new InitBitrateParam[i10];
        }
    }

    public InitBitrateParam() {
        this.f30230b = 0;
        this.f30231c = 0;
        this.f30232d = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBitrate() {
        return this.f30229a;
    }

    public int getHeight() {
        return this.f30232d;
    }

    public int getType() {
        return this.f30230b;
    }

    public int getWidth() {
        return this.f30231c;
    }

    public void setBitrate(int i10) {
        this.f30229a = i10;
    }

    public void setHeight(int i10) {
        this.f30232d = i10;
    }

    public void setType(int i10) {
        this.f30230b = i10;
    }

    public void setWidth(int i10) {
        this.f30231c = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f30229a);
        parcel.writeInt(this.f30230b);
        parcel.writeInt(this.f30231c);
        parcel.writeInt(this.f30232d);
    }

    public InitBitrateParam(Parcel parcel) {
        this.f30230b = 0;
        this.f30231c = 0;
        this.f30232d = 0;
        this.f30229a = parcel.readInt();
        this.f30230b = parcel.readInt();
        this.f30231c = parcel.readInt();
        this.f30232d = parcel.readInt();
    }
}
