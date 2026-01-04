package com.huawei.android.hicloud.complexutil;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import com.hihonor.android.provider.SettingsEx;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.p088ui.activity.AccountLogoutActivity;
import com.huawei.android.hicloud.p088ui.activity.AccountMismatchAlertActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupMainforSettingActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupRouterActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareJoinByDefaultActivity;
import com.huawei.android.hicloud.p088ui.activity.GalleryLoginActivity;
import com.huawei.android.hicloud.p088ui.activity.HisyncExternalActivity;
import com.huawei.android.hicloud.p088ui.activity.HisyncGuideActivity;
import com.huawei.android.hicloud.p088ui.activity.HisyncSpaceDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.LogoutProcessActivity;
import com.huawei.android.hicloud.p088ui.activity.NewHiSyncSettingActivity;
import com.huawei.android.hicloud.p088ui.activity.OOBECloudBackupRecordsActivity;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity;
import com.huawei.android.hicloud.p088ui.activity.UpgradePopNotificationActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.PaymentManagerAndOrderActivity;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemView;
import com.huawei.android.hicloud.p088ui.uiextend.HicloudVerticalItemView;
import com.huawei.android.hicloud.p088ui.uiextend.StorageManagerCardLayout;
import com.huawei.android.hicloud.p088ui.uiextend.StorageManagerCardViewLayout;
import com.huawei.android.hicloud.task.simple.C3017c;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.provider.SettingsEx;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.DriveModuleConfigManager;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.manager.SyncModuleConfigManager;
import com.huawei.hicloud.notification.p106db.bean.NotifyTypeAndUriGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.notification.p106db.bean.RecommendCardReport;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import io.C10582a;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0214f0;
import p020ap.C1006a;
import p020ap.C1008c;
import p020ap.C1010e;
import p034bc.C1162b;
import p037bp.C1270a;
import p223db.C9062b;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9287f;
import p335hd.C10145h;
import p336he.C10155f;
import p422k9.C11019b;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13226e;
import p684un.C13227f;
import p684un.C13230i;
import p703v8.C13368e;
import p709vj.C13452e;
import p742wj.C13612b;
import p746wn.C13622a;
import p783xp.C13843a;
import p836z8.C14152a;
import p847zk.C14315h;
import p848zl.C14333b;
import vn.C13470b;

/* renamed from: com.huawei.android.hicloud.complexutil.d */
/* loaded from: classes3.dex */
public class C2783d {

    /* renamed from: a */
    public static volatile int f12089a = -1;

    /* renamed from: b */
    public static final List<String> f12090b = new a();

    /* renamed from: com.huawei.android.hicloud.complexutil.d$a */
    public class a extends ArrayList<String> {
        public a() {
            add("gallery_sync");
            add("clouddrive");
        }
    }

