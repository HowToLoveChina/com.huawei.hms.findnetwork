package com.huawei.openalliance.p169ad.beans.metadata;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class Template {
    private String templateContent;
    private String templateId;

    /* renamed from: a */
    public boolean m40456a() {
        return (TextUtils.isEmpty(this.templateId) || TextUtils.isEmpty(this.templateContent)) ? false : true;
    }

    /* renamed from: b */
    public String m40457b() {
        return this.templateId;
    }

    /* renamed from: c */
    public String m40458c() {
        return this.templateContent;
    }
}
