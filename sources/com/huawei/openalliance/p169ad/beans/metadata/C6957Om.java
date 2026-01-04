package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import java.io.Serializable;

@DataKeep
/* renamed from: com.huawei.openalliance.ad.beans.metadata.Om */
/* loaded from: classes8.dex */
public class C6957Om implements Serializable {
    private static final long serialVersionUID = 6514947323166042687L;

    @InterfaceC6929a
    private String resourceUrl;
    private String vendorKey;

    @InterfaceC6929a
    private String verificationParameters;

    /* renamed from: a */
    public String m40366a() {
        return this.vendorKey;
    }

    /* renamed from: b */
    public String m40368b() {
        return this.resourceUrl;
    }

    /* renamed from: c */
    public String m40370c() {
        return this.verificationParameters;
    }

    public String toString() {
        return "Om{vendorKey='" + this.vendorKey + "', resourceUrl='" + this.resourceUrl + "', verificationParameters='" + this.verificationParameters + "'}";
    }

    /* renamed from: a */
    public void m40367a(String str) {
        this.vendorKey = str;
    }

    /* renamed from: b */
    public void m40369b(String str) {
        this.resourceUrl = str;
    }

    /* renamed from: c */
    public void m40371c(String str) {
        this.verificationParameters = str;
    }
}
