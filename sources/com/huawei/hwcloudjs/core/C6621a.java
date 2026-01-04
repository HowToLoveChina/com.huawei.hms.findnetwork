package com.huawei.hwcloudjs.core;

import android.app.PendingIntent;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/* renamed from: com.huawei.hwcloudjs.core.a */
/* loaded from: classes8.dex */
class C6621a implements ExclusionStrategy {
    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> cls) {
        return PendingIntent.class.getName().equals(cls.getName());
    }

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return false;
    }
}
