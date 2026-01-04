package p252e9;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.huawei.android.hicloud.cloudbackup.bean.CBState;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.common.manager.DeviceSwitchQueryCallback;
import com.huawei.android.hicloud.task.simple.C3041i;
import com.huawei.android.hicloud.task.simple.C3101z;
import com.huawei.android.p073ds.R$string;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import ne.C11667a;
import p015ak.C0213f;
import p514o9.C11839m;
import p616rk.C12515a;

/* renamed from: e9.i */
/* loaded from: classes3.dex */
public class C9432i {

    /* renamed from: e */
    public static final C9432i f47125e = new C9432i();

    /* renamed from: f */
    public static final Object f47126f = new Object();

    /* renamed from: g */
    public static final Object f47127g = new Object();

    /* renamed from: h */
    public static final Object f47128h = new Object();

    /* renamed from: a */
    public Map<String, Map<String, String>> f47129a = new HashMap();

    /* renamed from: b */
    public Random f47130b = new Random();

    /* renamed from: c */
    public List<String> f47131c = new ArrayList();

    /* renamed from: d */
    public Map<String, String> f47132d = new HashMap();

    /* renamed from: e9.i$a */
    public static class a implements DeviceSwitchQueryCallback {
        @Override // com.huawei.android.hicloud.common.manager.DeviceSwitchQueryCallback
        /* renamed from: a */
        public void mo15609a(Map<String, String> map) {
            C11839m.m70688i("DeviceSwitchQueryManager", "onDeviceQueryFinish");
            C9432i.m59149j().m59162q(map);
            C9432i.m59149j().m59161p(map);
            if (C9432i.m59149j().m59159n()) {
                C9432i.m59149j().m59158m();
            }
        }
    }

    /* renamed from: j */
    public static C9432i m59149j() {
        return f47125e;
    }

    /* renamed from: d */
    public final void m59150d(String str) {
        synchronized (f47127g) {
            try {
                Iterator<String> it = this.f47131c.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(str)) {
                        return;
                    }
                }
                C11839m.m70688i("DeviceSwitchQueryManager", "addModule, moduleName=" + str);
                this.f47131c.add(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public void m59151e() {
        synchronized (f47126f) {
            this.f47132d.clear();
        }
        synchronized (f47127g) {
            this.f47131c.clear();
        }
        synchronized (f47128h) {
            this.f47129a.clear();
        }
    }

    /* renamed from: f */
    public final String m59152f(Long l10) throws Resources.NotFoundException {
        C11839m.m70688i("DeviceSwitchQueryManager", "getBackupFinishContent");
        String strM69662d = C11667a.m69662d(C0213f.m1377a(), l10.longValue());
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        C11839m.m70688i("DeviceSwitchQueryManager", "lastBackupSuccessTime time=" + strM69662d);
        return (l10.longValue() == 0 || !zM62388s) ? C0213f.m1377a().getString(R$string.cloud_backup_explain) : strM69662d;
    }

    /* renamed from: g */
    public final String m59153g(int i10) {
        return i10 == 1 ? C0213f.m1377a().getString(R$string.canceling_cloudbackup) : i10 == 2 ? C0213f.m1377a().getString(R$string.canceling_cloudrestore) : "";
    }

    /* renamed from: h */
    public String m59154h() {
        CBState cloudBackupStateSynchronous = CloudBackupService.getInstance().getCloudBackupStateSynchronous();
        int status = cloudBackupStateSynchronous.getStatus();
        CacheTask.State state = cloudBackupStateSynchronous.getState();
        C11839m.m70688i("DeviceSwitchQueryManager", "refreshCloudBackupStatus backupStatus=" + status + ", currentState=" + state);
        if (status == 1) {
            return C0213f.m1377a().getString(R$string.general_append_handling2, CacheTask.State.CANCEL.equals(state) ? m59153g(1) : C0213f.m1377a().getString(R$string.main_cloudbackuping));
        }
        if (status != 2) {
            return status != 3 ? m59152f(Long.valueOf(cloudBackupStateSynchronous.getLastTimeStamp())) : C0213f.m1377a().getString(R$string.main_restore_paused);
        }
        return C0213f.m1377a().getString(R$string.general_append_handling2, CacheTask.State.CANCEL.equals(state) ? m59153g(2) : C0213f.m1377a().getString(R$string.restoring_data));
    }

    /* renamed from: i */
    public String m59155i() {
        return m59154h();
    }

    /* renamed from: k */
    public String m59156k(String str) {
        return "cloudbackup".equals(str) ? m59155i() : "phonefinder".equals(str) ? C0213f.m1377a().getString(R$string.phone_findback_tips) : "";
    }

    /* renamed from: l */
    public Map<String, String> m59157l(String str) {
        synchronized (f47128h) {
            try {
                if (this.f47129a.containsKey(str)) {
                    return this.f47129a.get(str);
                }
                C11839m.m70688i("DeviceSwitchQueryManager", "getQueryResult, not requestId found, requestId=" + str);
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public final void m59158m() {
        synchronized (f47127g) {
            try {
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    C11839m.m70687e("DeviceSwitchQueryManager", "notifyObserver context null");
                    return;
                }
                ContentResolver contentResolver = contextM1377a.getContentResolver();
                if (contentResolver == null) {
                    C11839m.m70687e("DeviceSwitchQueryManager", "notifyObserver resolver null");
                    return;
                }
                Uri uri = null;
                for (String str : this.f47131c) {
                    if (str.equals("cloudbackup")) {
                        uri = Uri.parse("content://com.huawei.android.hicloud.provider/query_cloud_backup_status");
                    } else if (str.equals("phonefinder")) {
                        uri = Uri.parse("content://com.huawei.android.hicloud.provider/query_phone_finder_status");
                    }
                    if (uri != null) {
                        C11839m.m70688i("DeviceSwitchQueryManager", "notifyObserver uri is not null");
                        contentResolver.notifyChange(uri, null);
                    }
                }
                this.f47131c.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: n */
    public final boolean m59159n() {
        boolean z10;
        synchronized (f47126f) {
            z10 = this.f47132d.size() == 0;
        }
        return z10;
    }

    /* renamed from: o */
    public String m59160o(String str, String str2, String str3) {
        C11839m.m70688i("DeviceSwitchQueryManager", "queryDeviceSwitchStatus moduleName:" + str);
        m59150d(str);
        String strValueOf = String.valueOf(this.f47130b.nextInt(10000));
        this.f47132d.put(strValueOf, str2);
        if ("phonefinder".equals(str)) {
            C12515a.m75110o().m75172d(new C3041i(strValueOf, str2, str3, new a()));
        } else {
            C3101z c3101z = new C3101z(new a());
            c3101z.m18440c(str2, strValueOf, str3);
            C12515a.m75110o().m75172d(c3101z);
        }
        C11839m.m70688i("DeviceSwitchQueryManager", "queryDeviceSwitchStatus, requestId=" + strValueOf);
        return strValueOf;
    }

    /* renamed from: p */
    public void m59161p(Map<String, String> map) {
        C11839m.m70688i("DeviceSwitchQueryManager", "updateQuering");
        synchronized (f47126f) {
            this.f47132d.remove(map.get("requestId"));
        }
    }

    /* renamed from: q */
    public final void m59162q(Map<String, String> map) {
        C11839m.m70688i("DeviceSwitchQueryManager", "updateResult");
        synchronized (f47128h) {
            this.f47129a.put(map.get("requestId"), map);
        }
    }
}
