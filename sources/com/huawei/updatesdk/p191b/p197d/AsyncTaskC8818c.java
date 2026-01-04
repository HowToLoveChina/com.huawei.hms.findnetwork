package com.huawei.updatesdk.p191b.p197d;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8782d;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p177a.p186b.p188b.C8795b;
import com.huawei.updatesdk.p191b.p199f.C8829c;
import com.huawei.updatesdk.p191b.p200g.C8831b;
import com.huawei.updatesdk.p191b.p200g.C8832c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* renamed from: com.huawei.updatesdk.b.d.c */
/* loaded from: classes9.dex */
public class AsyncTaskC8818c extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    private String f45152a;

    /* renamed from: b */
    private HttpURLConnection f45153b;

    /* renamed from: d */
    private final C8817b f45155d;

    /* renamed from: c */
    private boolean f45154c = false;

    /* renamed from: e */
    private Handler f45156e = new b(null);

    /* renamed from: com.huawei.updatesdk.b.d.c$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AsyncTaskC8818c.this.f45153b != null) {
                AsyncTaskC8818c.this.f45154c = true;
                AsyncTaskC8818c.this.f45153b.disconnect();
            }
            AbstractC8782d.m56040a(new File(C8819d.m56261b()));
        }
    }

    /* renamed from: com.huawei.updatesdk.b.d.c$b */
    public static class b extends Handler {
        private b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: a */
        private void m56259a(Message message, Intent intent, C8795b c8795b) {
            Bundle bundle = new Bundle();
            bundle.putInt("download_status_param", message.what);
            intent.putExtras(bundle);
            C8829c.m56292b().m56294b(c8795b);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj instanceof C8817b) {
                C8817b c8817b = (C8817b) obj;
                Intent intent = new Intent();
                C8795b c8795bM56136a = C8795b.m56136a(intent);
                int i10 = message.what;
                if (i10 == 2) {
                    intent.putExtra("download_apk_size", c8817b.m56246e());
                    intent.putExtra("download_apk_already", c8817b.m56238a());
                    C8829c.m56292b().m56293a(c8795bM56136a);
                    return;
                }
                if (i10 != 3) {
                    if (i10 == 4) {
                        C8820e.m56265a(C8793a.m56132c().m56133a(), C8819d.m56261b() + "/appmarket.apk", c8817b.m56244c(), c8817b.m56245d());
                    } else if (i10 != 5) {
                        return;
                    }
                }
                m56259a(message, intent, c8795bM56136a);
            }
        }
    }

    public AsyncTaskC8818c(C8817b c8817b) {
        this.f45155d = c8817b;
        if (TextUtils.isEmpty(c8817b.m56244c())) {
            return;
        }
        this.f45152a = c8817b.m56244c();
    }

    /* renamed from: a */
    private int m56247a(C8817b c8817b, BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream, long j10) throws IOException {
        byte[] bArr = new byte[8192];
        long jCurrentTimeMillis = 0;
        int i10 = 0;
        while (true) {
            int i11 = bufferedInputStream.read(bArr);
            if (i11 == -1) {
                return i10;
            }
            bufferedOutputStream.write(bArr, 0, i11);
            i10 += i11;
            if (Math.abs(System.currentTimeMillis() - jCurrentTimeMillis) > 1000) {
                jCurrentTimeMillis = System.currentTimeMillis();
                if (i10 != j10) {
                    m56251a(c8817b.m56245d(), i10, j10, this.f45152a, 2);
                }
            }
        }
    }

    /* renamed from: c */
    private void m56255c() {
        HttpURLConnection httpURLConnection = this.f45153b;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* renamed from: b */
    public void m56258b() {
        this.f45156e = null;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        m56257a();
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) throws Throwable {
        C8831b.m56300a(this);
        m56249a(this.f45155d, C8819d.m56261b());
        return null;
    }

    /* renamed from: a */
    public void m56257a() {
        C8832c.f45172a.execute(new a());
    }

    /* renamed from: a */
    private void m56249a(C8817b c8817b, String str) throws Throwable {
        String str2;
        if (c8817b == null || TextUtils.isEmpty(c8817b.m56242b())) {
            return;
        }
        String str3 = str + "/appmarket.apk";
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str3));
                try {
                    if (!m56253a(c8817b, fileOutputStream2, str3)) {
                        AbstractC8782d.m56040a(new File(C8819d.m56261b()));
                    }
                    AbstractC8782d.m56039a(fileOutputStream2);
                } catch (FileNotFoundException unused) {
                    fileOutputStream = fileOutputStream2;
                    str2 = "DOWNLOAD market package FileNotFoundException error";
                    C8777a.m56028b("DownloadMarketTask", str2);
                    AbstractC8782d.m56039a(fileOutputStream);
                } catch (Exception e10) {
                    e = e10;
                    fileOutputStream = fileOutputStream2;
                    str2 = "DOWNLOAD market package Exception error:" + e.getMessage();
                    C8777a.m56028b("DownloadMarketTask", str2);
                    AbstractC8782d.m56039a(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    AbstractC8782d.m56039a(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    private void m56250a(InputStream inputStream, OutputStream outputStream) throws IOException {
        AbstractC8782d.m56039a(inputStream);
        AbstractC8782d.m56039a(outputStream);
    }

    /* renamed from: a */
    private void m56251a(String str, int i10, long j10, String str2, int i11) {
        C8817b c8817b = new C8817b();
        c8817b.m56239a(i10);
        c8817b.m56240a(j10);
        c8817b.m56241a(str2);
        c8817b.m56243b(str);
        Handler handler = this.f45156e;
        if (handler == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(i11, c8817b));
    }

    /* renamed from: a */
    private void m56252a(boolean z10, C8817b c8817b, int i10, long j10) {
        String strM56245d;
        String str;
        int i11;
        if (z10) {
            return;
        }
        if (this.f45154c) {
            strM56245d = c8817b.m56245d();
            str = this.f45152a;
            i11 = 3;
        } else {
            strM56245d = c8817b.m56245d();
            str = this.f45152a;
            i11 = 5;
        }
        m56251a(strM56245d, i10, j10, str, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.huawei.updatesdk.b.d.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m56253a(com.huawei.updatesdk.p191b.p197d.C8817b r18, java.io.OutputStream r19, java.lang.String r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p191b.p197d.AsyncTaskC8818c.m56253a(com.huawei.updatesdk.b.d.b, java.io.OutputStream, java.lang.String):boolean");
    }
}
