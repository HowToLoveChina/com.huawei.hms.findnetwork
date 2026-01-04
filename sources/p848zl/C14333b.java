package p848zl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0224k0;
import p292fn.C9733f;
import p327h5.C10100c;
import p495nm.C11734o;
import p514o9.C11839m;
import p699v4.C13347p;
import p848zl.C14333b;

/* renamed from: zl.b */
/* loaded from: classes6.dex */
public class C14333b {

    /* renamed from: A */
    public static final List<String> f63636A;

    /* renamed from: B */
    public static final List<String> f63637B;

    /* renamed from: C */
    public static final List<String> f63638C;

    /* renamed from: D */
    public static final List<String> f63639D;

    /* renamed from: E */
    public static final List<String> f63640E;

    /* renamed from: F */
    public static final List<String> f63641F;

    /* renamed from: G */
    public static final HashMap<String, String> f63642G;

    /* renamed from: H */
    public static List<String> f63643H;

    /* renamed from: I */
    public static final List<String> f63644I;

    /* renamed from: J */
    public static final HashMap<String, String> f63645J;

    /* renamed from: K */
    public static List<String> f63646K;

    /* renamed from: L */
    public static List<String> f63647L;

    /* renamed from: M */
    public static final HashMap<String, Supplier<Boolean>> f63648M;

    /* renamed from: a */
    public static final String f63649a;

    /* renamed from: b */
    public static final ConcurrentHashMap<String, Object> f63650b;

    /* renamed from: c */
    public static final ConcurrentHashMap<String, String> f63651c;

    /* renamed from: d */
    public static final List<String> f63652d;

    /* renamed from: e */
    public static final ConcurrentHashMap<String, Object> f63653e;

    /* renamed from: f */
    public static final List<String> f63654f;

    /* renamed from: g */
    public static final List<String> f63655g;

    /* renamed from: h */
    public static final List<String> f63656h;

    /* renamed from: i */
    public static final List<String> f63657i;

    /* renamed from: j */
    public static final List<String> f63658j;

    /* renamed from: k */
    public static final HashMap<String, Integer> f63659k;

    /* renamed from: l */
    public static final Map<String, Integer> f63660l;

    /* renamed from: m */
    public static final List<String> f63661m;

    /* renamed from: n */
    public static final List<String> f63662n;

    /* renamed from: o */
    public static final List<String> f63663o;

    /* renamed from: p */
    public static final List<String> f63664p;

    /* renamed from: q */
    public static final List<String> f63665q;

    /* renamed from: r */
    public static final List<String> f63666r;

    /* renamed from: s */
    public static final List<String> f63667s;

    /* renamed from: t */
    public static final List<String> f63668t;

    /* renamed from: u */
    public static final List<String> f63669u;

    /* renamed from: v */
    public static final List<String> f63670v;

    /* renamed from: w */
    public static final List<String> f63671w;

    /* renamed from: x */
    public static final List<String> f63672x;

    /* renamed from: y */
    public static final List<String> f63673y;

    /* renamed from: z */
    public static final List<String> f63674z;

    /* renamed from: zl.b$a */
    public class a extends ArrayList<String> {
        public a() {
            add(HNConstants.DataType.CONTACT);
            add(NavigationUtils.SMS_SCHEMA_PREF);
            add("calllog");
            add("calendar");
            add("Memo");
            add("huaweiBrowser");
            add("soundrecorder");
            add("music");
            add(HNConstants.DataType.MEDIA);
            add("HuaweiHiAi");
            add("HiCreate");
        }
    }

    /* renamed from: zl.b$a0 */
    public class a0 extends ArrayList<String> {
        public a0() {
            add("HWlanucher");
            add("phoneManager");
            add("virtual.sync.switch.status");
            add("setting");
        }
    }

    /* renamed from: zl.b$b */
    public class b extends ArrayList<String> {
        public b() {
            add("HuaweiHiAi");
        }
    }

    /* renamed from: zl.b$c */
    public class c extends ArrayList<String> {
        public c() {
            add("HuaweiHiAi");
            add("HiCreate");
        }
    }

    /* renamed from: zl.b$d */
    public class d extends ArrayList<String> {
        public d() {
            add("HWlanucher");
        }
    }

