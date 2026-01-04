package no;

import android.os.Build;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hicloud.request.okhttp.callback.AbstractC4992a;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Map;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import p015ak.C0209d;
import p015ak.C0228m0;
import p336he.C10160k;
import p514o9.C11829c;
import p514o9.C11839m;
import p549p9.C12122a;
import p709vj.C13452e;

/* renamed from: no.a */
/* loaded from: classes6.dex */
public class C11738a extends AbstractC4992a<Void> {

    /* renamed from: a */
    public C12122a f54289a;

    /* renamed from: b */
    public String f54290b;

    /* renamed from: c */
    public long f54291c;

    /* renamed from: d */
    public Map<String, String> f54292d;

    /* renamed from: e */
    public String f54293e;

    public C11738a(String str, long j10, C12122a c12122a, String str2) {
        this.f54289a = c12122a;
        this.f54290b = str;
        this.f54291c = j10;
        this.f54293e = str2;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(C11918e0.a aVar) {
        aVar.m71578e("Range", "bytes=" + this.f54291c + "-");
        aVar.m71578e("x-hw-unique-trace-id", C10160k.m63341b("04015"));
        Map<String, String> map = this.f54292d;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.m71574a(entry.getKey(), entry.getValue());
            }
        }
        if (C10028c.m62182c0().m62420y1()) {
            aVar.m71574a("x-hw-trace-id", this.f54293e);
            aVar.m71574a("x-hw-country-code", C13452e.m80781L().m80942m());
            aVar.m71574a("x-hw-device-type", C0209d.m1209S1(C13452e.m80781L().m80970t()));
            aVar.m71574a("x-hw-device-id", C0209d.m1209S1(C13452e.m80781L().m80954p()));
            aVar.m71574a("x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
            aVar.m71574a("x-hw-os-brand", C0209d.m1276l0());
            aVar.m71574a(JsbMapKeyNames.H5_USER_ID, C13452e.m80781L().m80971t0());
            aVar.m71574a("User-Agent", "com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + C11829c.f54755a + ") HMS/2.6.3.306 (10055832)");
        }
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public Void onResponse(C11922g0 c11922g0) throws Throwable {
        InputStream inputStreamM71632s = c11922g0.m71595s().m71632s();
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFileM63449o = C10278a.m63449o(this.f54290b, "rw");
            try {
                randomAccessFileM63449o.seek(this.f54291c);
                this.f54289a.mo17784f(this.f54291c);
                byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
                boolean zMo17782d = this.f54289a.mo17782d();
                int i10 = inputStreamM71632s.read(bArr);
                while (i10 != -1 && !zMo17782d) {
                    randomAccessFileM63449o.write(bArr, 0, i10);
                    this.f54289a.m72686c(i10);
                    i10 = inputStreamM71632s.read(bArr);
                    zMo17782d = this.f54289a.mo17782d();
                }
                this.f54289a.mo17783e(true);
                if (zMo17782d) {
                    cancel();
                    throw new C9721b(1002, "net disable or canceled by user", "download");
                }
                try {
                    inputStreamM71632s.close();
                } catch (IOException unused) {
                    C11839m.m70689w("DownloadCallback", "inputStream close exception.");
                }
                try {
                    randomAccessFileM63449o.close();
                } catch (IOException unused2) {
                    C11839m.m70689w("DownloadCallback", "randomAccessFile close exception.");
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFileM63449o;
                if (inputStreamM71632s != null) {
                    try {
                        inputStreamM71632s.close();
                    } catch (IOException unused3) {
                        C11839m.m70689w("DownloadCallback", "inputStream close exception.");
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    C11839m.m70689w("DownloadCallback", "randomAccessFile close exception.");
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
