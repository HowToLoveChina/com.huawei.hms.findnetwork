package com.huawei.android.hicloud.task.simple;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupSpaceUnEnoughActivity;
import com.huawei.android.hicloud.p088ui.activity.IntelligentClearActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceGuideActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.DlAppCampInfo;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.FilterDataForRecommend;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.manager.GuideH5ReportUtil;
import com.huawei.hicloud.notification.util.CampaignCheckUtil;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import p015ak.C0212e0;
import p222da.C9057a;
import p329h7.C10121i;
import p341hj.C10220d0;
import p341hj.C10221d1;
import p341hj.C10250n0;
import p341hj.C10255p;
import p391jb.C10768a;
import p391jb.C10769b;
import p391jb.C10770c;
import p391jb.C10772e;
import p424kb.C11024a;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.task.simple.d2 */
/* loaded from: classes3.dex */
public class C3024d2 extends AbstractC12367d {

    /* renamed from: a */
    public Handler f13187a;

    /* renamed from: b */
    public Context f13188b;

    /* renamed from: d */
    public Activity f13190d;

    /* renamed from: e */
    public String f13191e;

    /* renamed from: p */
    public int f13202p;

    /* renamed from: r */
    public String f13204r;

    /* renamed from: t */
    public ArrayList<FilterAvailabalGradePackage> f13206t;

    /* renamed from: c */
    public String f13189c = "";

    /* renamed from: f */
    public boolean f13192f = false;

    /* renamed from: g */
    public boolean f13193g = false;

    /* renamed from: h */
    public boolean f13194h = false;

    /* renamed from: i */
    public String f13195i = "";

    /* renamed from: j */
    public GetActivityEntryResp f13196j = null;

    /* renamed from: k */
    public UserPackage f13197k = null;

    /* renamed from: l */
    public CloudSpace f13198l = null;

    /* renamed from: m */
    public boolean f13199m = false;

    /* renamed from: n */
    public int f13200n = -1;

    /* renamed from: o */
    public int f13201o = -1;

    /* renamed from: q */
    public String f13203q = "";

    /* renamed from: s */
    public int f13205s = -1;

    /* renamed from: u */
    public GetActivityEntryResp f13207u = null;

    /* renamed from: com.huawei.android.hicloud.task.simple.d2$a */
    public class a extends Handler {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f13208a;

        /* renamed from: b */
        public final /* synthetic */ DlAppCampInfo f13209b;

