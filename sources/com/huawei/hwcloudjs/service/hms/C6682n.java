package com.huawei.hwcloudjs.service.hms;

import android.os.Handler;
import android.os.Message;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.hms.bean.C6670a;
import org.json.JSONException;

/* renamed from: com.huawei.hwcloudjs.service.hms.n */
/* loaded from: classes8.dex */
public class C6682n implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ HmsLiteCoreApi f30999a;

    public C6682n(HmsLiteCoreApi hmsLiteCoreApi) {
        this.f30999a = hmsLiteCoreApi;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws JSONException {
        if (message.what != 4) {
            return false;
        }
        Object obj = message.obj;
        if (obj == null || !(obj instanceof C6670a)) {
            C6659d.m37881b("HmsLiteCoreApi", "msg.obj is not LoginBean type", true);
            return false;
        }
        this.f30999a.m37940a((C6670a) obj);
        return false;
    }
}
