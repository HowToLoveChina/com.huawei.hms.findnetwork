package com.huawei.openalliance.p169ad.p171db.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6933e;

@DataKeep
/* loaded from: classes2.dex */
public class TemplateRecord extends C7013a {
    public static final String TEMPLATE_ID = "templateId";

    @InterfaceC6933e
    private String _id;
    private String templateContent;
    private String templateId;

    /* renamed from: a */
    public String m41820a() {
        return this.templateId;
    }

    /* renamed from: b */
    public void m41822b(String str) {
        this.templateContent = str;
    }

    /* renamed from: a */
    public void m41821a(String str) {
        this.templateId = str;
    }
}
