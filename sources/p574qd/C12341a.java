package p574qd;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import com.huawei.hicloud.base.bean.ExiterSyncData;
import java.util.List;
import p020ap.C1008c;
import p514o9.C11839m;
import p572qb.C12316j0;
import p581qk.AbstractC12367d;
import p609rc.C12487a;
import p675uc.C13153a;
import p684un.C13226e;

/* renamed from: qd.a */
/* loaded from: classes3.dex */
public final class C12341a extends AbstractC12367d {

    /* renamed from: a */
    public Context f57125a;

    /* renamed from: b */
    public Handler f57126b;

    /* renamed from: c */
    public List<ExiterSyncData> f57127c;

    /* renamed from: d */
    public String f57128d;

    public C12341a(Context context, Handler handler, List<ExiterSyncData> list, String str) {
        this.f57125a = context;
        this.f57126b = handler;
        this.f57127c = list;
        this.f57128d = str;
    }

    private void deleteSyncData(String str) throws Throwable {
        if (this.f57127c.isEmpty()) {
            SyncObserverServiceInvoker.getInstance().retainSyncData(this.f57125a, str);
            return;
        }
        SyncObserverServiceInvoker.getInstance().closeAllSyncSwitch();
        SyncObserverServiceInvoker.getInstance().resetSyncSetting();
        C2786g.m16213b();
        C12316j0.m74076d().m74078b();
        m74277c(this.f57127c);
        for (ExiterSyncData exiterSyncData : this.f57127c) {
            String syncType = exiterSyncData.getSyncType();
            int i10 = !exiterSyncData.isRetainState() ? 1 : 2;
            C11839m.m70688i("DeleteSyncDataTask", "deleteSyncData: syncType = " + syncType + ", retainState = " + i10);
            C13153a.m79132r(this.f57125a, syncType, i10, str);
            C1008c.m6035v().m6056U(this.f57125a, syncType);
        }
        CloudSyncUtil.m16030n();
        this.f57127c = null;
    }

    /* renamed from: c */
    public final void m74277c(List<ExiterSyncData> list) {
        if (list == null || list.size() == 0) {
            C11839m.m70687e("DeleteSyncDataTask", "exiterSyncDataLists is null");
            return;
        }
        for (ExiterSyncData exiterSyncData : list) {
            if (!TextUtils.isEmpty(exiterSyncData.getSyncType())) {
                C13226e.m79491f1().m79551D0(exiterSyncData.getSyncType(), exiterSyncData.isRetainState() ? "retain" : "delete");
            }
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        try {
            C12487a.m74966b(this.f57125a);
            deleteSyncData(this.f57128d);
            SystemClock.sleep(1000L);
        } catch (Exception e10) {
            C11839m.m70687e("DeleteSyncDataTask", "DeleteSyncDataTask error: " + e10.toString());
        }
        C11839m.m70688i("DeleteSyncDataTask", "deleteSyncData: end");
        if (this.f57126b != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            this.f57126b.sendMessage(messageObtain);
        }
    }
}
