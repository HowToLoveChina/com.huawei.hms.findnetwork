package com.huawei.phoneservice.feedbackcommon.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.HNConstants;

/* loaded from: classes5.dex */
public class FeedbackInfo implements Parcelable {
    public static final Parcelable.Creator<FeedbackInfo> CREATOR = new C8606a();

    /* renamed from: a */
    @SerializedName("problemId")
    private String f40053a;

    /* renamed from: b */
    @SerializedName("parentId")
    private String f40054b;

    /* renamed from: c */
    @SerializedName("childId")
    private String f40055c;

    /* renamed from: d */
    @SerializedName("problemDesc")
    private String f40056d;

    /* renamed from: e */
    @SerializedName(HNConstants.DataType.CONTACT)
    private String f40057e;

    /* renamed from: f */
    @SerializedName("filesSize")
    private long f40058f;

    /* renamed from: g */
    @SerializedName("logsSize")
    private long f40059g;

    /* renamed from: h */
    @SerializedName("showLog")
    private boolean[] f40060h;

    /* renamed from: i */
    @SerializedName("flag")
    private int f40061i;

    /* renamed from: j */
    @SerializedName("srCode")
    private String f40062j;

    /* renamed from: k */
    @SerializedName("problemName")
    private String f40063k;

    /* renamed from: l */
    @SerializedName("zipFileName")
    private String f40064l;

    /* renamed from: m */
    @SerializedName("associatedId")
    private long f40065m;

    /* renamed from: n */
    @SerializedName("uniqueCode")
    private String f40066n;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.entity.FeedbackInfo$a */
    public class C8606a implements Parcelable.Creator<FeedbackInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedbackInfo createFromParcel(Parcel parcel) {
            return new FeedbackInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FeedbackInfo[] newArray(int i10) {
            return new FeedbackInfo[i10];
        }
    }

    @Keep
    public FeedbackInfo() {
        this.f40060h = new boolean[]{true};
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Keep
    public long getAssociatedId() {
        return this.f40065m;
    }

    @Keep
    public String getChildId() {
        return this.f40055c;
    }

    @Keep
    public String getContact() {
        return this.f40057e;
    }

    @Keep
    public long getFilesSize() {
        return this.f40058f;
    }

    @Keep
    public int getFlag() {
        return this.f40061i;
    }

    @Keep
    public long getLogsSize() {
        return this.f40059g;
    }

    @Keep
    public String getParentId() {
        return this.f40054b;
    }

    @Keep
    public String getProblemDesc() {
        return this.f40056d;
    }

    @Keep
    public String getProblemId() {
        return this.f40053a;
    }

    @Keep
    public String getProblemName() {
        return this.f40063k;
    }

    @Keep
    public String getProblemType() {
        return !TextUtils.isEmpty(this.f40055c) ? this.f40055c : this.f40054b;
    }

    @Keep
    public boolean getShowLog() {
        return this.f40060h[0];
    }

    @Keep
    public String getSrCode() {
        return this.f40062j;
    }

    @Keep
    public String getUniqueCode() {
        return this.f40066n;
    }

    @Keep
    public String getZipFileName() {
        return this.f40064l;
    }

    @Keep
    public void setAssociatedId(long j10) {
        this.f40065m = j10;
    }

    @Keep
    public void setChildId(String str) {
        this.f40055c = str;
    }

    @Keep
    public void setContact(String str) {
        this.f40057e = str;
    }

    @Keep
    public void setFilesSize(long j10) {
        this.f40058f = j10;
    }

    @Keep
    public void setFlag(int i10) {
        this.f40061i = i10;
    }

    @Keep
    public void setLogsSize(long j10) {
        this.f40059g = j10;
    }

    @Keep
    public void setParentId(String str) {
        this.f40054b = str;
    }

    @Keep
    public void setProblemDesc(String str) {
        this.f40056d = str;
    }

    @Keep
    public void setProblemId(String str) {
        this.f40053a = str;
    }

    @Keep
    public void setProblemName(String str) {
        this.f40063k = str;
    }

    @Keep
    public void setProblemType(String str, String str2) {
        this.f40054b = str;
        this.f40055c = str2;
    }

    @Keep
    public void setShowLog(boolean z10) {
        this.f40060h[0] = z10;
    }

    @Keep
    public void setSrCode(String str) {
        this.f40062j = str;
    }

    @Keep
    public void setUniqueCode(String str) {
        this.f40066n = str;
    }

    @Keep
    public void setZipFileName(String str) {
        this.f40064l = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f40053a);
        parcel.writeString(this.f40054b);
        parcel.writeString(this.f40055c);
        parcel.writeString(this.f40056d);
        parcel.writeString(this.f40057e);
        parcel.writeLong(this.f40058f);
        parcel.writeLong(this.f40059g);
        parcel.writeBooleanArray(this.f40060h);
        parcel.writeInt(this.f40061i);
        parcel.writeString(this.f40062j);
        parcel.writeString(this.f40063k);
        parcel.writeString(this.f40064l);
        parcel.writeLong(this.f40065m);
        parcel.writeString(this.f40066n);
    }

    public FeedbackInfo(Parcel parcel) {
        this.f40060h = new boolean[]{true};
        this.f40053a = parcel.readString();
        this.f40054b = parcel.readString();
        this.f40055c = parcel.readString();
        this.f40056d = parcel.readString();
        this.f40057e = parcel.readString();
        this.f40058f = parcel.readLong();
        this.f40059g = parcel.readLong();
        this.f40060h = parcel.createBooleanArray();
        this.f40061i = parcel.readInt();
        this.f40062j = parcel.readString();
        this.f40063k = parcel.readString();
        this.f40064l = parcel.readString();
        this.f40065m = parcel.readLong();
        this.f40066n = parcel.readString();
    }

    @Keep
    public FeedbackInfo(String str, String str2, String str3, String str4) {
        this.f40060h = new boolean[]{true};
        this.f40053a = str;
        this.f40054b = str2;
        this.f40055c = str3;
        this.f40057e = str4;
    }

    @Keep
    public FeedbackInfo(String str, String str2, String str3, String str4, String str5) {
        this.f40060h = new boolean[]{true};
        this.f40062j = str;
        this.f40053a = str2;
        this.f40054b = str3;
        this.f40055c = str4;
        this.f40063k = str5;
    }
}
