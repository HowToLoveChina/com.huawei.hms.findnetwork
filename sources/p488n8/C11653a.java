package p488n8;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.drive.clouddisk.presenter.callback.DownloadProgressListener;
import com.huawei.android.hicloud.task.frame.RequestDispatcher;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.DownloadItem;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import je.C10800n;
import je.C10812z;
import md.C11440c;
import md.C11442e;
import p015ak.C0206b0;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p514o9.C11839m;
import p516ob.C11845a;
import p837z9.C14163d;

/* renamed from: n8.a */
/* loaded from: classes2.dex */
public class C11653a {

    /* renamed from: d */
    public static C11653a f54060d;

    /* renamed from: e */
    public static final Object f54061e = new Object();

    /* renamed from: a */
    public Context f54062a;

    /* renamed from: b */
    public RequestDispatcher f54063b;

    /* renamed from: c */
    public SharedPreferences f54064c = null;

    public C11653a() {
        this.f54062a = null;
        this.f54063b = null;
        this.f54062a = C0213f.m1377a();
        this.f54063b = new RequestDispatcher(this.f54062a);
    }

    /* renamed from: l */
    public static C11653a m69582l() {
        C11653a c11653a;
        synchronized (f54061e) {
            try {
                if (f54060d == null) {
                    f54060d = new C11653a();
                }
                c11653a = f54060d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c11653a;
    }

    /* renamed from: p */
    public static void m69583p(C11653a c11653a) {
        synchronized (f54061e) {
            f54060d = c11653a;
        }
    }

    /* renamed from: q */
    public static void m69584q(String str, ModuleItem moduleItem, C10800n c10800n) {
        if ("notepad".equals(str)) {
            ArrayList arrayList = new ArrayList();
            ArrayList<DownloadItem> downloadItems = moduleItem.getDownloadItems();
            if (downloadItems == null || downloadItems.isEmpty()) {
                return;
            }
            Iterator<DownloadItem> it = downloadItems.iterator();
            while (it.hasNext()) {
                DownloadItem next = it.next();
                if (next != null) {
                    String fileId = next.getFileId();
                    if (!TextUtils.isEmpty(fileId)) {
                        arrayList.add(fileId);
                    }
                }
            }
            c10800n.m65743h("fileIdList", arrayList);
        }
    }

    /* renamed from: a */
    public final boolean m69585a(Context context) {
        if (context == null || !C0209d.m1173G1(context)) {
            return false;
        }
        C11839m.m70688i("CloudDisk", "CloudDisk check isPrivacyUser, now exit Cloud!");
        CloudSyncUtil.m15974R0(context.getApplicationContext());
        CloudSyncUtil.m16055w(context);
        return true;
    }

    /* renamed from: b */
    public void m69586b(int i10) {
        C11440c.m68529g().m68543d(i10);
        m69583p(null);
        C11845a.m70914a();
    }

    /* renamed from: c */
    public int m69587c() {
        if (!C10028c.m62182c0().m62395t1("funcfg_call_log_up")) {
            C11839m.m70689w("CloudDisk", "server refused upload calllog");
            return -12;
        }
        if (m69585a(this.f54062a)) {
            C11839m.m70688i("CloudDisk", "enter doAutoBackupCallLog");
            return -4;
        }
        if (C10028c.m62182c0().m62206E1() || C14163d.m84990g().m85009o()) {
            C11839m.m70689w("CloudDisk", "onIncrementDataMigration CallLog cannot upload");
            C10812z.m65845n(this.f54062a, "callLog", -11, "", "onIncrementDataMigration", "03009", "local_upload", C10812z.m65832a("03009"));
            return -11;
        }
        if (m69596m("callLog")) {
            return -13;
        }
        boolean zM68533k = C11440c.m68533k("autocallloglistkey");
        boolean zM68531i = C11440c.m68531i("autocallloglistkey");
        boolean zM1131c = C0206b0.m1131c("autocallloglistkey", this.f54062a);
        C11839m.m70688i("CloudDisk", "hasRestorerCalllogTask: " + zM68533k + ", hasBackupCalllogTask: " + zM68531i + ", calllogSwitchStatus: " + zM1131c);
        if (zM68533k) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f54062a, "deviceNameSp", 0);
            this.f54064c = sharedPreferencesM1382b;
            sharedPreferencesM1382b.edit().putBoolean("autocallloglistkeynotAllSucess", true).commit();
            return 0;
        }
        if (zM68531i || !zM1131c) {
            return -4;
        }
        C10800n c10800n = new C10800n();
        c10800n.m65743h("BackupModuleArray", new String[]{"callLog"});
        this.f54063b.m18035b(new C11442e(55000015, c10800n), "autocallloglistkey");
        HiCloudNotification.getInstance().executeFromDataUse();
        return 0;
    }

