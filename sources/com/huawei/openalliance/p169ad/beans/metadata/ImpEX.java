package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class ImpEX implements Serializable {
    private static final long serialVersionUID = 30445301;
    private String key;
    private String value;

    public ImpEX() {
    }

    public ImpEX(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    /* renamed from: a */
    public String m40188a() {
        return this.key;
    }

    /* renamed from: b */
    public String m40190b() {
        return this.value;
    }

    /* renamed from: a */
    public void m40189a(String str) {
        this.key = str;
    }

    /* renamed from: b */
    public void m40191b(String str) {
        this.value = str;
    }
}
