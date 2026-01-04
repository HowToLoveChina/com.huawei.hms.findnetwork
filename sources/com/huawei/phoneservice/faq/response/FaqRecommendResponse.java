package com.huawei.phoneservice.faq.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes4.dex */
public class FaqRecommendResponse {

    /* renamed from: a */
    @SerializedName("rList")
    private List<RecommendResponse> f38809a;

    public static class RecommendResponse implements Parcelable {
        public static final Parcelable.Creator<RecommendResponse> CREATOR = new C8340a();

        /* renamed from: a */
        @SerializedName("knowledgeId")
        private String f38810a;

        /* renamed from: b */
        @SerializedName("knowledgeTitle")
        private String f38811b;

        /* renamed from: c */
        @SerializedName("lastUpdateDate")
        private String f38812c;

        /* renamed from: d */
        @SerializedName("url")
        private String f38813d;

        /* renamed from: e */
        @SerializedName("score")
        private String f38814e;

        /* renamed from: f */
        @SerializedName("scorenumy")
        private String f38815f;

        /* renamed from: g */
        @SerializedName("scorenumn")
        private String f38816g;

        /* renamed from: h */
        @SerializedName("viewnum")
        private String f38817h;

        /* renamed from: i */
        @SerializedName("description")
        private String f38818i;

        /* renamed from: com.huawei.phoneservice.faq.response.FaqRecommendResponse$RecommendResponse$a */
        public class C8340a implements Parcelable.Creator<RecommendResponse> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public RecommendResponse createFromParcel(Parcel parcel) {
                return new RecommendResponse(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public RecommendResponse[] newArray(int i10) {
                return new RecommendResponse[i10];
            }
        }

        public RecommendResponse(Parcel parcel) {
            this.f38810a = parcel.readString();
            this.f38811b = parcel.readString();
            this.f38812c = parcel.readString();
            this.f38813d = parcel.readString();
            this.f38814e = parcel.readString();
            this.f38815f = parcel.readString();
            this.f38816g = parcel.readString();
            this.f38817h = parcel.readString();
            this.f38818i = parcel.readString();
        }

        /* renamed from: a */
        public String m51984a() {
            return this.f38813d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f38810a);
            parcel.writeString(this.f38811b);
            parcel.writeString(this.f38812c);
            parcel.writeString(this.f38813d);
            parcel.writeString(this.f38814e);
            parcel.writeString(this.f38815f);
            parcel.writeString(this.f38816g);
            parcel.writeString(this.f38817h);
            parcel.writeString(this.f38818i);
        }
    }

    /* renamed from: a */
    public List<RecommendResponse> m51983a() {
        return this.f38809a;
    }
}
