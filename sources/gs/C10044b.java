package gs;

import com.baidu.location.p065a.C1529a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.openalliance.p169ad.constant.TradeMode;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* renamed from: gs.b */
/* loaded from: classes8.dex */
public class C10044b {

    /* renamed from: a */
    public static final List<String> f49010a = Arrays.asList("CN");

    /* renamed from: b */
    public static final List<String> f49011b = Arrays.asList("AE", "AF", "AG", "AI", "AM", "AO", "AQ", "AR", "AS", "AW", "AZ", "BB", "BD", "BF", "BH", "BI", "BJ", "BL", "BM", "BN", "BO", "BR", "BS", "BT", "BV", "BW", "BY", "BZ", "CC", "CD", "CF", "CG", "CI", "CK", "CL", "CM", "CO", "CR", "CU", "CV", "CX", "DJ", "DM", "DO", "DZ", "EC", "EG", "EH", "ER", "ET", "FJ", "FK", "FM", "GA", "GD", "GE", "GF", "GH", "GM", "GN", "GP", "GQ", "GS", "GT", "GU", "GW", "GY", "HK", "HM", "HN", "HT", "ID", FaqConstants.OPEN_TYPE_IN, "IO", "IQ", "JM", "JO", "JP", "KE", "KG", "KH", "KI", "KM", "KN", "KP", "KR", "KW", "KY", "KZ", "LA", "LB", "LC", "LK", "LR", "LS", "LY", "MA", "MG", "MH", "ML", "MM", "MN", "MO", "MP", "MQ", "MR", "MS", "MU", "MV", "MW", "MX", "MY", "MZ", HNConstants.DataType.f22634NA, "NC", "NE", "NF", CloudBackupConstant.UserPackageInfo.FULL_DATA_SERVICE_200GB, "NI", "NP", "NR", "NU", "OM", TradeMode.f32145PA, "PE", "PF", "PG", "PH", "PK", "PN", "PR", "PS", "PW", "PY", "QA", "RE", "RW", "SA", "SB", "SC", "SD", "SG", "SH", "SL", "SN", "SO", "SR", "SS", "ST", "SV", "SY", "SZ", "TC", "TD", "TF", "TG", "TH", "TJ", "TK", "TL", "TM", "TN", "TO", "TT", "TV", "TW", "TZ", "UG", "UY", "UZ", "VE", "VG", "VI", "VN", "VU", "WF", C1529a.f6584j, "YE", "YT", "ZA", "ZM", "ZW");

    /* renamed from: c */
    public static final List<String> f49012c = Arrays.asList("AD", "AL", "AN", "AT", "AU", "AX", "BA", "BE", "BG", "BQ", "CA", "CH", "CW", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FO", "FR", "GB", "GG", "GI", "GL", "GR", "HR", "HU", "IE", "IL", "IM", "IS", "IT", "JE", "LI", "LT", "LU", "LV", "MC", "MD", "ME", "MF", "MK", "MT", "NL", "NO", "NZ", "PL", "PM", "PT", "RO", "RS", "SE", "SI", "SJ", "SK", "SM", "SX", "TR", "UA", "UM", "US", "VA", "VC", "XK", "YK", "EU");

    /* renamed from: d */
    public static final List<String> f49013d = Arrays.asList("RU");

    /* renamed from: a */
    public static boolean m62450a(String str) {
        if (!C10043a.m62449b(str)) {
            return false;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        return f49010a.contains(upperCase) || f49011b.contains(upperCase) || f49012c.contains(upperCase) || f49013d.contains(upperCase);
    }
}
