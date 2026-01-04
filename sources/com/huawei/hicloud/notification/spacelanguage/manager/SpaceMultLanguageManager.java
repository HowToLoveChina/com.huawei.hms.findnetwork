package com.huawei.hicloud.notification.spacelanguage.manager;

import android.content.Context;
import android.database.SQLException;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.spacelanguage.bean.SpaceMultLanguageConfig;
import com.huawei.hicloud.notification.spacelanguage.operator.SpaceMultLanguageOperator;
import com.huawei.hicloud.notification.spacelanguage.task.HiCloudSpaceMultLanguageTask;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import java.io.File;
import p015ak.C0209d;
import p015ak.C0213f;
import p459lp.C11327e;
import p616rk.C12515a;
import p742wj.C13612b;

/* loaded from: classes6.dex */
public class SpaceMultLanguageManager {
    private static final SpaceMultLanguageManager INSTANCE = new SpaceMultLanguageManager();
    private static final String TAG = "SpaceMultLanguageManager";

    private SpaceMultLanguageManager() {
    }

    public static SpaceMultLanguageManager getInstance() {
        return INSTANCE;
    }

    public boolean checkConfigExistAndDownload() throws SQLException {
        NotifyLogger.m29915i(TAG, "checkConfigExistAndDownload");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "checkConfigExistAndDownload context is null.");
            return false;
        }
        SpaceMultLanguageOperator spaceMultLanguageOperator = new SpaceMultLanguageOperator();
        if (!new File(contextM1377a.getFilesDir() + "/space_mult_language.json").exists()) {
            C11327e.m68059b("HiCloudSpaceMultLanguage");
            getInstance().processOMConfig();
            return false;
        }
        if (spaceMultLanguageOperator.hasRecord()) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "file exist but no language in db");
        C11327e.m68059b("HiCloudSpaceMultLanguage");
        getInstance().clearConfigAndDB(contextM1377a);
        getInstance().processOMConfig();
        return false;
    }

    public void checkLanguageDataBase() {
        NotifyLogger.m29915i(TAG, "checkLanguageDataBase");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "checkLanguageDataBase, context is null");
            return;
        }
        String str = (contextM1377a.getFilesDir() + "/") + RecommendCardConstants.spaceLanguage.SPACE_MULT_LANGUAGE_XML_NAME_CLOUD;
        File file = new File(str);
        SpaceMultLanguageOperator spaceMultLanguageOperator = new SpaceMultLanguageOperator();
        if (!file.exists() || spaceMultLanguageOperator.hasRecord()) {
            return;
        }
        NotifyLogger.m29915i(TAG, "checkLanguageDataBase, need parse SpaceMultLanguage LanguageXml");
        SpaceMultLanguageDownloader.parseLanguageXml(contextM1377a, str, RecommendCardConstants.spaceLanguage.SPACE_MULT_LANGUAGE_XML_NAME_CLOUD);
    }

    public void clearConfigAndDB(Context context) throws SQLException {
        if (context == null) {
            NotifyLogger.m29915i(TAG, "clearConfigAndDB context is null.");
            return;
        }
        SpaceMultLanguageUtil.clearConfig(context, "space_mult_language.json");
        SpaceMultLanguageUtil.clearConfig(context, RecommendCardConstants.spaceLanguage.SPACE_MULT_LANGUAGE_XML_NAME_CLOUD);
        new SpaceMultLanguageOperator().clearDB();
    }

    public boolean getDataCount() {
        int dataCount = new SpaceMultLanguageOperator().getDataCount();
        NotifyLogger.m29915i(TAG, "getDataCount count = " + dataCount);
        return dataCount > 0;
    }

    public SpaceMultLanguageConfig getSpaceMultLanguageFromFile() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "getSpaceMultLanguageConfigFromFile context is null.");
            return null;
        }
        String str = contextM1377a.getFilesDir() + "/";
        new File(str + RecommendCardConstants.spaceLanguage.SPACE_MULT_LANGUAGE_XML_NAME_CLOUD);
        return SpaceMultLanguageUtil.readConfigFromJson(str + "space_mult_language.json");
    }

    public void processOMConfig() {
        if (C13612b.m81829B().isLogin()) {
            startDownloadTask();
        } else {
            NotifyLogger.m29915i(TAG, "processOMConfig user not login.");
        }
    }

    public void startDownloadTask() {
        NotifyLogger.m29915i(TAG, "startDownloadTask");
        if (!C0209d.m1333z1(C0213f.m1377a())) {
            NotifyLogger.m29915i(TAG, "startDownloadTask no network");
        } else {
            C12515a.m75110o().m75172d(new HiCloudSpaceMultLanguageTask(1));
        }
    }
}
