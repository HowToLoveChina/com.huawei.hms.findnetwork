package p618rm;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.bean.BackupSpeedInfo;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.DeviceConditionReport;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Backup;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import fk.C9721b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import je.C10782d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p292fn.C9733f;
import p514o9.C11839m;
import p709vj.C13452e;
import p814yl.C14000c0;

/* renamed from: rm.t */
/* loaded from: classes6.dex */
public class C12592t {

    /* renamed from: g */
    public static final Object f57979g = new Object();

    /* renamed from: a */
    public final Map<String, BackupSpeedInfo> f57980a;

    /* renamed from: b */
    public volatile long f57981b;

    /* renamed from: c */
    public volatile int f57982c;

    /* renamed from: d */
    public volatile boolean f57983d;

    /* renamed from: e */
    public volatile boolean f57984e;

    /* renamed from: f */
    public String f57985f;

    /* renamed from: rm.t$a */
    public class a extends TypeToken<Map<String, BackupSpeedInfo>> {
        public a() {
        }
    }

    /* renamed from: rm.t$b */
    public static class b {

        /* renamed from: a */
        public static final C12592t f57987a = new C12592t(null);
    }

    public /* synthetic */ C12592t(a aVar) {
        this();
    }

    /* renamed from: g */
    public static C12592t m75950g() {
        return b.f57987a;
    }

    /* renamed from: m */
    public static /* synthetic */ CloudBackupV3Request m75951m(DeviceConditionReport deviceConditionReport, String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Backup.Device.ConditionReport conditionReport = cloudBackupV3Server.backup().device().conditionReport(deviceConditionReport);
        conditionReport.setBackupDeviceId(str);
        return conditionReport;
    }

    /* renamed from: b */
    public void m75952b() {
        C11839m.m70686d("CloudBackupSpeedUtil", "clear cache");
        m75953c();
        this.f57980a.clear();
        this.f57985f = "";
    }

