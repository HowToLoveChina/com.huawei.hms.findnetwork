package vn;

import com.huawei.fastengine.fastview.NavigationUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: vn.c */
/* loaded from: classes6.dex */
public class C13471c {

    /* renamed from: a */
    public static final Map<String, String> f60678a = new a();

    /* renamed from: b */
    public static final Map<String, String> f60679b = new b();

    /* renamed from: c */
    public static final Map<String, String> f60680c = new c();

    /* renamed from: d */
    public static final Map<String, String> f60681d = new d();

    /* renamed from: e */
    public static final Map<Integer, String> f60682e = new e();

    /* renamed from: f */
    public static String f60683f;

    /* renamed from: g */
    public static String f60684g;

    /* renamed from: h */
    public static String f60685h;

    /* renamed from: vn.c$a */
    public class a extends HashMap<String, String> {
        public a() {
            put(NavigationUtils.SMS_SCHEMA_PREF, "UP_SMS");
            put("callLog", "UP_CALL");
            put("recording", "UP_REC");
            put("phonemanager", "UP_PHONEMANAGER");
        }
    }

    /* renamed from: vn.c$b */
    public class b extends HashMap<String, String> {
        public b() {
            put("wlan", "CLOUDBACKUP_OOBE_OPEN_WLAN");
            put("calendar", "CLOUDBACKUP_OOBE_OPEN_CALENDAR");
            put("addressbook", "CLOUDBACKUP_OOBE_OPEN_CONTACT");
            put("notepad", "CLOUDBACKUP_OOBE_OPEN_NOTEPAD");
            put("backup_key", "CLOUDBACKUP_OOBE_OPEN_CLOUDBACKUP");
            put("uploadphotokey", "CLOUDBACKUP_OOBE_OPEN_CLOUDALBUM");
        }
    }

    /* renamed from: vn.c$c */
    public class c extends HashMap<String, String> {
        public c() {
            put("autosmslistkey", "CLOUDBACKUP_AUTOBACKUP_OPEN_SMS");
            put("autocallloglistkey", "CLOUDBACKUP_AUTOBACKUP_OPEN_CALLLOG");
            put("autorecordingkey", "CLOUDBACKUP_AUTOBACKUP_OPEN_RECORDING");
            put("autophonemanagerkey", "CLOUDBACKUP_AUTOBACKUP_OPEN_PHONEMANAGER");
            put("wlan", "CLOUDBACKUP_SYNC_OPEN_WLAN");
            put("calendar", "CLOUDBACKUP_SYNC_OPEN_CLENDAR");
            put("addressbook", "CLOUDBACKUP_OPEN_CONTACT");
            put("notepad", "CLOUDBACKUP_SYNC_OPEN_NOTEPAD");
            put("browser", "CLOUDBACKUP_SYNC_OPEN_BROWSER");
            put("backup_key", "CLOUDBACKUP_OPEN_CLOUDBACKUP");
        }
    }

    /* renamed from: vn.c$d */
    public class d extends HashMap<String, String> {
        public d() {
            put("autosmslistkey", "CLOUDBACKUP_AUTOBACKUP_CLOSE_SMS");
            put("autocallloglistkey", "CLOUDBACKUP_AUTOBACKU_CLOSEP_CALLLOG");
            put("autorecordingkey", "CLOUDBACKUP_AUTOBACKUP_CLOSE_RECORDING");
            put("autophonemanagerkey", "CLOUDBACKUP_AUTOBACKU_CLOSEP_PHONEMANAGER");
            put("wlan", "CLOUDBACKUP_SYNC_CLOSE_WLAN");
            put("calendar", "CLOUDBACKUP_SYNC_CLOSE_CLENDAR");
            put("addressbook", "CLOUDBACKUP_CLOSE_CONTACT");
            put("notepad", "CLOUDBACKUP_SYNC_CLOSE_NOTEPAD");
            put("browser", "CLOUDBACKUP_SYNC_CLOSE_BROWSER");
        }
    }

    /* renamed from: vn.c$e */
    public class e extends HashMap<Integer, String> {
        public e() {
            put(1, "CLOUDBACKUP_MIGRATE_FROM_OOBE");
            put(2, "CLOUDBACKUP_MIGRATE_FROM_SETTING");
            put(3, "CLOUDBACKUP_MIGRATE_FROM_HICLOUD");
        }
    }

    /* renamed from: vn.c$f */
    public enum f {
        ALL_SWITCH("all switch"),
        FULL_SWITCH("full switch"),
        BASE_SWITCH("base switch");


        /* renamed from: a */
        public final String f60690a;

        f(String str) {
            this.f60690a = str;
        }

        /* renamed from: b */
        public String m81136b() {
            return this.f60690a;
        }
    }

    /* renamed from: vn.c$g */
    public interface g {

        /* renamed from: a */
        public static final String f60691a;

        /* renamed from: b */
        public static final String f60692b;

        /* renamed from: c */
        public static final String f60693c;

        static {
            StringBuilder sb2 = new StringBuilder();
            String str = File.separator;
            sb2.append(str);
            sb2.append("analyze_cache_bi.txt");
            f60691a = sb2.toString();
            f60692b = str + "analyze_cache_om.txt";
            f60693c = str + "analyze_cache_uba.txt";
        }
    }

    /* renamed from: a */
    public static Map<String, String> m81128a() {
        return f60678a;
    }

    /* renamed from: b */
    public static String m81129b() {
        return f60684g;
    }

    /* renamed from: c */
    public static Map<Integer, String> m81130c() {
        return f60682e;
    }

    /* renamed from: d */
    public static Map<String, String> m81131d() {
        return f60681d;
    }

    /* renamed from: e */
    public static Map<String, String> m81132e() {
        return f60680c;
    }

    /* renamed from: f */
    public static String m81133f() {
        return f60683f;
    }

    /* renamed from: g */
    public static void m81134g(String str, String str2) {
        f60683f = str;
        f60684g = str2;
    }

    /* renamed from: h */
    public static void m81135h(String str) {
        f60685h = str;
    }
}
