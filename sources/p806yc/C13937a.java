package p806yc;

import com.huawei.android.backup.service.logic.calendar.CalendarConfigTable;
import com.huawei.android.hicloud.complexutil.C2785f;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.bean.CloudSyncRetryInfo;
import com.huawei.android.hicloud.sync.syncutil.C2973b;
import com.huawei.android.hicloud.sync.syncutil.C2974c;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import je.C10800n;
import je.C10812z;
import p015ak.C0237v;
import p514o9.C11839m;
import p736wc.C13581a;
import p770xc.AbstractC13752o;
import sc.C12772e;

@CBServiceTask(request = 55000030, response = 66000030)
/* renamed from: yc.a */
/* loaded from: classes3.dex */
public class C13937a extends AbstractC13752o {

    /* renamed from: y */
    public List<String> f62500y = null;

    /* renamed from: z */
    public List<String> f62501z = null;

    /* renamed from: A */
    public List<String> f62496A = null;

    /* renamed from: B */
    public boolean f62497B = false;

    /* renamed from: C */
    public boolean f62498C = false;

    /* renamed from: D */
    public boolean f62499D = false;

    /* renamed from: C */
    private boolean m83700C() {
        List<String> list = this.f62501z;
        if (list == null || list.isEmpty()) {
            return false;
        }
        C11839m.m70688i("GenEndSyncTask", this.f61834s + " checkSyncResult dataTypeResult = " + this.f62501z.toString());
        Iterator<String> it = this.f62501z.iterator();
        while (it.hasNext()) {
            if (!"0".equals(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: E */
    private void m83701E() {
        LinkedHashMap<String, String> linkedHashMap;
        String str = this.f61834s;
        if (str == null) {
            C11839m.m70687e("GenEndSyncTask", "notifyUISyncEnd syncType is null");
            return;
        }
        CloudSyncUtil.m16011g1(str);
        C2786g.m16220i(this.f61834s, this.f61831p, this.f61838w);
        int i10 = this.f61831p.getInt(this.f61834s + "sync_retcode", -1);
        boolean z10 = this.f61831p.getBoolean(this.f61834s + "reportFileNotAllSucess", false);
        boolean z11 = this.f61831p.getBoolean(this.f61834s + "notAllSucess", false);
        boolean z12 = this.f61831p.getBoolean(this.f61834s + "cloudSpaceNotEnough", false);
        C11839m.m70688i("GenEndSyncTask", "syncType = " + this.f61834s + ", sync status is = " + i10 + ", isReportNotAllSuccess = " + z10 + ", isUploadNotAllSuccess = " + z11 + ", isCloudSpaceNotEnough = " + z12);
        if (this.f62497B) {
            i10 = 21;
        }
        if (this.f62498C) {
            i10 = 24;
        }
        boolean zM83700C = m83700C();
        if (i10 == 4) {
            i10 = (!zM83700C || z11) ? 5 : 0;
        }
        LinkedHashMap<String, String> linkedHashMapM65833b = C10812z.m65833b(this.f61836u);
        if (z12) {
            this.f61831p.edit().putInt(this.f61834s + "sync_retcode", 20).commit();
            C10812z.m65846o(this.f53282a, this.f61834s, SNSCode.Status.HWID_UNLOGIN, "Cloud space not enough", this.f61832q, "fail", this.f61833r, linkedHashMapM65833b, true);
            C11839m.m70688i("GenEndSyncTask", this.f61834s + " sync result: sync failed, cloud space not enough.");
            C0237v.m1661c();
        } else {
            if (z11 || !zM83700C) {
                this.f61831p.edit().putInt(this.f61834s + "sync_retcode", i10).commit();
                linkedHashMap = linkedHashMapM65833b;
                C10812z.m65846o(this.f53282a, this.f61834s, i10, "dataTypeResult: " + this.f62501z.toString(), this.f61832q, "fail", this.f61833r, linkedHashMap, true);
                C11839m.m70688i("GenEndSyncTask", this.f61834s + " sync result: sync failed, syncStatus = " + i10);
                C2980i.m17868c(this.f53282a, this.f61834s, this.f61839x, C10812z.m65833b(this.f61836u).get("packageName"));
                CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END", this.f61834s);
                if (i10 == 0 && !z11) {
                    C11839m.m70688i("GenEndSyncTask", "delete all FileInfo for " + this.f61834s);
                    new C12772e().m76660n(this.f61834s);
                }
                m82615A(this.f61834s, z12, i10, linkedHashMap);
                C2785f.m16211g();
            }
            if (i10 == 2225) {
                C11839m.m70688i("GenEndSyncTask", this.f61834s + " syncV2 sync result: unLock error.");
            } else {
                this.f61831p.edit().putLong(this.f61834s + "sync_syncTime", System.currentTimeMillis()).commit();
                this.f61831p.edit().putInt(this.f61834s + "sync_retcode", 0).commit();
                C10812z.m65846o(this.f53282a, this.f61834s, 0, "", this.f61832q, "success", this.f61833r, linkedHashMapM65833b, true);
                C11839m.m70688i("GenEndSyncTask", this.f61834s + " sync result: sync success.");
            }
            C2974c.m17828d(this.f53282a, this.f61834s, "");
        }
        linkedHashMap = linkedHashMapM65833b;
        C2980i.m17868c(this.f53282a, this.f61834s, this.f61839x, C10812z.m65833b(this.f61836u).get("packageName"));
        CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END", this.f61834s);
        if (i10 == 0) {
            C11839m.m70688i("GenEndSyncTask", "delete all FileInfo for " + this.f61834s);
            new C12772e().m76660n(this.f61834s);
        }
        m82615A(this.f61834s, z12, i10, linkedHashMap);
        C2785f.m16211g();
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
        m83701E();
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("GenEndSyncTask", "Begin doWork");
        C13581a c13581a = new C13581a(this.f53282a, this.f61834s, this.f62500y, this.f62501z, this.f62496A, this.f61832q, this.f61833r, this.f61836u, this.f61838w);
        c13581a.m81587d(this.f62499D);
        c13581a.setConfig(this.f61834s, this.f53297m, this.f61839x);
        c13581a.m81586b();
        return Boolean.FALSE;
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("GenEndSyncTask", "Begin beforeWorkStart");
        super.mo66489c();
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f62500y = (List) c10800nM68549a.m65737b("datatypelist");
        this.f62501z = (List) c10800nM68549a.m65737b("datatyperesultlist");
        this.f62496A = (List) c10800nM68549a.m65737b("data_type_ctag_list");
        this.f62497B = c10800nM68549a.m65736a("is_timeout", false);
        this.f62498C = c10800nM68549a.m65736a("is_destroy", false);
        Object objM65739d = c10800nM68549a.m65739d("sync_mode_info");
        if (objM65739d instanceof Integer) {
            int iIntValue = ((Integer) objM65739d).intValue();
            this.f62499D = iIntValue == 0;
            C11839m.m70688i("GenEndSyncTask", "endSync: syncMode " + iIntValue + ", isDownloadOnly " + this.f62499D);
        }
    }

    @Override // p770xc.AbstractC13752o
    /* renamed from: z */
    public void mo82568z(LinkedHashMap<String, String> linkedHashMap, int i10) {
        CloudSyncRetryInfo cloudSyncRetryInfoM17817e = C2973b.m17817e(this.f53282a, this.f61834s);
        if (cloudSyncRetryInfoM17817e != null) {
            long retryTime = cloudSyncRetryInfoM17817e.getRetryTime();
            int retryTimes = cloudSyncRetryInfoM17817e.getRetryTimes();
            linkedHashMap.put(ContentRecord.TASK_ID, String.valueOf(cloudSyncRetryInfoM17817e.getTaskId()));
            linkedHashMap.put("syncType", String.valueOf(cloudSyncRetryInfoM17817e.getSyncType()));
            linkedHashMap.put(CalendarConfigTable.CalendarTable.Events.TIME, String.valueOf(cloudSyncRetryInfoM17817e.getSyncTime()));
            linkedHashMap.put("syncStatus", String.valueOf(cloudSyncRetryInfoM17817e.getSyncStatus()));
            linkedHashMap.put("retryTime", String.valueOf(retryTime));
            linkedHashMap.put("retryTimes", String.valueOf(retryTimes));
            if (1 == i10) {
                linkedHashMap.put("retryResult", String.valueOf(1));
                C10812z.m65846o(this.f53282a, this.f61834s, 0, "dataTypeResult: " + this.f62501z.toString(), this.f61832q, "cloud_sync_retry", this.f61833r, linkedHashMap, true);
                return;
            }
            if (i10 != 0 || retryTime <= 0 || retryTimes <= 0) {
                return;
            }
            linkedHashMap.put("syncStatus", String.valueOf(0));
            linkedHashMap.put("retryTime", String.valueOf(0));
            linkedHashMap.put("retryTimes", String.valueOf(0));
            linkedHashMap.put(CalendarConfigTable.CalendarTable.Events.TIME, String.valueOf(System.currentTimeMillis()));
            linkedHashMap.put("retryResult", String.valueOf(0));
            C10812z.m65846o(this.f53282a, this.f61834s, 0, "", this.f61832q, "cloud_sync_retry", this.f61833r, linkedHashMap, true);
        }
    }
}