        /* renamed from: c */
        public final /* synthetic */ String f13210c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, CountDownLatch countDownLatch, DlAppCampInfo dlAppCampInfo, String str) {
            super(looper);
            this.f13208a = countDownLatch;
            this.f13209b = dlAppCampInfo;
            this.f13210c = str;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj = message.obj;
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            if (message.what != 7016) {
                C11839m.m70688i("QueryGuideH5Task", "checkPpsAdsIsOk msg not satify");
                C3024d2.this.m18274g0(iIntValue, this.f13209b.getAdParametersExt(), this.f13208a, this.f13210c);
            } else {
                C11839m.m70688i("QueryGuideH5Task", "checkPpsAdsIsOk msg check success");
                C3024d2.this.f13200n = 0;
                this.f13208a.countDown();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.simple.d2$b */
    public class b extends Handler {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f13212a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, CountDownLatch countDownLatch) {
            super(looper);
            this.f13212a = countDownLatch;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 6009) {
                C3024d2 c3024d2 = C3024d2.this;
                c3024d2.f13189c = c3024d2.m18232A(message.obj);
                C3024d2.this.f13200n = 0;
                this.f13212a.countDown();
                return;
            }
            if (i10 != 6010) {
                this.f13212a.countDown();
                return;
            }
            C3024d2.this.f13200n = 1;
            C11839m.m70688i("QueryGuideH5Task", "getPackageId CHECK_FAIL msg.obj e.getMessage()：" + message.obj);
            this.f13212a.countDown();
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.simple.d2$c */
    public class c extends Handler {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f13214a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, CountDownLatch countDownLatch) {
            super(looper);
            this.f13214a = countDownLatch;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 7001) {
                C3024d2 c3024d2 = C3024d2.this;
                c3024d2.f13207u = c3024d2.m18266X(message);
                C3024d2.this.f13200n = 0;
                this.f13214a.countDown();
                return;
            }
            if (i10 != 7002) {
                this.f13214a.countDown();
            } else {
                C3024d2.this.f13200n = 1;
                this.f13214a.countDown();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.simple.d2$d */
    public class d extends Handler {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f13216a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Looper looper, CountDownLatch countDownLatch) {
            super(looper);
            this.f13216a = countDownLatch;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 2001) {
                if (i10 != 2101) {
                    if (i10 != 2131) {
                        if (i10 != 7019) {
                            C11839m.m70688i("QueryGuideH5Task", "getUserPackage other recall");
                            this.f13216a.countDown();
                            return;
                        }
                    }
                }
                C11839m.m70688i("QueryGuideH5Task", "getUserPackage failed");
                C3024d2.this.f13201o = 1;
                this.f13216a.countDown();
                return;
            }
            C11839m.m70688i("QueryGuideH5Task", "getUserPackage success");
            C3024d2 c3024d2 = C3024d2.this;
            c3024d2.f13197k = c3024d2.m18236Y(message);
            C3024d2.this.f13201o = 0;
            this.f13216a.countDown();
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.simple.d2$e */
    public static class e implements Comparator<C10769b>, Serializable {
        private static final long serialVersionUID = 3207914161137875043L;

        public e() {
        }

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(C10769b c10769b, C10769b c10769b2) {
            try {
                int iM65586c = c10769b.m65586c();
                int iM65586c2 = c10769b2.m65586c();
                if (iM65586c > iM65586c2) {
                    return 1;
                }
                return iM65586c < iM65586c2 ? -1 : 0;
            } catch (Exception e10) {
                C11839m.m70687e("QueryGuideH5Task", "ActionListListComparator Exception : " + e10.toString());
                return 0;
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.simple.d2$f */
    public static class f implements Comparator<C10770c>, Serializable {
        private static final long serialVersionUID = 3207914161137875043L;

        public f() {
        }

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(C10770c c10770c, C10770c c10770c2) {
            try {
                int iM65595g = c10770c.m65595g();
                int iM65595g2 = c10770c2.m65595g();
                if (iM65595g > iM65595g2) {
                    return 1;
                }
                return iM65595g < iM65595g2 ? -1 : 0;
            } catch (Exception e10) {
                C11839m.m70687e("QueryGuideH5Task", "OperPageHintListComparator Exception : " + e10.toString());
                return 0;
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public C3024d2(Activity activity, Handler handler, int i10, String str) {
        this.f13190d = null;
        this.f13202p = 0;
        this.f13204r = "";
        C11839m.m70688i("QueryGuideH5Task", "SharedPreferenceUtil.clear CHECK_GUID_H5_DATA_RECORDSP activity: " + activity);
        C0212e0.m1351a(activity, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP);
        C0212e0.m1351a(activity, m18235I(activity, true, ""));
        C0212e0.m1351a(activity, m18235I(activity, false, ""));
        this.f13188b = activity;
        this.f13190d = activity;
        this.f13187a = handler;
        this.f13202p = i10;
        this.f13204r = str;
    }

    /* renamed from: A */
    public String m18232A(Object obj) {
        try {
            ArrayList<FilterAvailabalGradePackage> filterAvailabalGradePackageList = ((FilterDataForRecommend) obj).getFilterAvailabalGradePackageList();
            this.f13206t = filterAvailabalGradePackageList;
            return filterAvailabalGradePackageList.get(0).getPackageIdList().get(0);
        } catch (Exception e10) {
            C11839m.m70688i("QueryGuideH5Task", "dealGetPackagesBySpaceRuleSuccess object is invalid. e: " + e10.toString());
            return "";
        }
    }

    /* renamed from: E */
    public static String m18233E(Activity activity, String str) {
        return "drive".equals(str) ? "drive" : activity instanceof MainActivity ? RecommendCardConstants.Entrance.HOMEPAGE : activity instanceof CloudSpaceUpgradeActivity ? RecommendCardConstants.Entrance.BUY : ((activity instanceof CloudSpaceGuideActivity) || (activity instanceof CloudBackupSpaceUnEnoughActivity)) ? "recommend" : activity instanceof BackupMainActivity ? CloudBackupConstant.Command.PMS_CMD_BACKUP : activity instanceof IntelligentClearActivity ? "clean" : "";
    }

    /* renamed from: H */
    public static String m18234H(Activity activity, boolean z10, String str) {
        if (activity == null) {
            return "";
        }
        if ("drive".equals(str)) {
            return z10 ? "drive_h5_dialog_entry_data" : "drive_h5_dialog_exit_data";
        }
        if (activity instanceof MainActivity) {
            return z10 ? FrequencyManager.H5DialogConstant.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PREFIX : FrequencyManager.H5DialogConstant.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PREFIX;
        }
        if (activity instanceof CloudSpaceUpgradeActivity) {
            if (!z10) {
                return FrequencyManager.H5DialogConstant.CHECK_GUID_H5_UPDATE_DATA_RECORD_PREFIX;
            }
        } else if ((activity instanceof CloudSpaceGuideActivity) || (activity instanceof CloudBackupSpaceUnEnoughActivity)) {
            if (!z10) {
                return FrequencyManager.H5DialogConstant.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PREFIX;
            }
        } else {
            if (activity instanceof BackupMainActivity) {
                return z10 ? "backup_h5_dialog_entry_data" : "backup_h5_dialog_exit_data";
            }
            if (activity instanceof IntelligentClearActivity) {
                return z10 ? "clean_h5_dialog_entry_data" : "clean_h5_dialog_exit_data";
            }
        }
        return "";
    }

    /* renamed from: I */
    public static String m18235I(Activity activity, boolean z10, String str) {
        if (activity == null) {
            return "";
        }
        if ("drive".equals(str)) {
            return z10 ? "drive_h5_dialog_entry_data_sp" : "drive_h5_dialog_exit_data_sp";
        }
        if (activity instanceof MainActivity) {
            return z10 ? FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP : FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP;
        }
        if ((activity instanceof CloudSpaceUpgradeActivity) || (activity instanceof CloudSpaceGuideActivity) || (activity instanceof CloudBackupSpaceUnEnoughActivity)) {
            if (!z10) {
                return FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP;
            }
        } else {
            if (activity instanceof BackupMainActivity) {
                return z10 ? "backup_h5_dialog_entry_data_sp" : "backup_h5_dialog_exit_data_sp";
            }
            if (activity instanceof IntelligentClearActivity) {
                return z10 ? "clean_h5_dialog_entry_data_sp" : "clean_h5_dialog_exit_data_sp";
            }
        }
        return "";
    }

    /* renamed from: Y */
    public UserPackage m18236Y(Message message) {
        if (message == null) {
            C11839m.m70687e("QueryGuideH5Task", "processGetActivityEntrySuccess entry success, but msg is null");
            return null;
        }
        Object obj = message.obj;
        if (!(obj instanceof UserPackage)) {
            C11839m.m70687e("QueryGuideH5Task", "process get activity entry success, but msg obj is not GetActivityEntryResp");
            return null;
        }
        UserPackage userPackage = (UserPackage) obj;
        if (userPackage.getResultCode() == 0) {
            return userPackage;
        }
        return null;
    }

    /* renamed from: B */
    public final void m18247B(List<C10769b> list, int i10) throws NumberFormatException {
        if (list == null) {
            return;
        }
        if (i10 == 4 || i10 == 5 || i10 == 6) {
            Iterator<C10769b> it = list.iterator();
            while (it.hasNext()) {
                int iM65584a = it.next().m65584a();
                if (iM65584a == 0 || iM65584a == 1 || iM65584a == 2) {
                    C11839m.m70688i("QueryGuideH5Task", "filterActionList campaignSource = " + i10 + ", remove actionNum = " + iM65584a);
                    it.remove();
                }
            }
        }
        m18248C(list);
    }

    /* renamed from: C */
    public final void m18248C(List<C10769b> list) throws NumberFormatException {
        if (list == null) {
            return;
        }
        boolean zM80881Z = C13452e.m80781L().m80881Z();
        try {
            long j10 = Long.parseLong(C13452e.m80781L().m80886a0());
            long j11 = Long.parseLong(this.f13203q);
            z = j10 >= j11;
            C11839m.m70688i("QueryGuideH5Task", "old version: " + j10 + ", new version: " + j11);
        } catch (Exception e10) {
            C11839m.m70688i("QueryGuideH5Task", "filterOtherOperationWhileHasShow formate change Exception:" + e10.getMessage());
        }
        if (zM80881Z && z) {
            C11839m.m70688i("QueryGuideH5Task", "otherOperation has shown, delete the nodes.");
            Iterator<C10769b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().m65584a() == 2) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: D */
    public final void m18249D(String str, String str2, int i10, String str3, List<C10769b> list, C10770c c10770c, int i11, C11060c c11060c, boolean z10, boolean z11) throws NumberFormatException {
        boolean z12;
        boolean z13;
        boolean z14 = false;
        if (m18254L(i10, c10770c, z10, str3, z11)) {
            C11839m.m70688i("QueryGuideH5Task", "isNeedSartGuidH5 isFrequencyOk true");
            z13 = true;
            if (m18285z(UserSpaceUtil.getUserTagsUseCache("QueryGuideH5Task"), c10770c)) {
                C11839m.m70688i("QueryGuideH5Task", "isNeedSartGuidH5 checkUserTag true");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long time = simpleDateFormat.parse(str).getTime();
                    long time2 = simpleDateFormat.parse(str2).getTime();
                    if (time <= jCurrentTimeMillis && jCurrentTimeMillis <= time2) {
                        try {
                            C11839m.m70688i("QueryGuideH5Task", "isNeedSartGuidH5 beginTimeStamp endTimeStamp in");
                            m18275n(i10, list, c10770c, i11, c11060c, str3, z10);
                            z14 = true;
                        } catch (ParseException e10) {
                            e = e10;
                            z14 = true;
                            C11839m.m70688i("QueryGuideH5Task", "isNeedSartGuidH5 firstCondition ParseException: " + e.toString());
                            z12 = z14;
                            z14 = true;
                            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_QUERY_FIRST_CONDITION_CHECK, " isFrequencyOk= " + z14 + " ischeckUserTagOk= " + z13 + " isTimeOk= " + z12);
                        }
                    }
                } catch (ParseException e11) {
                    e = e11;
                }
                z12 = z14;
                z14 = true;
                GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_QUERY_FIRST_CONDITION_CHECK, " isFrequencyOk= " + z14 + " ischeckUserTagOk= " + z13 + " isTimeOk= " + z12);
            }
            z12 = false;
            z14 = true;
        } else {
            z12 = false;
        }
        z13 = z12;
        GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_QUERY_FIRST_CONDITION_CHECK, " isFrequencyOk= " + z14 + " ischeckUserTagOk= " + z13 + " isTimeOk= " + z12);
    }

    /* renamed from: F */
    public final GetActivityEntryResp m18250F(int i10) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f13200n = -1;
        C12515a.m75110o().m75175e(new C10255p(new c(Looper.getMainLooper(), countDownLatch), null, i10), false);
        try {
            if (!countDownLatch.await(5L, TimeUnit.SECONDS)) {
                C11839m.m70686d("QueryGuideH5Task", "getActivityEntryRespOk wait not finish");
            }
        } catch (InterruptedException unused) {
            C11839m.m70689w("QueryGuideH5Task", "getActivityEntryRespOk syncLock wait catch InterruptedException.");
        }
        GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_EXCEPTION, "getActivityEntryRespOk=" + this.f13200n);
        C11839m.m70688i("QueryGuideH5Task", "getActivityEntryRespOk end, result = " + this.f13200n);
        if (this.f13200n == 0) {
            return this.f13207u;
        }
        return null;
    }

    /* renamed from: G */
    public final String m18251G(C11060c c11060c) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f13200n = -1;
        new C10220d0(new b(Looper.getMainLooper(), countDownLatch), c11060c, 3, -1L, 2, null).m63381g();
        try {
            if (!countDownLatch.await(5L, TimeUnit.SECONDS)) {
                C11839m.m70686d("QueryGuideH5Task", "getPackageId wait not finish");
            }
        } catch (InterruptedException unused) {
            C11839m.m70689w("QueryGuideH5Task", "getPackageId syncLock wait catch InterruptedException.");
        }
        GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_EXCEPTION, "getPackageId=" + this.f13200n);
        C11839m.m70688i("QueryGuideH5Task", "getPackageId end, result = " + this.f13200n);
        C11839m.m70688i("QueryGuideH5Task", "getPackageId end, packageId = " + this.f13189c);
        return this.f13200n == 0 ? this.f13189c : "";
    }

    /* renamed from: J */
    public final UserPackage m18252J(String str) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f13201o = -1;
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06014");
        c11060c.m66643I(C11058a.m66627b("06014"));
        new C10250n0(new d(Looper.getMainLooper(), countDownLatch), c11060c, true, str).m63381g();
        try {
            if (!countDownLatch.await(5L, TimeUnit.SECONDS)) {
                C11839m.m70686d("QueryGuideH5Task", "getUserPackage wait not finish");
            }
        } catch (InterruptedException unused) {
            C11839m.m70689w("QueryGuideH5Task", "getUserPackage syncLock wait catch InterruptedException.");
        }
        GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_EXCEPTION, "getUserPackage=" + this.f13201o);
        C11839m.m70688i("QueryGuideH5Task", "getUserPackage end, result = " + this.f13201o);
        if (this.f13201o == 0) {
            return this.f13197k;
        }
        return null;
    }

