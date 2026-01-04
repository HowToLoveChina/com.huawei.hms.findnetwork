package p806yc;

import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.notification.CloudSyncNotificationManager;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.sync.syncutil.C2984m;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.manager.DataUpperLimitNoticeManager;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import java.util.ArrayList;
import je.C10800n;
import p015ak.C0209d;
import p514o9.C11839m;
import p572qb.C12329u;
import p736wc.C13587g;
import p770xc.AbstractC13752o;

@CBServiceTask(request = 55000027, response = 66000027)
/* renamed from: yc.h */
/* loaded from: classes3.dex */
public class C13944h extends AbstractC13752o {

    /* renamed from: y */
    public boolean f62530y = false;

    /* renamed from: z */
    public ArrayList<SyncData> f62531z = null;

    /* renamed from: A */
    public ArrayList<SyncData> f62524A = null;

    /* renamed from: B */
    public ArrayList<SyncData> f62525B = null;

    /* renamed from: C */
    public ArrayList<String> f62526C = null;

    /* renamed from: D */
    public ArrayList<UnstructData> f62527D = null;

    /* renamed from: E */
    public int f62528E = 0;

    /* renamed from: F */
    public C12329u f62529F = null;

    /* renamed from: D */
    private void m83725D(String str) throws Throwable {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SyncConfigService serviceById = new SyncConfigOperator().getServiceById(str);
        if (serviceById != null) {
            String str2 = "notify_time_" + str;
            if (jCurrentTimeMillis - CloudSyncNotificationManager.getSyncNotifyTime(this.f53282a, str2) > 86400000) {
                String name = serviceById.getName();
                if (TextUtils.isEmpty(name)) {
                    return;
                }
                String stringFromSyncConfig = NotifyUtil.getStringFromSyncConfig(name);
                if (TextUtils.isEmpty(stringFromSyncConfig)) {
                    return;
                }
                C11839m.m70688i("GenUploadDataTask", "exceed notify, syncType: " + str);
                CloudSyncNotificationManager cloudSyncNotificationManager = new CloudSyncNotificationManager(this.f53282a);
                String extraNoticeLanguage = DataUpperLimitNoticeManager.getInstance().getExtraNoticeLanguage("generalTitle");
                String extraNoticeLanguage2 = DataUpperLimitNoticeManager.getInstance().getExtraNoticeLanguage("generalMainText");
                if (TextUtils.isEmpty(extraNoticeLanguage) || TextUtils.isEmpty(extraNoticeLanguage2)) {
                    string = this.f53282a.getResources().getString(R$string.universal_sync_exceed_limit, stringFromSyncConfig);
                    extraNoticeLanguage = null;
                } else {
                    string = extraNoticeLanguage2.replace("%1$s", stringFromSyncConfig);
                }
                cloudSyncNotificationManager.setSyncActivityNotify(extraNoticeLanguage, string, str, C0209d.m1300r0(this.f53282a, serviceById.getApplications()));
                CloudSyncNotificationManager.writeSyncNotifyTime(this.f53282a, str2, jCurrentTimeMillis);
            }
        }
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) throws Throwable {
        if (this.f53282a == null) {
            C11839m.m70687e("GenUploadDataTask", "afterWorkDone mContext is null");
            return;
        }
        C11839m.m70688i("GenUploadDataTask", "End afterWorkDone syncResult = " + this.f62528E);
        int i10 = this.f62528E;
        if (i10 == 14 || C2984m.m17915i(i10)) {
            C11839m.m70688i("GenUploadDataTask", "exceed limit ,syncType = " + this.f61834s);
            m83725D(this.f61834s);
        }
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("GenUploadDataTask", "Begin doWork");
        C13587g c13587g = new C13587g(this.f53282a, this.f61834s, this.f61835t, this.f62531z, this.f62524A, this.f62525B, this.f62527D, this.f62526C, this.f62530y, this.f61832q, this.f61833r, this.f61836u, this.f62529F, this.f61838w);
        c13587g.setConfig(this.f61834s, this.f53297m, this.f61839x);
        this.f62528E = c13587g.m81728B1();
        return Boolean.FALSE;
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("GenUploadDataTask", "Begin beforeWorkStart");
        super.mo66489c();
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f62531z = (ArrayList) c10800nM68549a.m65739d("addList");
        this.f62524A = (ArrayList) c10800nM68549a.m65739d("modifyList");
        this.f62525B = (ArrayList) c10800nM68549a.m65739d("lostRefundList");
        this.f62526C = (ArrayList) c10800nM68549a.m65739d("deleteList");
        this.f62530y = ((Boolean) c10800nM68549a.m65739d("havefile")).booleanValue();
        this.f62527D = (ArrayList) c10800nM68549a.m65739d("local_file_list");
        this.f62529F = c10800nM68549a.m65739d("sync_moudle_lost_refund_impl") != null ? (C12329u) c10800nM68549a.m65739d("sync_moudle_lost_refund_impl") : null;
    }
}
