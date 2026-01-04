package com.baidu.location.p065a;

import android.text.TextUtils;
import com.baidu.location.p065a.C1531c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.baidu.location.a.e */
/* loaded from: classes.dex */
public class C1533e {

    /* renamed from: a */
    private static final String f6627a = "NetworkClient";

    /* renamed from: b */
    private static final String f6628b = "GET";

    /* renamed from: c */
    private static final String f6629c = "POST";

    /* renamed from: d */
    private static final int f6630d = 5000;

    /* renamed from: e */
    private static final int f6631e = 5000;

    /* renamed from: f */
    private static final int f6632f = 5000;

    /* renamed from: g */
    private static final int f6633g = 1000;

    /* renamed from: h */
    private static final int f6634h = 12000;

    /* renamed from: i */
    private static ExecutorService f6635i = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.location.a.e$a */
    public static class a implements Callable<String> {

        /* renamed from: a */
        private String f6636a;

        /* renamed from: b */
        private String f6637b;

        /* renamed from: c */
        private String f6638c;

        /* renamed from: d */
        private int f6639d;

        /* renamed from: e */
        private int f6640e;

        public a(String str, String str2, String str3, int i10, int i11) {
            this.f6636a = str;
            this.f6637b = str2;
            this.f6638c = str3;
            this.f6639d = i10;
            this.f6640e = i11;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            C1534f.m8725c("HttpTaskWithResult, call() begin the http Task.");
            C1531c c1531c = new C1531c(this.f6636a, new C1531c.b() { // from class: com.baidu.location.a.e.a.1
                @Override // com.baidu.location.p065a.C1531c.b
                /* renamed from: a */
                public void mo8700a(C1531c.a aVar) {
                    C1534f.m8725c("HttpTaskWithResult,onFailed(),error:" + aVar);
                }

                @Override // com.baidu.location.p065a.C1531c.b
                /* renamed from: a */
                public void mo8701a(String str) {
                }
            });
            c1531c.m8699b(this.f6639d);
            c1531c.m8698a(this.f6640e);
            return c1531c.m8697a(this.f6637b, this.f6638c);
        }
    }

    /* renamed from: a */
    public static String m8707a(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("URI cannot be null or empty");
        }
        return m8709a("GET", str, null, 5000, 1000);
    }

    /* renamed from: a */
    public static String m8708a(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("URI or param cannot be null or empty");
        }
        return m8709a("POST", str, str2, 5000, 5000);
    }

    /* renamed from: a */
    private static String m8709a(String str, String str2, String str3, int i10, int i11) {
        String str4;
        try {
            return (String) f6635i.submit(new a(str, str2, str3, i10, i11)).get(12000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
            str4 = "executeHttpTask()  InterruptedException";
            C1534f.m8725c(str4);
            return "";
        } catch (ExecutionException e11) {
            e11.printStackTrace();
            str4 = "executeHttpTask()  ExecutionException";
            C1534f.m8725c(str4);
            return "";
        } catch (TimeoutException e12) {
            e12.printStackTrace();
            str4 = "executeHttpTask()  TimeoutException out of time";
            C1534f.m8725c(str4);
            return "";
        }
    }
}
