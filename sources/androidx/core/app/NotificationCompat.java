package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import p694v.C13310l;
import p694v.InterfaceC13303e;

/* loaded from: classes.dex */
public class NotificationCompat {

    /* renamed from: androidx.core.app.NotificationCompat$a */
    public static class C0604a {

        /* renamed from: a */
        public final Bundle f3361a;

        /* renamed from: b */
        public IconCompat f3362b;

        /* renamed from: c */
        public final C13310l[] f3363c;

        /* renamed from: d */
        public final C13310l[] f3364d;

        /* renamed from: e */
        public boolean f3365e;

        /* renamed from: f */
        public boolean f3366f;

        /* renamed from: g */
        public final int f3367g;

        /* renamed from: h */
        public final boolean f3368h;

        /* renamed from: i */
        @Deprecated
        public int f3369i;

        /* renamed from: j */
        public CharSequence f3370j;

        /* renamed from: k */
        public PendingIntent f3371k;

        /* renamed from: l */
        public boolean f3372l;

        public C0604a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.m3908k(null, "", i10) : null, charSequence, pendingIntent);
        }

        /* renamed from: a */
        public PendingIntent m3826a() {
            return this.f3371k;
        }

        /* renamed from: b */
        public boolean m3827b() {
            return this.f3365e;
        }

        /* renamed from: c */
        public Bundle m3828c() {
            return this.f3361a;
        }

        /* renamed from: d */
        public IconCompat m3829d() {
            int i10;
            if (this.f3362b == null && (i10 = this.f3369i) != 0) {
                this.f3362b = IconCompat.m3908k(null, "", i10);
            }
            return this.f3362b;
        }

        /* renamed from: e */
        public C13310l[] m3830e() {
            return this.f3363c;
        }

        /* renamed from: f */
        public int m3831f() {
            return this.f3367g;
        }

        /* renamed from: g */
        public boolean m3832g() {
            return this.f3366f;
        }

        /* renamed from: h */
        public CharSequence m3833h() {
            return this.f3370j;
        }

        /* renamed from: i */
        public boolean m3834i() {
            return this.f3372l;
        }

        /* renamed from: j */
        public boolean m3835j() {
            return this.f3368h;
        }

        public C0604a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        public C0604a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, C13310l[] c13310lArr, C13310l[] c13310lArr2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
            this.f3366f = true;
            this.f3362b = iconCompat;
            if (iconCompat != null && iconCompat.m3915o() == 2) {
                this.f3369i = iconCompat.m3913l();
            }
            this.f3370j = Builder.m3797g(charSequence);
            this.f3371k = pendingIntent;
            this.f3361a = bundle == null ? new Bundle() : bundle;
            this.f3363c = c13310lArr;
            this.f3364d = c13310lArr2;
            this.f3365e = z10;
            this.f3367g = i10;
            this.f3366f = z11;
            this.f3368h = z12;
            this.f3372l = z13;
        }
    }

    /* renamed from: androidx.core.app.NotificationCompat$b */
    public static class C0605b extends AbstractC0608e {

        /* renamed from: e */
        public CharSequence f3373e;

        @Override // androidx.core.app.NotificationCompat.AbstractC0608e
        /* renamed from: a */
        public void mo3836a(Bundle bundle) {
            super.mo3836a(bundle);
        }

        @Override // androidx.core.app.NotificationCompat.AbstractC0608e
        /* renamed from: b */
        public void mo3837b(InterfaceC13303e interfaceC13303e) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(interfaceC13303e.mo3846a()).setBigContentTitle(this.f3375b).bigText(this.f3373e);
            if (this.f3377d) {
                bigTextStyleBigText.setSummaryText(this.f3376c);
            }
        }

        @Override // androidx.core.app.NotificationCompat.AbstractC0608e
        /* renamed from: c */
        public String mo3838c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        /* renamed from: h */
        public C0605b m3839h(CharSequence charSequence) {
            this.f3373e = Builder.m3797g(charSequence);
            return this;
        }

        /* renamed from: i */
        public C0605b m3840i(CharSequence charSequence) {
            this.f3375b = Builder.m3797g(charSequence);
            return this;
        }
    }

    /* renamed from: androidx.core.app.NotificationCompat$c */
    public static final class C0606c {
        /* renamed from: a */
        public static Notification.BubbleMetadata m3841a(C0606c c0606c) {
            return null;
        }
    }

    /* renamed from: androidx.core.app.NotificationCompat$d */
    public static class C0607d extends AbstractC0608e {
        @Override // androidx.core.app.NotificationCompat.AbstractC0608e
        /* renamed from: b */
        public void mo3837b(InterfaceC13303e interfaceC13303e) {
            interfaceC13303e.mo3846a().setStyle(new Notification.DecoratedCustomViewStyle());
        }

        @Override // androidx.core.app.NotificationCompat.AbstractC0608e
        /* renamed from: c */
        public String mo3838c() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // androidx.core.app.NotificationCompat.AbstractC0608e
        /* renamed from: d */
        public RemoteViews mo3842d(InterfaceC13303e interfaceC13303e) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.AbstractC0608e
        /* renamed from: e */
        public RemoteViews mo3843e(InterfaceC13303e interfaceC13303e) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.AbstractC0608e
        /* renamed from: f */
        public RemoteViews mo3844f(InterfaceC13303e interfaceC13303e) {
            return null;
        }
    }

    /* renamed from: androidx.core.app.NotificationCompat$e */
    public static abstract class AbstractC0608e {

        /* renamed from: a */
        public Builder f3374a;

        /* renamed from: b */
        public CharSequence f3375b;

        /* renamed from: c */
        public CharSequence f3376c;

        /* renamed from: d */
        public boolean f3377d = false;

        /* renamed from: a */
        public void mo3836a(Bundle bundle) {
            if (this.f3377d) {
                bundle.putCharSequence("android.summaryText", this.f3376c);
            }
            CharSequence charSequence = this.f3375b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strMo3838c = mo3838c();
            if (strMo3838c != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strMo3838c);
            }
        }

        /* renamed from: b */
        public abstract void mo3837b(InterfaceC13303e interfaceC13303e);

        /* renamed from: c */
        public abstract String mo3838c();

        /* renamed from: d */
        public RemoteViews mo3842d(InterfaceC13303e interfaceC13303e) {
            return null;
        }

        /* renamed from: e */
        public RemoteViews mo3843e(InterfaceC13303e interfaceC13303e) {
            return null;
        }

        /* renamed from: f */
        public RemoteViews mo3844f(InterfaceC13303e interfaceC13303e) {
            return null;
        }

        /* renamed from: g */
        public void m3845g(Builder builder) {
            if (this.f3374a != builder) {
                this.f3374a = builder;
                if (builder != null) {
                    builder.m3825z(this);
                }
            }
        }
    }

    /* renamed from: a */
    public static Bundle m3796a(Notification notification) {
        return notification.extras;
    }

    public static class Builder {

        /* renamed from: A */
        public boolean f3313A;

        /* renamed from: B */
        public boolean f3314B;

        /* renamed from: C */
        public String f3315C;

        /* renamed from: D */
        public Bundle f3316D;

        /* renamed from: E */
        public int f3317E;

        /* renamed from: F */
        public int f3318F;

        /* renamed from: G */
        public Notification f3319G;

        /* renamed from: H */
        public RemoteViews f3320H;

        /* renamed from: I */
        public RemoteViews f3321I;

        /* renamed from: J */
        public RemoteViews f3322J;

        /* renamed from: K */
        public String f3323K;

        /* renamed from: L */
        public int f3324L;

        /* renamed from: M */
        public String f3325M;

        /* renamed from: N */
        public LocusIdCompat f3326N;

        /* renamed from: O */
        public long f3327O;

        /* renamed from: P */
        public int f3328P;

        /* renamed from: Q */
        public int f3329Q;

        /* renamed from: R */
        public boolean f3330R;

        /* renamed from: S */
        public Notification f3331S;

        /* renamed from: T */
        public boolean f3332T;

        /* renamed from: U */
        public Icon f3333U;

        /* renamed from: V */
        @Deprecated
        public ArrayList<String> f3334V;

        /* renamed from: a */
        public Context f3335a;

        /* renamed from: b */
        public ArrayList<C0604a> f3336b;

        /* renamed from: c */
        public ArrayList<C0611c> f3337c;

        /* renamed from: d */
        public ArrayList<C0604a> f3338d;

        /* renamed from: e */
        public CharSequence f3339e;

        /* renamed from: f */
        public CharSequence f3340f;

        /* renamed from: g */
        public PendingIntent f3341g;

        /* renamed from: h */
        public PendingIntent f3342h;

        /* renamed from: i */
        public RemoteViews f3343i;

        /* renamed from: j */
        public Bitmap f3344j;

        /* renamed from: k */
        public CharSequence f3345k;

        /* renamed from: l */
        public int f3346l;

        /* renamed from: m */
        public int f3347m;

        /* renamed from: n */
        public boolean f3348n;

        /* renamed from: o */
        public boolean f3349o;

        /* renamed from: p */
        public AbstractC0608e f3350p;

        /* renamed from: q */
        public CharSequence f3351q;

        /* renamed from: r */
        public CharSequence f3352r;

        /* renamed from: s */
        public CharSequence[] f3353s;

        /* renamed from: t */
        public int f3354t;

        /* renamed from: u */
        public int f3355u;

        /* renamed from: v */
        public boolean f3356v;

        /* renamed from: w */
        public String f3357w;

        /* renamed from: x */
        public boolean f3358x;

        /* renamed from: y */
        public String f3359y;

        /* renamed from: z */
        public boolean f3360z;

        public Builder(Context context, String str) {
            this.f3336b = new ArrayList<>();
            this.f3337c = new ArrayList<>();
            this.f3338d = new ArrayList<>();
            this.f3348n = true;
            this.f3360z = false;
            this.f3317E = 0;
            this.f3318F = 0;
            this.f3324L = 0;
            this.f3328P = 0;
            this.f3329Q = 0;
            Notification notification = new Notification();
            this.f3331S = notification;
            this.f3335a = context;
            this.f3323K = str;
            notification.when = System.currentTimeMillis();
            this.f3331S.audioStreamType = -1;
            this.f3347m = 0;
            this.f3334V = new ArrayList<>();
            this.f3330R = true;
        }

        /* renamed from: g */
        public static CharSequence m3797g(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        /* renamed from: A */
        public Builder m3798A(CharSequence charSequence) {
            this.f3351q = m3797g(charSequence);
            return this;
        }

        /* renamed from: B */
        public Builder m3799B(CharSequence charSequence) {
            this.f3331S.tickerText = m3797g(charSequence);
            return this;
        }

        /* renamed from: C */
        public Builder m3800C(long j10) {
            this.f3331S.when = j10;
            return this;
        }

        /* renamed from: a */
        public Builder m3801a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f3336b.add(new C0604a(i10, charSequence, pendingIntent));
            return this;
        }

        /* renamed from: b */
        public Builder m3802b(C0604a c0604a) {
            if (c0604a != null) {
                this.f3336b.add(c0604a);
            }
            return this;
        }

        /* renamed from: c */
        public Builder m3803c(Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.f3316D;
                if (bundle2 == null) {
                    this.f3316D = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        /* renamed from: d */
        public Notification m3804d() {
            return new C0609a(this).m3848c();
        }

        /* renamed from: e */
        public Builder m3805e() {
            this.f3336b.clear();
            return this;
        }

        /* renamed from: f */
        public Bundle m3806f() {
            if (this.f3316D == null) {
                this.f3316D = new Bundle();
            }
            return this.f3316D;
        }

        /* renamed from: h */
        public Builder m3807h(boolean z10) {
            m3816q(16, z10);
            return this;
        }

        /* renamed from: i */
        public Builder m3808i(String str) {
            this.f3315C = str;
            return this;
        }

        /* renamed from: j */
        public Builder m3809j(PendingIntent pendingIntent) {
            this.f3341g = pendingIntent;
            return this;
        }

        /* renamed from: k */
        public Builder m3810k(CharSequence charSequence) {
            this.f3340f = m3797g(charSequence);
            return this;
        }

        /* renamed from: l */
        public Builder m3811l(CharSequence charSequence) {
            this.f3339e = m3797g(charSequence);
            return this;
        }

        /* renamed from: m */
        public Builder m3812m(RemoteViews remoteViews) {
            this.f3321I = remoteViews;
            return this;
        }

        /* renamed from: n */
        public Builder m3813n(int i10) {
            Notification notification = this.f3331S;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        /* renamed from: o */
        public Builder m3814o(PendingIntent pendingIntent) {
            this.f3331S.deleteIntent = pendingIntent;
            return this;
        }

        /* renamed from: p */
        public Builder m3815p(Bundle bundle) {
            this.f3316D = bundle;
            return this;
        }

        /* renamed from: q */
        public final void m3816q(int i10, boolean z10) {
            if (z10) {
                Notification notification = this.f3331S;
                notification.flags = i10 | notification.flags;
            } else {
                Notification notification2 = this.f3331S;
                notification2.flags = (~i10) & notification2.flags;
            }
        }

        /* renamed from: r */
        public Builder m3817r(String str) {
            this.f3357w = str;
            return this;
        }

        /* renamed from: s */
        public Builder m3818s(boolean z10) {
            this.f3358x = z10;
            return this;
        }

        /* renamed from: t */
        public Builder m3819t(boolean z10) {
            m3816q(2, z10);
            return this;
        }

        /* renamed from: u */
        public Builder m3820u(boolean z10) {
            m3816q(8, z10);
            return this;
        }

        /* renamed from: v */
        public Builder m3821v(int i10) {
            this.f3347m = i10;
            return this;
        }

        /* renamed from: w */
        public Builder m3822w(int i10, int i11, boolean z10) {
            this.f3354t = i10;
            this.f3355u = i11;
            this.f3356v = z10;
            return this;
        }

        /* renamed from: x */
        public Builder m3823x(boolean z10) {
            this.f3348n = z10;
            return this;
        }

        /* renamed from: y */
        public Builder m3824y(int i10) {
            this.f3331S.icon = i10;
            return this;
        }

        /* renamed from: z */
        public Builder m3825z(AbstractC0608e abstractC0608e) {
            if (this.f3350p != abstractC0608e) {
                this.f3350p = abstractC0608e;
                if (abstractC0608e != null) {
                    abstractC0608e.m3845g(this);
                }
            }
            return this;
        }

        @Deprecated
        public Builder(Context context) {
            this(context, null);
        }
    }
}
