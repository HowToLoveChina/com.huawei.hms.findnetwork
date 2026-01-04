package com.huawei.android.hicloud.task.simple;

import android.os.Handler;
import android.os.Message;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordDeviceInfo;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordsRsp;
import fk.C9721b;
import io.C10582a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: com.huawei.android.hicloud.task.simple.g2 */
/* loaded from: classes3.dex */
public class C3036g2 extends AbstractC12367d {

    /* renamed from: a */
    public Handler f13276a;

    /* renamed from: b */
    public String f13277b;

    /* renamed from: c */
    public int f13278c;

    /* renamed from: d */
    public CBSSyncRecordDeviceInfo f13279d;

    public C3036g2(Handler handler, int i10, String str) {
        this.f13276a = handler;
        this.f13278c = i10;
        this.f13277b = str;
        this.f13279d = null;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Message messageObtain = Message.obtain(this.f13276a);
        try {
            C10582a c10582a = new C10582a(null);
            CBSSyncRecordDeviceInfo cBSSyncRecordDeviceInfo = this.f13279d;
            CBSSyncRecordsRsp cBSSyncRecordsRspM64921V = cBSSyncRecordDeviceInfo == null ? c10582a.m64921V(this.f13278c, this.f13277b) : c10582a.m64922W(this.f13278c, this.f13277b, cBSSyncRecordDeviceInfo);
            messageObtain.what = 0;
            messageObtain.obj = cBSSyncRecordsRspM64921V;
        } catch (C9721b e10) {
            C11839m.m70687e("QuerySyncRecordsTask", "QuerySyncRecordsTask failed, " + e10.getMessage());
            messageObtain.what = -1;
        }
        this.f13276a.sendMessage(messageObtain);
    }

    public C3036g2(Handler handler, int i10, String str, CBSSyncRecordDeviceInfo cBSSyncRecordDeviceInfo) {
        this.f13276a = handler;
        this.f13278c = i10;
        this.f13279d = cBSSyncRecordDeviceInfo;
        this.f13277b = str;
    }
}
