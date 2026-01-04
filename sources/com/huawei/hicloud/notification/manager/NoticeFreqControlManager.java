package com.huawei.hicloud.notification.manager;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.ICloudSpaceProxy;
import com.huawei.hicloud.notification.bean.FreqControlBean;
import com.huawei.hicloud.notification.bean.FreqControlRoot;
import com.huawei.hicloud.notification.bean.FrequencyBean;
import com.huawei.hicloud.notification.bean.FrequencyControl;
import com.huawei.hicloud.notification.bean.SceneNoticeText;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.languageoperator.FrequencyControlLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.FreqControlTimeOperator;
import com.huawei.hicloud.notification.task.NoticeFreqControlClearTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5030x;
import com.huawei.hms.network.embedded.C5963j;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;
import p292fn.C9734g;
import p429kk.C11058a;
import p429kk.C11060c;
import p616rk.C12515a;
import p709vj.C13452e;
import p746wn.C13622a;

/* loaded from: classes6.dex */
public class NoticeFreqControlManager {
    private static final long ONE_DAY_MILLIS = 86400000;
    private static final String PLACE_HOLDER_DATETIME = "DATETIME";
    private static final String PLACE_HOLDER_DAY = "DAY";
    private static final String PLACE_HOLDER_MODEL = "MODEL";
    private static final String PLACE_HOLDER_REASON = "REASON";
    private static final String PLACE_HOLDER_SIZE = "SIZE";
    private static final String TAG = "NoticeFreqControlManager";
    private static NoticeFreqControlManager instance = new NoticeFreqControlManager();
    private C5030x mFreqControlService = new C5030x(null);
    private ICloudSpaceProxy spaceProxy;

    private NoticeFreqControlManager() {
    }

    private boolean checkFreqList(FrequencyBean[] frequencyBeanArr) {
        int days;
        int times;
        int noticeShownCount;
        if (frequencyBeanArr == null || frequencyBeanArr.length == 0) {
            NotifyLogger.m29914e(TAG, "canShowNotice, no frequencyBeans, return true");
            return true;
        }
        for (FrequencyBean frequencyBean : frequencyBeanArr) {
            if (frequencyBean != null && (noticeShownCount = getNoticeShownCount((days = frequencyBean.getDays()))) >= (times = frequencyBean.getTimes())) {
                NotifyLogger.m29916w(TAG, "freq check failed, in " + days + " days, already shown " + noticeShownCount + ", but config max time is: " + times);
                return false;
            }
        }
        return true;
    }

    private void extractLanguage() throws Throwable {
        NotifyLogger.m29915i(TAG, "begin extractLanguage");
        FreqControlRoot frequencyControlConfig = getFrequencyControlConfig();
        if (frequencyControlConfig == null) {
            NotifyLogger.m29914e(TAG, "root is null");
            return;
        }
        FrequencyControl frequencyControl = frequencyControlConfig.getFrequencyControl();
        if (frequencyControl == null) {
            NotifyLogger.m29914e(TAG, "frequencyControl is null");
        } else {
            FrequencyControlLangManager.getInstance().extractCommonLanguage(frequencyControl.getLanguage());
        }
    }

