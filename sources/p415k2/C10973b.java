package p415k2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import java.nio.ByteBuffer;
import java.util.List;
import p002a1.AbstractC0002a;
import p415k2.C10977f;
import p630s2.C12676k;
import p725w1.InterfaceC13516a;
import p759x1.InterfaceC13688m;

/* renamed from: k2.b */
/* loaded from: classes.dex */
public class C10973b extends Drawable implements C10977f.b, Animatable {

    /* renamed from: a */
    public final a f51998a;

    /* renamed from: b */
    public boolean f51999b;

    /* renamed from: c */
    public boolean f52000c;

    /* renamed from: d */
    public boolean f52001d;

    /* renamed from: e */
    public boolean f52002e;

    /* renamed from: f */
    public int f52003f;

    /* renamed from: g */
    public int f52004g;

    /* renamed from: h */
    public boolean f52005h;

    /* renamed from: i */
    public Paint f52006i;

    /* renamed from: j */
    public Rect f52007j;

    /* renamed from: k */
    public List<AbstractC0002a> f52008k;

    /* renamed from: k2.b$a */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a */
        public final C10977f f52009a;

        public a(C10977f c10977f) {
            this.f52009a = c10977f;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C10973b(this);
        }
    }

    public C10973b(Context context, InterfaceC13516a interfaceC13516a, InterfaceC13688m<Bitmap> interfaceC13688m, int i10, int i11, Bitmap bitmap) {
        this(new a(new C10977f(ComponentCallbacks2C1546b.m8898c(context), interfaceC13516a, i10, i11, interfaceC13688m, bitmap)));
    }

    @Override // p415k2.C10977f.b
    /* renamed from: a */
    public void mo66303a() {
        if (m66304b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (m66309g() == m66308f() - 1) {
            this.f52003f++;
        }
        int i10 = this.f52004g;
        if (i10 == -1 || this.f52003f < i10) {
            return;
        }
        m66312j();
        stop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final Drawable.Callback m66304b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    /* renamed from: c */
    public ByteBuffer m66305c() {
        return this.f51998a.f52009a.m66322b();
    }

    /* renamed from: d */
    public final Rect m66306d() {
        if (this.f52007j == null) {
            this.f52007j = new Rect();
        }
        return this.f52007j;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f52001d) {
            return;
        }
        if (this.f52005h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), m66306d());
            this.f52005h = false;
        }
        canvas.drawBitmap(this.f51998a.f52009a.m66323c(), (Rect) null, m66306d(), m66310h());
    }

    /* renamed from: e */
    public Bitmap m66307e() {
        return this.f51998a.f52009a.m66325e();
    }

    /* renamed from: f */
    public int m66308f() {
        return this.f51998a.f52009a.m66326f();
    }

    /* renamed from: g */
    public int m66309g() {
        return this.f51998a.f52009a.m66324d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f51998a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f51998a.f52009a.m66327h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f51998a.f52009a.m66329k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    /* renamed from: h */
    public final Paint m66310h() {
        if (this.f52006i == null) {
            this.f52006i = new Paint(2);
        }
        return this.f52006i;
    }

    /* renamed from: i */
    public int m66311i() {
        return this.f51998a.f52009a.m66328j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f51999b;
    }

    /* renamed from: j */
    public final void m66312j() {
        List<AbstractC0002a> list = this.f52008k;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f52008k.get(i10).mo2a(this);
            }
        }
    }

    /* renamed from: k */
    public void m66313k() {
        this.f52001d = true;
        this.f51998a.f52009a.m66321a();
    }

    /* renamed from: l */
    public final void m66314l() {
        this.f52003f = 0;
    }

    /* renamed from: m */
    public void m66315m(InterfaceC13688m<Bitmap> interfaceC13688m, Bitmap bitmap) {
        this.f51998a.f52009a.m66333o(interfaceC13688m, bitmap);
    }

    /* renamed from: n */
    public final void m66316n() {
        C12676k.m76273a(!this.f52001d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f51998a.f52009a.m66326f() == 1) {
            invalidateSelf();
        } else {
            if (this.f51999b) {
                return;
            }
            this.f51999b = true;
            this.f51998a.f52009a.m66336r(this);
            invalidateSelf();
        }
    }

    /* renamed from: o */
    public final void m66317o() {
        this.f51999b = false;
        this.f51998a.f52009a.m66337s(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f52005h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        m66310h().setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        m66310h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        C12676k.m76273a(!this.f52001d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f52002e = z10;
        if (!z10) {
            m66317o();
        } else if (this.f52000c) {
            m66316n();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f52000c = true;
        m66314l();
        if (this.f52002e) {
            m66316n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f52000c = false;
        m66317o();
    }

    public C10973b(a aVar) {
        this.f52002e = true;
        this.f52004g = -1;
        this.f51998a = (a) C12676k.m76276d(aVar);
    }
}
