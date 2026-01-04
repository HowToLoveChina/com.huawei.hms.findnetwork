package p341hj;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.CreateOrder;
import com.huawei.cloud.pay.model.VoucherInfo;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;

/* renamed from: hj.j */
/* loaded from: classes5.dex */
public class C10237j extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49612b;

    /* renamed from: c */
    public String f49613c;

    /* renamed from: d */
    public C11060c f49614d;

    /* renamed from: e */
    public int f49615e;

    /* renamed from: f */
    public String f49616f;

    /* renamed from: g */
    public int f49617g;

    /* renamed from: h */
    public List<VoucherInfo> f49618h;

    /* renamed from: i */
    public Map<String, String> f49619i;

    /* renamed from: j */
    public ChannelInfo f49620j;

    public C10237j(Handler handler, String str, C11060c c11060c, int i10, String str2, ChannelInfo channelInfo, Map<String, String> map) {
        this.f49612b = handler;
        this.f49613c = str;
        this.f49614d = c11060c;
        this.f49615e = i10;
        this.f49616f = str2;
        this.f49617g = 1;
        this.f49618h = new ArrayList();
        this.f49620j = channelInfo;
        this.f49619i = map;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            CreateOrder createOrderM61674i = C9948a.m61631C().m61674i(this.f49613c, this.f49614d, this.f49615e, this.f49616f, this.f49617g, this.f49618h, this.f49620j, this.f49619i);
            this.f49614d.m66665u(String.valueOf(0));
            this.f49614d.m66635A("success");
            m63380f(this.f49612b, 2005, createOrderM61674i);
        } catch (C9721b e10) {
            int iM60659c = e10.m60659c();
            C1442a.m8291w("CreateOrderTask", "create order err. " + iM60659c + " " + e10.getMessage());
            C11060c c11060c = this.f49614d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(iM60659c);
            c11060c.m66665u(sb2.toString());
            this.f49614d.m66635A(e10.getMessage());
            if (iM60659c != 106 || TextUtils.isEmpty(this.f49616f)) {
                m63379e(this.f49612b, 2105, e10);
            } else {
                m63398h(this.f49612b, 2130, e10, this.f49616f);
            }
        }
    }

    /* renamed from: h */
    public void m63398h(Handler handler, int i10, C9721b c9721b, String str) {
        if (handler == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = c9721b.m60659c();
        Bundle bundle = new Bundle();
        bundle.putString("receiver_user_account", str);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.obj = c9721b.getMessage();
        handler.sendMessage(messageObtainMessage);
    }

    public C10237j(Handler handler, String str, C11060c c11060c, int i10, String str2, int i11, List<VoucherInfo> list, ChannelInfo channelInfo, Map<String, String> map) {
        this.f49612b = handler;
        this.f49613c = str;
        this.f49614d = c11060c;
        this.f49615e = i10;
        this.f49616f = str2;
        this.f49617g = i11;
        this.f49618h = list;
        this.f49620j = channelInfo;
        this.f49619i = map;
    }
}
