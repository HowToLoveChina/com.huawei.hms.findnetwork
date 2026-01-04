package com.huawei.location.crowdsourcing;

import android.os.Build;
import as.C1016d;
import br.InterfaceC1273a;
import com.google.gson.JsonSyntaxException;
import com.huawei.location.activity.C6738e;
import com.huawei.location.crowdsourcing.Config;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import es.C9542g;
import es.C9554s;
import fr.C9765b;
import fr.C9766c;
import java.io.File;
import java.util.TreeMap;

/* renamed from: com.huawei.location.crowdsourcing.b */
/* loaded from: classes8.dex */
public final class C6746b implements InterfaceC1273a {

    /* renamed from: a */
    public C9765b f31271a;

    /* renamed from: b */
    public C9765b f31272b;

    /* renamed from: c */
    public C9766c f31273c = C9766c.f48048d;

    /* renamed from: d */
    public final TreeMap f31274d = new TreeMap();

    /* renamed from: e */
    public final File f31275e;

    public C6746b(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        this.f31275e = new File(C6738e.m38291a(sb2, File.separator, "crowdsourcing_upload"));
        m38327b();
    }

    /* renamed from: b */
    private void m38327b() {
        String strM38303i = Config.C6744b.f31261a.m38303i();
        if (!strM38303i.isEmpty()) {
            C1016d.m6186f("Uploader", "read patch policy");
            try {
                this.f31273c = (C9766c) C9542g.m59588a().fromJson(strM38303i, C9766c.class);
            } catch (JsonSyntaxException unused) {
                C1016d.m6183c("Uploader", "read patch policy failed");
            }
        }
        if (this.f31273c == null) {
            this.f31273c = C9766c.f48048d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0139 A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m38328c() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.C6746b.m38328c():void");
    }

    @Override // br.InterfaceC1273a
    /* renamed from: a */
    public final void mo7544a() {
        C1016d.m6190j("Uploader", "Stop");
    }

    /* renamed from: d */
    public final boolean m38329d() {
        String str;
        File file = this.f31275e;
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file.canWrite()) {
                    str = "folder can not write";
                    C1016d.m6183c("FileUtil", str);
                    C1016d.m6183c("Uploader", "regularize folder failed");
                    return false;
                }
            } else if (!file.delete()) {
                str = "folder delete failed";
                C1016d.m6183c("FileUtil", str);
                C1016d.m6183c("Uploader", "regularize folder failed");
                return false;
            }
        }
        if (!this.f31275e.exists() && !this.f31275e.mkdir()) {
            C1016d.m6183c("Uploader", "create folder failed");
            return false;
        }
        this.f31274d.put(FaqConstants.FAQ_SHASN, Config.C6744b.f31261a.m38300f());
        this.f31274d.put(FaqConstants.FAQ_MODEL, Build.PRODUCT);
        this.f31274d.put(FaqConstants.FAQ_ROMVERSION, C9554s.m59654i());
        this.f31274d.put(FaqConstants.FAQ_EMUIVERSION, C9554s.m59649d());
        this.f31274d.put(FaqConstants.FAQ_OSVERSION, C9554s.m59647b());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0266, code lost:
    
        r0 = "AesGcm.decrypt Exception";
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02e4  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m38330e(java.lang.String r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 752
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.C6746b.m38330e(java.lang.String):boolean");
    }
}
