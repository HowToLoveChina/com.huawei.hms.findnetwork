package p711vl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.bean.DisperseRule;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreRetry;
import com.huawei.android.hicloud.cloudbackup.bean.ThermalControl;
import com.huawei.android.hicloud.cloudbackup.bean.ThermalControlGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mk.C11477c;
import p015ak.C0214f0;
import p514o9.C11839m;

/* renamed from: vl.d */
/* loaded from: classes6.dex */
public class C13464d {

    /* renamed from: a */
    public Context f60643a;

    /* renamed from: b */
    public SharedPreferences f60644b;

    /* renamed from: vl.d$b */
    public static class b extends TypeToken<List<DisperseRule>> {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: vl.d$c */
    public static class c {

        /* renamed from: a */
        public static C13464d f60645a = new C13464d();
    }

    public /* synthetic */ C13464d(a aVar) {
        this();
    }

    /* renamed from: f */
    public static C13464d m81030f(Context context) {
        if (c.f60645a.f60644b == null || c.f60645a.f60643a == null) {
            c.f60645a.m81044o(context);
        }
        return c.f60645a;
    }

    /* renamed from: a */
    public void m81031a() {
        SharedPreferences sharedPreferences = this.f60644b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    /* renamed from: b */
    public boolean m81032b(String str) {
        SharedPreferences sharedPreferences = this.f60644b;
        if (sharedPreferences != null) {
            return sharedPreferences.contains(str);
        }
        return false;
    }

    /* renamed from: c */
    public boolean m81033c(String str) {
        SharedPreferences sharedPreferences = this.f60644b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, false);
        }
        return false;
    }

    /* renamed from: d */
    public List<DisperseRule> m81034d() {
        try {
            List<DisperseRule> list = (List) new Gson().fromJson(m81039j("disperseRule", ""), new b().getType());
            if (list != null) {
                return list;
            }
        } catch (Exception e10) {
            C11839m.m70688i("CloudBackupDsSettingSp", "json error " + e10.toString());
        }
        return new ArrayList();
    }

    /* renamed from: e */
    public int m81035e() {
        int iM81037h = (int) m81037h("backupCycle");
        int iM81036g = m81036g("backup_frequency", 0);
        return iM81036g == 0 ? iM81037h : iM81036g;
    }

