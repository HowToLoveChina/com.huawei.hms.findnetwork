package je;

import android.content.Context;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: je.q */
/* loaded from: classes3.dex */
public class C10803q {

    /* renamed from: je.q$a */
    public static class a {

        /* renamed from: a */
        public static C10803q f51565a = new C10803q();
    }

    /* renamed from: c */
    public static C10803q m65748c() {
        return a.f51565a;
    }

    /* renamed from: a */
    public String m65749a(String str, String str2) {
        C11839m.m70688i("LocalServiceForH5", "getAppExists, traceId = " + str2);
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("LocalServiceForH5", "getAppExists param error");
            return FaqConstants.DISABLE_HA_REPORT;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70689w("LocalServiceForH5", "getAppExists context null");
            return "false";
        }
        if (C0209d.m1184K0(contextM1377a, str)) {
            C11839m.m70689w("LocalServiceForH5", "getAppExists true");
            return FaqConstants.DISABLE_HA_REPORT;
        }
        C11839m.m70689w("LocalServiceForH5", "getAppExists false");
        return "false";
    }

    /* renamed from: b */
    public String m65750b(String str, String str2) {
        C11839m.m70688i("LocalServiceForH5", "getCloudBackupInCrementSize, traceId = " + str2);
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("LocalServiceForH5", "getCloudBackupInCrementSize param error, return 0");
            return String.valueOf(0L);
        }
        long moduleIncSizeFromOption = "false".equals(str) ? CloudBackupService.getInstance().getModuleIncSizeFromOption() : 0L;
        C11839m.m70688i("LocalServiceForH5", "getCloudBackupInCrementSize size = " + moduleIncSizeFromOption);
        return String.valueOf(moduleIncSizeFromOption);
    }

    /* renamed from: d */
    public String m65751d(String str, String str2) {
        C11839m.m70688i("LocalServiceForH5", "getLocalVersion");
        return C1443a.f6213a;
    }

    /* renamed from: e */
    public String m65752e(String str, String str2) {
        C11839m.m70688i("LocalServiceForH5", "getLocalVersionName");
        return "16.0.0.300";
    }

    /* renamed from: f */
    public String m65753f(String str, String str2, String str3) throws C9721b {
        String strM65751d;
        C11839m.m70688i("LocalServiceForH5", "localCommonInterface cmd = " + str + ", reqBody = " + str2 + ", traceId = " + str3);
        str.hashCode();
        switch (str) {
            case "getLocalVersion":
                strM65751d = m65751d(str2, str3);
                break;
            case "getAppExists":
                strM65751d = m65749a(str2, str3);
                break;
            case "getLocalVersionName":
                strM65751d = m65752e(str2, str3);
                break;
            case "getBackupInCrementSize":
                strM65751d = m65750b(str2, str3);
                break;
            default:
                strM65751d = "";
                break;
        }
        C11839m.m70688i("LocalServiceForH5", "localCommonInterface response = " + strM65751d);
        return strM65751d;
    }
}
