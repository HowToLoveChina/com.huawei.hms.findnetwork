package com.huawei.updatesdk.p177a.p186b.p189c;

import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p179b.C8776b;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8786h;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8800c;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8801d;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.InterfaceC8798a;
import com.huawei.updatesdk.p191b.p200g.C8830a;
import com.huawei.updatesdk.p191b.p200g.C8831b;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.huawei.updatesdk.a.b.c.b */
/* loaded from: classes9.dex */
public class AsyncTaskC8797b extends AsyncTask<C8800c, Void, C8801d> {

    /* renamed from: a */
    protected C8800c f45106a;

    /* renamed from: c */
    private final InterfaceC8798a f45108c;

    /* renamed from: b */
    private C8801d f45107b = null;

    /* renamed from: d */
    private C8776b f45109d = null;

    /* renamed from: e */
    private int f45110e = 0;

    public AsyncTaskC8797b(C8800c c8800c, InterfaceC8798a interfaceC8798a) {
        this.f45106a = c8800c;
        this.f45108c = interfaceC8798a;
    }

    /* renamed from: d */
    private String m56155d() throws PackageManager.NameNotFoundException {
        String strM56296a = C8830a.m56296a();
        C8777a.m56029c("StoreTask", "UserAgent is: " + strM56296a);
        return TextUtils.isEmpty(strM56296a) ? "Android/1.0" : strM56296a;
    }

