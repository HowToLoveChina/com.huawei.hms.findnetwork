package p514o9;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/* renamed from: o9.o */
/* loaded from: classes3.dex */
public class C11841o {

    /* renamed from: a */
    public static volatile Toast f54788a;

    /* renamed from: b */
    public static volatile Toast f54789b;

    /* renamed from: o9.o$a */
    public static class a implements Runnable {

        /* renamed from: a */
        public final Activity f54790a;

        /* renamed from: b */
        public final String f54791b;

        /* renamed from: c */
        public final int f54792c;

        public a(Activity activity, String str, int i10) {
            this.f54790a = activity;
            this.f54792c = i10;
            this.f54791b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity = this.f54790a;
            if (activity != null) {
                Toast.makeText(activity, this.f54791b, this.f54792c).show();
            }
        }
    }

    /* renamed from: a */
    public static void m70705a() {
        if (f54788a != null) {
            f54788a.cancel();
            f54788a = null;
        }
        if (f54789b != null) {
            f54789b.cancel();
            f54789b = null;
        }
    }

    /* renamed from: b */
    public static void m70706b(Activity activity, String str, int i10) {
        if (activity == null) {
            C11839m.m70687e("ToastUtil", "context is null");
            return;
        }
        try {
            if (f54789b == null) {
                f54789b = Toast.makeText(activity, str, i10);
            } else {
                f54789b.setText(str);
                f54789b.setDuration(i10);
            }
            f54789b.show();
        } catch (Exception unused) {
            activity.runOnUiThread(new a(activity, str, i10));
        }
    }

    /* renamed from: c */
    public static void m70707c(Context context, int i10, int i11) {
        if (context == null) {
            C11839m.m70687e("ToastUtil", "context is null");
        } else {
            m70708d(context, context.getString(i10), i11);
        }
    }

    /* renamed from: d */
    public static void m70708d(Context context, String str, int i10) {
        if (context == null) {
            C11839m.m70687e("ToastUtil", "context is null");
            return;
        }
        try {
            if (f54788a == null) {
                f54788a = Toast.makeText(context.getApplicationContext(), str, i10);
            } else {
                f54788a.setText(str);
                f54788a.setDuration(i10);
            }
            f54788a.show();
        } catch (Exception unused) {
            Looper.prepare();
            Toast.makeText(context, str, i10).show();
            Looper.loop();
        }
    }
}
