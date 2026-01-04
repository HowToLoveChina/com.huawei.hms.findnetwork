package p745wm;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.entity.tss.GetDeviceIdRequ;
import com.huawei.hms.support.api.entity.tss.GetDeviceIdResp;
import com.huawei.hms.support.api.tss.HmsTss;
import com.huawei.hms.support.api.tss.TssClient;
import p015ak.C0213f;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* renamed from: wm.b */
/* loaded from: classes6.dex */
public class C13621b extends AbstractC12367d {

    /* renamed from: a */
    public String f61275a;

    /* renamed from: wm.b$a */
    public class a implements InterfaceC8938f {
        public a() {
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            if (exc instanceof ApiException) {
                ApiException apiException = (ApiException) exc;
                AbstractC10896a.m65886e("GetVudidFromTssTask", "OnFailure, statusCode" + apiException.getStatusCode() + ", message" + apiException.getLocalizedMessage());
            }
        }
    }

    /* renamed from: wm.b$b */
    public class b implements InterfaceC8939g<GetDeviceIdResp> {
        public b() {
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(GetDeviceIdResp getDeviceIdResp) {
            if (getDeviceIdResp == null) {
                AbstractC10896a.m65886e("GetVudidFromTssTask", "getDeviceIdResp is null");
                return;
            }
            int rtnCode = getDeviceIdResp.getRtnCode();
            AbstractC10896a.m65887i("GetVudidFromTssTask", "retCode: " + rtnCode);
            if (rtnCode == 0) {
                int idType = getDeviceIdResp.getIdType();
                String idValue = getDeviceIdResp.getIdValue();
                AbstractC10896a.m65887i("GetVudidFromTssTask", "idValue: " + idType);
                if (idType != 11 || TextUtils.isEmpty(idValue)) {
                    AbstractC10896a.m65888w("GetVudidFromTssTask", "not vudid");
                } else {
                    AbstractC10896a.m65887i("GetVudidFromTssTask", "save vudid");
                    C13452e.m80781L().m80847Q1(idValue);
                }
            }
        }
    }

    public C13621b(String str) {
        this.f61275a = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("GetVudidFromTssTask", "context is null");
            return;
        }
        if (TextUtils.isEmpty(this.f61275a)) {
            AbstractC10896a.m65886e("GetVudidFromTssTask", "imei is empty");
            return;
        }
        try {
            TssClient tssClient = HmsTss.getTssClient(contextM1377a);
            GetDeviceIdRequ getDeviceIdRequ = new GetDeviceIdRequ();
            getDeviceIdRequ.setImei(this.f61275a);
            tssClient.getDeviceId(getDeviceIdRequ).addOnSuccessListener(new b()).addOnFailureListener(new a());
        } catch (Exception e10) {
            AbstractC10896a.m65886e("GetVudidFromTssTask", "getVudid exception: " + e10.toString());
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.QUERY_KEY;
    }
}
