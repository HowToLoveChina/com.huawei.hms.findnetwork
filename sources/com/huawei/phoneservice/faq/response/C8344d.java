package com.huawei.phoneservice.faq.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.huawei.phoneservice.faq.response.d */
/* loaded from: classes4.dex */
public class C8344d {

    /* renamed from: a */
    @SerializedName("list")
    private List<a> f38843a;

    /* renamed from: com.huawei.phoneservice.faq.response.d$a */
    public static class a {

        /* renamed from: a */
        @SerializedName("id")
        private String f38844a;

        /* renamed from: b */
        @SerializedName("title")
        private String f38845b;

        /* renamed from: a */
        public String m52000a() {
            return this.f38844a;
        }

        /* renamed from: b */
        public String m52001b() {
            return this.f38845b;
        }
    }

    /* renamed from: a */
    public List<a> m51999a() {
        return this.f38843a;
    }
}
