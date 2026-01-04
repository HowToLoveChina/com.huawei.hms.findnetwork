package com.huawei.hms.videokit.player;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class WisePlayerFactoryOptions implements Parcelable {
    public static final Parcelable.Creator<WisePlayerFactoryOptions> CREATOR = new C6538a();
    private String deviceId;

    public static class Builder {
        private String deviceId;

        public WisePlayerFactoryOptions build() {
            return new WisePlayerFactoryOptions(this, null);
        }

        public Builder setDeviceId(String str) {
            this.deviceId = str;
            return this;
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.WisePlayerFactoryOptions$a */
    public class C6538a implements Parcelable.Creator<WisePlayerFactoryOptions> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WisePlayerFactoryOptions createFromParcel(Parcel parcel) {
            return new WisePlayerFactoryOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WisePlayerFactoryOptions[] newArray(int i10) {
            return new WisePlayerFactoryOptions[i10];
        }
    }

    public WisePlayerFactoryOptions(Parcel parcel) {
        this.deviceId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.deviceId);
    }

    private WisePlayerFactoryOptions(Builder builder) {
        this.deviceId = builder.deviceId;
    }

    public /* synthetic */ WisePlayerFactoryOptions(Builder builder, C6538a c6538a) {
        this(builder);
    }
}
