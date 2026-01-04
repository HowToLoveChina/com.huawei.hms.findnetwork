package jm;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.SCompressionPolicy;
import com.huawei.android.hicloud.cloudbackup.bean.SCompressionPolicyEncoding;
import com.huawei.android.hicloud.cloudbackup.process.util.CompressionPolicyUtil;
import com.huawei.android.hicloud.utils.hole.HoleUtil;
import com.huawei.cloud.base.util.C4658z;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import mk.C11476b;
import p015ak.C0213f;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p746wn.C13622a;
import p815ym.AbstractC14026a;

/* renamed from: jm.c */
/* loaded from: classes6.dex */
public class C10900c extends AbstractC10898a {

    /* renamed from: m */
    public boolean f51745m;

    /* renamed from: n */
    public String f51746n;

    public C10900c(SCompressionPolicy sCompressionPolicy, String str, File file, String str2) {
        super(sCompressionPolicy, str, file, str2);
        this.f51745m = true;
        m65914j("sparse");
    }

    /* renamed from: o */
    public static boolean m65919o(double d10) {
        double dNextDouble = ThreadLocalRandom.current().nextDouble();
        C11839m.m70686d("SpotCheckHandler", "generate probability:" + dNextDouble + ",spotCheckRate:" + d10);
        return dNextDouble < d10;
    }

    @Override // jm.AbstractC10898a
    /* renamed from: e */
    public void mo65909e() {
        SCompressionPolicy sCompressionPolicy = this.f51732a;
        if (sCompressionPolicy == null || AbstractC14026a.m84159a(sCompressionPolicy.getProcessStep())) {
            C11839m.m70688i("SpotCheckHandler", "compressionPolicy or processStep is null.");
            return;
        }
        m65920m();
        if (!this.f51732a.getProcessStep().contains("compress")) {
            C11839m.m70688i("SpotCheckHandler", "not contain compress step,delete spotCheck file.");
            m65905a(this.f51743l);
        } else if (this.f51745m) {
            this.f51735d.mo65909e();
        }
    }