    /* renamed from: zl.b$e */
    public class e extends ArrayList<String> {
        public e() {
            add("HuaweiHiAi");
            add("HiCreate");
        }
    }

    /* renamed from: zl.b$f */
    public class f extends ArrayList<String> {
        public f() {
            add(HNConstants.DataType.CONTACT);
            add(NavigationUtils.SMS_SCHEMA_PREF);
            add("chatSms");
            add("calllog");
            add("calendar");
            add("Memo");
            add("huaweiBrowser");
            add("soundrecorder");
            add("callRecorder");
            add("music");
            add(HNConstants.DataType.MEDIA);
            add("HuaweiHiAi");
            add("HiCreate");
        }
    }

    /* renamed from: zl.b$g */
    public class g extends ArrayList<String> {
        public g() {
            add("wallpaper");
            add("desktopMyFile");
            add("smsSetting");
            add("email");
            add("Form");
            add("hwouc");
            add("bookmark");
            add("contactFA");
            add("alarm");
            add("screenRecorder");
            add("HwWallet");
            add("calendarSetting");
            add("HAware");
            add("phoneservice");
            add("baiduInput");
            add("harassment");
            add("motionService");
            add("fmradio");
            add("clock");
            add("virtual.sync.switch.status");
            add("gallerySettting");
            add("weather");
            add("camera");
            add("hwIReader");
            add("hwDzRead");
            add("HiAIDecision");
            add("hiVoice");
            add("smartcare");
            add("remoteController");
            add("smartSwipe");
            add("magazineUnlock");
            add("phoneManager");
            add("setting");
            add("HWlanucher");
        }
    }

    /* renamed from: zl.b$h */
    public class h extends ArrayList<String> {
        public h() {
            add(HNConstants.DataType.MEDIA);
            add("music");
            add("doc");
            add("virtual.sync.switch.status");
        }
    }

    /* renamed from: zl.b$i */
    public class i extends ArrayList<String> {
        public i() {
            addAll(C14333b.f63666r);
            remove(HNConstants.DataType.MEDIA);
            remove("music");
            removeAll(C14333b.f63667s);
            add("baseData");
        }
    }

    /* renamed from: zl.b$j */
    public class j extends ArrayList<String> {
        public j() {
            addAll(C14333b.f63666r);
            remove(HNConstants.DataType.MEDIA);
            remove("music");
            add("baseData");
        }
    }

    /* renamed from: zl.b$k */
    public class k extends ArrayList<String> {
        public k() {
            add("oh_contact");
            add("com.ohos.mms");
            add("com.ohos.telephonydataability");
            add("oh_calllog");
            add("com.huawei.hmos.calendar");
            add("com.huawei.hmos.calendardata");
        }
    }

    /* renamed from: zl.b$l */
    public class l extends ArrayList<String> {
        public l() {
            addAll(C14333b.f63663o);
            addAll(C14333b.f63664p);
            addAll(C14333b.f63665q);
            add(HNConstants.DataType.MEDIA);
            add("music");
            add("HuaweiHiAi");
            add("HiCreate");
        }
    }

    /* renamed from: zl.b$m */
    public class m extends ArrayList<String> {
        public m() {
            addAll(C14333b.f63663o);
            addAll(C14333b.f63664p);
            addAll(C14333b.f63665q);
        }
    }

    /* renamed from: zl.b$n */
    public class n extends ArrayList<String> {
        public n() {
            addAll(C14333b.f63663o);
            addAll(C14333b.f63664p);
            addAll(C14333b.f63665q);
            remove(HNConstants.DataType.CONTACT);
            remove(NavigationUtils.SMS_SCHEMA_PREF);
            remove("chatSms");
            remove("calllog");
        }
    }

    /* renamed from: zl.b$o */
    public class o extends ArrayList<String> {
        public o() {
            add(HNConstants.DataType.CONTACT);
        }
    }

    /* renamed from: zl.b$p */
    public class p extends HashMap<String, String> {
        public p() {
            put("com.tencent.mm", "com.tencent.mm.plugin.account.model.AccountAuthenticatorService");
            put("com.whatsapp", "com.whatsapp.accountsync.AccountAuthenticatorService");
        }
    }

    /* renamed from: zl.b$q */
    public class q extends ArrayList<String> {
        public q() {
            add("com.tencent.mm");
            add("com.tencent.mobileqq");
        }
    }

