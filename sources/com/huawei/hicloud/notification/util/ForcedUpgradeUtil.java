package com.huawei.hicloud.notification.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hicloud.account.p102ui.activity.StInvalidNotificationActivity;
import com.huawei.hicloud.bean.NotifyJumpInfo;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.ForcedUpgradeNotificationManager;
import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.ForceUpgradeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.ForcedUpgradeNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.UpgradeConfigLanguage;
import com.huawei.hicloud.notification.p106db.bean.UpgradeDetailContent;
import com.huawei.hicloud.notification.p106db.bean.UpgradeHomePageBar;
import com.huawei.hicloud.notification.p106db.bean.UpgradeJumpObject;
import com.huawei.hicloud.notification.p106db.bean.UpgradeNotifyBar;
import com.huawei.hicloud.notification.p106db.languageoperator.HiCloudUpgradeNoticeLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.UpgradeConfigLanguageOperator;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;

/* loaded from: classes6.dex */
public class ForcedUpgradeUtil {
    private static final ForcedUpgradeUtil INSTANCE = new ForcedUpgradeUtil();
    private static final int MAX_FAIL_RETRY = 2;
    private static final long MILLISECOND_DAY = 86400000;
    private static final long RETRY_INTERVAL = 5000;
    private static final String TAG = "ForcedUpgradeUtil";
    private boolean userCancelForcedUpgrade = false;
    private boolean forcedUpgradeIsShowing = false;
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.huawei.hicloud.notification.util.ForcedUpgradeUtil.1
        public C49661() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws SecurityException {
            if (intent == null || context == null) {
                NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, "intent or context is empty");
                return;
            }
            String strM1295q = C0209d.m1295q(context);
            boolean z10 = strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.STOCK_ACTIVE_POPUP_GUIDE_ACTIVITY)) || strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.STOCK_ACTIVE_ACTIVITY)) || strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY)) || strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.UPGRADE_EMPTY_ACTIVITY));
            if (!TextUtils.isEmpty(strM1295q) && z10) {
                NotifyLogger.m29915i(ForcedUpgradeUtil.TAG, "StockActive Activity");
                return;
            }
            NotifyLogger.m29915i(ForcedUpgradeUtil.TAG, "process upgrade broadcast");
            if ("com.huawei.hicloud.intent.action.UPGRADE_NOTICE".equals(intent.getAction())) {
                ForcedUpgradeUtil.this.processForcedUpgrade(context);
            } else if ("com.huawei.hicloud.intent.action.APP_BACKGROUND_TO_FOREGROUND".equals(intent.getAction())) {
                ForcedUpgradeUtil.this.processBackgroundToForeground(context);
            }
        }
    };

    /* renamed from: com.huawei.hicloud.notification.util.ForcedUpgradeUtil$1 */
    public class C49661 extends BroadcastReceiver {
        public C49661() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws SecurityException {
            if (intent == null || context == null) {
                NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, "intent or context is empty");
                return;
            }
            String strM1295q = C0209d.m1295q(context);
            boolean z10 = strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.STOCK_ACTIVE_POPUP_GUIDE_ACTIVITY)) || strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.STOCK_ACTIVE_ACTIVITY)) || strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY)) || strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.UPGRADE_EMPTY_ACTIVITY));
            if (!TextUtils.isEmpty(strM1295q) && z10) {
                NotifyLogger.m29915i(ForcedUpgradeUtil.TAG, "StockActive Activity");
                return;
            }
            NotifyLogger.m29915i(ForcedUpgradeUtil.TAG, "process upgrade broadcast");
            if ("com.huawei.hicloud.intent.action.UPGRADE_NOTICE".equals(intent.getAction())) {
                ForcedUpgradeUtil.this.processForcedUpgrade(context);
            } else if ("com.huawei.hicloud.intent.action.APP_BACKGROUND_TO_FOREGROUND".equals(intent.getAction())) {
                ForcedUpgradeUtil.this.processBackgroundToForeground(context);
            }
        }
    }

    /* renamed from: com.huawei.hicloud.notification.util.ForcedUpgradeUtil$2 */
    public class C49672 extends AbstractC12367d {
        final /* synthetic */ Context val$context;

        public C49672(Context context) {
            context = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM1295q = C0209d.m1295q(context);
            if (TextUtils.isEmpty(strM1295q)) {
                NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, "topActivity is null");
            } else if (strM1295q.startsWith("com.huawei.hidisk")) {
                ForcedUpgradeUtil.this.showAppDialog(context, true);
            } else {
                ForcedUpgradeUtil.this.showUpgradeDetailORAppDialog(context);
            }
        }
    }

    public class LanguageTask extends AbstractC12367d {
        private boolean isSuccess = true;
        private UpgradeConfigLanguage mLanguage;
        private ResourceDownLoadHolder mResultHolder;
        private String xmlPath;

        public LanguageTask(UpgradeConfigLanguage upgradeConfigLanguage, ResourceDownLoadHolder resourceDownLoadHolder) {
            this.mLanguage = upgradeConfigLanguage;
            this.mResultHolder = resourceDownLoadHolder;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11, types: [java.io.RandomAccessFile] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.io.RandomAccessFile] */
        /* JADX WARN: Type inference failed for: r0v8, types: [java.io.RandomAccessFile] */
        private void extractLanguageFile(String str) throws Throwable {
            StringBuilder sb2;
            NotifyLogger.m29915i(ForcedUpgradeUtil.TAG, "extractLanguageFile");
            ?? M1377a = C0213f.m1377a();
            InputStream inputStream = null;
            try {
                try {
                    InputStream inputStreamOpen = M1377a.getAssets().open("upgrade_config_strings.xml");
                    try {
                        if (inputStreamOpen == null) {
                            NotifyLogger.m29915i(ForcedUpgradeUtil.TAG, "language file inputStream is null");
                            if (inputStreamOpen != null) {
                                try {
                                    inputStreamOpen.close();
                                    return;
                                } catch (IOException e10) {
                                    NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, "IOException exception:" + e10.toString());
                                    return;
                                }
                            }
                            return;
                        }
                        RandomAccessFile randomAccessFileM63449o = C10278a.m63449o(str, "rw");
                        randomAccessFileM63449o.seek(0L);
                        byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
                        while (true) {
                            int i10 = inputStreamOpen.read(bArr);
                            if (i10 == -1) {
                                try {
                                    inputStreamOpen.close();
                                    randomAccessFileM63449o.close();
                                    return;
                                } catch (IOException e11) {
                                    e = e11;
                                    sb2 = new StringBuilder();
                                    sb2.append("IOException exception:");
                                    sb2.append(e.toString());
                                    NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, sb2.toString());
                                    return;
                                }
                            }
                            randomAccessFileM63449o.write(bArr, 0, i10);
                        }
                    } catch (IOException e12) {
                        e = e12;
                        inputStream = inputStreamOpen;
                        M1377a = 0;
                        NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, "open local language config fail msg:" + e.getMessage());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e13) {
                                e = e13;
                                sb2 = new StringBuilder();
                                sb2.append("IOException exception:");
                                sb2.append(e.toString());
                                NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, sb2.toString());
                                return;
                            }
                        }
                        if (M1377a != 0) {
                            M1377a.close();
                        }
                    } catch (Exception e14) {
                        e = e14;
                        inputStream = inputStreamOpen;
                        M1377a = 0;
                        NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, "extractLanguageFile exception:" + e.toString());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e15) {
                                e = e15;
                                sb2 = new StringBuilder();
                                sb2.append("IOException exception:");
                                sb2.append(e.toString());
                                NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, sb2.toString());
                                return;
                            }
                        }
                        if (M1377a != 0) {
                            M1377a.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStreamOpen;
                        M1377a = 0;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e16) {
                                NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, "IOException exception:" + e16.toString());
                                throw th;
                            }
                        }
                        if (M1377a != 0) {
                            M1377a.close();
                        }
                        throw th;
                    }
                } catch (IOException e17) {
                    e = e17;
                    M1377a = 0;
                } catch (Exception e18) {
                    e = e18;
                    M1377a = 0;
                } catch (Throwable th3) {
                    th = th3;
                    M1377a = 0;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            NotifyLogger.m29915i(ForcedUpgradeUtil.TAG, "LanguageTask call start");
            if (this.mLanguage == null) {
                NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, "LanguageTask language null");
                return;
            }
            this.isSuccess = false;
            ForcedUpgradeNotificationManager forcedUpgradeNotificationManager = new ForcedUpgradeNotificationManager();
            this.xmlPath = forcedUpgradeNotificationManager.getXmlPath();
            if (!TextUtils.isEmpty(this.mLanguage.getUrl())) {
                if ("upgrade_config_strings.xml".equals(this.mLanguage.getUrl())) {
                    extractLanguageFile(this.xmlPath);
                    this.isSuccess = true;
                } else {
                    C4896a c4896a = new C4896a(this.mLanguage.getUrl(), this.xmlPath, 0L);
                    for (int i10 = 0; i10 < 2; i10++) {
                        try {
                            NotifyUtil.downloadFileToPath(this.xmlPath, c4896a.getUrl(), c4896a);
                        } catch (C9721b e10) {
                            NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, "download language failed: " + e10.toString());
                            try {
                                Thread.sleep(5000L);
                            } catch (InterruptedException unused) {
                                NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, "LanguageTask sleep exception: " + e10.toString());
                            }
                        }
                        if (new File(this.xmlPath).exists()) {
                            NotifyLogger.m29915i(ForcedUpgradeUtil.TAG, "download language xml success");
                            this.isSuccess = true;
                            break;
                        }
                        continue;
                    }
                }
            }
            ForcedUpgradeUtil.this.clearLanguageDb();
            forcedUpgradeNotificationManager.parseLanguageXml(this.xmlPath, this.mLanguage);
            this.mResultHolder.setDownloadResult(this.isSuccess);
            NotifyLogger.m29915i(ForcedUpgradeUtil.TAG, "LanguageTask call end, isLanguageSuccess: " + this.isSuccess);
        }
    }

    public interface QueryUpdate {
        void onUpgrade(int i10);
    }

    public void clearLanguageDb() throws SQLException {
        new UpgradeConfigLanguageOperator().clear();
    }

    public static ForcedUpgradeUtil getInstance() {
        return INSTANCE;
    }

    private boolean isShowDetailORAppDialog(Context context) {
        String strM1295q = C0209d.m1295q(context);
        if (TextUtils.isEmpty(strM1295q)) {
            return true;
        }
        NotifyLogger.m29913d(TAG, "isShowDetailORAppDialog className = " + strM1295q);
        if (!strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.UPGRADE_EMPTY_ACTIVITY)) && !strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY)) && !strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.UPGRADE_POP_NOTIFICATION_ACTIVITY)) && !strM1295q.equals(AppUpdateActivity.class.getName())) {
            if (!strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY)) && !strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY)) && !strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY))) {
                if (!strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY)) && !strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY)) && !strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY)) && !strM1295q.equals(NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY))) {
                    return !strM1295q.equals(StInvalidNotificationActivity.class.getName());
                }
                NotifyLogger.m29913d(TAG, "Logout " + strM1295q + ", no need showDetailORAppDialog");
                return false;
            }
            NotifyLogger.m29913d(TAG, "Logout " + strM1295q + ", no need showDetailORAppDialog");
        }
        return false;
    }

    public void showAppDialog(Context context, boolean z10) {
        NotifyLogger.m29915i(TAG, "showAppDialog");
        String strM1295q = C0209d.m1295q(context);
        if (TextUtils.isEmpty(strM1295q)) {
            NotifyLogger.m29915i(TAG, "className is null ");
            return;
        }
        if (!getInstance().isAppForground(context) || this.userCancelForcedUpgrade) {
            NotifyLogger.m29916w(TAG, "not foreground, not show dialog");
            return;
        }
        if (!strM1295q.equals(NotifyConstants.Action.ACTION_MAIN_ACTIVITY)) {
            NotifyLogger.m29914e(TAG, "forgroundActivity Name is not main activity, className is:" + strM1295q);
            return;
        }
        int iM62274T = C10028c.m62182c0().m62274T();
        ForceUpgradeConfiguration conformsConfig = HiCloudForceUpgradeConfigManager.getInstance().getConformsConfig();
        if (iM62274T != 0) {
            conformsConfig = HiCloudForceUpgradeConfigManager.getInstance().getConformsConfig(iM62274T);
        }
        if (conformsConfig == null) {
            NotifyLogger.m29914e(TAG, "upgradeConfig is null, not need show.");
            return;
        }
        UpgradeHomePageBar homePage = conformsConfig.getHomePage();
        if (homePage == null) {
            NotifyLogger.m29914e(TAG, "homePage is null, not need show.");
            return;
        }
        ForcedUpgradeUtil forcedUpgradeUtil = getInstance();
        if (forcedUpgradeUtil.isForcedUpgradeIsShowing()) {
            NotifyLogger.m29914e(TAG, "empty force activity is showing.");
            return;
        }
        String contentString = forcedUpgradeUtil.getContentString(homePage.getHomepageTitle());
        String contentString2 = forcedUpgradeUtil.getContentString(homePage.getHomepageText());
        String contentString3 = forcedUpgradeUtil.getContentString(homePage.getHomepageButton());
        if (TextUtils.isEmpty(contentString) || TextUtils.isEmpty(contentString2) || TextUtils.isEmpty(contentString3)) {
            NotifyLogger.m29914e(TAG, "showUpgradeNotice title, message， button is empty");
            return;
        }
        if (!getInstance().isAppForground(context)) {
            NotifyLogger.m29916w(TAG, "not foreground, not show dialog");
            return;
        }
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction(NotifyConstants.Action.ACTION_UPGRADE_EMPTY_ACTIVITY);
        if (z10) {
            intent.putExtra("isFromFileManager", z10);
        }
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        context.startActivity(intent);
    }

    public void showUpgradeDetailORAppDialog(Context context) {
        NotifyLogger.m29915i(TAG, "showUpgradeDetailORAppDialog ");
        if (isShowDetailORAppDialog(context)) {
            showAppDialog(context, false);
        } else {
            NotifyLogger.m29914e(TAG, "isShowDetailORAppDialog: false");
        }
    }

    public boolean containsValue(String[] strArr, String str) {
        if (strArr != null && !TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getContentString(String str) {
        String currentLanguage = HNUtil.getCurrentLanguage();
        List<CommonLanguageDbString> listQueryString = new HiCloudUpgradeNoticeLanguageOperator().queryString(currentLanguage, HNUtil.getCurrentBaseLanguage(), HNConstants.Language.EN_STANDARD, str);
        if (listQueryString == null || listQueryString.size() <= 0) {
            NotifyLogger.m29914e(TAG, "getContentString no language configs,textName=" + str);
            return null;
        }
        CommonLanguageDbString commonLanguageDbString = null;
        CommonLanguageDbString commonLanguageDbString2 = null;
        for (CommonLanguageDbString commonLanguageDbString3 : listQueryString) {
            String language = commonLanguageDbString3.getLanguage();
            if (language == null) {
                NotifyLogger.m29914e(TAG, "tmpLanguageName null, stringId=" + str);
            } else if (language.equals(currentLanguage)) {
                commonLanguageDbString2 = commonLanguageDbString3;
            } else if (language.equals(HNConstants.Language.EN_STANDARD)) {
                commonLanguageDbString = commonLanguageDbString3;
            }
        }
        if (commonLanguageDbString != null) {
            listQueryString.remove(commonLanguageDbString);
        }
        if (commonLanguageDbString2 != null) {
            NotifyLogger.m29915i(TAG, "fullMatchString stringId=" + str);
            listQueryString.remove(commonLanguageDbString2);
            commonLanguageDbString = commonLanguageDbString2;
        } else if (listQueryString.size() > 0) {
            NotifyLogger.m29915i(TAG, "partMatch stringId=" + str);
            CommonLanguageDbString commonLanguageDbString4 = listQueryString.get(0);
            commonLanguageDbString = commonLanguageDbString4 != null ? commonLanguageDbString4 : null;
        } else {
            NotifyLogger.m29915i(TAG, "no match, using default stringId=" + str);
        }
        if (commonLanguageDbString != null) {
            return commonLanguageDbString.getValue();
        }
        return null;
    }

    public void initReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.intent.action.UPGRADE_NOTICE");
        intentFilter.addAction("com.huawei.hicloud.intent.action.APP_BACKGROUND_TO_FOREGROUND");
        C13108a.m78878b(context).m78880c(this.receiver, intentFilter);
    }

    public boolean isAppForground(Context context) throws SecurityException {
        boolean zM1185K1 = C0209d.m1185K1(context);
        boolean zM1245d1 = C0209d.m1245d1(context, NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.UPGRADE_POP_NOTIFICATION_ACTIVITY));
        boolean zM1245d12 = C0209d.m1245d1(context, NotifyConstants.getForcedUpgradeMapping().get(NotifyConstants.ActivityName.UPGRADE_EMPTY_ACTIVITY));
        boolean zM1245d13 = C0209d.m1245d1(context, AppUpdateActivity.class.getName());
        NotifyLogger.m29915i(TAG, "isAppForeground: " + zM1185K1 + "; isActivityForeground: " + zM1245d1 + "; isEmptyForeground: " + zM1245d12 + "; isAppUpdateForground: " + zM1245d13);
        return (!zM1185K1 || zM1245d1 || zM1245d12 || zM1245d13) ? false : true;
    }

    public boolean isForcedUpgradeIsShowing() {
        return this.forcedUpgradeIsShowing;
    }

    public void isShowForcedUpgrade() throws Throwable {
        new CheckAppStatus().checkUpgrade();
    }

    public boolean isUserCancelForcedUpgrade() {
        return this.userCancelForcedUpgrade;
    }

    public void parseUpgradeConfig(ForcedUpgradeNotifyConfig forcedUpgradeNotifyConfig) {
        UpgradeConfigLanguage upgradeConfigLanguage;
        if (forcedUpgradeNotifyConfig == null) {
            NotifyLogger.m29915i(TAG, "upgradeNotifyConfig null");
            return;
        }
        NotifyLogger.m29915i(TAG, "parseUpgradeConfig");
        try {
            upgradeConfigLanguage = forcedUpgradeNotifyConfig.getUpgradeConfigLanguage();
        } catch (Exception unused) {
            NotifyLogger.m29914e(TAG, "parseUpgradeConfig end");
        }
        if (upgradeConfigLanguage == null) {
            NotifyLogger.m29914e(TAG, "language null");
            C10028c.m62182c0().m62254O1();
            return;
        }
        ResourceDownLoadHolder resourceDownLoadHolder = new ResourceDownLoadHolder();
        int iM62189B = C10028c.m62182c0().m62189B("language_version");
        String strM62184A = C10028c.m62182c0().m62184A("language_hash");
        NotifyLogger.m29915i(TAG, "current language version is: " + iM62189B + ", OM file language version is: " + upgradeConfigLanguage.getVersion() + "current language Hash is: " + strM62184A + ", OM file language Hash is: " + upgradeConfigLanguage.getHash());
        if (iM62189B == 0 || TextUtils.isEmpty(upgradeConfigLanguage.getHash()) || (iM62189B < upgradeConfigLanguage.getVersion() && !TextUtils.equals(strM62184A, upgradeConfigLanguage.getHash()))) {
            C12515a.m75110o().m75172d(new LanguageTask(upgradeConfigLanguage, resourceDownLoadHolder));
        } else {
            resourceDownLoadHolder.setDownloadResult(true);
        }
        NotifyLogger.m29915i(TAG, "parseUpgradeConfig end");
    }

    public Intent parseUpgradeGoto(Context context, UpgradeJumpObject upgradeJumpObject, UpgradeDetailContent upgradeDetailContent) {
        Intent intent = new Intent();
        if ("application".equals(upgradeJumpObject.getType())) {
            if ("main".equals(upgradeJumpObject.getUrl())) {
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.setAction(NotifyConstants.Action.ACTION_MAIN_ACTIVITY);
            } else if ("detail".equals(upgradeJumpObject.getUrl())) {
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.setAction(NotifyConstants.Action.ACTION_FORCE_UPGRADE_ACTIVITY);
                intent.putExtra("upgrade_notify_detail_key", upgradeDetailContent);
            }
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        } else if ("web".equals(upgradeJumpObject.getType())) {
            Uri uri = Uri.parse(upgradeJumpObject.getUrl());
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
        }
        return intent;
    }

    public void processAppForegroundShow(Context context) {
        NotifyLogger.m29915i(TAG, "processAppForegroundShow");
        if (isAppForground(context)) {
            String strM1295q = C0209d.m1295q(context);
            if (TextUtils.isEmpty(strM1295q)) {
                NotifyLogger.m29914e(TAG, "topActivity is null");
            } else if (strM1295q.startsWith("com.huawei.hidisk")) {
                showAppDialog(context, true);
            } else {
                showUpgradeDetailORAppDialog(context);
            }
        }
    }

    public void processBackgroundToForeground(Context context) throws SecurityException {
        NotifyLogger.m29915i(TAG, "processBackgroundToForeground");
        if (!C10028c.m62182c0().m62380q1() && !C10028c.m62182c0().m62320e1()) {
            NotifyLogger.m29915i(TAG, "no need processBackgroundToForeground");
            return;
        }
        boolean zM1245d1 = C0209d.m1245d1(context, NotifyConstants.Action.ACTION_MAIN_ACTIVITY);
        NotifyLogger.m29915i(TAG, "isActivityForeground: " + zM1245d1);
        if (zM1245d1) {
            C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.hicloud.notification.util.ForcedUpgradeUtil.2
                final /* synthetic */ Context val$context;

                public C49672(Context context2) {
                    context = context2;
                }

                @Override // p616rk.AbstractRunnableC12516b
                public void call() {
                    String strM1295q = C0209d.m1295q(context);
                    if (TextUtils.isEmpty(strM1295q)) {
                        NotifyLogger.m29914e(ForcedUpgradeUtil.TAG, "topActivity is null");
                    } else if (strM1295q.startsWith("com.huawei.hidisk")) {
                        ForcedUpgradeUtil.this.showAppDialog(context, true);
                    } else {
                        ForcedUpgradeUtil.this.showUpgradeDetailORAppDialog(context);
                    }
                }
            });
        }
    }

    public void processForcedUpgrade(Context context) {
        NotifyUtil.sendForceUpgradeBroadcast();
    }

    public void setForcedUpgradeIsShowing(boolean z10) {
        this.forcedUpgradeIsShowing = z10;
    }

    public void setUserCancelForcedUpgrade(boolean z10) {
        this.userCancelForcedUpgrade = z10;
    }

    public void showUpgradeNotice(Context context, long j10, UpgradeNotifyBar upgradeNotifyBar) {
        NotifyLogger.m29915i(TAG, "show upgrade notice");
        if (upgradeNotifyBar == null) {
            NotifyLogger.m29914e(TAG, "noticeContent is null");
            return;
        }
        if (C0209d.m1241c1()) {
            NotifyLogger.m29914e(TAG, "cloud activity is foreground, not show notice");
            return;
        }
        int iM62414x0 = C10028c.m62183d0(context).m62414x0("notice_times");
        if (upgradeNotifyBar.getNumber() != 0 && iM62414x0 >= upgradeNotifyBar.getNumber()) {
            NotifyLogger.m29915i(TAG, "showUpgradeNotice over limit times");
            return;
        }
        float dayonce = upgradeNotifyBar.getDayonce();
        String contentString = getContentString(upgradeNotifyBar.getNotifyBarTitle());
        String contentString2 = getContentString(upgradeNotifyBar.getNotifyBarText());
        NotifyJumpInfo notifyJumpInfo = upgradeNotifyBar.getNotifyJumpInfo();
        if (TextUtils.isEmpty(contentString) || TextUtils.isEmpty(contentString2)) {
            NotifyLogger.m29914e(TAG, "showUpgradeNotice title, mainText");
            return;
        }
        if (System.currentTimeMillis() - j10 < 8.64E7f * dayonce) {
            NotifyLogger.m29915i(TAG, "no need to show showUpgradeNotice, lastNoticeTime: " + j10 + ", frequency: " + dayonce);
            return;
        }
        NotifyLogger.m29915i(TAG, "showUpgradeNotice, lastNoticeTime: " + j10 + ", frequency: " + dayonce);
        new HiCloudNotificationManager(context.getApplicationContext()).sendForcedUpgradeNotification(context.getApplicationContext(), contentString, contentString2, notifyJumpInfo);
    }

    public void unregisterReceiver(Context context) {
        if (this.receiver != null) {
            C13108a.m78878b(context).m78883f(this.receiver);
        }
    }

    public static class ResourceDownLoadHolder {
        private boolean mResult;

        private ResourceDownLoadHolder() {
            this.mResult = false;
        }

        public boolean getResult() {
            return this.mResult;
        }

        public void setDownloadResult(boolean z10) {
            this.mResult = z10;
        }

        public /* synthetic */ ResourceDownLoadHolder(C49661 c49661) {
            this();
        }
    }
}