    /* renamed from: m */
    public final void m65920m() {
        double dM25923a;
        SCompressionPolicyEncoding encodingConfig;
        String strM65908d;
        if (!this.f51732a.getProcessStep().contains("spotCheck")) {
            C11839m.m70688i("SpotCheckHandler", "om config not contain spotCheck");
            return;
        }
        if (this.f51739h == null) {
            C11839m.m70687e("SpotCheckHandler", "mCompressParams is null.");
            return;
        }
        String str = "";
        HashMap map = new HashMap();
        try {
            m65910f("spotCheck");
            String strM70648l = C11835i.m70648l(this.f51733b);
            dM25923a = HoleUtil.m25923a(C10279b.m63452a(this.f51733b));
            long length = this.f51733b.length();
            C11839m.m70686d("SpotCheckHandler", "spotCheck start,file:" + this.f51733b.getName() + ",currentFileRate is:" + dM25923a + ",fileExtension:" + strM70648l + ",fileSize:" + length);
            encodingConfig = CompressionPolicyUtil.getEncodingConfig(this.f51732a, strM70648l, length);
            strM65908d = m65908d();
            this.f51743l = strM65908d;
        } catch (Throwable th2) {
            try {
                str = "spotCheck error:" + th2.getMessage();
                this.f51745m = false;
                C11839m.m70687e("SpotCheckHandler", str);
                m65905a(this.f51743l);
                if (!TextUtils.isEmpty(str)) {
                }
            } finally {
                if (!TextUtils.isEmpty(str)) {
                    this.f51737f.m66665u("113_1049");
                    this.f51737f.m66635A(str);
                    map.put("resourcePath", C10279b.m63452a(this.f51733b));
                    this.f51738g.put("spotCheckResult", str);
                    UBAAnalyze.m29947H("CKC", "action_file_spot_check_result", this.f51738g);
                    C13622a.m81969o(C0213f.m1377a(), this.f51737f, map);
                }
                m65905a(this.f51746n);
            }
        }
        if (TextUtils.isEmpty(strM65908d)) {
            C11839m.m70687e("SpotCheckHandler", "getZipDestFilePath error,path is empty");
            return;
        }
        if (encodingConfig == null) {
            C11839m.m70689w("SpotCheckHandler", "encoding is null,no need spotCheck");
            this.f51745m = false;
            m65905a(this.f51743l);
            if (!TextUtils.isEmpty("")) {
                this.f51737f.m66665u("113_1049");
                this.f51737f.m66635A("");
                map.put("resourcePath", C10279b.m63452a(this.f51733b));
                this.f51738g.put("spotCheckResult", "");
                UBAAnalyze.m29947H("CKC", "action_file_spot_check_result", this.f51738g);
                C13622a.m81969o(C0213f.m1377a(), this.f51737f, map);
            }
            m65905a(this.f51746n);
            return;
        }
        if (!C11835i.m70650n(C10278a.m63442h(this.f51743l))) {
            if (!m65921n(encodingConfig)) {
                C11839m.m70688i("SpotCheckHandler", "no need to spotCheck:amount or randomRate or supportEncoding not match:" + this.f51733b.getName());
                this.f51745m = false;
                if (!TextUtils.isEmpty("")) {
                    this.f51737f.m66665u("113_1049");
                    this.f51737f.m66635A("");
                    map.put("resourcePath", C10279b.m63452a(this.f51733b));
                    this.f51738g.put("spotCheckResult", "");
                    UBAAnalyze.m29947H("CKC", "action_file_spot_check_result", this.f51738g);
                    C13622a.m81969o(C0213f.m1377a(), this.f51737f, map);
                }
                m65905a(this.f51746n);
                return;
            }
            this.f51739h.m69976c().m70033f();
            this.f51739h.m69976c().m70030c(this.f51733b.length());
            if (dM25923a < encodingConfig.getCompressionRate()) {
                C11839m.m70688i("SpotCheckHandler", "currentFileRate less than config:" + this.f51733b.getName());
                if (!TextUtils.isEmpty("")) {
                    this.f51737f.m66665u("113_1049");
                    this.f51737f.m66635A("");
                    map.put("resourcePath", C10279b.m63452a(this.f51733b));
                    this.f51738g.put("spotCheckResult", "");
                    UBAAnalyze.m29947H("CKC", "action_file_spot_check_result", this.f51738g);
                    C13622a.m81969o(C0213f.m1377a(), this.f51737f, map);
                }
                m65905a(this.f51746n);
                return;
            }
            this.f51739h.m69976c().m70032e();
            this.f51739h.m69976c().m70029b(this.f51733b.length());
            String strM63452a = C10279b.m63452a(this.f51733b);
            this.f51739h.m69976c().m70028a(HoleUtil.m25924b(strM63452a));
            C11839m.m70688i("SpotCheckHandler", "sparse file:" + this.f51733b.getName() + ",zippedSize is:" + HoleUtil.getZippedSize(strM63452a));
            HoleUtil.m25926d(strM63452a, this.f51743l);
            if (m65916l()) {
                C11839m.m70687e("SpotCheckHandler", "srcFile hash changed after sparse zipped");
                this.f51745m = false;
                m65905a(this.f51743l);
                if (!TextUtils.isEmpty("srcFile hash changed after sparse zipped")) {
                    this.f51737f.m66665u("113_1049");
                    this.f51737f.m66635A("srcFile hash changed after sparse zipped");
                    map.put("resourcePath", C10279b.m63452a(this.f51733b));
                    this.f51738g.put("spotCheckResult", "srcFile hash changed after sparse zipped");
                    UBAAnalyze.m29947H("CKC", "action_file_spot_check_result", this.f51738g);
                    C13622a.m81969o(C0213f.m1377a(), this.f51737f, map);
                }
                m65905a(this.f51746n);
                return;
            }
        }
        String strM75649C = C12583q.m75649C(this.f51742k);
        C12590s0.m75820Y1(strM75649C);
        String str2 = strM75649C + this.f51733b.getName();
        this.f51746n = str2;
        HoleUtil.m25925c(this.f51743l, str2);
        if (C4658z.m28496a(C11476b.m68622d(this.f51733b).getHash(), C11476b.m68622d(C10278a.m63442h(this.f51746n)).getHash())) {
            C11839m.m70688i("SpotCheckHandler", "unzipSparseFile hash equals to the original file:" + this.f51733b.getName());
            this.f51745m = true;
        } else {
            str = "unzipSparseFile hash not equals to the original file.";
            C11839m.m70689w("SpotCheckHandler", "unzipSparseFile hash not equals to the original file.");
            this.f51745m = false;
            m65905a(this.f51743l);
        }
        C11839m.m70688i("SpotCheckHandler", "spotCheck end,isPass:" + this.f51745m);
        if (!TextUtils.isEmpty(str)) {
            this.f51737f.m66665u("113_1049");
            this.f51737f.m66635A(str);
            map.put("resourcePath", C10279b.m63452a(this.f51733b));
            this.f51738g.put("spotCheckResult", str);
            UBAAnalyze.m29947H("CKC", "action_file_spot_check_result", this.f51738g);
            C13622a.m81969o(C0213f.m1377a(), this.f51737f, map);
        }
        m65905a(this.f51746n);
    }

    /* renamed from: n */
    public final boolean m65921n(SCompressionPolicyEncoding sCompressionPolicyEncoding) {
        if (sCompressionPolicyEncoding == null) {
            return false;
        }
        try {
            if (!sCompressionPolicyEncoding.getEncoding().equals(m65907c())) {
                C11839m.m70688i("SpotCheckHandler", "not support encoding,om config encoding:" + sCompressionPolicyEncoding.getEncoding() + ",supportEncoding:" + m65907c());
                return false;
            }
            this.f51739h.m69976c().m70034g(sCompressionPolicyEncoding.getCompressionRate());
            int spotCheckAmount = this.f51732a.getSpotCheckAmount();
            int iM70031d = this.f51739h.m69976c().m70031d();
            if (iM70031d < spotCheckAmount) {
                return m65919o(this.f51732a.getSpotCheckRate());
            }
            C11839m.m70688i("SpotCheckHandler", "spotCheckCount(" + iM70031d + ") exceeds amount(" + spotCheckAmount + ")");
            return false;
        } catch (Throwable th2) {
            C11839m.m70687e("SpotCheckHandler", "sparse compress error:" + th2.getMessage());
            return false;
        }
    }
}
