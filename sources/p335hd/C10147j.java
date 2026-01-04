package p335hd;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import gp.C10028c;
import io.C10582a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p015ak.C0214f0;
import p020ap.C1006a;
import p336he.C10155f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: hd.j */
/* loaded from: classes3.dex */
public class C10147j extends AbstractC12367d {

    /* renamed from: a */
    public final Context f49444a;

    /* renamed from: b */
    public final ArrayList<String> f49445b;

    /* renamed from: c */
    public final String f49446c;

    /* renamed from: d */
    public final String f49447d;

    /* renamed from: hd.j$a */
    public static class a implements C10582a.c {

        /* renamed from: a */
        public Context f49448a;

        public a(Context context) {
            this.f49448a = context;
        }

        @Override // io.C10582a.c
        public void onResult(int i10) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f49448a, "sync_contact_spfile", 0);
            if (sharedPreferencesM1382b != null) {
                if (i10 != 0) {
                    sharedPreferencesM1382b.edit().putBoolean("register_switch_failed", true).commit();
                } else {
                    sharedPreferencesM1382b.edit().putBoolean("register_switch_failed", false).commit();
                }
            }
        }
    }

    public C10147j(Context context, ArrayList<String> arrayList, String str, String str2) {
        this.f49444a = context;
        this.f49445b = arrayList;
        this.f49446c = str;
        this.f49447d = str2;
    }

    /* renamed from: c */
    public final Map<String, String> m63207c() throws Throwable {
        C10028c c10028cM62183d0 = C10028c.m62183d0(this.f49444a);
        HashMap map = new HashMap();
        if (C10155f.m63286j(this.f49444a)) {
            map.put("sync.type", "AUTO");
        } else {
            map.put("sync.type", "DISABLED");
        }
        Iterator<String> it = this.f49445b.iterator();
        while (it.hasNext()) {
            String next = it.next();
            m63208d(map, next, "atlas".equals(next) ? C1006a.m5936k().m5975v(this.f49444a) : c10028cM62183d0.m62388s(next) ? "AUTO" : "DISABLED");
        }
        return map;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        ArrayList<String> arrayList = this.f49445b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        C11839m.m70688i("SettingSyncTask", "Register switch status operationType: " + this.f49446c + ", traceId: " + this.f49447d);
        new C10582a(this.f49447d).m64928b0(m63207c(), "1", new a(this.f49444a));
    }

    /* renamed from: d */
    public final void m63208d(Map<String, String> map, String str, String str2) throws Throwable {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        C11839m.m70688i("SettingSyncTask", "syncType: " + str + ", switch: " + str2);
        str.hashCode();
        switch (str) {
            case "addressbook":
                map.put("sync.contact", str2);
                break;
            case "calendar":
                map.put("sync.calendar", str2);
                break;
            case "wlan":
                map.put("sync.wlan", str2);
                break;
            case "atlas":
                map.put("sync.atlas", str2);
                break;
            case "browser":
                map.put("sync.browser", str2);
                break;
            case "notepad":
                map.put("sync.note", str2);
                break;
            default:
                SyncConfigService serviceById = new SyncConfigOperator().getServiceById(str);
                if (serviceById != null) {
                    int recordIndex = serviceById.getRecordIndex();
                    C11839m.m70688i("SettingSyncTask", "syncType: " + str + ", index = " + recordIndex);
                    map.put("sync." + recordIndex + "." + str, str2);
                    break;
                }
                break;
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }
}
