package na;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.model.SliceObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;

/* renamed from: na.b */
/* loaded from: classes3.dex */
public class C11656b {

    /* renamed from: a */
    public String f54071a;

    /* renamed from: b */
    public int f54072b;

    /* renamed from: c */
    public File f54073c;

    /* renamed from: e */
    public int f54075e;

    /* renamed from: g */
    public String f54077g;

    /* renamed from: h */
    public long f54078h;

    /* renamed from: i */
    public long f54079i;

    /* renamed from: j */
    public SliceObject f54080j;

    /* renamed from: f */
    public boolean f54076f = false;

    /* renamed from: d */
    public List<C11660f> f54074d = new ArrayList();

    public C11656b(SliceObject sliceObject, int i10) {
        this.f54071a = sliceObject.getId();
        this.f54080j = sliceObject;
        this.f54075e = i10;
    }

    /* renamed from: a */
    public void m69608a(C11660f c11660f) {
        this.f54074d.add(c11660f);
    }

    /* renamed from: b */
    public void m69609b() {
        File file = this.f54073c;
        if (file == null || !file.exists()) {
            return;
        }
        C11839m.m70686d("NetSlice", "finally clean file exits, delete = " + this.f54073c.delete());
    }

    /* renamed from: c */
    public String m69610c() {
        return this.f54071a;
    }

    /* renamed from: d */
    public int m69611d() {
        return this.f54072b;
    }

    /* renamed from: e */
    public long m69612e() {
        return this.f54079i;
    }

    /* renamed from: f */
    public String m69613f() {
        if (!TextUtils.isEmpty(this.f54077g)) {
            return this.f54077g;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bytes=");
        ArrayList arrayList = new ArrayList(this.f54074d.size());
        for (C11660f c11660f : this.f54074d) {
            if (!arrayList.contains(c11660f)) {
                arrayList.add(c11660f);
            }
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            sb2.append(((C11660f) arrayList.get(i10)).m69633b());
            sb2.append("-");
            this.f54078h += r3.m69632a();
            sb2.append((r3.m69633b() + r3.m69632a()) - 1);
            if (i10 < arrayList.size() - 1) {
                sb2.append(",");
            }
        }
        String string = sb2.toString();
        this.f54077g = string;
        return string;
    }

    /* renamed from: g */
    public long m69614g() {
        return this.f54078h;
    }

    /* renamed from: h */
    public File m69615h() {
        return this.f54073c;
    }

    /* renamed from: i */
    public SliceObject m69616i() {
        return this.f54080j;
    }

    /* renamed from: j */
    public void m69617j(int i10) {
        this.f54072b = i10;
    }

    /* renamed from: k */
    public void m69618k(long j10) {
        this.f54079i = j10;
    }

    /* renamed from: l */
    public void m69619l(File file) {
        this.f54073c = file;
    }

    public String toString() {
        return "layerSeq:" + this.f54072b + ",number:" + this.f54075e + ",id:" + this.f54071a;
    }
}
