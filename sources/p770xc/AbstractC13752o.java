package p770xc;

import android.content.SharedPreferences;
import android.os.Message;
import com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo;
import com.huawei.android.hicloud.sync.syncutil.C2973b;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import je.C10800n;
import md.C11439b;
import p015ak.C0214f0;
import p514o9.C11839m;

/* renamed from: xc.o */
/* loaded from: classes3.dex */
public abstract class AbstractC13752o extends C11439b<Boolean> {

    /* renamed from: p */
    public SharedPreferences f61831p;

    /* renamed from: q */
    public String f61832q;

    /* renamed from: r */
    public String f61833r;

    /* renamed from: s */
    public String f61834s = null;

    /* renamed from: t */
    public String f61835t = null;

    /* renamed from: u */
    public String f61836u = null;

    /* renamed from: v */
    public String f61837v = null;

    /* renamed from: w */
    public ConcurrentHashMap<String, Boolean> f61838w;

    /* renamed from: x */
    public ReportSyncEndInfo f61839x;

    /* renamed from: A */
    public void m82615A(String str, boolean z10, int i10, LinkedHashMap<String, String> linkedHashMap) {
        if ("wlan".equals(str) || "atlas".equals(str)) {
            C11839m.m70689w("SyncBaseTask", str + " not support OM retry");
            return;
        }
        if (m82616y(z10, i10)) {
            C2973b.m17825m(this.f53282a, str, 1, 0L, 0, false);
            mo82568z(linkedHashMap, 1);
        } else {
            mo82568z(linkedHashMap, 0);
            C2973b.m17825m(this.f53282a, str, 0, 0L, 0, false);
        }
    }

    @Override // md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61832q = "03001";
        this.f61834s = c10800nM68549a.m65740e("synctype", "");
        this.f61835t = c10800nM68549a.m65740e("datatype", "");
        this.f61833r = c10800nM68549a.m65740e("trace_id_key", "");
        this.f61836u = c10800nM68549a.m65740e("sync_moudle_package_name", "");
        this.f61837v = c10800nM68549a.m65740e("sync_module_real_package_name", "");
        if (c10800nM68549a.m65739d("sync_report_end_info") != null) {
            this.f61839x = (ReportSyncEndInfo) c10800nM68549a.m65739d("sync_report_end_info");
        }
        if (c10800nM68549a.m65739d("sync_flow_control_effect_flag") != null) {
            this.f61838w = (ConcurrentHashMap) c10800nM68549a.m65739d("sync_flow_control_effect_flag");
        }
    }

    @Override // md.AbstractC11438a
    /* renamed from: h */
    public void mo66491h() {
        super.mo66491h();
        this.f61831p = C0214f0.m1382b(this.f53282a, "sync_contact_spfile", 0);
    }

    @Override // md.C11439b
    /* renamed from: r */
    public boolean mo66493r(Message message) {
        super.mo66493r(message);
        return false;
    }

    /* renamed from: y */
    public boolean m82616y(boolean z10, int i10) {
        return (z10 || i10 == 0 || i10 == 14 || i10 == 20 || i10 == 2012 || i10 == 30001 || i10 == 40001 || i10 == 40100 || i10 == 50001 || i10 == 70001 || i10 == 90001 || i10 == 10002 || i10 == 10003) ? false : true;
    }

    /* renamed from: z */
    public void mo82568z(LinkedHashMap<String, String> linkedHashMap, int i10) {
    }
}
