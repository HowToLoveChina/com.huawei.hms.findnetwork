package p335hd;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0214f0;
import p399jk.AbstractC10896a;
import p514o9.C11829c;
import p581qk.AbstractC12367d;
import p709vj.C13452e;

/* renamed from: hd.k */
/* loaded from: classes3.dex */
public class C10148k extends AbstractC12367d {

    /* renamed from: a */
    public Context f49449a;

    /* renamed from: b */
    public String f49450b;

    public C10148k(Context context, String str) {
        this.f49449a = context;
        this.f49450b = str;
    }

    /* renamed from: c */
    public final boolean m63209c(C10028c c10028c, boolean z10) {
        ArrayList<DriveConfigService> shownDriveServiceItems = NotifyUtil.getShownDriveServiceItems(this.f49449a);
        if (shownDriveServiceItems.size() > 0) {
            Iterator<DriveConfigService> it = shownDriveServiceItems.iterator();
            while (it.hasNext()) {
                DriveConfigService next = it.next();
                if (next != null) {
                    String id2 = next.getId();
                    if (!TextUtils.isEmpty(id2)) {
                        boolean zM62388s = c10028c.m62388s(id2);
                        AbstractC10896a.m65887i("SettingsCheckTask", "isDriveLoginAndSettingSuccess moduleName: " + id2 + " switchState: " + zM62388s);
                        if (z10) {
                            if (C0209d.m1151A2(this.f49449a, "hicloud_sync_" + id2, zM62388s)) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
            }
        }
        return z10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        AbstractC10896a.m65887i("SettingsCheckTask", "SettingsCheckTask call: " + this.f49450b);
        if ("refresh".equals(this.f49450b)) {
            m63210d();
            return;
        }
        boolean zM1355e = C0212e0.m1355e(this.f49449a, "hicloud_settings_status", "settings_success", false);
        long jM1360j = C0212e0.m1360j(this.f49449a, "hicloud_settings_status", "last_config_time", 0L);
        if (!zM1355e) {
            m63210d();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jM1360j;
        AbstractC10896a.m65887i("SettingsCheckTask", "SettingsCheckTask overtime: " + jCurrentTimeMillis);
        if (jCurrentTimeMillis > 21600000) {
            m63210d();
        }
    }

    /* renamed from: d */
    public final void m63210d() {
        boolean zM70621u1;
        C0212e0.m1366p(this.f49449a, "hicloud_settings_status", "settings_success", false);
        C0212e0.m1371u(this.f49449a, "hicloud_settings_status", "last_config_time", 0L);
        boolean zM80850R0 = C13452e.m80781L().m80850R0();
        AbstractC10896a.m65887i("SettingsCheckTask", "resetSettings login: " + zM80850R0);
        if (zM80850R0) {
            boolean zM1334z2 = C0209d.m1334z2(this.f49449a, "hicloud_login", 1);
            boolean z10 = C0214f0.m1382b(this.f49449a, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("SwitchHelperUtilisCloudAlbumOn", false);
            AbstractC10896a.m65887i("SettingsCheckTask", "resetSettings albumOn: " + z10);
            boolean zM1151A2 = zM1334z2 & C0209d.m1151A2(this.f49449a, "hicloud_cloudPhoto", z10);
            C10028c c10028cM62183d0 = C10028c.m62183d0(this.f49449a);
            boolean zM62388s = c10028cM62183d0.m62388s("backup_key");
            AbstractC10896a.m65887i("SettingsCheckTask", "resetSettings backupOn: " + zM62388s);
            boolean zM1151A22 = zM1151A2 & C0209d.m1151A2(this.f49449a, NotifyConstants.HICLOUD_BACKUP, zM62388s);
            boolean zM62388s2 = c10028cM62183d0.m62388s("addressbook");
            AbstractC10896a.m65887i("SettingsCheckTask", "resetSettings contactStatus: " + zM62388s2);
            boolean zM1151A23 = zM1151A22 & C0209d.m1151A2(this.f49449a, "hicloud_sync_addressbook", zM62388s2);
            boolean zM62388s3 = c10028cM62183d0.m62388s("notepad");
            AbstractC10896a.m65887i("SettingsCheckTask", "resetSettings notepadStatus: " + zM62388s3);
            boolean zM1151A24 = zM1151A23 & C0209d.m1151A2(this.f49449a, "hicloud_sync_notepad", zM62388s3);
            boolean zM62388s4 = c10028cM62183d0.m62388s("calendar");
            AbstractC10896a.m65887i("SettingsCheckTask", "resetSettings calendarStatus: " + zM62388s4);
            boolean zM1151A25 = zM1151A24 & C0209d.m1151A2(this.f49449a, "hicloud_sync_calendar", zM62388s4);
            boolean zM62388s5 = c10028cM62183d0.m62388s("browser");
            AbstractC10896a.m65887i("SettingsCheckTask", "resetSettings browserStatus: " + zM62388s5);
            boolean zM1151A26 = zM1151A25 & C0209d.m1151A2(this.f49449a, "hicloud_sync_browser", zM62388s5);
            boolean zM62388s6 = c10028cM62183d0.m62388s("wlan");
            AbstractC10896a.m65887i("SettingsCheckTask", "resetSettings wlanStatus: " + zM62388s6);
            boolean zM1151A27 = zM1151A26 & C0209d.m1151A2(this.f49449a, "hicloud_sync_wlan", zM62388s6);
            ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(this.f49449a);
            if (shownSyncServiceItems.size() > 0) {
                Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
                while (it.hasNext()) {
                    SyncConfigService next = it.next();
                    if (next != null) {
                        String id2 = next.getId();
                        if (!TextUtils.isEmpty(id2)) {
                            boolean zM62388s7 = c10028cM62183d0.m62388s(id2);
                            AbstractC10896a.m65887i("SettingsCheckTask", "resetSettings moduleName: " + id2 + " switchState: " + zM62388s7);
                            Context context = this.f49449a;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("hicloud_sync_");
                            sb2.append(id2);
                            zM1151A27 &= C0209d.m1151A2(context, sb2.toString(), zM62388s7);
                        }
                    }
                }
            }
            zM70621u1 = m63209c(c10028cM62183d0, zM1151A27);
        } else {
            zM70621u1 = C11829c.m70621u1(this.f49449a);
        }
        if (!zM70621u1) {
            AbstractC10896a.m65886e("SettingsCheckTask", "resetSettings set fail");
        } else {
            C0212e0.m1366p(this.f49449a, "hicloud_settings_status", "settings_success", true);
            C0212e0.m1371u(this.f49449a, "hicloud_settings_status", "last_config_time", System.currentTimeMillis());
        }
    }
}
