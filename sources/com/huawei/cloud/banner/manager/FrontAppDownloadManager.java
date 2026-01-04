package com.huawei.cloud.banner.manager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import ba.C1159m;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.cloud.pay.R$drawable;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.FrontAppDownloadStatus;
import com.huawei.hicloud.base.common.CommonBaseBroadcastReceiver;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0213f;
import p015ak.C0238w;
import p054cj.C1442a;
import p258ei.C9494c;
import p514o9.C11839m;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* loaded from: classes.dex */
public class FrontAppDownloadManager {

    /* renamed from: e */
    public static FrontAppDownloadManager f21119e = new FrontAppDownloadManager();

    /* renamed from: a */
    public List<FrontAppDownloadStatus> f21120a = new ArrayList();

    /* renamed from: b */
    public String f21121b = "";

    /* renamed from: c */
    public String f21122c = "";

    /* renamed from: d */
    public LocalBroadcast f21123d = new LocalBroadcast();

    public class LocalBroadcast extends CommonBaseBroadcastReceiver {
        public LocalBroadcast() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ActivityEntry activityEntryM59423s;
            String resource;
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            C1442a.m8288d("FrontAppDownloadManager", "onReceive: " + action);
            if (!"com.huawei.cloud.FRONT_APP_DOWNLOAD_SUCCESS".equals(action)) {
                if ("com.huawei.cloud.FRONT_APP_OPEN".equals(action)) {
                    try {
                        FrontAppDownloadManager.this.m28143h(safeIntent.getStringExtra(MapKeyNames.PACKAGE_NAME), safeIntent.getStringExtra("unique_id"));
                        return;
                    } catch (Exception e10) {
                        C1442a.m8289e("FrontAppDownloadManager", e10.getMessage());
                        return;
                    }
                }
                if ("com.huawei.cloud.FRONT_APP_CILCK_NOTIFICATION".equals(action)) {
                    try {
                        Intent intentM28136i = FrontAppDownloadManager.m28136i();
                        intentM28136i.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                        context.startActivity(intentM28136i);
                        FrontAppDownloadManager frontAppDownloadManager = FrontAppDownloadManager.this;
                        frontAppDownloadManager.m28146m(frontAppDownloadManager.f21121b, FrontAppDownloadManager.this.f21122c);
                        return;
                    } catch (Exception e11) {
                        C1442a.m8289e("FrontAppDownloadManager", e11.getMessage());
                        return;
                    }
                }
                return;
            }
            String stringExtra = safeIntent.getStringExtra(MapKeyNames.PACKAGE_NAME);
            FrontAppDownloadManager.this.m28149q(stringExtra, safeIntent.getStringExtra("unique_id"));
            if (!FrontAppDownloadManager.this.m28140e() || (activityEntryM59423s = C9494c.m59390r().m59423s()) == null || (resource = activityEntryM59423s.getResource()) == null) {
                return;
            }
            try {
                String strFromDBByResource = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_DOUBLE_NOTIFYBAR_TITLE);
                String strFromDBByResource2 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_DOUBLE_NOTIFYBAR);
                if (TextUtils.isEmpty(strFromDBByResource)) {
                    FrontAppDownloadManager frontAppDownloadManager2 = FrontAppDownloadManager.this;
                    frontAppDownloadManager2.m28148p(frontAppDownloadManager2.f21121b, FrontAppDownloadManager.this.f21122c, stringExtra);
                } else {
                    FrontAppDownloadManager.this.m28150r(strFromDBByResource, strFromDBByResource2);
                    FrontAppDownloadManager frontAppDownloadManager3 = FrontAppDownloadManager.this;
                    frontAppDownloadManager3.m28147n(frontAppDownloadManager3.f21121b, FrontAppDownloadManager.this.f21122c, stringExtra);
                }
            } catch (Exception e12) {
                C1442a.m8289e("FrontAppDownloadManager", e12.getMessage());
            }
        }
    }

    /* renamed from: c */
    public static void m28135c(Intent intent, ActivityEntry activityEntry) {
        if (activityEntry == null || activityEntry.getCampaignInfo() == null) {
            C1442a.m8291w("FrontAppDownloadManager", "activityEntry is null");
            return;
        }
        AdParametersExt adParametersExt = activityEntry.getCampaignInfo().getAdParametersExt();
        if (adParametersExt == null) {
            C1442a.m8291w("FrontAppDownloadManager", "adParameters is null");
            return;
        }
        intent.putExtra("agd_resource_enable", adParametersExt.getEnabled());
        intent.putExtra("agd_resource_slot_id", adParametersExt.getAgdAdid());
        intent.putExtra("pps_threshold", adParametersExt.getThreshold());
    }

    /* renamed from: i */
    public static Intent m28136i() {
        ActivityEntry activityEntryM59423s = C9494c.m59390r().m59423s();
        Intent dlAppWebViewIntent = null;
        if (activityEntryM59423s == null) {
            C11839m.m70687e("FrontAppDownloadManager", "getDlappDoubleIntent activityEntry is null");
            return null;
        }
        try {
            Uri.Builder builderBuildUpon = Uri.parse(activityEntryM59423s.getUrl()).buildUpon();
            builderBuildUpon.appendQueryParameter(RemoteMessageConst.FROM, "preApp");
            dlAppWebViewIntent = NotifyUtil.getDlAppWebViewIntent(C0213f.m1377a(), builderBuildUpon.toString());
            dlAppWebViewIntent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
            m28135c(dlAppWebViewIntent, activityEntryM59423s);
            return dlAppWebViewIntent;
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppDownloadManager", "getDlappIntent e:" + e10.toString());
            return dlAppWebViewIntent;
        }
    }

    /* renamed from: j */
    public static FrontAppDownloadManager m28137j() {
        return f21119e;
    }

    /* renamed from: o */
    public static void m28138o(String str, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        if (linkedHashMap != null) {
            linkedHashMapM79497A.putAll(linkedHashMap);
        }
        C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", str, linkedHashMapM79497A);
    }

    /* renamed from: d */
    public void m28139d() {
        ((NotificationManager) C0213f.m1377a().getSystemService("notification")).cancel(392);
    }

    /* renamed from: e */
    public boolean m28140e() {
        if (this.f21120a.isEmpty()) {
            return false;
        }
        Iterator<FrontAppDownloadStatus> it = this.f21120a.iterator();
        while (it.hasNext()) {
            if (it.next().getDownloadStatus() == 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean m28141f(String str) {
        if (this.f21120a.isEmpty()) {
            return false;
        }
        Iterator<FrontAppDownloadStatus> it = this.f21120a.iterator();
        while (it.hasNext()) {
            if (it.next().getPackageName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public void m28142g() {
        this.f21120a = new ArrayList();
    }

    /* renamed from: h */
    public void m28143h(String str, String str2) {
        FrontAppDownloadStatus frontAppDownloadStatus = null;
        for (int i10 = 0; i10 < this.f21120a.size(); i10++) {
            FrontAppDownloadStatus frontAppDownloadStatus2 = this.f21120a.get(i10);
            if (frontAppDownloadStatus2.getPackageName().equals(str) && frontAppDownloadStatus2.getUniqueId().equals(str2)) {
                frontAppDownloadStatus = frontAppDownloadStatus2;
            }
        }
        if (frontAppDownloadStatus != null) {
            this.f21120a.remove(frontAppDownloadStatus);
        }
    }

    /* renamed from: k */
    public boolean m28144k(C1159m c1159m) {
        m28142g();
        m28139d();
        String strM7238c = c1159m.m7238c();
        String strM7239d = c1159m.m7239d();
        this.f21121b = strM7238c;
        this.f21122c = strM7239d;
        INativeAd iNativeAdM7236a = c1159m.m7236a();
        INativeAd iNativeAdM7237b = c1159m.m7237b();
        if (!TextUtils.isEmpty(strM7238c) && !TextUtils.isEmpty(strM7239d) && iNativeAdM7236a != null && iNativeAdM7237b != null) {
            String uniqueId = iNativeAdM7236a.getUniqueId();
            String uniqueId2 = iNativeAdM7237b.getUniqueId();
            if (!TextUtils.isEmpty(uniqueId) && !TextUtils.isEmpty(uniqueId2)) {
                C1442a.m8288d("FrontAppDownloadManager", "save front app packageName: " + strM7238c + " , " + strM7239d);
                C1442a.m8288d("FrontAppDownloadManager", "save front app uniqueId: " + uniqueId + " , " + uniqueId2);
                this.f21120a.add(new FrontAppDownloadStatus(strM7238c, 0, uniqueId));
                this.f21120a.add(new FrontAppDownloadStatus(strM7239d, 0, uniqueId2));
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    public void m28145l() {
        C1442a.m8288d("FrontAppDownloadManager", "registerBroadcastReceiver start");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70689w("FrontAppDownloadManager", "context is null");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.cloud.FRONT_APP_DOWNLOAD_SUCCESS");
        intentFilter.addAction("com.huawei.cloud.FRONT_APP_OPEN");
        intentFilter.addAction("com.huawei.cloud.FRONT_APP_CILCK_NOTIFICATION");
        LocalBroadcast localBroadcast = this.f21123d;
        if (localBroadcast != null) {
            localBroadcast.m29111a(contextM1377a, intentFilter);
        }
    }

    /* renamed from: m */
    public void m28146m(String str, String str2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("app_package_name_first", str);
            linkedHashMap.put("app_package_name_second", str2);
            m28138o("two_app_installed_notify_click", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppDownloadManager", "reportAppInstalledNotifyClick exception, e: " + e10.toString());
        }
    }

    /* renamed from: n */
    public void m28147n(String str, String str2, String str3) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("app_package_name_first", str);
            linkedHashMap.put("app_package_name_second", str2);
            linkedHashMap.put("app_package_name_key_notifiy_download", str3);
            m28138o("two_app_installed_notify_pop", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppDownloadManager", "reportAppInstalledNotifyPop exception, e: " + e10.toString());
        }
    }

    /* renamed from: p */
    public void m28148p(String str, String str2, String str3) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("app_package_name_first", str);
            linkedHashMap.put("app_package_name_second", str2);
            linkedHashMap.put("app_package_name_key_notifiy_download", str3);
            m28138o("two_app_notify_pop_error", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppDownloadManager", "reportAppInstalledNotifyPop exception, e: " + e10.toString());
        }
    }

    /* renamed from: q */
    public boolean m28149q(String str, String str2) {
        for (FrontAppDownloadStatus frontAppDownloadStatus : this.f21120a) {
            if (frontAppDownloadStatus.getPackageName().equals(str) && frontAppDownloadStatus.getUniqueId().equals(str2)) {
                frontAppDownloadStatus.setDownloadStatus(1);
                return true;
            }
        }
        C1442a.m8288d("FrontAppDownloadManager", "setAppDownloadFinish failed, packageName = " + str + " uniqueId = " + str2);
        return false;
    }

    /* renamed from: r */
    public void m28150r(String str, String str2) {
        Context contextM1377a = C0213f.m1377a();
        NotificationManager notificationManager = (NotificationManager) contextM1377a.getSystemService("notification");
        NotificationCompat.Builder builderM1668i = C0238w.m1663f().m1668i(contextM1377a, "FrontAppDownloadManager");
        Intent intent = new Intent();
        intent.setClass(C0213f.m1377a(), CommonNotifyReceiver.class);
        intent.setAction(CommonNotifyReceiver.COMMON_ACTION);
        intent.putExtra("requestId", NotifyConstants.CommonActionRequestCode.OPEN_DOUBLE_FRONT_APP_NOTICE);
        builderM1668i.m3824y(R$drawable.logo_about_system).m3811l(str).m3810k(str2).m3817r("com.huawei.android.hicloud.notification").m3823x(true).m3800C(System.currentTimeMillis()).m3807h(true).m3809j(PendingIntent.getBroadcast(contextM1377a, 4, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK)).m3819t(false);
        notificationManager.notify(392, builderM1668i.m3804d());
    }

    /* renamed from: s */
    public void m28151s() {
        C1442a.m8288d("FrontAppDownloadManager", "unRegisterBroadcastReceiver start");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70689w("FrontAppDownloadManager", "context is null");
            return;
        }
        LocalBroadcast localBroadcast = this.f21123d;
        if (localBroadcast != null) {
            localBroadcast.m29112b(contextM1377a);
        }
    }
}
