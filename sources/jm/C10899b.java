package jm;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.SCompressionPolicy;
import com.huawei.android.hicloud.utils.hole.HoleUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.HashMap;
import p015ak.C0213f;
import p514o9.C11835i;
import p514o9.C11839m;
import p746wn.C13622a;

/* renamed from: jm.b */
/* loaded from: classes6.dex */
public class C10899b extends AbstractC10898a {

    /* renamed from: m */
    public File f51744m;

    public C10899b(SCompressionPolicy sCompressionPolicy, String str, File file, String str2) {
        super(sCompressionPolicy, str, file, str2);
        m65914j("sparse");
    }

    @Override // jm.AbstractC10898a
    /* renamed from: e */
    public void mo65909e() {
        File fileM63442h;
        boolean zIsEmpty;
        if (this.f51732a == null) {
            C11839m.m70686d("SparseCompressHandler", "compressionPolicy is null.");
            return;
        }
        HashMap map = new HashMap();
        try {
            m65910f("sparseCompress");
            String strM65908d = m65908d();
            this.f51743l = strM65908d;
            fileM63442h = C10278a.m63442h(strM65908d);
        } catch (Throwable th2) {
            try {
                C11839m.m70687e("SparseCompressHandler", "compress sparse file error:" + th2.getMessage());
                m65905a(this.f51743l);
                if (TextUtils.isEmpty("")) {
                    return;
                }
            } finally {
                if (!TextUtils.isEmpty("")) {
                    this.f51737f.m66665u("113_1050");
                    this.f51737f.m66635A("");
                    map.put("resourcePath", C10279b.m63452a(this.f51733b));
                    this.f51738g.put("sparseCompressResult", "");
                    UBAAnalyze.m29947H("CKC", "action_file_sparse_compress_result", this.f51738g);
                    C13622a.m81969o(C0213f.m1377a(), this.f51737f, map);
                }
            }
        }
        if (C11835i.m70650n(fileM63442h)) {
            C11839m.m70688i("SparseCompressHandler", "sparse file already compressed:" + fileM63442h.getName());
            m65918n(fileM63442h);
            if (zIsEmpty) {
                return;
            } else {
                return;
            }
        }
        if (!m65911g()) {
            C11839m.m70688i("SparseCompressHandler", "no need parse compress,sparse rate or encoding not match.");
            if (TextUtils.isEmpty("")) {
                return;
            }
            this.f51737f.m66665u("113_1050");
            this.f51737f.m66635A("");
            map.put("resourcePath", C10279b.m63452a(this.f51733b));
            this.f51738g.put("sparseCompressResult", "");
            UBAAnalyze.m29947H("CKC", "action_file_sparse_compress_result", this.f51738g);
            C13622a.m81969o(C0213f.m1377a(), this.f51737f, map);
            return;
        }
        HoleUtil.m25926d(C10279b.m63452a(this.f51733b), this.f51743l);
        m65918n(C10278a.m63442h(this.f51743l));
        if (m65916l()) {
            C11839m.m70687e("SparseCompressHandler", "srcFile hash changed after sparse zipped");
            m65905a(this.f51743l);
            if (TextUtils.isEmpty("srcFile hash changed after sparse zipped")) {
                return;
            }
            this.f51737f.m66665u("113_1050");
            this.f51737f.m66635A("srcFile hash changed after sparse zipped");
            map.put("resourcePath", C10279b.m63452a(this.f51733b));
            this.f51738g.put("sparseCompressResult", "srcFile hash changed after sparse zipped");
            UBAAnalyze.m29947H("CKC", "action_file_sparse_compress_result", this.f51738g);
            C13622a.m81969o(C0213f.m1377a(), this.f51737f, map);
            return;
        }
        C11839m.m70688i("SparseCompressHandler", "sparse file compress success,appId:" + this.f51734c + ",fileName:" + this.f51733b.getName());
        if (TextUtils.isEmpty("")) {
            return;
        }
        this.f51737f.m66665u("113_1050");
        this.f51737f.m66635A("");
        map.put("resourcePath", C10279b.m63452a(this.f51733b));
        this.f51738g.put("sparseCompressResult", "");
        UBAAnalyze.m29947H("CKC", "action_file_sparse_compress_result", this.f51738g);
        C13622a.m81969o(C0213f.m1377a(), this.f51737f, map);
    }

    /* renamed from: m */
    public File m65917m() {
        if (this.f51744m == null) {
            C11839m.m70686d("SparseCompressHandler", "compressedFile is null,get from local:" + this.f51733b.getName());
            try {
                String strM65908d = m65908d();
                this.f51743l = strM65908d;
                File fileM63442h = C10278a.m63442h(strM65908d);
                if (C11835i.m70650n(fileM63442h)) {
                    C11839m.m70688i("SparseCompressHandler", "local compressed file exist:" + this.f51733b.getName());
                    m65918n(fileM63442h);
                }
            } catch (C9721b e10) {
                C11839m.m70687e("SparseCompressHandler", "getCompressedFile error:" + e10.getMessage());
            }
        }
        return this.f51744m;
    }

    /* renamed from: n */
    public void m65918n(File file) {
        this.f51744m = file;
    }

    public C10899b(String str, File file) {
        super(str, file);
    }
}
