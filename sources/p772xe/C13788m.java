package p772xe;

import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkScanResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p809yg.C13981a;

/* renamed from: xe.m */
/* loaded from: classes4.dex */
public class C13788m {

    /* renamed from: a */
    public final Map<String, FindNetworkScanResult> f61960a = new ConcurrentHashMap();

    /* renamed from: b */
    public final Map<String, C13779d> f61961b = new ConcurrentHashMap();

    /* renamed from: c */
    public long f61962c;

    /* renamed from: xe.m$a */
    public static class a {

        /* renamed from: a */
        public static final C13788m f61963a = new C13788m();
    }

    /* renamed from: c */
    public static C13788m m82779c() {
        return a.f61963a;
    }

    /* renamed from: a */
    public void m82780a() {
        C13981a.m83989i("TagScanManager", CloudBackupConstant.REPORT_TYPE_BASE_CLEAR_CACHE);
        this.f61960a.clear();
        this.f61961b.clear();
        this.f61962c = 0L;
    }

    /* renamed from: b */
    public void m82781b(String str) {
        this.f61960a.remove(str);
    }
}
