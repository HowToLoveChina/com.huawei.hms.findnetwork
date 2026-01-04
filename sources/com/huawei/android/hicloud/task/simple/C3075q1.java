package com.huawei.android.hicloud.task.simple;

import android.os.Handler;
import android.os.Message;
import com.huawei.hicloud.request.basic.bean.CBSAllDevicesRsp;
import fk.C9721b;
import io.C10582a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: com.huawei.android.hicloud.task.simple.q1 */
/* loaded from: classes3.dex */
public class C3075q1 extends AbstractC12367d {

    /* renamed from: a */
    public Handler f13365a;

    /* renamed from: b */
    public int f13366b;

    public C3075q1(Handler handler, int i10) {
        this.f13365a = handler;
        this.f13366b = i10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Message messageObtain = Message.obtain(this.f13365a);
        try {
            CBSAllDevicesRsp cBSAllDevicesRspM64917R = new C10582a(null).m64917R(this.f13366b);
            messageObtain.what = 0;
            messageObtain.obj = cBSAllDevicesRspM64917R;
        } catch (C9721b e10) {
            C11839m.m70687e("QueryAllDevicesTask", "QueryAllDevicesTask failed, " + e10.getMessage());
            messageObtain.what = -1;
        }
        this.f13365a.sendMessage(messageObtain);
    }
}