    /* renamed from: zl.b$r */
    public class r extends HashMap<String, String> {
        public r() {
            put(NavigationUtils.SMS_SCHEMA_PREF, "bs.sms");
            put("calllog", "bs.calllog");
            put("harassment", "bs.harassment");
            put("soundrecorder", "bs.recording");
            put("music", "bs.music");
            put(HNConstants.DataType.CONTACT, "bs.contact");
            put("calendar", "bs.calendar");
            put("Memo", "bs.memo");
            put(HNConstants.DataType.MEDIA, "bs.gallery");
        }
    }

    /* renamed from: zl.b$s */
    public class s extends HashMap<String, Supplier<Boolean>> {
        public s() {
            put("fmradio", new Supplier() { // from class: zl.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Boolean.FALSE;
                }
            });
            put("bookmark", new Supplier() { // from class: zl.d
                @Override // java.util.function.Supplier
                public final Object get() {
                    return C14333b.s.m85496j();
                }
            });
            put("Memo", new Supplier() { // from class: zl.e
                @Override // java.util.function.Supplier
                public final Object get() {
                    return C14333b.s.m85497k();
                }
            });
        }

        /* renamed from: j */
        public static /* synthetic */ Boolean m85496j() {
            return Boolean.valueOf(C2157a.m13168C() && C14333b.m85475j(C0213f.m1377a()));
        }

