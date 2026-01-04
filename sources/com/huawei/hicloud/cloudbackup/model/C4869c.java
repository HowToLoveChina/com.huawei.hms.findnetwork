package com.huawei.hicloud.cloudbackup.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* renamed from: com.huawei.hicloud.cloudbackup.model.c */
/* loaded from: classes6.dex */
public class C4869c {

    /* renamed from: a */
    @SerializedName("appList")
    ArrayList<C4870d> f22272a;

    /* renamed from: b */
    @SerializedName("totalSize")
    String f22273b;

    /* renamed from: c */
    @SerializedName("totalCount")
    long f22274c;

    /* renamed from: d */
    @SerializedName("type")
    String f22275d;

    public C4869c(ArrayList<C4870d> arrayList, String str, long j10, String str2) {
        new ArrayList();
        this.f22272a = arrayList;
        this.f22273b = str;
        this.f22274c = j10;
        this.f22275d = str2;
    }
}
