package p804ya;

import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.io.IOException;
import p369ii.InterfaceC10510a;

/* renamed from: ya.c */
/* loaded from: classes3.dex */
public abstract class AbstractC13926c<T> implements InterfaceC10510a<T, ErrorResp> {
    /* renamed from: a */
    public abstract void mo74862a(ErrorResp.Error error, C4609l c4609l) throws IOException;

    @Override // p369ii.InterfaceC10510a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void onFailure(ErrorResp errorResp, C4609l c4609l) throws IOException {
        if (errorResp != null) {
            mo74862a(errorResp.getError(), c4609l);
        }
    }
}