    /* renamed from: d */
    public int m69588d() {
        if (!C10028c.m62182c0().m62395t1("funcfg_blocked_up")) {
            C11839m.m70689w("CloudDisk", "server refused upload blocked");
            return -12;
        }
        if (m69585a(this.f54062a)) {
            C11839m.m70688i("CloudDisk", "enter doAutoBackupPhoneManager");
            return -4;
        }
        if (C10028c.m62182c0().m62206E1() || C14163d.m84990g().m85009o()) {
            C11839m.m70689w("CloudDisk", "onIncrementDataMigration blocked cannot upload blocked");
            C10812z.m65845n(this.f54062a, "phonemanager", -11, "", "onIncrementDataMigration", "03009", "local_upload", C10812z.m65832a("03009"));
            return -11;
        }
        boolean zM68533k = C11440c.m68533k("autophonemanagerkey");
        boolean zM68531i = C11440c.m68531i("autophonemanagerkey");
        boolean zM1131c = C0206b0.m1131c("autophonemanagerkey", this.f54062a);
        C11839m.m70688i("CloudDisk", "hasRestorerPhonemanagerTask: " + zM68533k + ", hasBackupPhonemanagerTask: " + zM68531i + ", phonemanagerSwitchStatus: " + zM1131c);
        if (zM68533k) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f54062a, "deviceNameSp", 0);
            this.f54064c = sharedPreferencesM1382b;
            sharedPreferencesM1382b.edit().putBoolean("autophonemanagerkeynotAllSucess", true).commit();
            return 0;
        }
        if (!zM68531i && zM1131c) {
            C10800n c10800n = new C10800n();
            c10800n.m65743h("BackupModuleArray", new String[]{"phonemanager"});
            this.f54063b.m18035b(new C11442e(55000021, c10800n), "autophonemanagerkey");
            HiCloudNotification.getInstance().executeFromDataUse();
        }
        return -4;
    }

    /* renamed from: e */
    public int m69589e() {
        if (!C10028c.m62182c0().m62395t1("funcfg_recordings_up")) {
            C11839m.m70689w("CloudDisk", "server refused upload recording");
            return -12;
        }
        if (m69585a(this.f54062a)) {
            C11839m.m70688i("CloudDisk", "enter doAutoBackupRecording");
            return -4;
        }
        if (C10028c.m62182c0().m62206E1() || C14163d.m84990g().m85009o()) {
            C11839m.m70689w("CloudDisk", "onIncrementDataMigration recording cannot upload recording");
            C10812z.m65845n(this.f54062a, "recording", -11, "", "onIncrementDataMigration", "03009", "local_upload", C10812z.m65832a("03009"));
            return -11;
        }
        boolean zM68533k = C11440c.m68533k("autorecordingkey");
        boolean zM68531i = C11440c.m68531i("autorecordingkey");
        boolean zM1131c = C0206b0.m1131c("autorecordingkey", this.f54062a);
        boolean zM15940A0 = CloudSyncUtil.m15940A0(this.f54062a, "autorecordingkey");
        C11839m.m70688i("CloudDisk", "hasRestorerRcordingTask: " + zM68533k + ", hasBackupRcordingTask: " + zM68531i + ", rcordingSwitchStatus: " + zM1131c + ", isSatifyWifiAutoConstruction: " + zM15940A0);
        if (!zM15940A0 || zM68533k) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f54062a, "deviceNameSp", 0);
            this.f54064c = sharedPreferencesM1382b;
            sharedPreferencesM1382b.edit().putBoolean("autorecordingkeynotAllSucess", true).commit();
            return 0;
        }
        if (!zM68531i && zM1131c) {
            C11839m.m70688i("CloudDisk", "BackupRecordingTask start ");
            C10800n c10800n = new C10800n();
            c10800n.m65743h("BackupModuleArray", new String[]{"recording"});
            this.f54063b.m18035b(new C11442e(55000018, c10800n), "autorecordingkey");
            HiCloudNotification.getInstance().executeFromDataUse();
        }
        return -4;
    }

    /* renamed from: f */
    public int m69590f() {
        if (!C10028c.m62182c0().m62395t1("funcfg_messaging_up")) {
            C11839m.m70689w("CloudDisk", "server refused upload sms");
            return -12;
        }
        if (m69585a(this.f54062a)) {
            C11839m.m70688i("CloudDisk", "enter doAutoBackupSms");
            return -4;
        }
        if (C10028c.m62182c0().m62206E1() || C14163d.m84990g().m85009o()) {
            C11839m.m70689w("CloudDisk", "onIncrementDataMigration sms cannot upload");
            C10812z.m65845n(this.f54062a, NavigationUtils.SMS_SCHEMA_PREF, -11, "", "onIncrementDataMigration", "03009", "local_upload", C10812z.m65832a("03009"));
            return -11;
        }
        if (m69596m(NavigationUtils.SMS_SCHEMA_PREF)) {
            return -13;
        }
        boolean zM68533k = C11440c.m68533k("autosmslistkey");
        boolean zM68531i = C11440c.m68531i("autosmslistkey");
        boolean zM1131c = C0206b0.m1131c("autosmslistkey", this.f54062a);
        C11839m.m70688i("CloudDisk", "hasRestorerSmsTask: " + zM68533k + ", hasBackupSmsTask: " + zM68531i + ", smsSwitchStatus: " + zM1131c);
        if (zM68533k) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f54062a, "deviceNameSp", 0);
            this.f54064c = sharedPreferencesM1382b;
            sharedPreferencesM1382b.edit().putBoolean("autosmslistkeynotAllSucess", true).commit();
            return 0;
        }
        if (zM68531i || !zM1131c) {
            return -4;
        }
        C10800n c10800n = new C10800n();
        c10800n.m65743h("BackupModuleArray", new String[]{NavigationUtils.SMS_SCHEMA_PREF});
        this.f54063b.m18035b(new C11442e(55000014, c10800n), "autosmslistkey");
        HiCloudNotification.getInstance().executeFromDataUse();
        return 0;
    }

    /* renamed from: g */
    public void m69591g() {
        if (!C10028c.m62182c0().m62395t1("funcfg_call_log_down")) {
            C11839m.m70689w("CloudDisk", "server refused download calllog");
            return;
        }
        if (m69585a(this.f54062a)) {
            C11839m.m70688i("CloudDisk", "enter doRestoreCallLog");
            return;
        }
        if (!C14163d.m84990g().m85009o()) {
            this.f54063b.m18035b(new C11442e(55000202, new C10800n()), "restorecalllog");
        } else {
            C11839m.m70689w("CloudDisk", "onIncrementDataMigration calllog cannot download CallLog");
            C10812z.m65845n(this.f54062a, "callLog", -11, "", "onIncrementDataMigration", "03010", "local_download", C10812z.m65832a("03010"));
        }
    }

    /* renamed from: h */
    public void m69592h(ModuleItem moduleItem, DownloadProgressListener downloadProgressListener) {
        if (m69585a(this.f54062a)) {
            C11839m.m70688i("CloudDisk", "enter doRestoreNotePad");
            return;
        }
        if (!C14163d.m84990g().m85009o()) {
            this.f54063b.m18035b(new C11442e(55000203, new C10800n()), "restorenotepad");
        } else {
            C11839m.m70689w("CloudDisk", "onIncrementDataMigration cannot download notepad");
            C10812z.m65845n(this.f54062a, "notepad", -11, "", "onIncrementDataMigration", "03010", "local_download", C10812z.m65832a("03010"));
        }
    }

    /* renamed from: i */
    public void m69593i() {
        if (!C10028c.m62182c0().m62395t1("funcfg_blocked_down")) {
            C11839m.m70689w("CloudDisk", "server refused download Blocked");
            return;
        }
        if (m69585a(this.f54062a)) {
            C11839m.m70688i("CloudDisk", "enter doRestorePhoneManager");
            return;
        }
        if (!C14163d.m84990g().m85009o()) {
            this.f54063b.m18035b(new C11442e(55000205, new C10800n()), "restorephonemanager");
        } else {
            C11839m.m70689w("CloudDisk", "onIncrementDataMigration Blocked cannot download Blocked");
            C10812z.m65845n(this.f54062a, "phonemanager", -11, "", "onIncrementDataMigration", "03010", "local_download", C10812z.m65832a("03010"));
        }
    }

    /* renamed from: j */
    public void m69594j() {
        if (!C10028c.m62182c0().m62395t1("funcfg_recordings_down")) {
            C11839m.m70689w("CloudDisk", "server refused download Recording");
            return;
        }
        if (m69585a(this.f54062a)) {
            C11839m.m70688i("CloudDisk", "enter doRestoreRecording");
            return;
        }
        if (!C14163d.m84990g().m85009o()) {
            this.f54063b.m18035b(new C11442e(55000204, new C10800n()), "restorerecording");
        } else {
            C11839m.m70689w("CloudDisk", "onIncrementDataMigration Recording cannot download Recording");
            C10812z.m65845n(this.f54062a, "recording", -11, "", "onIncrementDataMigration", "03010", "local_download", C10812z.m65832a("03010"));
        }
    }

    /* renamed from: k */
    public void m69595k() {
        if (!C10028c.m62182c0().m62395t1("funcfg_messaging_down")) {
            C11839m.m70689w("CloudDisk", "server refused download Sms");
            return;
        }
        if (m69585a(this.f54062a)) {
            C11839m.m70688i("CloudDisk", "enter doRestoreSms");
            return;
        }
        if (!C14163d.m84990g().m85009o()) {
            this.f54063b.m18035b(new C11442e(55000201, new C10800n()), "restoresms");
        } else {
            C11839m.m70689w("CloudDisk", "onIncrementDataMigration Sms cannot download Sms");
            C10812z.m65845n(this.f54062a, NavigationUtils.SMS_SCHEMA_PREF, -11, "", "onIncrementDataMigration", "03010", "local_download", C10812z.m65832a("03010"));
        }
    }

    /* renamed from: m */
    public final boolean m69596m(String str) {
        if (CloudSyncUtil.m15965N() != 1) {
            return false;
        }
        String str2 = "callLog".equals(str) ? "Server Control Reset CallLog cannot upload" : NavigationUtils.SMS_SCHEMA_PREF.equals(str) ? "Server Control Reset Sms cannot upload" : "";
        C11839m.m70689w("CloudDisk", str2);
        C10812z.m65845n(this.f54062a, str, -13, "", str2, "03009", "local_upload", C10812z.m65832a("03009"));
        return true;
    }

    /* renamed from: n */
    public void m69597n(Messenger messenger, int i10) {
        this.f54063b.m18037e(messenger, i10);
    }

    /* renamed from: o */
    public void m69598o(String str, int i10, String str2, ModuleItem moduleItem) {
        C10800n c10800n = new C10800n();
        c10800n.m65743h("deviceId", str);
        c10800n.m65743h(JsbMapKeyNames.H5_DEVICE_TYPE, Integer.valueOf(i10));
        c10800n.m65743h("moduleName", str2);
        m69584q(str2, moduleItem, c10800n);
        this.f54063b.m18035b(new C11442e(55000003, c10800n), "removebackup");
    }

    /* renamed from: r */
    public void m69599r(Messenger messenger) {
        this.f54063b.m18038f(messenger);
    }
}
