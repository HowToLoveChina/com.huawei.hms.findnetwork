package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.DataExportResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.b */
/* loaded from: classes8.dex */
public class C6406b extends AbstractC6435y<DataExportResp> {
    public C6406b(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public DataExportResp mo36804b(String str) throws JSONException {
        return new DataExportResp(str);
    }
}
