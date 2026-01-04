package com.huawei.phoneservice.faq.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.huawei.phoneservice.faq.response.e */
/* loaded from: classes4.dex */
public class C8345e {

    /* renamed from: a */
    @SerializedName("detailList")
    private List<FaqKnowSearchDetail> f38846a;

    /* renamed from: b */
    @SerializedName("curPage")
    private int f38847b;

    /* renamed from: c */
    @SerializedName("totalPage")
    private int f38848c;

    /* renamed from: a */
    public List<FaqKnowSearchDetail> m52002a() {
        return this.f38846a;
    }

    /* renamed from: b */
    public void m52003b(int i10) {
        this.f38847b = i10;
    }

    /* renamed from: c */
    public void m52004c(List<FaqKnowSearchDetail> list) {
        this.f38846a = list;
    }

    /* renamed from: d */
    public int m52005d() {
        return this.f38848c;
    }

    /* renamed from: e */
    public void m52006e(int i10) {
        this.f38848c = i10;
    }
}
