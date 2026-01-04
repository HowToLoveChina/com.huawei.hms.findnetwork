package com.huawei.android.hicloud.task.simple;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import je.C10809w;
import p054cj.C1442a;
import p581qk.AbstractC12367d;

/* renamed from: com.huawei.android.hicloud.task.simple.a0 */
/* loaded from: classes3.dex */
public class C3010a0 extends AbstractC12367d {

    /* renamed from: a */
    public Handler f13131a;

    public C3010a0(Handler handler) {
        this.f13131a = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        C1442a.m8290i("GetLocalPhotoTask", "GetLocalPhotoTask start");
        if (this.f13131a == null) {
            C1442a.m8289e("GetLocalPhotoTask", "mHandlerCallback is null.");
            return;
        }
        Bitmap bitmapM65801e = C10809w.m65801e();
        Message messageObtainMessage = this.f13131a.obtainMessage();
        messageObtainMessage.what = 7011;
        messageObtainMessage.obj = bitmapM65801e;
        this.f13131a.sendMessage(messageObtainMessage);
    }
}
