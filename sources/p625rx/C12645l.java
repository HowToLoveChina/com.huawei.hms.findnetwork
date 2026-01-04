package p625rx;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: rx.l */
/* loaded from: classes9.dex */
public class C12645l {

    /* renamed from: a */
    public a f58104a;

    /* renamed from: b */
    public Context f58105b;

    /* renamed from: c */
    public Activity f58106c;

    /* renamed from: d */
    public WeakReference<Context> f58107d;

    /* renamed from: rx.l$a */
    public interface a {
        /* renamed from: a */
        void mo38539a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12645l(Activity activity) {
        this.f58105b = activity;
        this.f58107d = new WeakReference<>(this.f58105b);
        this.f58106c = activity;
        if (activity instanceof a) {
            this.f58104a = (a) activity;
        }
    }

    /* renamed from: a */
    public int m76172a(int i10) {
        return this.f58105b.getResources().getColor(i10, this.f58105b.getTheme());
    }
}
