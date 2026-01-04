package com.huawei.openalliance.p169ad.analysis;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7120fd;
import com.huawei.openalliance.p169ad.beans.inner.ApiStatisticsReq;
import com.huawei.openalliance.p169ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.ApiNames;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.analysis.d */
/* loaded from: classes8.dex */
public class C6923d {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static int m39137b(DelayInfo delayInfo, String str) {
        int iM40066q = delayInfo.m40066q();
        if (iM40066q == 494) {
            Integer numM40072w = delayInfo.m40072w();
            iM40066q = numM40072w != null ? numM40072w.intValue() : delayInfo.m40067r() + 20000;
        } else if (iM40066q == -2) {
            iM40066q = delayInfo.m40068s() + ("1".equals(str) ? 10001 : "2".equals(str) ? 10002 : "3".equals(str) ? 10003 : 10000);
        }
        delayInfo.m40027a(iM40066q);
        return iM40066q;
    }

    /* renamed from: a */
    public static int m39126a(AdContentRsp adContentRsp, ContentRecord contentRecord, String str, int i10, long j10, List<ContentRecord> list) {
        if (adContentRsp == null) {
            return -1;
        }
        if (!m39135a(adContentRsp.m40819a())) {
            return adContentRsp.m40819a() + 20000;
        }
        if (contentRecord == null) {
            return m39127a(str, i10, j10, list) + 30000;
        }
        return 200;
    }

