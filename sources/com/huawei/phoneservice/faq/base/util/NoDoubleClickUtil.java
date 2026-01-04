package com.huawei.phoneservice.faq.base.util;

import android.util.LruCache;
import android.view.View;
import androidx.annotation.Keep;
import com.huawei.hms.framework.common.Logger;

/* loaded from: classes4.dex */
public class NoDoubleClickUtil {

    /* renamed from: a */
    public static final LruCache<Integer, Long> f38729a = new LruCache<>(10);

    @Keep
    public static boolean isDoubleClick(View view) {
        boolean z10 = true;
        if (view != null) {
            Integer numValueOf = Integer.valueOf(view.getId());
            LruCache<Integer, Long> lruCache = f38729a;
            Long l10 = lruCache.get(numValueOf);
            long jNanoTime = System.nanoTime() / 1000000;
            Logger.m32137d("NoDoubleClickUtil", "isDoubleClick view:%s, lastClickTime:%s,  currentTime:%s", numValueOf, l10, Long.valueOf(jNanoTime));
            if (l10 != null) {
                long jLongValue = jNanoTime - l10.longValue();
                if (jLongValue > 800) {
                    lruCache.put(numValueOf, Long.valueOf(jNanoTime));
                    z10 = false;
                }
                Logger.m32137d("NoDoubleClickUtil", "isDoubleClick gap:%s, BREAK_TIME:%s", Long.valueOf(jLongValue), 800);
            } else {
                lruCache.put(numValueOf, Long.valueOf(jNanoTime));
                z10 = false;
            }
        }
        Logger.m32137d("NoDoubleClickUtil", "isDoubleClick result:%s", Boolean.valueOf(z10));
        return z10;
    }
}
