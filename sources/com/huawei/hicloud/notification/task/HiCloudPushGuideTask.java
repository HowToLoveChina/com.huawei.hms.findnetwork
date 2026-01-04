package com.huawei.hicloud.notification.task;

import android.text.TextUtils;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.constants.HicloudPushGuideConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HicloudPushGuideManager;
import com.huawei.hicloud.notification.p106db.bean.HiCloudPushGuideLanguage;
import com.huawei.hicloud.notification.p106db.bean.HicloudPushGuideConfig;
import com.huawei.hicloud.notification.p106db.bean.HicloudPushGuideConfigurations;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5025s;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import p015ak.C0213f;
import p292fn.C9734g;
import p459lp.C11327e;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class HiCloudPushGuideTask extends AbstractC12367d {
    private static final int MAX_FAIL_RETRY = 2;
    private static final long RETRY_INTERVAL = 5000;
    private static final String TAG = "HiCloudPushGuideTask";
    private C5025s mHiCloudPushGuideService;

    public static class DownLoadLanguageTask extends AbstractC12367d {
        private boolean isSuccess = true;
        private HiCloudPushGuideLanguage mLanguage;
        private ResourceDownLoadHolder mResultHolder;
        private String xmlPath;

        public DownLoadLanguageTask(HiCloudPushGuideLanguage hiCloudPushGuideLanguage, ResourceDownLoadHolder resourceDownLoadHolder) {
            this.mLanguage = hiCloudPushGuideLanguage;
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
            NotifyLogger.m29915i(HiCloudPushGuideTask.TAG, "pushguideconfig extractLanguageFile");
            ?? M1377a = C0213f.m1377a();
            InputStream inputStream = null;
            try {
                try {
                    InputStream inputStreamOpen = M1377a.getAssets().open(HicloudPushGuideConstants.LANGUAGE_PACKAGE_NAME);
                    try {
                        if (inputStreamOpen == null) {
                            NotifyLogger.m29915i(HiCloudPushGuideTask.TAG, "pushguide language file inputStream is null");
                            if (inputStreamOpen != null) {
                                try {
                                    inputStreamOpen.close();
                                    return;
                                } catch (IOException e10) {
                                    NotifyLogger.m29914e(HiCloudPushGuideTask.TAG, "pushguide IOException exception:" + e10.toString());
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
                                    sb2.append("pushguide IOException exception:");
                                    sb2.append(e.toString());
                                    NotifyLogger.m29914e(HiCloudPushGuideTask.TAG, sb2.toString());
                                    return;
                                }
                            }
                            randomAccessFileM63449o.write(bArr, 0, i10);
                        }
                    } catch (IOException e12) {
                        e = e12;
                        inputStream = inputStreamOpen;
                        M1377a = 0;
                        NotifyLogger.m29914e(HiCloudPushGuideTask.TAG, "pushguide open local language config fail msg:" + e.getMessage());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e13) {
                                e = e13;
                                sb2 = new StringBuilder();
                                sb2.append("pushguide IOException exception:");
                                sb2.append(e.toString());
                                NotifyLogger.m29914e(HiCloudPushGuideTask.TAG, sb2.toString());
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
                        NotifyLogger.m29914e(HiCloudPushGuideTask.TAG, "pushguide extractLanguageFile exception:" + e.toString());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e15) {
                                e = e15;
                                sb2 = new StringBuilder();
                                sb2.append("pushguide IOException exception:");
                                sb2.append(e.toString());
                                NotifyLogger.m29914e(HiCloudPushGuideTask.TAG, sb2.toString());
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
                                NotifyLogger.m29914e(HiCloudPushGuideTask.TAG, "pushguide IOException exception:" + e16.toString());
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
            NotifyLogger.m29915i(HiCloudPushGuideTask.TAG, "pushguide LanguageTask call start");
            if (this.mLanguage == null) {
                NotifyLogger.m29914e(HiCloudPushGuideTask.TAG, "pushguide LanguageTask language null");
                return;
            }
            this.isSuccess = false;
            this.xmlPath = HicloudPushGuideManager.getInstance().getXmlPath();
            if (!TextUtils.isEmpty(this.mLanguage.getUrl())) {
                if (HicloudPushGuideConstants.LANGUAGE_PACKAGE_NAME.equals(this.mLanguage.getUrl())) {
                    extractLanguageFile(this.xmlPath);
                    this.isSuccess = true;
                } else {
                    C4896a c4896a = new C4896a(this.mLanguage.getUrl(), this.xmlPath, 0L);
                    for (int i10 = 0; i10 < 2; i10++) {
                        try {
                            NotifyUtil.downloadFileToPath(this.xmlPath, c4896a.getUrl(), c4896a);
                        } catch (C9721b e10) {
                            NotifyLogger.m29914e(HiCloudPushGuideTask.TAG, "pushguide download language failed: " + e10.toString());
                            try {
                                Thread.sleep(5000L);
                            } catch (InterruptedException unused) {
                                NotifyLogger.m29914e(HiCloudPushGuideTask.TAG, "pushguide LanguageTask sleep exception: " + e10.toString());
                            }
                        }
                        if (new File(this.xmlPath).exists()) {
                            NotifyLogger.m29915i(HiCloudPushGuideTask.TAG, "pushguide download language xml success");
                            this.isSuccess = true;
                            break;
                        }
                        continue;
                    }
                }
            }
            HicloudPushGuideManager.getInstance().clearLanguageDb();
            HicloudPushGuideManager.getInstance().parseHicoudPushGuideLanguageXml(this.xmlPath, this.mLanguage);
            this.mResultHolder.setDownloadResult(this.isSuccess);
            NotifyLogger.m29915i(HiCloudPushGuideTask.TAG, "pushguide LanguageTask call end, isLanguageSuccess: " + this.isSuccess);
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
    }

    private void extractConfig() {
        HicloudPushGuideConfigurations configurations;
        HicloudPushGuideConfig configFromFile = HicloudPushGuideManager.getInstance().getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "extractConfig failed, pushGuideConfig is null");
            return;
        }
        NotifyLogger.m29913d(TAG, "extractConfig, pushGuideConfig:" + configFromFile.toString());
        try {
            configurations = configFromFile.getConfigurations();
        } catch (Exception unused) {
            NotifyLogger.m29914e(TAG, "pushguideconfig end");
        }
        if (configurations == null) {
            NotifyLogger.m29914e(TAG, "pushguideconfig,configurations null");
            return;
        }
        HicloudPushGuideManager.getInstance().resetPopTimes();
        HiCloudPushGuideLanguage language = configurations.getLanguage();
        if (language == null) {
            NotifyLogger.m29914e(TAG, "pushguideconfig,language null");
            return;
        }
        ResourceDownLoadHolder resourceDownLoadHolder = new ResourceDownLoadHolder();
        int iM62189B = C10028c.m62182c0().m62189B(HicloudPushGuideConstants.LANGUAGE_VERSION);
        String strM62184A = C10028c.m62182c0().m62184A(HicloudPushGuideConstants.LANGUAGE_HASH);
        NotifyLogger.m29915i(TAG, "pushguideconfig,current language version is: " + iM62189B + ", OM file language version is: " + language.getVersion() + "current language Hash is: " + strM62184A + ", OM file language Hash is: " + language.getHash());
        if (iM62189B == 0 || TextUtils.isEmpty(strM62184A) || (iM62189B < language.getVersion() && !TextUtils.equals(language.getHash(), strM62184A))) {
            C12515a.m75110o().m75172d(new DownLoadLanguageTask(language, resourceDownLoadHolder));
        } else {
            resourceDownLoadHolder.setDownloadResult(true);
        }
        NotifyLogger.m29915i(TAG, "pushguideconfig end");
    }

    private void requestConfig() {
        NotifyLogger.m29915i(TAG, "request push guide Config");
        if (this.mHiCloudPushGuideService == null) {
            this.mHiCloudPushGuideService = new C5025s(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request push guide config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudPushGuide")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "pushguideconfig,HTTP_NOT_MODIFY extract sync module config");
                    return;
                } else {
                    if (!this.mHiCloudPushGuideService.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "pushguideconfig,getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (this.mHiCloudPushGuideService.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "request push guide config success");
                C9734g.m60767a().m60769c("HiCloudPushGuide");
                extractConfig();
                return;
            }
            NotifyLogger.m29914e(TAG, "query  pushguide config failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "pushguideconfig,getLatestConfig failed retry, retry num: " + i10);
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        NotifyLogger.m29915i(TAG, "start hicloudpushguidetask");
        requestVersion();
    }

    public boolean requestVersion() {
        NotifyLogger.m29915i(TAG, "request hicloud push guide config version");
        if (this.mHiCloudPushGuideService == null) {
            this.mHiCloudPushGuideService = new C5025s(null);
        }
        long configVersion = 0;
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
                configVersion = this.mHiCloudPushGuideService.getConfigVersion();
                NotifyLogger.m29913d(TAG, "push guide latestVersion:" + configVersion);
                break;
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request push guide config version exception: " + e10.toString());
                if (!this.mHiCloudPushGuideService.isExceptionNeedRetry(e10) || i10 >= 2) {
                    return false;
                }
                NotifyLogger.m29915i(TAG, "pushguideconfig,requestVersion exception retry, retry num: " + i10);
            }
        }
        if (C11327e.m68063f("HiCloudPushGuide") < configVersion) {
            NotifyLogger.m29915i(TAG, "version updated, query pushguide config");
            requestConfig();
            return true;
        }
        NotifyLogger.m29915i(TAG, "version not updated, extract push guide config");
        extractConfig();
        return false;
    }
}
