package com.huawei.hicloud.cloudbackup.p104v3.server.batch;

import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.io.IOException;
import p369ii.InterfaceC10510a;

/* loaded from: classes6.dex */
public abstract class CloudBackupV3BatchCallback<T> implements InterfaceC10510a<T, ErrorResp> {
    public abstract void onFailure(ErrorResp.Error error, C4609l c4609l) throws IOException;

    @Override // p369ii.InterfaceC10510a
    public abstract /* synthetic */ void onSuccess(Object obj, C4609l c4609l) throws IOException;

    @Override // p369ii.InterfaceC10510a
    public final void onFailure(ErrorResp errorResp, C4609l c4609l) throws IOException {
        if (errorResp == null) {
            errorResp = new ErrorResp();
            errorResp.setError(new ErrorResp.Error());
        }
        onFailure(errorResp.getError(), c4609l);
    }
}
