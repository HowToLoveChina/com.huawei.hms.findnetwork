package jm;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.SCompressionPolicy;
import com.huawei.android.hicloud.cloudbackup.bean.SCompressionPolicyEncoding;
import com.huawei.android.hicloud.cloudbackup.process.util.CompressionPolicyUtil;
import com.huawei.android.hicloud.utils.hole.HoleUtil;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.LinkedHashMap;
import mk.C11476b;
import p429kk.C11058a;
import p429kk.C11060c;
import p495nm.C11728i;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: jm.a */
/* loaded from: classes6.dex */
public abstract class AbstractC10898a {

    /* renamed from: a */
    public SCompressionPolicy f51732a;

    /* renamed from: b */
    public File f51733b;

    /* renamed from: c */
    public final String f51734c;

    /* renamed from: d */
    public AbstractC10898a f51735d;

    /* renamed from: e */
    public String f51736e;

    /* renamed from: f */
    public C11060c f51737f;

    /* renamed from: g */
    public LinkedHashMap<String, String> f51738g;

    /* renamed from: h */
    public C11728i f51739h;

    /* renamed from: i */
    public String f51740i;

    /* renamed from: j */
    public String f51741j;

    /* renamed from: k */
    public String f51742k;

    /* renamed from: l */
    public String f51743l = "";

    public AbstractC10898a(SCompressionPolicy sCompressionPolicy, String str, File file, String str2) {
        this.f51734c = str;
        this.f51732a = sCompressionPolicy;
        this.f51733b = file;
        this.f51736e = str2;
        this.f51742k = m65906b(str);
    }

    /* renamed from: a */
    public void m65905a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (C11835i.m70650n(fileM63442h)) {
            C11839m.m70688i("CompressHandler", "delete file by path:" + str + ",delete result:" + C11835i.m70642f(fileM63442h));
        }
    }

    /* renamed from: b */
    public final String m65906b(String str) {
        return C12583q.m75680p(0) + File.separator + str;
    }

    /* renamed from: c */
    public String m65907c() {
        return this.f51740i;
    }

    /* renamed from: d */
    public String m65908d() throws C9721b {
        String strM75650D = C12583q.m75650D(this.f51742k);
        C12590s0.m75820Y1(strM75650D);
        String str = strM75650D + C11476b.m68626h(C10279b.m63452a(this.f51733b));
        this.f51743l = str;
        return str;
    }

    /* renamed from: e */
    public abstract void mo65909e();

    /* renamed from: f */
    public void m65910f(String str) {
        this.f51738g = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C11060c c11060cM66626a = C11058a.m66626a(this.f51741j, str, C13452e.m80781L().m80971t0());
        this.f51737f = c11060cM66626a;
        c11060cM66626a.m66663s(this.f51734c);
        String str2 = "file = " + this.f51733b.getName() + " hash = " + this.f51736e + " length = " + this.f51733b.length();
        this.f51737f.m66638D(str2);
        this.f51738g.put("resourcePath", str2);
    }

    /* renamed from: g */
    public boolean m65911g() {
        try {
            String strM70648l = C11835i.m70648l(this.f51733b);
            double dM25923a = HoleUtil.m25923a(C10279b.m63452a(this.f51733b));
            long length = this.f51733b.length();
            C11839m.m70686d("CompressHandler", "check compress start,file:" + this.f51733b.getName() + ",currentFileRate is:" + dM25923a + ",fileExtension:" + strM70648l + ",fileSize:" + length);
            SCompressionPolicyEncoding encodingConfig = CompressionPolicyUtil.getEncodingConfig(this.f51732a, strM70648l, length);
            if (encodingConfig == null || !encodingConfig.getEncoding().equals(m65907c())) {
                return false;
            }
            return dM25923a > ((double) encodingConfig.getCompressionRate());
        } catch (Throwable th2) {
            C11839m.m70687e("CompressHandler", "sparse compress error:" + th2.getMessage());
            return false;
        }
    }

    /* renamed from: h */
    public void m65912h(C11728i c11728i) {
        this.f51739h = c11728i;
    }

    /* renamed from: i */
    public void m65913i(AbstractC10898a abstractC10898a) {
        this.f51735d = abstractC10898a;
    }

    /* renamed from: j */
    public void m65914j(String str) {
        this.f51740i = str;
    }

    /* renamed from: k */
    public void m65915k(String str) {
        this.f51741j = str;
    }

    /* renamed from: l */
    public boolean m65916l() {
        try {
            File file = this.f51733b;
            return !C12594t1.m75989n(file, file, this.f51734c).getHash().equals(this.f51736e);
        } catch (C9721b e10) {
            C11839m.m70687e("CompressHandler", "check srcFile hash failed:" + e10.getMessage());
            return true;
        }
    }

    public AbstractC10898a(String str, File file) {
        this.f51734c = str;
        this.f51733b = file;
        this.f51742k = m65906b(str);
    }
}