    private void getConfig() throws Throwable {
        NotifyLogger.m29915i(TAG, C5963j.f27044m);
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request notice config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudSpaceFrequencyControl")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    extractLanguage();
                    return;
                } else {
                    if (!this.mFreqControlService.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (this.mFreqControlService.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "request notice config success");
                C9734g.m60767a().m60769c("HiCloudSpaceFrequencyControl");
                FrequencyControlLangManager.getInstance().clearLangVersionAndResult();
                extractLanguage();
                return;
            }
            NotifyLogger.m29914e(TAG, "query cloud notify config failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    private String getDeviceNameForIM() {
        String strM1171G = C0209d.m1171G();
        return TextUtils.isEmpty(strM1171G) ? "" : strM1171G.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&#x27;").replace("\"", "&quot;").replace("(", "&#40;").replace(")", "&#41;").replace("%", "&#37;").replace("+", "&#43;").replace("\\", "&#92;").replace("/", "&#x2F;");
    }

    public static NoticeFreqControlManager getInstance() {
        return instance;
    }

    private List<CommonLanguageDbString> getLanguageStringFromDb(String str, String str2, String str3) {
        return new FrequencyControlLanguageOperator().queryString(str, str2, HNConstants.Language.EN_STANDARD, str3);
    }

    private int getLevelFreqShownCount(int i10, String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis2 = calendar.getTimeInMillis() - ((i10 - 1) * 86400000);
        FreqControlTimeOperator freqControlTimeOperator = new FreqControlTimeOperator();
        return "purpose".equals(str) ? freqControlTimeOperator.queryPurposeCountByTimeInterval(String.valueOf(timeInMillis2), String.valueOf(timeInMillis), str2) : freqControlTimeOperator.queryMethodCountByTimeInterval(String.valueOf(timeInMillis2), String.valueOf(timeInMillis), str2);
    }

    private int getNoticeShownCount(int i10) {
        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return new FreqControlTimeOperator().queryCountByTimeInterval(String.valueOf(calendar.getTimeInMillis() - ((i10 - 1) * 86400000)), String.valueOf(timeInMillis));
    }

    private String replaceFixedItems(String str) {
        return str.replace("&lt;", "<").replace("&gt;", ">").replace(PLACE_HOLDER_DATETIME, new SimpleDateFormat("yyyy.MM.dd").format((Date) new Timestamp(System.currentTimeMillis())));
    }

    public boolean canShowNotice() {
        FreqControlBean matchedFreqControlBean = getMatchedFreqControlBean();
        if (matchedFreqControlBean == null) {
            return true;
        }
        return checkFreqList(matchedFreqControlBean.getFrequencyList());
    }

    public boolean checkLevelFreqList(FrequencyBean[] frequencyBeanArr, String str, String str2) {
        if (frequencyBeanArr == null || frequencyBeanArr.length == 0) {
            NotifyLogger.m29914e(TAG, "checkLevelFreqList, no frequencyBeans, return true");
            return true;
        }
        for (FrequencyBean frequencyBean : frequencyBeanArr) {
            if (frequencyBean == null) {
                NotifyLogger.m29915i(TAG, "checkLevelFreqList freqControlBean null");
            } else {
                int days = frequencyBean.getDays();
                int times = frequencyBean.getTimes();
                int levelFreqShownCount = getLevelFreqShownCount(days, str, str2);
                if (levelFreqShownCount >= times) {
                    NotifyLogger.m29916w(TAG, "checkLevelFreqList freq check failed, type=" + str + ",target=" + str2 + " in " + days + " days, already shown " + levelFreqShownCount + ", but config max time is: " + times);
                    return false;
                }
                NotifyLogger.m29915i(TAG, "checkLevelFreqList success days:" + days + ", times:" + times + ", alreadyShownCount=" + levelFreqShownCount);
            }
        }
        return true;
    }

    public void clearAllConfig() {
        new FreqControlTimeOperator().clear();
        FrequencyControlLangManager.getInstance().clearLanguageDb();
        FrequencyControlLangManager.getInstance().clearLangVersionAndResult();
        clearConfigFile();
    }

    public void clearAllConfigInTask() {
        C12515a.m75110o().m75172d(new NoticeFreqControlClearTask());
    }

    public void clearConfigFile() {
        boolean zDelete;
        boolean zDelete2;
        try {
            if (C0213f.m1377a() == null) {
                NotifyLogger.m29914e(TAG, "clearConfigFile context null");
                return;
            }
            if (this.mFreqControlService == null) {
                this.mFreqControlService = new C5030x(null);
            }
            File file = new File(this.mFreqControlService.getConfigFilePath());
            if (file.exists() && !(zDelete2 = file.delete())) {
                NotifyLogger.m29914e(TAG, "delete config file, deleteResult is:" + zDelete2);
            }
            File file2 = new File(FrequencyControlLangManager.getInstance().getLanguageFilePath());
            if (!file2.exists() || (zDelete = file2.delete())) {
                return;
            }
            NotifyLogger.m29914e(TAG, "delete language file, deleteResult is:" + zDelete);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clearConfigFile exception:" + e10.toString());
        }
    }

    public FreqControlRoot getFrequencyControlConfig() throws Throwable {
        if (this.mFreqControlService == null) {
            this.mFreqControlService = new C5030x(null);
        }
        try {
            return (FreqControlRoot) new Gson().fromJson(C0209d.m1290o2(new FileInputStream(new File(this.mFreqControlService.getConfigFilePath()))), FreqControlRoot.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getFrequencyControlConfig file exception, msg:" + e10.getMessage());
            return null;
        }
    }

    public String getIMMessage() {
        FreqControlBean matchedFreqControlBean = getMatchedFreqControlBean();
        if (matchedFreqControlBean == null) {
            NotifyLogger.m29914e(TAG, "sendBackupFailIMMessage failed, freqControlBean is null");
            return null;
        }
        SceneNoticeText sceneNoticeText = matchedFreqControlBean.getSceneNoticeText();
        if (sceneNoticeText == null) {
            NotifyLogger.m29914e(TAG, "sendBackupFailIMMessage failed, sceneNoticeText is null");
            return null;
        }
        String insufficientSpace = sceneNoticeText.getInsufficientSpace();
        if (TextUtils.isEmpty(insufficientSpace)) {
            NotifyLogger.m29914e(TAG, "sendBackupFailIMMessage failed, textId is empty");
            return null;
        }
        String stringFromConfig = getStringFromConfig(insufficientSpace, false);
        if (!TextUtils.isEmpty(stringFromConfig)) {
            return replaceFixedItems(stringFromConfig);
        }
        NotifyLogger.m29914e(TAG, "sendBackupFailIMMessage failed, message is empty");
        return null;
    }

    public FreqControlBean getMatchedFreqControlBean() {
        FreqControlRoot frequencyControlConfig = getFrequencyControlConfig();
        if (frequencyControlConfig == null) {
            NotifyLogger.m29914e(TAG, "getMatchedFreqControlBean, no rootConfig, return true");
            return null;
        }
        FrequencyControl frequencyControl = frequencyControlConfig.getFrequencyControl();
        if (frequencyControl == null) {
            NotifyLogger.m29914e(TAG, "getMatchedFreqControlBean, no frequencyControl, return true");
            return null;
        }
        FreqControlBean[] frequencyControlBeans = frequencyControl.getFrequencyControlBeans();
        if (frequencyControlBeans == null || frequencyControlBeans.length == 0) {
            NotifyLogger.m29914e(TAG, "getMatchedFreqControlBean, no freqControlBeans, return true");
            return null;
        }
        for (FreqControlBean freqControlBean : frequencyControlBeans) {
            if (freqControlBean == null) {
                NotifyLogger.m29914e(TAG, "getMatchedFreqControlBean,freqControlBean is null, continue");
            } else {
                ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
                if (iCloudSpaceProxy != null && iCloudSpaceProxy.checkUserTag(freqControlBean.getUserGroupExtIDs())) {
                    if (freqControlBean.isEnableSwitch()) {
                        NotifyLogger.m29915i(TAG, "getMatchedFreqControlBean, find matched freq bean, id: " + freqControlBean.getId());
                        return freqControlBean;
                    }
                    NotifyLogger.m29914e(TAG, "getMatchedFreqControlBean, enableSwitch is false, no need check, id: " + freqControlBean.getId());
                    return null;
                }
                NotifyLogger.m29914e(TAG, "getMatchedFreqControlBean, user tag not fit, continue, id: " + freqControlBean.getId());
            }
        }
        return null;
    }

    public String getStringFromConfig(String str, boolean z10) {
        return NotifyUtil.getStringFromConfig(str, z10, getLanguageStringFromDb(C0234s.m1631i(), HNUtil.getCurrentBaseLanguage(), str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudSpaceFrequencyControl") >= r2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.NoticeFreqControlManager.TAG, "version updated, query config");
        getConfig();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0081, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29916w(com.huawei.hicloud.notification.manager.NoticeFreqControlManager.TAG, "getVersion fail. localVersion > latestVersion");
        extractLanguage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getVersion() throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "getVersion start"
            java.lang.String r1 = "NoticeFreqControlManager"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            com.huawei.hicloud.service.x r0 = r6.mFreqControlService
            if (r0 != 0) goto L13
            com.huawei.hicloud.service.x r0 = new com.huawei.hicloud.service.x
            r2 = 0
            r0.<init>(r2)
            r6.mFreqControlService = r0
        L13:
            r0 = 0
        L14:
            r2 = 2
            if (r0 > r2) goto L6d
            com.huawei.hicloud.service.x r3 = r6.mFreqControlService     // Catch: fk.C9721b -> L1e
            long r2 = r3.getConfigVersion()     // Catch: fk.C9721b -> L1e
            goto L6f
        L1e:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getHiCloudActivesConfigVersion exception:"
            r4.append(r5)
            java.lang.String r5 = r3.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = " retryNum = "
            r5.append(r4)
            r5.append(r0)
            java.lang.String r4 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r4)
            com.huawei.hicloud.service.x r4 = r6.mFreqControlService
            boolean r3 = r4.isExceptionNeedRetry(r3)
            if (r3 == 0) goto L6c
            if (r0 >= r2) goto L6c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getVersion exception retry, retry num: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            int r0 = r0 + 1
            goto L14
        L6c:
            return
        L6d:
            r2 = 0
        L6f:
            java.lang.String r0 = "HiCloudSpaceFrequencyControl"
            long r4 = p459lp.C11327e.m68063f(r0)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L82
            java.lang.String r0 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r6.getConfig()
            return
        L82:
            java.lang.String r0 = "getVersion fail. localVersion > latestVersion"
            com.huawei.hicloud.notification.log.NotifyLogger.m29916w(r1, r0)
            r6.extractLanguage()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.NoticeFreqControlManager.getVersion():void");
    }

    public void recordLevelNoticeShow(List<String> list, String str) {
        NotifyLogger.m29915i(TAG, "recordNoticeShow");
        long jCurrentTimeMillis = System.currentTimeMillis();
        FreqControlTimeOperator freqControlTimeOperator = new FreqControlTimeOperator();
        if (list == null && str == null) {
            freqControlTimeOperator.replace(jCurrentTimeMillis);
        } else {
            freqControlTimeOperator.replaceBatch(jCurrentTimeMillis, list, str);
        }
    }

    public void recordNoticeShow() {
        NotifyLogger.m29915i(TAG, "recordNoticeShow");
        new FreqControlTimeOperator().replace(System.currentTimeMillis());
    }

    public String replaceDataString(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) ? str : str.replace(PLACE_HOLDER_REASON, str2).replace(PLACE_HOLDER_SIZE, str3).replace(PLACE_HOLDER_DAY, str4);
    }

    public String replaceDeviceNameString(String str) {
        return TextUtils.isEmpty(str) ? str : str.replace(PLACE_HOLDER_MODEL, getDeviceNameForIM());
    }

    public void reportFreqControlled(String str) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.EVENT_NAME_SUPPRESSED_NOTICE_TYPE, str);
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_FREQ_CONTROL_SUPPRESS, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportFreqControlled exception:" + e10.toString());
        }
    }

    public void reportOMEvent(String str, Map<String, String> map) {
        try {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07041"), "07041", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B(str);
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportOMEvent exception:" + e10.toString());
        }
    }

    public void setSpaceProxy(ICloudSpaceProxy iCloudSpaceProxy) {
        this.spaceProxy = iCloudSpaceProxy;
    }
}
