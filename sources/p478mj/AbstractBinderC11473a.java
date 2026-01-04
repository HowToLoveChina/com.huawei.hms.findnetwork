package p478mj;

import android.os.RemoteException;
import com.huawei.common.service.IDecisionCallback;
import java.util.Map;

/* renamed from: mj.a */
/* loaded from: classes5.dex */
public abstract class AbstractBinderC11473a extends IDecisionCallback.Stub {

    /* renamed from: a */
    public AbstractBinderC11473a f53369a;

    /* renamed from: g */
    public AbstractBinderC11473a m68605g() {
        return m68607i(null);
    }

    /* renamed from: h */
    public void m68606h() {
    }

    /* renamed from: i */
    public AbstractBinderC11473a m68607i(AbstractBinderC11473a abstractBinderC11473a) {
        this.f53369a = abstractBinderC11473a;
        return this;
    }

    @Override // com.huawei.common.service.IDecisionCallback
    public abstract void onResult(Map map) throws RemoteException;
}
