package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.d0 */
/* loaded from: classes5.dex */
public class C8618d0 implements Serializable {
    private static final long serialVersionUID = -8045680007893341280L;

    /* renamed from: a */
    @SerializedName("fileMd5")
    private String f40114a = "";

    /* renamed from: b */
    @SerializedName("fileSha256")
    private String f40115b;

    /* renamed from: c */
    @SerializedName("fileSize")
    private long f40116c;

    /* renamed from: b */
    public void m53224b(long j10) {
        this.f40116c = j10;
    }

    /* renamed from: c */
    public void m53225c(String str) {
        this.f40115b = str;
    }
}
