package com.huawei.hms.videokit.player;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class AudioTrackInfo implements Parcelable {
    public static final Parcelable.Creator<AudioTrackInfo> CREATOR = new C6526a();

    /* renamed from: a */
    private int f30219a;

    /* renamed from: b */
    private String f30220b;

    /* renamed from: c */
    private boolean f30221c;

    /* renamed from: com.huawei.hms.videokit.player.AudioTrackInfo$a */
    public class C6526a implements Parcelable.Creator<AudioTrackInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AudioTrackInfo createFromParcel(Parcel parcel) {
            return new AudioTrackInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AudioTrackInfo[] newArray(int i10) {
            return new AudioTrackInfo[i10];
        }
    }

    public AudioTrackInfo() {
    }

    public AudioTrackInfo(Parcel parcel) {
        this.f30219a = parcel.readInt();
        this.f30220b = parcel.readString();
        this.f30221c = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f30220b;
    }

    public int getId() {
        return this.f30219a;
    }

    public boolean getSelected() {
        return this.f30221c;
    }

    public void setDesc(String str) {
        this.f30220b = str;
    }

    public void setId(int i10) {
        this.f30219a = i10;
    }

    public void setSelected(boolean z10) {
        this.f30221c = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f30219a);
        parcel.writeString(this.f30220b);
        parcel.writeByte(this.f30221c ? (byte) 1 : (byte) 0);
    }
}
