package com.huawei.phoneservice.feedbackcommon.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class FeedMedia implements Serializable, Parcelable {
    public static final Parcelable.Creator<FeedMedia> CREATOR = new C8605a();
    private static final long serialVersionUID = -6196153509419034853L;

    /* renamed from: a */
    @SerializedName("size")
    private String f40049a;

    /* renamed from: b */
    @SerializedName("attachId")
    private String f40050b;

    /* renamed from: c */
    @SerializedName("downloadURL")
    private String f40051c;

    /* renamed from: d */
    @SerializedName("isReplay")
    private boolean f40052d;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.entity.FeedMedia$a */
    public class C8605a implements Parcelable.Creator<FeedMedia> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedMedia createFromParcel(Parcel parcel) {
            return new FeedMedia(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FeedMedia[] newArray(int i10) {
            return new FeedMedia[i10];
        }
    }

    public FeedMedia(Parcel parcel) {
        this.f40052d = false;
        this.f40049a = parcel.readString();
        this.f40050b = parcel.readString();
        this.f40051c = parcel.readString();
        this.f40052d = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Keep
    public String getAttachId() {
        return this.f40050b;
    }

    @Keep
    public String getDownloadURL() {
        return this.f40051c;
    }

    @Keep
    public String getSize() {
        return this.f40049a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f40049a);
        parcel.writeString(this.f40050b);
        parcel.writeString(this.f40051c);
        parcel.writeByte(this.f40052d ? (byte) 1 : (byte) 0);
    }
}
