package com.huawei.android.hicloud.report;

import android.content.Context;
import java.util.HashMap;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* loaded from: classes3.dex */
public class CloudCommonReport {

    /* renamed from: com.huawei.android.hicloud.report.CloudCommonReport$BI */
    public interface InterfaceC2872BI {
    }

    public interface GetUserPublicInfo {
    }

    public interface MigrateState {
    }

    public interface PushGuideReportKey {
    }

    public interface TermProcessKey {
    }

    public interface TermProcessValue {
    }

    /* renamed from: a */
    public static C11060c m17077a() {
        return C11058a.m66626a(C11058a.m66627b("07002"), "07002", C13452e.m80781L().m80971t0());
    }

    /* renamed from: b */
    public static void m17078b(Context context, String str, int i10) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07002"), "07002", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66664t("07002");
        c11060cM66626a.m66665u("119_" + i10);
        HashMap map = new HashMap();
        map.put("migration_state", str);
        C13622a.m81969o(context, c11060cM66626a, map);
    }
}
