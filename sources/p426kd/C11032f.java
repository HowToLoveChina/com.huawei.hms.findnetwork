package p426kd;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bd.C1164a;
import com.google.gson.Gson;
import com.huawei.android.hicloud.complexutil.C2782c;
import com.huawei.android.hicloud.drive.clouddisk.model.DataBaseListResponse;
import com.huawei.android.hicloud.drive.clouddisk.model.DataBasesResponse;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HNCloudConfig;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.NotificationConfigManager;
import com.huawei.hicloud.notification.manager.SyncModuleConfigManager;
import fk.C9721b;
import fk.C9722c;
import gp.C10028c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p020ap.C1007b;
import p020ap.C1008c;
import p336he.C10155f;
import p514o9.C11839m;
import p581qk.AbstractC12368e;
import p709vj.C13452e;
import tc.C13007b;

/* renamed from: kd.f */
/* loaded from: classes3.dex */
public class C11032f extends AbstractC12368e {

    /* renamed from: a */
    public final Context f52121a;

    /* renamed from: b */
    public final boolean f52122b;

    /* renamed from: c */
    public final Handler f52123c;

    public C11032f(Context context, Handler handler, boolean z10) {
        this.f52123c = handler;
        this.f52122b = z10;
        this.f52121a = context;
    }

    /* renamed from: c */
    public final void m66514c() {
        if (this.f52123c != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 5;
            this.f52123c.sendMessage(messageObtain);
            C11839m.m70689w("DataBaseListTask", "send fail result");
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        if (!C13452e.m80781L().m80887a1()) {
            C11839m.m70689w("DataBaseListTask", "not new bm type, no need query");
            m66515d();
            return;
        }
        if (C13452e.m80781L().m80803F0().booleanValue() && !C10028c.m62182c0().m62221H1()) {
            C11839m.m70689w("DataBaseListTask", "terms not agreed");
            m66514c();
            return;
        }
        try {
            if (this.f52122b || C2782c.m16070h(this.f52121a)) {
                C11839m.m70688i("DataBaseListTask", "refresh database from server now");
                m66517f(this.f52121a);
            }
            if (this.f52122b) {
                C11839m.m70688i("DataBaseListTask", "refresh gradeCode from server now");
                C1007b.m5980s().m5981A();
            } else {
                C10155f.m63264Q();
            }
            C11839m.m70688i("DataBaseListTask", "baseList = " + C13007b.m78205Y(this.f52121a).m78294x() + ", fullList = " + C13007b.m78205Y(this.f52121a).m78210C());
            C2782c.m16065c(this.f52121a);
            m66515d();
        } catch (Exception e10) {
            C11839m.m70687e("DataBaseListTask", "getDataBaseList error: " + e10.getMessage());
            m66514c();
        }
    }

    /* renamed from: d */
    public final void m66515d() {
        if (this.f52123c != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            this.f52123c.sendMessage(messageObtain);
            C11839m.m70688i("DataBaseListTask", "send success result");
        }
    }

    /* renamed from: e */
    public final void m66516e() {
        C11839m.m70688i("DataBaseListTask", "retry parseSyncConfig");
        NotificationConfig configFromFile = new HNCloudConfig().getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29916w("DataBaseListTask", "extractConfig failed, fullConfig is null, retry download");
            new NotificationConfigManager().queryConfigVersion();
        }
        if (configFromFile != null) {
            NotifyLogger.m29915i("DataBaseListTask", "extractConfig");
            SyncModuleConfigManager.getInstance().parseSyncConfig(configFromFile.getSyncConfig());
        }
        if (C13452e.m80781L().m80791C0()) {
            C1008c.m6035v().m6086m(this.f52121a, "DataBaseListTask");
        }
    }

    /* renamed from: f */
    public void m66517f(Context context) throws C9722c, IOException {
        DataBaseListResponse dataBaseListResponseExecute = C1164a.m7265f().m7268d("").m59251j().get().setFields2("databases,nextCursor").execute();
        if (dataBaseListResponseExecute == null) {
            throw new C9722c(5, "response is null");
        }
        C11839m.m70686d("DataBaseListTask", "response = " + dataBaseListResponseExecute.toString());
        List<DataBasesResponse> databases = dataBaseListResponseExecute.getDatabases();
        if (databases == null) {
            throw new C9722c(5, "response InnerDatabases is null");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (DataBasesResponse dataBasesResponse : databases) {
            if (dataBasesResponse != null) {
                String strM18000j = DriveSyncUtil.m18000j(dataBasesResponse.getDatabaseId().intValue());
                if (TextUtils.isEmpty(strM18000j)) {
                    m66516e();
                    strM18000j = DriveSyncUtil.m18000j(dataBasesResponse.getDatabaseId().intValue());
                }
                if (dataBasesResponse.getMode().intValue() == 0 && !TextUtils.isEmpty(strM18000j)) {
                    arrayList.add(strM18000j);
                } else if (dataBasesResponse.getMode().intValue() == 1 && !TextUtils.isEmpty(strM18000j)) {
                    arrayList2.add(strM18000j);
                }
            }
        }
        C13007b.m78205Y(context).m78271l0(new Gson().toJson(arrayList));
        C13007b.m78205Y(context).m78285s0(new Gson().toJson(arrayList2));
        C13007b.m78205Y(context).m78293w0(System.currentTimeMillis());
        C11839m.m70688i("DataBaseListTask", "baseApps = " + arrayList.size() + ", fullApps = " + arrayList2.size());
    }
}
