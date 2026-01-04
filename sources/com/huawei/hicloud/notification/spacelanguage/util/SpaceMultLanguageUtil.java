package com.huawei.hicloud.notification.spacelanguage.util;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.spacelanguage.bean.SpaceMultLanguageConfig;
import com.huawei.hicloud.notification.spacelanguage.bean.SpaceMultLanguageString;
import com.huawei.hicloud.notification.spacelanguage.manager.SpaceMultLanguageManager;
import com.huawei.hicloud.notification.spacelanguage.operator.SpaceMultLanguageOperator;
import gp.C10028c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;

/* loaded from: classes6.dex */
public class SpaceMultLanguageUtil {
    private static final String NAME_KEY = "@null";
    private static final String TAG = "SpaceMultLanguageUtil";

    public static void clearConfig(Context context, String str) {
        boolean zDelete;
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists() || (zDelete = file.delete())) {
                return;
            }
            NotifyLogger.m29914e(TAG, "clearConfig " + str + " is:" + zDelete);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clearConfig " + str + " exception:" + e10.toString());
        }
    }

    public static String formatString(String str, Object... objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "formatSring err:" + e10.toString());
            return str;
        }
    }

    private static String getSpaceDefaultStr(String str) {
        try {
            NotifyLogger.m29915i(TAG, "getSpaceDefaultStr " + str + " use defaultStr");
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                NotifyLogger.m29914e(TAG, "getSpaceDefaultStr context is null.");
                return "";
            }
            Integer num = CloudSpaceNotifyUtil.getInstance().getSpaceProxy().getSpaceLanguageMap().get(str);
            return num != null ? contextM1377a.getString(num.intValue()) : "";
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getSpaceDefaultStr  error " + e10);
            return "";
        }
    }

    public static String getSpaceMultLanguage(String str) {
        String str2 = "@null/" + str;
        NotifyLogger.m29915i(TAG, "getSpaceMultLanguage language ,name = " + str2);
        if (!SpaceMultLanguageManager.getInstance().checkConfigExistAndDownload()) {
            NotifyLogger.m29914e(TAG, "getSpaceMultLanguageConfig not exit ,name = " + str2);
            return getSpaceDefaultStr(str2);
        }
        String strM1631i = C0234s.m1631i();
        String currentBaseLanguage = HNUtil.getCurrentBaseLanguage();
        if (TextUtils.isEmpty(strM1631i)) {
            NotifyLogger.m29914e(TAG, "getSpaceMultLanguage language null,name = " + str2);
            return getSpaceDefaultStr(str2);
        }
        SpaceMultLanguageOperator spaceMultLanguageOperator = new SpaceMultLanguageOperator();
        SpaceMultLanguageString spaceMultLanguageStringQueryLanguageValue = spaceMultLanguageOperator.queryLanguageValue(strM1631i, str2);
        if (spaceMultLanguageStringQueryLanguageValue == null) {
            NotifyLogger.m29915i(TAG, "getSpaceMultLanguage cannot find by countryLanguage=" + strM1631i + ",query by language = " + currentBaseLanguage + ",name = " + str2);
            spaceMultLanguageStringQueryLanguageValue = spaceMultLanguageOperator.queryLanguageValueByLanguage(currentBaseLanguage, str2);
        }
        if (spaceMultLanguageStringQueryLanguageValue != null) {
            String value = spaceMultLanguageStringQueryLanguageValue.getValue();
            return TextUtils.isEmpty(value) ? getSpaceDefaultStr(str2) : value;
        }
        NotifyLogger.m29914e(TAG, "getSpaceMultLanguage result is null.name = " + str2);
        return getSpaceDefaultStr(str2);
    }

    public static SpaceMultLanguageConfig readConfigFromJson(String str) throws IOException {
        SpaceMultLanguageConfig spaceMultLanguageConfig;
        Exception e10;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                spaceMultLanguageConfig = (SpaceMultLanguageConfig) new Gson().fromJson(C0209d.m1290o2(fileInputStream), SpaceMultLanguageConfig.class);
            } finally {
            }
        } catch (Exception e11) {
            spaceMultLanguageConfig = null;
            e10 = e11;
        }
        try {
            fileInputStream.close();
        } catch (Exception e12) {
            e10 = e12;
            NotifyLogger.m29914e(TAG, "cloud config file not exitst, msg:" + e10.getMessage());
            return spaceMultLanguageConfig;
        }
        return spaceMultLanguageConfig;
    }

    public static void saveLanguageDownloadingFlag(boolean z10) {
        C10028c.m62182c0().m62213F3(z10);
    }
}
