package com.huawei.openalliance.p169ad.beans.metadata.p170v3;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class TemplateV3 implements Serializable {
    private static final long serialVersionUID = -8566137528932430260L;
    private String style;
    private String styleExt;
    private TemplateData templateData;
    private String templateId;
    private String templateUrl;

    /* renamed from: a */
    public String m40557a() {
        return this.templateId;
    }

    /* renamed from: b */
    public TemplateData m40560b() {
        return this.templateData;
    }

    /* renamed from: c */
    public String m40562c() {
        return this.templateUrl;
    }

    /* renamed from: d */
    public String m40564d() {
        return this.style;
    }

    /* renamed from: e */
    public String m40566e() {
        return this.styleExt;
    }

    /* renamed from: a */
    public void m40558a(TemplateData templateData) {
        this.templateData = templateData;
    }

    /* renamed from: b */
    public void m40561b(String str) {
        this.templateUrl = str;
    }

    /* renamed from: c */
    public void m40563c(String str) {
        this.style = str;
    }

    /* renamed from: d */
    public void m40565d(String str) {
        this.styleExt = str;
    }

    /* renamed from: a */
    public void m40559a(String str) {
        this.templateId = str;
    }
}
