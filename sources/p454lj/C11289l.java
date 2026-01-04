package p454lj;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.DlAppCampInfo;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.UserTags;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import p222da.C9060d;
import p315gj.C9948a;
import p329h7.C10121i;
import p341hj.C10221d1;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p616rk.C12515a;
import p846zj.C14306d;

/* renamed from: lj.l */
/* loaded from: classes5.dex */
public class C11289l {

    /* renamed from: a */
    public static int f52940a = -1;

    /* renamed from: lj.l$a */
    public class a extends Handler {

        /* renamed from: a */
        public final /* synthetic */ DlAppCampInfo f52941a;

        /* renamed from: b */
        public final /* synthetic */ CountDownLatch f52942b;

        /* renamed from: c */
        public final /* synthetic */ int f52943c;

        /* renamed from: d */
        public final /* synthetic */ int f52944d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, DlAppCampInfo dlAppCampInfo, CountDownLatch countDownLatch, int i10, int i11) {
            super(looper);
            this.f52941a = dlAppCampInfo;
            this.f52942b = countDownLatch;
            this.f52943c = i10;
            this.f52944d = i11;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj = message.obj;
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            int i10 = message.what;
            if (i10 == 7014) {
                C11289l.m67739m(iIntValue, this.f52941a.getAdParametersExt(), this.f52942b, this.f52943c, this.f52944d);
            } else if (i10 != 7015) {
                C11289l.m67737k(this.f52942b);
            } else {
                C11289l.m67738l(this.f52942b);
            }
        }
    }

    /* renamed from: e */
    public static boolean m67731e(ActivityEntry activityEntry, String str, int i10, boolean z10) {
        C11839m.m70688i("MarketingUtil", "checkPpsAdsIsOk start");
        if (activityEntry == null) {
            C11839m.m70686d("MarketingUtil", "checkPpsAdsIsOk fail, activityEntry is null");
            return false;
        }
        if (!"dlApp".equals(activityEntry.getcType())) {
            C11839m.m70686d("MarketingUtil", "checkPpsAdsIsOk fail, but cType is not dlApp , so no campaignInfo ");
            return false;
        }
        String resource = activityEntry.getResource();
        C11839m.m70686d("MarketingUtil", "checkPpsAdsIsOk , resourceId " + resource);
        DlAppCampInfo campaignInfo = activityEntry.getCampaignInfo();
        if (campaignInfo == null) {
            C11839m.m70686d("MarketingUtil", "checkPpsAdsIsOk, but campaignInfo is null");
            return false;
        }
        int minLimit = campaignInfo.getMinLimit();
        int launchNo = campaignInfo.getLaunchNo();
        AdParametersExt adParametersExt = campaignInfo.getAdParametersExt();
        if (adParametersExt == null) {
            C11839m.m70687e("MarketingUtil", " parametersExt is null");
            return false;
        }
        String ppsAdid = adParametersExt.getPpsAdid();
        C11839m.m70686d("MarketingUtil", "checkPpsAdsIsOk , minLimit " + minLimit + " launchNo " + launchNo + " adId " + ppsAdid);
        if (TextUtils.isEmpty(resource) || TextUtils.isEmpty(ppsAdid)) {
            C11839m.m70686d("MarketingUtil", "checkPpsAdsIsOk , resourceId or url is null");
            return false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        f52940a = -1;
        C10121i.m63036b(adParametersExt);
        C12515a.m75110o().m75175e(new C9060d(resource, minLimit, launchNo, ppsAdid, new a(Looper.getMainLooper(), campaignInfo, countDownLatch, launchNo, minLimit), i10, z10), false);
        try {
            if (!countDownLatch.await(30L, TimeUnit.SECONDS)) {
                C11839m.m70686d("MarketingUtil", "wait not finish");
            }
        } catch (InterruptedException unused) {
            C11839m.m70689w("MarketingUtil", "syncLock wait catch InterruptedException.");
        }
        C11839m.m70688i("MarketingUtil", "checkPpsAdsIsOk end, check pps ad result = " + f52940a);
        NotificationReportUtil.reportPrepareActivityNoSpace("0008", " noticeType = " + str + ", result = 0010_" + f52940a);
        return f52940a == 0;
    }

    /* renamed from: f */
    public static void m67732f() {
        C14306d.m85218s();
    }

    /* renamed from: g */
    public static GetActivityEntryResp m67733g(long j10, int i10) {
        return m67734h(j10, i10, true);
    }

    /* renamed from: h */
    public static GetActivityEntryResp m67734h(long j10, int i10, boolean z10) {
        m67732f();
        GetActivityEntryResp getActivityEntryResp = new GetActivityEntryResp();
        try {
            C11060c c11060c = new C11060c();
            c11060c.m66636B("06008");
            c11060c.m66643I(C11058a.m66627b("06008"));
            c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
            c11060c.m66670z("2.0");
            UserTags userTags = new UserTags();
            userTags.setRequiredQuota(j10);
            return C9948a.m61631C().m61691r(userTags, i10, c11060c, z10);
        } catch (Exception e10) {
            NotifyLogger.m29914e("MarketingUtil", "getActivityEntry error " + e10.getMessage());
            return getActivityEntryResp;
        }
    }

    /* renamed from: i */
    public static GetActivityEntryResp m67735i(long j10, String str) {
        GetActivityEntryResp getActivityEntryRespM67733g = TextUtils.equals(str, NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT) ? m67733g(j10, NotifyConstants.MarketingConstant.CSOURCE_VALUE_BACKUP_FAIL_NOTIFICATION_POPUP) : m67733g(j10, 401);
        NotificationReportUtil.reportPrepareActivityNoSpace("0008", " notifyType = " + str);
        return getActivityEntryRespM67733g;
    }

    /* renamed from: j */
    public static /* synthetic */ void m67736j(int i10, int i11, int i12, CountDownLatch countDownLatch, List list) {
        if (i10 + i11 + list.size() >= i12) {
            m67738l(countDownLatch);
        } else {
            m67737k(countDownLatch);
        }
    }

    /* renamed from: k */
    public static void m67737k(CountDownLatch countDownLatch) {
        C11839m.m70688i("MarketingUtil", "checkPpsAdsIsOk msg check fail");
        f52940a = 1;
        countDownLatch.countDown();
    }

    /* renamed from: l */
    public static void m67738l(CountDownLatch countDownLatch) {
        C11839m.m70688i("MarketingUtil", "checkPpsAdsIsOk msg check success");
        f52940a = 0;
        countDownLatch.countDown();
    }

    /* renamed from: m */
    public static void m67739m(final int i10, AdParametersExt adParametersExt, final CountDownLatch countDownLatch, final int i11, final int i12) {
        if (adParametersExt == null || !adParametersExt.isRequestAgdResource(0, null)) {
            m67737k(countDownLatch);
        } else {
            C12515a.m75110o().m75175e(new C10221d1(new Consumer() { // from class: lj.k
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C11289l.m67736j(i11, i10, i12, countDownLatch, (List) obj);
                }
            }, adParametersExt.getAgdAdid()), false);
        }
    }
}
