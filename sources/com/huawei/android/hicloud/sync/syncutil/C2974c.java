package com.huawei.android.hicloud.sync.syncutil;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.commonlib.space.QuotaDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.SyncRiskNotificationManager;
import com.huawei.hicloud.notification.p106db.bean.HiCloudRiskRule;
import com.huawei.hicloud.notification.p106db.bean.Regular;
import com.huawei.hicloud.notification.p106db.bean.RiskRule;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hwcloudjs.p164f.C6661f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import je.C10812z;
import p015ak.C0209d;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p684un.C13223b;
import p709vj.C13452e;
import tc.C13007b;
import to.C13049a;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.c */
/* loaded from: classes3.dex */
public class C2974c {

    /* renamed from: m */
    public static final List<String> f12998m = new a();

    /* renamed from: n */
    public static final Map<String, String> f12999n = new b();

    /* renamed from: a */
    public Context f13000a;

    /* renamed from: b */
    public String f13001b;

    /* renamed from: c */
    public String f13002c;

    /* renamed from: d */
    public String f13003d;

    /* renamed from: e */
    public int f13004e;

    /* renamed from: f */
    public int f13005f;

    /* renamed from: g */
    public int f13006g;

    /* renamed from: h */
    public String f13007h;

    /* renamed from: i */
    public int f13008i;

    /* renamed from: j */
    public boolean f13009j;

    /* renamed from: k */
    public boolean f13010k = true;

    /* renamed from: l */
    public List<RiskRule> f13011l;

    /* renamed from: com.huawei.android.hicloud.sync.syncutil.c$a */
    public class a extends ArrayList<String> {
        public a() {
            add(HNConstants.DataType.CONTACT);
            add("calendar");
            add("note");
            add("bookmark");
            add("wlan");
        }
    }

    /* renamed from: com.huawei.android.hicloud.sync.syncutil.c$b */
    public class b extends HashMap<String, String> {
        public b() {
            put("addressbook", HNConstants.DataType.CONTACT);
            put("calendar", "calendar");
            put("notepad", "notepad");
            put("browser", "browser");
            put("wlan", C6661f.f30885g);
        }
    }

    public C2974c(Context context, String str, String str2, String str3, int i10, int i11, int i12, String str4) {
        this.f13000a = context;
        this.f13001b = str;
        this.f13002c = str2;
        this.f13003d = str3;
        this.f13004e = i10;
        this.f13005f = i11;
        this.f13006g = i12;
        this.f13007h = str4;
    }

    /* renamed from: d */
    public static void m17828d(Context context, String str, String str2) {
        if (context == null) {
            C11839m.m70689w("CloudSyncRiskUtil", "clearIgnoreRisk, context is null");
            return;
        }
        try {
            C11839m.m70688i("CloudSyncRiskUtil", "clearIgnoreRisk");
            C13007b.m78205Y(context).m78256e(str, "");
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncRiskUtil", "clearIgnoreRisk error: " + e10.toString());
        }
    }

    /* renamed from: e */
    public static void m17829e(Context context, String str, String str2, int i10) {
        C11839m.m70688i("CloudSyncRiskUtil", "clearRiskInfo, jumpType:" + i10);
        if (context == null) {
            C11839m.m70687e("CloudSyncRiskUtil", "clearRiskInfo, context is null");
            return;
        }
        C13007b c13007bM78205Y = C13007b.m78205Y(context);
        C13452e.m80781L().m80929i3("");
        if (i10 == 1) {
            c13007bM78205Y.m78287t0(str, "", true);
        } else if (i10 == 2) {
            c13007bM78205Y.m78256e(str, "");
        }
    }

    /* renamed from: a */
    public final void m17830a(int i10, String str) {
        if (TextUtils.isEmpty(str) || "-1".equals(str) || "0".equals(str)) {
            C11839m.m70686d("CloudSyncRiskUtil", "invalid baseNum:" + str);
            return;
        }
        try {
            if (str.contains("%")) {
                this.f13009j = m17832c(i10, Double.parseDouble(str.replace("%", "")));
            } else {
                this.f13009j = m17831b(i10, Integer.parseInt(str));
            }
        } catch (NumberFormatException e10) {
            C11839m.m70689w("CloudSyncRiskUtil", "converts error:" + e10.toString());
        }
    }

