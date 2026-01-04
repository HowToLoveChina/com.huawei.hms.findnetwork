package com.huawei.phoneservice.faq.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.huawei.phoneservice.faq.response.b */
/* loaded from: classes4.dex */
public class C8342b {

    /* renamed from: a */
    @SerializedName("returnCode")
    private String f38823a;

    /* renamed from: b */
    @SerializedName("returnMessage")
    private String f38824b;

    /* renamed from: c */
    @SerializedName("rList")
    private List<a> f38825c;

    /* renamed from: d */
    @SerializedName("curPage")
    private String f38826d;

    /* renamed from: e */
    @SerializedName("pageSize")
    private String f38827e;

    /* renamed from: f */
    @SerializedName("totalPage")
    private String f38828f;

    /* renamed from: g */
    @SerializedName("totalCount")
    private String f38829g;

    /* renamed from: com.huawei.phoneservice.faq.response.b$a */
    public static class a {

        /* renamed from: a */
        @SerializedName("knowledgeId")
        private String f38830a;

        /* renamed from: b */
        @SerializedName("knowledgeTitle")
        private String f38831b;

        /* renamed from: c */
        @SerializedName("url")
        private String f38832c;

        /* renamed from: d */
        @SerializedName("lastUpdateDate")
        private String f38833d;

        /* renamed from: e */
        @SerializedName("isTop")
        private String f38834e;

        /* renamed from: f */
        @SerializedName("score")
        private String f38835f;

        /* renamed from: g */
        @SerializedName("scorenumy")
        private String f38836g;

        /* renamed from: h */
        @SerializedName("scorenumn")
        private String f38837h;

        /* renamed from: i */
        @SerializedName("viewnum")
        private String f38838i;

        /* renamed from: j */
        @SerializedName("description")
        private String f38839j;

        /* renamed from: k */
        @SerializedName("returnCode")
        private String f38840k;

        /* renamed from: l */
        @SerializedName("returnMessage")
        private String f38841l;

        /* renamed from: a */
        public String m51993a() {
            return this.f38834e;
        }

        /* renamed from: b */
        public String m51994b() {
            return this.f38830a;
        }

        /* renamed from: c */
        public String m51995c() {
            return this.f38831b;
        }

        /* renamed from: d */
        public String m51996d() {
            return this.f38839j;
        }

        /* renamed from: e */
        public String m51997e() {
            return this.f38832c;
        }
    }

    /* renamed from: a */
    public String m51991a() {
        return this.f38829g;
    }

    /* renamed from: b */
    public List<a> m51992b() {
        return this.f38825c;
    }
}
