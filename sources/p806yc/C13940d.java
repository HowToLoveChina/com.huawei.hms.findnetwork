package p806yc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.commonlib.space.QuotaDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import com.huawei.android.hicloud.sync.service.aidl.SerializableMap;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C10812z;
import p020ap.C1008c;
import p514o9.C11839m;
import p664u0.C13108a;
import p770xc.AbstractC13752o;

@CBServiceTask(request = 55000034, response = 66000034)
/* renamed from: yc.d */
/* loaded from: classes3.dex */
public class C13940d extends AbstractC13752o {

    /* renamed from: y */
    public List<String> f62508y;

    /* renamed from: z */
    public final Map<String, Integer> f62509z = new HashMap();

    /* renamed from: A */
    public final LinkedHashMap<String, String> f62507A = new LinkedHashMap<>();

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
        super.mo66488a(bool);
    }

    /* renamed from: C */
    public final void m83710C() {
        C11839m.m70688i("GenQueryStructCountTask", "Begin callback");
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.GENSENDCALLBACK");
        intent.putExtra("msgType", this.f61834s);
        intent.putExtra("msgID", 10016);
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, 0);
        bundle.putString("sync_module_package_name", this.f61836u);
        SerializableMap serializableMap = new SerializableMap();
        serializableMap.setMap(this.f62509z);
        bundle.putSerializable("gen_get_struct_count_result", serializableMap);
        this.f62507A.putAll(C10812z.m65833b(this.f61836u));
        this.f62507A.put("cloudStructNumResult", this.f62509z.toString());
        C10812z.m65846o(this.f53282a, this.f61834s, 0, "", this.f61832q, "get_cloud_struct_num", this.f61833r, this.f62507A, false);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.f53282a).m78881d(intent);
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("GenQueryStructCountTask", "Begin doWork");
        try {
            try {
                m83712E();
            } catch (Exception e10) {
                C11839m.m70687e("GenQueryStructCountTask", "doWork error, msg: " + e10.getMessage());
            }
            return Boolean.FALSE;
        } finally {
            m83710C();
        }
    }

    /* renamed from: E */
    public final void m83712E() {
        String strM6038C = C1008c.m6035v().m6038C(this.f61834s);
        if (TextUtils.isEmpty(strM6038C)) {
            C11839m.m70689w("GenQueryStructCountTask", "database id is null");
            return;
        }
        QuotaUsedInfoRsp quotaUsedInfoRspM17966K = DriveSyncUtil.m17966K(this.f53282a, this.f61834s, m83713F(), strM6038C, this.f61833r);
        if (quotaUsedInfoRspM17966K == null) {
            C11839m.m70689w("GenQueryStructCountTask", "response is null.");
        } else {
            m83714G(quotaUsedInfoRspM17966K);
        }
    }

    /* renamed from: F */
    public final String m83713F() {
        StringBuilder sb2 = new StringBuilder("collection=private and kind in [");
        List<String> list = this.f62508y;
        if (list == null || list.isEmpty()) {
            C11839m.m70687e("GenQueryStructCountTask", "dataTypes is null or empty.");
            return "";
        }
        sb2.append(String.join(",", this.f62508y));
        sb2.append("] and (trashed=true or trashed=false)");
        C11839m.m70688i("GenQueryStructCountTask", "getQuotaRequest: " + sb2.toString());
        return sb2.toString();
    }

    /* renamed from: G */
    public final void m83714G(QuotaUsedInfoRsp quotaUsedInfoRsp) {
        if (quotaUsedInfoRsp.getRetCode() != 0) {
            C11839m.m70688i("GenQueryStructCountTask", "Query quota pim number request failed. msg: " + quotaUsedInfoRsp.getRetDesc());
            return;
        }
        for (QuotaDetail quotaDetail : quotaUsedInfoRsp.getQuotaDetails()) {
            int recordsCount = quotaDetail.getRecordsCount();
            String kind = quotaDetail.getKind();
            this.f62509z.put(kind, Integer.valueOf(this.f62509z.getOrDefault(kind, 0).intValue() + recordsCount));
        }
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("GenQueryStructCountTask", "Begin beforeWorkStart.");
        super.mo66489c();
        this.f62508y = (List) this.f53284c.m68549a().m65739d("datatypelist");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("End beforeWorkStart, syncType ");
        sb2.append(this.f61834s);
        sb2.append(", dataTypes ");
        List<String> list = this.f62508y;
        sb2.append(list == null ? "empty" : list.toString());
        sb2.append(", packageName ");
        sb2.append(this.f61836u);
        C11839m.m70688i("GenQueryStructCountTask", sb2.toString());
    }
}
