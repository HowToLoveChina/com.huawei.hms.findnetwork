package com.huawei.hms.videokit.player;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class VideoInfo implements Parcelable {
    public static final Parcelable.Creator<VideoInfo> CREATOR = new C6536a();

    /* renamed from: a */
    private int f30255a;

    /* renamed from: b */
    private List<StreamInfo> f30256b;

    /* renamed from: com.huawei.hms.videokit.player.VideoInfo$a */
    public class C6536a implements Parcelable.Creator<VideoInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoInfo createFromParcel(Parcel parcel) {
            return new VideoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoInfo[] newArray(int i10) {
            return new VideoInfo[i10];
        }
    }

    public VideoInfo() {
    }

    public VideoInfo(Parcel parcel) {
        this.f30255a = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.f30256b = arrayList;
        parcel.readList(arrayList, StreamInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDuration() {
        return this.f30255a;
    }

    public List<StreamInfo> getStreamInfos() {
        return this.f30256b;
    }

    public void setDuration(int i10) {
        this.f30255a = i10;
    }

    public void setStreamInfos(List<StreamInfo> list) {
        this.f30256b = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f30255a);
        parcel.writeList(this.f30256b);
    }
}
