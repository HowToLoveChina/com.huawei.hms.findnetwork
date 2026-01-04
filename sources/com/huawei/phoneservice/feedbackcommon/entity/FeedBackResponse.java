package com.huawei.phoneservice.feedbackcommon.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes5.dex */
public class FeedBackResponse implements Serializable, Parcelable {
    public static final Parcelable.Creator<FeedBackResponse> CREATOR = new C8604a();
    private static final long serialVersionUID = -5533984095408646461L;

    /* renamed from: a */
    @SerializedName("data")
    private List<ProblemEnity> f40033a;

    public static class ProblemEnity implements Serializable, Parcelable {
        public static final Parcelable.Creator<ProblemEnity> CREATOR = new C8603a();
        private static final long serialVersionUID = 6410105318113796076L;

        /* renamed from: a */
        @SerializedName("problemId")
        private String f40034a;

        /* renamed from: b */
        @SerializedName("problemDesc")
        private String f40035b;

        /* renamed from: c */
        @SerializedName("answer")
        private String f40036c;

        /* renamed from: d */
        @SerializedName("attaches")
        private List<FeedMedia> f40037d;

        /* renamed from: e */
        @SerializedName("pic")
        private FeedMedia f40038e;

        /* renamed from: f */
        @SerializedName("createTime")
        private String f40039f;

        /* renamed from: g */
        @SerializedName("score")
        private String f40040g;

        /* renamed from: h */
        @SerializedName("read")
        private boolean f40041h;

        /* renamed from: i */
        @SerializedName("srcno")
        private String f40042i;

        /* renamed from: j */
        @SerializedName("answerTime")
        private String f40043j;

        /* renamed from: k */
        @SerializedName("updateTime")
        private String f40044k;

        /* renamed from: l */
        @SerializedName("problemCatalogCode")
        private String f40045l;

        /* renamed from: m */
        @SerializedName(HNConstants.DataType.CONTACT)
        private String f40046m;

        /* renamed from: n */
        @SerializedName("isSelectMode")
        private boolean f40047n;

        /* renamed from: o */
        @SerializedName("isChecked")
        private boolean f40048o;

        /* renamed from: com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse$ProblemEnity$a */
        public class C8603a implements Parcelable.Creator<ProblemEnity> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ProblemEnity createFromParcel(Parcel parcel) {
                return new ProblemEnity(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ProblemEnity[] newArray(int i10) {
                return new ProblemEnity[i10];
            }
        }

        public ProblemEnity(Parcel parcel) {
            this.f40034a = parcel.readString();
            this.f40035b = parcel.readString();
            this.f40036c = parcel.readString();
            this.f40037d = parcel.createTypedArrayList(FeedMedia.CREATOR);
            this.f40038e = (FeedMedia) parcel.readParcelable(FeedMedia.class.getClassLoader());
            this.f40039f = parcel.readString();
            this.f40040g = parcel.readString();
            this.f40041h = parcel.readByte() != 0;
            this.f40042i = parcel.readString();
            this.f40043j = parcel.readString();
            this.f40044k = parcel.readString();
            this.f40045l = parcel.readString();
            this.f40046m = parcel.readString();
            this.f40047n = parcel.readByte() != 0;
            this.f40048o = parcel.readByte() != 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Keep
        public String getAnswer() {
            return this.f40036c;
        }

        @Keep
        public String getAnswerTime() {
            return this.f40043j;
        }

        @Keep
        public String getContact() {
            return this.f40046m;
        }

        @Keep
        public String getCreateTime() {
            return this.f40039f;
        }

        @Keep
        public boolean getIsRead() {
            return this.f40041h;
        }

        @Keep
        public List<FeedMedia> getMediaItemList() {
            return this.f40037d;
        }

        @Keep
        public FeedMedia getPicURL() {
            return this.f40038e;
        }

        @Keep
        public String getProblemCatalogCode() {
            return this.f40045l;
        }

        @Keep
        public String getProblemDesc() {
            return this.f40035b;
        }

        @Keep
        public String getProblemId() {
            return this.f40034a;
        }

        @Keep
        public String getScore() {
            return this.f40040g;
        }

        @Keep
        public String getSrno() {
            return this.f40042i;
        }

        @Keep
        public String getUpdateTime() {
            return this.f40044k;
        }

        @Keep
        public boolean isChecked() {
            return this.f40048o;
        }

        @Keep
        public boolean isSelectMode() {
            return this.f40047n;
        }

        @Keep
        public void setChecked(boolean z10) {
            this.f40048o = z10;
        }

        @Keep
        public void setIsRead(boolean z10) {
            this.f40041h = z10;
        }

        @Keep
        public void setScore(String str) {
            this.f40040g = str;
        }

        @Keep
        public void setSelectMode(boolean z10) {
            this.f40047n = z10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f40034a);
            parcel.writeString(this.f40035b);
            parcel.writeString(this.f40036c);
            parcel.writeTypedList(this.f40037d);
            parcel.writeParcelable(this.f40038e, i10);
            parcel.writeString(this.f40039f);
            parcel.writeString(this.f40040g);
            parcel.writeByte(this.f40041h ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f40042i);
            parcel.writeString(this.f40043j);
            parcel.writeString(this.f40044k);
            parcel.writeString(this.f40045l);
            parcel.writeString(this.f40046m);
            parcel.writeByte(this.f40047n ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f40048o ? (byte) 1 : (byte) 0);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse$a */
    public class C8604a implements Parcelable.Creator<FeedBackResponse> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedBackResponse createFromParcel(Parcel parcel) {
            return new FeedBackResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FeedBackResponse[] newArray(int i10) {
            return new FeedBackResponse[i10];
        }
    }

    public FeedBackResponse(Parcel parcel) {
        this.f40033a = parcel.createTypedArrayList(ProblemEnity.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Keep
    public List<ProblemEnity> getDataList() {
        return this.f40033a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
    }
}
