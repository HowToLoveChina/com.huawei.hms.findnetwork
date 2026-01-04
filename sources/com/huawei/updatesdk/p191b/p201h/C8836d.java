package com.huawei.updatesdk.p191b.p201h;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.huawei.hianalytics.core.transport.Utils;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.h.d */
/* loaded from: classes9.dex */
public class C8836d {

    /* renamed from: a */
    private static Typeface f45187a;

    /* renamed from: a */
    public static int m56336a(long j10, long j11) {
        if (j11 <= 0) {
            return 0;
        }
        return Math.min((int) Math.round((j10 / j11) * 100.0d), 100);
    }

    /* renamed from: a */
    public static String m56337a(int i10) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(0);
        return percentInstance.format(i10 / 100.0d);
    }

    /* renamed from: a */
    public static String m56338a(Context context, long j10) {
        if (j10 == 0) {
            return context.getString(C8835c.m56335c(context, "upsdk_storage_utils"), "0");
        }
        DecimalFormat decimalFormat = j10 > 104857 ? new DecimalFormat("###.#") : j10 > 10485 ? new DecimalFormat("###.##") : null;
        return decimalFormat != null ? context.getString(C8835c.m56335c(context, "upsdk_storage_utils"), decimalFormat.format(j10 / 1048576.0d)) : context.getString(C8835c.m56335c(context, "upsdk_storage_utils"), "0.01");
    }

    /* renamed from: a */
    public static void m56339a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e10) {
                C8774a.m56008a(Utils.TAG, "close cursor error: " + e10.getMessage());
            }
        }
    }

    /* renamed from: a */
    public static void m56340a(TextView textView) {
        try {
            if (C8833a.m56305f().m56309b() > 0) {
                if (f45187a == null) {
                    f45187a = Typeface.create("HnChinese-medium", 0);
                }
                Typeface typeface = f45187a;
                if (typeface != null) {
                    textView.setTypeface(typeface);
                }
            }
        } catch (Exception e10) {
            C8777a.m56028b(Utils.TAG, "setSubTextType TextView Exception" + e10.getMessage());
        }
    }

    /* renamed from: a */
    public static boolean m56341a(Context context, Uri uri, String str) {
        if (uri == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            C8774a.m56008a(Utils.TAG, "invalid provider: " + uri);
            return false;
        }
        ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo == null || !TextUtils.equals(str, applicationInfo.packageName)) {
            return false;
        }
        C8774a.m56009b(Utils.TAG, "valid provider: " + uri);
        return true;
    }

    /* renamed from: a */
    public static boolean m56342a(List list) {
        return list == null || list.size() <= 0;
    }
}
