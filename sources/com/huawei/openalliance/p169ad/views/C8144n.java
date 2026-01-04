package com.huawei.openalliance.p169ad.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
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
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8132y;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.views.n */
/* loaded from: classes2.dex */
public class C8144n extends RelativeLayout {

    /* renamed from: a */
    protected Context f38015a;

    /* renamed from: b */
    int f38016b;

    /* renamed from: c */
    private AppInfo f38017c;

    /* renamed from: d */
    private TextView f38018d;

    /* renamed from: e */
    private TextView f38019e;

    /* renamed from: f */
    private ImageView f38020f;

    /* renamed from: g */
    private ImageView f38021g;

    /* renamed from: h */
    private Button f38022h;

    /* renamed from: i */
    private RelativeLayout f38023i;

    /* renamed from: j */
    private RelativeLayout f38024j;

    /* renamed from: k */
    private InterfaceC8132y f38025k;

    /* renamed from: l */
    private Handler f38026l;

    /* renamed from: m */
    private Animator f38027m;

    /* renamed from: n */
    private ContentRecord f38028n;

    /* renamed from: o */
    private C7512ng f38029o;

    /* renamed from: p */
    private View.OnClickListener f38030p;

    /* renamed from: com.huawei.openalliance.ad.views.n$a */
    public static class a implements Runnable {

        /* renamed from: a */
        private String f38033a;

        /* renamed from: b */
        private WeakReference<ImageView> f38034b;

        /* renamed from: c */
        private C7022dk f38035c;

        /* renamed from: d */
        private Context f38036d;

