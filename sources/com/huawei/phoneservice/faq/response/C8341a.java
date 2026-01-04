package com.huawei.phoneservice.faq.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.huawei.phoneservice.faq.response.a */
/* loaded from: classes4.dex */
public class C8341a {

    /* renamed from: a */
    @SerializedName("knowledgeEvaluationList")
    private List<a> f38819a;

    /* renamed from: com.huawei.phoneservice.faq.response.a$a */
    public static class a {

        /* renamed from: a */
        @SerializedName("evaluationOption")
        private String f38820a;

        /* renamed from: b */
        @SerializedName("sort")
        private String f38821b;

        /* renamed from: c */
        public boolean f38822c;

        /* renamed from: a */
        public String m51988a() {
            return this.f38820a;
        }

        /* renamed from: b */
        public void m51989b(boolean z10) {
            this.f38822c = z10;
        }

        /* renamed from: c */
        public boolean m51990c() {
            return this.f38822c;
        }
    }

    /* renamed from: a */
    public List<a> m51987a() {
        return this.f38819a;
    }
}
