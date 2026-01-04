package com.huawei.openalliance.p169ad.constant;

import android.text.TextUtils;
import com.baidu.location.p065a.C1529a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class CountryConfig {
    private static final List<String> ALL = Arrays.asList("AX", "AL", "DZ", "AS", "AD", "AI", "AG", "AR", "AM", "AW", "AU", "AT", "AZ", "BH", "BB", "BY", "BE", "BZ", "BD", "BJ", "BM", "BT", "BO", "BA", "BW", "BR", "BN", "BG", "BF", "BI", "KH", "CM", "CA", "KY", "CF", "TD", "CL", "CX", "CC", "CO", "KM", "CG", "CD", "CK", "CR", "CI", "HR", "CY", "CZ", "DK", "DJ", "DM", "EC", "EG", "SV", "GQ", "EE", "ET", "FK", "FO", "FI", "FR", "GF", "PF", "GA", "GM", "GE", "DE", "GH", "GI", "GR", "GL", "GD", "GP", "GU", "GT", "GG", "GN", "GW", "GY", "HT", "VA", "HN", "HU", "IS", FaqConstants.OPEN_TYPE_IN, "ID", "IE", "IM", "IL", "IT", "JM", "JP", "JE", "JO", "KZ", "KE", "KI", "KR", "YK", "KW", "KG", "LA", "LV", "LB", "LS", "LR", "LI", "LT", "LU", "MG", "MW", "MY", "MV", "ML", "MT", "MH", "MQ", "MR", "MU", "YT", "MX", "FM", "MD", "MC", "MN", "ME", "MS", "MA", "MZ", "MM", HNConstants.DataType.f22634NA, "NR", "NP", "NL", "AN", "NC", "NZ", "NI", "NE", CloudBackupConstant.UserPackageInfo.FULL_DATA_SERVICE_200GB, "NU", "NF", "MP", "NO", "OM", "PK", "PW", "PS", TradeMode.f32145PA, "PG", "PY", "PE", "PH", "PN", "PL", "PT", "PR", "QA", "RO", "RU", "RW", "BL", "SH", "KN", "LC", "MF", "VC", C1529a.f6584j, "SM", "ST", "SA", "SN", "RS", "SC", "SL", "SG", "SX", "SK", "SI", "SB", "SO", "ZA", "SS", "ES", "LK", "SR", "SZ", "SE", "CH", "TJ", "TZ", "TH", "BS", "AE", "TL", "TG", "TK", "TO", "TT", "TN", "TR", "TM", "TC", "TV", "UG", "UA", "GB", "UY", "UZ", "VU", "VE", "VN", "VG", "VI", "WF", "YE", "ZM", "ZW", "US", "AO", "AF", "LY", "IQ", "CV", "ER", "HK", "MO", "MK", "PM", "SJ", "TW", "IC", "BQ", "RE", "EA", "FJ", "PM", "DO");
    private static final List<String> DR1 = Arrays.asList("CN");
    private static final List<String> DR2 = Arrays.asList("AE", "AF", "AG", "AI", "AM", "AO", "AR", "AS", "AW", "AZ", "BB", "BD", "BF", "BH", "BI", "BJ", "BL", "BM", "BN", "BO", "BR", "BS", "BT", "BW", "BY", "BZ", "CC", "CD", "CG", "CI", "CK", "CL", "CM", "CO", "CR", "CV", "CX", "DJ", "DM", "DO", "DZ", "EC", "EG", "ER", "ET", "FJ", "FM", "GA", "GD", "GE", "GF", "GH", "GM", "GN", "GP", "GQ", "GT", "GU", "GW", "GY", "HK", "HN", "HT", "ID", FaqConstants.OPEN_TYPE_IN, "IQ", "JM", "JO", "KE", "KG", "KH", "KI", "KM", "KN", "KW", "KY", "KZ", "LA", "LB", "LC", "LK", "LR", "LS", "LY", "MA", "MG", "MH", "ML", "MM", "MN", "MO", "MP", "MQ", "MR", "MS", "MU", "MV", "MW", "MX", "MY", "MZ", HNConstants.DataType.f22634NA, "NC", "NE", "NF", CloudBackupConstant.UserPackageInfo.FULL_DATA_SERVICE_200GB, "NI", "NP", "NR", "NU", "OM", TradeMode.f32145PA, "PE", "PF", "PG", "PH", "PK", "PN", "PR", "PS", "PW", "PY", "QA", "RE", "RW", "SA", "SB", "SC", "SG", "SL", "SN", "SO", "SR", "SS", "ST", "SV", "SZ", "TC", "TD", "TG", "TH", "TJ", "TK", "TL", "TM", "TN", "TO", "TT", "TV", "TW", "TZ", "UG", "UY", "UZ", "VG", "VI", "VN", "VU", "WF", C1529a.f6584j, "YT", "ZA", "ZM", "ZW", "JP", "KR");
    private static final List<String> DR3 = Arrays.asList("AD", "AL", "AT", "AU", "BA", "BE", "BG", "BQ", "CA", "CH", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FO", "FR", "GB", "GI", "GL", "GR", "HR", "HU", "IE", "IL", "IS", "IT", "UA", "VC", "LI", "LT", "LU", "LV", "MC", "MD", "ME", "MK", "MT", "NL", "NO", "NZ", "PL", "PT", "RO", "RS", "SE", "SI", "SK", "SM", "SX", "TR");
    private static final List<String> DR4 = Arrays.asList("RU");
    private static final String TAG = "CountryConfig";

    private static String getConfigCountry(String[] strArr, int i10) {
        if (strArr == null) {
            return null;
        }
        if (i10 < strArr.length) {
            return strArr[i10];
        }
        AbstractC7185ho.m43826d(TAG, "index is out of array, index: " + i10);
        return null;
    }

    public static boolean isDR1(String str, String[] strArr) {
        return isInDR(str, strArr, 0, DR1);
    }

    public static boolean isDR2(String str, String[] strArr) {
        return isInDR(str, strArr, 1, DR2);
    }

    public static boolean isDR3(String str, String[] strArr) {
        return isInDR(str, strArr, 2, DR3);
    }

    public static boolean isDR4(String str, String[] strArr) {
        return isInDR(str, strArr, 3, DR4);
    }

    private static boolean isInDR(String str, String[] strArr, int i10, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43826d(TAG, "countryCode is empty");
            return false;
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        String configCountry = getConfigCountry(strArr, i10);
        if (!AbstractC7806cz.m48165b(configCountry)) {
            list = Arrays.asList(configCountry.split(","));
        }
        return list.contains(upperCase);
    }

    public static boolean isValidCountryCode(String str) {
        return ALL.contains(AbstractC7806cz.m48183l(str));
    }
}
