package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.DataImportResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.c */
/* loaded from: classes8.dex */
public class C6408c extends AbstractC6435y<DataImportResp> {
    public C6408c(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public DataImportResp mo36804b(String str) throws JSONException {
        return new DataImportResp(str);
    }
}