    /* renamed from: com.huawei.android.hicloud.complexutil.d$b */
    public class b extends View.AccessibilityDelegate {
        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction(16);
        }
    }

    /* renamed from: com.huawei.android.hicloud.complexutil.d$c */
    public class c extends View.AccessibilityDelegate {
        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClickable(true);
            accessibilityNodeInfo.addAction(16);
        }
    }

    /* renamed from: com.huawei.android.hicloud.complexutil.d$d */
    public class d extends View.AccessibilityDelegate {

        /* renamed from: a */
        public final /* synthetic */ boolean f12091a;

        public d(boolean z10) {
            this.f12091a = z10;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(this.f12091a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.complexutil.d$e */
    public static class e implements C10582a.c {
        @Override // io.C10582a.c
        public void onResult(int i10) {
            C11839m.m70688i("HiSyncUtil", "fullReportSwitchStatus,onResult: " + i10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.complexutil.d$f */
    public static class f extends AbstractC12367d {
        public f() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            boolean z10;
            try {
                LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
                linkedHashMapM79497A.put(CloudBackupConstant.Command.PMS_CMD_BACKUP, String.valueOf(zM62388s));
                Context contextM1377a = C0213f.m1377a();
                boolean zM6138d = contextM1377a != null ? C1010e.m6125b().m6138d(contextM1377a) : false;
                linkedHashMapM79497A.put("phonefinder", String.valueOf(zM6138d));
                List<String> listM6100t = C1008c.m6035v().m6100t(contextM1377a);
                String string = "";
                if (listM6100t == null || listM6100t.size() <= 0) {
                    z10 = false;
                } else {
                    string = listM6100t.toString();
                    z10 = true;
                }
                linkedHashMapM79497A.put("syncStatus", String.valueOf(z10));
                linkedHashMapM79497A.put("openSyncItems", string);
                linkedHashMapM79497A.put("ifHasOpenSwitch", String.valueOf(zM62388s || zM6138d || z10));
                linkedHashMapM79497A.put("ifUdidEmpty", String.valueOf(TextUtils.isEmpty(C0209d.m1324x0())));
                linkedHashMapM79497A.put("dataAnalyzeSwitchStatus", String.valueOf(C13470b.m81125a().m81126b()));
                C13227f.m79492i1().m79567R("refresh_all_switch_status", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "refresh_all_switch_status", "4", "100", linkedHashMapM79497A);
                C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07043"), "07043", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66636B("refresh_all_switch_status");
                c11060cM66626a.m66665u("0");
                C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMapM79497A);
            } catch (Exception e10) {
                C11839m.m70687e("HiSyncUtil", "ReportAllSwitchStatusTask error occur:" + e10.getMessage());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.STOCK_ACTIVE;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.complexutil.d$g */
    public static class g extends AbstractC12367d {

        /* renamed from: a */
        public RecommendCard f12092a;

        /* renamed from: b */
        public int f12093b;

        public g(RecommendCard recommendCard, int i10) {
            this.f12092a = recommendCard;
            this.f12093b = i10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (this.f12092a == null) {
                C11839m.m70687e("HiSyncUtil", "reportRecommendCardSeenByUser card is null.");
                return;
            }
            try {
                LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                linkedHashMapM79497A.put("recommend_card_activity_id", this.f12092a.getActivityId());
                linkedHashMapM79497A.put("recommend_card_activity_type", this.f12092a.getActivityType());
                linkedHashMapM79497A.put("recommend_card_entrance", this.f12092a.getEntrance());
                linkedHashMapM79497A.put("recommend_card_position", String.valueOf(this.f12093b));
                C11839m.m70686d("HiSyncUtil", "recommendCard title:" + this.f12092a.getRemark());
                C13227f.m79492i1().m79567R("recommend_card_banner_seen_by_user", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "recommend_card_banner_seen_by_user", "4", "66", linkedHashMapM79497A);
                C2783d.m16118X0("recommend_card_banner_seen_by_user", linkedHashMapM79497A);
                NotifyTypeAndUriGoto notifyTypeAndUriGoto = this.f12092a.getNotifyTypeAndUriGoto();
                if (notifyTypeAndUriGoto != null && TextUtils.equals(notifyTypeAndUriGoto.getNotifyType(), NotifyConstants.HICLOUD_KA)) {
                    C2783d.m16088I0(this.f12092a, this.f12093b, false);
                }
            } catch (Exception e10) {
                C11839m.m70687e("HiSyncUtil", "reportRecommendCardSeenByUser error occur:" + e10.getMessage());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.RECOMMEND_CARD;
        }
    }

    /* renamed from: com.huawei.android.hicloud.complexutil.d$h */
    public static class h extends AbstractC12367d {

        /* renamed from: a */
        public ArrayList<RecommendCard> f12094a;

        /* renamed from: b */
        public boolean f12095b;

        public h(ArrayList<RecommendCard> arrayList, boolean z10) {
            this.f12094a = new ArrayList<>(arrayList);
            this.f12095b = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Iterator<RecommendCard> it = this.f12094a.iterator();
            while (it.hasNext()) {
                RecommendCard next = it.next();
                if (next != null) {
                    String activityId = next.getActivityId();
                    String activityType = next.getActivityType();
                    String entrance = next.getEntrance();
                    if (!RecommendCardManager.getInstance().isShowKeySetHaveStr(activityId, activityType, entrance)) {
                        try {
                            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                            linkedHashMapM79497A.put("recommend_card_activity_id", activityId);
                            linkedHashMapM79497A.put("recommend_card_activity_type", activityType);
                            linkedHashMapM79497A.put("recommend_card_entrance", entrance);
                            if (this.f12095b) {
                                C13227f.m79492i1().m79567R("recommend_card_detail_activity_banner_show", linkedHashMapM79497A);
                                UBAAnalyze.m29958S("PVC", "recommend_card_detail_activity_banner_show", "4", "66", linkedHashMapM79497A);
                                C2783d.m16118X0("recommend_card_detail_activity_banner_show", linkedHashMapM79497A);
                            } else {
                                C13227f.m79492i1().m79567R("recommend_card_banner_show", linkedHashMapM79497A);
                                UBAAnalyze.m29958S("PVC", "recommend_card_banner_show", "4", "66", linkedHashMapM79497A);
                                C2783d.m16118X0("recommend_card_banner_show", linkedHashMapM79497A);
                            }
                        } catch (Exception e10) {
                            C11839m.m70687e("HiSyncUtil", "reportBannerClickEvent error occur:" + e10.getMessage());
                        }
                    }
                }
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.RECOMMEND_CARD;
        }
    }

    /* renamed from: A */
    public static String m16071A(float f10) {
        return m16073B(f10, 2);
    }

    /* renamed from: A0 */
    public static void m16072A0() {
        C11019b.m66371t().m66430l0("BackupMainforSettingActivity", BackupMainforSettingActivity.class);
        C11019b.m66371t().m66430l0("AccountMismatchAlertActivity", AccountMismatchAlertActivity.class);
        C11019b.m66371t().m66430l0("HisyncGuideActivity", HisyncGuideActivity.class);
        C11019b.m66371t().m66430l0("RestoreMainActivity", RestoreMainActivity.class);
        C11019b.m66371t().m66430l0("OOBECloudBackupRecordsActivity", OOBECloudBackupRecordsActivity.class);
        C11019b.m66371t().m66430l0(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, NewHiSyncSettingActivity.class);
        C11019b.m66371t().m66430l0("CloudSpaceUpgradeActivity", CloudSpaceUpgradeActivity.class);
    }

    /* renamed from: B */
    public static String m16073B(float f10, int i10) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(i10);
        try {
            return percentInstance.format(new BigDecimal(f10).divide(new BigDecimal(100)).doubleValue());
        } catch (Exception unused) {
            C11839m.m70687e("HiSyncUtil", "getLocaleFormatNum params invalid error");
            return "";
        }
    }

    /* renamed from: B0 */
    public static void m16074B0() {
        C11019b.m66371t().m66432m0(C14152a.m84937r0());
        C1162b.m7257a().m7261e(C13612b.m81829B());
    }

    /* renamed from: C */
    public static String m16075C(int i10) {
        try {
            return NumberFormat.getPercentInstance().format(new BigDecimal(i10).divide(new BigDecimal(100)).doubleValue());
        } catch (Exception unused) {
            C11839m.m70687e("HiSyncUtil", "getLocaleFormatNum params invalid error");
            return "";
        }
    }

    /* renamed from: C0 */
    public static void m16076C0() {
        Map<String, Class<?>> gotoAppMapping = NotifyConstants.getGotoAppMapping();
        gotoAppMapping.put(NotifyConstants.BUY_MORE, BackupNotificationActivity.class);
        gotoAppMapping.put("manage", HisyncSpaceDetailActivity.class);
        gotoAppMapping.put(NotifyConstants.CLOUD_STORAGE, HisyncSpaceDetailActivity.class);
        gotoAppMapping.put(NotifyConstants.HICLOUD_BACKUP, BackupMainActivity.class);
        gotoAppMapping.put("login", NewHiSyncSettingActivity.class);
        gotoAppMapping.put(NotifyConstants.HICLOUD_BACKUP_OPTION, BackupOptionsActivity.class);
        gotoAppMapping.put(NotifyConstants.HICLOUD_BACKUP_MANAGER, CloudSpaceBackupActivity.class);
        gotoAppMapping.put(NotifyConstants.HICLOUD_VOUCHER, PaymentManagerAndOrderActivity.class);
        gotoAppMapping.put(NotifyConstants.HICLOUD_BACKUP_DOUBLE_PAGE, BackupRouterActivity.class);
    }

    /* renamed from: D */
    public static long m16077D() {
        long jM1260h0 = C0209d.m1260h0(0, 300) * 1000;
        C11839m.m70688i("HiSyncUtil", "pushguide,getDelayRandomTime:" + jM1260h0);
        return jM1260h0;
    }

    /* renamed from: D0 */
    public static View.AccessibilityDelegate m16078D0() {
        return new b();
    }

    /* renamed from: E */
    public static String m16079E(Context context, String str) {
        int iIntValue;
        return (!C14333b.m85486u().containsKey(str) || (iIntValue = C14333b.m85486u().get(str).intValue()) <= 0 || context == null) ? "" : context.getString(iIntValue);
    }

    /* renamed from: E0 */
    public static void m16080E0() {
        C12515a.m75110o().m75172d(new f(null));
    }

    /* renamed from: F */
    public static String m16081F(Context context, String str) {
        if (context == null) {
            return null;
        }
        return HNConstants.DataType.CONTACT.equals(str) ? context.getString(R$string.recovery_appid_contact) : NavigationUtils.SMS_SCHEMA_PREF.equals(str) ? context.getString(R$string.recovery_appid_sms) : "chatSms".equals(str) ? context.getString(R$string.cloud_enhancement_information) : "calllog".equals(str) ? context.getString(R$string.recovery_appid_calllog) : context.getString(R$string.system_data);
    }

    /* renamed from: F0 */
    public static void m16082F0(String str) {
        try {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07022"), "07022", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0");
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            if (TextUtils.isEmpty(str)) {
                linkedHashMapM79497A.put("creat_desk_shortcut_dialog_show", FaqConstants.DISABLE_HA_REPORT);
            } else {
                linkedHashMapM79497A.put("user_select_which", str);
            }
            C13225d.m79490f1().m79567R("07022", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "07022", linkedHashMapM79497A);
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMapM79497A);
        } catch (Exception e10) {
            C11839m.m70687e("HiSyncUtil", "reportdeskshortcut exception:" + e10.toString());
        }
    }

    /* renamed from: G */
    public static long m16083G() {
        long jM1260h0 = C0209d.m1260h0(0, 300) * 1000;
        C11839m.m70688i("HiSyncUtil", "releaseSpace,getDelayRandomTime:" + jM1260h0);
        return jM1260h0;
    }

    /* renamed from: G0 */
    public static void m16084G0(RecommendCard recommendCard, boolean z10) {
        if (recommendCard == null) {
            C11839m.m70687e("HiSyncUtil", "reportBannerClickEvent card is null.");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("recommend_card_activity_id", recommendCard.getActivityId());
            linkedHashMapM79497A.put("recommend_card_activity_type", recommendCard.getActivityType());
            linkedHashMapM79497A.put("recommend_card_entrance", recommendCard.getEntrance());
            if (z10) {
                C13225d.m79490f1().m79567R("detail_ka_banner_click_fail", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "detail_ka_banner_click_fail", "1", "66", linkedHashMapM79497A);
                m16118X0("detail_ka_banner_click_fail", linkedHashMapM79497A);
            } else {
                C13225d.m79490f1().m79567R("ka_banner_click_fail", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "ka_banner_click_fail", "1", "66", linkedHashMapM79497A);
                m16118X0("ka_banner_click_fail", linkedHashMapM79497A);
            }
        } catch (Exception e10) {
            C11839m.m70687e("HiSyncUtil", "reportKaClickFailed error occur:" + e10.getMessage());
        }
    }

    /* renamed from: H */
    public static String m16085H(float f10) {
        return m16073B(f10, f10 >= 100.0f ? 0 : 2);
    }

    /* renamed from: H0 */
    public static void m16086H0(RecommendCard recommendCard, boolean z10) {
        if (recommendCard == null) {
            C11839m.m70687e("HiSyncUtil", "reportBannerClickEvent card is null.");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("recommend_card_activity_id", recommendCard.getActivityId());
            linkedHashMapM79497A.put("recommend_card_activity_type", recommendCard.getActivityType());
            linkedHashMapM79497A.put("recommend_card_entrance", recommendCard.getEntrance());
            if (z10) {
                C13225d.m79490f1().m79567R("detail_ka_activity_banner_click", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "detail_ka_activity_banner_click", "1", "66", linkedHashMapM79497A);
                m16118X0("detail_ka_activity_banner_click", linkedHashMapM79497A);
            } else {
                C13225d.m79490f1().m79567R("ka_banner_click", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "ka_banner_click", "1", "66", linkedHashMapM79497A);
                m16118X0("ka_banner_click", linkedHashMapM79497A);
            }
        } catch (Exception e10) {
            C11839m.m70687e("HiSyncUtil", "reportKaClickFailed error occur:" + e10.getMessage());
        }
    }

    /* renamed from: I */
    public static Bundle m16087I(Intent intent) {
        return new SafeIntent(intent).getExtras();
    }

    /* renamed from: I0 */
    public static void m16088I0(RecommendCard recommendCard, int i10, boolean z10) {
        if (recommendCard == null) {
            C11839m.m70687e("HiSyncUtil", "reportBannerClickEvent card is null.");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("recommend_card_activity_id", recommendCard.getActivityId());
            linkedHashMapM79497A.put("recommend_card_activity_type", recommendCard.getActivityType());
            linkedHashMapM79497A.put("recommend_card_entrance", recommendCard.getEntrance());
            linkedHashMapM79497A.put("recommend_card_position", String.valueOf(i10));
            if (z10) {
                C13225d.m79490f1().m79567R("detail_ka_banner_show", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "detail_ka_banner_show", "1", "66", linkedHashMapM79497A);
                m16118X0("detail_ka_banner_show", linkedHashMapM79497A);
            } else {
                C13225d.m79490f1().m79567R("ka_banner_show", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "ka_banner_show", "1", "66", linkedHashMapM79497A);
                m16118X0("ka_banner_show", linkedHashMapM79497A);
            }
        } catch (Exception e10) {
            C11839m.m70687e("HiSyncUtil", "reportKaClickFailed error occur:" + e10.getMessage());
        }
    }

    /* renamed from: J */
    public static Intent m16089J(Context context, int i10, int i11) {
        if (context == null) {
            C11839m.m70687e("HiSyncUtil", "context is null");
            return null;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, i10);
        bundle.putInt(FamilyShareConstants.EXTRA_KEY, i11);
        intent.putExtras(bundle);
        if (i10 == 1) {
            intent.addFlags(33554432);
        }
        return intent;
    }

    /* renamed from: J0 */
    public static void m16090J0(String str, LinkedHashMap<String, String> linkedHashMap) {
        C13225d.m79490f1().m79567R(str, linkedHashMap);
        UBAAnalyze.m29958S("PVC", str, "1", "74", linkedHashMap);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07042"), "07042", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B(str);
        c11060cM66626a.m66665u("0");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    /* renamed from: K */
    public static String m16091K() {
        return C0212e0.m1363m(C0213f.m1377a(), "common_config", "sync_config_previous_language", "");
    }

    /* renamed from: K0 */
    public static void m16092K0(RecommendCard recommendCard, boolean z10) {
        if (recommendCard == null) {
            C11839m.m70687e("HiSyncUtil", "reportBannerClickEvent card is null.");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("recommend_card_activity_id", recommendCard.getActivityId());
            linkedHashMapM79497A.put("recommend_card_activity_type", recommendCard.getActivityType());
            linkedHashMapM79497A.put("recommend_card_entrance", recommendCard.getEntrance());
            if (z10) {
                C13227f.m79492i1().m79567R("recommend_card_detail_activity_banner_click", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "recommend_card_detail_activity_banner_click", "1", "66", linkedHashMapM79497A);
                m16118X0("recommend_card_detail_activity_banner_click", linkedHashMapM79497A);
            } else {
                C13227f.m79492i1().m79567R("recommend_card_banner_click", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "recommend_card_banner_click", "1", "66", linkedHashMapM79497A);
                m16118X0("recommend_card_banner_click", linkedHashMapM79497A);
            }
        } catch (Exception e10) {
            C11839m.m70687e("HiSyncUtil", "reportBannerClickEvent error occur:" + e10.getMessage());
        }
    }

    /* renamed from: L */
    public static String m16093L(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            TimeZone timeZone = TimeZone.getTimeZone(str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ZZZ");
            simpleDateFormat.setTimeZone(timeZone);
            String str2 = simpleDateFormat.format(new Date(System.currentTimeMillis()));
            StringBuffer stringBuffer = new StringBuffer();
            String displayName = timeZone.getDisplayName();
            stringBuffer.append("GMT");
            stringBuffer.append(str2);
            StringBuffer stringBufferInsert = stringBuffer.insert(6, ":");
            stringBufferInsert.append(" ");
            stringBufferInsert.append(displayName);
            return stringBuffer.toString();
        } catch (Exception e10) {
            C11839m.m70688i("HiSyncUtil", e10.toString());
            return "";
        }
    }

    /* renamed from: L0 */
    public static void m16094L0(RecommendCardReport recommendCardReport, String str) {
        if (recommendCardReport == null) {
            C11839m.m70687e("HiSyncUtil", "mRecommendCardReport is null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("HiSyncUtil", "eventId is empty.");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("recommend_card_activity_id", recommendCardReport.getActivityId());
            linkedHashMapM79497A.put("recommend_card_activity_type", recommendCardReport.getActivityType());
            linkedHashMapM79497A.put("recommend_card_entrance", recommendCardReport.getEntrance());
            C13225d.m79490f1().m79567R(str, linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", str, "4", "66", linkedHashMapM79497A);
            m16118X0(str, linkedHashMapM79497A);
        } catch (Exception e10) {
            C11839m.m70687e("HiSyncUtil", "reportBannerClickEvent error occur:" + e10.getMessage());
        }
    }

    /* renamed from: M */
    public static String m16095M(String str, Object obj) {
        return (str == null || obj == null) ? str : str.replace(String.valueOf(obj), C13843a.m83104z(obj));
    }

    /* renamed from: M0 */
    public static void m16096M0(View view, RecommendCard recommendCard, int i10, C11842p.f fVar) {
        if (recommendCard == null) {
            C11839m.m70687e("HiSyncUtil", "reportRecommendCardSeenByUser card is null.");
        } else if (fVar == null || !fVar.m70892b(view)) {
            C11839m.m70689w("HiSyncUtil", "banner container is invisible to user, don't report!");
        } else {
            m16098N0(recommendCard, i10);
        }
    }

    /* renamed from: N */
    public static boolean m16097N() {
        boolean z10 = m16099O() || C10028c.m62182c0().m62395t1("is_already_configed_NV4");
        C11839m.m70688i("HiSyncUtil", "configTagIncludeOld:" + z10);
        return z10;
    }

    /* renamed from: N0 */
    public static void m16098N0(RecommendCard recommendCard, int i10) {
        if (recommendCard == null) {
            C11839m.m70687e("HiSyncUtil", "reportRecommendCardSeenByUser card is null.");
        } else {
            C12515a.m75110o().m75175e(new g(recommendCard, i10), false);
        }
    }

    /* renamed from: O */
    public static boolean m16099O() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean z10 = c10028cM62182c0.m62395t1("is_already_configed_new") || c10028cM62182c0.m62395t1("server_config_flag") || c10028cM62182c0.m62395t1("is_already_configed_new_v3") || c10028cM62182c0.m62395t1("is_already_configed_V4") || c10028cM62182c0.m62395t1("is_already_configed_V5") || c10028cM62182c0.m62395t1("is_already_configed_V6") || c10028cM62182c0.m62395t1("is_already_configed_V7") || c10028cM62182c0.m62395t1("is_already_configed_V8") || c10028cM62182c0.m62395t1("is_already_configed_NV1") || c10028cM62182c0.m62395t1("is_already_configed_NV2") || c10028cM62182c0.m62395t1("is_already_configed_NV3");
        C11839m.m70688i("HiSyncUtil", "hasSetConfigTagJustOld:" + z10);
        return z10;
    }

    /* renamed from: O0 */
    public static void m16100O0(ArrayList<RecommendCard> arrayList, boolean z10) {
        if (arrayList == null || arrayList.size() == 0) {
            C11839m.m70687e("HiSyncUtil", "reportRecommendCardShowEvent card is null.");
        } else {
            C12515a.m75110o().m75175e(new h(arrayList, z10), false);
        }
    }

    /* renamed from: P */
    public static void m16101P() {
        Map<String, String> forcedUpgradeMapping = NotifyConstants.getForcedUpgradeMapping();
        forcedUpgradeMapping.put(NotifyConstants.ActivityName.UPGRADE_POP_NOTIFICATION_ACTIVITY, UpgradePopNotificationActivity.class.getName());
        forcedUpgradeMapping.put(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, NewHiSyncSettingActivity.class.getName());
        forcedUpgradeMapping.put(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, GalleryLoginActivity.class.getName());
        forcedUpgradeMapping.put(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, AccountLogoutActivity.class.getName());
        forcedUpgradeMapping.put(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY, LogoutProcessActivity.class.getName());
        forcedUpgradeMapping.put(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, HisyncExternalActivity.class.getName());
        forcedUpgradeMapping.put(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, OperationWebViewActivity.class.getName());
        forcedUpgradeMapping.put(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, UniformGuideActivity.class.getName());
    }

    /* renamed from: P0 */
    public static void m16102P0(RecommendCard recommendCard) {
        if (recommendCard == null) {
            C11839m.m70687e("HiSyncUtil", "reportBannerClickEvent card is null.");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("recommend_card_activity_id", recommendCard.getActivityId());
            linkedHashMapM79497A.put("recommend_card_activity_type", recommendCard.getActivityType());
            linkedHashMapM79497A.put("recommend_card_entrance", recommendCard.getEntrance());
            C13225d.m79490f1().m79567R("recommend_card_banner_text_link_click", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "recommend_card_banner_text_link_click", "1", "66", linkedHashMapM79497A);
            m16118X0("recommend_card_banner_text_link_click", linkedHashMapM79497A);
        } catch (Exception e10) {
            C11839m.m70687e("HiSyncUtil", "reportBannerClickEvent error occur:" + e10.getMessage());
        }
    }

    /* renamed from: Q */
    public static boolean m16103Q(Context context) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("accessibility");
        if (systemService instanceof AccessibilityManager) {
            return ((AccessibilityManager) systemService).isTouchExplorationEnabled();
        }
        return false;
    }

    /* renamed from: Q0 */
    public static void m16104Q0(String str, String str2, String str3) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("recommend_card_activity_id", C0209d.m1209S1(str));
            linkedHashMapM79497A.put("recommend_card_activity_type", C0209d.m1209S1(str2));
            linkedHashMapM79497A.put("recommend_card_entrance", C0209d.m1209S1(str3));
            C13227f.m79492i1().m79567R("recommend_card_banner_unsatisfied", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "recommend_card_banner_unsatisfied", "4", "66", linkedHashMapM79497A);
            m16118X0("recommend_card_banner_unsatisfied", linkedHashMapM79497A);
        } catch (Exception e10) {
            C11839m.m70687e("HiSyncUtil", "reportRecommendCardUnsatisfied error occur:" + e10.getMessage());
        }
    }

    /* renamed from: R */
    public static boolean m16105R() {
        return C1006a.m5936k().m5975v(C0213f.m1377a());
    }

    /* renamed from: R0 */
    public static void m16106R0(Context context, Map<String, String> map, C10028c c10028c) {
        if (c10028c.m62395t1("funcfg_gallery")) {
            map.put("syncSwitch", C1006a.m5936k().m5975v(context) ? "AUTO" : "DISABLED");
        }
        if (c10028c.m62395t1("funcfg_contacts")) {
            map.put("sync.contact", c10028c.m62388s("addressbook") ? "AUTO" : "DISABLED");
        }
        if (c10028c.m62395t1("funcfg_calendar")) {
            map.put("sync.calendar", c10028c.m62388s("calendar") ? "AUTO" : "DISABLED");
        }
        if (c10028c.m62395t1("funcfg_wlan") && C0209d.m1166E1()) {
            map.put("sync.wlan", c10028c.m62388s("wlan") ? "AUTO" : "DISABLED");
        }
        if (c10028c.m62395t1("funcfg_browser") && C10155f.m63285i(context)) {
            map.put("sync.browser", c10028c.m62388s("browser") ? "AUTO" : "DISABLED");
        }
    }

    /* renamed from: S */
    public static boolean m16107S() {
        return C0209d.m1202Q0();
    }

    /* renamed from: S0 */
    public static void m16108S0(Map<String, String> map, C10028c c10028c) {
        if (c10028c.m62395t1("funcfg_find_my_phone_globe")) {
            Context contextM1377a = C0213f.m1377a();
            map.put("pf.main", C1010e.m6125b().m6139e(contextM1377a) ? "AUTO" : "DISABLED");
            map.put("pf.lowpower", C1010e.m6125b().m6143i(contextM1377a) ? "AUTO" : "DISABLED");
            map.put("pf.sharelocate", C1010e.m6125b().m6147m(contextM1377a) ? "AUTO" : "DISABLED");
        }
    }

    /* renamed from: T */
    public static boolean m16109T(String str) {
        return f12090b.contains(str);
    }

    /* renamed from: T0 */
    public static void m16110T0(Map<String, String> map, C10028c c10028c) {
        if (c10028c.m62395t1("funcfg_notes")) {
            map.put("sync.note", c10028c.m62388s("notepad") ? "AUTO" : "DISABLED");
        }
        if (c10028c.m62395t1("funcfg_call_log_up")) {
            map.put("backup.callog", c10028c.m62388s("autocallloglistkey") ? "AUTO" : "DISABLED");
        }
        if (c10028c.m62395t1("funcfg_messaging_up")) {
            map.put("backup.sms", c10028c.m62388s("autosmslistkey") ? "AUTO" : "DISABLED");
        }
        if (c10028c.m62395t1("funcfg_recordings_up")) {
            map.put("backup.recording", C10028c.m62182c0().m62388s("autorecordingkey") ? "AUTO" : "DISABLED");
        }
        if (c10028c.m62395t1("funcfg_blocked_up")) {
            map.put("backup.harassment", C10028c.m62182c0().m62388s("autophonemanagerkey") ? "AUTO" : "DISABLED");
        }
        if (c10028c.m62395t1("funcfg_cloud_backup")) {
            boolean zM62388s = c10028c.m62388s("backup_key");
            C3017c c3017c = new C3017c(2);
            C12515a.m75110o().m75172d(c3017c);
            if (zM62388s) {
                c3017c.m18198e(map, new HashSet<>());
                c3017c.m18209r();
            }
            map.put("backup.cloudbak", zM62388s ? "AUTO" : "DISABLED");
            if (C13452e.m80781L().m80887a1()) {
                map.put("backup.cloudbakbase", C10028c.m62182c0().m62303a1() ? "AUTO" : "DISABLED");
                map.put("backup.cloudbakfull", C10028c.m62182c0().m62388s("backup_key") ? "AUTO" : "DISABLED");
            }
        }
    }

    /* renamed from: U */
    public static boolean m16111U(Context context) {
        return C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).getBoolean("isFirstUse", true);
    }

    /* renamed from: U0 */
    public static void m16112U0(String str, String str2, String str3, int i10) {
        String str4 = "mecloud_main_not_shown_" + str;
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        C13226e.m79491f1().m79588i0(str4, str2, str3, C13452e.m80781L().m80971t0(), i10);
        UBAAnalyze.m29973d0("PVC", str4, "1", "29", str2, str3, i10);
    }

    /* renamed from: V */
    public static boolean m16113V(float f10, float f11) {
        return Math.abs(f10 - f11) < 0.001f;
    }

    /* renamed from: V0 */
    public static void m16114V0(String str, String str2, String str3, int i10) {
        String str4;
        String str5;
        str.hashCode();
        switch (str) {
            case "addressbook":
                str4 = "mecloud_main_click_contacts";
                str5 = DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN;
                break;
            case "calendar":
                str4 = "mecloud_main_click_calendar";
                str5 = "11";
                break;
            case "wlan":
                str4 = "mecloud_clouddiskmain_click_wlan";
                str5 = PriorInstallWay.PRIOR_ACTION_LANDING_PAGE;
                break;
            case "browser":
                str4 = "mecloud_clouddiskmain_click_browser";
                str5 = "20";
                break;
            case "notepad":
                str4 = "mecloud_main_click_notepad";
                str5 = "10";
                break;
            default:
                str4 = "mecloud_main_click_" + str;
                str5 = "29";
                break;
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        String str6 = str4;
        C13227f.m79492i1().m79588i0(str6, str2, str3, C13452e.m80781L().m80971t0(), i10);
        UBAAnalyze.m29973d0("PVC", str6, "1", str5, str2, str3, i10);
    }

    /* renamed from: W */
    public static boolean m16115W(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("is_switch_restored", false);
        }
        return false;
    }

    /* renamed from: W0 */
    public static void m16116W0(String str, String str2, String str3, int i10, int i11) {
        String str4;
        String str5;
        str.hashCode();
        switch (str) {
            case "addressbook":
                str4 = "mecloud_main_click_contacts";
                str5 = DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN;
                break;
            case "calendar":
                str4 = "mecloud_main_click_calendar";
                str5 = "11";
                break;
            case "wlan":
                str4 = "mecloud_clouddiskmain_click_wlan";
                str5 = PriorInstallWay.PRIOR_ACTION_LANDING_PAGE;
                break;
            case "browser":
                str4 = "mecloud_clouddiskmain_click_browser";
                str5 = "20";
                break;
            case "notepad":
                str4 = "mecloud_main_click_notepad";
                str5 = "10";
                break;
            default:
                str4 = "mecloud_main_click_" + str;
                str5 = "29";
                break;
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        String str6 = str4;
        C13226e.m79491f1().m79589j0(str6, str2, str3, C13452e.m80781L().m80971t0(), i10, i11);
        UBAAnalyze.m29975e0("PVC", str6, "1", str5, str2, str3, i10, i11);
    }

    /* renamed from: X */
    public static boolean m16117X(String str) {
        if (C0209d.m1166E1()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("gallery_sync");
        arrayList.add("gallerydelete");
        arrayList.add("wlan");
        arrayList.add(NavigationUtils.SMS_SCHEMA_PREF);
        arrayList.add("calllog");
        if (!C10155f.m63288l()) {
            arrayList.add("record");
            arrayList.add("phonemanager");
        }
        arrayList.add("cloud_backup");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: X0 */
    public static void m16118X0(String str, LinkedHashMap<String, String> linkedHashMap) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07038"), "07038", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B(str);
        c11060cM66626a.m66665u("0");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    /* renamed from: Y */
    public static boolean m16119Y(Context context) {
        if (context == null) {
            C11839m.m70687e("HiSyncUtil", "cloud backup red dot context is null");
            return false;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62395t1 = c10028cM62182c0.m62395t1("funcfg_cloud_backup");
        if (!zM62395t1) {
            C11839m.m70688i("HiSyncUtil", "cloud backup red dot isModuleOn=" + zM62395t1);
            return false;
        }
        boolean zM62388s = c10028cM62182c0.m62388s("backup_key");
        if (zM62388s) {
            C11839m.m70688i("HiSyncUtil", "cloud backup red dot switchStatus=" + zM62388s);
            return false;
        }
        int iM62252O = c10028cM62182c0.m62252O("EnterCloudBackupTimes");
        C11839m.m70688i("HiSyncUtil", "cloud backup red dot enterTimes=" + iM62252O);
        if (iM62252O >= 3) {
            return false;
        }
        long time = new Date().getTime();
        long jM62247N = c10028cM62182c0.m62247N("EnterCloudBackupDate");
        if (jM62247N == 0) {
            C11839m.m70688i("HiSyncUtil", "cloud backup red dot last date is 0, return true");
            return true;
        }
        long j10 = time - jM62247N;
        C11839m.m70688i("HiSyncUtil", "cloud backup red dot dategap=" + j10);
        if (j10 < 604800000) {
            return false;
        }
        C11839m.m70688i("HiSyncUtil", "cloud backup red dot need show");
        return true;
    }

    /* renamed from: Y0 */
    public static void m16120Y0(Context context, String str, String str2) {
        if (context == null) {
            C11839m.m70687e("HiSyncUtil", "retainSyncData context null");
        }
        C1008c.m6035v().m6090o(str);
        C1008c.m6035v().m6056U(context, str);
        C1008c.m6035v().m6054S(str);
        str.hashCode();
        switch (str) {
            case "addressbook":
                if (!C13843a.m83073Y(context)) {
                    C1008c.m6035v().m6095q0(context, str, 101, 2012, str2);
                    break;
                } else {
                    C1008c.m6035v().m6097r0(context, str, 101, 2012, str2);
                    break;
                }
            case "calendar":
                C1008c.m6035v().m6093p0(context, str, 101, 2012, str2);
                break;
            case "wlan":
                C1008c.m6035v().m6104v0(context, str, 101, 2012, str2);
                break;
            case "browser":
                C1008c.m6035v().m6091o0(context, str, 101, 2012, str2);
                break;
            case "notepad":
                C1008c.m6035v().m6101t0(context, str, 101, 2012, str2);
                break;
            default:
                C1008c.m6035v().m6099s0(context, str, 101, 2012, str2);
                break;
        }
    }

    /* renamed from: Z */
    public static boolean m16121Z(Context context, int i10) {
        if (context == null) {
            C11839m.m70687e("HiSyncUtil", "phone finder red dot context is null");
            return false;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (!c10028cM62182c0.m62395t1("funcfg_find_my_phone_globe")) {
            C11839m.m70688i("HiSyncUtil", "phone finder red dot isModuleOn is false, return");
            return false;
        }
        if (((InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class)) == null) {
            C11839m.m70688i("HiSyncUtil", "phone finder red dot phoneFinderRouter is null, return");
            return false;
        }
        boolean zM6139e = C1010e.m6125b().m6139e(context.getApplicationContext());
        C11839m.m70688i("HiSyncUtil", "phone finder switch status is " + zM6139e);
        if (zM6139e) {
            return false;
        }
        boolean zM6148n = C1010e.m6125b().m6148n(C13452e.m80781L().m80942m());
        if (i10 == 1 && zM6148n) {
            C11839m.m70688i("HiSyncUtil", "ShowPhoneFinderFeature ignore");
            return false;
        }
        int iM62252O = c10028cM62182c0.m62252O("EnterPhoneFinderTimes");
        C11839m.m70688i("HiSyncUtil", "phone finder red dot enter times is " + iM62252O);
        if (iM62252O >= 3) {
            return false;
        }
        long time = new Date().getTime();
        long jM62247N = c10028cM62182c0.m62247N("EnterPhoneFinderDate");
        if (jM62247N == 0) {
            C11839m.m70688i("HiSyncUtil", "phone finder red dot last date is 0, return");
            return true;
        }
        if (time - jM62247N < 604800000) {
            C11839m.m70688i("HiSyncUtil", "phone finder red dot date less than interval, return");
            return false;
        }
        C11839m.m70688i("HiSyncUtil", "phone finder red dot need show");
        return true;
    }

    /* renamed from: Z0 */
    public static String m16122Z0() {
        String strM16180t = m16180t();
        String currentLanguage = HNUtil.getCurrentLanguage();
        if (TextUtils.isEmpty(strM16180t)) {
            m16140f1(currentLanguage);
        }
        return strM16180t;
    }

    /* renamed from: a0 */
    public static boolean m16124a0(Context context) {
        if (context != null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "power_saving_on", 1) == 0;
            } catch (Exception e10) {
                C11839m.m70687e("HiSyncUtil", "isPowerSavingOn exception:" + e10.getMessage());
            }
        }
        return false;
    }

    /* renamed from: a1 */
    public static String m16125a1() {
        String strM16091K = m16091K();
        String currentLanguage = HNUtil.getCurrentLanguage();
        if (TextUtils.isEmpty(strM16091K)) {
            m16146h1(currentLanguage);
        }
        return strM16091K;
    }

    /* renamed from: b */
    public static void m16126b(Context context, AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        if (context == null || touchExplorationStateChangeListener == null) {
            C11839m.m70687e("HiSyncUtil", "param is null");
            return;
        }
        Object systemService = context.getSystemService("accessibility");
        if (systemService instanceof AccessibilityManager) {
            ((AccessibilityManager) systemService).removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
    }

    /* renamed from: b0 */
    public static boolean m16127b0(Context context) throws SecurityException {
        String packageName;
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            C11839m.m70687e("HiSyncUtil", "ActivityManager is null");
            return false;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
        if (runningTasks == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null) {
            packageName = "";
        } else {
            C11839m.m70686d("HiSyncUtil", "isRunningForeground, activity: " + componentName.getClassName());
            packageName = componentName.getPackageName();
        }
        if (TextUtils.isEmpty(packageName) || !packageName.equals(context.getPackageName())) {
            C11839m.m70686d("HiSyncUtil", "hicloud is background");
            return false;
        }
        C11839m.m70686d("HiSyncUtil", "hicloud is foreground");
        return true;
    }

    /* renamed from: b1 */
    public static View.AccessibilityDelegate m16128b1(boolean z10) {
        return new d(z10);
    }

    /* renamed from: c */
    public static void m16129c(Context context, AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        if (context == null || touchExplorationStateChangeListener == null) {
            C11839m.m70687e("HiSyncUtil", "param is null");
            return;
        }
        Object systemService = context.getSystemService("accessibility");
        if (systemService instanceof AccessibilityManager) {
            ((AccessibilityManager) systemService).addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
    }

    /* renamed from: c0 */
    public static boolean m16130c0(Context context) {
        return context != null && C11829c.m70546T0(context) && C10028c.m62182c0().m62395t1("funcfg_call_log_up");
    }

    /* renamed from: c1 */
    public static void m16131c1(Context context) {
        if (context == null) {
            C11839m.m70689w("HiSyncUtil", "setAllModuleDisable context is null");
            return;
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        c10028cM62183d0.m62377p3("uploadphotokey", false);
        c10028cM62183d0.m62377p3("addressbook", false);
        c10028cM62183d0.m62377p3("calendar", false);
        c10028cM62183d0.m62377p3("notepad", false);
        c10028cM62183d0.m62377p3("wlan", false);
        CloudBackupService.getInstance().cloudbackupOpr(false);
        c10028cM62183d0.m62377p3("browser", false);
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", false);
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("HiSyncUtil", "cloudAlbumRouterImpl is null");
        } else {
            interfaceC9282a.mo58396U(context, bundle, 6);
            CloudBackupService.getInstance().cloudbackupOpr(false);
        }
    }

    /* renamed from: d */
    public static View.AccessibilityDelegate m16132d() {
        return new c();
    }

    /* renamed from: d0 */
    public static boolean m16133d0(Context context) {
        return context != null && (C10155f.m63250C(context) || C10155f.m63298v(context) || C10155f.m63255H(context) || C10155f.m63254G(context));
    }

    /* renamed from: d1 */
    public static void m16134d1(int i10) {
        f12089a = i10;
    }

    /* renamed from: e */
    public static void m16135e(Context context, int i10) {
        if (context == null) {
            C11839m.m70687e("HiSyncUtil", "context is null");
            return;
        }
        for (String str : C1008c.m6035v().m6100t(context)) {
            if (!TextUtils.isEmpty(str)) {
                C10155f.m63268U(context, str, i10);
                m16120Y0(context, str, "local_close_switch");
            }
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            if (C10155f.m63249B()) {
                interfaceC9282a.mo58407Z0(context, 5);
            }
            interfaceC9282a.mo58416c1();
        } else {
            C11839m.m70688i("HiSyncUtil", "cloudAlbumRouterImpl is null");
        }
        C14315h.m85262p().m85278n();
        CBAccess.manualAbort();
        MessageCenterManager.getInstance().clearAllMessages();
    }

    /* renamed from: e0 */
    public static boolean m16136e0(Context context) {
        return (context == null || C0209d.m1258g2(context) || !C10028c.m62182c0().m62395t1("funcfg_blocked_up")) ? false : true;
    }

    /* renamed from: e1 */
    public static void m16137e1(boolean z10) {
        C0212e0.m1365o(C0213f.m1377a(), "common_config", "firset_enter_mainactivity", z10);
    }

    /* renamed from: f */
    public static void m16138f(Context context) {
        if (context == null) {
            C11839m.m70687e("HiSyncUtil", "Exit to HiCloud entrace, context is null");
            return;
        }
        C11839m.m70688i("HiSyncUtil", "Exit to HiCloud entrace");
        m16158l1(context);
        C9062b.m57146k().m57155h(false, false);
    }

    /* renamed from: f0 */
    public static boolean m16139f0() {
        return C10028c.m62182c0().m62395t1("funcfg_manage_storage");
    }

    /* renamed from: f1 */
    public static void m16140f1(String str) {
        C0212e0.m1372v(C0213f.m1377a(), "common_config", "hisync_space_previous_language", str);
    }

    /* renamed from: g */
    public static String m16141g(float f10) {
        if (f10 > 100.0f || f10 < 0.0f) {
            f10 = 0.0f;
        }
        return ((m16113V(f10, 100.0f) || m16113V(f10, 0.0f)) ? new DecimalFormat("0%") : new DecimalFormat("0.00%")).format(new BigDecimal(f10).divide(new BigDecimal(100)).doubleValue());
    }

    /* renamed from: g0 */
    public static boolean m16142g0(String str) {
        return (str == null || NavigationUtils.SMS_SCHEMA_PREF.equals(str) || "chatSms".equals(str) || "calllog".equals(str) || HNConstants.DataType.CONTACT.equals(str) || C14333b.m85481p().contains(str)) ? false : true;
    }

    /* renamed from: g1 */
    public static void m16143g1(Context context, boolean z10) {
        C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).edit().putBoolean("is_switch_restored", z10).commit();
    }

    /* renamed from: h */
    public static String m16144h(int i10) {
        if (i10 > 100 || i10 < 0) {
            i10 = 0;
        }
        return NumberFormat.getPercentInstance().format(new BigDecimal(i10).divide(new BigDecimal(100)).doubleValue());
    }

    /* renamed from: h0 */
    public static boolean m16145h0(Context context) {
        return context != null && C10028c.m62182c0().m62395t1("funcfg_recordings_up");
    }

    /* renamed from: h1 */
    public static void m16146h1(String str) {
        C0212e0.m1372v(C0213f.m1377a(), "common_config", "sync_config_previous_language", str);
    }

    /* renamed from: i */
    public static String m16147i(Context context, long j10) {
        String string;
        if (context == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.applyPattern("0.##");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        float f10 = j10;
        int i10 = R$string.main_space_display_B;
        if (f10 > 900.0f) {
            i10 = R$string.main_space_display_KB;
            f10 /= 1024;
        }
        if (f10 > 900.0f) {
            f10 /= 1024;
            i10 = R$string.main_space_display_MB;
        }
        if (f10 > 900.0f) {
            f10 /= 1024;
            i10 = R$string.main_space_display_GB;
        }
        try {
            string = context.getString(i10, C13843a.m83104z(Double.valueOf(decimalFormat.format(f10))));
        } catch (Exception unused) {
            C11839m.m70687e("HiSyncUtil", "formatSpace exception");
            string = context.getString(i10, decimalFormat.format(f10));
        }
        return C13843a.m83087i(string);
    }

    /* renamed from: i0 */
    public static boolean m16148i0(Context context) {
        return context != null && C11829c.m70523I0(context) && C10028c.m62182c0().m62395t1("funcfg_messaging_up");
    }

    /* renamed from: i1 */
    public static void m16149i1(Context context) {
        if (context == null) {
            C11839m.m70687e("HiSyncUtil", "setWiFi context is null");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.WIFI_SETTINGS");
        try {
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            C11839m.m70687e("HiSyncUtil", "startActivity: setNet failed");
        }
    }

    /* renamed from: j */
    public static void m16150j(Context context) {
        boolean z10;
        if (context == null) {
            C11839m.m70687e("HiSyncUtil", "fullReportSwitchStatus context is null");
            return;
        }
        C11839m.m70688i("HiSyncUtil", "fullReportSwitchStatus");
        HashMap map = new HashMap();
        C10028c c10028cM62183d0 = C10028c.m62183d0(context.getApplicationContext());
        m16106R0(context, map, c10028cM62183d0);
        m16110T0(map, c10028cM62183d0);
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(context);
        if (shownSyncServiceItems.size() > 0) {
            Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
            while (it.hasNext()) {
                SyncConfigService next = it.next();
                if (next != null) {
                    String id2 = next.getId();
                    boolean zM62388s = c10028cM62183d0.m62388s(id2);
                    int recordIndex = next.getRecordIndex();
                    C11839m.m70688i("HiSyncUtil", "syncType: " + next.getId() + ", index = " + recordIndex);
                    map.put("sync." + recordIndex + "." + id2, zM62388s ? "AUTO" : "DISABLED");
                }
            }
        }
        Iterator it2 = map.entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z10 = false;
                break;
            } else if (TextUtils.equals((String) ((Map.Entry) it2.next()).getValue(), "AUTO")) {
                z10 = true;
                break;
            }
        }
        map.put("sync.type", z10 ? "AUTO" : "DISABLED");
        m16108S0(map, c10028cM62183d0);
        new C10582a(C13622a.m81958d("")).m64928b0(map, "2", new e());
        C1008c.m6035v().m6066c(context, "fullReport");
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58380M();
        } else {
            C11839m.m70688i("HiSyncUtil", "cloudAlbumRouterImpl is null");
        }
    }

    /* renamed from: j0 */
    public static boolean m16151j0() {
        return C10155f.m63301y() || C10155f.m63253F() || C10155f.m63248A();
    }

    /* renamed from: j1 */
    public static boolean m16152j1(Context context) {
        if (context != null) {
            try {
                return C0209d.m1277l1() ? SettingsEx.System.getIntForUser(context.getContentResolver(), "SmartModeStatus", 1, 0) == 4 : SettingsEx.System.getIntForUser(context.getContentResolver(), "SmartModeStatus", 1, 0) == 4;
            } catch (Throwable th2) {
                C11839m.m70687e("HiSyncUtil", "smartModeStatus exception:" + th2.getMessage());
            }
        }
        return false;
    }

    /* renamed from: k */
    public static String m16153k(Context context, String str) {
        if (context == null) {
            return null;
        }
        return HNConstants.DataType.CONTACT.equals(str) ? context.getString(R$string.contact) : NavigationUtils.SMS_SCHEMA_PREF.equals(str) ? context.getString(R$string.cloudbackup_back_item_sms) : "chatSms".equals(str) ? context.getString(R$string.cloud_enhancement_information) : "calllog".equals(str) ? context.getString(R$string.recovery_appid_calllog) : HNConstants.DataType.MEDIA.equals(str) ? context.getString(R$string.gallery_item_title) : "music".equals(str) ? context.getString(R$string.backup_music) : C14333b.m85481p().contains(str) ? context.getString(R$string.system_data) : !TextUtils.isEmpty(str) ? str : context.getString(R$string.application_data);
    }

    /* renamed from: k0 */
    public static boolean m16154k0(long j10) {
        return System.currentTimeMillis() - j10 > 86400000;
    }

    /* renamed from: k1 */
    public static boolean m16155k1(Context context) {
        if (context != null) {
            try {
                return Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) == 7;
            } catch (Exception e10) {
                C11839m.m70687e("HiSyncUtil", "stayOnWhilePlugged exception:" + e10.getMessage());
            }
        }
        return false;
    }

    /* renamed from: l */
    public static int m16156l(Context context) {
        ArrayList arrayList = new ArrayList();
        if (m16148i0(context)) {
            arrayList.add(Boolean.valueOf(C10028c.m62183d0(context).m62388s("autosmslistkey")));
        }
        if (m16130c0(context)) {
            arrayList.add(Boolean.valueOf(C10028c.m62183d0(context).m62388s("autocallloglistkey")));
        }
        if (m16145h0(context)) {
            arrayList.add(Boolean.valueOf(C10028c.m62183d0(context).m62388s("autorecordingkey")));
        }
        if (m16136e0(context)) {
            arrayList.add(Boolean.valueOf(C10028c.m62183d0(context).m62388s("autophonemanagerkey")));
        }
        Iterator it = arrayList.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (!((Boolean) it.next()).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: l0 */
    public static boolean m16157l0(Context context, String str) {
        if ("record".equals(str)) {
            return C10155f.m63254G(context);
        }
        if ("notepad".equals(str)) {
            return C10155f.m63252E();
        }
        if ("phonemanager".equals(str)) {
            return C10155f.m63250C(context);
        }
        if ("gallerydelete".equals(str)) {
            return C10155f.m63249B();
        }
        if ("calendar".equals(str)) {
            return C10155f.m63297u();
        }
        return true;
    }

    /* renamed from: l1 */
    public static void m16158l1(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setClass(context, NewHiSyncSettingActivity.class);
        intent.setAction("com.huawei.android.intent.action.settings.HICLOUD_ENTTRANCE");
        context.startActivity(intent);
    }

    /* renamed from: m */
    public static int m16159m() {
        return f12089a;
    }

    /* renamed from: m0 */
    public static boolean m16160m0() {
        return C10028c.m62182c0().m62395t1("funcfg_contacts") || C10028c.m62182c0().m62395t1("funcfg_calendar") || C10028c.m62182c0().m62390s1() || C10028c.m62182c0().m62395t1("funcfg_wlan") || C10028c.m62182c0().m62395t1("funcfg_browser") || C10028c.m62182c0().m62315d1() || C10028c.m62182c0().m62395t1("funcfg_notes");
    }

    /* renamed from: m1 */
    public static void m16161m1(Context context, String str) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setClass(context, NewHiSyncSettingActivity.class);
        intent.setAction("com.huawei.android.intent.action.settings.HICLOUD_ENTTRANCE");
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(FaqConstants.FAQ_MODULE, str);
        }
        context.startActivity(intent);
    }

    /* renamed from: n */
    public static int m16162n() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        return (interfaceC9282a == null || interfaceC9282a.mo58368G()) ? 29 : 30;
    }

    /* renamed from: n0 */
    public static boolean m16163n0(Context context) {
        if (context != null) {
            try {
                return Settings.Global.getInt(context.getContentResolver(), "wifi_sleep_policy", 0) == 2;
            } catch (Exception e10) {
                C11839m.m70687e("HiSyncUtil", "isWifiSleep exception:" + e10.getMessage());
            }
        }
        return false;
    }

    /* renamed from: n1 */
    public static void m16164n1(Context context) {
        boolean zM16172q0 = m16172q0(context);
        ComponentName componentName = new ComponentName(context, (Class<?>) BackupMainforSettingActivity.class);
        if (zM16172q0) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
            return;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62388s = c10028cM62182c0.m62388s("backup_key");
        boolean zM62395t1 = c10028cM62182c0.m62395t1("funcfg_cloud_backup");
        C11839m.m70686d("HiSyncUtil", "isBackupModuleOn is " + zM62395t1);
        int iM62252O = c10028cM62182c0.m62252O("EnterClosedCloudBackupTimes");
        long time = new Date().getTime();
        long jM62247N = c10028cM62182c0.m62247N("CloseCloudBackupDate");
        long j10 = time - jM62247N;
        if (iM62252O > 3) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
            return;
        }
        if (!zM62395t1) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
            return;
        }
        if (zM62388s) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
            return;
        }
        if (jM62247N == 0) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            c10028cM62182c0.m62197C2("CloseCloudBackupDate", time);
            c10028cM62182c0.m62202D2("EnterClosedCloudBackupTimes", iM62252O + 1);
        } else {
            if (j10 < 604800000) {
                context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            c10028cM62182c0.m62197C2("CloseCloudBackupDate", time);
            int i10 = iM62252O + 1;
            c10028cM62182c0.m62202D2("EnterClosedCloudBackupTimes", i10);
            C11839m.m70688i("HiSyncUtil", "ENTER_CLOSED_BACKUP_MODULES_TIMES = " + i10);
        }
    }

    /* renamed from: o */
    public static int m16165o(String str) {
        return "record".equals(str) ? C0209d.m1269j1() ? R$drawable.icon_record_detail_honor : R$drawable.icon_record_detail : "notepad".equals(str) ? C0209d.m1269j1() ? R$drawable.ic_memorandum_honor : R$drawable.ic_memorandum : "phonemanager".equals(str) ? R$drawable.icon_section_ba : "gallerydelete".equals(str) ? R$drawable.icon_recently_deleted : HNConstants.DataType.CONTACT.equals(str) ? C0209d.m1269j1() ? R$drawable.ic_contacts_honor : R$drawable.ic_contacts : "calendar".equals(str) ? C0209d.m1269j1() ? R$drawable.icon_calendar_honor : R$drawable.icon_calendar : C0209d.m1269j1() ? R$drawable.ic_home_disk_normal_honor : R$drawable.ic_home_disk_normal;
    }

    /* renamed from: o0 */
    public static void m16166o0(Context context, int i10, int i11) {
        C11839m.m70688i("HiSyncUtil", "moveToSpaceShare");
        Intent intentM16089J = m16089J(context, i10, i11);
        if (intentM16089J == null) {
            C11839m.m70687e("HiSyncUtil", "intent is null");
        } else {
            intentM16089J.setClass(context, CloudSpaceShareActivity.class);
            context.startActivity(intentM16089J);
        }
    }

    /* renamed from: o1 */
    public static void m16167o1() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("HiSyncUtil", "initData cloudAlbumRouterImpl is null");
        } else if (interfaceC9282a.mo58357A0()) {
            C11839m.m70688i("HiSyncUtil", "gallery size changeing");
            C13368e.m80184F().m80253r0();
            C13368e.m80184F().m80250o0();
        }
    }

    /* renamed from: p */
    public static String m16168p(Context context, String str) {
        if (context == null) {
            return null;
        }
        return "record".equals(str) ? context.getString(R$string.recorder_app_name) : "notepad".equals(str) ? context.getString(R$string.notepad_app_name) : "phonemanager".equals(str) ? context.getString(R$string.cloudbackup_back_item_phonemanager) : "clouddrive".equals(str) ? context.getString(R$string.cloud_collect_detail_new) : "recycle".equals(str) ? context.getString(R$string.disk_detail_recycle) : "sync".equals(str) ? context.getString(R$string.disk_detail_sync) : "gallerydelete".equals(str) ? context.getString(R$string.gallery_detail_title_delete) : HNConstants.DataType.CONTACT.equals(str) ? context.getString(R$string.contact) : "calendar".equals(str) ? context.getString(R$string.calendar_sync_item) : context.getString(R$string.disk_detail_activity_title_new);
    }

    /* renamed from: p0 */
    public static void m16169p0(Context context, int i10, int i11) {
        C11839m.m70688i("HiSyncUtil", "moveToSpaceShareJoinByDefault");
        Intent intentM16089J = m16089J(context, i10, i11);
        if (intentM16089J == null) {
            C11839m.m70687e("HiSyncUtil", "intent is null");
        } else {
            intentM16089J.setClass(context, CloudSpaceShareJoinByDefaultActivity.class);
            context.startActivity(intentM16089J);
        }
    }

    /* renamed from: p1 */
    public static void m16170p1(ListView listView, BaseAdapter baseAdapter) {
        int measuredHeight = 0;
        for (int i10 = 0; i10 < baseAdapter.getCount(); i10++) {
            View view = baseAdapter.getView(i10, null, listView);
            if (view != null) {
                view.measure(0, 0);
                measuredHeight += view.getMeasuredHeight();
            }
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = measuredHeight + (listView.getDividerHeight() * (baseAdapter.getCount() - 1));
        listView.setLayoutParams(layoutParams);
    }

    /* renamed from: q */
    public static CloudSpace m16171q(List<CloudSpace> list, int i10) {
        if (list == null) {
            return null;
        }
        for (CloudSpace cloudSpace : list) {
            if (cloudSpace != null && cloudSpace.getScheme() == i10) {
                return cloudSpace;
            }
        }
        return null;
    }

    /* renamed from: q0 */
    public static boolean m16172q0(Context context) {
        return context == null || ModuleConfigUtil.getInstance().isLocalVersion() || !C0209d.m1166E1() || C0209d.m1173G1(context);
    }

    /* renamed from: q1 */
    public static void m16173q1(Context context) {
        boolean zM16172q0 = m16172q0(context);
        ComponentName componentName = new ComponentName(context, (Class<?>) BackupMainforSettingActivity.class);
        if (zM16172q0) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
            return;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62388s = c10028cM62182c0.m62388s("backup_key");
        boolean zM62395t1 = c10028cM62182c0.m62395t1("funcfg_cloud_backup");
        C11839m.m70686d("HiSyncUtil", "isBackupModuleOn is " + zM62395t1);
        if (!zM62395t1) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
        } else if (zM62388s) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
        } else {
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    /* renamed from: r */
    public static CloudSpace m16174r(List<CloudSpace> list, int i10) {
        if (list == null) {
            return null;
        }
        for (CloudSpace cloudSpace : list) {
            if (cloudSpace != null && cloudSpace.getType() == i10) {
                return cloudSpace;
            }
        }
        return null;
    }

    /* renamed from: r0 */
    public static void m16175r0(Context context) {
        m16178s0(context, "1", 7);
    }

    /* renamed from: r1 */
    public static void m16176r1(ListView listView, BaseAdapter baseAdapter) {
        int iMin = Math.min(7, baseAdapter.getCount());
        int measuredHeight = 0;
        for (int i10 = 0; i10 < iMin; i10++) {
            View view = baseAdapter.getView(i10, null, listView);
            if (view != null) {
                view.measure(0, 0);
                measuredHeight += view.getMeasuredHeight();
            }
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = measuredHeight + (listView.getDividerHeight() * (iMin - 1));
        listView.setLayoutParams(layoutParams);
    }

    /* renamed from: s */
    public static boolean m16177s() {
        return C0212e0.m1354d(C0213f.m1377a(), "common_config", "firset_enter_mainactivity", true);
    }

    /* renamed from: s0 */
    public static void m16178s0(Context context, String str, int i10) {
        if (context == null) {
            C11839m.m70688i("HiSyncUtil", "context is null");
            return;
        }
        boolean zM5975v = C1006a.m5936k().m5975v(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", zM5975v);
        if (zM5975v) {
            bundle.putBoolean("ShareAlbum", true);
            C13223b.m79473a(context, "CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY", "1");
            UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY", str, "15");
        } else {
            C13223b.m79473a(context, "CLOUDBACKUP_CLOUDALBUM_CLOSE_GALLERY", "1");
            UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_CLOUDALBUM_CLOSE_GALLERY", str, "15");
        }
        C1006a.m5936k().m5943G(context, bundle, i10);
        C1008c.m6035v().m6053R(context, zM5975v);
    }

    /* renamed from: s1 */
    public static int m16179s1(int i10, int i11) {
        return C0209d.m1262h2() ? i10 : i11;
    }

    /* renamed from: t */
    public static String m16180t() {
        return C0212e0.m1363m(C0213f.m1377a(), "common_config", "hisync_space_previous_language", "");
    }

    /* renamed from: t0 */
    public static void m16181t0(List<HiCloudItemView> list) {
        for (HiCloudItemView hiCloudItemView : list) {
            if (hiCloudItemView != null) {
                hiCloudItemView.m23987t();
            }
        }
    }

    /* renamed from: u */
    public static Drawable m16182u(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "calendar":
                return ContextCompat.getDrawable(context, R$drawable.icon_calendar_honor);
            case "wlan":
                return ContextCompat.getDrawable(context, R$drawable.ic_wifi);
            case "browser":
                return ContextCompat.getDrawable(context, R$drawable.ic_hicloud_browser_list_new_honor);
            case "contact":
                return ContextCompat.getDrawable(context, R$drawable.ic_contacts_honor);
            case "gallery_sync":
                return ContextCompat.getDrawable(context, R$drawable.ic_cloud_album_honor);
            case "notepad":
                return ContextCompat.getDrawable(context, R$drawable.ic_memorandum_honor);
            default:
                Drawable iconDrawable = null;
                for (SyncConfigService syncConfigService : SyncModuleConfigManager.getInstance().getSyncServicesFromDb()) {
                    if (TextUtils.equals(str, syncConfigService.getId())) {
                        iconDrawable = syncConfigService.getIconDrawable();
                    }
                }
                for (DriveConfigService driveConfigService : DriveModuleConfigManager.getInstance().getDriveServicesFromDb()) {
                    if (TextUtils.equals(str, driveConfigService.getId())) {
                        iconDrawable = driveConfigService.getIconDrawable();
                    }
                }
                return iconDrawable;
        }
    }

    /* renamed from: u0 */
    public static void m16183u0(List<StorageManagerCardLayout> list) {
        for (StorageManagerCardLayout storageManagerCardLayout : list) {
            if (storageManagerCardLayout != null) {
                storageManagerCardLayout.onConfigurationChanged();
            }
        }
    }

    /* renamed from: v */
    public static Drawable m16184v(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "calendar":
                return ContextCompat.getDrawable(context, R$drawable.icon_calendar);
            case "wlan":
                return ContextCompat.getDrawable(context, R$drawable.ic_wifi);
            case "browser":
                return ContextCompat.getDrawable(context, R$drawable.ic_hicloud_browser_list_new);
            case "contact":
                return ContextCompat.getDrawable(context, R$drawable.ic_contacts);
            case "gallery_sync":
                return ContextCompat.getDrawable(context, R$drawable.ic_cloud_album);
            case "notepad":
                return ContextCompat.getDrawable(context, R$drawable.ic_memorandum);
            default:
                Drawable iconDrawable = null;
                for (SyncConfigService syncConfigService : SyncModuleConfigManager.getInstance().getSyncServicesFromDb()) {
                    if (TextUtils.equals(str, syncConfigService.getId())) {
                        iconDrawable = syncConfigService.getIconDrawable();
                    }
                }
                for (DriveConfigService driveConfigService : DriveModuleConfigManager.getInstance().getDriveServicesFromDb()) {
                    if (TextUtils.equals(str, driveConfigService.getId())) {
                        iconDrawable = driveConfigService.getIconDrawable();
                    }
                }
                return iconDrawable;
        }
    }

    /* renamed from: v0 */
    public static void m16185v0(List<StorageManagerCardViewLayout> list) {
        for (StorageManagerCardViewLayout storageManagerCardViewLayout : list) {
            if (storageManagerCardViewLayout != null) {
                storageManagerCardViewLayout.onConfigurationChanged();
            }
        }
    }

    /* renamed from: w */
    public static Drawable m16186w(Context context, String str) {
        if (context != null) {
            return C0209d.m1269j1() ? m16182u(context, str) : m16184v(context, str);
        }
        C11839m.m70687e("HiSyncUtil", "context is null");
        return null;
    }

    /* renamed from: w0 */
    public static void m16187w0(List<HicloudVerticalItemView> list) {
        C11839m.m70686d("HiSyncUtil", "notifyVerticalItemViewConfigurationChanged size:" + list.size());
        for (HicloudVerticalItemView hicloudVerticalItemView : list) {
            if (hicloudVerticalItemView != null) {
                hicloudVerticalItemView.onConfigurationChanged();
            }
        }
    }

    /* renamed from: x */
    public static List<String> m16188x(Context context) {
        PackageManager packageManager;
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            C11839m.m70689w("HiSyncUtil", "getInstalledApplication error : context is null");
            return arrayList;
        }
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e10) {
            C11839m.m70687e("HiSyncUtil", "isApplicationAvailble exception : " + e10.toString());
        }
        if (packageManager == null) {
            C11839m.m70689w("HiSyncUtil", "getPackageManager is null");
            return arrayList;
        }
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i10 = 0; i10 < installedPackages.size(); i10++) {
                arrayList.add(installedPackages.get(i10).packageName);
            }
        }
        return arrayList;
    }

    /* renamed from: x0 */
    public static void m16189x0() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("HiSyncUtil", "context is null");
            return;
        }
        C13223b.m79484l(contextM1377a, 1, 0);
        C12515a.m75110o().m75172d(new C10145h(contextM1377a, true));
    }

    /* renamed from: y */
    public static long m16190y() {
        long j10;
        SettingOperator settingOperator = new SettingOperator();
        long jQuerylastsuccesstime = settingOperator.querylastsuccesstime();
        long jQueryinitopentime = settingOperator.queryinitopentime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jQuerylastsuccesstime == 0) {
            if (jQueryinitopentime > jCurrentTimeMillis) {
                jQueryinitopentime = jCurrentTimeMillis;
            }
            j10 = jCurrentTimeMillis - jQueryinitopentime;
            C11839m.m70688i("HiSyncUtil", "has no backup record");
        } else {
            j10 = jCurrentTimeMillis - jQuerylastsuccesstime;
            C11839m.m70688i("HiSyncUtil", "has success backup record");
        }
        long j11 = (j10 - 1) / 86400000;
        if (j11 == 0) {
            j11++;
        }
        C11839m.m70688i("HiSyncUtil", "Has not been backed up days = " + j11);
        return j11;
    }

    /* renamed from: y0 */
    public static void m16191y0(RecommendCardReport recommendCardReport, Intent intent) {
        try {
            SafeIntent safeIntent = new SafeIntent(intent);
            recommendCardReport.setActivityId(safeIntent.getStringExtra("recommend_card_activity_id"));
            recommendCardReport.setActivityType(safeIntent.getStringExtra("recommend_card_activity_type"));
            recommendCardReport.setEntrance(safeIntent.getStringExtra("recommend_card_entrance"));
        } catch (Throwable th2) {
            C11839m.m70687e("HiSyncUtil", "parseRecommendCardReportParam err " + th2.getMessage());
        }
    }

    /* renamed from: z */
    public static int m16192z(Context context) {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("HiSyncUtil", "cloudAlbumRouterImpl is null");
            return 0;
        }
        long jMo58423f = interfaceC9282a.mo58423f(context) - System.currentTimeMillis();
        if (jMo58423f < 0) {
            return interfaceC9282a.mo58372I(context);
        }
        int i10 = (int) (jMo58423f / 86400000);
        return (interfaceC9282a.mo58368G() || jMo58423f % 86400000 <= 0) ? i10 : i10 + 1;
    }

    /* renamed from: z0 */
    public static void m16193z0(Context context, String str) {
        if (context == null) {
            C11839m.m70687e("HiSyncUtil", "populateForAnnounce,context is null");
            return;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getApplicationContext().getSystemService("accessibility");
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(16384);
        accessibilityEventObtain.setClassName(context.getClass().getName());
        accessibilityEventObtain.setPackageName(context.getApplicationContext().getPackageName());
        accessibilityEventObtain.getText().add(str);
        accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
    }
}
