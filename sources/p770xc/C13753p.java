package p770xc;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.p088ui.notification.CloudSyncNotificationManager;
import com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo;
import com.huawei.android.hicloud.sync.contact.C2891p;
import com.huawei.android.hicloud.sync.service.aidl.ModuleRst;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.notification.manager.DataUpperLimitNoticeManager;
import je.C10800n;
import je.C10812z;
import ke.C11046a;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11839m;
import p573qc.C12338d;
import p709vj.C13452e;

@CBServiceTask(request = 55000004, response = 66000004)
/* renamed from: xc.p */
/* loaded from: classes3.dex */
public class C13753p extends AbstractC13752o {

    /* renamed from: B */
    public ReportSyncEndInfo f61841B;

    /* renamed from: y */
    public SyncType f61842y = null;

    /* renamed from: z */
    public ModuleRst f61843z = null;

    /* renamed from: A */
    public boolean f61840A = false;

    /* renamed from: E */
    private void m82617E() {
        CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END", "addressbook");
    }

    /* renamed from: F */
    private void m82618F() {
        CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_START", "addressbook");
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) throws Resources.NotFoundException {
        if (this.f53282a == null) {
            C11839m.m70687e("SyncContactTask", "afterWorkDone mContext is null");
            return;
        }
        m82621D();
        if (14 == this.f61843z.getRetCode()) {
            long syncNotifyTime = CloudSyncNotificationManager.getSyncNotifyTime(this.f53282a, "notify_contact_time");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - syncNotifyTime > 86400000) {
                CloudSyncNotificationManager cloudSyncNotificationManager = new CloudSyncNotificationManager(this.f53282a);
                String extraNoticeLanguage = DataUpperLimitNoticeManager.getInstance().getExtraNoticeLanguage("contactTitle");
                String extraNoticeLanguage2 = DataUpperLimitNoticeManager.getInstance().getExtraNoticeLanguage("contactMainText");
                if (TextUtils.isEmpty(extraNoticeLanguage) || TextUtils.isEmpty(extraNoticeLanguage2)) {
                    extraNoticeLanguage2 = this.f53282a.getResources().getString(R$string.contact_exceed_limit_new);
                    extraNoticeLanguage = null;
                }
                cloudSyncNotificationManager.setSyncActivityNotify(extraNoticeLanguage, extraNoticeLanguage2, "addressbook");
                CloudSyncNotificationManager.writeSyncNotifyTime(this.f53282a, "notify_contact_time", jCurrentTimeMillis);
            }
        }
        C11839m.m70686d("SyncContactTask", "sync contact end, send message");
        C11046a.m66593a(this.f53297m, 112, 0, 0, this.f61843z);
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        m82623H(this.f61842y, this.f61841B);
        return Boolean.FALSE;
    }

    /* renamed from: D */
    public final void m82621D() {
        String str;
        SharedPreferences.Editor editorEdit = this.f61831p.edit();
        if (this.f61831p.getBoolean("addressbooknotAllSucess", false)) {
            editorEdit.remove("addressbooknotAllSucess");
            editorEdit.commit();
        }
        int retCode = this.f61843z.getRetCode();
        int returnCode = this.f61843z.getReturnCode();
        String str2 = "scene: " + this.f61842y.getBiReportType() + " " + this.f61843z.getFailReason();
        C11839m.m70688i("SyncContactTask", "Contact sync result = " + retCode + ", returnCode = " + returnCode + ", msg = " + str2);
        C2980i.m17879n(this.f61841B, returnCode, str2);
        if (retCode == 0) {
            editorEdit.putLong("addressbooksync_syncTime", System.currentTimeMillis());
            editorEdit.putInt("addressbooksync_retcode", 0);
            editorEdit.putBoolean("addressbooknotAllSucess", false);
            editorEdit.commit();
            str = "SyncContactTask";
            C10812z.m65839h(this.f53282a, "addressbook", returnCode, "", str2, this.f61832q, "success", this.f61833r, null, true);
        } else {
            str = "SyncContactTask";
            if (retCode != 17) {
                editorEdit.putBoolean("addressbooknotAllSucess", true);
            }
            editorEdit.putInt("addressbooksync_retcode", retCode);
            editorEdit.commit();
            if (returnCode == 2200 && C13452e.m80781L().m80917g1()) {
                str2 = "endOpr: local ST invalid flag is true";
                C11839m.m70689w(str, "endOpr: local ST invalid flag is true");
                returnCode = 2001;
            }
            C10812z.m65839h(this.f53282a, "addressbook", returnCode, this.f61843z.getErrorSource(), str2, this.f61832q, "fail", this.f61833r, null, true);
        }
        C2980i.m17868c(this.f53282a, "addressbook", this.f61841B, "com.huawei.hidisk");
        m82617E();
        if (!C11829c.m70611r0()) {
            C11839m.m70688i(str, "end sync task");
            if (!C0209d.m1208S0(this.f53282a)) {
                C12338d.m74195s().m74241o0();
                C12338d.m74195s().m74216T();
            }
        }
        C2980i.m17867b("addressbook");
    }

    /* renamed from: G */
    public void m82622G() {
        SharedPreferences.Editor editorEdit = this.f61831p.edit();
        editorEdit.putInt("addressbooksync_retcode", 4);
        editorEdit.putBoolean("addressbooknotAllSucess", true);
        editorEdit.commit();
        if (this.f61840A) {
            editorEdit.putInt("last_sync_type", -1).commit();
        }
        editorEdit.putBoolean("isCloud", false).commit();
        editorEdit.putBoolean("isNeedAlert", false).commit();
        editorEdit.putBoolean("isNeedRechoose", false).commit();
    }

    /* renamed from: H */
    public final void m82623H(SyncType syncType, ReportSyncEndInfo reportSyncEndInfo) throws Throwable {
        ModuleRst moduleRstM17692z0 = new C2891p(this.f53282a, this.f61832q, this.f61833r).m17692z0(this.f53297m, syncType, reportSyncEndInfo);
        this.f61843z = moduleRstM17692z0;
        moduleRstM17692z0.setModuleName("addressbook");
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61842y = (SyncType) c10800nM68549a.m65739d("synctype");
        this.f61840A = ((Boolean) c10800nM68549a.m65739d("synauto")).booleanValue();
        this.f61841B = (ReportSyncEndInfo) c10800nM68549a.m65739d("sync_report_end_info");
        this.f61843z = new ModuleRst();
        this.f61832q = "03001";
        this.f61833r = C10812z.m65832a("03001");
        m82622G();
        this.f61843z.setModuleName("addressbook");
        this.f61843z.setRetCode(4);
        C11046a.m66593a(this.f53297m, 111, 0, 0, this.f61843z);
        m82618F();
    }
}
