package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.y */
/* loaded from: classes8.dex */
public abstract class AbstractC6435y<T> extends AbstractC6404a<T> {
    public AbstractC6435y(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public T mo36802a(String str) throws JSONException {
        return mo36804b(str);
    }

    /* renamed from: b */
    public abstract T mo36804b(String str) throws JSONException;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 3;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 64000000;
    }
}