    /* renamed from: b */
    public final boolean m17831b(int i10, int i11) {
        C11839m.m70686d("CloudSyncRiskUtil", "num:" + i10 + ", limit:" + i11);
        if (!this.f13010k) {
            return this.f13009j && i10 >= i11;
        }
        this.f13010k = false;
        return i10 >= i11;
    }

    /* renamed from: c */
    public final boolean m17832c(int i10, double d10) {
        C11839m.m70686d("CloudSyncRiskUtil", "num:" + i10 + ", percent:" + d10);
        if (!this.f13010k) {
            return this.f13009j && ((double) i10) >= (((double) this.f13008i) * d10) / 100.0d;
        }
        this.f13010k = false;
        return ((double) i10) >= (((double) this.f13008i) * d10) / 100.0d;
    }

    /* renamed from: f */
    public boolean m17833f() {
        C11839m.m70688i("CloudSyncRiskUtil", "doCheck risk begin, mDataType: " + this.f13003d + ", addNum:" + this.f13004e + ", delNum:" + this.f13005f + ", updNum:" + this.f13006g);
        if (HNConstants.DataType.CONTACT.equals(this.f13003d)) {
            String str = C10812z.m65833b(this.f13002c).get("versionName");
            boolean zIsSdkSupportRecycleProcess = SyncLogicService.isSdkSupportRecycleProcess(this.f13002c);
            if ("9.2.0.308".equals(str) && !zIsSdkSupportRecycleProcess) {
                int i10 = this.f13005f;
                int i11 = this.f13006g;
                this.f13005f = i11;
                this.f13006g = i10;
                StringBuilder sb2 = new StringBuilder("contactSyncVersion:");
                sb2.append(str);
                sb2.append(",before delNum:");
                sb2.append(i10);
                sb2.append(" updNum:");
                sb2.append(i11);
                sb2.append(",after correction,delNum:");
                sb2.append(this.f13005f);
                sb2.append(" updNum:");
                sb2.append(this.f13006g);
                C10812z.m65840i(this.f13000a, this.f13001b, this.f13003d, 0, sb2.toString(), "03001", "check_risk_before_upload", this.f13007h);
                C11839m.m70688i("CloudSyncRiskUtil", sb2.toString());
            }
        }
        if (!m17836i()) {
            return false;
        }
        this.f13009j = false;
        for (RiskRule riskRule : this.f13011l) {
            String ruleType = riskRule.getRuleType();
            Map<String, String> map = f12999n;
            if (TextUtils.isEmpty(map.get(this.f13001b)) || !map.get(this.f13001b).equals(ruleType)) {
                C11839m.m70686d("CloudSyncRiskUtil", "riskType not match");
            } else {
                int iM17834g = m17834g();
                this.f13008i = iM17834g;
                if (iM17834g == -1) {
                    C11839m.m70689w("CloudSyncRiskUtil", "cloudTotal error.");
                } else {
                    C11839m.m70688i("CloudSyncRiskUtil", "cloudTotal:" + this.f13008i);
                    int threshold = riskRule.getThreshold();
                    int i12 = this.f13008i;
                    if (i12 < threshold || i12 == 0) {
                        C11839m.m70688i("CloudSyncRiskUtil", "not reach threshold, continue. threshold:" + threshold);
                    } else {
                        List<Regular> regulars = riskRule.getRegulars();
                        if (regulars != null) {
                            for (Regular regular : regulars) {
                                this.f13010k = true;
                                m17830a(this.f13004e, regular.getAddNum());
                                m17830a(this.f13005f, regular.getDelNum());
                                m17830a(this.f13006g, regular.getMdfNum());
                                C11839m.m70688i("CloudSyncRiskUtil", "riskManagement, effective:" + this.f13009j);
                                if (this.f13009j) {
                                    C13452e.m80781L().m80929i3(this.f13001b + "_" + this.f13002c);
                                    C13452e.m80781L().m80894b3(true);
                                    C13452e.m80781L().m80992y1();
                                    C13223b.m79473a(this.f13000a, "SYNC_RISK_EFFECTIVE", "1");
                                    UBAAnalyze.m29943D("CKC", "SYNC_RISK_EFFECTIVE");
                                    return this.f13009j;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return this.f13009j;
    }

    /* renamed from: g */
    public final int m17834g() {
        C11839m.m70688i("CloudSyncRiskUtil", "getCloudTotal, syncType:" + this.f13001b);
        StringBuffer stringBuffer = new StringBuffer("collection=private and kind in [");
        stringBuffer.append(this.f13003d);
        stringBuffer.append("] and (trashed=false)");
        return m17835h("", "/Statistic", new String(stringBuffer));
    }

    /* renamed from: h */
    public final int m17835h(String str, String str2, String str3) {
        try {
            String strM78761z = new C13049a(EnumC12999a.CLOUD_SYNC, this.f13007h).m78761z(DriveSyncUtil.m17958C(this.f13001b), str3);
            C11839m.m70686d("CloudSyncRiskUtil", "getQuotaUsedInfo recycleContact response=" + strM78761z);
            QuotaUsedInfoRsp quotaUsedInfoRsp = (QuotaUsedInfoRsp) new Gson().fromJson(strM78761z, QuotaUsedInfoRsp.class);
            QuotaDetail[] quotaDetails = quotaUsedInfoRsp.getQuotaDetails();
            quotaUsedInfoRsp.getRetCode();
            quotaUsedInfoRsp.getRetDesc();
            Arrays.toString(quotaDetails);
            if (quotaUsedInfoRsp.getRetCode() != 0) {
                C11839m.m70687e("CloudSyncRiskUtil", "quotausedinfo " + this.f13001b + "request failed");
                return 0;
            }
            C11839m.m70688i("CloudSyncRiskUtil", "quotausedinfo request success");
            if (quotaDetails.length <= 0) {
                C11839m.m70688i("CloudSyncRiskUtil", "getQuotaUsedInfo " + this.f13001b + " recycleContact request success,recordsCount:0");
                return -1;
            }
            int recordsCount = 0;
            for (QuotaDetail quotaDetail : quotaDetails) {
                if (quotaDetail != null && !quotaDetail.isTrashed()) {
                    recordsCount += quotaDetail.getRecordsCount();
                }
            }
            return recordsCount;
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncRiskUtil", "getSyncRiskTotal exception:" + e10.toString());
            return -1;
        }
    }

    /* renamed from: i */
    public final boolean m17836i() {
        Context context = this.f13000a;
        if (context == null) {
            C11839m.m70689w("CloudSyncRiskUtil", "context is null");
            return false;
        }
        if (this.f13004e == 0 && this.f13005f == 0 && this.f13006g == 0) {
            return false;
        }
        if (!C0209d.m1206R1(context)) {
            C11839m.m70688i("CloudSyncRiskUtil", "oobe not end.");
            return false;
        }
        if (!f12998m.contains(this.f13003d)) {
            C11839m.m70688i("CloudSyncRiskUtil", "no need check. dataType:" + this.f13003d);
            return false;
        }
        if (C13007b.m78205Y(this.f13000a).m78251b0(this.f13001b, "")) {
            C11839m.m70688i("CloudSyncRiskUtil", "ignore check risk, continue sync.");
            return false;
        }
        try {
            NotificationConfig syncRiskNoticeConfig = new SyncRiskNotificationManager().getSyncRiskNoticeConfig();
            if (syncRiskNoticeConfig == null) {
                C11839m.m70689w("CloudSyncRiskUtil", "getSyncRiskNoticeConfig null.");
                return false;
            }
            HiCloudRiskRule hiCloudRiskRule = syncRiskNoticeConfig.getHiCloudRiskRule();
            if (hiCloudRiskRule != null && hiCloudRiskRule.getRules() != null) {
                this.f13011l = hiCloudRiskRule.getRules();
                return true;
            }
            C11839m.m70689w("CloudSyncRiskUtil", "getHiCloudRiskRule null.");
            return false;
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncRiskUtil", "getSyncRiskNoticeConfig error: " + e10.getMessage());
            return false;
        }
    }
}