    /* renamed from: c */
    public final void m75953c() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "com.huawei.hidisk.backup.upload_speed", 0);
        if (sharedPreferencesM1382b != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            editorEdit.remove("key_upload_speed");
            editorEdit.commit();
        }
    }

    /* renamed from: d */
    public void m75954d(String str, String str2) {
        C11839m.m70688i("CloudBackupSpeedUtil", "report condition");
        this.f57983d = C9733f.m60705z().m60716K();
        if (!this.f57983d) {
            C11839m.m70688i("CloudBackupSpeedUtil", "report condition bandwidthCollectSwitch = false");
            m75952b();
            return;
        }
        try {
            m75955e(str, str2, C13452e.m80781L().m80790C(), m75958i());
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupSpeedUtil", "report condition exception: " + e10.getMessage());
        }
        m75952b();
    }

    /* renamed from: e */
    public final void m75955e(String str, final String str2, String str3, List<Map<String, String>> list) throws C9721b {
        final DeviceConditionReport deviceConditionReport = new DeviceConditionReport();
        deviceConditionReport.setGradeCode(str3).setTransBandwidths(list);
        new C14000c0(new C14000c0.a() { // from class: rm.s
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C12592t.m75951m(deviceConditionReport, str2, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.conditionReport", str);
    }

    /* renamed from: f */
    public final Map<String, BackupSpeedInfo> m75956f() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "com.huawei.hidisk.backup.upload_speed", 0);
        if (sharedPreferencesM1382b != null) {
            String string = sharedPreferencesM1382b.getString("key_upload_speed", "");
            if (!TextUtils.isEmpty(string)) {
                return (Map) C12540b1.m75484b(string, new a().getType());
            }
        }
        return new HashMap();
    }

    /* renamed from: h */
    public String m75957h() {
        if (this.f57984e || TextUtils.isEmpty(this.f57985f)) {
            this.f57984e = false;
            this.f57985f = C10782d.m65634a().m65635b(C0213f.m1377a());
        }
        return this.f57985f;
    }

    /* renamed from: i */
    public final List<Map<String, String>> m75958i() {
        ArrayList arrayList = new ArrayList();
        Map<String, BackupSpeedInfo> mapM75956f = m75956f();
        if (mapM75956f != null) {
            Iterator<Map.Entry<String, BackupSpeedInfo>> it = mapM75956f.entrySet().iterator();
            while (it.hasNext()) {
                BackupSpeedInfo value = it.next().getValue();
                C11839m.m70686d("CloudBackupSpeedUtil", "getTransBandwidths: " + value.toString());
                HashMap map = new HashMap();
                map.put("backupSpeedId", value.getBackupSpeedId());
                map.put("backupSpeed", String.valueOf(m75959j(value.getTotalSize(), value.getTotalTime())));
                arrayList.add(map);
            }
        }
        C11839m.m70686d("CloudBackupSpeedUtil", "getTransBandwidths: " + arrayList);
        return arrayList;
    }

    /* renamed from: j */
    public final long m75959j(long j10, long j11) {
        if (j11 <= 0) {
            return 0L;
        }
        return (j10 / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / (j11 / 1000);
    }

    /* renamed from: k */
    public void m75960k() {
        this.f57983d = C9733f.m60705z().m60716K();
        C11839m.m70686d("CloudBackupSpeedUtil", "bandwidthCollectSwitch: " + this.f57983d);
    }

    /* renamed from: l */
    public boolean m75961l() {
        return this.f57983d;
    }

    /* renamed from: n */
    public void m75962n(String str, long j10) {
        long j11;
        synchronized (f57979g) {
            try {
                this.f57982c--;
                if (this.f57982c <= 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j12 = (jCurrentTimeMillis <= this.f57981b || this.f57981b <= 0) ? 0L : jCurrentTimeMillis - this.f57981b;
                    this.f57981b = 0L;
                    j11 = j12;
                } else {
                    j11 = 0;
                }
                C11839m.m70686d("CloudBackupSpeedUtil", "markUploadEnd: " + this.f57982c + ", size: " + j10 + ", time: " + j11);
                m75964p(str, j10, j11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: o */
    public void m75963o(String str) {
        synchronized (f57979g) {
            try {
                this.f57982c++;
                C11839m.m70686d("CloudBackupSpeedUtil", "markUploadStart: " + this.f57982c);
                if (this.f57982c == 1) {
                    this.f57981b = System.currentTimeMillis();
                }
                m75964p(str, 0L, 0L);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: p */
    public final void m75964p(String str, long j10, long j11) {
        BackupSpeedInfo backupSpeedInfo;
        Map<String, BackupSpeedInfo> mapM75956f;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("CloudBackupSpeedUtil", "backupSpeedId is empty");
            return;
        }
        if (this.f57980a.isEmpty() && (mapM75956f = m75956f()) != null && !mapM75956f.isEmpty()) {
            this.f57980a.putAll(mapM75956f);
            C11839m.m70686d("CloudBackupSpeedUtil", "restore cache from sp: " + mapM75956f.size());
        }
        BackupSpeedInfo backupSpeedInfo2 = new BackupSpeedInfo(str, j10, j11);
        if (this.f57980a.containsKey(str) && (backupSpeedInfo = this.f57980a.get(str)) != null) {
            if (j10 > 0) {
                backupSpeedInfo2.setTotalSize(backupSpeedInfo2.getTotalSize() + backupSpeedInfo.getTotalSize());
                backupSpeedInfo2.setTotalTime(backupSpeedInfo2.getTotalTime() + backupSpeedInfo.getTotalTime());
            } else {
                backupSpeedInfo2.setTotalSize(backupSpeedInfo.getTotalSize());
                backupSpeedInfo2.setTotalTime(backupSpeedInfo.getTotalTime());
            }
        }
        if (j10 > 0 || j11 > 0) {
            C11839m.m70686d("CloudBackupSpeedUtil", "totalSize: " + backupSpeedInfo2.getTotalSize() + ", totalTime: " + backupSpeedInfo2.getTotalTime());
        }
        this.f57980a.put(str, backupSpeedInfo2);
        m75965q(this.f57980a);
    }

    /* renamed from: q */
    public final void m75965q(Map<String, BackupSpeedInfo> map) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "com.huawei.hidisk.backup.upload_speed", 0);
        if (sharedPreferencesM1382b != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            editorEdit.putString("key_upload_speed", C12540b1.m75485c(map));
            editorEdit.commit();
        }
    }

    /* renamed from: r */
    public void m75966r() {
        this.f57984e = true;
    }

    public C12592t() {
        this.f57980a = new HashMap();
        this.f57981b = 0L;
        this.f57982c = 0;
        this.f57984e = false;
        this.f57985f = "";
    }
}
