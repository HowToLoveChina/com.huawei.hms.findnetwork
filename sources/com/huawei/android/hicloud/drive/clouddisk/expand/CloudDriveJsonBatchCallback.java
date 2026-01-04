package com.huawei.android.hicloud.drive.clouddisk.expand;

import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.io.IOException;
import p369ii.InterfaceC10510a;

/* loaded from: classes3.dex */
public abstract class CloudDriveJsonBatchCallback<T> implements InterfaceC10510a<T, ErrorResp> {
    public abstract void onFailure(ErrorResp.Error error, C4609l c4609l) throws IOException;

    @Override // p369ii.InterfaceC10510a
    public abstract /* synthetic */ void onSuccess(Object obj, C4609l c4609l) throws IOException;

    @Override // p369ii.InterfaceC10510a
    public final void onFailure(ErrorResp errorResp, C4609l c4609l) throws IOException {
        if (errorResp != null) {
            onFailure(errorResp.getError(), c4609l);
        }
    }
}