    /* renamed from: K */
    public final boolean m18253K() {
        if (!CampaignCheckUtil.checkCampaignEntryCondition(this.f13188b)) {
            C11839m.m70688i("QueryGuideH5Task", "isCampaignCenterNeedShow, checkCampaignEntryCondition false");
            return false;
        }
        if (C0212e0.m1354d(this.f13188b, "hicloud_campaign_activity_entry_sp", "exceedRedemptionLimit", true)) {
            C11839m.m70688i("QueryGuideH5Task", "isCampaignCenterNeedShow, exceed redemption limit");
            return false;
        }
        C11839m.m70688i("QueryGuideH5Task", "isCampaignCenterNeedShow, true");
        return true;
    }

    /* renamed from: L */
    public final boolean m18254L(int i10, C10770c c10770c, boolean z10, String str, boolean z11) {
        if (z10 && this.f13202p == 1 && str.equals("exit")) {
            C11839m.m70688i("QueryGuideH5Task", "isNeedSartGuidH5 isMainActivity && (exitPosition == 1) && sceneType.equals(OPER_EXIT) true");
            return true;
        }
        if (z11 && this.f13202p == 1 && str.equals("exit")) {
            C11839m.m70688i("QueryGuideH5Task", "isFrequencyOk isActivityWithEntry && (exitPosition == 1) && sceneType.equals(OPER_EXIT) true");
            return true;
        }
        FrequencyManager frequencyManager = new FrequencyManager();
        C11839m.m70688i("QueryGuideH5Task", "QueryGuideH5Task isFrequencyOk intervalTime: " + c10770c.m65593e());
        if (frequencyManager.checkGuideH5DialogFrequency(this.f13188b, i10, this.f13202p, c10770c.m65593e())) {
            C11839m.m70688i("QueryGuideH5Task", "isNeedSartGuidH5 checkGuideH5DialogFrequency true");
            return true;
        }
        C11839m.m70688i("QueryGuideH5Task", "isNeedSartGuidH5 checkGuideH5DialogFrequency false");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00f9  */
    /* renamed from: M */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m18255M(p391jb.C10772e r19) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.task.simple.C3024d2.m18255M(jb.e):boolean");
    }

    /* renamed from: N */
    public final /* synthetic */ void m18256N(int i10, CountDownLatch countDownLatch, List list) {
        this.f13200n = i10 + list.size() >= 1 ? 0 : 1;
        countDownLatch.countDown();
    }

