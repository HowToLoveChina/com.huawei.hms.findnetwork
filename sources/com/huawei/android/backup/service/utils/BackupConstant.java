package com.huawei.android.backup.service.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.calendar.BackupCalendarImp;
import com.huawei.android.backup.service.logic.installedapps.C2148f;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import com.huawei.hms.android.SystemUtils;
import com.huawei.openalliance.p169ad.constant.AiCoreSdkConstant;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p006a5.C0049d;
import p006a5.C0050e;
import p006a5.C0051f;
import p047c5.C1386a;
import p048c6.C1388b;
import p229di.C9142g;
import p309g5.C9886c;
import p327h5.C10099b;
import p358i5.C10443b;
import p418k5.C10988a;
import p418k5.C10989b;
import p444l5.C11236d;
import p485n5.C11634a;
import p510o5.C11818a;
import p545p5.C12087a;
import p567q5.C12287a;
import p602r5.C12465a;
import p633s5.C12704a;
import p633s5.C12705b;
import p633s5.C12708e;
import p633s5.C12709f;
import p633s5.C12710g;
import p633s5.C12711h;
import p633s5.C12712i;
import p633s5.C12713j;
import p633s5.C12714k;
import p633s5.C12715l;
import p633s5.C12716m;
import p648t5.C12938a;
import p669u5.C13124b;
import p699v4.C13342k;
import p700v5.C13352b;
import p728w4.C13529c;
import p729w5.C13531a;
import p799y5.C13910a;
import p833z5.C14132b;

/* loaded from: classes.dex */
public class BackupConstant {

    /* renamed from: A */
    public static final HashMap<String, String> f9712A;

    /* renamed from: B */
    public static final List<String> f9713B;

    /* renamed from: C */
    public static final ConcurrentHashMap<String, String> f9714C;

    /* renamed from: D */
    public static final HashMap<String, String> f9715D;

    /* renamed from: E */
    public static final HashMap<String, String> f9716E;

    /* renamed from: F */
    public static final Map<String, Boolean> f9717F;

    /* renamed from: G */
    public static final HashMap<String, String> f9718G;

    /* renamed from: H */
    public static final Set<String> f9719H;

    /* renamed from: I */
    public static final Set<String> f9720I;

    /* renamed from: J */
    public static final Set<String> f9721J;

    /* renamed from: K */
    public static final Map<Integer, Integer> f9722K;

    /* renamed from: L */
    public static final Map<String, Bundle> f9723L;

    /* renamed from: M */
    public static final Map<String, Bundle> f9724M;

    /* renamed from: N */
    public static final Set<String> f9725N;

    /* renamed from: O */
    public static final Set<String> f9726O;

    /* renamed from: P */
    public static final Set<String> f9727P;

    /* renamed from: Q */
    public static final ArrayList<String> f9728Q;

    /* renamed from: R */
    public static final ArrayList<String> f9729R;

    /* renamed from: S */
    public static final ArrayList<String> f9730S;

    /* renamed from: T */
    public static final Map<String, String[]> f9731T;

    /* renamed from: U */
    public static final Map<String, String> f9732U;

    /* renamed from: V */
    public static final Set<String> f9733V;

    /* renamed from: a */
    public static final HashSet<String> f9734a = new HashSet<>(100);

    /* renamed from: b */
    public static final HashSet<String> f9735b = new HashSet<>(4);

    /* renamed from: c */
    public static final Set<String> f9736c = new HashSet(20);

    /* renamed from: d */
    public static volatile boolean f9737d = false;

    /* renamed from: e */
    public static final String[] f9738e;

    /* renamed from: f */
    public static final String[] f9739f;

    /* renamed from: g */
    public static final String[] f9740g;

    /* renamed from: h */
    public static final String[] f9741h;

    /* renamed from: i */
    public static final String[] f9742i;

    /* renamed from: j */
    public static final String[] f9743j;

    /* renamed from: k */
    public static final String[] f9744k;

    /* renamed from: l */
    public static final String[] f9745l;

    /* renamed from: m */
    public static final String[] f9746m;

    /* renamed from: n */
    public static final String[] f9747n;

    /* renamed from: o */
    public static final String[] f9748o;

    /* renamed from: p */
    public static final String[] f9749p;

    /* renamed from: q */
    public static final String[] f9750q;

    /* renamed from: r */
    public static final String[] f9751r;

    /* renamed from: s */
    public static final String[] f9752s;

    /* renamed from: t */
    public static final String[] f9753t;

    /* renamed from: u */
    public static final String[] f9754u;

    /* renamed from: v */
    public static final String[] f9755v;

    /* renamed from: w */
    public static final String[] f9756w;

    /* renamed from: x */
    public static final String[] f9757x;

    /* renamed from: y */
    public static final String[] f9758y;

    /* renamed from: z */
    public static final HashMap<String, String[]> f9759z;

    /* renamed from: com.huawei.android.backup.service.utils.BackupConstant$1 */
    public class C21561 extends ArrayList<String> {
        public C21561() {
            add("soundrecorder");
            add("callRecorder");
            add("chatSms");
            add("smartcare");
        }
    }

