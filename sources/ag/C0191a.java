package ag;

import android.text.TextUtils;
import eg.AbstractC9478g;
import fk.C9721b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import p809yg.C13981a;

/* renamed from: ag.a */
/* loaded from: classes4.dex */
public class C0191a extends AbstractC9478g {

    /* renamed from: a */
    public final C0195e f755a;

    /* renamed from: b */
    public final BlockingQueue<byte[]> f756b;

    /* renamed from: c */
    public FileOutputStream f757c;

    public C0191a(C0195e c0195e, BlockingQueue<byte[]> blockingQueue) {
        this.f755a = c0195e;
        this.f756b = blockingQueue;
    }

    /* renamed from: c */
    public final String m1077c() {
        String strM1089a = this.f755a.m1089a();
        if (TextUtils.isEmpty(strM1089a)) {
            return System.currentTimeMillis() + "log.bin";
        }
        return strM1089a.substring(Math.max(0, strM1089a.length() - 4)) + "-" + System.currentTimeMillis() + "log.bin";
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws InterruptedException, C9721b, IOException {
        File file = new File(C0194d.f760c + File.separator + m1077c());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            C13981a.m83989i("PrintTagLogTask", "create ParentFile:" + parentFile.mkdirs());
        }
        try {
            C13981a.m83989i("PrintTagLogTask", "createResult:" + file.createNewFile());
            this.f757c = new FileOutputStream(file, true);
        } catch (Exception e10) {
            C13981a.m83989i("PrintTagLogTask", "PrintTagLogWorker exception:" + e10.getMessage());
        }
        m1078d();
    }

    /* renamed from: d */
    public final void m1078d() throws InterruptedException, IOException {
        while (this.f755a.m1090b()) {
            try {
                byte[] bArrPoll = this.f756b.poll(20L, TimeUnit.SECONDS);
                if (bArrPoll != null) {
                    C13981a.m83989i("PrintTagLogTask", "write log");
                    this.f757c.write(bArrPoll, 0, bArrPoll.length);
                    this.f757c.flush();
                }
            } catch (InterruptedException unused) {
                C13981a.m83989i("PrintTagLogTask", "PrintWoker InterruptedException");
            } catch (Exception unused2) {
                C13981a.m83989i("PrintTagLogTask", "PrintWoker IllegalMonitorStateException");
            }
        }
        FileOutputStream fileOutputStream = this.f757c;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused3) {
                C13981a.m83989i("PrintTagLogTask", "PrintWoker fos Exception");
            }
        }
        this.f757c = null;
        C13981a.m83989i("PrintTagLogTask", "PrintWoker stop");
    }
}
