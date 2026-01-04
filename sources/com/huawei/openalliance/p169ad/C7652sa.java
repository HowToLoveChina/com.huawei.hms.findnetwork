package com.huawei.openalliance.p169ad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7801cu;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;

/* renamed from: com.huawei.openalliance.ad.sa */
/* loaded from: classes8.dex */
public class C7652sa {
    /* renamed from: a */
    public static ContentResource m47163a(C7653sb c7653sb) {
        String strM47164a;
        Integer numM48178h;
        int iIntValue;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("SourceFetcherUtil", "generateContentResource: %s", c7653sb.m47194i());
        }
        try {
            ContentRecord contentRecordM47197l = c7653sb.m47197l();
            if (contentRecordM47197l == null || TextUtils.isEmpty(contentRecordM47197l.m41588n())) {
                return null;
            }
            ContentResource contentResource = new ContentResource(contentRecordM47197l);
            if (c7653sb.m47204s()) {
                strM47164a = m47164a(c7653sb.m47194i()) + AbstractC7731ae.m47465e(c7653sb.m47194i());
            } else {
                strM47164a = m47164a(c7653sb.m47194i());
            }
            contentResource.m41624a(strM47164a);
            Integer numM48178h2 = AbstractC7806cz.m48178h(contentRecordM47197l.m41493ao());
            if (numM48178h2 == null) {
                numM48178h2 = Integer.valueOf(C7021dj.m41949a(contentRecordM47197l.m41552f()));
            }
            contentResource.m41626b(numM48178h2.intValue());
            contentResource.m41629c(contentRecordM47197l.m41573j());
            String strM41423U = contentRecordM47197l.m41423U();
            if (c7653sb.m47206u() == null) {
                if (!AbstractC7806cz.m48165b(strM41423U) && (numM48178h = AbstractC7806cz.m48178h(strM41423U)) != null) {
                    iIntValue = numM48178h.intValue();
                }
                contentResource.m41633d(c7653sb.m47202q());
                contentResource.m41638f(0);
                contentResource.m41636e(c7653sb.m47203r());
                contentResource.m41623a(System.currentTimeMillis());
                return contentResource;
            }
            iIntValue = c7653sb.m47206u().intValue();
            contentResource.m41632d(iIntValue);
            contentResource.m41633d(c7653sb.m47202q());
            contentResource.m41638f(0);
            contentResource.m41636e(c7653sb.m47203r());
            contentResource.m41623a(System.currentTimeMillis());
            return contentResource;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("SourceFetcherUtil", "generateContentResource " + th2.getClass().getSimpleName());
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static String m47164a(String str) {
        if (str == null) {
            return null;
        }
        String strM48126a = AbstractC7801cu.m48126a(str);
        return TextUtils.isEmpty(strM48126a) ? String.valueOf(str.hashCode()) : strM48126a;
    }

    /* renamed from: a */
    public static void m47165a(final Context context, String str, C7022dk c7022dk, final C7653sb c7653sb, final String str2) {
        if (c7022dk == null || c7653sb == null) {
            return;
        }
        c7022dk.m41975h(str);
        ContentRecord contentRecordM47197l = c7653sb.m47197l();
        if (contentRecordM47197l == null) {
            AbstractC7185ho.m43820b("SourceFetcherUtil", "updateOnCacheUri, contentRecord is null");
            return;
        }
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.sa.1
            @Override // java.lang.Runnable
            public void run() {
                C7105eu.m43130a(context).m43134a(C7652sa.m47163a(c7653sb), str2);
            }
        }, AbstractC7834m.a.DISK_CACHE, false);
        Integer numM48178h = AbstractC7806cz.m48178h(contentRecordM47197l.m41493ao());
        if (numM48178h == null) {
            numM48178h = Integer.valueOf(C7021dj.m41949a(contentRecordM47197l.m41552f()));
        }
        c7022dk.m41960a(str, numM48178h.intValue());
    }
}
