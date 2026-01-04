package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.C6310a;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public class HMSBIInitializer {

    /* renamed from: d */
    private static final Object f30163d = new Object();

    /* renamed from: e */
    private static HMSBIInitializer f30164e;

    /* renamed from: f */
    private static HiAnalyticsInstance f30165f;

    /* renamed from: a */
    private final Context f30166a;

    /* renamed from: b */
    private AtomicBoolean f30167b = new AtomicBoolean(false);

    /* renamed from: c */
    private boolean f30168c = HianalyticsExist.isHianalyticsExist();

    /* renamed from: com.huawei.hms.utils.HMSBIInitializer$a */
    public class C6520a implements IQueryUrlCallBack {
        public C6520a() {
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackFail(int i10) {
            HMSLog.m36986e("HMSBIInitializer", "get grs failed, the errorcode is " + i10);
            HMSBIInitializer.this.f30167b.set(false);
            C6310a.m36621c().m36622a();
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (HMSBIInitializer.this.f30168c) {
                        HMSBIInitializer.this.m37008a(str);
                    } else {
                        HmsHiAnalyticsUtils.init(HMSBIInitializer.this.f30166a, false, false, false, str, "com.huawei.hwid");
                    }
                    HMSLog.m36988i("HMSBIInitializer", "BI URL acquired successfully");
                } catch (Throwable th2) {
                    HMSLog.m36986e("HMSBIInitializer", "HA Init error, message : " + th2.getMessage());
                }
            }
            HMSBIInitializer.this.f30167b.set(false);
            C6310a.m36621c().m36624b();
        }
    }

    /* renamed from: com.huawei.hms.utils.HMSBIInitializer$b */
    public class AsyncTaskC6521b extends AsyncTask<String, Integer, Void> {
        private AsyncTaskC6521b() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            HMSBIInitializer.this.m37012b(strArr[0]);
            return null;
        }

        public /* synthetic */ AsyncTaskC6521b(HMSBIInitializer hMSBIInitializer, C6520a c6520a) {
            this();
        }
    }

    private HMSBIInitializer(Context context) {
        this.f30166a = context;
    }

    public static HMSBIInitializer getInstance(Context context) {
        synchronized (f30163d) {
            try {
                if (f30164e == null && context != null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        f30164e = new HMSBIInitializer(applicationContext);
                    } else {
                        f30164e = new HMSBIInitializer(context);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f30164e;
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f30165f;
    }

    public void initBI() {
        boolean initFlag = !this.f30168c ? HmsHiAnalyticsUtils.getInitFlag() : HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        HMSLog.m36988i("HMSBIInitializer", "Builder->biInitFlag :" + initFlag);
        if (initFlag || AnalyticsSwitchHolder.isAnalyticsDisabled(this.f30166a)) {
            return;
        }
        HMSLog.m36988i("HMSBIInitializer", "Builder->biInitFlag : start initHaSDK");
        initHaSDK();
    }

    public void initHaSDK() {
        if (this.f30167b.compareAndSet(false, true)) {
            String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(this.f30166a);
            if (!TextUtils.isEmpty(issueCountryCode)) {
                issueCountryCode = issueCountryCode.toUpperCase(Locale.ENGLISH);
            }
            if (!"UNKNOWN".equalsIgnoreCase(issueCountryCode) && !TextUtils.isEmpty(issueCountryCode)) {
                new AsyncTaskC6521b(this, null).execute(issueCountryCode);
            } else {
                HMSLog.m36986e("HMSBIInitializer", "Failed to get device issue country");
                this.f30167b.set(false);
            }
        }
    }

    public boolean isInit() {
        return !this.f30168c ? HmsHiAnalyticsUtils.getInitFlag() : HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    /* renamed from: a */
    public void m37008a(String str) {
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag(HiAnalyticsConstant.HA_SERVICE_TAG);
        f30165f = instanceByTag;
        if (instanceByTag != null) {
            instanceByTag.setAppid("com.huawei.hwid");
            return;
        }
        HiAnalyticsConfig hiAnalyticsConfigBuild = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
        HiAnalyticsInstance hiAnalyticsInstanceCreate = new HiAnalyticsInstance.Builder(this.f30166a).setOperConf(hiAnalyticsConfigBuild).setMaintConf(new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(HiAnalyticsConstant.HA_SERVICE_TAG);
        f30165f = hiAnalyticsInstanceCreate;
        if (hiAnalyticsInstanceCreate != null) {
            hiAnalyticsInstanceCreate.setAppid("com.huawei.hwid");
        }
    }

    /* renamed from: b */
    public void m37012b(String str) {
        HMSLog.m36988i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new GrsClient(this.f30166a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new C6520a());
    }
}
