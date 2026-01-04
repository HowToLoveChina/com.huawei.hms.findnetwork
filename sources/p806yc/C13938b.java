package p806yc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.syncutil.C2985n;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import je.C10800n;
import je.C10812z;
import p514o9.C11839m;
import p572qb.C12329u;
import p664u0.C13108a;
import p770xc.AbstractC13752o;
import tc.C13007b;

@CBServiceTask(request = 55000035, response = 66000035)
/* renamed from: yc.b */
/* loaded from: classes3.dex */
public class C13938b extends AbstractC13752o {

    /* renamed from: y */
    public ArrayList<String> f62502y = new ArrayList<>();

    /* renamed from: z */
    public C12329u f62503z = null;

    /* renamed from: C */
    private void m83704C() {
        C11839m.m70688i("GenGetSyncLostTask", "CallBack");
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.GENSENDCALLBACK");
        intent.putExtra("msgType", this.f61834s);
        intent.putExtra("msgID", 10017);
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, 0);
        bundle.putString("sync_module_package_name", this.f61836u);
        bundle.putStringArrayList("get_sync_lost_list_result", this.f62502y);
        LinkedHashMap<String, String> linkedHashMapM65833b = C10812z.m65833b(this.f61836u);
        linkedHashMapM65833b.put("lostRecordIdList", this.f62502y.toString());
        C10812z.m65847p(this.f53282a, this.f61834s, this.f61835t, 0, "", this.f61832q, "batch_of_get_lost_list", this.f61833r, linkedHashMapM65833b, false);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.f53282a).m78881d(intent);
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
        C11839m.m70688i("GenGetSyncLostTask", "afterWorkDone");
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C13007b c13007bM78205Y;
        String str;
        C11839m.m70688i("GenGetSyncLostTask", "Begin doWork");
        try {
            try {
                c13007bM78205Y = C13007b.m78205Y(this.f53282a);
                str = this.f61834s;
            } catch (Exception e10) {
                C11839m.m70687e("GenGetSyncLostTask", "doWork error:" + e10.toString());
            }
            if (!C2985n.m17934d(str, c13007bM78205Y.m78245W(str, this.f61835t))) {
                C11839m.m70689w("GenGetSyncLostTask", "is not support");
                return Boolean.FALSE;
            }
            List<Record> listM17963H = DriveSyncUtil.m17963H(this.f61834s, this.f61835t, this.f61836u, this.f61833r, this.f53282a);
            C12329u c12329u = this.f62503z;
            if (c12329u != null) {
                c12329u.m74133x(listM17963H, "update_record_none_lost_file");
            }
            for (Record record : listM17963H) {
                if (record != null && !TextUtils.isEmpty(record.getId())) {
                    this.f62502y.add(record.getId());
                }
            }
            if (this.f62503z != null && listM17963H.size() > 0) {
                this.f62503z.m74126O(listM17963H);
            }
            C11839m.m70686d("GenGetSyncLostTask", "lostRecordIdList = " + this.f62502y.toString());
            return Boolean.FALSE;
        } finally {
            m83704C();
        }
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("GenGetSyncLostTask", "Begin beforeWorkStart");
        super.mo66489c();
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f62503z = c10800nM68549a.m65739d("sync_moudle_lost_refund_impl") != null ? (C12329u) c10800nM68549a.m65739d("sync_moudle_lost_refund_impl") : null;
        C11839m.m70688i("GenGetSyncLostTask", "syncType: " + this.f61834s + ", dataType: " + this.f61835t + ", packageName: " + this.f61836u);
    }
}
