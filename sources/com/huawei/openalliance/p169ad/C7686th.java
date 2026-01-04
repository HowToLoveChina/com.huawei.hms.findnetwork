package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.th */
/* loaded from: classes8.dex */
public class C7686th {

    /* renamed from: a */
    private static final String f35699a = "th";

    /* renamed from: a */
    public static AbstractC7687ti m47245a(Context context, ContentRecord contentRecord, Map<String, String> map) {
        if (context == null || contentRecord == null || map == null) {
            return new C7682td();
        }
        List<AbstractC7687ti> listM47246a = m47246a(context, contentRecord, map, contentRecord.m41409N());
        if (listM47246a == null || listM47246a.size() <= 0) {
            return new C7682td();
        }
        AbstractC7687ti abstractC7687ti = null;
        for (AbstractC7687ti abstractC7687ti2 : listM47246a) {
            if (abstractC7687ti != null) {
                abstractC7687ti.m47247a(abstractC7687ti2);
            }
            abstractC7687ti = abstractC7687ti2;
        }
        return listM47246a.get(0);
    }

    /* renamed from: a */
    private static List<AbstractC7687ti> m47246a(Context context, ContentRecord contentRecord, Map<String, String> map, List<Integer> list) {
        AbstractC7687ti c7682td;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Integer num : list) {
            switch (num.intValue()) {
                case 0:
                    c7682td = new C7682td();
                    break;
                case 1:
                    c7682td = new C7681tc(context, contentRecord, false, map);
                    break;
                case 2:
                    c7682td = new C7680tb(context, contentRecord, map);
                    break;
                case 3:
                    c7682td = new C7672su(context, contentRecord);
                    break;
                case 4:
                    c7682td = new C7681tc(context, contentRecord, true, map);
                    break;
                case 5:
                    c7682td = new C7684tf(context, contentRecord);
                    break;
                case 6:
                    c7682td = new C7674sw(context, contentRecord);
                    break;
                case 7:
                    c7682td = new C7673sv(context, contentRecord);
                    break;
                case 8:
                    c7682td = new C7683te(context, contentRecord, map);
                    break;
                case 9:
                    c7682td = new C7685tg(context, contentRecord, map);
                    break;
                case 10:
                case 13:
                case 14:
                default:
                    AbstractC7185ho.m43823c(f35699a, "unsupport action:" + num);
                    c7682td = null;
                    break;
                case 11:
                    c7682td = new C7677sz(context, contentRecord);
                    break;
                case 12:
                    c7682td = new C7676sy(context, contentRecord);
                    break;
                case 15:
                    c7682td = new C7675sx(context, contentRecord);
                    break;
            }
            if (c7682td != null) {
                arrayList.add(c7682td);
            }
        }
        return arrayList;
    }
}
