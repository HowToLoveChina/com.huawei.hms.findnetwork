package dk;

import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: dk.c */
/* loaded from: classes6.dex */
public class C9162c {

    /* renamed from: a */
    public static final HashSet<String> f45956a = new a();

    /* renamed from: b */
    public static final HashSet<String> f45957b = new b();

    /* renamed from: c */
    public static final HashSet<String> f45958c = new c();

    /* renamed from: dk.c$a */
    public class a extends HashSet<String> {
        public a() {
            add("campaignNotify_7");
            add("campaignNotify_8");
            add("campaignNotify_9");
        }
    }

    /* renamed from: dk.c$b */
    public class b extends HashSet<String> {
        public b() {
            add("ADL_Enough4Gift");
        }
    }

    /* renamed from: dk.c$c */
    public class c extends HashSet<String> {
        public c() {
            add(NotifyConstants.NotificationType.CLOUDPHOTO_SYNC_SPACE_INSUFFICIENT);
            add(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
        }
    }

    /* renamed from: a */
    public static Set<String> m57580a() {
        return f45956a;
    }

    /* renamed from: b */
    public static Set<String> m57581b() {
        return f45957b;
    }

    /* renamed from: c */
    public static Set<String> m57582c() {
        return f45958c;
    }

    /* renamed from: d */
    public static boolean m57583d(List<String> list) {
        return list != null && list.size() > 0 && list.size() == 1 && m57581b().contains(list.get(0));
    }
}