    /* renamed from: b */
    public static void m39138b(final Context context, final ContentRecord contentRecord) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.analysis.d.6
            @Override // java.lang.Runnable
            public void run() {
                new C6922c(context).m39120c(contentRecord);
            }
        });
    }

    /* renamed from: a */
    private static int m39127a(String str, int i10, long j10, List<ContentRecord> list) {
        ContentRecord next;
        if (TextUtils.isEmpty(str)) {
            return 4;
        }
        if (AbstractC7760bg.m47767a(list)) {
            next = null;
        } else {
            Iterator<ContentRecord> it = list.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (next != null && str.equals(next.m41588n())) {
                    break;
                }
            }
            next = null;
        }
        if (next == null) {
            return 6;
        }
        int iM41609u = next.m41609u();
        int iM41606t = next.m41606t();
        if (i10 == 0 && (next.m41392E() == 12 || iM41606t <= iM41609u)) {
            return 2;
        }
        if (i10 == 1 && next.m41392E() != 12 && iM41606t > iM41609u) {
            return 3;
        }
        if (j10 < next.m41603s() || j10 > next.m41600r()) {
            return 1;
        }
        return next.m41573j() == 0 ? 5 : 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m39139b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (AbstractC7806cz.m48181j(str)) {
            str = C7022dk.m41953d(str);
        }
        return AbstractC7731ae.m47462c(context, str, Constants.NORMAL_CACHE);
    }

    /* renamed from: a */
    private static ApiStatisticsReq m39128a(String str, String str2, int i10, int i11) {
        ApiStatisticsReq apiStatisticsReq = new ApiStatisticsReq();
        apiStatisticsReq.m39365b(str);
        apiStatisticsReq.m39371d(str2);
        apiStatisticsReq.m39367c(i10);
        apiStatisticsReq.m39363b(i11);
        return apiStatisticsReq;
    }

    /* renamed from: a */
    public static <T extends IAd> void m39129a(final Context context, final int i10, final String str, final int i11, final Map<String, List<T>> map, final DelayInfo delayInfo) {
        if (context == null || delayInfo == null || delayInfo.m40026a() <= 0) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.analysis.d.2
            @Override // java.lang.Runnable
            public void run() {
                C6922c c6922c = new C6922c(context);
                if (!C7765bl.m47802a(map)) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Map.Entry entry : map.entrySet()) {
                        arrayList.add(entry.getKey());
                        List<IAd> list = (List) entry.getValue();
                        if (!AbstractC7760bg.m47767a(list)) {
                            for (IAd iAd : list) {
                                if (iAd != null) {
                                    arrayList2.add(iAd.getContentId());
                                }
                            }
                        }
                    }
                    delayInfo.m40031a(arrayList);
                    delayInfo.m40038b(arrayList2);
                }
                c6922c.mo39103a(ApiNames.LOAD_AD, str, delayInfo, i11, i10);
            }
        });
    }

    /* renamed from: a */
    private static void m39130a(final Context context, final ApiStatisticsReq apiStatisticsReq) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.analysis.d.1
            @Override // java.lang.Runnable
            public void run() {
                new C6922c(context).m39067a(apiStatisticsReq);
            }
        });
    }

    /* renamed from: a */
    public static void m39131a(final Context context, final ContentRecord contentRecord) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.analysis.d.5
            @Override // java.lang.Runnable
            public void run() {
                new C6922c(context).m39112b(contentRecord);
            }
        });
    }

    /* renamed from: a */
    public static void m39132a(final Context context, final ContentRecord contentRecord, final int i10, final int i11) {
        if (context == null) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.analysis.d.4
            @Override // java.lang.Runnable
            public void run() {
                new C6922c(context).mo39071a(contentRecord, i10, i11);
            }
        });
    }

    /* renamed from: a */
    public static void m39133a(final Context context, final String str, final DelayInfo delayInfo, final String str2, final ContentRecord contentRecord, final int i10) {
        if (context == null || delayInfo == null || delayInfo.m40026a() <= 0) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.analysis.d.3
            @Override // java.lang.Runnable
            public void run() {
                ContentRecord contentRecordM41885h;
                delayInfo.m40030a(str);
                C6922c c6922c = new C6922c(context);
                ContentRecord contentRecord2 = contentRecord;
                if (contentRecord2 != null) {
                    delayInfo.m40037b(contentRecord2.m41423U());
                    delayInfo.m40038b(Collections.singletonList(contentRecord.m41588n()));
                    delayInfo.m40032a(contentRecord.m41498at());
                    delayInfo.m40029a(Integer.valueOf(contentRecord.m41392E()));
                    MetaData metaDataM41568i = contentRecord.m41568i();
                    if (metaDataM41568i != null) {
                        delayInfo.m40046d(metaDataM41568i.m40341u());
                    }
                    String strM41585m = contentRecord.m41585m();
                    if (!AbstractC7806cz.m48165b(strM41585m)) {
                        delayInfo.m40052f(String.valueOf(C7120fd.m43288a(context).mo43290a(strM41585m)));
                    }
                }
                if (!delayInfo.m40069t() && (contentRecordM41885h = AbstractC7014dc.m41885h()) != null) {
                    delayInfo.m40049e(contentRecordM41885h.m41588n());
                    delayInfo.m40039b(C6923d.m39139b(context, contentRecordM41885h.m41619z()));
                }
                DelayInfo delayInfo2 = delayInfo;
                ContentRecord contentRecord3 = contentRecord;
                c6922c.mo39103a(ApiNames.LOAD_AD, str2, delayInfo, i10, C6923d.m39137b(delayInfo2, contentRecord3 != null ? contentRecord3.m41423U() : null));
            }
        });
    }

    /* renamed from: a */
    public static void m39134a(Context context, String str, String str2, int i10, int i11, long j10, long j11, int i12) {
        if (context == null || j10 == 0 || j10 >= j11) {
            return;
        }
        ApiStatisticsReq apiStatisticsReqM39128a = m39128a(str, str2, i11, i12);
        apiStatisticsReqM39128a.m39364b(j11 - j10);
        apiStatisticsReqM39128a.m39370d(i10);
        m39130a(context, apiStatisticsReqM39128a);
    }

    /* renamed from: a */
    private static boolean m39135a(int i10) {
        return i10 >= 200 && i10 < 300 && i10 != 204;
    }
}
