package com.huawei.hicloud.notification.util;

import android.content.Context;
import com.huawei.hicloud.bean.BaseModuleConfig;
import com.huawei.hicloud.bean.BasicModuleConfigV3Rsp;
import com.huawei.hicloud.bean.CMModuleConfig;
import com.huawei.hicloud.bean.CTModuleConfig;
import com.huawei.hicloud.bean.GeneralModuleConfig;
import com.huawei.hicloud.bean.LocalModuleConfig;
import gp.C10028c;

/* loaded from: classes6.dex */
public class ModuleConfigUtil {

    /* renamed from: CM */
    private static final String f22681CM = "cm";

    /* renamed from: CT */
    private static final String f22682CT = "ct";
    private static final String GENERAL = "general";
    private static final ModuleConfigUtil INSTANCE = new ModuleConfigUtil();
    private static final String LOCAL = "local";
    private static final String TAG = "ModuleConfigUtil";
    private String versionType = GENERAL;
    private GeneralModuleConfig generalModuleConfig = new GeneralModuleConfig();
    private CTModuleConfig ctModuleConfig = new CTModuleConfig();
    private CMModuleConfig cmModuleConfig = new CMModuleConfig();
    private LocalModuleConfig localModuleConfig = new LocalModuleConfig();

    private ModuleConfigUtil() {
    }

    public static ModuleConfigUtil getInstance() {
        return INSTANCE;
    }

    private BaseModuleConfig getModuleConfig() {
        return GENERAL.equals(this.versionType) ? this.generalModuleConfig : f22682CT.equals(this.versionType) ? this.ctModuleConfig : f22681CM.equals(this.versionType) ? this.cmModuleConfig : LOCAL.equals(this.versionType) ? this.localModuleConfig : this.generalModuleConfig;
    }

    public static boolean isAllModuleDisabled(Context context) {
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        return isModulesDisable(c10028cM62183d0) && !c10028cM62183d0.m62291X0();
    }

    public static boolean isModuleAllDisabledInLocalConfig(BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) {
        return (basicModuleConfigV3Rsp == null || basicModuleConfigV3Rsp.isContactEnable() || basicModuleConfigV3Rsp.isBackupEnable() || basicModuleConfigV3Rsp.isWlanEnable() || basicModuleConfigV3Rsp.isCalendarEnable() || basicModuleConfigV3Rsp.isNotesEnable() || basicModuleConfigV3Rsp.isGalleryEnable()) ? false : true;
    }

    private static boolean isModulesDisable(C10028c c10028c) {
        return (c10028c.m62395t1("funcfg_cloud_backup") || c10028c.m62395t1("funcfg_huawei_drive") || c10028c.m62395t1("funcfg_find_my_phone_globe") || c10028c.m62395t1("funcfg_gallery") || c10028c.m62395t1("funcfg_contacts") || c10028c.m62395t1("funcfg_calendar") || c10028c.m62395t1("funcfg_notes") || c10028c.m62395t1("funcfg_wlan") || c10028c.m62395t1("funcfg_messaging_up") || c10028c.m62395t1("funcfg_browser") || c10028c.m62395t1("funcfg_call_log_up") || c10028c.m62395t1("funcfg_recordings_up") || c10028c.m62395t1("funcfg_blocked_up")) ? false : true;
    }

    public boolean isAlbumEnable() {
        return getModuleConfig().isAlbumEnable();
    }

    public boolean isAllModuleDisabledIncludePhonefinder(Context context) {
        if (C10028c.m62183d0(context).m62395t1("is_already_configed_NV4")) {
            return isAllModuleNotShow(context);
        }
        return true;
    }

    public boolean isAllModuleNotShow(Context context) {
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        boolean zIsModulesDisable = isModulesDisable(c10028cM62183d0);
        boolean zM62291X0 = c10028cM62183d0.m62291X0();
        if (zIsModulesDisable) {
            return !zM62291X0 || NotifyUtil.getShownSyncServiceItems(context).size() <= 0;
        }
        return false;
    }

    public boolean isBackupEnable() {
        return getModuleConfig().isBackupEnable();
    }

    public boolean isCMVersion() {
        return f22681CM.equals(this.versionType);
    }

    public boolean isCTVersion() {
        return f22682CT.equals(this.versionType);
    }

    public boolean isDbankEnable() {
        return getModuleConfig().isDbankEnable();
    }

    public boolean isGeneralVersion() {
        return GENERAL.equals(this.versionType);
    }

    public boolean isLocalVersion() {
        return LOCAL.equals(this.versionType);
    }

    public boolean isPhoneFinderEnable() {
        return getModuleConfig().isPhoneFinderEnable();
    }

    public boolean isSyncEnable() {
        return getModuleConfig().isSyncEnable();
    }
}
