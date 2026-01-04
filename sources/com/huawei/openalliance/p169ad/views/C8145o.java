package com.huawei.openalliance.p169ad.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7512ng;
import com.huawei.openalliance.p169ad.C7650rz;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7654sc;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7818dk;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8132y;

/* renamed from: com.huawei.openalliance.ad.views.o */
/* loaded from: classes2.dex */
public class C8145o extends RelativeLayout {

    /* renamed from: a */
    protected Context f38040a;

    /* renamed from: b */
    private AppInfo f38041b;

    /* renamed from: c */
    private View f38042c;

    /* renamed from: d */
    private View f38043d;

    /* renamed from: e */
    private View f38044e;

    /* renamed from: f */
    private TextView f38045f;

    /* renamed from: g */
    private TextView f38046g;

    /* renamed from: h */
    private ImageView f38047h;

    /* renamed from: i */
    private ImageView f38048i;

    /* renamed from: j */
    private int f38049j;

    /* renamed from: k */
    private int f38050k;

    /* renamed from: l */
    private int f38051l;

    /* renamed from: m */
    private C7022dk f38052m;

    /* renamed from: n */
    private InterfaceC8132y f38053n;

    /* renamed from: o */
    private Handler f38054o;

    /* renamed from: p */
    private Animator f38055p;

    /* renamed from: q */
    private ContentRecord f38056q;

    /* renamed from: r */
    private C7512ng f38057r;

    /* renamed from: s */
    private View.OnTouchListener f38058s;

    /* renamed from: com.huawei.openalliance.ad.views.o$6, reason: invalid class name */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f38064a;

        /* renamed from: b */
        final /* synthetic */ ImageView f38065b;

        public AnonymousClass6(String str, ImageView imageView) {
            this.f38064a = str;
            this.f38065b = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7653sb c7653sb = new C7653sb();
            c7653sb.m47181b(false);
            c7653sb.m47185c(true);
            c7653sb.m47180b("icon");
            c7653sb.m47187d(this.f38064a);
            C7654sc c7654scM47158a = new C7650rz(C8145o.this.f38040a, c7653sb).m47158a();
            if (c7654scM47158a != null) {
                String strM47207a = c7654scM47158a.m47207a();
                if (TextUtils.isEmpty(strM47207a)) {
                    return;
                }
                String strM41968c = C8145o.this.f38052m.m41968c(strM47207a);
                if (TextUtils.isEmpty(strM41968c)) {
                    return;
                }
                C7752az.m47690a(C8145o.this.f38040a, strM41968c, new C7752az.a() { // from class: com.huawei.openalliance.ad.views.o.6.1
                    @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                    /* renamed from: a */
                    public void mo30231a() {
                    }

                    @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                    /* renamed from: a */
                    public void mo30232a(final Drawable drawable) {
                        if (drawable != null) {
                            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.o.6.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass6.this.f38065b.setBackground(null);
                                    AnonymousClass6.this.f38065b.setImageDrawable(drawable);
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public C8145o(Context context) {
        super(context);
        this.f38054o = new Handler();
        this.f38058s = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.o.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return C8145o.this.m50444a(view, motionEvent);
            }
        };
        m50442a(context, (AttributeSet) null);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f38051l = this.f38042c.getMeasuredWidth();
        m50449c();
    }

    public void setDownloadSource(int i10) {
        this.f38057r.m46104a(i10);
    }

    public void setOnCloseListener(InterfaceC8132y interfaceC8132y) {
        this.f38053n = interfaceC8132y;
    }

    /* renamed from: b */
    private void m50447b() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat(TopAnimatorConfig.AnimatorType.SCALE_X, 0.8f, 1.05f, 1.0f), PropertyValuesHolder.ofFloat(TopAnimatorConfig.AnimatorType.SCALE_Y, 0.8f, 1.05f, 1.0f), PropertyValuesHolder.ofFloat(TopAnimatorConfig.AnimatorType.ALPHA, 0.0f, 1.0f, 1.0f));
        this.f38055p = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(200L);
        this.f38055p.setInterpolator(new LinearInterpolator());
    }

    /* renamed from: c */
    private void m50449c() {
        if (this.f38049j != this.f38050k) {
            View viewFindViewById = findViewById(C6849R.id.app_view);
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.width = (int) (this.f38049j - C7818dk.m48367a(this.f38040a, 24));
            viewFindViewById.setLayoutParams(layoutParams);
            int i10 = (this.f38051l - this.f38049j) / 2;
            View viewFindViewById2 = findViewById(C6849R.id.layout_start);
            ViewGroup.LayoutParams layoutParams2 = viewFindViewById2.getLayoutParams();
            layoutParams2.width = i10;
            viewFindViewById2.setLayoutParams(layoutParams2);
            View viewFindViewById3 = findViewById(C6849R.id.layout_end);
            ViewGroup.LayoutParams layoutParams3 = viewFindViewById3.getLayoutParams();
            layoutParams3.width = i10;
            viewFindViewById3.setLayoutParams(layoutParams3);
        }
    }

    /* renamed from: a */
    public void m50451a() {
        this.f38054o.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.o.5
            @Override // java.lang.Runnable
            public void run() {
                if (C8145o.this.f38055p != null) {
                    C8145o.this.f38055p.start();
                    C8145o.this.setVisibility(0);
                }
            }
        });
    }