    /* renamed from: g */
    public int m81036g(String str, int i10) {
        SharedPreferences sharedPreferences = this.f60644b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, i10);
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* renamed from: h */
    public long m81037h(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -2000153843:
                if (str.equals("delayedstarttime")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1738791107:
                if (str.equals("notifycycle")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1309891091:
                if (str.equals("checkInterval")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1174977651:
                if (str.equals("retryInterval")) {
                    c10 = 3;
                    break;
                }
                break;
            case -376241649:
                if (str.equals("timeAdvanced")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1094024260:
                if (str.equals("backupCycle")) {
                    c10 = 5;
                    break;
                }
                break;
            case 1107436599:
                if (str.equals("checkIntervalMax")) {
                    c10 = 6;
                    break;
                }
                break;
            case 1346628780:
                if (str.equals("lastnotifytime")) {
                    c10 = 7;
                    break;
                }
                break;
            case 1577510565:
                if (str.equals("lastbackuptime")) {
                    c10 = '\b';
                    break;
                }
                break;
            case 1910396331:
                if (str.equals("breakedtime")) {
                    c10 = '\t';
                    break;
                }
                break;
        }
        long jCurrentTimeMillis = 30;
        switch (c10) {
            case 0:
                jCurrentTimeMillis = 600000;
                break;
            case 1:
                jCurrentTimeMillis = 14;
                break;
            case 2:
                jCurrentTimeMillis = 2;
                break;
            case 3:
            case 6:
                break;
            case 4:
                jCurrentTimeMillis = 20;
                break;
            case 5:
                jCurrentTimeMillis = 7;
                break;
            case 7:
            case '\b':
                jCurrentTimeMillis = System.currentTimeMillis();
                break;
            case '\t':
                jCurrentTimeMillis = 300000;
                break;
            default:
                jCurrentTimeMillis = 0;
                break;
        }
        SharedPreferences sharedPreferences = this.f60644b;
        return sharedPreferences != null ? sharedPreferences.getLong(str, jCurrentTimeMillis) : jCurrentTimeMillis;
    }

    /* renamed from: i */
    public RestoreRetry m81038i() {
        RestoreRetry restoreRetry;
        try {
            restoreRetry = (RestoreRetry) new Gson().fromJson(m81039j("restoreRetry", ""), RestoreRetry.class);
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupDsSettingSp", "getRestoreRetry error: " + e10.toString());
            restoreRetry = null;
        }
        if (restoreRetry != null) {
            return restoreRetry;
        }
        RestoreRetry restoreRetry2 = new RestoreRetry();
        C11839m.m70689w("CloudBackupDsSettingSp", "getRestoreRetry restoreRetry is null");
        return restoreRetry2;
    }

    /* renamed from: j */
    public String m81039j(String str, String str2) {
        SharedPreferences sharedPreferences = this.f60644b;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : "";
    }

    /* renamed from: k */
    public ThermalControl m81040k() {
        try {
            ThermalControl thermalControl = (ThermalControl) new Gson().fromJson(m81039j("thermalControl", ""), ThermalControl.class);
            if (thermalControl != null) {
                return thermalControl;
            }
        } catch (Exception e10) {
            C11839m.m70688i("CloudBackupDsSettingSp", "json error " + e10.toString());
        }
        return new ThermalControl();
    }

    /* renamed from: l */
    public ThermalControlGroup m81041l() {
        try {
            ThermalControlGroup thermalControlGroup = (ThermalControlGroup) new Gson().fromJson(m81039j("thermalControlGroup", ""), ThermalControlGroup.class);
            if (thermalControlGroup != null) {
                return thermalControlGroup;
            }
            return null;
        } catch (Exception e10) {
            C11839m.m70688i("CloudBackupDsSettingSp", "json error " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: m */
    public String m81042m() {
        SharedPreferences sharedPreferences = this.f60644b;
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString("user_id_encrypt", "");
        return !TextUtils.isEmpty(string) ? C11477c.m68633c(string) : this.f60644b.getString("user_id", "");
    }

    /* renamed from: n */
    public String m81043n(String str) {
        SharedPreferences sharedPreferences = this.f60644b;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }

    /* renamed from: o */
    public final void m81044o(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f60643a = applicationContext;
        this.f60644b = C0214f0.m1382b(applicationContext, "cloudbackupregister", 0);
    }

    /* renamed from: p */
    public void m81045p(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f60644b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, z10);
            editorEdit.commit();
        }
    }

    /* renamed from: q */
    public void m81046q(String str, int i10) {
        SharedPreferences sharedPreferences = this.f60644b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt(str, i10);
            editorEdit.commit();
        }
    }

    /* renamed from: r */
    public void m81047r(HashMap<String, Integer> map) {
        SharedPreferences sharedPreferences = this.f60644b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                editorEdit.putInt(entry.getKey(), entry.getValue().intValue());
            }
            editorEdit.commit();
        }
    }

    /* renamed from: s */
    public void m81048s(String str, long j10) {
        SharedPreferences sharedPreferences = this.f60644b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong(str, j10);
            editorEdit.commit();
        }
    }

    /* renamed from: t */
    public void m81049t(String str, String str2) {
        SharedPreferences sharedPreferences = this.f60644b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(str, str2);
            editorEdit.commit();
        }
    }

    /* renamed from: u */
    public void m81050u(String str, String str2) {
        SharedPreferences sharedPreferences = this.f60644b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(str, str2);
            editorEdit.commit();
        }
    }

    public C13464d() {
        this.f60643a = null;
        this.f60644b = null;
    }
}
