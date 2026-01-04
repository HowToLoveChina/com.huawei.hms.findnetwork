package com.huawei.android.hicloud.task.simple;

import android.os.Handler;
import android.os.Message;
import fk.C9721b;
import io.C10582a;
import p458lo.C11322a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: com.huawei.android.hicloud.task.simple.b2 */
/* loaded from: classes3.dex */
public final class C3016b2 extends AbstractC12367d {

    /* renamed from: a */
    public Handler f13149a;

    /* renamed from: b */
    public boolean f13150b;

    public C3016b2(Handler handler, boolean z10) {
        this.f13149a = handler;
        this.f13150b = z10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Message messageObtain = Message.obtain(this.f13149a);
        try {
            C11839m.m70688i("QueryDeviceOperationsTask", "isFromBasic " + this.f13150b);
            if (this.f13150b) {
                messageObtain.obj = new C10582a(null).m64918S();
            } else {
                messageObtain.obj = new C11322a().m68003J();
            }
            messageObtain.what = 0;
        } catch (C9721b e10) {
            C11839m.m70687e("QueryDeviceOperationsTask", "QueryDeviceOperationsTask failed, " + e10.getMessage());
            messageObtain.what = -1;
            messageObtain.arg1 = e10.m60659c();
        }
        this.f13149a.sendMessage(messageObtain);
    }
}