    /* renamed from: a */
    public void m50452a(int i10, int i11) {
        this.f38049j = i10;
        this.f38050k = i11;
    }

    /* renamed from: a */
    private void m50442a(Context context, AttributeSet attributeSet) {
        View.inflate(context, C6849R.layout.hiad_full_screen_notity_layout, this);
        setVisibility(4);
        this.f38040a = context;
        this.f38052m = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
        this.f38042c = findViewById(C6849R.id.app_layout);
        this.f38043d = findViewById(C6849R.id.layout_start);
        this.f38044e = findViewById(C6849R.id.layout_end);
        this.f38047h = (ImageView) findViewById(C6849R.id.app_icon);
        this.f38045f = (TextView) findViewById(C6849R.id.app_name_tv);
        this.f38046g = (TextView) findViewById(C6849R.id.notify_tv);
        ImageView imageView = (ImageView) findViewById(C6849R.id.app_close);
        this.f38048i = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.o.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C8145o.this.f38057r.m46105a("0");
                C8145o.this.f38053n.mo38720c();
            }
        });
        this.f38043d.setOnTouchListener(new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.o.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                C8145o.this.f38057r.m46105a("2");
                C8145o.this.f38053n.mo38720c();
                return true;
            }
        });
        this.f38044e.setOnTouchListener(new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.o.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                C8145o.this.f38057r.m46105a("2");
                C8145o.this.f38053n.mo38720c();
                return true;
            }
        });
        setOnTouchListener(this.f38058s);
        m50447b();
        if (AbstractC7741ao.m47592n(context)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f38047h.getLayoutParams();
            layoutParams.removeRule(15);
            this.f38047h.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f38048i.getLayoutParams();
            layoutParams2.removeRule(15);
            this.f38048i.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a */
    private void m50443a(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        AbstractC7185ho.m43820b("PPSFullScreenNotifyView", "load app icon:" + AbstractC7806cz.m48174f(str));
        AbstractC7834m.m48484d(new AnonymousClass6(str, imageView));
    }

    /* renamed from: a */
    public void m50453a(ContentRecord contentRecord, String str) {
        this.f38056q = contentRecord;
        this.f38057r = new C7512ng(this.f38040a, contentRecord, 1);
        ContentRecord contentRecord2 = this.f38056q;
        if (contentRecord2 == null || contentRecord2.m41484af() == null) {
            AbstractC7185ho.m43820b("PPSFullScreenNotifyView", "contentRecord or appInfo is null");
            return;
        }
        this.f38041b = this.f38056q.m41484af();
        if (!TextUtils.isEmpty(str)) {
            this.f38041b.m44433v(str);
        }
        MetaData metaDataM41568i = this.f38056q.m41568i();
        if (metaDataM41568i != null) {
            this.f38041b.m44415m(metaDataM41568i.m40332o());
        }
        String appName = this.f38041b.getAppName();
        if (!TextUtils.isEmpty(appName)) {
            this.f38045f.setText(appName);
        }
        String strM44422q = this.f38041b.m44422q();
        if (!TextUtils.isEmpty(strM44422q)) {
            this.f38046g.setText(strM44422q);
        }
        m50443a(this.f38047h, this.f38041b.getIconUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m50444a(View view, MotionEvent motionEvent) {
        String str;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                str = action == 3 ? "ACTION_CANCEL" : "ACTION_DOWN";
            } else {
                AbstractC7185ho.m43820b("PPSFullScreenNotifyView", "ACTION_UP");
                this.f38057r.m46106b(-1);
                this.f38053n.mo38720c();
            }
            return true;
        }
        AbstractC7185ho.m43820b("PPSFullScreenNotifyView", str);
        return true;
    }
}
