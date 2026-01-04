package p770xc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import bd.C1164a;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.sync.service.aidl.SerializableMap;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.About;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C10800n;
import je.C10812z;
import p015ak.C0240y;
import p514o9.C11839m;
import p664u0.C13108a;
import tc.C13007b;

@CBServiceTask(request = 55000025, response = 66000025)
/* renamed from: xc.c */
/* loaded from: classes3.dex */
public class C13740c extends AbstractC13752o {

    /* renamed from: D */
    public String f61765D;

    /* renamed from: y */
    public ArrayList<String> f61766y = null;

    /* renamed from: z */
    public String f61767z = "";

    /* renamed from: A */
    public int f61762A = -1;

    /* renamed from: B */
    public final Map<String, Long> f61763B = new HashMap();

    /* renamed from: C */
    public final LinkedHashMap<String, String> f61764C = new LinkedHashMap<>();

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
        C11839m.m70688i("GetExceedLimitsTask", "afterWorkDone");
    }

    /* renamed from: C */
    public final void m82570C(boolean z10) {
        C11839m.m70688i("GetExceedLimitsTask", "CallBack, value = 0");
        Intent intent = new Intent();
        if (this.f61762A == 0) {
            intent.setAction("com.huawei.android.hicloud.intent.TOOLSYNCCALLBACK");
        } else {
            intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        }
        intent.putExtra("msgType", this.f61834s);
        intent.putExtra("msgID", 10015);
        Bundle bundle = new Bundle();
        bundle.putString("callbackUuid", this.f61767z);
        bundle.putInt(MapKeyNames.RESULT_CODE, 0);
        bundle.putString("sync_module_package_name", this.f61836u);
        bundle.putString("get_exceed_from_channel", "exceed_from_service");
        SerializableMap serializableMap = new SerializableMap();
        serializableMap.setMap(this.f61763B);
        bundle.putSerializable("get_datatypes_limits_result", serializableMap);
        LinkedHashMap<String, String> linkedHashMapM65833b = C10812z.m65833b(this.f61836u);
        if (linkedHashMapM65833b.isEmpty()) {
            this.f61764C.put("versionName", this.f61765D);
            this.f61764C.put("packageName", this.f61837v);
        } else {
            this.f61764C.putAll(linkedHashMapM65833b);
        }
        this.f61764C.put("upperlimitsResult", this.f61763B.toString());
        C10812z.m65846o(this.f53282a, this.f61834s, 0, z10 ? "is flow control" : "", this.f61832q, "get_exceed_limits", this.f61833r, this.f61764C, false);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.f53282a).m78881d(intent);
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("GetExceedLimitsTask", "Begin doWork");
        boolean z10 = false;
        try {
            try {
                if (C2786g.m16219h(this.f53282a, this.f61834s, this.f61765D)) {
                    C11839m.m70689w("GetExceedLimitsTask", "syncFlowControlPolicy effect before getExceedLimitsNum");
                    z10 = true;
                    m82573F();
                } else {
                    C2786g.m16214c(this.f53282a, this.f61833r, this.f61834s);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getExceedLimitsNum dataTypes = ");
                    ArrayList<String> arrayList = this.f61766y;
                    sb2.append(arrayList == null ? null : arrayList.toString());
                    C11839m.m70688i("GetExceedLimitsTask", sb2.toString());
                    boolean zM82572E = m82572E(this.f53282a, this.f61834s, this.f61766y, this.f61764C);
                    C11839m.m70688i("GetExceedLimitsTask", "getExceedLimitsNum result = " + zM82572E);
                    if (zM82572E) {
                        m82573F();
                        C11839m.m70688i("GetExceedLimitsTask", "dataTypeLimitsResult map = " + this.f61763B.toString());
                    }
                }
            } catch (Exception e10) {
                C11839m.m70687e("GetExceedLimitsTask", "doWork error:" + e10.toString());
            }
            m82570C(z10);
            return Boolean.FALSE;
        } catch (Throwable th2) {
            m82570C(false);
            throw th2;
        }
    }

    /* renamed from: E */
    public final boolean m82572E(Context context, String str, List<String> list, LinkedHashMap<String, String> linkedHashMap) {
        if (list == null || list.size() <= 0) {
            C11839m.m70689w("GetExceedLimitsTask", "syncV2 getExceedLimitsNum param invalid");
            return false;
        }
        if (m82574G(context, str, list)) {
            C11839m.m70688i("GetExceedLimitsTask", "syncV2 getExceedLimitsNum syncType: " + str + " in 30 days, get limits from sp");
            linkedHashMap.put("limitsFrom", "fromSp");
            return true;
        }
        try {
            C13007b.m78205Y(context).m78258f(str, list);
            C13007b.m78205Y(context).m78268k(str, list);
            linkedHashMap.put("limitsFrom", "fromServer");
            About aboutExecute = C1164a.m7265f().m7268d(str).m59248g().get(DriveSyncUtil.m17959D(str)).setFields2("dataVersion,kinds,maxBatchNumber,status,kindsUpperLimits").execute();
            if (aboutExecute == null) {
                C11839m.m70689w("GetExceedLimitsTask", "syncV2 getExceedLimitsNum fail, about response null, syncType : " + str);
                return false;
            }
            m82575H(context, aboutExecute, str, linkedHashMap);
            C11839m.m70688i("GetExceedLimitsTask", "syncV2 getExceedLimitsNum success, syncType : " + str);
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("GetExceedLimitsTask", "syncV2 getExceedLimitsNum error, syncType : " + str + ", errorMsg = " + e10.getMessage());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("syncV2 getExceedLimitsNum fail, syncType : ");
            sb2.append(str);
            C11839m.m70688i("GetExceedLimitsTask", sb2.toString());
            return false;
        }
    }

    /* renamed from: F */
    public final void m82573F() {
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f53282a);
        Iterator<String> it = this.f61766y.iterator();
        while (it.hasNext()) {
            String next = it.next();
            long jM78212D = c13007bM78205Y.m78212D(this.f61834s, next);
            if (jM78212D != -1) {
                this.f61763B.put(next, Long.valueOf(jM78212D));
            }
        }
    }

    /* renamed from: G */
    public final boolean m82574G(Context context, String str, List<String> list) {
        if ("V2.0".equalsIgnoreCase(C13007b.m78205Y(context).m78296y(str))) {
            boolean z10 = true;
            if (1 == C13007b.m78205Y(context).m78246X(str)) {
                for (String str2 : list) {
                    if (System.currentTimeMillis() - C13007b.m78205Y(context).m78220H(str, str2) >= 2592000000L) {
                        C11839m.m70689w("GetExceedLimitsTask", "syncV2 getExceedLimitsNum local not satisfy, dataType = " + str2);
                        z10 = false;
                    }
                }
                return z10;
            }
        }
        C11839m.m70689w("GetExceedLimitsTask", "syncV2 getExceedLimitsNum not v2 version");
        return false;
    }

    /* renamed from: H */
    public final void m82575H(Context context, About about, String str, LinkedHashMap<String, String> linkedHashMap) {
        C13007b c13007bM78205Y = C13007b.m78205Y(context);
        Map<String, Long> kindsUpperLimits = about.getKindsUpperLimits();
        if (kindsUpperLimits != null && kindsUpperLimits.size() > 0) {
            for (Map.Entry<String, Long> entry : kindsUpperLimits.entrySet()) {
                String key = entry.getKey();
                c13007bM78205Y.m78289u0(str, key, entry.getValue().longValue());
                c13007bM78205Y.m78299z0(str, key, System.currentTimeMillis());
            }
        }
        Iterator<String> it = this.f61766y.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (c13007bM78205Y.m78212D(str, next) == -1) {
                c13007bM78205Y.m78299z0(str, next, System.currentTimeMillis());
            }
        }
        if (linkedHashMap != null) {
            linkedHashMap.put("cloudkindsUpperLimits", kindsUpperLimits == null ? "" : kindsUpperLimits.toString());
        }
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("GetExceedLimitsTask", "Begin beforeWorkStart");
        super.mo66489c();
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61766y = (ArrayList) c10800nM68549a.m65739d("datatypelist");
        if (c10800nM68549a.m65739d("callbackUuid") != null) {
            this.f61767z = (String) c10800nM68549a.m65739d("callbackUuid");
        }
        if (c10800nM68549a.m65739d("functionVersion") != null) {
            this.f61762A = ((Integer) c10800nM68549a.m65739d("functionVersion")).intValue();
        }
        this.f61765D = C0240y.m1681c(this.f53282a, this.f61837v);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getExceedLimitsNum, syncType = ");
        sb2.append(this.f61834s);
        sb2.append(", dataTypes = ");
        ArrayList<String> arrayList = this.f61766y;
        sb2.append(arrayList == null ? null : arrayList.toString());
        sb2.append(", packageName = ");
        sb2.append(this.f61836u);
        sb2.append(", realPackageName = ");
        sb2.append(this.f61837v);
        sb2.append(", versionName = ");
        sb2.append(this.f61765D);
        C11839m.m70688i("GetExceedLimitsTask", sb2.toString());
    }
}
