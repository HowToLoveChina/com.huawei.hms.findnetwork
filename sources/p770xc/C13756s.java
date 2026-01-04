package p770xc;

import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.notification.CloudSyncNotificationManager;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.sync.syncutil.C2984m;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.manager.DataUpperLimitNoticeManager;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import je.C10800n;
import je.C10812z;
import p015ak.C0209d;
import p514o9.C11839m;
import p572qb.C12329u;
import vc.C13405i;

@CBServiceTask(request = 55000009, response = 66000009)
/* renamed from: xc.s */
/* loaded from: classes3.dex */
public class C13756s extends AbstractC13752o {

    /* renamed from: y */
    public boolean f61855y = false;

    /* renamed from: z */
    public ArrayList<SyncData> f61856z = null;

    /* renamed from: A */
    public ArrayList<SyncData> f61849A = null;

    /* renamed from: B */
    public ArrayList<String> f61850B = null;

    /* renamed from: C */
    public ArrayList<SyncData> f61851C = null;

    /* renamed from: D */
    public ArrayList<UnstructData> f61852D = null;

    /* renamed from: E */
    public int f61853E = 0;

    /* renamed from: F */
    public C12329u f61854F = null;

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) throws Throwable {
        if (this.f53282a == null) {
            C11839m.m70687e("UploadDataTask", "afterWorkDone mContext is null");
            return;
        }
        C11839m.m70688i("UploadDataTask", "End afterWorkDone syncResult = " + this.f61853E);
        int i10 = this.f61853E;
        if (i10 == 14 || C2984m.m17915i(i10)) {
            C11839m.m70688i("UploadDataTask", "exceed limit ,syncType = " + this.f61834s);
            if ("calendar".equals(this.f61834s)) {
                m82641H("notify_calendar_time", "calendar", R$string.calendar_exceed_limit_new);
                return;
            }
            if ("notepad".equals(this.f61834s)) {
                m82641H("notify_notepad_time", "notepad", R$string.notepad_exceed_limit_new);
                return;
            }
            if ("browser".equals(this.f61834s)) {
                m82641H("notify_browser_time", "browser", R$string.browser_exceed_limit_new);
            } else if ("addressbook".equals(this.f61834s)) {
                m82641H("notify_contact_time", "addressbook", R$string.contact_exceed_limit_new);
            } else {
                m82639F(this.f61834s);
            }
        }
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("UploadDataTask", "Begin doWork");
        C13405i c13405i = new C13405i(this.f53282a, this.f61834s, this.f61835t, this.f61856z, this.f61849A, this.f61851C, this.f61852D, this.f61850B, this.f61855y, this.f61832q, this.f61833r, this.f61836u, this.f61854F, this.f61838w);
        c13405i.setConfig(this.f61834s, this.f53297m, this.f61839x);
        this.f61853E = c13405i.m80665C1();
        return Boolean.FALSE;
    }

    /* renamed from: D */
    public final String m82637D(String str) {
        str.hashCode();
        switch (str) {
            case "addressbook":
                return "contactMainText";
            case "calendar":
                return "calendarMainText";
            case "browser":
                return "browserMainText";
            case "notepad":
                return "notepadMainText";
            default:
                C11839m.m70687e("UploadDataTask", "getNoticeMainTextKey module is invalid.");
                return null;
        }
    }

    /* renamed from: E */
    public final String m82638E(String str) {
        str.hashCode();
        switch (str) {
            case "addressbook":
                return "contactTitle";
            case "calendar":
                return "calendarTitle";
            case "browser":
                return "browserTitle";
            case "notepad":
                return "notepadTitle";
            default:
                C11839m.m70687e("UploadDataTask", "getNoticeTitleKey module is invalid.");
                return null;
        }
    }

    /* renamed from: F */
    public final void m82639F(String str) throws Throwable {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SyncConfigService serviceById = new SyncConfigOperator().getServiceById(str);
        if (serviceById != null) {
            String str2 = "notify_time_" + str;
            long syncNotifyTime = CloudSyncNotificationManager.getSyncNotifyTime(this.f53282a, str2);
            if (jCurrentTimeMillis - syncNotifyTime > 86400000) {
                String name = serviceById.getName();
                if (!TextUtils.isEmpty(name)) {
                    String stringFromSyncConfig = NotifyUtil.getStringFromSyncConfig(name);
                    if (!TextUtils.isEmpty(stringFromSyncConfig)) {
                        C11839m.m70688i("UploadDataTask", "exceed notify, syncType: " + str);
                        CloudSyncNotificationManager cloudSyncNotificationManager = new CloudSyncNotificationManager(this.f53282a);
                        String extraNoticeLanguage = DataUpperLimitNoticeManager.getInstance().getExtraNoticeLanguage("generalTitle");
                        String extraNoticeLanguage2 = DataUpperLimitNoticeManager.getInstance().getExtraNoticeLanguage("generalMainText");
                        if (TextUtils.isEmpty(extraNoticeLanguage) || TextUtils.isEmpty(extraNoticeLanguage2)) {
                            string = this.f53282a.getResources().getString(R$string.universal_sync_exceed_limit, stringFromSyncConfig);
                            extraNoticeLanguage = null;
                        } else {
                            string = extraNoticeLanguage2.replace("%1$s", stringFromSyncConfig);
                        }
                        cloudSyncNotificationManager.setSyncActivityNotify(extraNoticeLanguage, string, str, C0209d.m1300r0(this.f53282a, serviceById.getApplications()));
                        CloudSyncNotificationManager.writeSyncNotifyTime(this.f53282a, str2, jCurrentTimeMillis);
                    }
                }
                m82640G(str, syncNotifyTime);
            }
        }
    }

    /* renamed from: G */
    public final void m82640G(String str, long j10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("lastNotifyTime", String.valueOf(j10));
        linkedHashMap.putAll(C10812z.m65833b(this.f61836u));
        C10812z.m65846o(this.f53282a, str, 0, "", "03001", "upload_exceed_notify", this.f61833r, linkedHashMap, false);
    }

    /* renamed from: H */
    public final void m82641H(String str, String str2, int i10) throws Resources.NotFoundException {
        long syncNotifyTime = CloudSyncNotificationManager.getSyncNotifyTime(this.f53282a, str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - syncNotifyTime > 86400000) {
            CloudSyncNotificationManager cloudSyncNotificationManager = new CloudSyncNotificationManager(this.f53282a);
            String extraNoticeLanguage = DataUpperLimitNoticeManager.getInstance().getExtraNoticeLanguage(m82638E(str2));
            String extraNoticeLanguage2 = DataUpperLimitNoticeManager.getInstance().getExtraNoticeLanguage(m82637D(str2));
            if (TextUtils.isEmpty(extraNoticeLanguage) || TextUtils.isEmpty(extraNoticeLanguage2)) {
                extraNoticeLanguage2 = this.f53282a.getResources().getString(i10);
                extraNoticeLanguage = null;
            }
            cloudSyncNotificationManager.setSyncActivityNotify(extraNoticeLanguage, extraNoticeLanguage2, str2);
            CloudSyncNotificationManager.writeSyncNotifyTime(this.f53282a, str, jCurrentTimeMillis);
            m82640G(this.f61834s, syncNotifyTime);
        }
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("UploadDataTask", "Begin beforeWorkStart");
        super.mo66489c();
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61856z = (ArrayList) c10800nM68549a.m65739d("addList");
        this.f61849A = (ArrayList) c10800nM68549a.m65739d("modifyList");
        this.f61850B = (ArrayList) c10800nM68549a.m65739d("deleteList");
        this.f61851C = (ArrayList) c10800nM68549a.m65739d("lostRefundList");
        this.f61855y = ((Boolean) c10800nM68549a.m65739d("havefile")).booleanValue();
        this.f61852D = (ArrayList) c10800nM68549a.m65739d("local_file_list");
        this.f61854F = c10800nM68549a.m65739d("sync_moudle_lost_refund_impl") != null ? (C12329u) c10800nM68549a.m65739d("sync_moudle_lost_refund_impl") : null;
    }
}