        /* renamed from: k */
        public static /* synthetic */ Boolean m85497k() {
            return Boolean.valueOf(C0209d.m1227Y1(C0213f.m1377a(), C13347p.m80079b(C14333b.f63649a)));
        }
    }

    /* renamed from: zl.b$t */
    public class t extends ArrayList<String> {
        public t() {
            add(HNConstants.DataType.CONTACT);
            add(NavigationUtils.SMS_SCHEMA_PREF);
            add("chatSms");
            add("calllog");
            add("calendar");
            add("bookmark");
            add("fmradio");
            add("phoneservice");
            add("Memo");
            add("soundrecorder");
            add("callRecorder");
            add(HNConstants.DataType.MEDIA);
            add("music");
            add("HuaweiHiAi");
            add("wallpaper");
            add("desktopMyFile");
            add("smsSetting");
            add("email");
            add("Form");
            add("hwouc");
            add("huaweiBrowser");
            add("contactFA");
            add("alarm");
            add("screenRecorder");
            add("HwWallet");
            add("calendarSetting");
            add("HAware");
            add("baiduInput");
            add("harassment");
            add("motionService");
            add("clock");
            add("gallerySettting");
            add("weather");
            add("camera");
            add("hwIReader");
            add("hwDzRead");
            add("HiAIDecision");
            add("hiVoice");
            add("smartcare");
            add("remoteController");
            add("smartSwipe");
            add("magazineUnlock");
            add("phoneManager");
            add("virtual.sync.switch.status");
            add("virtual.hmos.sync.switch.status");
            add("setting");
            add("HiCreate");
            add("HWlanucher");
            add("sysdata");
            add("thirdApp");
            addAll(C14333b.f63652d);
        }
    }

    /* renamed from: zl.b$u */
    public class u extends HashMap<String, Integer> {
        public u() {
            int i10 = R$string.contact;
            put(HNConstants.DataType.CONTACT, Integer.valueOf(i10));
            int i11 = R$string.cloudbackup_back_item_sms;
            put(NavigationUtils.SMS_SCHEMA_PREF, Integer.valueOf(i11));
            put("chatSms", Integer.valueOf(R$string.cloud_enhancement_information));
            int i12 = R$string.recovery_appid_calllog;
            put("calllog", Integer.valueOf(i12));
            int i13 = R$string.calendar_sync_item;
            put("calendar", Integer.valueOf(i13));
            put("Memo", Integer.valueOf(R$string.cloudbackup_back_item_notepad));
            put("bookmark", Integer.valueOf(R$string.recovering_browser));
            put("baiduInput", Integer.valueOf(R$string.recovering_baidu));
            put("harassment", Integer.valueOf(R$string.cloudbackup_back_item_phonemanager));
            put("smartcare", Integer.valueOf(R$string.cloud_restore_option_smartcare));
            put("phoneManager", Integer.valueOf(R$string.recovering_phonemanager));
            put("alarm", Integer.valueOf(R$string.recovering_alarm_setting));
            put("clock", Integer.valueOf(R$string.recovering_clock_setting));
            put("weather", Integer.valueOf(R$string.recovering_weather_setting));
            put("camera", Integer.valueOf(R$string.recovering_camera_setting));
            put("fmradio", Integer.valueOf(R$string.recovering_radio));
            put("phoneservice", Integer.valueOf(R$string.recovering_phoneservice));
            int i14 = R$string.cloudbackup_back_item_record;
            put("soundrecorder", Integer.valueOf(i14));
            put("callRecorder", Integer.valueOf(i14));
            put("HWlanucher", Integer.valueOf(R$string.recovering_hwlaucher));
            put("setting", Integer.valueOf(R$string.cloudbackup_setting));
            int i15 = R$string.gallery_item_title;
            put(HNConstants.DataType.MEDIA, Integer.valueOf(i15));
            put("music", Integer.valueOf(R$string.backup_music));
            int i16 = R$string.system_data;
            put("baseData", Integer.valueOf(i16));
            put("sysdata", Integer.valueOf(i16));
            put("basic_system_data", Integer.valueOf(i16));
            put("thirdApp", Integer.valueOf(R$string.cloud_restore_applist));
            put("thirdAppData", Integer.valueOf(R$string.frag_app_data_title));
            put("contactFA", Integer.valueOf(R$string.contactfa_sync_item));
            put("Form", Integer.valueOf(R$string.huawei_form));
            put("smsSetting", Integer.valueOf(R$string.smssetting_sync_item));
            put("calendarSetting", Integer.valueOf(R$string.calendarsetting_sync_item));
            put("wallpaper", Integer.valueOf(R$string.recovering_wallpaper));
            put("desktopMyFile", Integer.valueOf(R$string.recovering_desktop_my_file));
            put("hiVoice", Integer.valueOf(R$string.hiVoice));
            put("HiAIDecision", Integer.valueOf(R$string.hiaidecision));
            put("remoteController", Integer.valueOf(R$string.remoteController));
            put("HAware", Integer.valueOf(R$string.haware));
            put("magazineUnlock", Integer.valueOf(R$string.hw_magazine_unlock));
            put("hwIReader", Integer.valueOf(R$string.hw_reader));
            put("hwDzRead", Integer.valueOf(R$string.hw_reader_dz));
            put("HwWallet", Integer.valueOf(R$string.cloudbakcup_hwwallet_msg));
            put("smartSwipe", Integer.valueOf(R$string.cloudbakcup_smartswipe_msg));
            put("hwouc", Integer.valueOf(R$string.cloudbakcup_hwouc_msg));
            put("motionService", Integer.valueOf(R$string.cloudbackup_item_motion_service));
            put("screenRecorder", Integer.valueOf(R$string.cloudbackup_item_screen_recorder));
            put("email", Integer.valueOf(R$string.cloudbackup_item_email));
            put("gallerySettting", Integer.valueOf(R$string.huawei_gallery_settting));
            put("huaweiBrowser", Integer.valueOf(R$string.huawei_browser));
            put("virtual.sync.switch.status", Integer.valueOf(R$string.virtual_sync_switch_status));
            put("bmBaseData", Integer.valueOf(R$string.base_data));
            put("newBmBaseItem", Integer.valueOf(R$string.backup_basic_module));
            put("HuaweiHiAi", Integer.valueOf(R$string.backup_intelligent_engine));
            put("HiCreate", Integer.valueOf(R$string.backup_hi_create));
            put("oh_contact", Integer.valueOf(i10));
            put("com.ohos.mms", Integer.valueOf(i11));
            put("com.ohos.telephonydataability", Integer.valueOf(R$string.next_module_name_sms_storage));
            put("oh_calllog", Integer.valueOf(i12));
            put("com.huawei.hmos.calendar", Integer.valueOf(i13));
            put("com.huawei.hmos.calendardata", Integer.valueOf(R$string.next_module_name_calendar_storage));
            put("com.huawei.hmos.soundrecorder", Integer.valueOf(i14));
            int i17 = R$string.recovering_call_recorder;
            put("com.huawei.hmos.callrecorder", Integer.valueOf(i17));
            put("com.huawei.hmos.meetime", Integer.valueOf(R$string.cloudbackup_back_item_meetime));
            put("com.huawei.hmos.meetimeservice", Integer.valueOf(i17));
            put(NextRestoreConstants.BUNDLE_NAME_GALLERY, Integer.valueOf(R$string.cloudbackup_back_item_medialibrarydata));
            put("com.huawei.hmos.photos", Integer.valueOf(i15));
        }
    }

    /* renamed from: zl.b$v */
    public class v extends HashMap<String, Integer> {
        public v() {
            put(HNConstants.DataType.CONTACT, Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_contacts_honor : R$drawable.ic_contacts));
            put(NavigationUtils.SMS_SCHEMA_PREF, Integer.valueOf(C0209d.m1269j1() ? R$drawable.icon_message_honor : R$drawable.icon_sms));
            put("chatSms", Integer.valueOf(C0209d.m1269j1() ? R$drawable.icon_message_honor : R$drawable.icon_sms));
            put("calllog", Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_cloud_phone_honor : R$drawable.ic_cloud_phone));
            put("calendar", Integer.valueOf(C0209d.m1269j1() ? R$drawable.icon_calendar_honor : R$drawable.icon_calendar));
            put("Memo", Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_memorandum_honor : R$drawable.ic_memorandum));
            put("bookmark", Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_hicloud_browser_list_new_honor : R$drawable.ic_hicloud_browser_list_new));
            put("huaweiBrowser", Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_hicloud_browser_list_new_honor : R$drawable.ic_hicloud_browser_list_new));
            put("soundrecorder", Integer.valueOf(C0209d.m1269j1() ? R$drawable.icon_record_detail_honor : R$drawable.icon_soundrecorder_detail));
            put("callRecorder", Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_cloud_callrecord_honor : R$drawable.icon_soundrecorder_detail));
            put("baiduInput", Integer.valueOf(R$drawable.ic_cloud_baidu));
            put("harassment", Integer.valueOf(R$drawable.ic_cloud_harassment));
            put("smartcare", Integer.valueOf(R$drawable.ic_cloud_assistant));
            put("phoneManager", Integer.valueOf(R$drawable.ic_cloud_systemmanager));
            put("alarm", Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_cloud_alarm_honor : R$drawable.ic_cloud_alarm));
            put("clock", Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_cloud_deskclock_honor : R$drawable.ic_cloud_deskclock));
            put("weather", Integer.valueOf(R$drawable.ic_cloud_totemweather));
            put("camera", Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_cloud_camera_honor : R$drawable.ic_cloud_camera));
            put("fmradio", Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_cloud_fmradio_honor : R$drawable.ic_cloud_fmradio));
            put("phoneservice", Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_cloud_phoneservice_honor : R$drawable.ic_cloud_phoneservice));
            put("HWlanucher", Integer.valueOf(R$drawable.ic_cloud_desktop));
            put("setting", Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_cloud_settings_honor : R$drawable.ic_cloud_settings));
            put(HNConstants.DataType.MEDIA, Integer.valueOf(C0209d.m1269j1() ? R$drawable.ic_cloud_album_honor : R$drawable.ic_cloud_album));
            put("music", Integer.valueOf(C0209d.m1269j1() ? R$drawable.icon_huawei_music_honor : R$drawable.icon_huawei_music));
            put("baseData", Integer.valueOf(C0209d.m1269j1() ? R$drawable.icon_base_data_honor : R$drawable.icon_base_data));
            put("HuaweiHiAi", Integer.valueOf(R$drawable.icon_hiai));
            put("HiCreate", Integer.valueOf(R$drawable.icon_hicreate));
            put("sysdata", C14333b.m85451G());
            put("basic_system_data", C14333b.m85451G());
            put("thirdApp", Integer.valueOf(R$drawable.icon_cloudbackup_applist));
            put("newBmBaseItem", Integer.valueOf(R$drawable.backup_basic_module_option));
            put("thirdAppData", Integer.valueOf(R$drawable.ic_app_data));
            put("virtual.sync.switch.status", Integer.valueOf(R$drawable.ic_about_cloud));
            int i10 = R$drawable.icon_mms;
            put("com.ohos.mms", Integer.valueOf(i10));
            put("com.ohos.telephonydataability", Integer.valueOf(i10));
            int i11 = R$drawable.icon_calendardata;
            put("com.huawei.hmos.calendar", Integer.valueOf(i11));
            put("com.huawei.hmos.calendardata", Integer.valueOf(i11));
            int i12 = R$drawable.icon_soundrecorder;
            put("com.huawei.hmos.soundrecorder", Integer.valueOf(i12));
            put("com.huawei.hmos.callrecorder", Integer.valueOf(i12));
            int i13 = R$drawable.icon_meetime;
            put("com.huawei.hmos.meetime", Integer.valueOf(i13));
            put("com.huawei.hmos.meetimeservice", Integer.valueOf(i13));
            int i14 = R$drawable.icon_photos;
            put("com.huawei.hmos.photos", Integer.valueOf(i14));
            put(NextRestoreConstants.BUNDLE_NAME_GALLERY, Integer.valueOf(i14));
            put("virtual.hmos.sync.switch.status", Integer.valueOf(R$drawable.ic_cloud_backup_sync_setting));
        }
    }

    /* renamed from: zl.b$w */
    public class w extends ArrayList<String> {
        public w() {
            add("com.google.android.setupwizard");
            add("com.google.android.googlequicksearchbox");
            add(FeedbackConst.Mail.GMAIL);
            add("com.google.android.calendar");
            add("com.google.android.talk");
            add("com.google.android.youtube");
            add("com.google.android.apps.maps");
            add("com.google.android.street");
            add("com.google.android.syncadapters.contacts");
            add("com.google.earth");
            add("com.google.android.apps.genie.geniewidget");
            add("com.google.android.apps.googlevoice");
            add("com.google.android.syncadapters.calendar");
            add("com.google.android.apps.plus");
            add("com.google.android.apps.books");
            add("com.google.android.music");
            add("com.google.android.partnersetup");
            add("com.android.chrome");
            add("com.google.android.gsf");
            add("com.google.android.videos");
            add("com.google.android.apps.magazines");
            add("com.google.android.apps.walletnfcrel");
            add("com.google.android.apps.shopping.express");
            add("com.android.browser.provider");
            add("com.google.android.configupdater");
            add("com.google.android.syncadapters.bookmarks");
            add("com.google.android.apps.cloudprint");
            add("com.google.android.apps.docs");
            add("com.google.android.gallery3d");
            add(Constants.GMS_PGK);
            add("com.google.android.backup");
            add("com.google.android.GoogleCamera");
            add("com.google.android.feedback");
            add("com.google.android.gsf.login");
            add("com.google.android.onetimeinitializer");
            add("com.google.android.tts");
            add("com.google.android.inputmethod.latin");
            add("com.google.android.maps.jar");
            add("com.google.android.media.effects.jar");
            add("com.google.android.play.games");
            add("com.google.android.tag");
            add("com.google.android.marvin.talkback");
            add("com.google.android.videoeditor");
            add("com.android.vending");
            add("com.google.android.apps.work.oobconfig");
            add("com.google.android.apps.restore");
            add("com.google.android.apps.tachyon");
            add("com.google.android.webview");
            add("com.google.android.packageinstaller");
            add("com.google.android.printservice.recommendation");
            add("com.google.android.ext.shared");
            add("com.google.android.ext.services");
            add("com.google.android.gms.policy_sidecar_aps");
            add("com.google.android.calculator");
            add("com.google.android.deskclock");
            add("com.google.android.contacts");
            add("com.google.android.inputmethod.korean");
            add("com.google.android.inputmethod.pinyin");
            add("com.google.android.inputmethod.japanese");
            add("com.android.facelock");
            add("com.google.android.apps.docs.editors.docs");
            add("com.google.android.apps.docs.editors.sheets");
            add("com.google.android.apps.docs.editors.slides");
            add("com.google.android.apps.actionsservice");
            add("com.google.android.apps.speechservices");
            add("com.google.android.dialer");
            add("com.google.android.keep");
            add("com.google.android.apps.turbo");
            add("com.android.hotwordenrollment.okgoogle");
            add("com.android.hotwordenrollment.xgoogle");
            add("com.google.ar.core");
            add("com.google.android.apps.googleassistant");
            add("com.google.android.apps.translate");
            add("com.google.android.apps.messaging");
            add("com.google.android.ims");
            add("com.google.android.euicc");
            add("com.google.android.apps.enterprise.dmagent");
            add("com.google.android.apps.adm");
            add("com.google.android.inputmethod.latin");
            add("com.google.android.apps.inputmethod.hindi");
            add("com.google.android.apps.handwriting.ime");
            add("com.google.android.apps.wallpaper");
            add("com.google.android.apps.nbu.files");
            add("com.google.android.apps.youtube.mango");
            add("com.google.android.apps.youtube.kids");
            add("com.google.android.apps.fitness");
            add("com.google.android.apps.pdfviewer");
            add("com.google.vr.vrcore");
            add("com.google.android.apps.freighter");
            add("com.google.android.apps.subscriptions.red");
            add("com.google.android.apps.wellbeing");
        }
    }

    /* renamed from: zl.b$x */
    public class x extends ArrayList<String> {
        public x() {
            add("com.huawei.search");
            add("com.hihonor.search");
            add(Constants.REMOTE_APP_INSTALL_HOST_HSF_PACKAGE);
            add("com.huawei.hicloud");
            add("com.huawei.hidisk");
            add(NextRestoreConstants.PKG_NAME_FILE_MANAGER);
            add("com.huawei.android.findmyphone");
            add("com.huawei.contacts");
            add("com.hihonor.contacts");
            add("com.huawei.contacts.sync");
            add("com.android.mediacenter");
            add("com.huawei.music");
            add("com.hihonor.music");
            add(NextRestoreConstants.PKG_NAME_GALLERY_DATA);
            add("com.hihonor.photos");
            add("com.huawei.filemanager.tv");
            add(NotifyConstants.InterfaceC4908FA.PACKAGE_NAME);
        }
    }

    /* renamed from: zl.b$y */
    public class y extends ArrayList<String> {
        public y() {
            add(HNConstants.DataType.CONTACT);
            add(NavigationUtils.SMS_SCHEMA_PREF);
            add("chatSms");
            add("calllog");
            add("calendar");
            add("bookmark");
            add("baiduInput");
            add("harassment");
            add("smartcare");
            add("alarm");
            add("clock");
            add("weather");
            add("camera");
            add("fmradio");
            add("phoneservice");
        }
    }

    /* renamed from: zl.b$z */
    public class z extends ArrayList<String> {
        public z() {
            add("Memo");
            add("soundrecorder");
            add("callRecorder");
            addAll(C14333b.f63656h);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:272:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0313  */
    static {
        /*
            Method dump skipped, instructions count: 1501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p848zl.C14333b.<clinit>():void");
    }

    /* renamed from: A */
    public static Supplier<Boolean> m85445A(final String str) {
        return f63648M.getOrDefault(str, new Supplier() { // from class: zl.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return C14333b.m85462R(str);
            }
        });
    }

    /* renamed from: B */
    public static List<String> m85446B() {
        return f63658j;
    }

    /* renamed from: C */
    public static List<String> m85447C() {
        return f63670v;
    }

    /* renamed from: D */
    public static List<String> m85448D() {
        return f63668t;
    }

    /* renamed from: E */
    public static List<String> m85449E() {
        return f63667s;
    }

    /* renamed from: F */
    public static List<String> m85450F() {
        return f63646K.isEmpty() ? f63644I : f63646K;
    }

    /* renamed from: G */
    public static Integer m85451G() {
        return C0209d.m1269j1() ? Integer.valueOf(R$drawable.ic_cloud_settings_honor) : C0224k0.m1567v() ? Integer.valueOf(R$drawable.ic_cloud_settings_harmony) : Integer.valueOf(R$drawable.ic_cloud_settings_emui9);
    }

    /* renamed from: H */
    public static List<String> m85452H() {
        return f63666r;
    }

    /* renamed from: I */
    public static List<String> m85453I() {
        return f63671w;
    }

    /* renamed from: J */
    public static List<String> m85454J() {
        return f63662n;
    }

    /* renamed from: K */
    public static List<String> m85455K() {
        return f63673y;
    }

    /* renamed from: L */
    public static HashMap<String, String> m85456L() {
        return f63645J;
    }

    /* renamed from: M */
    public static List<String> m85457M() {
        return f63636A;
    }

    /* renamed from: N */
    public static HashMap<String, String> m85458N() {
        return f63642G;
    }

    /* renamed from: O */
    public static List<String> m85459O() {
        return f63647L.isEmpty() ? f63644I : f63647L;
    }

    /* renamed from: P */
    public static void m85460P(int i10) {
        boolean zM60720O = C9733f.m60705z().m60720O("backupRecorderRestoreCompat");
        String strM60762u = C9733f.m60705z().m60762u("backupRecorderRestoreCompat");
        ArrayList arrayList = new ArrayList(Arrays.asList("smartcare", "chatSms", "soundrecorder"));
        if (zM60720O && !TextUtils.isEmpty(strM60762u)) {
            try {
                List<Integer> listM70027a = ((C11734o) new Gson().fromJson(strM60762u, C11734o.class)).m70027a();
                if (listM70027a != null && listM70027a.contains(Integer.valueOf(i10))) {
                    arrayList.remove("soundrecorder");
                }
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupModules", "initMediaModulesForRestore json parse error: " + e10.getMessage());
            }
        }
        C11839m.m70688i("CloudBackupModules", "initMediaModulesForRestore bakCategory: " + i10 + " result: " + arrayList);
        List<String> list = f63641F;
        list.clear();
        list.addAll(arrayList);
    }

    /* renamed from: Q */
    public static boolean m85461Q(String str) {
        return "soundrecorder".equals(str) || "callRecorder".equals(str);
    }

    /* renamed from: R */
    public static /* synthetic */ Boolean m85462R(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = f63651c;
        return Boolean.valueOf(!concurrentHashMap.containsKey(str) || C0209d.m1184K0(C0213f.m1377a(), concurrentHashMap.get(str)));
    }

    /* renamed from: S */
    public static void m85463S(List<String> list) {
        f63643H = list;
    }

    /* renamed from: T */
    public static void m85464T(List<String> list) {
        f63646K = list;
    }

    /* renamed from: U */
    public static void m85465U(List<String> list) {
        f63647L = list;
    }

    /* renamed from: j */
    public static boolean m85475j(Context context) {
        try {
            Uri uri = C10100c.a.f49289a;
            if (!C0209d.m1227Y1(context, uri)) {
                return false;
            }
            String[] strArrM13202j = C2157a.m13202j(context, uri);
            if (strArrM13202j.length == 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : strArrM13202j) {
                if (C10100c.a.m62911a().containsKey(str)) {
                    arrayList.add(str);
                }
            }
            return arrayList.size() > 0;
        } catch (Throwable th2) {
            C11839m.m70689w("CloudBackupModules", "bookMarkSupportCheck error: " + th2);
            return false;
        }
    }

    /* renamed from: k */
    public static List<String> m85476k() {
        return f63637B;
    }

    /* renamed from: l */
    public static List<String> m85477l() {
        return f63638C;
    }

    /* renamed from: m */
    public static List<String> m85478m() {
        return f63674z;
    }

    /* renamed from: n */
    public static List<String> m85479n() {
        return f63643H;
    }

    /* renamed from: o */
    public static List<String> m85480o() {
        return f63669u;
    }

    /* renamed from: p */
    public static List<String> m85481p() {
        return f63639D;
    }

    /* renamed from: q */
    public static List<String> m85482q() {
        return f63672x;
    }

    /* renamed from: r */
    public static Map<String, Integer> m85483r() {
        return f63660l;
    }

    /* renamed from: s */
    public static List<String> m85484s() {
        return f63661m;
    }

    /* renamed from: t */
    public static List<String> m85485t() {
        return f63652d;
    }

    /* renamed from: u */
    public static HashMap<String, Integer> m85486u() {
        return f63659k;
    }

    /* renamed from: v */
    public static List<String> m85487v() {
        return f63663o;
    }

    /* renamed from: w */
    public static List<String> m85488w() {
        return f63664p;
    }

    /* renamed from: x */
    public static List<String> m85489x() {
        return f63665q;
    }

    /* renamed from: y */
    public static List<String> m85490y() {
        return f63640E;
    }

    /* renamed from: z */
    public static List<String> m85491z() {
        return new ArrayList(f63641F);
    }
}