    public static class BackupObject {
        static {
            BackupConstant.f9734a.add(HNConstants.DataType.CONTACT);
            BackupConstant.f9734a.add("contact_net");
            BackupConstant.f9734a.add("system setting");
            BackupConstant.f9734a.add("calllog");
            BackupConstant.f9734a.add(NavigationUtils.SMS_SCHEMA_PREF);
            BackupConstant.f9734a.add("chatSms");
            BackupConstant.f9734a.add("alarm");
            BackupConstant.f9734a.add("bookmark");
            BackupConstant.f9734a.add("calendar");
            BackupConstant.f9734a.add("notepad");
            BackupConstant.f9734a.add("Memo");
            BackupConstant.f9734a.add("weather");
            BackupConstant.f9734a.add("smartcare");
            BackupConstant.f9734a.add("harassment");
            BackupConstant.f9734a.add("phoneManager");
            BackupConstant.f9734a.add("HWlanucher");
            BackupConstant.f9734a.add("soundrecorder");
            BackupConstant.f9734a.add("camera");
            BackupConstant.f9734a.add("fmradio");
            BackupConstant.f9734a.add("systemUI");
            BackupConstant.f9734a.add("baiduInput");
            BackupConstant.f9734a.add("callRecorder");
            BackupConstant.f9734a.add("sns");
            BackupConstant.f9734a.add("wallpaper");
            BackupConstant.f9734a.add("phoneservice");
            BackupConstant.f9734a.add("setting");
            BackupConstant.f9734a.add("clock");
            BackupConstant.f9734a.add("parentcontrol");
            BackupConstant.f9734a.add("gallerySettting");
            BackupConstant.f9734a.add("vdriver");
            BackupConstant.f9734a.add("smsSetting");
            BackupConstant.f9734a.add("calendarSetting");
            BackupConstant.f9734a.add("hwKeyChain");
            BackupConstant.f9734a.add("HuaweiHiAi");
            BackupConstant.f9734a.add("smartSuggestion");
            BackupConstant.f9734a.add("HiAIDecision");
            BackupConstant.f9734a.add("email");
            BackupConstant.f9734a.add("dataManagementServices");
            BackupConstant.f9734a.add("desktopMyFile");
            BackupConstant.f9734a.add("desktopSystemUI");
            BackupConstant.f9734a.add("galleryData");
            BackupConstant.f9734a.add("huaweiBrowser");
            BackupConstant.f9734a.add("motionService");
            BackupConstant.f9734a.add("remoteController");
            BackupConstant.f9734a.add("hiVoice");
            BackupConstant.f9734a.add("screenManager");
            BackupConstant.f9734a.add("HiCreate");
            BackupConstant.f9735b.add(Constants.VIDEO_SUB_DIR);
            BackupConstant.f9735b.add("photo");
            BackupConstant.f9735b.add("audio");
            BackupConstant.f9735b.add("doc");
            BackupConstant.f9736c.add(ClickDestination.APPMARKET);
            BackupConstant.f9736c.add("contact_pim");
            BackupConstant.f9736c.add("contact_private");
            BackupConstant.f9736c.add("contact_online");
            BackupConstant.f9736c.add("contact_location");
            BackupConstant.f9736c.add("calendar_online");
            BackupConstant.f9736c.add("calendar_location");
            BackupConstant.f9736c.add("HWnotepad");
            BackupConstant.f9736c.add("richpad");
            BackupConstant.f9736c.add("musicPlayList");
            BackupConstant.f9736c.add("system setting");
            BackupConstant.f9736c.add("contact_sim1");
            BackupConstant.f9736c.add("contact_sim2");
            BackupConstant.f9736c.add("home");
            BackupConstant.f9736c.add("calllog_private");
        }

        public static HashSet<String> getBackupSystemObject() {
            return BackupConstant.f9734a;
        }

        public static Set<String> getBlocklistBackupObject() {
            return BackupConstant.f9736c;
        }
    }

    public static class KoBackupIntent {
        public static final String CONTACT_RESTORE_FINISHED_ACTION;
        public static final String RECEIVER_PERMISSION;
        public static final String RESTORE_BEGIN;
        public static final String RESTORE_COMPLETE;

        static {
            RESTORE_COMPLETE = C9142g.m57463b() ? "com.hihonor.KoBackup.intent.action.RESTORE_COMPLETE" : "com.huawei.KoBackup.intent.action.RESTORE_COMPLETE";
            RESTORE_BEGIN = C9142g.m57463b() ? "com.hihonor.KoBackup.intent.action.RESTORE_BEGIN" : "com.huawei.KoBackup.intent.action.RESTORE_BEGIN";
            CONTACT_RESTORE_FINISHED_ACTION = C9142g.m57463b() ? "com.hihonor.hicloud.CONTACT_RESTORE_FINISHED" : "com.huawei.hicloud.CONTACT_RESTORE_FINISHED";
            RECEIVER_PERMISSION = C9142g.m57463b() ? "com.hihonor.hicloud.permission.CONTACT_RESTORE_FINISHED" : "com.huawei.hicloud.permission.CONTACT_RESTORE_FINISHED";
        }
    }

    public static class LocalPhoneInfo {
        public static final boolean IS_I_VERSION;
        public static final boolean IS_S7;
        public static final String VERSION_RELEASE;
        public static final int VERSION_SDK;
        public static final String PRODUCT_MODEL = C13529c.m81423a("ro.product.model");
        public static final String PRODUCT_BRAND = C13529c.m81423a(SystemUtils.PRODUCT_BRAND);
        public static final String PRODUCT_MANUFACTURER = C13529c.m81423a("ro.product.manufacturer");
        public static final String BORAD_PLATFORM = C13529c.m81423a("ro.board.platform");

