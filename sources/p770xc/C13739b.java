package p770xc;

import com.huawei.android.backup.service.logic.calendar.CalendarConfigTable;
import com.huawei.android.hicloud.sync.bean.CloudSyncRetryInfo;
import com.huawei.android.hicloud.sync.syncutil.C2973b;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import je.C10800n;
import je.C10812z;
import p514o9.C11839m;
import vc.C13398b;

@CBServiceTask(request = 55000011, response = 66000011)
/* renamed from: xc.b */
/* loaded from: classes3.dex */
public class C13739b extends AbstractC13752o {

    /* renamed from: y */
    public List<String> f61760y = null;

    /* renamed from: z */
    public List<String> f61761z = null;

    /* renamed from: A */
    public List<String> f61757A = null;

    /* renamed from: B */
    public boolean f61758B = false;

    /* renamed from: C */
    public boolean f61759C = false;

    /* JADX WARN: Removed duplicated region for block: B:43:0x027d  */
    /* renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m82564E() {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p770xc.C13739b.m82564E():void");
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
        m82564E();
    }

    /* renamed from: C */
    public final boolean m82566C() {
        List<String> list = this.f61761z;
        if (list == null || list.isEmpty()) {
            return false;
        }
        C11839m.m70688i("EndSyncTask", this.f61834s + " checkSyncResult dataTypeResult = " + this.f61761z.toString());
        Iterator<String> it = this.f61761z.iterator();
        while (it.hasNext()) {
            if (!"0".equals(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("EndSyncTask", "Begin doWork");
        C13398b c13398b = new C13398b(this.f53282a, this.f61834s, this.f61760y, this.f61761z, this.f61757A, this.f61832q, this.f61833r, this.f61836u, this.f61838w);
        c13398b.setConfig(this.f61834s, this.f53297m, this.f61839x);
        c13398b.m80500b();
        return Boolean.FALSE;
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        super.mo66489c();
        C11839m.m70688i("EndSyncTask", "Begin beforeWorkStart");
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61760y = (List) c10800nM68549a.m65737b("datatypelist");
        this.f61761z = (List) c10800nM68549a.m65737b("datatyperesultlist");
        this.f61757A = (List) c10800nM68549a.m65737b("data_type_ctag_list");
        this.f61758B = c10800nM68549a.m65736a("is_timeout", false);
        this.f61759C = c10800nM68549a.m65736a("is_destroy", false);
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
                C10812z.m65846o(this.f53282a, this.f61834s, 0, "dataTypeResult: " + this.f61761z.toString(), this.f61832q, "cloud_sync_retry", this.f61833r, linkedHashMap, true);
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
