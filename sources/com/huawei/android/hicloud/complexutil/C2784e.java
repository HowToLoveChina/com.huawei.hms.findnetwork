package com.huawei.android.hicloud.complexutil;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.hicloud.bean.BasicModuleConfigV3Rsp;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import gp.C10028c;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0209d;
import p020ap.C1006a;
import p336he.C10155f;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.complexutil.e */
/* loaded from: classes3.dex */
public class C2784e {
    /* renamed from: a */
    public final boolean m16194a(Context context, String str) {
        String str2;
        if (context == null) {
            return false;
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        if (HNConstants.DataType.MEDIA.equals(str)) {
            str2 = "cloudphoto_toogle";
        } else if ("cloudbackup".equals(str)) {
            str2 = "cloudbackup_toogle";
        } else {
            str2 = str + "_toogle";
        }
        return c10028cM62183d0.m62395t1(str2);
    }

    /* renamed from: b */
    public boolean m16195b(Context context, String str, boolean z10) {
        return !m16197d(context) ? z10 : m16194a(context, str);
    }

    /* renamed from: c */
    public void m16196c(Context context, String str, UnionSwitch unionSwitch, boolean z10) {
        if (m16197d(context)) {
            z10 = m16194a(context, str);
        }
        unionSwitch.setCheckedProgrammatically(z10);
    }

    /* renamed from: d */
    public boolean m16197d(Context context) {
        if (context != null) {
            return C10028c.m62183d0(context).m62395t1("toggle_default");
        }
        return false;
    }

    /* renamed from: e */
    public void m16198e(BasicModuleConfigV3Rsp basicModuleConfigV3Rsp, C10028c c10028c) {
        if (basicModuleConfigV3Rsp == null || c10028c == null) {
            C11839m.m70687e("SwitchDefaultHelper", "saveToggleDefaultSpV3 mConfig == null|| moduleSetting == null");
            return;
        }
        c10028c.m62377p3("toggle_default", basicModuleConfigV3Rsp.isGetToggleFromServer());
        c10028c.m62377p3("wlan_toogle", basicModuleConfigV3Rsp.isWlanDefaultToggle());
        c10028c.m62377p3("cloudbackup_toogle", basicModuleConfigV3Rsp.isCloudBackupDefaultToggle());
        c10028c.m62377p3("addressbook_toogle", basicModuleConfigV3Rsp.isAddressBookDefaultToggle());
        c10028c.m62377p3("cloudphoto_toogle", basicModuleConfigV3Rsp.isCloudPhotoDefaultToggle());
        c10028c.m62377p3("calendar_toogle", basicModuleConfigV3Rsp.isCalendarDefaultToggle());
        c10028c.m62377p3("notepad_toogle", basicModuleConfigV3Rsp.isNotepadDefaultToggle());
        c10028c.m62377p3("browser_toogle", basicModuleConfigV3Rsp.isBrowserDefaultToggle());
        m16199f(basicModuleConfigV3Rsp, c10028c);
    }

    /* renamed from: f */
    public void m16199f(BasicModuleConfigV3Rsp basicModuleConfigV3Rsp, C10028c c10028c) {
        if (basicModuleConfigV3Rsp == null || c10028c == null) {
            C11839m.m70687e("SwitchDefaultHelper", "saveToggleDefaultSpV3 configV3Rsp == null|| mSetting == null");
            return;
        }
        HashMap<String, Boolean> syncDynamicToggleFieldMap = basicModuleConfigV3Rsp.getSyncDynamicToggleFieldMap();
        if (syncDynamicToggleFieldMap == null || syncDynamicToggleFieldMap.isEmpty()) {
            C11839m.m70688i("SwitchDefaultHelper", "Dynamic toggle default empty");
            return;
        }
        for (Map.Entry<String, Boolean> entry : syncDynamicToggleFieldMap.entrySet()) {
            c10028c.m62377p3(entry.getKey(), entry.getValue().booleanValue());
        }
    }

    /* renamed from: g */
    public void m16200g(Context context) {
        C11839m.m70688i("SwitchDefaultHelper", "setAllSwitchDefaultValueExceptBackup");
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        if (c10028cM62183d0.m62395t1("funcfg_contacts")) {
            c10028cM62183d0.m62336h2("addressbook", m16195b(context, "addressbook", true));
        }
        if (c10028cM62183d0.m62395t1("funcfg_calendar")) {
            c10028cM62183d0.m62336h2("calendar", m16195b(context, "calendar", false));
        }
        if (c10028cM62183d0.m62395t1("funcfg_wlan")) {
            c10028cM62183d0.m62336h2("wlan", C0209d.m1166E1() ? m16195b(context, "wlan", false) : false);
        }
        if (C10155f.m63285i(context) && c10028cM62183d0.m62395t1("funcfg_browser")) {
            c10028cM62183d0.m62336h2("browser", m16195b(context, "browser", false));
        }
        if (c10028cM62183d0.m62395t1("funcfg_notes")) {
            c10028cM62183d0.m62336h2("notepad", m16195b(context, "notepad", false));
        }
        for (SyncConfigService syncConfigService : NotifyUtil.getShownSyncServiceItems(context)) {
            if (syncConfigService != null) {
                String id2 = syncConfigService.getId();
                if (TextUtils.isEmpty(id2)) {
                    C11839m.m70687e("SwitchDefaultHelper", "service id is null or empty ");
                } else {
                    if (c10028cM62183d0.m62395t1("funcfg_" + id2)) {
                        c10028cM62183d0.m62336h2(id2, m16195b(context, id2, false));
                    }
                }
            }
        }
        m16202i(c10028cM62183d0, context);
    }

    /* renamed from: h */
    public void m16201h(Context context) {
        CloudBackupService.getInstance().cloudbackupOpr(C0209d.m1166E1() ? m16195b(context, "cloudbackup", true) : false);
    }

    /* renamed from: i */
    public final void m16202i(C10028c c10028c, Context context) {
        for (DriveConfigService driveConfigService : NotifyUtil.getShownDriveServiceItems(context)) {
            if (driveConfigService != null) {
                String id2 = driveConfigService.getId();
                if (TextUtils.isEmpty(id2)) {
                    C11839m.m70687e("SwitchDefaultHelper", "driveConfigServiceId id is null or empty ");
                } else {
                    if (c10028c.m62395t1("funcfg_" + id2)) {
                        c10028c.m62336h2(id2, m16195b(context, id2, false));
                    }
                }
            }
        }
    }

    /* renamed from: j */
    public void m16203j(Context context) {
        boolean zM16195b = C0209d.m1166E1() ? m16195b(context, HNConstants.DataType.MEDIA, false) : false;
        C1006a.m5936k().m5951O(zM16195b, context);
        C10028c.m62183d0(context).m62377p3("uploadphotokey", zM16195b);
    }

    /* renamed from: k */
    public void m16204k(Context context, String str) {
        if (context == null) {
            return;
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        if ("addressbook".equals(str)) {
            c10028cM62183d0.m62336h2("addressbook", m16195b(context, "addressbook", true));
            return;
        }
        if ("calendar".equals(str)) {
            c10028cM62183d0.m62336h2("calendar", m16195b(context, "calendar", false));
            return;
        }
        if ("notepad".equals(str)) {
            c10028cM62183d0.m62336h2("notepad", m16195b(context, "notepad", false));
            return;
        }
        if ("wlan".equals(str)) {
            c10028cM62183d0.m62336h2("wlan", C0209d.m1166E1() ? m16195b(context, "wlan", false) : false);
            return;
        }
        if ("browser".equals(str)) {
            if (C10155f.m63285i(context)) {
                c10028cM62183d0.m62336h2("browser", m16195b(context, "browser", false));
            }
        } else if (HNConstants.DataType.MEDIA.equals(str)) {
            m16203j(context);
        } else {
            c10028cM62183d0.m62336h2(str, m16195b(context, str, false));
        }
    }
}