        public a(String str, ImageView imageView, Context context) {
            this.f38033a = str;
            this.f38034b = new WeakReference<>(imageView);
            context = context != null ? context.getApplicationContext() : context;
            this.f38036d = context;
            this.f38035c = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f38036d == null) {
                return;
            }
            C7653sb c7653sb = new C7653sb();
            c7653sb.m47181b(false);
            c7653sb.m47185c(true);
            c7653sb.m47180b("icon");
            c7653sb.m47187d(this.f38033a);
            C7654sc c7654scM47158a = new C7650rz(this.f38036d, c7653sb).m47158a();
            if (c7654scM47158a == null) {
                return;
            }
            String strM47207a = c7654scM47158a.m47207a();
            if (TextUtils.isEmpty(strM47207a)) {
                return;
            }
            String strM41968c = this.f38035c.m41968c(strM47207a);
            if (TextUtils.isEmpty(strM41968c)) {
                return;
            }
            C7752az.m47690a(this.f38036d, strM41968c, new C7752az.a() { // from class: com.huawei.openalliance.ad.views.n.a.1
                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30231a() {
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30232a(final Drawable drawable) {
                    if (drawable == null) {
                        return;
                    }
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.n.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageView imageView = (ImageView) a.this.f38034b.get();
                            if (imageView == null) {
                                return;
                            }
                            imageView.setBackground(null);
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    public C8144n(Context context) {
        super(context);
        this.f38026l = new Handler();
        this.f38030p = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C8144n c8144n;
                AbstractC7185ho.m43821b("PPSFullScreenNotifyOptimizeView", "onClick, insActvNotifyCfg: %s", Integer.valueOf(C8144n.this.f38016b));
                if (view.getId() == C6849R.id.app_close_optimize) {
                    C8144n.this.f38029o.m46105a("0");
                } else {
                    if (view.getId() == C6849R.id.app_valid_click_optimize || view.getId() == C6849R.id.app_open_btn_optimize) {
                        c8144n = C8144n.this;
                    } else {
                        if (view.getId() != C6849R.id.app_view_optimize) {
                            return;
                        }
                        c8144n = C8144n.this;
                        if (c8144n.f38016b != 2) {
                            return;
                        }
                    }
                    c8144n.f38029o.m46106b(C8144n.this.f38016b);
                }
                C8144n.this.f38025k.mo38720c();
            }
        };
        m50433a(context, (AttributeSet) null);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public void setDownloadSource(int i10) {
        this.f38029o.m46104a(i10);
    }

    public void setOnCloseListener(InterfaceC8132y interfaceC8132y) {
        this.f38025k = interfaceC8132y;
    }

    /* renamed from: b */
    private void m50436b() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat(TopAnimatorConfig.AnimatorType.SCALE_X, 0.8f, 1.05f, 1.0f), PropertyValuesHolder.ofFloat(TopAnimatorConfig.AnimatorType.SCALE_Y, 0.8f, 1.05f, 1.0f), PropertyValuesHolder.ofFloat(TopAnimatorConfig.AnimatorType.ALPHA, 0.0f, 1.0f, 1.0f));
        this.f38027m = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(200L);
        this.f38027m.setInterpolator(new LinearInterpolator());
    }

    /* renamed from: a */
    public void m50438a() {
        this.f38026l.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (C8144n.this.f38027m != null) {
                    C8144n.this.f38027m.start();
                    C8144n.this.setVisibility(0);
                }
            }
        });
    }

    /* renamed from: a */
    private void m50433a(Context context, AttributeSet attributeSet) {
        View.inflate(context, C6849R.layout.hiad_full_screen_notity_optimize_layout, this);
        setVisibility(4);
        this.f38015a = context;
        this.f38020f = (ImageView) findViewById(C6849R.id.app_icon_optimize);
        this.f38018d = (TextView) findViewById(C6849R.id.app_name_tv_optimize);
        this.f38019e = (TextView) findViewById(C6849R.id.notify_tv_optimize);
        this.f38021g = (ImageView) findViewById(C6849R.id.app_close_optimize);
        this.f38023i = (RelativeLayout) findViewById(C6849R.id.app_view_optimize);
        this.f38024j = (RelativeLayout) findViewById(C6849R.id.app_valid_click_optimize);
        this.f38022h = (Button) findViewById(C6849R.id.app_open_btn_optimize);
        this.f38023i.setOnClickListener(this.f38030p);
        this.f38024j.setOnClickListener(this.f38030p);
        this.f38022h.setOnClickListener(this.f38030p);
        this.f38021g.setOnClickListener(this.f38030p);
        m50436b();
        if (AbstractC7741ao.m47592n(context)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f38020f.getLayoutParams();
            layoutParams.removeRule(15);
            this.f38020f.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f38021g.getLayoutParams();
            layoutParams2.removeRule(15);
            this.f38021g.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a */
    private void m50434a(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str) || imageView == null || this.f38015a == null) {
            return;
        }
        AbstractC7185ho.m43820b("PPSFullScreenNotifyOptimizeView", "load app icon:" + AbstractC7806cz.m48174f(str));
        AbstractC7834m.m48484d(new a(str, imageView, this.f38015a));
    }

    /* renamed from: a */
    public void m50439a(ContentRecord contentRecord, String str) {
        this.f38028n = contentRecord;
        this.f38029o = new C7512ng(this.f38015a, contentRecord, 2);
        ContentRecord contentRecord2 = this.f38028n;
        if (contentRecord2 == null || contentRecord2.m41484af() == null) {
            AbstractC7185ho.m43820b("PPSFullScreenNotifyOptimizeView", "contentRecord or appInfo is null");
            return;
        }
        this.f38017c = this.f38028n.m41484af();
        if (!TextUtils.isEmpty(str)) {
            this.f38017c.m44433v(str);
        }
        MetaData metaDataM41568i = this.f38028n.m41568i();
        if (metaDataM41568i != null) {
            this.f38017c.m44415m(metaDataM41568i.m40332o());
        }
        String appName = this.f38017c.getAppName();
        if (TextUtils.isEmpty(appName)) {
            this.f38018d.setVisibility(8);
        } else {
            this.f38018d.setText(appName);
        }
        String strM44422q = this.f38017c.m44422q();
        if (!TextUtils.isEmpty(strM44422q)) {
            this.f38019e.setText(strM44422q);
        }
        String strM44424r = this.f38017c.m44424r();
        if (!TextUtils.isEmpty(strM44424r)) {
            this.f38022h.setText(strM44424r);
        }
        this.f38016b = this.f38017c.m44426s();
        m50434a(this.f38020f, this.f38017c.getIconUrl());
    }
}
