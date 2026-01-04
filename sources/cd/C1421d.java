package cd;

import android.content.Context;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.hicloud.connect.progress.Retry;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p837z9.C14163d;

/* renamed from: cd.d */
/* loaded from: classes3.dex */
public class C1421d {

    /* renamed from: a */
    public String f6172a;

    /* renamed from: b */
    public EnumC12999a f6173b;

    /* renamed from: c */
    public String f6174c;

    /* renamed from: d */
    public String f6175d;

    /* renamed from: e */
    public String f6176e;

    public C1421d(EnumC12999a enumC12999a, String str, String str2, String str3, String str4) {
        this.f6172a = str;
        this.f6173b = enumC12999a;
        this.f6174c = str2;
        this.f6175d = str3;
        this.f6176e = str4;
    }

    /* renamed from: c */
    public static Context m8267c() {
        return C0213f.m1377a();
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x0222  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8268a(com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset r24, java.lang.String r25, vc.C13404h r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cd.C1421d.m8268a(com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset, java.lang.String, vc.h, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* renamed from: b */
    public final void m8269b(int i10, C9721b c9721b, Retry retry, ICallback iCallback) throws C9721b {
        if (i10 == 1002) {
            throw c9721b;
        }
        switch (i10) {
            case 1104:
            case 1105:
            case 1106:
            case NotifyErr.NET_DISABLE_HMS_ERROR /* 1107 */:
                throw c9721b;
            default:
                if (!C0209d.m1208S0(m8267c())) {
                    throw c9721b;
                }
                retry.m16238g(c9721b.m60659c());
                if (!retry.m16232a() || iCallback.onStop()) {
                    throw c9721b;
                }
                return;
        }
    }

    /* renamed from: d */
    public final void m8270d(String str) {
        File fileM63437c = C10278a.m63437c(C10278a.m63442h(str));
        if (fileM63437c == null || fileM63437c.exists() || !fileM63437c.mkdirs()) {
            return;
        }
        C11839m.m70686d("SyncAssetDownloader", "syncV2 parent create success.");
    }

    /* renamed from: e */
    public final void m8271e() throws C9721b {
        if (C14163d.m84990g().m85009o()) {
            throw new C9721b(4009, "data migration error.", "onMigrateCheck");
        }
    }

    /* renamed from: f */
    public final Map<String, String> m8272f(Map<String, String> map, Asset asset, String str) {
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        map.put("migrate", asset.getProperties() == null ? "" : asset.getProperties().get("migrate"));
        map.put("usageName", str);
        return map;
    }
}