    /* renamed from: O */
    public final void m18257O(int i10, C10770c c10770c, String str, Bundle bundle, String str2, boolean z10, int i11) {
        boolean z11;
        boolean z12;
        int iM65593e;
        int i12 = this.f13202p;
        if (i12 != 1) {
            if (i12 == 2) {
                if (!z10) {
                    if (str.equals("exit")) {
                        m18267Z(i11, str2, i10, c10770c.m65594f(), str, c10770c.m65593e(), c10770c);
                        this.f13192f = true;
                        return;
                    }
                    return;
                }
                if (str.equals(NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE) && !this.f13193g) {
                    C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NUM, 0);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PACKAGEID, this.f13195i);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_H5URL, str2);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_BEGINTIME, c10770c.m65589a());
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_ENDTIME, c10770c.m65590b());
                    C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_FREQUENCY, i10);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PAGETYPE, c10770c.m65594f());
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_SCENETYPE, str);
                    if (i10 == 0) {
                        C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_INTERVAL, c10770c.m65593e());
                    }
                    z11 = true;
                    this.f13193g = true;
                } else if (!str.equals("exit") || this.f13194h) {
                    z11 = true;
                } else {
                    C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NUM, 0);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PACKAGEID, this.f13195i);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_H5URL, str2);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_BEGINTIME, c10770c.m65589a());
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_ENDTIME, c10770c.m65590b());
                    C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_FREQUENCY, i10);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PAGETYPE, c10770c.m65594f());
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_SCENETYPE, str);
                    if (i10 == 0) {
                        C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_INTERVAL, c10770c.m65593e());
                    }
                    z11 = true;
                    this.f13194h = true;
                }
                if (this.f13193g && this.f13194h) {
                    this.f13192f = z11;
                    return;
                }
                return;
            }
            return;
        }
        if (str.equals(NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE) && !this.f13193g) {
            C11839m.m70688i("QueryGuideH5Task", "procActionFirstMonthZero OPER_ENTRY mFindEntryOK in: mFindEntryOK:  " + this.f13193g);
            if (i10 == 0) {
                iM65593e = c10770c.m65593e();
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_INTERVAL, iM65593e);
            } else {
                iM65593e = 0;
            }
            bundle.putInt("queryh5oknum", 0);
            bundle.putString("packageId", this.f13195i);
            bundle.putString("h5Uri", str2);
            bundle.putInt("interval", iM65593e);
            bundle.putInt("frequency", i10);
            Handler handler = this.f13187a;
            handler.sendMessage(handler.obtainMessage(1, bundle));
            C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NUM, 0);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PACKAGEID, this.f13195i);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_H5URL, str2);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_BEGINTIME, c10770c.m65589a());
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_ENDTIME, c10770c.m65590b());
            C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_FREQUENCY, i10);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PAGETYPE, c10770c.m65594f());
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_SCENETYPE, str);
            z12 = true;
            this.f13193g = true;
        } else if (!str.equals("exit") || this.f13194h) {
            z12 = true;
        } else {
            C11839m.m70688i("QueryGuideH5Task", "procActionFirstMonthZero OPER_EXIT mFindExitOK in: mFindExitOK:  " + this.f13194h);
            C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NUM, 0);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PACKAGEID, this.f13195i);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_H5URL, str2);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_BEGINTIME, c10770c.m65589a());
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_ENDTIME, c10770c.m65590b());
            C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_FREQUENCY, i10);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PAGETYPE, c10770c.m65594f());
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_SCENETYPE, str);
            if (i10 == 0) {
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_INTERVAL, c10770c.m65593e());
            }
            z12 = true;
            this.f13194h = true;
        }
        if (this.f13193g && this.f13194h) {
            this.f13192f = z12;
        }
    }

    /* renamed from: P */
    public final void m18258P(int i10, C10770c c10770c, String str, Bundle bundle, String str2, ActivityEntry activityEntry, boolean z10, int i11) {
        boolean z11;
        boolean z12;
        int iM65593e;
        String url = activityEntry.getUrl();
        int i12 = this.f13202p;
        if (i12 == 1) {
            if (str.equals(NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE) && !this.f13193g) {
                C11839m.m70688i("QueryGuideH5Task", "procActiveDownload OPER_ENTRY mFindEntryOK in: mFindEntryOK:  " + this.f13193g);
                if (i10 == 0) {
                    iM65593e = c10770c.m65593e();
                    C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_INTERVAL, iM65593e);
                } else {
                    iM65593e = 0;
                }
                bundle.putInt("queryh5oknum", 1);
                bundle.putString(NotifyConstants.Keys.NOTIFY_URI, "");
                bundle.putString("h5Uri", str2);
                bundle.putString("activeUri", url);
                bundle.putInt("interval", iM65593e);
                bundle.putInt("frequency", i10);
                Handler handler = this.f13187a;
                handler.sendMessage(handler.obtainMessage(1, bundle));
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NUM, 1);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_ACTIVEURL, url);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_H5URL, str2);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_BEGINTIME, c10770c.m65589a());
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_ENDTIME, c10770c.m65590b());
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_FREQUENCY, i10);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PAGETYPE, c10770c.m65594f());
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_SCENETYPE, str);
                z12 = true;
                this.f13193g = true;
            } else if (!str.equals("exit") || this.f13194h) {
                z12 = true;
            } else {
                C11839m.m70688i("QueryGuideH5Task", "procActiveDownload OPER_EXIT mFindExitOK in: mFindExitOK:  " + this.f13194h);
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NUM, 1);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_ACTIVEURL, url);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_H5URL, str2);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_BEGINTIME, c10770c.m65589a());
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_ENDTIME, c10770c.m65590b());
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_FREQUENCY, i10);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PAGETYPE, c10770c.m65594f());
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_SCENETYPE, str);
                if (i10 == 0) {
                    C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_INTERVAL, c10770c.m65593e());
                }
                z12 = true;
                this.f13194h = true;
            }
            if (this.f13193g && this.f13194h) {
                this.f13192f = z12;
                return;
            }
            return;
        }
        if (i12 == 2) {
            if (z10) {
                if (!str.equals(NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE) || this.f13193g) {
                    z11 = true;
                    if (str.equals("exit") && !this.f13194h) {
                        C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NUM, 1);
                        C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_ACTIVEURL, url);
                        C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_H5URL, str2);
                        C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_BEGINTIME, c10770c.m65589a());
                        C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_ENDTIME, c10770c.m65590b());
                        C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_FREQUENCY, i10);
                        C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PAGETYPE, c10770c.m65594f());
                        C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_SCENETYPE, str);
                        if (i10 == 0) {
                            C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_INTERVAL, c10770c.m65593e());
                        }
                        z11 = true;
                        this.f13194h = true;
                    }
                } else {
                    C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NUM, 1);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_ACTIVEURL, url);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_H5URL, str2);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_BEGINTIME, c10770c.m65589a());
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_ENDTIME, c10770c.m65590b());
                    C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_FREQUENCY, i10);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PAGETYPE, c10770c.m65594f());
                    C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_SCENETYPE, str);
                    if (i10 == 0) {
                        C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_INTERVAL, c10770c.m65593e());
                    }
                    z11 = true;
                    this.f13193g = true;
                }
                if (this.f13193g && this.f13194h) {
                    this.f13192f = z11;
                    return;
                }
                return;
            }
            if (str.equals("exit")) {
                if (i11 == 2) {
                    C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_NUM, 1);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_ACTIVEURL, url);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_H5URL, str2);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_BEGINTIME, c10770c.m65589a());
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_ENDTIME, c10770c.m65590b());
                    C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_FREQUENCY, i10);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_PAGETYPE, c10770c.m65594f());
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_SCENETYPE, str);
                    if (i10 == 0) {
                        C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_INTERVAL, c10770c.m65593e());
                    }
                } else {
                    C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_NUM, 1);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_ACTIVEURL, url);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_H5URL, str2);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_BEGINTIME, c10770c.m65589a());
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_ENDTIME, c10770c.m65590b());
                    C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_FREQUENCY, i10);
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PAGETYPE, c10770c.m65594f());
                    C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_SCENETYPE, str);
                    if (i10 == 0) {
                        C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_INTERVAL, c10770c.m65593e());
                    }
                }
                GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_QUERY_END, " scenetype: " + str + " pagetype: " + c10770c.m65594f() + " beginTime: " + c10770c.m65589a() + " endTime: " + c10770c.m65590b() + " action: " + this.f13205s);
                this.f13192f = true;
            }
        }
    }

    /* renamed from: Q */
    public final void m18259Q(int i10, C10770c c10770c, String str, String str2) {
        if (!str.equals("exit") || this.f13194h) {
            return;
        }
        C11839m.m70688i("QueryGuideH5Task", "procCampaignCenterDialog save sp");
        C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_NUM, 5);
        C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_H5URL, str2);
        C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_BEGINTIME, c10770c.m65589a());
        C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_ENDTIME, c10770c.m65590b());
        C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_FREQUENCY, i10);
        C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_PAGETYPE, c10770c.m65594f());
        C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_SCENETYPE, str);
        if (i10 == 0) {
            C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_INTERVAL, c10770c.m65593e());
        }
        this.f13194h = true;
        this.f13192f = true;
    }

    /* renamed from: R */
    public final boolean m18260R(int i10, List<C10769b> list, C10770c c10770c, String str, Bundle bundle, int i11, String str2, int i12) {
        return m18263U(4, i10, list, c10770c, str, bundle, i11, str2, i12);
    }

    /* renamed from: S */
    public final boolean m18261S(int i10, List<C10769b> list, C10770c c10770c, String str, Bundle bundle, int i11, String str2, int i12) {
        return m18263U(3, i10, list, c10770c, str, bundle, i11, str2, i12);
    }

    /* renamed from: T */
    public final boolean m18262T(int i10, List<C10769b> list, C10770c c10770c, String str, Bundle bundle, int i11, String str2, boolean z10, int i12) {
        int iM65593e;
        C10768a c10768aM65585b = list.get(i11).m65585b();
        if (c10768aM65585b == null) {
            return false;
        }
        String strM65582a = c10768aM65585b.m65582a();
        String strM65583b = c10768aM65585b.m65583b();
        C11839m.m70688i("QueryGuideH5Task", "procOtherOperation in  sceneType: " + str);
        int i13 = this.f13202p;
        if (i13 == 1) {
            if (!str.equals(NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE) || this.f13193g) {
                if (!str.equals("exit") || this.f13194h) {
                    if (!this.f13193g || !this.f13194h) {
                        return false;
                    }
                    this.f13192f = true;
                    return false;
                }
                C11839m.m70688i("QueryGuideH5Task", "procOtherOperation OPER_EXIT mFindExitOK in: mFindExitOK:  " + this.f13194h);
                C11839m.m70686d("QueryGuideH5Task", "procOtherOperation start to save SP when exitPosition == 1, sceneType == exit");
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NUM, 2);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NOTIFYURL, strM65583b);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NOTIFYTYPE, strM65582a);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_BEGINTIME, c10770c.m65589a());
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_ENDTIME, c10770c.m65590b());
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_H5URL, str2);
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_FREQUENCY, i10);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PAGETYPE, c10770c.m65594f());
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_SCENETYPE, str);
                if (i10 == 0) {
                    C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_INTERVAL, c10770c.m65593e());
                }
                this.f13194h = true;
                return true;
            }
            C11839m.m70688i("QueryGuideH5Task", "procOtherOperation OPER_ENTRY mFindEntryOK in: mFindEntryOK:  " + this.f13193g);
            if (i10 == 0) {
                iM65593e = c10770c.m65593e();
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_INTERVAL, iM65593e);
            } else {
                iM65593e = 0;
            }
            bundle.putString(NotifyConstants.Keys.NOTIFY_URI, strM65583b);
            bundle.putString(NotifyConstants.Keys.NOTIFY_TYPE, strM65582a);
            bundle.putInt("queryh5oknum", 2);
            bundle.putString("h5Uri", str2);
            bundle.putInt("interval", iM65593e);
            bundle.putInt("frequency", i10);
            Handler handler = this.f13187a;
            handler.sendMessage(handler.obtainMessage(1, bundle));
            C11839m.m70686d("QueryGuideH5Task", "procOtherOperation start to save SP when exitPosition == 1, sceneType == entry");
            C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NUM, 2);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NOTIFYURL, strM65583b);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NOTIFYTYPE, strM65582a);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_BEGINTIME, c10770c.m65589a());
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_ENDTIME, c10770c.m65590b());
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_H5URL, str2);
            C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_FREQUENCY, i10);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PAGETYPE, c10770c.m65594f());
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_SCENETYPE, str);
            this.f13193g = true;
            return true;
        }
        if (i13 != 2) {
            return false;
        }
        if (z10) {
            if (str.equals(NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE) && !this.f13193g) {
                C11839m.m70686d("QueryGuideH5Task", "procOtherOperation start to save SP when exitPosition == 2, sceneType == entry");
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NUM, 2);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NOTIFYURL, strM65583b);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NOTIFYTYPE, strM65582a);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_H5URL, str2);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_BEGINTIME, c10770c.m65589a());
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_ENDTIME, c10770c.m65590b());
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_FREQUENCY, i10);
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PAGETYPE, c10770c.m65594f());
                C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_SCENETYPE, str);
                if (i10 == 0) {
                    C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_INTERVAL, c10770c.m65593e());
                }
                this.f13193g = true;
                return true;
            }
            if (!str.equals("exit") || this.f13194h) {
                if (!this.f13193g || !this.f13194h) {
                    return false;
                }
                this.f13192f = true;
                return false;
            }
            C11839m.m70686d("QueryGuideH5Task", "procOtherOperation start to save SP when exitPosition == 2, sceneType == exit");
            C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NUM, 2);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NOTIFYURL, strM65583b);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NOTIFYTYPE, strM65582a);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_H5URL, str2);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_BEGINTIME, c10770c.m65589a());
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_ENDTIME, c10770c.m65590b());
            C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_FREQUENCY, i10);
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PAGETYPE, c10770c.m65594f());
            C0212e0.m1372v(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_SCENETYPE, str);
            if (i10 == 0) {
                C0212e0.m1368r(this.f13190d, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_INTERVAL, c10770c.m65593e());
            }
            this.f13194h = true;
            return true;
        }
        if (!str.equals("exit")) {
            return false;
        }
        if (i12 == 2) {
            C11839m.m70686d("QueryGuideH5Task", "procOtherOperation start to save SP when exitPosition == 2, sceneType == exit, campaignSource == 2");
            C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_NUM, 2);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_NOTIFYURL, strM65583b);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_NOTIFYTYPE, strM65582a);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_H5URL, str2);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_BEGINTIME, c10770c.m65589a());
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_ENDTIME, c10770c.m65590b());
            C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_FREQUENCY, i10);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_PAGETYPE, c10770c.m65594f());
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_SCENETYPE, str);
            if (i10 == 0) {
                C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_INTERVAL, c10770c.m65593e());
            }
        } else {
            C11839m.m70686d("QueryGuideH5Task", "procOtherOperation start to save SP when exitPosition == 2, sceneType == exit, campaignSource != 2");
            C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_NUM, 2);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_NOTIFYURL, strM65583b);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_NOTIFYTYPE, strM65582a);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_H5URL, str2);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_BEGINTIME, c10770c.m65589a());
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_ENDTIME, c10770c.m65590b());
            C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_FREQUENCY, i10);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PAGETYPE, c10770c.m65594f());
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_SCENETYPE, str);
            if (i10 == 0) {
                C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_INTERVAL, c10770c.m65593e());
            }
        }
        GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_QUERY_END, " scenetype: " + str + " pagetype: " + c10770c.m65594f() + " beginTime: " + c10770c.m65589a() + " endTime: " + c10770c.m65590b() + " action: " + this.f13205s);
        this.f13192f = true;
        return true;
    }

    /* renamed from: U */
    public final boolean m18263U(int i10, int i11, List<C10769b> list, C10770c c10770c, String str, Bundle bundle, int i12, String str2, int i13) {
        String strM65583b;
        String str3;
        String str4;
        String strValueOf;
        CloudSpace cloudSpace;
        ActivityEntry entry;
        boolean zEquals = str.equals(NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE);
        String strM18235I = m18235I(this.f13190d, zEquals, this.f13191e);
        String strM18234H = m18234H(this.f13190d, zEquals, this.f13191e);
        C10768a c10768aM65585b = list.get(i12).m65585b();
        String gradeCode = "";
        if (c10768aM65585b != null) {
            String strM65582a = c10768aM65585b.m65582a();
            strM65583b = c10768aM65585b.m65583b();
            str3 = strM65582a;
        } else {
            strM65583b = "";
            str3 = strM65583b;
        }
        GetActivityEntryResp getActivityEntryResp = this.f13196j;
        String url = (getActivityEntryResp == null || (entry = getActivityEntryResp.getEntry()) == null) ? "" : entry.getUrl();
        String strM65594f = c10770c.m65594f();
        if (this.f13197k == null || (cloudSpace = this.f13198l) == null) {
            str4 = "";
            strValueOf = str4;
        } else {
            if (cloudSpace.getGradeCode() != null) {
                gradeCode = this.f13198l.getGradeCode();
            } else {
                C11839m.m70687e("QueryGuideH5Task", "latestCloudSpace have value but gradeCode is null");
            }
            strValueOf = String.valueOf(Math.abs(this.f13198l.getEndTime() - this.f13197k.getServerTime()));
            str4 = gradeCode;
        }
        String strM65589a = c10770c.m65589a();
        String strM65590b = c10770c.m65590b();
        String strM18233E = m18233E(this.f13190d, this.f13191e);
        int i14 = this.f13202p;
        if (i14 == 1) {
            if (m18265W(str, i11, c10770c, strM18235I, strM18234H, bundle, i10, strM65583b, str3, str2, url, str4, strValueOf, strM18233E, strM65594f, strM65589a, strM65590b)) {
                return true;
            }
        } else {
            if (i14 != 2) {
                C11839m.m70688i("QueryGuideH5Task", "procMemberBeforeExpire exitPosition invalid");
                return false;
            }
            if (m18264V(str, i11, c10770c, strM18235I, strM18234H, i13, i10, strM65583b, str3, str2, url, str4, strValueOf, strM18233E, strM65594f, strM65589a, strM65590b)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: V */
    public final boolean m18264V(String str, int i10, C10770c c10770c, String str2, String str3, int i11, int i12, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        C3024d2 c3024d2;
        C3024d2 c3024d22;
        if (str.equals(NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE) && !this.f13193g) {
            C11839m.m70688i("QueryGuideH5Task", "procOtherOperationNewOnlySaveSp OPER_ENTRY mFindEntryOK in: mFindEntryOK:  " + this.f13193g);
            m18269b0(str2, str3, i12, str4, str5, str7, this.f13195i, str6, i10, str11, str, str8, str9, str10, str12, str13);
            if (i10 == 0) {
                int iM65593e = c10770c.m65593e();
                c3024d22 = this;
                C0212e0.m1368r(c3024d22.f13190d, str2, str3 + "_interval", iM65593e);
            } else {
                c3024d22 = this;
            }
            c3024d22.f13193g = true;
            return true;
        }
        if (!str.equals("exit") || this.f13194h) {
            if ((!this.f13193g || !this.f13194h) && i11 != 2 && i11 != 3) {
                return false;
            }
            this.f13192f = true;
            return false;
        }
        C11839m.m70688i("QueryGuideH5Task", "procOtherOperationNewOnlySaveSp OPER_EXIT mFindEntryOK in: mFindEntryOK:  " + this.f13193g);
        m18269b0(str2, str3, i12, str4, str5, str7, this.f13195i, str6, i10, str11, str, str8, str9, str10, str12, str13);
        if (i10 == 0) {
            int iM65593e2 = c10770c.m65593e();
            c3024d2 = this;
            C0212e0.m1368r(c3024d2.f13190d, str2, str3 + "_interval", iM65593e2);
        } else {
            c3024d2 = this;
        }
        c3024d2.f13194h = true;
        return true;
    }

    /* renamed from: W */
    public final boolean m18265W(String str, int i10, C10770c c10770c, String str2, String str3, Bundle bundle, int i11, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        C3024d2 c3024d2;
        int iM65593e = 0;
        if (!str.equals(NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE) || this.f13193g) {
            if (!str.equals("exit") || this.f13194h) {
                if (this.f13193g && this.f13194h) {
                    this.f13192f = true;
                }
                return false;
            }
            C11839m.m70688i("QueryGuideH5Task", "procOtherOperationNewShowNow OPER_EXIT mFindEntryOK in: mFindEntryOK:  " + this.f13193g);
            m18269b0(str2, str3, i11, str4, str5, str7, this.f13195i, str6, i10, str11, str, str8, str9, str10, str12, str13);
            if (i10 == 0) {
                int iM65593e2 = c10770c.m65593e();
                c3024d2 = this;
                C0212e0.m1368r(c3024d2.f13190d, str2, str3 + "_interval", iM65593e2);
            } else {
                c3024d2 = this;
            }
            c3024d2.f13194h = true;
            return true;
        }
        if (i10 == 0) {
            iM65593e = c10770c.m65593e();
            C0212e0.m1368r(this.f13190d, str2, str3 + "_interval", iM65593e);
        }
        C11839m.m70688i("QueryGuideH5Task", "procOtherOperationNewShowNow OPER_ENTRY mFindEntryOK in: mFindEntryOK:  " + this.f13193g);
        bundle.putInt("interval", iM65593e);
        bundle.putInt("queryh5oknum", i11);
        bundle.putInt("frequency", i10);
        bundle.putString(NotifyConstants.Keys.NOTIFY_URI, str4);
        bundle.putString(NotifyConstants.Keys.NOTIFY_TYPE, str5);
        bundle.putString("h5Uri", str6);
        bundle.putString("activeUri", str7);
        bundle.putString("packageId", this.f13195i);
        bundle.putString("gradeCode", str8);
        bundle.putString("expireTime", str9);
        bundle.putString(FrequencyManager.H5DialogConstant.FROM_WHICH_ACTIVITY, str10);
        Handler handler = this.f13187a;
        handler.sendMessage(handler.obtainMessage(1, bundle));
        m18269b0(str2, str3, i11, str4, str5, str7, this.f13195i, str6, i10, str11, str, str8, str9, str10, str12, str13);
        this.f13193g = true;
        return true;
    }

    /* renamed from: X */
    public final GetActivityEntryResp m18266X(Message message) {
        if (message == null) {
            C11839m.m70687e("QueryGuideH5Task", "processGetActivityEntrySuccess entry success, but msg is null");
            return null;
        }
        Object obj = message.obj;
        if (!(obj instanceof GetActivityEntryResp)) {
            C11839m.m70687e("QueryGuideH5Task", "process get activity entry success, but msg obj is not GetActivityEntryResp");
            return null;
        }
        GetActivityEntryResp getActivityEntryResp = (GetActivityEntryResp) obj;
        if (getActivityEntryResp.getResultCode() == 0) {
            ActivityEntry entry = getActivityEntryResp.getEntry();
            if (entry == null) {
                C11839m.m70687e("QueryGuideH5Task", "get activity entry SUCCESS, but activityEntry == null");
                return null;
            }
            String resource = entry.getResource();
            String url = entry.getUrl();
            C11839m.m70686d("QueryGuideH5Task", "get activity entry SUCCESS , resourceId " + resource + " url " + url);
            DlAppCampInfo campaignInfo = entry.getCampaignInfo();
            if (campaignInfo == null) {
                C11839m.m70687e("QueryGuideH5Task", "get activity entry SUCCESS, but campaignInfo is null");
                return null;
            }
            AdParametersExt adParametersExt = campaignInfo.getAdParametersExt();
            if (adParametersExt == null) {
                C11839m.m70686d("QueryGuideH5Task", "checkPpsAdsIsOk, but campaignInfo is null");
                return null;
            }
            C10121i.m63036b(adParametersExt);
            String ppsAdid = adParametersExt.getPpsAdid();
            C11839m.m70686d("QueryGuideH5Task", "get activity entry SUCCESS ,  adId " + ppsAdid);
            if (!TextUtils.isEmpty(resource) && !TextUtils.isEmpty(url) && !TextUtils.isEmpty(ppsAdid)) {
                return getActivityEntryResp;
            }
            C11839m.m70687e("QueryGuideH5Task", "get activity entry SUCCESS, resourceId or url is null");
        }
        return null;
    }

    /* renamed from: Z */
    public final void m18267Z(int i10, String str, int i11, String str2, String str3, int i12, C10770c c10770c) {
        if (i10 == 2) {
            C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_NUM, 0);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_PACKAGEID, this.f13195i);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_H5URL, str);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_BEGINTIME, c10770c.m65589a());
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_ENDTIME, c10770c.m65590b());
            C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_FREQUENCY, i11);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_PAGETYPE, str2);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_SCENETYPE, str3);
            if (i11 == 0) {
                C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_INTERVAL, i12);
            }
        } else {
            C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_NUM, 0);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PACKAGEID, this.f13195i);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_H5URL, str);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_BEGINTIME, c10770c.m65589a());
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_ENDTIME, c10770c.m65590b());
            C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_FREQUENCY, i11);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PAGETYPE, str2);
            C0212e0.m1372v(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_SCENETYPE, str3);
            if (i11 == 0) {
                C0212e0.m1368r(this.f13190d, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_INTERVAL, i12);
            }
        }
        GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_QUERY_END, " scenetype: " + str3 + " pagetype: " + c10770c.m65594f() + " beginTime: " + c10770c.m65589a() + " endTime: " + c10770c.m65590b() + " action: " + this.f13205s);
    }

    /* renamed from: a0 */
    public final void m18268a0(List<C10770c> list) {
        if (list.size() < 1) {
            return;
        }
        if ("drive".equals(this.f13191e)) {
            m18271d0(list, "drive");
            return;
        }
        Activity activity = this.f13190d;
        if (activity instanceof CloudSpaceUpgradeActivity) {
            m18270c0(list, RecommendCardConstants.Entrance.BUY);
            return;
        }
        if (activity instanceof MainActivity) {
            Iterator<C10770c> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().m65594f().equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                    it.remove();
                }
            }
            return;
        }
        if ((activity instanceof CloudSpaceGuideActivity) || (activity instanceof CloudBackupSpaceUnEnoughActivity)) {
            m18270c0(list, "recommend");
        } else if (activity instanceof BackupMainActivity) {
            m18271d0(list, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        } else if (activity instanceof IntelligentClearActivity) {
            m18271d0(list, "clean");
        }
    }

    /* renamed from: b0 */
    public final void m18269b0(String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7, int i11, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        if (str == null || str.isEmpty()) {
            C11839m.m70687e("QueryGuideH5Task", "get spName error");
            return;
        }
        if (str2 == null || str2.isEmpty()) {
            C11839m.m70687e("QueryGuideH5Task", "get spAttrPrefix error");
            return;
        }
        C0212e0.m1368r(this.f13190d, str, str2 + "_num", i10);
        C0212e0.m1368r(this.f13190d, str, str2 + "_frequency", i11);
        C0212e0.m1372v(this.f13190d, str, str2 + "_" + FrequencyManager.H5DialogConstant.NOTIFYURL, str3);
        C0212e0.m1372v(this.f13190d, str, str2 + "_" + FrequencyManager.H5DialogConstant.NOTIFYTYPE, str4);
        C0212e0.m1372v(this.f13190d, str, str2 + "_" + FrequencyManager.H5DialogConstant.ACTIVEURL, str5);
        C0212e0.m1372v(this.f13190d, str, str2 + "_" + FrequencyManager.H5DialogConstant.PACKAGEID, str6);
        C0212e0.m1372v(this.f13190d, str, str2 + "_" + FrequencyManager.H5DialogConstant.H5URL, str7);
        C0212e0.m1372v(this.f13190d, str, str2 + "_pageType", str8);
        C0212e0.m1372v(this.f13190d, str, str2 + "_" + FrequencyManager.H5DialogConstant.SCENETYPE, str9);
        C0212e0.m1372v(this.f13190d, str, str2 + "_gradeCode", str10);
        C0212e0.m1372v(this.f13190d, str, str2 + "_expireTime", str11);
        C0212e0.m1372v(this.f13190d, str, str2 + "_" + FrequencyManager.H5DialogConstant.FROM_WHICH_ACTIVITY, str12);
        C0212e0.m1372v(this.f13190d, str, str2 + "_" + FrequencyManager.H5DialogConstant.BEGIN_TIME, str13);
        C0212e0.m1372v(this.f13190d, str, str2 + "_endTime", str14);
    }

    /* renamed from: c0 */
    public final void m18270c0(List<C10770c> list, String str) {
        Iterator<C10770c> it = list.iterator();
        while (it.hasNext()) {
            C10770c next = it.next();
            if (!next.m65594f().equals(str) || !next.m65596h().equals("exit")) {
                it.remove();
            }
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_QUERY_START, "from activity= " + this.f13204r);
        C10772e c10772eM66464a = new C11024a().m66464a();
        if (c10772eM66464a != null) {
            this.f13203q = c10772eM66464a.m65600b();
        } else {
            C11839m.m70688i("QueryGuideH5Task", "config is null");
        }
        if (m18255M(c10772eM66464a)) {
            C11839m.m70688i("QueryGuideH5Task", "isNeedSartGuidH5 OK end");
        } else {
            C11839m.m70688i("QueryGuideH5Task", "isNeedSartGuidH5 end ");
        }
        if (this.f13202p != 1 || this.f13193g) {
            return;
        }
        C11839m.m70688i("QueryGuideH5Task", "isNeedSartGuidH5 exitPosition == 1 && !mFindEntryOK ");
        Handler handler = this.f13187a;
        handler.sendMessage(handler.obtainMessage(0));
    }

    /* renamed from: d0 */
    public final void m18271d0(List<C10770c> list, String str) {
        Iterator<C10770c> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().m65594f().equals(str)) {
                it.remove();
            }
        }
    }

    /* renamed from: e0 */
    public final void m18272e0(List<C10769b> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        Collections.sort(list, new e(null));
    }

    /* renamed from: f0 */
    public final void m18273f0(List<C10770c> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        Collections.sort(list, new f(null));
    }

    /* renamed from: g0 */
    public final void m18274g0(final int i10, AdParametersExt adParametersExt, final CountDownLatch countDownLatch, String str) {
        if (adParametersExt == null || !adParametersExt.isRequestAgdResource(i10, str)) {
            this.f13200n = 1;
            countDownLatch.countDown();
        } else {
            C12515a.m75110o().m75175e(new C10221d1(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.c2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f13172a.m18256N(i10, countDownLatch, (List) obj);
                }
            }, adParametersExt.getAgdAdid()), false);
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.QUERY_GUIDE_H5_TASK;
    }

    /* renamed from: n */
    public final void m18275n(int i10, List<C10769b> list, C10770c c10770c, int i11, C11060c c11060c, String str, boolean z10) throws NumberFormatException {
        m18272e0(list);
        m18247B(list, i11);
        Bundle bundle = new Bundle();
        for (int i12 = 0; i12 < list.size(); i12++) {
            String strM65588e = list.get(i12).m65588e();
            this.f13205s = list.get(i12).m65584a();
            List<Integer> listM65587d = list.get(i12).m65587d();
            C11839m.m70688i("QueryGuideH5Task", "isNeedSartGuidH5 mActionNum=" + this.f13205s + ", operPageHintBean.getPriority(): " + c10770c.m65595g());
            int i13 = this.f13205s;
            if (i13 == 0) {
                if (m18278q(i10, bundle, strM65588e, c10770c, i11, c11060c, str, z10)) {
                    return;
                }
            } else if (i13 == 1) {
                if (m18276o(i10, bundle, strM65588e, c10770c, i11, str, z10)) {
                    return;
                }
            } else if (i13 == 2) {
                if (m18281t(i10, bundle, strM65588e, list, c10770c, i11, i12, str, z10)) {
                    return;
                }
            } else if (i13 == 3) {
                if (m18279r(i10, bundle, strM65588e, list, listM65587d, c10770c, i11, i12, str)) {
                    return;
                }
            } else if (i13 != 4) {
                if (i13 == 5) {
                    if (m18277p(i10, strM65588e, c10770c, str)) {
                        return;
                    }
                }
            } else if (m18280s(i10, bundle, strM65588e, list, listM65587d, c10770c, i11, i12, str)) {
                return;
            }
        }
    }

    /* renamed from: o */
    public final boolean m18276o(int i10, Bundle bundle, String str, C10770c c10770c, int i11, String str2, boolean z10) {
        if (this.f13196j == null) {
            this.f13196j = m18250F(i11);
        }
        if (this.f13196j == null) {
            return false;
        }
        C11839m.m70688i("QueryGuideH5Task", "getActivityEntryResp not null.");
        ActivityEntry entry = this.f13196j.getEntry();
        if (!this.f13199m) {
            this.f13199m = m18282u(entry, 1, i11);
        }
        if (!this.f13199m) {
            return false;
        }
        C11839m.m70688i("QueryGuideH5Task", "procActiveDownload in  sceneType: " + str2);
        m18258P(i10, c10770c, str2, bundle, str, entry, z10, i11);
        return true;
    }

    /* renamed from: p */
    public final boolean m18277p(int i10, String str, C10770c c10770c, String str2) {
        if (!m18253K()) {
            return false;
        }
        m18259Q(i10, c10770c, str2, str);
        return true;
    }

    /* renamed from: q */
    public final boolean m18278q(int i10, Bundle bundle, String str, C10770c c10770c, int i11, C11060c c11060c, String str2, boolean z10) {
        if (TextUtils.isEmpty(this.f13195i)) {
            this.f13195i = m18251G(c11060c);
        }
        if (TextUtils.isEmpty(this.f13195i)) {
            return false;
        }
        C11839m.m70688i("QueryGuideH5Task", "procActionFirstMonthZero in  sceneType: " + str2);
        m18257O(i10, c10770c, str2, bundle, str, z10, i11);
        return true;
    }

    /* renamed from: r */
    public final boolean m18279r(int i10, Bundle bundle, String str, List<C10769b> list, List<Integer> list2, C10770c c10770c, int i11, int i12, String str2) {
        if (list2 == null) {
            return false;
        }
        if (this.f13197k == null) {
            C11839m.m70688i("QueryGuideH5Task", "BeforeExpire userPackage is null, get again");
            this.f13197k = m18252J("memberBeforeExpire");
        }
        return m18283v(this.f13197k, list2) && m18261S(i10, list, c10770c, str2, bundle, i12, str, i11);
    }

    /* renamed from: s */
    public final boolean m18280s(int i10, Bundle bundle, String str, List<C10769b> list, List<Integer> list2, C10770c c10770c, int i11, int i12, String str2) {
        if (list2 == null) {
            return false;
        }
        if (this.f13197k == null) {
            C11839m.m70688i("QueryGuideH5Task", "AlreadyExpire userPackage is null, get again");
            this.f13197k = m18252J("menberAlreadyExpire");
        }
        return m18284y(this.f13197k, list2) && m18260R(i10, list, c10770c, str2, bundle, i12, str, i11);
    }

    /* renamed from: t */
    public final boolean m18281t(int i10, Bundle bundle, String str, List<C10769b> list, C10770c c10770c, int i11, int i12, String str2, boolean z10) {
        return m18262T(i10, list, c10770c, str2, bundle, i12, str, z10, i11);
    }

    /* renamed from: u */
    public final boolean m18282u(ActivityEntry activityEntry, int i10, int i11) {
        C11839m.m70688i("QueryGuideH5Task", "checkPpsAdsIsOk start");
        if (activityEntry == null) {
            C11839m.m70686d("QueryGuideH5Task", "checkPpsAdsIsOk fail, activityEntry is null");
            return false;
        }
        String resource = activityEntry.getResource();
        C11839m.m70686d("QueryGuideH5Task", "checkPpsAdsIsOk , resourceId " + resource);
        DlAppCampInfo campaignInfo = activityEntry.getCampaignInfo();
        if (campaignInfo == null) {
            C11839m.m70686d("QueryGuideH5Task", "checkPpsAdsIsOk, but campaignInfo is null");
            return false;
        }
        int minLimit = campaignInfo.getMinLimit();
        int launchNo = campaignInfo.getLaunchNo();
        AdParametersExt adParametersExt = campaignInfo.getAdParametersExt();
        if (adParametersExt == null) {
            C11839m.m70686d("QueryGuideH5Task", "checkPpsAdsIsOk, but campaignInfo is null");
            return false;
        }
        String ppsAdid = adParametersExt.getPpsAdid();
        C10121i.m63036b(adParametersExt);
        C11839m.m70686d("QueryGuideH5Task", "checkPpsAdsIsOk , minLimit " + minLimit + " launchNo " + launchNo + " adId " + ppsAdid);
        if (TextUtils.isEmpty(resource) || TextUtils.isEmpty(ppsAdid)) {
            C11839m.m70686d("QueryGuideH5Task", "checkPpsAdsIsOk , resourceId or url is null");
            return false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f13200n = -1;
        C12515a.m75110o().m75175e(new C9057a(resource, 1, ppsAdid, new a(Looper.getMainLooper(), countDownLatch, campaignInfo, ppsAdid), i11), false);
        try {
            if (!countDownLatch.await(5L, TimeUnit.SECONDS)) {
                C11839m.m70686d("QueryGuideH5Task", "wait not finish");
            }
        } catch (InterruptedException unused) {
            C11839m.m70689w("QueryGuideH5Task", "syncLock wait catch InterruptedException.");
        }
        GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_EXCEPTION, "checkPpsAdsNumOk=" + this.f13200n);
        C11839m.m70688i("QueryGuideH5Task", "checkPpsAdsIsOk end, check pps ad result = " + this.f13200n);
        return this.f13200n == 0;
    }

    /* renamed from: v */
    public final boolean m18283v(UserPackage userPackage, List<Integer> list) {
        if (userPackage != null) {
            List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
            long serverTime = userPackage.getServerTime();
            if (C2783d.m16171q(effectivePackages, 1) != null) {
                C11839m.m70688i("QueryGuideH5Task", "BeforeExpired petalSpace is not null");
                return false;
            }
            CloudSpace cloudSpaceM16171q = C2783d.m16171q(effectivePackages, 0);
            if (serverTime == 0 || cloudSpaceM16171q == null || cloudSpaceM16171q.getGradeCode().equals("N")) {
                C11839m.m70688i("QueryGuideH5Task", "BeforeExpired serverTime or normalSpace error");
                return false;
            }
            if (userPackage.getIsAutoPay() == 1) {
                C11839m.m70688i("QueryGuideH5Task", "auto pay user, not show BeforeExpired dialog");
                return false;
            }
            this.f13198l = cloudSpaceM16171q;
            int endTime = (int) ((cloudSpaceM16171q.getEndTime() - serverTime) / 86400000);
            if (list.contains(Integer.valueOf(endTime))) {
                return true;
            }
            C11839m.m70688i("QueryGuideH5Task", "BeforeExpired not cotains days: " + endTime);
        }
        C11839m.m70688i("QueryGuideH5Task", "BeforeExpired userPackage still null");
        return false;
    }

    /* renamed from: y */
    public final boolean m18284y(UserPackage userPackage, List<Integer> list) {
        if (userPackage != null) {
            List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
            long serverTime = userPackage.getServerTime();
            if (C2783d.m16171q(effectivePackages, 1) != null) {
                C11839m.m70688i("QueryGuideH5Task", "AlreadyExpired petalSpace is not null");
                return false;
            }
            CloudSpace cloudSpaceM16171q = C2783d.m16171q(effectivePackages, 0);
            if (serverTime == 0 || cloudSpaceM16171q == null || !cloudSpaceM16171q.getGradeCode().equals("N")) {
                C11839m.m70688i("QueryGuideH5Task", "AlreadyExpired serverTime or normalSpace error");
                return false;
            }
            CloudSpace expiredPackage = userPackage.getExpiredPackage();
            if (expiredPackage == null) {
                C11839m.m70688i("QueryGuideH5Task", "AlreadyExpired expiredSpace is null");
                return false;
            }
            this.f13198l = expiredPackage;
            int endTime = (int) ((serverTime - expiredPackage.getEndTime()) / 86400000);
            if (list.contains(Integer.valueOf(endTime))) {
                return true;
            }
            C11839m.m70688i("QueryGuideH5Task", "AlreadyExpired not cotains days: " + endTime);
        }
        C11839m.m70688i("QueryGuideH5Task", "AlreadyExpired userPackage still null");
        return false;
    }

    /* renamed from: z */
    public final boolean m18285z(List<PortraitAndGrade.UserTag> list, C10770c c10770c) {
        ArrayList<String> arrayListM65597i = c10770c.m65597i();
        if (arrayListM65597i == null || arrayListM65597i.isEmpty()) {
            return true;
        }
        if (!AdSwitchManager.getInstance().canDisplayAd(NotifyConstants.CommonReportConstants.SRC_AD_SWITCH_QUERY_GUIDE)) {
            C11839m.m70689w("QueryGuideH5Task", "can't display ad");
            return false;
        }
        if (list != null && !list.isEmpty()) {
            for (String str : arrayListM65597i) {
                Iterator<PortraitAndGrade.UserTag> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserGroupExtID().equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
