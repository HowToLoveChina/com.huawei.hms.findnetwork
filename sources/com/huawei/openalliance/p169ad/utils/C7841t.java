package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7074dr;
import com.huawei.openalliance.p169ad.C7076dt;
import com.huawei.openalliance.p169ad.C7105eu;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.data.PlacementMediaFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.utils.t */
/* loaded from: classes2.dex */
public class C7841t {
    /* renamed from: a */
    public static void m48503a(final Context context, final String str, String str2, final String str3) {
        final Integer numM48178h;
        if (AbstractC7806cz.m48165b(str) || AbstractC7806cz.m48165b(str2) || (numM48178h = AbstractC7806cz.m48178h(str2)) == null) {
            return;
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.t.1
            @Override // java.lang.Runnable
            public void run() {
                C7105eu.m43130a(context).mo43135a(str, numM48178h.intValue(), str3);
            }
        });
    }

    /* renamed from: a */
    private static void m48504a(final PlacementMediaFile placementMediaFile, final int i10, final boolean z10, final String str, final String str2, final Integer num, final int i11) {
        if (placementMediaFile == null || TextUtils.isEmpty(placementMediaFile.getUrl()) || placementMediaFile.getFileSize() <= 0) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.t.2
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("ContentUtils", "download media:%s", AbstractC7819dl.m48375a(placementMediaFile.getUrl()));
                }
                C7074dr c7074dr = new C7074dr(placementMediaFile.getUrl(), (int) placementMediaFile.getFileSize(), placementMediaFile.getCheckSha256() == 0, placementMediaFile.getSha256(), Integer.valueOf(i10), !z10 || 1 == placementMediaFile.getDownloadNetwork(), placementMediaFile.m44551c(), str, str2, 60, z10, i11);
                c7074dr.m42638a(num);
                C7076dt.m42678h().m42680a(c7074dr);
            }
        });
    }

    /* renamed from: a */
    public static void m48505a(Map<String, List<IPlacementAd>> map, int i10, boolean z10, int i11) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, List<IPlacementAd>> entry : map.entrySet()) {
            ArrayList arrayList = new ArrayList(entry.getValue());
            String key = entry.getKey();
            if (!AbstractC7760bg.m47767a(arrayList)) {
                int size = arrayList.size();
                for (int i12 = 0; i12 < size; i12++) {
                    IPlacementAd iPlacementAd = (IPlacementAd) arrayList.get(i12);
                    if (iPlacementAd != null) {
                        String contentId = iPlacementAd.getContentId();
                        if (z10 && (iPlacementAd instanceof C7304g)) {
                            C7304g c7304g = (C7304g) iPlacementAd;
                            List<PlacementMediaFile> listM44871D = c7304g.m44871D();
                            if (!AbstractC7760bg.m47767a(listM44871D)) {
                                int i13 = 0;
                                for (int size2 = listM44871D.size(); i13 < size2; size2 = size2) {
                                    m48504a(listM44871D.get(i13), i10, z10, contentId, key, c7304g.m44641h(), i11);
                                    i13++;
                                }
                            }
                        } else {
                            m48504a(iPlacementAd.getMediaFile(), i10, z10, contentId, key, iPlacementAd instanceof C7304g ? ((C7304g) iPlacementAd).m44641h() : null, i11);
                        }
                    }
                }
            }
        }
    }
}
