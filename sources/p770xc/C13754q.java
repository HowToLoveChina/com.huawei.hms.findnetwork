package p770xc;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.p088ui.notification.CloudSyncNotificationManager;
import com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo;
import com.huawei.android.hicloud.sync.service.aidl.ModuleRst;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.sync.wifi.SyncWlanImp;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.notification.manager.DataUpperLimitNoticeManager;
import gp.C10028c;
import java.util.concurrent.ConcurrentHashMap;
import je.C10800n;
import je.C10812z;
import ke.C11046a;
import p015ak.C0209d;
import p514o9.C11839m;
import tc.C13007b;

@CBServiceTask(request = 55000005, response = 66000005)
/* renamed from: xc.q */
/* loaded from: classes3.dex */
public class C13754q extends AbstractC13752o {

    /* renamed from: B */
    public ReportSyncEndInfo f61845B;

    /* renamed from: C */
    public ConcurrentHashMap<String, Boolean> f61846C;

    /* renamed from: y */
    public int f61847y;

    /* renamed from: z */
    public ModuleRst f61848z = null;

    /* renamed from: A */
    public boolean f61844A = false;

    /* renamed from: D */
    private void m82624D() {
        String str;
        SharedPreferences.Editor editorEdit = this.f61831p.edit();
        if (this.f61831p.getBoolean("wlannotAllSucess", false)) {
            editorEdit.remove("wlannotAllSucess");
            editorEdit.commit();
            CloudSyncUtil.m16048t("wlannotAllSucess");
        }
        int retCode = this.f61848z.getRetCode();
        String failReason = this.f61848z.getFailReason();
        C11839m.m70688i("SyncWlanTask", "Wlan sync result = " + retCode);
        C2980i.m17879n(this.f61845B, retCode, failReason);
        if (retCode == 0) {
            editorEdit.putString("wlansync_syncTime", String.valueOf(System.currentTimeMillis()));
            editorEdit.putInt("wlansync_retcode", 0);
            editorEdit.putBoolean("wlannotAllSucess", false);
            editorEdit.commit();
            CloudSyncUtil.m16048t("wlannotAllSucess");
            C10812z.m65839h(this.f53282a, "wlan", retCode, "", "", this.f61832q, "success", this.f61833r, null, true);
            str = "wlan";
        } else {
            if (retCode != 17) {
                editorEdit.putBoolean("wlannotAllSucess", true);
            }
            editorEdit.putInt("wlansync_retcode", retCode);
            editorEdit.commit();
            if (C10028c.m62182c0().m62388s("wlan")) {
                CloudSyncUtil.m16014h1("wlannotAllSucess", String.valueOf(5));
            }
            C11839m.m70688i("SyncWlanTask", "Wlan sync result = " + retCode + ",reason: " + failReason);
            str = "wlan";
            C10812z.m65839h(this.f53282a, "wlan", this.f61848z.getReturnCode(), this.f61848z.getErrorSource(), failReason, this.f61832q, "fail", this.f61833r, null, true);
        }
        C2980i.m17868c(this.f53282a, str, this.f61845B, "com.huawei.hidisk");
        m82625E();
        C2980i.m17867b(str);
    }

    /* renamed from: E */
    private void m82625E() {
        C11839m.m70688i("SyncWlanTask", "notifyUISyncEnd");
        CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END", "wlan");
    }

    /* renamed from: F */
    private void m82626F() {
        C11839m.m70688i("SyncWlanTask", "notifyUISyncStart");
        CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_START", "wlan");
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) throws Resources.NotFoundException {
        if (this.f53282a == null) {
            C11839m.m70687e("SyncWlanTask", "afterWorkDone mContext is null");
            return;
        }
        m82624D();
        C11839m.m70686d("SyncWlanTask", "sync wlan end, send message  ");
        if (14 == this.f61848z.getRetCode()) {
            long syncNotifyTime = CloudSyncNotificationManager.getSyncNotifyTime(this.f53282a, "notify_wlan_time");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - syncNotifyTime > 86400000) {
                CloudSyncNotificationManager cloudSyncNotificationManager = new CloudSyncNotificationManager(this.f53282a);
                if (C0209d.m1262h2()) {
                    String extraNoticeLanguage = DataUpperLimitNoticeManager.getInstance().getExtraNoticeLanguage("wlanTitle");
                    String extraNoticeLanguage2 = DataUpperLimitNoticeManager.getInstance().getExtraNoticeLanguage("wlanMainText");
                    if (TextUtils.isEmpty(extraNoticeLanguage) || TextUtils.isEmpty(extraNoticeLanguage2)) {
                        extraNoticeLanguage2 = this.f53282a.getResources().getString(R$string.wlan_exceed_limit_new);
                        extraNoticeLanguage = null;
                    }
                    cloudSyncNotificationManager.setSyncActivityNotify(extraNoticeLanguage, extraNoticeLanguage2, "wlan");
                } else {
                    cloudSyncNotificationManager.setSyncActivityNotify(this.f53282a.getResources().getString(R$string.wifi_exceed_limit_new), "wlan");
                }
                CloudSyncNotificationManager.writeSyncNotifyTime(this.f53282a, "notify_wlan_time", jCurrentTimeMillis);
            }
        }
        C11046a.m66593a(this.f53297m, 114, 0, 0, this.f61848z);
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        m82630H(this.f61847y);
        return Boolean.FALSE;
    }

    /* renamed from: G */
    public void m82629G() {
        C11839m.m70686d("SyncWlanTask", "prepareOpr");
        SharedPreferences.Editor editorEdit = this.f61831p.edit();
        editorEdit.putInt("wlansync_retcode", 4);
        editorEdit.putBoolean("wlannotAllSucess", true);
        editorEdit.commit();
        CloudSyncUtil.m16014h1("wlannotAllSucess", String.valueOf(5));
    }

    /* renamed from: H */
    public final void m82630H(int i10) throws Throwable {
        ModuleRst moduleRstDoSync = new SyncWlanImp(this.f53282a, this.f61832q, this.f61833r, this.f61845B, this.f61846C).doSync(this.f53297m, i10);
        this.f61848z = moduleRstDoSync;
        moduleRstDoSync.setModuleName("wlan");
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70686d("SyncWlanTask", "beforeWorkStart");
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61847y = ((Integer) c10800nM68549a.m65739d("synctype")).intValue();
        this.f61845B = (ReportSyncEndInfo) c10800nM68549a.m65739d("sync_report_end_info");
        this.f61846C = (ConcurrentHashMap) c10800nM68549a.m65739d("sync_flow_control_effect_flag");
        this.f61848z = new ModuleRst();
        this.f61832q = "03001";
        this.f61833r = C10812z.m65832a("03001");
        m82629G();
        this.f61848z.setModuleName("wlan");
        this.f61848z.setRetCode(4);
        C11046a.m66593a(this.f53297m, 113, 0, 0, this.f61848z);
        m82626F();
        C13007b.m78205Y(this.f53282a).m78270l("wlan", "");
    }
}
