package p252e9;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.notification.constants.BackUpOverMonthRecordConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.manager.HiCloudSceneBannerManager;
import com.huawei.hicloud.notification.p106db.bean.ClearOverMonths;
import com.huawei.hicloud.notification.p106db.bean.SceneNotices;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import java.util.LinkedHashMap;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13225d;
import p703v8.C13367d;

/* renamed from: e9.c */
/* loaded from: classes3.dex */
public class C9426c {

    /* renamed from: a */
    public String f47101a;

    /* renamed from: b */
    public long f47102b;

    /* renamed from: c */
    public long f47103c;

    /* renamed from: d */
    public long f47104d;

    /* renamed from: e */
    public long f47105e;

    /* renamed from: e9.c$a */
    public static class a {

        /* renamed from: a */
        public static final C9426c f47106a = new C9426c(null);
    }

    /* renamed from: e9.c$b */
    public static class b extends AbstractC12367d {

        /* renamed from: a */
        public final String f47107a;

        /* renamed from: b */
        public final String f47108b;

        public b(String str, String str2) {
            this.f47107a = str;
            this.f47108b = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            CloudSpace cloudSpaceM80181d = C13367d.m80180e().m80181d();
            String strValueOf = cloudSpaceM80181d == null ? "" : String.valueOf(cloudSpaceM80181d.getTotal() - cloudSpaceM80181d.getUsed());
            linkedHashMap.put("userPackage", UserSpaceUtil.getGradeCodeUseCache("BackUpOverMonthRecordManager"));
            linkedHashMap.put("availableSpace", strValueOf);
            C13225d.m79490f1().m79567R(this.f47108b, linkedHashMap);
            UBAAnalyze.m29947H(this.f47107a, this.f47108b, linkedHashMap);
        }
    }

    public /* synthetic */ C9426c(C9425b c9425b) {
        this();
    }

    /* renamed from: d */
    public static C9426c m59108d() {
        return a.f47106a;
    }

    /* renamed from: a */
    public void m59109a() {
        C0212e0.m1353c("back_up_over_month_record");
    }

    /* renamed from: b */
    public void m59110b() {
        C11839m.m70688i("BackUpOverMonthRecordManager", "clearNotification");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("BackUpOverMonthRecordManager", "context is null");
        } else {
            new HiCloudNotificationManager(contextM1377a).cancelNotification(304);
        }
    }

    /* renamed from: c */
    public boolean m59111c() {
        return C0212e0.m1354d(C0213f.m1377a(), "back_up_over_month_record", BackUpOverMonthRecordConstants.SpKey.AUTO_CLEAR_BACKUP_SWITCH, false);
    }

    /* renamed from: e */
    public int m59112e() {
        SceneNotices sceneNotices = HiCloudSceneBannerManager.getInstance().getSceneNotices(RecommendCardConstants.Entrance.HOMEPAGE);
        if (sceneNotices == null) {
            NotifyLogger.m29914e("BackUpOverMonthRecordManager", "homepageSceneNotices is null");
            return 6;
        }
        ClearOverMonths[] clearOverMonths = sceneNotices.getClearOverMonths();
        if (clearOverMonths == null) {
            NotifyLogger.m29914e("BackUpOverMonthRecordManager", "homepageClearOverMonths is null");
            return 6;
        }
        for (ClearOverMonths clearOverMonths2 : clearOverMonths) {
            if (clearOverMonths2 == null) {
                NotifyLogger.m29914e("BackUpOverMonthRecordManager", "clearOverMonth is null");
            } else {
                int unClearMonths = clearOverMonths2.getUnClearMonths();
                if (m59113f(unClearMonths)) {
                    return unClearMonths;
                }
            }
        }
        SceneNotices sceneNotices2 = HiCloudSceneBannerManager.getInstance().getSceneNotices(RecommendCardConstants.Entrance.BUY);
        if (sceneNotices2 == null) {
            NotifyLogger.m29914e("BackUpOverMonthRecordManager", "buySceneNotices is null");
            return 6;
        }
        ClearOverMonths[] clearOverMonths3 = sceneNotices2.getClearOverMonths();
        if (clearOverMonths3 == null) {
            NotifyLogger.m29914e("BackUpOverMonthRecordManager", "buyClearOverMonths is null");
            return 6;
        }
        for (ClearOverMonths clearOverMonths4 : clearOverMonths3) {
            if (clearOverMonths4 == null) {
                NotifyLogger.m29914e("BackUpOverMonthRecordManager", "clearOverMonth is null");
            } else {
                int unClearMonths2 = clearOverMonths4.getUnClearMonths();
                if (m59113f(unClearMonths2)) {
                    return unClearMonths2;
                }
            }
        }
        return 6;
    }

    /* renamed from: f */
    public final boolean m59113f(int i10) {
        return i10 > 0 && i10 <= 6;
    }

    /* renamed from: g */
    public void m59114g(String str, String str2) {
        C12515a.m75110o().m75172d(new b(str, str2));
    }

    /* renamed from: h */
    public void m59115h(boolean z10) {
        C0212e0.m1365o(C0213f.m1377a(), "back_up_over_month_record", BackUpOverMonthRecordConstants.SpKey.AUTO_CLEAR_BACKUP_SWITCH, z10);
    }

    public C9426c() {
        this.f47101a = "";
        this.f47102b = Long.MIN_VALUE;
        this.f47103c = Long.MIN_VALUE;
        this.f47104d = 0L;
        this.f47105e = Long.MIN_VALUE;
    }
}
