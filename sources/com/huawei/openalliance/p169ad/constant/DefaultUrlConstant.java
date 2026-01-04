package com.huawei.openalliance.p169ad.constant;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DefaultUrlConstant {
    private static final Map<String, Integer> DEFAULT_URL_MAPS;

    static {
        HashMap map = new HashMap();
        DEFAULT_URL_MAPS = map;
        map.put("analyticsServer", Integer.valueOf(C6849R.string.hiad_analyticsServer));
        map.put("eventServer", Integer.valueOf(C6849R.string.hiad_eventServer));
        map.put("adxServer", Integer.valueOf(C6849R.string.hiad_adxServer));
        map.put("adxServerFb", Integer.valueOf(C6849R.string.hiad_adxServerFb));
        map.put("configServer", Integer.valueOf(C6849R.string.hiad_configServer));
        map.put("dnkeeperServer", Integer.valueOf(C6849R.string.hiad_dnkeeperServer));
        map.put("amsServer", Integer.valueOf(C6849R.string.hiad_privacyServer));
        map.put("appDataServer", Integer.valueOf(C6849R.string.hiad_appDataServer));
        map.put("consentConfigServer", Integer.valueOf(C6849R.string.hiad_consentConfigServer));
        map.put("appInsListConfigServer", Integer.valueOf(C6849R.string.hiad_appInsListConfigServer));
        map.put("permissionServer", Integer.valueOf(C6849R.string.hiad_permissionServer));
        map.put("h5Server", Integer.valueOf(C6849R.string.haid_h5_content_server));
        map.put(UrlConstant.BASE_COMPLAIN_H5_URL, Integer.valueOf(C6849R.string.haid_complain_h5_server));
        map.put("analyticsServerTv", Integer.valueOf(C6849R.string.hiad_analyticsServerTv));
        map.put("adxServerTv", Integer.valueOf(C6849R.string.hiad_adxServerTv));
        map.put("adxServerFbTv", Integer.valueOf(C6849R.string.hiad_adxServerFbTv));
        map.put("eventServerTv", Integer.valueOf(C6849R.string.hiad_eventServerTv));
        map.put("configServerTv", Integer.valueOf(C6849R.string.hiad_configServerTv));
        map.put("amsServerTv", Integer.valueOf(C6849R.string.hiad_privacyServerTv));
        map.put("h5ServerTv", Integer.valueOf(C6849R.string.haid_h5_content_serverTv));
    }

    public static String getUrl(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Map<String, Integer> map = DEFAULT_URL_MAPS;
            if (map.containsKey(str) && C6982bz.m41148a(context).mo41175d()) {
                if (map.containsKey(str + AbstractC7806cz.m48149a(context))) {
                    str = str + AbstractC7806cz.m48149a(context);
                }
                return context.getString(map.get(str).intValue());
            }
        }
        return "";
    }
}
