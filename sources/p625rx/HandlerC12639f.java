package p625rx;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.InvocationTargetException;
import ohos.ohos.ohos.ohos.ohos.C11887c;
import ohos.ohos.ohos.ohos.ohos.C11889d;
import ohos.ohos.ohos.ohos.ohos.C11891f;

/* renamed from: rx.f */
/* loaded from: classes9.dex */
public class HandlerC12639f extends Handler {

    /* renamed from: a */
    public final /* synthetic */ C11889d f58096a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC12639f(C11889d c11889d, Looper looper) {
        super(looper);
        this.f58096a = c11889d;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i10 = message.what;
        if (i10 == 1) {
            C11891f c11891f = C11891f.f55039a;
            C11889d c11889d = this.f58096a;
            c11891f.m71419n(c11889d.f55014i, true, c11889d.m71399g());
        } else if (i10 == 2) {
            Object obj = message.obj;
            if (obj instanceof C11887c) {
                C11891f.f55039a.m71421p((C11887c) obj, true, this.f58096a.m71400h());
            }
        }
        super.handleMessage(message);
    }
}
