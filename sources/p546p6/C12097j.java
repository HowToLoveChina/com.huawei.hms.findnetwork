package p546p6;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.huawei.android.p069cg.R$string;
import p015ak.C0213f;
import p031b7.C1120a;
import p486n6.ViewOnClickListenerC11645j;
import p486n6.ViewOnClickListenerC11646k;

/* renamed from: p6.j */
/* loaded from: classes2.dex */
public class C12097j {

    /* renamed from: d */
    public static final Object f56115d = new Object();

    /* renamed from: e */
    public static C12097j f56116e;

    /* renamed from: a */
    public Context f56117a;

    /* renamed from: b */
    public ViewOnClickListenerC11645j f56118b;

    /* renamed from: c */
    public ViewOnClickListenerC11646k f56119c;

    public C12097j(Context context) {
        this.f56117a = context;
    }

    /* renamed from: b */
    public static C12097j m72480b() {
        C12097j c12097j;
        synchronized (f56115d) {
            try {
                C12097j c12097j2 = f56116e;
                if (c12097j2 == null || c12097j2.f56117a == null) {
                    f56116e = new C12097j(C0213f.m1377a());
                }
                c12097j = f56116e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c12097j;
    }

    /* renamed from: a */
    public void m72481a() {
        try {
            ViewOnClickListenerC11646k viewOnClickListenerC11646k = this.f56119c;
            if (viewOnClickListenerC11646k != null) {
                viewOnClickListenerC11646k.dismiss();
            }
        } catch (Exception e10) {
            C1120a.m6676e("GalleryDownloadManager", e10.getMessage());
        }
    }

    /* renamed from: c */
    public void m72482c(Context context, String str, int i10, Handler handler) {
        ViewOnClickListenerC11645j viewOnClickListenerC11645j = this.f56118b;
        if (viewOnClickListenerC11645j == null || !viewOnClickListenerC11645j.isShowing()) {
            ViewOnClickListenerC11645j viewOnClickListenerC11645j2 = new ViewOnClickListenerC11645j(context, str, i10, handler);
            this.f56118b = viewOnClickListenerC11645j2;
            viewOnClickListenerC11645j2.show();
        }
    }

    /* renamed from: d */
    public void m72483d(Context context, String str, Handler handler) {
        ViewOnClickListenerC11646k viewOnClickListenerC11646k = this.f56119c;
        if (viewOnClickListenerC11646k == null || !viewOnClickListenerC11646k.isShowing()) {
            ViewOnClickListenerC11646k viewOnClickListenerC11646k2 = new ViewOnClickListenerC11646k(context, str, handler);
            this.f56119c = viewOnClickListenerC11646k2;
            viewOnClickListenerC11646k2.show();
        }
    }

    /* renamed from: e */
    public void m72484e(String str, int i10) {
        ViewOnClickListenerC11646k viewOnClickListenerC11646k = this.f56119c;
        if (viewOnClickListenerC11646k == null || !viewOnClickListenerC11646k.isShowing()) {
            return;
        }
        this.f56119c.m69534a(str, i10);
        this.f56119c.show();
    }

    /* renamed from: f */
    public void m72485f(Activity activity) {
        Toast.makeText(activity, R$string.album_download_failed_toast, 0).show();
    }

    /* renamed from: g */
    public void m72486g(Activity activity) {
        Toast.makeText(activity, R$string.album_media_download_start_notify, 0).show();
    }

    /* renamed from: h */
    public void m72487h(Activity activity) {
        Toast.makeText(activity, R$string.album_media_save_success, 0).show();
    }

    /* renamed from: i */
    public void m72488i(Activity activity) {
        Toast.makeText(activity, R$string.album_media_download_local_exsit, 0).show();
    }

    /* renamed from: j */
    public void m72489j() {
        Toast.makeText(this.f56117a, R$string.network_disconnected, 0).show();
    }

    /* renamed from: k */
    public void m72490k(Activity activity) {
        Toast.makeText(activity, R$string.network_disconnected, 0).show();
    }
}
