package p632s4;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import java.io.File;
import java.text.Normalizer;
import p699v4.C13345n;

/* renamed from: s4.g */
/* loaded from: classes.dex */
public class C12703g {

    /* renamed from: a */
    public static boolean f58255a = false;

    /* renamed from: a */
    public static boolean m76448a(File file) {
        boolean zM76448a;
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !(zM76448a = m76448a(parentFile))) {
            return zM76448a;
        }
        return file.mkdir();
    }

    /* renamed from: b */
    public static String m76449b() {
        return m76453f() ? "/Sounds/CallRecord" : "/record";
    }

    /* renamed from: c */
    public static String m76450c() {
        return m76453f() ? "/Sounds" : "/Recordings";
    }

    /* renamed from: d */
    public static int m76451d(int i10) {
        switch (i10) {
            case 503:
                return 503;
            case 504:
                return 504;
            case BasicBaseResp.TERM_NO_SIGN /* 505 */:
                return BasicBaseResp.TERM_NO_SIGN;
            default:
                switch (i10) {
                    case 5061:
                    case 5062:
                    case 5063:
                    case 5064:
                    case 5065:
                        break;
                    default:
                        return -1;
                }
            case CBSbkFlowHead.FLOW_CONTROL_ERR_CODE /* 506 */:
                return CBSbkFlowHead.FLOW_CONTROL_ERR_CODE;
        }
    }

    /* renamed from: e */
    public static boolean m76452e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C13345n.m80072k(context, 2));
        sb2.append(m76450c());
        String str2 = File.separator;
        sb2.append(str2);
        String string = sb2.toString();
        String str3 = C13345n.m80072k(context, 3) + m76450c() + str2;
        String str4 = C13345n.m80072k(context, 2) + m76449b() + str2;
        String str5 = C13345n.m80072k(context, 3) + m76449b() + str2;
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFKC);
        return strNormalize.startsWith(string) || strNormalize.startsWith(str3) || strNormalize.startsWith(str4) || strNormalize.startsWith(str5);
    }

    /* renamed from: f */
    public static boolean m76453f() {
        return true;
    }

    /* renamed from: g */
    public static void m76454g(boolean z10) {
        f58255a = z10;
    }
}
