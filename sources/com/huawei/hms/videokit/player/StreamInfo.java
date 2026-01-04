package com.huawei.hms.videokit.player;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class StreamInfo implements Parcelable {
    public static final Parcelable.Creator<StreamInfo> CREATOR = new C6533a();

    /* renamed from: a */
    private int f30245a;

    /* renamed from: b */
    private boolean f30246b;

    /* renamed from: c */
    private int f30247c;

    /* renamed from: d */
    private int f30248d;

    /* renamed from: com.huawei.hms.videokit.player.StreamInfo$a */
    public class C6533a implements Parcelable.Creator<StreamInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StreamInfo createFromParcel(Parcel parcel) {
            return new StreamInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StreamInfo[] newArray(int i10) {
            return new StreamInfo[i10];
        }
    }

    public StreamInfo() {
    }

    public StreamInfo(Parcel parcel) {
        this.f30245a = parcel.readInt();
        this.f30246b = parcel.readByte() != 0;
        this.f30247c = parcel.readInt();
        this.f30248d = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBitrate() {
        return this.f30245a;
    }

    public boolean getIsHdr() {
        return this.f30246b;
    }

    public int getVideoHeight() {
        return this.f30247c;
    }

    public int getVideoWidth() {
        return this.f30248d;
    }

    public void setBitrate(int i10) {
        this.f30245a = i10;
    }

    public void setIsHdr(boolean z10) {
        this.f30246b = z10;
    }

    public void setVideoHeight(int i10) {
        this.f30247c = i10;
    }

    public void setVideoWidth(int i10) {
        this.f30248d = i10;
    }

    public String toString() {
        return "bitrate:" + this.f30245a + ",isHdr:" + this.f30246b + ",videoHeight:" + this.f30247c + ",videoWidth:" + this.f30248d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f30245a);
        parcel.writeByte(this.f30246b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f30247c);
        parcel.writeInt(this.f30248d);
    }
}
