package p327h5;

import android.net.Uri;
import com.huawei.android.backup.service.logic.calendar.CalendarConfigTable;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import java.util.HashMap;
import p699v4.C13347p;

/* renamed from: h5.c */
/* loaded from: classes.dex */
public class C10100c {

    /* renamed from: a */
    public static final Uri f49287a = C13347p.m80079b("content://browser");

    /* renamed from: b */
    public static final Uri f49288b = C13347p.m80079b("content://com.android.browser");

    /* renamed from: h5.c$a */
    public static class a {

        /* renamed from: a */
        public static final Uri f49289a = C13347p.m80080c(C10100c.m62910b(), "bookmarks");

        /* renamed from: b */
        public static final HashMap<String, Integer> f49290b;

        static {
            HashMap<String, Integer> map = new HashMap<>(24);
            f49290b = map;
            map.put("title", 1);
            map.put("url", 1);
            map.put("visits", 2);
            map.put(CallLogCons.DATE, 3);
            map.put("created", 3);
            map.put("description", 1);
            map.put("bookmark", 2);
            map.put("favicon", 4);
            map.put("thumbnail", 4);
            map.put("touch_icon", 4);
            map.put("user_entered", 2);
            map.put("folder", 2);
            map.put("parent", 2);
            map.put("position", 2);
            map.put("insert_after", 2);
            map.put(CalendarConfigTable.CalendarTable.Events.DELETED, 2);
            map.put("account_name", 1);
            map.put("account_type", 1);
            map.put("sourceid", 1);
            map.put("version", 2);
            map.put("modified", 2);
            map.put("dirty", 2);
            map.put("_id", 3);
            map.put("bookmark_type", 1);
        }

        /* renamed from: a */
        public static HashMap<String, Integer> m62911a() {
            return f49290b;
        }
    }

    /* renamed from: b */
    public static Uri m62910b() {
        return BackupConstant.LocalPhoneInfo.IS_I_VERSION ? f49288b : f49287a;
    }
}
