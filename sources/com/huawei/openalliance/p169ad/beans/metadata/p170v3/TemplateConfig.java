package com.huawei.openalliance.p169ad.beans.metadata.p170v3;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class TemplateConfig {
    private String style;
    private int styleVer;
    private String tag;
    private String templateId;

    public TemplateConfig() {
    }

    public TemplateConfig(String str, int i10) {
        this.templateId = str;
        this.styleVer = i10;
    }

    /* renamed from: a */
    public String m40545a() {
        return this.templateId;
    }

    /* renamed from: b */
    public int m40546b() {
        return this.styleVer;
    }

    /* renamed from: c */
    public String m40547c() {
        return this.style;
    }

    /* renamed from: d */
    public String m40548d() {
        return this.tag;
    }
}
