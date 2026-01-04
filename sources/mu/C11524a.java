package mu;

import android.util.Log;
import android.webkit.WebView;
import java.util.concurrent.CountDownLatch;
import lu.C11348g;
import lu.C11349h;

/* renamed from: mu.a */
/* loaded from: classes5.dex */
public class C11524a {

    /* renamed from: a */
    public String f53477a;

    /* renamed from: b */
    public WebView f53478b;

    /* renamed from: mu.a$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f53479a;

        public a(CountDownLatch countDownLatch) {
            this.f53479a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            C11524a c11524a = C11524a.this;
            c11524a.m68796d(c11524a.f53478b.getUrl());
            this.f53479a.countDown();
        }
    }

    public C11524a(WebView webView) {
        this.f53478b = webView;
    }

    /* renamed from: b */
    public String m68794b() throws InterruptedException {
        if (this.f53478b == null) {
            return "";
        }
        if (C11348g.m68159a()) {
            return this.f53478b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C11349h.m68160a(new a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e10) {
            Log.e("SafeGetUrl", "getUrlMethod: InterruptedException " + e10.getMessage(), e10);
        }
        return this.f53477a;
    }

    /* renamed from: c */
    public WebView m68795c() {
        return this.f53478b;
    }

    /* renamed from: d */
    public void m68796d(String str) {
        this.f53477a = str;
    }
}
