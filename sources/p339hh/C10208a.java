package p339hh;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Callable;
import p208cq.C8941i;
import p208cq.C8943k;
import p396jh.C10890a;
import p453lh.C11276a;

/* renamed from: hh.a */
/* loaded from: classes4.dex */
public class C10208a {

    /* renamed from: hh.a$a */
    public static class a implements Callable<Void> {

        /* renamed from: a */
        public final Context f49520a;

        /* renamed from: b */
        public final String f49521b;

        /* renamed from: c */
        public final boolean f49522c;

        /* renamed from: d */
        public final C8941i<String> f49523d;

        public a(C8941i<String> c8941i, Context context, String str, boolean z10) {
            this.f49520a = context;
            this.f49521b = str;
            this.f49522c = z10;
            this.f49523d = c8941i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Throwable {
            if (this.f49522c) {
                Log.i("HomeCountryImpl", "force homeCountry");
                C10890a.m65882b(this.f49523d, this.f49520a, this.f49521b);
                return null;
            }
            String strM67679i = C11276a.m67671a(this.f49520a).m67679i();
            if (strM67679i != null) {
                Log.i("HomeCountryImpl", "homeCountry from cache");
                if (System.currentTimeMillis() - C11276a.m67671a(this.f49520a).m67680j() < C11276a.m67671a(this.f49520a).m67675e()) {
                    Log.i("HomeCountryImpl", "current homeCountry is valid");
                    this.f49523d.m56658d(strM67679i);
                    return null;
                }
            }
            String strM63351d = C10208a.m63351d(this.f49520a);
            if (strM63351d != null) {
                Log.i("HomeCountryImpl", "homeCountry from settings");
                C10208a.m63352e(this.f49520a);
                C11276a.m67671a(this.f49520a).m67676f(strM63351d);
                this.f49523d.m56658d(strM63351d);
                return null;
            }
            String strM67677g = C11276a.m67671a(this.f49520a).m67677g();
            if (strM67677g != null) {
                Log.i("HomeCountryImpl", "homeCountry from sp");
                if (System.currentTimeMillis() - C11276a.m67671a(this.f49520a).m67678h() < C11276a.m67671a(this.f49520a).m67675e()) {
                    Log.i("HomeCountryImpl", "current homeCountry is valid");
                    this.f49523d.m56658d(strM67677g);
                    return null;
                }
            }
            C10890a.m65882b(this.f49523d, this.f49520a, this.f49521b);
            return null;
        }
    }

    /* renamed from: hh.a$b */
    public static class b extends ContentObserver {

        /* renamed from: a */
        public final Context f49524a;

        public b(Context context, Handler handler) {
            super(handler);
            this.f49524a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            Log.d("HomeCountryImpl", "homeCountry changed");
            if (uri.equals(Settings.Secure.getUriFor("appgallery_service_homecountry"))) {
                C11276a.m67671a(this.f49524a).m67676f(C10208a.m63351d(this.f49524a));
            }
        }
    }

    /* renamed from: a */
    public static Task<String> m63348a(Context context, String str, boolean z10) {
        C8941i c8941i = new C8941i();
        if (context == null) {
            c8941i.m56657c(new Exception("context is null"));
        } else {
            C8943k.m56662b(new a(c8941i, context, str, z10));
        }
        return c8941i.m56656b();
    }

    /* renamed from: d */
    public static String m63351d(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "appgallery_service_homecountry");
        } catch (Exception unused) {
            Log.e("HomeCountryImpl", "getHomeCountryBySettings exception");
            return null;
        }
    }

    /* renamed from: e */
    public static void m63352e(Context context) {
        try {
            context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("appgallery_service_homecountry"), false, new b(context, null));
        } catch (Exception unused) {
            Log.e("HomeCountryImpl", "registerHomeCountryObserver exception");
        }
    }
}
