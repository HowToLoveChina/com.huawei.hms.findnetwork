package com.huawei.hianalytics;

import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hianalytics.C4727a0;
import com.huawei.hianalytics.C4813x;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.a0 */
/* loaded from: classes5.dex */
public class C4727a0 {

    /* renamed from: a */
    public final Handler f21617a;

    /* renamed from: a */
    public final C4813x f21618a = new C4813x();

    public C4727a0(Handler handler) {
        this.f21617a = handler;
    }

    /* renamed from: a */
    public final List<C4813x> m28739a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        List<String> listQueryMcInfo = C4794n.m28969a(EnvUtils.getAppContext()).queryMcInfo();
        if (listQueryMcInfo.isEmpty()) {
            return arrayList;
        }
        try {
            Iterator<String> it = listQueryMcInfo.iterator();
            while (it.hasNext()) {
                C4813x c4813x = new C4813x(it.next());
                if (C4785j.m28921a(c4813x.f21980c)) {
                    list.add(c4813x.f21976a);
                } else {
                    arrayList.add(c4813x);
                }
            }
        } catch (JSONException unused) {
            HiLog.m28812w("MPL", "RAR JSONException");
        }
        if (arrayList.size() <= C4811w.m29047a().f21965c) {
            return arrayList;
        }
        Collections.sort(arrayList, new Comparator() { // from class: pj.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C4727a0.m28738a((C4813x) obj, (C4813x) obj2);
            }
        });
        return arrayList.subList(0, C4811w.m29047a().f21965c);
    }

    /* renamed from: a */
    public final Map<String, C4815y> m28740a(List<String> list) {
        List<String> listQueryMcTag = C4794n.m28969a(EnvUtils.getAppContext()).queryMcTag("MC");
        HashMap map = new HashMap();
        if (listQueryMcTag != null && !listQueryMcTag.isEmpty()) {
            try {
                Iterator<String> it = listQueryMcTag.iterator();
                while (it.hasNext()) {
                    C4815y c4815y = new C4815y(it.next());
                    if (C4785j.m28921a(c4815y.f21991a)) {
                        list.add(c4815y.f21992a);
                    } else {
                        map.put(c4815y.f21993b, c4815y);
                    }
                }
            } catch (JSONException unused) {
                HiLog.m28812w("MPL", "HMTD JSONException");
            }
        }
        return map;
    }

    /* renamed from: a */
    public static int m28738a(C4813x c4813x, C4813x c4813x2) {
        long j10 = c4813x.f21980c;
        long j11 = c4813x2.f21980c;
        if (j10 == j11) {
            return 0;
        }
        return j10 - j11 > 0 ? -1 : 1;
    }

    /* renamed from: a */
    public final void m28741a(List<C4813x> list, List<String> list2, List<C4813x> list3, Map<String, C4815y> map) throws JSONException {
        boolean z10 = list3 != null;
        for (C4813x c4813x : list) {
            if (z10) {
                list2.add(c4813x.f21976a);
            }
            if (map.containsKey(c4813x.f21979b)) {
                C4815y c4815y = map.get(c4813x.f21979b);
                if (c4815y != null) {
                    String str = c4815y.f21995d;
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObjectM28911a = C4785j.m28911a(c4813x, "content_code", str, "uuid_metric_info");
                        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_metric_mc");
                        if (instanceByTag == null) {
                            HiLog.m28812w("MRUtils", "metric instance is null");
                        } else {
                            instanceByTag.onEventSync(0, "108", jSONObjectM28911a);
                        }
                    }
                    String str2 = c4815y.f21994c;
                    if (!TextUtils.isEmpty(str2)) {
                        JSONObject jSONObjectM28911a2 = C4785j.m28911a(c4813x, "metric_tag", str2, "uuid_tag_info");
                        HiAnalyticsInstance instanceByTag2 = HiAnalyticsManager.getInstanceByTag("ha_metric_mc");
                        if (instanceByTag2 == null) {
                            HiLog.m28812w("MRUtils", "metric instance is null");
                        } else {
                            instanceByTag2.onEventSync(0, "109", jSONObjectM28911a2);
                        }
                    }
                }
            } else if (z10) {
                list3.add(c4813x);
            }
        }
    }

    /* renamed from: a */
    public final boolean m28742a(List<C4813x> list, Map<String, C4815y> map) throws JSONException {
        List<String> listM28910a;
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = new HashSet(list).iterator();
            while (it.hasNext()) {
                arrayList.add(((C4813x) it.next()).m29055a().toString());
            }
        } catch (JSONException unused) {
            HiLog.m28812w("MPL", "DD JSONException");
        }
        int iMin = Math.min(C4811w.m29047a().f21967d, 30);
        if (arrayList.size() <= iMin) {
            listM28910a = C4785j.m28910a(arrayList);
        } else {
            int iCeil = (int) Math.ceil(arrayList.size() / iMin);
            ArrayList arrayList2 = new ArrayList();
            for (int i10 = 0; i10 < iCeil; i10++) {
                int i11 = i10 * iMin;
                arrayList2.addAll(C4785j.m28910a((List<String>) arrayList.subList(i11, Math.min(i11 + iMin, arrayList.size()))));
            }
            HiLog.m28807d("MPL", "count_i: " + list.size() + ", count_o: " + arrayList2.size());
            HiLog.m28807d("MPL", "batchSize: " + iMin + ", batches: " + iCeil);
            listM28910a = arrayList2;
        }
        if (listM28910a.isEmpty()) {
            return false;
        }
        try {
            Iterator<String> it2 = listM28910a.iterator();
            while (it2.hasNext()) {
                C4815y c4815y = new C4815y(it2.next());
                map.put(c4815y.f21993b, c4815y);
            }
        } catch (JSONException unused2) {
            HiLog.m28812w("MPL", "MAR JSONException");
        }
        C4794n.m28969a(EnvUtils.getAppContext()).insertMcTagList(listM28910a);
        return true;
    }
}