    /* renamed from: e */
    private void m56157e() {
        m56151b(this.f45107b);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8801d m56158a() {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p177a.p186b.p189c.AsyncTaskC8797b.m56158a():com.huawei.updatesdk.a.b.c.c.d");
    }

    /* renamed from: b */
    public void m56162b() {
        C8776b c8776b = this.f45109d;
        if (c8776b != null) {
            c8776b.m56019a();
            this.f45109d = null;
        }
    }

    /* renamed from: c */
    public final C8801d m56163c() {
        C8801d c8801dM56158a = null;
        do {
            if (this.f45110e > 0 && c8801dM56158a != null) {
                C8777a.m56026a("StoreTask", "call store error! responseCode:" + c8801dM56158a.m56182d() + ", retryTimes:" + this.f45110e);
            }
            c8801dM56158a = m56158a();
        } while (m56153c(c8801dM56158a));
        this.f45107b = c8801dM56158a;
        return c8801dM56158a;
    }

    /* renamed from: a */
    private C8801d m56146a(String str, C8801d c8801d) {
        try {
            c8801d.fromJson(new JSONObject(str));
            c8801d.m56180b(0);
        } catch (Exception e10) {
            C8777a.m56027a("StoreTask", "parse json error", e10);
        }
        return c8801d;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m56151b(com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8801d r5) {
        /*
            r4 = this;
            java.lang.String r0 = "notifyResult, create response error, method:"
            boolean r1 = r4.isCancelled()
            if (r1 != 0) goto L5e
            com.huawei.updatesdk.a.b.c.c.a r1 = r4.f45108c
            if (r1 == 0) goto L5e
            if (r5 != 0) goto L57
            java.lang.String r1 = "notifyResult, response is null"
            java.lang.String r2 = "StoreTask"
            com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a.m56028b(r2, r1)
            com.huawei.updatesdk.a.b.c.c.c r1 = r4.f45106a     // Catch: java.lang.IllegalAccessException -> L20 java.lang.InstantiationException -> L22
            java.lang.String r1 = r1.m56170b()     // Catch: java.lang.IllegalAccessException -> L20 java.lang.InstantiationException -> L22
            com.huawei.updatesdk.a.b.c.c.d r5 = com.huawei.updatesdk.p177a.p186b.p189c.C8796a.m56145a(r1)     // Catch: java.lang.IllegalAccessException -> L20 java.lang.InstantiationException -> L22
            goto L43
        L20:
            r1 = move-exception
            goto L24
        L22:
            r1 = move-exception
            goto L3d
        L24:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L29:
            r3.append(r0)
            com.huawei.updatesdk.a.b.c.c.c r0 = r4.f45106a
            java.lang.String r0 = r0.m56170b()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a.m56027a(r2, r0, r1)
            goto L43
        L3d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L29
        L43:
            if (r5 != 0) goto L50
            com.huawei.updatesdk.a.b.c.c.d r5 = new com.huawei.updatesdk.a.b.c.c.d
            r5.<init>()
            com.huawei.updatesdk.a.b.c.c.d$a r0 = com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8801d.a.PARAM_ERROR
        L4c:
            r5.m56177a(r0)
            goto L53
        L50:
            com.huawei.updatesdk.a.b.c.c.d$a r0 = com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8801d.a.UNKNOWN_EXCEPTION
            goto L4c
        L53:
            r0 = 1
            r5.m56180b(r0)
        L57:
            com.huawei.updatesdk.a.b.c.c.a r0 = r4.f45108c
            com.huawei.updatesdk.a.b.c.c.c r4 = r4.f45106a
            r0.mo56165b(r4, r5)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p177a.p186b.p189c.AsyncTaskC8797b.m56151b(com.huawei.updatesdk.a.b.c.c.d):void");
    }

    /* renamed from: c */
    private boolean m56153c(C8801d c8801d) {
        if (isCancelled()) {
            return false;
        }
        if (c8801d.m56182d() != 1 && c8801d.m56182d() != 2) {
            return false;
        }
        int i10 = this.f45110e;
        this.f45110e = i10 + 1;
        if (i10 >= 3) {
            C8777a.m56026a("StoreTask", "retry completed total times = " + this.f45110e + ",response.responseCode = " + c8801d.m56182d());
            return false;
        }
        C8777a.m56026a("StoreTask", "retry times = " + this.f45110e + ",response.responseCode = " + c8801d.m56182d());
        return true;
    }

    /* renamed from: d */
    private void m56156d(String str) {
        C8774a.m56008a("StoreTask", TextUtils.isEmpty(str) ? "UpdateSDK response error, resData == null" : "UpdateSDK response error, resData is not json string");
    }

    /* renamed from: b */
    private boolean m56152b(String str) {
        return TextUtils.isEmpty(str) || !AbstractC8786h.m56068d(str);
    }

    /* renamed from: c */
    private boolean m56154c(String str) {
        return (str == null || str.contains("emuiApiLevel") || str.contains("ts") || str.contains("harmonyApiLevel")) ? false : true;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C8801d doInBackground(C8800c... c8800cArr) {
        C8777a.m56026a("StoreTask", "doInBackground, method:" + this.f45106a.m56170b());
        C8831b.m56300a((AsyncTask) this);
        C8801d c8801dM56163c = m56163c();
        InterfaceC8798a interfaceC8798a = this.f45108c;
        if (interfaceC8798a != null) {
            interfaceC8798a.mo56164a(this.f45106a, c8801dM56163c);
        }
        return c8801dM56163c;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C8801d c8801d) {
        C8777a.m56026a("StoreTask", "onPostExecute, method:" + this.f45106a.m56170b());
        C8831b.m56299a().remove(this);
        m56157e();
    }

    /* renamed from: a */
    private void m56147a(C8801d c8801d, int i10, C8801d.a aVar, Throwable th2) {
        if (c8801d != null) {
            c8801d.m56180b(i10);
            c8801d.m56177a(aVar);
            String string = th2.toString();
            if (m56150a(th2.toString())) {
                string = th2.getClass().getName();
            }
            c8801d.m56178a(string);
        }
    }

    /* renamed from: a */
    private void m56148a(C8801d c8801d, Throwable th2, String str) {
        C8801d.a aVar;
        int i10 = 1;
        if (th2 instanceof ConnectException) {
            aVar = C8801d.a.CONNECT_EXCEPTION;
        } else if ((th2 instanceof SocketTimeoutException) || (th2.getMessage() != null && th2.getMessage().contains("ConnectTimeoutException"))) {
            aVar = C8801d.a.CONNECT_EXCEPTION;
            i10 = 2;
        } else if (th2 instanceof IllegalArgumentException) {
            aVar = C8801d.a.PARAM_ERROR;
            i10 = 5;
        } else if (th2 instanceof IllegalAccessException) {
            aVar = C8801d.a.UNKNOWN_EXCEPTION;
        } else {
            if (!(th2 instanceof ArrayIndexOutOfBoundsException)) {
                if ((th2 instanceof InterruptedException) || (th2 instanceof InterruptedIOException)) {
                    m56147a(c8801d, 0, C8801d.a.NORMAL, th2);
                    C8774a.m56008a("StoreTask", "UpdateSDK task is canceled");
                } else if (th2 instanceof IOException) {
                    aVar = C8801d.a.IO_EXCEPTION;
                } else if (c8801d != null) {
                    c8801d.m56178a(th2.toString());
                }
                m56149a(str, th2);
            }
            aVar = C8801d.a.NO_PROGUARD;
            i10 = 6;
        }
        m56147a(c8801d, i10, aVar, th2);
        m56149a(str, th2);
    }

    /* renamed from: a */
    private void m56149a(String str, Throwable th2) {
        StringBuilder sb2 = new StringBuilder();
        String string = th2.toString();
        if (m56150a(th2.toString())) {
            string = th2.getClass().getName();
        }
        sb2.append("invoke store error");
        sb2.append(", exceptionType:");
        sb2.append(string);
        sb2.append(", url:");
        sb2.append(str);
        sb2.append(", method:");
        sb2.append(this.f45106a.m56170b());
        sb2.append(", retryTimes:");
        sb2.append(this.f45110e);
        String string2 = sb2.toString();
        C8777a.m56027a("StoreTask", string2, th2);
        C8774a.m56008a("StoreTask", "UpdateSDK call store error: " + string2);
    }

    /* renamed from: a */
    public final void m56161a(Executor executor) {
        executeOnExecutor(executor, this.f45106a);
    }

    /* renamed from: a */
    private boolean m56150a(String str) {
        try {
            return Pattern.compile("((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)").matcher(str).find();
        } catch (Exception e10) {
            C8774a.m56009b("StoreTask", "is contain ip error: " + e10.getMessage());
            return true;
        }
    }
}
