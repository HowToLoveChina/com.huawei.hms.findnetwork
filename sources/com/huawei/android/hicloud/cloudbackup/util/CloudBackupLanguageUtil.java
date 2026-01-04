package com.huawei.android.hicloud.cloudbackup.util;

import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.bean.BackupAppLanguageDbString;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.List;
import java.util.Locale;
import p514o9.C11839m;
import p526ol.C11960a;
import p617rl.C12519c;

/* loaded from: classes2.dex */
public class CloudBackupLanguageUtil {
    private static final String TAG = "CloudBackupLanguageUtil";

    public static String getString(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String currentLanguage = HNUtil.getCurrentLanguage();
        String currentBaseLanguage = HNUtil.getCurrentBaseLanguage();
        C11960a c11960a = new C11960a();
        C11839m.m70686d(TAG, "countryLanguage: " + currentLanguage + "baseLanguage: " + currentBaseLanguage);
        List<BackupAppLanguageDbString> listM71939d = c11960a.m71939d(currentLanguage, currentBaseLanguage, HNConstants.Language.EN_STANDARD, str);
        if (listM71939d.isEmpty()) {
            C11839m.m70689w(TAG, "no language in cloud backup configs, string id = " + str);
            return "";
        }
        BackupAppLanguageDbString backupAppLanguageDbString = null;
        BackupAppLanguageDbString backupAppLanguageDbString2 = null;
        for (BackupAppLanguageDbString backupAppLanguageDbString3 : listM71939d) {
            String languageName = backupAppLanguageDbString3.getLanguageName();
            if (languageName == null) {
                C11839m.m70689w(TAG, "language name is null, string id = " + str);
            } else if (languageName.equals(currentLanguage)) {
                backupAppLanguageDbString = backupAppLanguageDbString3;
            } else if (languageName.equals(HNConstants.Language.EN_STANDARD)) {
                backupAppLanguageDbString2 = backupAppLanguageDbString3;
            }
        }
        if (backupAppLanguageDbString == null) {
            listM71939d.remove(backupAppLanguageDbString2);
            if (listM71939d.size() > 0) {
                C11839m.m70686d(TAG, String.format(Locale.ENGLISH, "part match string id = %s,part match string : %s", str, new Gson().toJson(listM71939d)));
                BackupAppLanguageDbString backupAppLanguageDbString4 = listM71939d.get(0);
                if (backupAppLanguageDbString4 != null) {
                    backupAppLanguageDbString = backupAppLanguageDbString4;
                }
            } else {
                C11839m.m70686d(TAG, "no match, using default string id=" + str);
                backupAppLanguageDbString = backupAppLanguageDbString2;
            }
        }
        return backupAppLanguageDbString != null ? backupAppLanguageDbString.getTextValue() : "";
    }

    public static String getVirtualName(String str) {
        return getString(new C12519c().m75298i(str));
    }
}
