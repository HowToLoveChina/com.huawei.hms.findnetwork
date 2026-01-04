package com.huawei.openalliance.p169ad;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;

/* renamed from: com.huawei.openalliance.ad.vl */
/* loaded from: classes8.dex */
public class C8190vl extends AbstractC7693to {
    /* renamed from: a */
    public static String m50725a(Bundle bundle) {
        String strOptString = AbstractC7806cz.m48164b(bundle).optString(MapKeyNames.CREATIVE_SIZE, "");
        if (!AbstractC7806cz.m48187p(strOptString)) {
            strOptString = null;
        }
        AbstractC7185ho.m43818a("ShowTrackerUtil", "creativeSize: %s", strOptString);
        return strOptString;
    }

    /* renamed from: b */
    public static String m50726b(Bundle bundle) {
        String strOptString = AbstractC7806cz.m48164b(bundle).optString(MapKeyNames.SLOT_POSITION, "");
        if (!AbstractC7806cz.m48186o(strOptString)) {
            strOptString = null;
        }
        AbstractC7185ho.m43818a("ShowTrackerUtil", "slotPosition: %s", strOptString);
        return strOptString;
    }

    /* renamed from: c */
    private static String m50728c(View view) {
        ViewParent parent = view.getParent();
        for (int i10 = 0; i10 < 5 && parent != null; i10++) {
            if (AbstractC7693to.m47281a(parent)) {
                return m50729d((ViewGroup) parent);
            }
            parent = parent.getParent();
        }
        return null;
    }

    /* renamed from: d */
    private static String m50729d(View view) {
        StringBuilder sb2 = new StringBuilder();
        int width = view.getWidth();
        int height = view.getHeight();
        sb2.append(width);
        sb2.append("*");
        sb2.append(height);
        String string = sb2.toString();
        AbstractC7185ho.m43821b("ShowTrackerUtil", "adViewCreativeSize: %s", string);
        return string;
    }

    /* renamed from: b */
    public static String m50727b(View view) {
        if (view == null) {
            return null;
        }
        return AbstractC7693to.m47280a(view) ? m50728c(view) : m50729d(view);
    }
}
