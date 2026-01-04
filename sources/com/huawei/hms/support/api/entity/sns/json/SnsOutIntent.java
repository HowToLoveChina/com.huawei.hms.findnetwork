package com.huawei.hms.support.api.entity.sns.json;

import android.content.Intent;

/* loaded from: classes8.dex */
public class SnsOutIntent {

    /* renamed from: a */
    private String f29799a;

    /* renamed from: b */
    private Intent f29800b;

    public SnsOutIntent(String str) {
        this.f29799a = str;
    }

    public String getBody() {
        return this.f29799a;
    }

    public Intent getIntent() {
        return this.f29800b;
    }

    public void setBody(String str) {
        this.f29799a = str;
    }

    public void setIntent(Intent intent) {
        this.f29800b = intent;
    }
}
