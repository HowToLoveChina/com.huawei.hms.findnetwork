package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class ContentExt implements Serializable {
    private static final long serialVersionUID = 5565833272963480072L;
    private String key;
    private String value;

    /* renamed from: a */
    public String m40009a() {
        return this.key;
    }

    /* renamed from: b */
    public String m40011b() {
        return this.value;
    }

    /* renamed from: a */
    public void m40010a(String str) {
        this.key = str;
    }

    /* renamed from: b */
    public void m40012b(String str) {
        this.value = str;
    }
}
