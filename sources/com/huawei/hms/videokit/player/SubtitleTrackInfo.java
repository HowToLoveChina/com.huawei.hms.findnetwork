package com.huawei.hms.videokit.player;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class SubtitleTrackInfo implements Parcelable {
    public static final Parcelable.Creator<SubtitleTrackInfo> CREATOR = new C6534a();

    /* renamed from: a */
    private int f30249a;

    /* renamed from: b */
    private int f30250b;

    /* renamed from: c */
    private String f30251c;

    /* renamed from: d */
    private boolean f30252d;

    /* renamed from: com.huawei.hms.videokit.player.SubtitleTrackInfo$a */
    public class C6534a implements Parcelable.Creator<SubtitleTrackInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubtitleTrackInfo createFromParcel(Parcel parcel) {
            return new SubtitleTrackInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubtitleTrackInfo[] newArray(int i10) {
            return new SubtitleTrackInfo[i10];
        }
    }

    public SubtitleTrackInfo() {
    }

    public SubtitleTrackInfo(Parcel parcel) {
        this.f30249a = parcel.readInt();
        this.f30250b = parcel.readInt();
        this.f30251c = parcel.readString();
        this.f30252d = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f30251c;
    }

    public int getId() {
        return this.f30249a;
    }

    public boolean getSelected() {
        return this.f30252d;
    }

    public int getType() {
        return this.f30250b;
    }

    public void setDesc(String str) {
        this.f30251c = str;
    }

    public void setId(int i10) {
        this.f30249a = i10;
    }

    public void setSelected(boolean z10) {
        this.f30252d = z10;
    }

    public void setType(int i10) {
        this.f30250b = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f30249a);
        parcel.writeInt(this.f30250b);
        parcel.writeString(this.f30251c);
        parcel.writeByte(this.f30252d ? (byte) 1 : (byte) 0);
    }
}
