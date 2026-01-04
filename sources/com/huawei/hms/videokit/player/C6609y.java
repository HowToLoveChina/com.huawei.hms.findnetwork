package com.huawei.hms.videokit.player;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.Locale;

/* renamed from: com.huawei.hms.videokit.player.y */
/* loaded from: classes8.dex */
public class C6609y {

    /* renamed from: c */
    private static final Object f30712c = new Object();

    /* renamed from: d */
    private static volatile C6609y f30713d;

    /* renamed from: a */
    private Context f30714a;

    /* renamed from: b */
    private boolean f30715b = false;

    private C6609y() {
    }

    /* renamed from: a */
    private String m37723a() {
        String strM37640a = C6597s.m37640a();
        if (!C6600t0.m37680b(strM37640a)) {
            Locale locale = Locale.ENGLISH;
            if (!TextUtils.equals(strM37640a.toUpperCase(locale), "UNKNOWN")) {
                return strM37640a.toUpperCase(locale);
            }
        }
        return Locale.getDefault().getCountry();
    }

    /* renamed from: b */
    public static C6609y m37724b() {
        if (f30713d == null) {
            synchronized (f30712c) {
                try {
                    if (f30713d == null) {
                        f30713d = new C6609y();
                    }
                } finally {
                }
            }
        }
        return f30713d;
    }

    /* renamed from: c */
    public boolean m37727c() {
        if (!this.f30715b) {
            return false;
        }
        int iM37665a = C6600t0.m37665a(this.f30714a);
        C6550c1.m37256a("HiAnalyticsHelper", "isEnableReport analytics state:" + iM37665a);
        if (iM37665a == 1) {
            return true;
        }
        return iM37665a != 0 && m37723a().equals("CN");
    }

    /* renamed from: a */
    public void m37725a(int i10, String str, C6592p c6592p) {
        C6550c1.m37264c("HiAnalyticsHelper", "onEvent, type = " + i10);
        if (str == null || c6592p == null) {
            C6550c1.m37264c("HiAnalyticsHelper", "eventId or data is null");
            return;
        }
        C6550c1.m37256a("HiAnalyticsHelper", "type = " + i10 + ", eventId = " + str + ", data = " + c6592p.toString());
        HiAnalyticsUtils.getInstance().onReport(this.f30714a, str, c6592p.m37592a(), i10);
    }

    /* renamed from: a */
    public void m37726a(Context context, boolean z10) {
        if (context == null) {
            C6550c1.m37265d("HiAnalyticsHelper", "initAnalyticsSdk Context is null");
            return;
        }
        this.f30714a = context;
        try {
            HMSLog.init(context, 4, "HMS_");
            HMSBIInitializer.getInstance(this.f30714a).initBI();
            C6550c1.m37264c("HiAnalyticsHelper", "initAnalyticsSdk success");
            this.f30715b = true;
        } catch (Exception e10) {
            C6550c1.m37258a("HiAnalyticsHelper", "initAnalyticsSdk e:", e10);
        }
    }
}
