package com.huawei.android.p069cg.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.BabyInfo;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.p071ui.FilterConditionAdapter;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p031b7.C1120a;
import p514o9.C11829c;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13224c;
import p709vj.C13452e;
import sk.C12809f;

/* renamed from: com.huawei.android.cg.activity.a */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC2256a implements View.OnClickListener {

    /* renamed from: b0 */
    public static final CharSequence f10693b0 = "LLL";

    /* renamed from: A */
    public RelativeLayout f10694A;

    /* renamed from: B */
    public ImageView f10695B;

    /* renamed from: C */
    public TextView f10696C;

    /* renamed from: D */
    public LinearLayout f10697D;

    /* renamed from: E */
    public ImageView f10698E;

    /* renamed from: F */
    public TextView f10699F;

    /* renamed from: G */
    public LinearLayout f10700G;

    /* renamed from: H */
    public ImageView f10701H;

    /* renamed from: I */
    public TextView f10702I;

    /* renamed from: J */
    public LinearLayout f10703J;

    /* renamed from: K */
    public ImageView f10704K;

    /* renamed from: L */
    public TextView f10705L;

    /* renamed from: M */
    public LinearLayout f10706M;

    /* renamed from: N */
    public TextView f10707N;

    /* renamed from: O */
    public LinearLayout f10708O;

    /* renamed from: P */
    public LinearLayout f10709P;

    /* renamed from: Q */
    public TextView f10710Q;

    /* renamed from: R */
    public ImageView f10711R;

    /* renamed from: S */
    public ImageView f10712S;

    /* renamed from: T */
    public LinearLayout f10713T;

    /* renamed from: U */
    public ScrollView f10714U;

    /* renamed from: V */
    public Album f10715V;

    /* renamed from: W */
    public boolean f10716W;

    /* renamed from: X */
    public boolean f10717X;

    /* renamed from: Z */
    public View f10719Z;

    /* renamed from: a */
    public LinearLayout f10720a;

    /* renamed from: b */
    public HwRecyclerView f10722b;

    /* renamed from: c */
    public FilterConditionAdapter f10723c;

    /* renamed from: d */
    public HwRecyclerView f10724d;

    /* renamed from: e */
    public FilterConditionAdapter f10725e;

    /* renamed from: f */
    public HwRecyclerView f10726f;

    /* renamed from: g */
    public FilterConditionAdapter f10727g;

    /* renamed from: h */
    public Context f10728h;

    /* renamed from: i */
    public Activity f10729i;

    /* renamed from: j */
    public Map<String, List<String>> f10730j;

    /* renamed from: k */
    public Map<String, Long> f10731k;

    /* renamed from: l */
    public List<String> f10732l;

    /* renamed from: m */
    public List<String> f10733m;

    /* renamed from: n */
    public Map<String, Map<String, List<String>>> f10734n;

    /* renamed from: o */
    public Map<String, List<String>> f10735o;

    /* renamed from: p */
    public List<String> f10736p;

    /* renamed from: q */
    public List<String> f10737q;

    /* renamed from: r */
    public List<String> f10738r;

    /* renamed from: s */
    public String f10739s;

    /* renamed from: t */
    public String f10740t;

    /* renamed from: u */
    public String f10741u;

    /* renamed from: v */
    public List<Long> f10742v;

    /* renamed from: w */
    public d f10743w;

    /* renamed from: x */
    public RelativeLayout f10744x;

    /* renamed from: y */
    public ImageView f10745y;

    /* renamed from: z */
    public TextView f10746z;

    /* renamed from: Y */
    public boolean f10718Y = true;

    /* renamed from: a0 */
    public Handler f10721a0 = new c();

    /* renamed from: com.huawei.android.cg.activity.a$a */
    public class a extends AbstractC12367d {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            ViewOnClickListenerC2256a.this.f10734n = new HashMap();
            Iterator it = ViewOnClickListenerC2256a.this.f10742v.iterator();
            while (it.hasNext()) {
                ViewOnClickListenerC2256a.this.m14060f0(((Long) it.next()).longValue());
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 291;
            ViewOnClickListenerC2256a.this.f10721a0.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.a$b */
    public class b extends AbstractC12367d {
        public b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Resources.NotFoundException {
            ViewOnClickListenerC2256a.this.f10730j = new HashMap();
            ViewOnClickListenerC2256a.this.f10731k = new HashMap();
            Iterator it = ViewOnClickListenerC2256a.this.f10742v.iterator();
            while (it.hasNext()) {
                ViewOnClickListenerC2256a.this.m14059e0(((Long) it.next()).longValue());
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 292;
            ViewOnClickListenerC2256a.this.f10721a0.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.a$c */
    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 291) {
                if (i10 == 292) {
                    C1120a.m6675d("ShareAlbumGuideDialog", "FILTER_AGE_INIT_SUCCESS");
                    ViewOnClickListenerC2256a.this.m14042N();
                    ViewOnClickListenerC2256a viewOnClickListenerC2256a = ViewOnClickListenerC2256a.this;
                    viewOnClickListenerC2256a.m14043O(0, (String) viewOnClickListenerC2256a.f10732l.get(0));
                    ViewOnClickListenerC2256a viewOnClickListenerC2256a2 = ViewOnClickListenerC2256a.this;
                    viewOnClickListenerC2256a2.f10739s = (String) viewOnClickListenerC2256a2.f10732l.get(0);
                    return;
                }
                return;
            }
            ViewOnClickListenerC2256a.this.m14051W();
            ViewOnClickListenerC2256a viewOnClickListenerC2256a3 = ViewOnClickListenerC2256a.this;
            viewOnClickListenerC2256a3.m14047S(0, (String) viewOnClickListenerC2256a3.f10736p.get(0));
            ViewOnClickListenerC2256a viewOnClickListenerC2256a4 = ViewOnClickListenerC2256a.this;
            viewOnClickListenerC2256a4.m14046R((String) viewOnClickListenerC2256a4.f10737q.get(0));
            ViewOnClickListenerC2256a viewOnClickListenerC2256a5 = ViewOnClickListenerC2256a.this;
            viewOnClickListenerC2256a5.f10739s = (String) viewOnClickListenerC2256a5.f10736p.get(0);
            ViewOnClickListenerC2256a viewOnClickListenerC2256a6 = ViewOnClickListenerC2256a.this;
            viewOnClickListenerC2256a6.f10740t = (String) viewOnClickListenerC2256a6.f10737q.get(0);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.a$d */
    public interface d {
        /* renamed from: a */
        void mo13855a(long j10, boolean z10, boolean z11);

        /* renamed from: b */
        void mo13856b(boolean z10);

        /* renamed from: c */
        void mo13857c(boolean z10, boolean z11);
    }

    /* renamed from: com.huawei.android.cg.activity.a$e */
    public class e implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 3598808232543560547L;

        public e() {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int compare(java.lang.String r7, java.lang.String r8) {
            /*
                r6 = this;
                com.huawei.android.cg.activity.a r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this
                java.util.Map r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14021o(r0)
                r1 = 0
                if (r0 == 0) goto Ld9
                com.huawei.android.cg.activity.a r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this
                java.util.Map r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14021o(r0)
                int r0 = r0.size()
                if (r0 == 0) goto Ld9
                com.huawei.android.cg.activity.a r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this
                java.util.Map r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14023q(r0)
                if (r0 == 0) goto Ld9
                com.huawei.android.cg.activity.a r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this
                java.util.Map r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14023q(r0)
                int r0 = r0.size()
                if (r0 != 0) goto L2b
                goto Ld9
            L2b:
                r2 = 0
                com.huawei.android.cg.activity.a r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this     // Catch: java.lang.Exception -> L71
                java.util.Map r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14021o(r0)     // Catch: java.lang.Exception -> L71
                java.lang.Object r0 = r0.get(r7)     // Catch: java.lang.Exception -> L71
                if (r0 == 0) goto L74
                com.huawei.android.cg.activity.a r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this     // Catch: java.lang.Exception -> L71
                java.util.Map r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14021o(r0)     // Catch: java.lang.Exception -> L71
                java.lang.Object r0 = r0.get(r7)     // Catch: java.lang.Exception -> L71
                java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Exception -> L71
                java.util.Objects.requireNonNull(r0)     // Catch: java.lang.Exception -> L71
                java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Exception -> L71
                int r0 = r0.size()     // Catch: java.lang.Exception -> L71
                if (r0 <= 0) goto L74
                com.huawei.android.cg.activity.a r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this     // Catch: java.lang.Exception -> L71
                java.util.Map r0 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14023q(r0)     // Catch: java.lang.Exception -> L71
                com.huawei.android.cg.activity.a r4 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this     // Catch: java.lang.Exception -> L71
                java.util.Map r4 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14021o(r4)     // Catch: java.lang.Exception -> L71
                java.lang.Object r7 = r4.get(r7)     // Catch: java.lang.Exception -> L71
                java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Exception -> L71
                java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Exception -> L71
                java.lang.Object r7 = r0.get(r7)     // Catch: java.lang.Exception -> L71
                java.lang.Long r7 = (java.lang.Long) r7     // Catch: java.lang.Exception -> L71
                long r4 = r7.longValue()     // Catch: java.lang.Exception -> L71
                goto L75
            L71:
                r6 = move-exception
                r4 = r2
                goto Lba
            L74:
                r4 = r2
            L75:
                com.huawei.android.cg.activity.a r7 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this     // Catch: java.lang.Exception -> Lb9
                java.util.Map r7 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14021o(r7)     // Catch: java.lang.Exception -> Lb9
                java.lang.Object r7 = r7.get(r8)     // Catch: java.lang.Exception -> Lb9
                if (r7 == 0) goto Ld4
                com.huawei.android.cg.activity.a r7 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this     // Catch: java.lang.Exception -> Lb9
                java.util.Map r7 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14021o(r7)     // Catch: java.lang.Exception -> Lb9
                java.lang.Object r7 = r7.get(r8)     // Catch: java.lang.Exception -> Lb9
                java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Exception -> Lb9
                java.util.Objects.requireNonNull(r7)     // Catch: java.lang.Exception -> Lb9
                java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Exception -> Lb9
                int r7 = r7.size()     // Catch: java.lang.Exception -> Lb9
                if (r7 <= 0) goto Ld4
                com.huawei.android.cg.activity.a r7 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this     // Catch: java.lang.Exception -> Lb9
                java.util.Map r7 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14023q(r7)     // Catch: java.lang.Exception -> Lb9
                com.huawei.android.cg.activity.a r6 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.this     // Catch: java.lang.Exception -> Lb9
                java.util.Map r6 = com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.m14021o(r6)     // Catch: java.lang.Exception -> Lb9
                java.lang.Object r6 = r6.get(r8)     // Catch: java.lang.Exception -> Lb9
                java.util.List r6 = (java.util.List) r6     // Catch: java.lang.Exception -> Lb9
                java.lang.Object r6 = r6.get(r1)     // Catch: java.lang.Exception -> Lb9
                java.lang.Object r6 = r7.get(r6)     // Catch: java.lang.Exception -> Lb9
                java.lang.Long r6 = (java.lang.Long) r6     // Catch: java.lang.Exception -> Lb9
                long r2 = r6.longValue()     // Catch: java.lang.Exception -> Lb9
                goto Ld4
            Lb9:
                r6 = move-exception
            Lba:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = "e "
                r7.append(r8)
                java.lang.String r6 = r6.getMessage()
                r7.append(r6)
                java.lang.String r6 = r7.toString()
                java.lang.String r7 = "ShareAlbumGuideDialog"
                p031b7.C1120a.m6676e(r7, r6)
            Ld4:
                int r6 = java.lang.Long.compare(r2, r4)
                return r6
            Ld9:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.e.compare(java.lang.String, java.lang.String):int");
        }

        public /* synthetic */ e(ViewOnClickListenerC2256a viewOnClickListenerC2256a, a aVar) {
            this();
        }
    }

    /* renamed from: com.huawei.android.cg.activity.a$f */
    public class f implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 6169651831759929977L;

        public f() {
        }

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            long jLongValue;
            if (ViewOnClickListenerC2256a.this.f10731k == null || ViewOnClickListenerC2256a.this.f10731k.size() == 0) {
                return 0;
            }
            long jLongValue2 = 0;
            try {
                jLongValue = ((Long) ViewOnClickListenerC2256a.this.f10731k.get(str)).longValue();
                try {
                    jLongValue2 = ((Long) ViewOnClickListenerC2256a.this.f10731k.get(str2)).longValue();
                } catch (Exception e10) {
                    e = e10;
                    C1120a.m6676e("ShareAlbumGuideDialog", "e " + e.getMessage());
                    return Long.compare(jLongValue2, jLongValue);
                }
            } catch (Exception e11) {
                e = e11;
                jLongValue = 0;
            }
            return Long.compare(jLongValue2, jLongValue);
        }

        public /* synthetic */ f(ViewOnClickListenerC2256a viewOnClickListenerC2256a, a aVar) {
            this();
        }
    }

    public ViewOnClickListenerC2256a(Activity activity, Context context) {
        this.f10728h = context;
        this.f10729i = activity;
        m14032D();
    }

    /* renamed from: A */
    public final void m14029A() {
        m14033E();
        m14031C();
        m14030B();
        Album album = this.f10715V;
        if (album != null) {
            this.f10709P.setVisibility(1 == album.getShareType().intValue() ? 0 : 8);
        }
        if (!this.f10717X && !this.f10716W) {
            m14049U();
            m14044P(true);
        }
        if (this.f10716W) {
            m14049U();
            m14048T(true);
        }
        if (this.f10717X) {
            m14049U();
            m14050V(true);
        }
        if (this.f10718Y) {
            m14041M(true);
            m14055a0(false);
        } else {
            m14041M(false);
            m14055a0(true);
        }
        m14054Z();
        m14053Y(true);
        m14058d0();
    }

    /* renamed from: B */
    public final void m14030B() {
        FilterConditionAdapter filterConditionAdapter = new FilterConditionAdapter(this.f10728h);
        this.f10727g = filterConditionAdapter;
        filterConditionAdapter.m14704G(new FilterConditionAdapter.InterfaceC2338c() { // from class: k6.t
            @Override // com.huawei.android.p069cg.p071ui.FilterConditionAdapter.InterfaceC2338c
            /* renamed from: a */
            public final void mo14707a(int i10, String str) {
                this.f52074a.m14034F(i10, str);
            }
        });
        this.f10726f.setLayoutManager(new LinearLayoutManager(this.f10728h, 1, false));
        this.f10726f.setAdapter(this.f10727g);
    }

    /* renamed from: C */
    public final void m14031C() {
        FilterConditionAdapter filterConditionAdapter = new FilterConditionAdapter(this.f10728h);
        this.f10725e = filterConditionAdapter;
        filterConditionAdapter.m14704G(new FilterConditionAdapter.InterfaceC2338c() { // from class: k6.r
            @Override // com.huawei.android.p069cg.p071ui.FilterConditionAdapter.InterfaceC2338c
            /* renamed from: a */
            public final void mo14707a(int i10, String str) {
                this.f52072a.m14035G(i10, str);
            }
        });
        this.f10724d.setLayoutManager(new LinearLayoutManager(this.f10728h, 1, false));
        this.f10724d.setAdapter(this.f10725e);
    }

    /* renamed from: D */
    public final void m14032D() {
        this.f10714U = (ScrollView) C12809f.m76829b(this.f10729i, R$id.filter_container);
        this.f10713T = (LinearLayout) C12809f.m76829b(this.f10729i, R$id.llay_filter_root);
        this.f10720a = (LinearLayout) C12809f.m76829b(this.f10729i, R$id.llay_filter_month);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this.f10729i, R$id.llay_big);
        this.f10744x = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this.f10729i, R$id.llay_small);
        this.f10694A = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this.f10729i, R$id.llay_all);
        this.f10697D = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this.f10729i, R$id.llay_only_pic);
        this.f10700G = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) C12809f.m76829b(this.f10729i, R$id.llay_only_video);
        this.f10703J = linearLayout3;
        linearLayout3.setOnClickListener(this);
        View viewM76829b = C12809f.m76829b(this.f10729i, R$id.filter_left_view);
        this.f10719Z = viewM76829b;
        viewM76829b.setOnClickListener(this);
        LinearLayout linearLayout4 = (LinearLayout) C12809f.m76829b(this.f10729i, R$id.rlay_filter_by_date);
        this.f10706M = linearLayout4;
        linearLayout4.setOnClickListener(this);
        LinearLayout linearLayout5 = (LinearLayout) C12809f.m76829b(this.f10729i, R$id.rlay_filter_by_age);
        this.f10708O = linearLayout5;
        linearLayout5.setOnClickListener(this);
        this.f10709P = (LinearLayout) C12809f.m76829b(this.f10729i, R$id.llay_filter_by_age);
        this.f10745y = (ImageView) C12809f.m76829b(this.f10729i, R$id.iv_big);
        this.f10746z = (TextView) C12809f.m76829b(this.f10729i, R$id.tv_big);
        this.f10695B = (ImageView) C12809f.m76829b(this.f10729i, R$id.iv_small);
        this.f10696C = (TextView) C12809f.m76829b(this.f10729i, R$id.tv_small);
        this.f10698E = (ImageView) C12809f.m76829b(this.f10729i, R$id.iv_all);
        this.f10699F = (TextView) C12809f.m76829b(this.f10729i, R$id.tv_all);
        this.f10701H = (ImageView) C12809f.m76829b(this.f10729i, R$id.iv_only_pic);
        this.f10702I = (TextView) C12809f.m76829b(this.f10729i, R$id.tv_only_pic);
        this.f10704K = (ImageView) C12809f.m76829b(this.f10729i, R$id.iv_only_video);
        this.f10705L = (TextView) C12809f.m76829b(this.f10729i, R$id.tv_only_video);
        this.f10710Q = (TextView) C12809f.m76829b(this.f10729i, R$id.tv_filter_by_age);
        this.f10707N = (TextView) C12809f.m76829b(this.f10729i, R$id.tv_filter_by_date);
        this.f10711R = (ImageView) C12809f.m76829b(this.f10729i, R$id.iv_age_indicate);
        this.f10712S = (ImageView) C12809f.m76829b(this.f10729i, R$id.iv_date_indicate);
        this.f10722b = (HwRecyclerView) C12809f.m76829b(this.f10729i, R$id.rv_filte_year);
        this.f10724d = (HwRecyclerView) C12809f.m76829b(this.f10729i, R$id.rv_filte_month);
        this.f10726f = (HwRecyclerView) C12809f.m76829b(this.f10729i, R$id.rv_filte_day);
    }

    /* renamed from: E */
    public final void m14033E() {
        FilterConditionAdapter filterConditionAdapter = new FilterConditionAdapter(this.f10728h);
        this.f10723c = filterConditionAdapter;
        filterConditionAdapter.m14704G(new FilterConditionAdapter.InterfaceC2338c() { // from class: k6.s
            @Override // com.huawei.android.p069cg.p071ui.FilterConditionAdapter.InterfaceC2338c
            /* renamed from: a */
            public final void mo14707a(int i10, String str) {
                this.f52073a.m14036H(i10, str);
            }
        });
        this.f10722b.setLayoutManager(new LinearLayoutManager(this.f10728h, 1, false));
        this.f10722b.setAdapter(this.f10723c);
    }

    /* renamed from: F */
    public final /* synthetic */ void m14034F(int i10, String str) {
        this.f10741u = str;
        m14037I();
    }

    /* renamed from: G */
    public final /* synthetic */ void m14035G(int i10, String str) {
        this.f10725e.m14705H(i10, 1);
        this.f10740t = str;
        this.f10725e.m5213j();
        m14046R(str);
    }

    /* renamed from: H */
    public final /* synthetic */ void m14036H(int i10, String str) {
        this.f10739s = str;
        this.f10723c.m14705H(i10, 0);
        this.f10723c.m5213j();
        if (!this.f10708O.isSelected()) {
            m14047S(0, str);
            m14046R(this.f10737q.get(0));
            return;
        }
        C1120a.m6675d("ShareAlbumGuideDialog", "select age " + str + " pos " + i10);
        m14043O(i10, str);
    }

    /* renamed from: I */
    public final void m14037I() {
        m14064z();
        if (this.f10708O.isSelected()) {
            long jLongValue = this.f10731k.get(this.f10741u).longValue();
            C1120a.m6675d("ShareAlbumGuideDialog", "selectDay " + this.f10741u + " selectMills " + jLongValue);
            this.f10743w.mo13855a(jLongValue, this.f10716W, this.f10717X);
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM月-dd日");
        String str = this.f10739s + "-" + this.f10740t + "-" + this.f10741u;
        C1120a.m6675d("ShareAlbumGuideDialog", "selectDateStr " + str);
        try {
            long time = simpleDateFormat.parse(str).getTime();
            this.f10743w.mo13855a(time, this.f10716W, this.f10717X);
            C1120a.m6675d("ShareAlbumGuideDialog", "selectMills " + time);
        } catch (ParseException e10) {
            C1120a.m6676e("ShareAlbumGuideDialog", "ParseException " + e10.getMessage());
        }
    }

    /* renamed from: J */
    public final void m14038J() {
        m14064z();
        this.f10743w.mo13856b(this.f10718Y);
    }

    /* renamed from: K */
    public final void m14039K() {
        m14064z();
        this.f10743w.mo13857c(this.f10716W, this.f10717X);
    }

    /* renamed from: L */
    public final void m14040L(String str) {
        C1120a.m6675d("ShareAlbumGuideDialog", "reportClickModeEvent eventCode " + str);
        C13224c.m79487f1().m79585f0(str, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", str, "1", "from_share_album_filter_view");
    }

    /* renamed from: M */
    public final void m14041M(boolean z10) {
        this.f10744x.setSelected(z10);
        this.f10745y.setSelected(z10);
        this.f10746z.setSelected(z10);
        if (z10) {
            this.f10718Y = true;
        }
    }

    /* renamed from: N */
    public final void m14042N() {
        ArrayList arrayList = new ArrayList(this.f10730j.keySet());
        this.f10732l = arrayList;
        Collections.sort(arrayList, new e(this, null));
        this.f10723c.m14703F(this.f10732l);
        this.f10723c.m5213j();
    }

    /* renamed from: O */
    public final void m14043O(int i10, String str) {
        ArrayList arrayList = new ArrayList();
        this.f10733m = arrayList;
        arrayList.addAll(this.f10730j.get(str));
        Collections.sort(this.f10733m, new f(this, null));
        this.f10727g.m14703F(this.f10733m);
        this.f10723c.m14705H(i10, 0);
        this.f10727g.m5213j();
    }

    /* renamed from: P */
    public final void m14044P(boolean z10) {
        this.f10697D.setSelected(z10);
        this.f10698E.setSelected(z10);
        this.f10699F.setSelected(z10);
        if (z10) {
            this.f10716W = false;
            this.f10717X = false;
        }
    }

    /* renamed from: Q */
    public void m14045Q(Album album, List<Long> list, boolean z10, boolean z11, boolean z12, d dVar) {
        this.f10715V = album;
        this.f10742v = list;
        this.f10716W = z10;
        this.f10717X = z11;
        this.f10743w = dVar;
        this.f10718Y = z12;
        m14029A();
    }

    /* renamed from: R */
    public final void m14046R(String str) {
        ArrayList arrayList = new ArrayList();
        this.f10738r = arrayList;
        arrayList.addAll(this.f10735o.get(str));
        Collections.sort(this.f10738r);
        Collections.reverse(this.f10738r);
        this.f10727g.m14703F(this.f10738r);
        this.f10727g.m5213j();
    }

    /* renamed from: S */
    public final void m14047S(int i10, String str) {
        this.f10735o = this.f10734n.get(str);
        ArrayList arrayList = new ArrayList(this.f10735o.keySet());
        this.f10737q = arrayList;
        Collections.sort(arrayList);
        Collections.reverse(this.f10737q);
        this.f10725e.m14703F(this.f10737q);
        this.f10740t = this.f10737q.get(0);
        this.f10725e.m14705H(i10, 1);
        this.f10725e.m5213j();
    }

    /* renamed from: T */
    public final void m14048T(boolean z10) {
        this.f10700G.setSelected(z10);
        this.f10701H.setSelected(z10);
        this.f10702I.setSelected(z10);
        if (z10) {
            this.f10716W = true;
            this.f10717X = false;
        }
    }

    /* renamed from: U */
    public final void m14049U() {
        m14044P(false);
        m14048T(false);
        m14050V(false);
    }

    /* renamed from: V */
    public final void m14050V(boolean z10) {
        this.f10703J.setSelected(z10);
        this.f10704K.setSelected(z10);
        this.f10705L.setSelected(z10);
        if (z10) {
            this.f10716W = false;
            this.f10717X = true;
        }
    }

    /* renamed from: W */
    public final void m14051W() {
        ArrayList arrayList = new ArrayList(this.f10734n.keySet());
        this.f10736p = arrayList;
        Collections.sort(arrayList);
        Collections.reverse(this.f10736p);
        this.f10723c.m14703F(this.f10736p);
        this.f10723c.m14705H(0, 0);
        this.f10723c.m5213j();
    }

    /* renamed from: X */
    public final void m14052X(boolean z10) {
        this.f10708O.setSelected(z10);
        this.f10710Q.setSelected(z10);
        this.f10711R.setVisibility(z10 ? 0 : 4);
        this.f10712S.setVisibility(z10 ? 4 : 0);
        this.f10720a.setVisibility(z10 ? 8 : 0);
    }

    /* renamed from: Y */
    public final void m14053Y(boolean z10) {
        this.f10706M.setSelected(z10);
        this.f10707N.setSelected(z10);
        this.f10712S.setVisibility(z10 ? 0 : 4);
        this.f10711R.setVisibility(z10 ? 4 : 0);
        this.f10720a.setVisibility(z10 ? 0 : 8);
    }

    /* renamed from: Z */
    public final void m14054Z() {
        m14052X(false);
        m14053Y(false);
    }

    /* renamed from: a0 */
    public final void m14055a0(boolean z10) {
        this.f10694A.setSelected(z10);
        this.f10695B.setSelected(z10);
        this.f10696C.setSelected(z10);
        if (z10) {
            this.f10718Y = false;
        }
    }

    /* renamed from: b0 */
    public void m14056b0() {
        LinearLayout linearLayout = this.f10713T;
        if (linearLayout == null || this.f10714U == null) {
            return;
        }
        linearLayout.setBackgroundColor(this.f10728h.getColor(R$color.color_33000000));
        this.f10713T.setVisibility(0);
        Animation animationMakeInAnimation = AnimationUtils.makeInAnimation(this.f10728h, false);
        animationMakeInAnimation.setDuration(300L);
        this.f10714U.setAnimation(animationMakeInAnimation);
    }

    /* renamed from: c0 */
    public final void m14057c0() {
        List<Long> list = this.f10742v;
        if (list == null || list.size() == 0) {
            C1120a.m6676e("ShareAlbumGuideDialog", " millsList is null");
        } else {
            C12515a.m75110o().m75175e(new b(), false);
        }
    }

    /* renamed from: d0 */
    public final void m14058d0() {
        List<Long> list = this.f10742v;
        if (list == null || list.size() == 0) {
            C1120a.m6676e("ShareAlbumGuideDialog", " millsList is null");
        } else {
            C12515a.m75110o().m75175e(new a(), false);
        }
    }

    /* renamed from: e0 */
    public final void m14059e0(long j10) throws Resources.NotFoundException {
        boolean z10;
        long jM14062x = m14062x();
        if (jM14062x == 0) {
            C1120a.m6676e("ShareAlbumGuideDialog", "transMillsToFilterAge babyBirthdayMills is 0");
            return;
        }
        long jAbs = j10 - jM14062x;
        C1120a.m6675d("ShareAlbumGuideDialog", "timeMills " + jAbs);
        if (jAbs < 0) {
            jAbs = Math.abs(jAbs);
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = jAbs > 567648000000L;
        int i10 = (int) (jAbs / 31536000000L);
        C1120a.m6675d("ShareAlbumGuideDialog", "transMillsToFilterAge age " + i10);
        if (i10 == 0) {
            String string = this.f10728h.getString(z10 ? R$string.filter_age_unborn : R$string.album_born_year);
            int i11 = (int) (jAbs / 2592000000L);
            Resources resources = this.f10728h.getResources();
            int i12 = z10 ? R$plurals.filter_age_unborn_month : R$plurals.baby_album_title_month;
            int i13 = i11 == 0 ? 1 : i11;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(i11 != 0 ? i11 : 1);
            String quantityString = resources.getQuantityString(i12, i13, objArr);
            C1120a.m6675d("ShareAlbumGuideDialog", "ageValue  " + quantityString);
            m14061w(string, quantityString);
            this.f10731k.put(quantityString, Long.valueOf(j10));
            return;
        }
        String quantityString2 = this.f10728h.getResources().getQuantityString(R$plurals.baby_album_title_year, i10, Integer.valueOf(i10));
        String string2 = z11 ? this.f10728h.getResources().getString(R$string.filter_age_adult) : "";
        C1120a.m6675d("ShareAlbumGuideDialog", "ageKey " + quantityString2 + " adultAgeKey" + string2);
        int i14 = (int) ((jAbs - (((long) i10) * 31536000000L)) / 2592000000L);
        Resources resources2 = this.f10728h.getResources();
        int i15 = R$plurals.baby_album_title_month;
        int i16 = i14 == 0 ? 1 : i14;
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(i14 != 0 ? i14 : 1);
        String quantityString3 = resources2.getQuantityString(i15, i16, objArr2);
        C1120a.m6675d("ShareAlbumGuideDialog", "monthStr " + quantityString3);
        String string3 = this.f10728h.getString(R$string.baby_album_title_partly_age, quantityString2, quantityString3);
        C1120a.m6675d("ShareAlbumGuideDialog", "ageValue " + string3);
        if (z11) {
            quantityString2 = string2;
        }
        m14061w(quantityString2, string3);
        this.f10731k.put(string3, Long.valueOf(j10));
    }

    /* renamed from: f0 */
    public final void m14060f0(long j10) {
        String str = new SimpleDateFormat(C11829c.m70590k0() ? "yyyy-MM月-dd日" : "yyyy-MM-dd").format(new Date(j10));
        String str2 = str.split("-")[0];
        String str3 = str.split("-")[1];
        String str4 = str.split("-")[2];
        String strM14063y = m14063y(str3);
        C1120a.m6675d("ShareAlbumGuideDialog", "monthStr " + strM14063y);
        Map<String, List<String>> map = this.f10734n.get(str2);
        if (map == null) {
            HashMap map2 = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str4);
            map2.put(strM14063y, arrayList);
            this.f10734n.put(str2, map2);
            return;
        }
        List<String> list = map.get(strM14063y);
        if (list == null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str4);
            map.put(strM14063y, arrayList2);
            this.f10734n.put(str2, map);
            return;
        }
        if (list.toString().contains(str4)) {
            return;
        }
        list.add(str4);
        map.put(strM14063y, list);
        this.f10734n.put(str2, map);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.llay_all) {
            m14049U();
            m14044P(true);
            m14039K();
            return;
        }
        if (id2 == R$id.llay_only_pic) {
            m14049U();
            m14048T(true);
            m14039K();
            return;
        }
        if (id2 == R$id.llay_only_video) {
            m14049U();
            m14050V(true);
            m14039K();
            return;
        }
        if (id2 == R$id.rlay_filter_by_date) {
            m14054Z();
            m14053Y(true);
            m14058d0();
            return;
        }
        if (id2 == R$id.rlay_filter_by_age) {
            m14054Z();
            m14052X(true);
            m14057c0();
            return;
        }
        if (id2 == R$id.filter_left_view) {
            m14064z();
            return;
        }
        if (id2 == R$id.llay_big) {
            m14040L("share_album_click_big_mode");
            m14041M(true);
            m14055a0(false);
            m14038J();
            return;
        }
        if (id2 == R$id.llay_small) {
            m14040L("share_album_click_small_mode");
            m14041M(false);
            m14055a0(true);
            m14038J();
        }
    }

    /* renamed from: w */
    public final void m14061w(String str, String str2) {
        List<String> list = this.f10730j.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            this.f10730j.put(str, arrayList);
        } else {
            if (list.toString().contains(str2)) {
                return;
            }
            list.add(str2);
            this.f10730j.put(str, list);
        }
    }

    /* renamed from: x */
    public final long m14062x() {
        Album album = this.f10715V;
        if (album == null) {
            C1120a.m6676e("ShareAlbumGuideDialog", "getBabyBirthdayMills mAlbum is null");
            return 0L;
        }
        BabyInfo babyInfo = album.getBabyInfo();
        if (babyInfo == null) {
            C1120a.m6676e("ShareAlbumGuideDialog", "getBabyBirthdayMills babyInfo is null");
            return 0L;
        }
        C4644l birthday = babyInfo.getBirthday();
        if (birthday != null) {
            return birthday.m28458c();
        }
        C1120a.m6676e("ShareAlbumGuideDialog", "getBabyBirthdayMills dateTime is null");
        return 0L;
    }

    /* renamed from: y */
    public final String m14063y(String str) {
        try {
            if (C11829c.m70590k0() || this.f10728h == null) {
                return str;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(2, Integer.parseInt(str) - 1);
            return String.valueOf(DateFormat.format(f10693b0, calendar));
        } catch (Exception e10) {
            C1120a.m6676e("ShareAlbumGuideDialog", "getNotChineseMonthStr e " + e10.getMessage());
            return str;
        }
    }

    /* renamed from: z */
    public void m14064z() {
        LinearLayout linearLayout = this.f10713T;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(this.f10728h.getColor(R$color.transparent));
            this.f10713T.setVisibility(8);
            Animation animationMakeOutAnimation = AnimationUtils.makeOutAnimation(this.f10728h, true);
            animationMakeOutAnimation.setDuration(200L);
            this.f10713T.setAnimation(animationMakeOutAnimation);
        }
    }
}
