package p323h1;

import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: h1.g */
/* loaded from: classes.dex */
public class C10083g {
    /* renamed from: a */
    public static String m62844a(int i10) {
        switch (i10) {
            case 1:
                return VastAttribute.ERROR;
            case 2:
                return "int";
            case 3:
                return "float";
            case 4:
                return ExtractOWiFiHelper.STING_NODE;
            case 5:
                return "iso8601";
            case 6:
                return FaqConstants.DISABLE_HA_REPORT;
            case 7:
                return "false";
            case 8:
                return "null";
            case 9:
                return "new";
            case 10:
                return "(";
            case 11:
                return ")";
            case 12:
                return "{";
            case 13:
                return "}";
            case 14:
                return "[";
            case 15:
                return "]";
            case 16:
                return ",";
            case 17:
                return ":";
            case 18:
                return "ident";
            case 19:
                return "fieldName";
            case 20:
                return "EOF";
            case 21:
                return "Set";
            case 22:
                return "TreeSet";
            case 23:
                return "undefined";
            case 24:
                return ";";
            case 25:
                return ".";
            case 26:
                return "hex";
            default:
                return "Unknown";
        }
    }
}
