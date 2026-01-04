package p607ra;

import android.os.Handler;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import p514o9.C11839m;
import qa.C12296a;

/* renamed from: ra.a */
/* loaded from: classes3.dex */
public class C12479a {

    /* renamed from: a */
    public Handler f57454a;

    /* renamed from: b */
    public RunnableC12480b f57455b;

    /* renamed from: c */
    public FileModel f57456c;

    /* renamed from: d */
    public int f57457d;

    public C12479a(FileModel fileModel, Handler handler, int i10) {
        this.f57456c = fileModel;
        this.f57454a = handler;
        this.f57457d = i10;
    }

    /* renamed from: a */
    public void m74929a() {
        RunnableC12480b runnableC12480b = new RunnableC12480b(this.f57456c, this.f57454a, this.f57457d);
        this.f57455b = runnableC12480b;
        String strM74944p = runnableC12480b.m74944p(this.f57457d);
        C11839m.m70686d("BitmapRequest", "initDownBitmap thumbKey: " + strM74944p + ", fileName: " + this.f57456c.getFileName());
        C12296a.m73898e().m73901c(strM74944p, new C12482d(this.f57455b, null, this.f57457d));
    }
}