        static {
            int iM80055d = C13342k.m80055d(C13529c.m81423a("ro.build.version.sdk"));
            VERSION_SDK = iM80055d;
            VERSION_RELEASE = C13529c.m81423a("ro.build.version.release");
            IS_I_VERSION = iM80055d >= 14;
            IS_S7 = BackupConstant.m13150x();
        }
    }

    public static class VersionInfo {

        /* renamed from: b */
        public static VersionInfo f9760b;

        /* renamed from: a */
        public int f9761a;

        public VersionInfo(Context context) {
            try {
                this.f9761a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                C2111d.m12648d("BackupConstant", "VersionInfo error.");
            }
        }

        public static synchronized VersionInfo getInstance(Context context) {
            try {
                if (f9760b == null) {
                    f9760b = new VersionInfo(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
            return f9760b;
        }

        public int getVersionCode() {
            return this.f9761a;
        }
    }

    static {
        String[] strArr = {"com.huawei.contacts", "com.hihonor.contacts", "com.meizu.mzsimcontacts"};
        f9738e = strArr;
        String[] strArr2 = {NextRestoreConstants.PKG_NAME_GALLERY_DATA, "com.hihonor.photos", NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D};
        f9739f = strArr2;
        String[] strArr3 = {NextRestoreConstants.PKG_NAME_CALENDAR, "com.hihonor.calendar"};
        f9740g = strArr3;
        String[] strArr4 = {NextRestoreConstants.PKG_NAME_MEMO, "com.hihonor.notepad"};
        f9741h = strArr4;
        String[] strArr5 = {NextRestoreConstants.PKG_NAME_CALL_RECORDER, "com.hihonor.phone.recorder"};
        f9742i = strArr5;
        String[] strArr6 = {"com.huawei.deskclock", "com.hihonor.deskclock"};
        f9743j = strArr6;
        String[] strArr7 = {NextRestoreConstants.PKG_NAME_SOUND_RECORDER, "com.hihonor.soundrecorder"};
        f9744k = strArr7;
        String[] strArr8 = {FeedbackConst.Mail.EMUI10_EMAIL_PKG_NAME, "com.hihonor.email"};
        f9745l = strArr8;
        String[] strArr9 = {"com.hihonor.mms"};
        f9746m = strArr9;
        String[] strArr10 = {"com.hihonor.android.launcher"};
        f9747n = strArr10;
        String[] strArr11 = {"com.hihonor.android.totemweather"};
        f9748o = strArr11;
        String[] strArr12 = {"com.hihonor.systemmanager"};
        f9749p = strArr12;
        String[] strArr13 = {"com.hihonor.FMRadio"};
        f9750q = strArr13;
        String[] strArr14 = {"com.baidu.input_hihonor"};
        f9751r = strArr14;
        String[] strArr15 = {"com.hihonor.android.thememanager"};
        f9752s = strArr15;
        String[] strArr16 = {"com.hihonor.phoneservice"};
        f9753t = strArr16;
        String[] strArr17 = {"com.hihonor.parentcontrol"};
        f9754u = strArr17;
        String[] strArr18 = {"com.hihonor.browser"};
        f9755v = strArr18;
        String[] strArr19 = {"com.hihonor.vassistant"};
        f9756w = strArr19;
        String[] strArr20 = {"com.huawei.hiai", "com.hihonor.hiai"};
        f9757x = strArr20;
        String[] strArr21 = {"com.huawei.hicreate"};
        f9758y = strArr21;
        HashMap<String, String[]> map = new HashMap<>(24);
        f9759z = map;
        map.put("galleryData", strArr2);
        map.put("gallerySettting", strArr2);
        map.put("calllog", strArr);
        map.put("calendarSetting", strArr3);
        map.put("notepad", strArr4);
        map.put("Memo", strArr4);
        map.put("callRecorder", strArr5);
        map.put("alarm", strArr6);
        map.put("clock", strArr6);
        map.put("soundrecorder", strArr7);
        map.put("email", strArr8);
        map.put("chatSms", strArr9);
        map.put("HWlanucher", strArr10);
        map.put("weather", strArr11);
        map.put("phoneManager", strArr12);
        map.put("harassment", strArr12);
        map.put("fmradio", strArr13);
        map.put("baiduInput", strArr14);
        map.put("wallpaper", strArr15);
        map.put("phoneservice", strArr16);
        map.put("smsSetting", strArr9);
        map.put("parentcontrol", strArr17);
        map.put("huaweiBrowser", strArr18);
        map.put("hiVoice", strArr19);
        map.put("HuaweiHiAi", strArr20);
        map.put("HiCreate", strArr21);
        HashMap<String, String> map2 = new HashMap<>(40);
        f9712A = map2;
        map2.put(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, C9142g.m57463b() ? "content://com.huawei.hidisk.backupProvider" : "content://com.hihonor.hidisk.backupProvider");
        map2.put("camera", C9142g.m57463b() ? "content://com.hihonor.camera.backupprovider" : "content://com.huawei.camera.backupprovider");
        map2.put("soundrecorder", C9142g.m57463b() ? "content://com.hihonor.soundrecorder.backupProvider" : "content://com.huawei.soundrecorder.backupProvider");
        map2.put("baiduInput", C9142g.m57463b() ? "content://com.baidu.input_hihonor.hwbackup" : "content://com.baidu.input_huawei.hwbackup");
        map2.put("callRecorder", "content://com.android.phone.autorecordbackup");
        map2.put("fmradio", C9142g.m57463b() ? "content://com.hihonor.andorid.FMRadio.backup" : "content://com.huawei.andorid.FMRadio.backup");
        map2.put("systemUI", "content://com.android.systemui.backup.BackupRestore");
        map2.put("sns", C9142g.m57463b() ? "content://com.hihonor.android.sns.backup" : "content://com.huawei.android.sns.backup");
        map2.put("wallpaper", C9142g.m57463b() ? "content://com.hihonor.android.thememanager.WallpaperBackupProvider" : "content://com.huawei.android.thememanager.WallpaperBackupProvider");
        map2.put("phoneservice", C9142g.m57463b() ? "content://com.hihonor.phoneservice" : "content://com.huawei.phoneservice");
        map2.put("setting", C9142g.m57463b() ? "content://com.hihonor.android.backup.settings" : "content://com.huawei.android.backup.settings");
        map2.put("clock", "content://com.android.deskclock.backup");
        map2.put("smsSetting", "content://com.android.mms.backup");
        map2.put("parentcontrol", C9142g.m57463b() ? "content://com.hihonor.parentcontrol.backupprovider" : "content://com.huawei.parentcontrol.backupprovider");
        map2.put("gallerySettting", C9142g.m57463b() ? "content://com.hihonor.gallery.backup.GalleryBackupProvider" : "content://com.huawei.gallery.backup.GalleryBackupProvider");
        map2.put("vdriver", C9142g.m57463b() ? "content://com.hihonor.vdrive.provider" : "content://com.huawei.vdrive.provider");
        map2.put("HuaweiHiAi", C9142g.m57463b() ? "content://com.hihonor.hiai.awareness.clone" : "content://com.huawei.hiai.awareness.clone");
        map2.put("HiCreate", "content://com.huawei.hicreate.provider.clone");
        map2.put("smartcare", C9142g.m57463b() ? "content://com.hihonor.provider.intelligent" : "content://com.huawei.provider.intelligent");
        map2.put("chatSms", "content://com.android.rcs.backup");
        map2.put("calendarSetting", "content://com.android.calendar.backupprovider/shared_pref");
        map2.put("hwKeyChain", C9142g.m57463b() ? "content://com.hihonor.keychain.provider.HwKeychainContentProvider" : "content://com.huawei.keychain.provider.HwKeychainContentProvider");
        map2.put("smartSuggestion", C9142g.m57463b() ? "content://com.hihonor.pengine.DataCloneProvider/clone_files" : "content://com.huawei.pengine.DataCloneProvider/clone_files");
        map2.put("HiAIDecision", C9142g.m57463b() ? "content://com.hihonor.recsys.provider.RecSysProvider" : "content://com.huawei.recsys.provider.RecSysProvider");
        map2.put("email", C9142g.m57463b() ? "content://com.hihonor.email.cloneprovider" : "content://com.huawei.email.cloneprovider");
        map2.put("dataManagementServices", C9142g.m57463b() ? "content://com.hihonor.nb.provider.KvBackupProvider" : "content://com.huawei.nb.provider.KvBackupProvider");
        map2.put("desktopMyFile", C9142g.m57463b() ? "content://com.hihonor.desktop.explorer.CloneContentProvider" : "content://com.huawei.desktop.explorer.CloneContentProvider");
        map2.put("desktopSystemUI", C9142g.m57463b() ? "content://com.hihonor.desktop.systemui.CloneContentProvider" : "content://com.huawei.desktop.systemui.CloneContentProvider");
        map2.put("huaweiBrowser", C9142g.m57463b() ? "content://com.hihonor.browser.provider.BackupProvider" : "content://com.huawei.browser.provider.BackupProvider");
        map2.put("motionService", C9142g.m57463b() ? "content://com.hihonor.motionservice.provider.BackupProvider" : "content://com.huawei.motionservice.provider.BackupProvider");
        map2.put("remoteController", C9142g.m57463b() ? "content://com.hihonor.android.remotecontroller.data.RemoteControllerDb" : "content://com.huawei.android.remotecontroller.data.RemoteControllerDb");
        map2.put("galleryData", C9142g.m57463b() ? "content://com.hihonor.gallery.fullclone.provider.FullCloneDataProvider" : "content://com.huawei.gallery.fullclone.provider.FullCloneDataProvider");
        map2.put("hiVoice", C9142g.m57463b() ? "content://com.hihonor.ziri.provider.clone" : "content://com.huawei.ziri.provider.clone");
        map2.put("aod", C9142g.m57463b() ? "content://com.hihonor.aod.backup" : "content://com.huawei.aod.backup");
        map2.put("screenManager", C9142g.m57463b() ? "content://com.hihonor.homevision.screenmanager.backup.BackupProvider" : "content://com.huawei.homevision.screenmanager.backup.BackupProvider");
        f9713B = new ArrayList<String>() { // from class: com.huawei.android.backup.service.utils.BackupConstant.1
            public C21561() {
                add("soundrecorder");
                add("callRecorder");
                add("chatSms");
                add("smartcare");
            }
        };
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(60);
        f9714C = concurrentHashMap;
        concurrentHashMap.put(HNConstants.DataType.CONTACT, "com.android.providers.contacts");
        concurrentHashMap.put(NavigationUtils.SMS_SCHEMA_PREF, "com.android.providers.telephony");
        concurrentHashMap.put("chatSms", NextRestoreConstants.PKG_NAME_SMS);
        concurrentHashMap.put("calllog", "com.android.contacts");
        concurrentHashMap.put("alarm", "com.android.deskclock");
        concurrentHashMap.put("bookmark", "com.android.browser");
        concurrentHashMap.put("calendar", "com.android.providers.calendar");
        concurrentHashMap.put("notepad", "com.example.android.notepad");
        concurrentHashMap.put("Memo", "com.example.android.notepad");
        concurrentHashMap.put("HWlanucher", "com.huawei.android.launcher");
        concurrentHashMap.put("weather", "com.huawei.android.totemweather");
        concurrentHashMap.put("phoneManager", "com.huawei.systemmanager");
        concurrentHashMap.put("harassment", "com.huawei.systemmanager");
        concurrentHashMap.put("smartcare", Constants.HW_INTELLIEGNT_PACKAGE);
        concurrentHashMap.put("soundrecorder", "com.android.soundrecorder");
        concurrentHashMap.put("camera", "com.huawei.camera");
        concurrentHashMap.put("fmradio", "com.huawei.android.FMRadio");
        concurrentHashMap.put("systemUI", "com.android.systemui");
        concurrentHashMap.put("baiduInput", "com.baidu.input_huawei");
        concurrentHashMap.put("callRecorder", "com.android.phone.recorder");
        concurrentHashMap.put("sns", "com.huawei.hwid");
        concurrentHashMap.put("wallpaper", "com.huawei.android.thememanager");
        concurrentHashMap.put("phoneservice", ICBBroadcastManager.MYHUAWEI_PACKAGE);
        concurrentHashMap.put("setting", "com.android.settings");
        concurrentHashMap.put("clock", "com.android.deskclock");
        concurrentHashMap.put("smsSetting", NextRestoreConstants.PKG_NAME_SMS);
        concurrentHashMap.put("parentcontrol", Constants.PARENT_CONTROL_PACKAGE_NAME);
        concurrentHashMap.put("vdriver", "com.huawei.vdrive");
        concurrentHashMap.put("calendarSetting", "com.android.calendar");
        concurrentHashMap.put("hwKeyChain", "com.huawei.securitymgr");
        concurrentHashMap.put("smartSuggestion", "com.huawei.pengine");
        concurrentHashMap.put("HiAIDecision", AiCoreSdkConstant.DECISION_PKG_NAME);
        concurrentHashMap.put("email", FeedbackConst.Mail.ANDROID_EMAIL);
        concurrentHashMap.put("dataManagementServices", "com.huawei.nb.service");
        concurrentHashMap.put("desktopMyFile", "com.huawei.desktop.explorer");
        concurrentHashMap.put("desktopSystemUI", "com.huawei.desktop.systemui");
        concurrentHashMap.put("huaweiBrowser", Constants.HW_BROWSER_PACKAGE);
        concurrentHashMap.put("motionService", "com.huawei.motionservice");
        concurrentHashMap.put("remoteController", "com.huawei.android.remotecontroller");
        concurrentHashMap.put("hiVoice", "com.huawei.vassistant");
        concurrentHashMap.put("screenManager", "com.huawei.homevision.screenmanager");
        HashMap<String, String> map3 = new HashMap<>(3);
        f9715D = map3;
        HashMap<String, String> map4 = new HashMap<>(80);
        f9716E = map4;
        map3.put("storHandlerForData", C0049d.class.getName());
        map3.put("storHandlerForInfo", C0051f.class.getName());
        map3.put("storHandlerForVFile", C0050e.class.getName());
        map4.put(HNConstants.DataType.CONTACT, C11236d.class.getName());
        map4.put(NavigationUtils.SMS_SCHEMA_PREF, C14132b.class.getName());
        map4.put("chatSms", C13124b.class.getName());
        map4.put("calllog", C10443b.class.getName());
        map4.put("alarm", C9886c.class.getName());
        map4.put("bookmark", C10099b.class.getName());
        map4.put("calendar", BackupCalendarImp.class.getName());
        map4.put("notepad", C13352b.class.getName());
        map4.put("weather", C1388b.class.getName());
        map4.put("photo", C12710g.class.getName());
        map4.put(Constants.VIDEO_SUB_DIR, C12714k.class.getName());
        map4.put("audio", C12712i.class.getName());
        map4.put("doc", C12704a.class.getName());
        map4.put("otherFile", C12708e.class.getName());
        map4.put("wechat_record", C12716m.class.getName());
        map4.put("photo_sd", C12711h.class.getName());
        map4.put("video_sd", C12715l.class.getName());
        map4.put("audio_sd", C12713j.class.getName());
        map4.put("doc_sd", C12705b.class.getName());
        map4.put("otherFile_sd", C12709f.class.getName());
        map4.put("phoneManager", C13531a.class.getName());
        map4.put("HWlanucher", C12465a.class.getName());
        map4.put("Memo", C12938a.class.getName());
        map4.put("app", C2148f.class.getName());
        map4.put("harassment", C11634a.class.getName());
        map4.put("smartcare", C13124b.class.getName());
        map4.put("soundrecorder", C13910a.class.getName());
        map4.put("camera", C13124b.class.getName());
        map4.put("fmradio", C13124b.class.getName());
        map4.put("systemUI", C13124b.class.getName());
        map4.put("baiduInput", C13124b.class.getName());
        map4.put("callRecorder", C13910a.class.getName());
        map4.put("sns", C13124b.class.getName());
        map4.put("wallpaper", C13124b.class.getName());
        map4.put("phoneservice", C13124b.class.getName());
        map4.put("setting", C13124b.class.getName());
        map4.put("clock", C13124b.class.getName());
        map4.put("smsSetting", C13124b.class.getName());
        map4.put("parentcontrol", C13124b.class.getName());
        map4.put("gallerySettting", C13124b.class.getName());
        map4.put("Form", C13124b.class.getName());
        map4.put("vdriver", C13124b.class.getName());
        map4.put("calendarSetting", C13124b.class.getName());
        map4.put("hwKeyChain", C10989b.class.getName());
        map4.put("smartSuggestion", C10988a.class.getName());
        map4.put("HiAIDecision", C12087a.class.getName());
        map4.put("email", C13124b.class.getName());
        map4.put("dataManagementServices", C13124b.class.getName());
        map4.put("desktopMyFile", C13124b.class.getName());
        map4.put("desktopSystemUI", C13124b.class.getName());
        map4.put("huaweiBrowser", C13124b.class.getName());
        map4.put("motionService", C13124b.class.getName());
        map4.put("remoteController", C13124b.class.getName());
        map4.put("galleryData", C13124b.class.getName());
        map4.put("hiVoice", C13124b.class.getName());
        map4.put("screenManager", C13124b.class.getName());
        map4.put("contactFA", C13124b.class.getName());
        map4.put("HAware", C13124b.class.getName());
        map4.put("HuaweiHiAi", C11818a.class.getName());
        map4.put("HiCreate", C12287a.class.getName());
        HashMap map5 = new HashMap(4);
        f9717F = map5;
        Boolean bool = Boolean.FALSE;
        map5.put("systemmodule", bool);
        map5.put("mediamodule", bool);
        map5.put("appmodule", bool);
        map5.put("mediasdmodule", bool);
        HashMap<String, String> map6 = new HashMap<>(4);
        f9718G = map6;
        map6.put(Constants.FAST_APP_PKG, "content://com.huawei.fastapp.backupProvider");
        map6.put("com.hihonor.fastapp", "content://com.hihonor.fastapp.backupProvider");
        HashSet hashSet = new HashSet(60);
        f9719H = hashSet;
        hashSet.add(HNConstants.DataType.CONTACT);
        hashSet.add(NavigationUtils.SMS_SCHEMA_PREF);
        hashSet.add("chatSms");
        hashSet.add("calllog");
        hashSet.add("bookmark");
        hashSet.add("baiduInput");
        hashSet.add("harassment");
        hashSet.add("smartcare");
        hashSet.add("phoneManager");
        hashSet.add("alarm");
        hashSet.add("clock");
        hashSet.add("weather");
        hashSet.add("camera");
        hashSet.add("smsSetting");
        hashSet.add("systemUI");
        hashSet.add("sns");
        hashSet.add("wallpaper");
        hashSet.add("phoneservice");
        hashSet.add("fmradio");
        hashSet.add("Memo");
        hashSet.add("calendar");
        hashSet.add("soundrecorder");
        hashSet.add("callRecorder");
        hashSet.add("parentcontrol");
        hashSet.add("gallerySettting");
        hashSet.add("vdriver");
        hashSet.add("HWlanucher");
        hashSet.add("setting");
        hashSet.add("calendarSetting");
        hashSet.add("hwKeyChain");
        hashSet.add("smartSuggestion");
        hashSet.add("HiAIDecision");
        hashSet.add("email");
        hashSet.add("dataManagementServices");
        hashSet.add("desktopMyFile");
        hashSet.add("desktopSystemUI");
        hashSet.add("huaweiBrowser");
        hashSet.add("galleryData");
        hashSet.add("motionService");
        hashSet.add("remoteController");
        hashSet.add("hiVoice");
        hashSet.add("screenManager");
        hashSet.add("contactFA");
        HashSet hashSet2 = new HashSet(6);
        f9720I = hashSet2;
        hashSet2.add("photo");
        hashSet2.add("audio");
        hashSet2.add(Constants.VIDEO_SUB_DIR);
        hashSet2.add("doc");
        hashSet2.add("otherFile");
        hashSet2.add("wechat_record");
        HashSet hashSet3 = new HashSet(6);
        f9721J = hashSet3;
        hashSet3.add("photo_sd");
        hashSet3.add("audio_sd");
        hashSet3.add("video_sd");
        hashSet3.add("doc_sd");
        hashSet3.add("otherFile_sd");
        HashMap map7 = new HashMap(12);
        f9722K = map7;
        map7.put(503, 0);
        map7.put(512, 0);
        map7.put(504, 0);
        map7.put(513, 0);
        map7.put(Integer.valueOf(BasicBaseResp.TERM_NO_SIGN), 0);
        map7.put(514, 0);
        map7.put(Integer.valueOf(CBSbkFlowHead.FLOW_CONTROL_ERR_CODE), 0);
        map7.put(515, 0);
        map7.put(508, 0);
        map7.put(517, 0);
        HashMap map8 = new HashMap(4);
        f9723L = map8;
        map8.put("systemmodule", new Bundle());
        map8.put("mediamodule", new Bundle());
        map8.put("appmodule", new Bundle());
        map8.put("mediasdmodule", new Bundle());
        HashMap map9 = new HashMap(4);
        f9724M = map9;
        map9.put("systemmodule", new Bundle());
        map9.put("mediamodule", new Bundle());
        map9.put("appmodule", new Bundle());
        map9.put("mediasdmodule", new Bundle());
        HashSet hashSet4 = new HashSet(2);
        f9725N = hashSet4;
        hashSet4.add("soundrecorder");
        hashSet4.add("callRecorder");
        HashSet hashSet5 = new HashSet(60);
        f9726O = hashSet5;
        hashSet5.add("phoneManager");
        hashSet5.add(HNConstants.DataType.CONTACT);
        hashSet5.add(NavigationUtils.SMS_SCHEMA_PREF);
        hashSet5.add("chatSms");
        hashSet5.add("calllog");
        hashSet5.add("bookmark");
        hashSet5.add("baiduInput");
        hashSet5.add("harassment");
        hashSet5.add("smartcare");
        hashSet5.add("alarm");
        hashSet5.add("clock");
        hashSet5.add("weather");
        hashSet5.add("camera");
        hashSet5.add("smsSetting");
        hashSet5.add("systemUI");
        hashSet5.add("sns");
        hashSet5.add("wallpaper");
        hashSet5.add("phoneservice");
        hashSet5.add("fmradio");
        hashSet5.add("calendar");
        hashSet5.add("soundrecorder");
        hashSet5.add("callRecorder");
        hashSet5.add("parentcontrol");
        hashSet5.add("gallerySettting");
        hashSet5.add("vdriver");
        hashSet5.add("HWlanucher");
        hashSet5.add("setting");
        hashSet5.add("calendarSetting");
        HashSet hashSet6 = new HashSet(60);
        f9727P = hashSet6;
        hashSet6.add("Memo");
        hashSet6.add("email");
        hashSet6.add("huaweiBrowser");
        hashSet6.add("galleryData");
        hashSet6.add("hiVoice");
        ArrayList<String> arrayList = new ArrayList<>(3);
        f9728Q = arrayList;
        arrayList.add("setting");
        arrayList.add("hwKeyChain");
        ArrayList<String> arrayList2 = new ArrayList<>(1);
        f9729R = arrayList2;
        arrayList2.add("desktopMyFile");
        arrayList2.add("galleryData");
        ArrayList<String> arrayList3 = new ArrayList<>();
        f9730S = arrayList3;
        arrayList3.add("camera");
        arrayList3.add("huaweiBrowser");
        arrayList3.add("motionService");
        arrayList3.add("remoteController");
        arrayList3.add("email");
        arrayList3.add("setting");
        HashMap map10 = new HashMap(9);
        f9731T = map10;
        map10.put("com.example.android.notepad", new String[]{"Memo"});
        map10.put(NextRestoreConstants.PKG_NAME_MEMO, new String[]{"Memo"});
        map10.put("com.hihonor.notepad", new String[]{"Memo"});
        map10.put("com.android.contacts", new String[]{HNConstants.DataType.CONTACT, "calllog"});
        map10.put("com.huawei.contacts", new String[]{HNConstants.DataType.CONTACT, "calllog"});
        map10.put("com.hihonor.contacts", new String[]{HNConstants.DataType.CONTACT, "calllog"});
        map10.put("com.android.calendar", new String[]{"calendar"});
        map10.put(NextRestoreConstants.PKG_NAME_CALENDAR, new String[]{"calendar"});
        map10.put("com.hihonor.calendar", new String[]{"calendar"});
        map10.put("com.android.soundrecorder", new String[]{"soundrecorder", "callRecorder", "recorder"});
        map10.put(NextRestoreConstants.PKG_NAME_SOUND_RECORDER, new String[]{"soundrecorder", "callRecorder", "recorder"});
        map10.put("com.hihonor.soundrecorder", new String[]{"soundrecorder", "callRecorder", "recorder"});
        map10.put("com.huawei.android.totemweather", new String[]{"weather"});
        map10.put("com.hihonor.android.totemweather", new String[]{"weather"});
        map10.put("com.google.android.apps.messaging", new String[]{NavigationUtils.SMS_SCHEMA_PREF});
        map10.put(NextRestoreConstants.PKG_NAME_SMS, new String[]{NavigationUtils.SMS_SCHEMA_PREF});
        map10.put("com.huawei.android.thememanager", new String[]{"wallpaper"});
        map10.put("com.hihonor.android.thememanager", new String[]{"wallpaper"});
        HashMap map11 = new HashMap(10);
        f9732U = map11;
        map11.put("smartcare", "");
        map11.put("smartSuggestion", "");
        HashSet hashSet7 = new HashSet(60);
        f9733V = hashSet7;
        hashSet7.add("calendar");
        hashSet7.add("Memo");
        hashSet7.add("soundrecorder");
        hashSet7.add("callRecorder");
        hashSet7.add("alarm");
        hashSet7.add("harassment");
        hashSet7.add("smartcare");
        hashSet7.add("phoneManager");
        hashSet7.add("bookmark");
        hashSet7.add("weather");
        hashSet7.add("fmradio");
        hashSet7.add("systemUI");
        hashSet7.add("camera");
        hashSet7.add("baiduInput");
        hashSet7.add("sns");
        hashSet7.add("phoneservice");
        hashSet7.add("clock");
        hashSet7.add("smsSetting");
        hashSet7.add("HWlanucher");
        hashSet7.add("parentcontrol");
        hashSet7.add("gallerySettting");
        hashSet7.add("vdriver");
        hashSet7.add("setting");
        hashSet7.add("wallpaper");
        hashSet7.add("calendarSetting");
        hashSet7.add("hwKeyChain");
        hashSet7.add("smartSuggestion");
        hashSet7.add("HiAIDecision");
        hashSet7.add("email");
        hashSet7.add("dataManagementServices");
        hashSet7.add("desktopMyFile");
        hashSet7.add("desktopSystemUI");
        hashSet7.add("huaweiBrowser");
        hashSet7.add("hiVoice");
        hashSet7.add("motionService");
        hashSet7.add("remoteController");
    }

    /* renamed from: A */
    public static boolean m13125A() {
        String strM81424b = C13529c.m81424b("ro.product.model", "Ideos S7");
        return "Ideos S7".equalsIgnoreCase(strM81424b) || "S7".equalsIgnoreCase(strM81424b);
    }

    /* renamed from: B */
    public static void m13126B() {
        Context contextM7941a = C1386a.m7941a();
        if (contextM7941a == null) {
            C2111d.m12648d("BackupConstant", "processSystemModule context is null.");
            return;
        }
        PackageManager packageManager = contextM7941a.getPackageManager();
        for (Map.Entry<String, String[]> entry : f9759z.entrySet()) {
            String[] value = entry.getValue();
            if (value != null && value.length != 0) {
                int length = value.length;
                int i10 = 0;
                while (true) {
                    if (i10 < length) {
                        String str = value[i10];
                        if (C2157a.m13181P(packageManager, str)) {
                            C2111d.m12654j("BackupConstant", str, " is installed.");
                            f9714C.put(entry.getKey(), str);
                            break;
                        }
                        i10++;
                    }
                }
            }
        }
        f9737d = true;
    }

    /* renamed from: d */
    public static HashMap<String, String> m13130d() {
        return f9718G;
    }

    /* renamed from: e */
    public static HashMap<String, String> m13131e() {
        return f9716E;
    }

    /* renamed from: f */
    public static List<String> m13132f() {
        return f9713B;
    }

    /* renamed from: g */
    public static HashMap<String, String> m13133g() {
        return f9712A;
    }

    /* renamed from: h */
    public static HashMap<String, String> m13134h() {
        return f9715D;
    }

    /* renamed from: i */
    public static ArrayList<String> m13135i() {
        return f9730S;
    }

    /* renamed from: j */
    public static Map<String, Bundle> m13136j() {
        return f9724M;
    }

    /* renamed from: k */
    public static Map<String, Bundle> m13137k() {
        return f9723L;
    }

    /* renamed from: l */
    public static Map<String, Boolean> m13138l() {
        return f9717F;
    }

    /* renamed from: m */
    public static Set<String> m13139m() {
        return f9725N;
    }

    /* renamed from: n */
    public static Set<String> m13140n() {
        return f9733V;
    }

    /* renamed from: o */
    public static ArrayList<String> m13141o() {
        return f9728Q;
    }

    /* renamed from: p */
    public static Map<Integer, Integer> m13142p() {
        return f9722K;
    }

    /* renamed from: q */
    public static Map<String, String> m13143q() {
        return f9732U;
    }

    /* renamed from: r */
    public static Set<String> m13144r() {
        return f9727P;
    }

    /* renamed from: s */
    public static Set<String> m13145s() {
        return f9726O;
    }

    /* renamed from: t */
    public static ConcurrentHashMap<String, String> m13146t() {
        if (!f9737d) {
            m13126B();
        }
        return f9714C;
    }

    /* renamed from: u */
    public static Set<String> m13147u() {
        return f9719H;
    }

    /* renamed from: v */
    public static ArrayList<String> m13148v() {
        return f9729R;
    }

    /* renamed from: w */
    public static boolean m13149w(String str) {
        return NextRestoreConstants.PKG_NAME_GALLERY_DATA.equals(str) || "com.hihonor.photos".equals(str) || NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D.equals(str);
    }

    /* renamed from: x */
    public static boolean m13150x() {
        return m13151y() || m13125A() || m13152z();
    }

    /* renamed from: y */
    public static boolean m13151y() {
        String strM81424b = C13529c.m81424b("ro.product.board", "");
        return "MediaPad".equalsIgnoreCase(C13529c.m81424b("ro.product.name", "")) && ("hws7300w".equalsIgnoreCase(strM81424b) || "hws7300t".equalsIgnoreCase(strM81424b) || "hws7300c".equalsIgnoreCase(strM81424b) || "hws7300u".equalsIgnoreCase(strM81424b) || "hws7300".equalsIgnoreCase(strM81424b));
    }

    /* renamed from: z */
    public static boolean m13152z() {
        return "Ideos S7 slim".equalsIgnoreCase(C13529c.m81424b("ro.product.model", "Ideos S7"));
    }
}
