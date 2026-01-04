package p771xd;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import java.io.Serializable;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* renamed from: xd.l */
/* loaded from: classes3.dex */
public class C13768l extends AbstractC12367d {

    /* renamed from: a */
    public Handler f61868a;

    /* renamed from: xd.l$a */
    public class a implements CheckUpdateCallBack {
        public a() {
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onMarketInstallInfo(Intent intent) {
            C11839m.m70688i("OnlineUpdateQuery", "onMarketInstallInfo ");
            UpdateSdkAPI.releaseCallBack();
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onMarketStoreError(int i10) {
            C11839m.m70687e("OnlineUpdateQuery", "onMarketStoreError: " + i10);
            C13768l.this.m82677f(14);
            UpdateSdkAPI.releaseCallBack();
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onUpdateInfo(Intent intent) {
            Serializable serializableExtra;
            if (intent != null) {
                SafeIntent safeIntent = new SafeIntent(intent);
                int intExtra = safeIntent.getIntExtra("status", -99);
                try {
                    serializableExtra = safeIntent.getSerializableExtra(UpdateKey.INFO);
                } catch (Exception e10) {
                    C11839m.m70687e("OnlineUpdateQuery", "onUpdateInfo error " + e10.getMessage());
                    serializableExtra = null;
                }
                C11839m.m70688i("OnlineUpdateQuery", "updateCheck status: " + intExtra);
                if (intExtra == 7 && serializableExtra != null && (serializableExtra instanceof ApkUpgradeInfo)) {
                    C11839m.m70688i("OnlineUpdateQuery", "has new version apk");
                    C13768l.this.m82678g(1, 0, 0, serializableExtra);
                } else if (intExtra == 3) {
                    C11839m.m70688i("OnlineUpdateQuery", "no new version");
                    C13768l.this.m82677f(2);
                } else {
                    C11839m.m70687e("OnlineUpdateQuery", "update server error");
                    C13768l.this.m82677f(14);
                }
                UpdateSdkAPI.releaseCallBack();
            }
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onUpdateStoreError(int i10) {
            C11839m.m70687e("OnlineUpdateQuery", "onUpdateStoreError: " + i10);
            C13768l.this.m82677f(14);
            UpdateSdkAPI.releaseCallBack();
        }
    }

    public C13768l(Handler handler) {
        this.f61868a = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m82677f(int i10) {
        Handler handler = this.f61868a;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(i10));
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        a aVar = new a();
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("OnlineUpdateQuery", "context is null");
            return;
        }
        C11839m.m70686d("OnlineUpdateQuery", "getServiceCountryCode: " + C13452e.m80781L().m80921h0());
        UpdateSdkAPI.setServiceZone(C13452e.m80781L().m80921h0());
        UpdateSdkAPI.checkTargetAppUpdate(contextM1377a, mo82651e(), aVar);
    }

    /* renamed from: e */
    public String mo82651e() {
        return "com.huawei.hidisk";
    }

    /* renamed from: g */
    public final void m82678g(int i10, int i11, int i12, Object obj) {
        Handler handler = this.f61868a;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(i10, i11, i12, obj));
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.ONLINE_UPDATE_QUERY;
    }
}
