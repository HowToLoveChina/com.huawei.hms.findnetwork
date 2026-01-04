package com.huawei.openalliance.p169ad.views.dsa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.InterfaceC7179hi;
import com.huawei.openalliance.p169ad.InterfaceC7328jb;
import com.huawei.openalliance.p169ad.activity.SplashFeedbackActivity;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.AbstractC8104h;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* loaded from: classes2.dex */
public class DomesticDsaView extends AbstractC8104h {

    /* renamed from: k */
    protected Boolean f37595k;

    /* renamed from: l */
    private RelativeLayout f37596l;

    /* renamed from: m */
    private TextView f37597m;

    /* renamed from: n */
    private View f37598n;

    /* renamed from: o */
    private RelativeLayout f37599o;

    /* renamed from: p */
    private TextView f37600p;

    /* renamed from: q */
    private ContentRecord f37601q;

    /* renamed from: r */
    private Integer f37602r;

    /* renamed from: s */
    private InterfaceC7328jb f37603s;

    /* renamed from: t */
    private InterfaceC7179hi f37604t;

    public DomesticDsaView(Context context) {
        super(context);
    }

    /* renamed from: f */
    private void m50102f() {
        String str;
        if (this.f37598n == null || this.f37596l == null) {
            str = "partingLine or splashFeedbackClick view not init";
        } else {
            Boolean bool = this.f37595k;
            if (bool != null && bool.booleanValue()) {
                this.f37598n.setVisibility(0);
                this.f37596l.setVisibility(0);
                this.f37596l.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.dsa.DomesticDsaView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new C6928i(DomesticDsaView.this.getContext().getApplicationContext()).m39208a("145", "", "", "");
                        Intent intent = new Intent(DomesticDsaView.this.getContext(), (Class<?>) SplashFeedbackActivity.class);
                        intent.setPackage(DomesticDsaView.this.getContext().getPackageName());
                        intent.putExtra(MapKeyNames.SPLASH_CLICKABLE_TYPE, DomesticDsaView.this.f37602r);
                        if (!(DomesticDsaView.this.getContext() instanceof Activity)) {
                            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                        }
                        AbstractC7811dd.m48294a(DomesticDsaView.this.getContext(), intent);
                        if (DomesticDsaView.this.f37603s != null) {
                            DomesticDsaView.this.f37603s.mo45176f();
                        }
                    }
                });
                if (AbstractC7741ao.m47554a(this.f37601q.m41517bd(), this.f37601q.m41516bc())) {
                    return;
                }
                this.f37599o.setVisibility(8);
                this.f37598n.setVisibility(8);
                return;
            }
            str = "not need show splash feedback";
        }
        AbstractC7185ho.m43820b("DomesticDsaView", str);
    }

    /* renamed from: g */
    private void m50103g() {
        if (AbstractC7741ao.m47592n(getContext())) {
            TextView textView = this.f37597m;
            if (textView != null) {
                textView.setTextSize(1, 28.0f);
            }
            TextView textView2 = this.f37600p;
            if (textView2 != null) {
                textView2.setTextSize(1, 28.0f);
            }
        }
    }

    /* renamed from: h */
    private void m50104h() {
        if (this.f37756c != null) {
            this.f37756c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            float measuredWidth = this.f37756c.getMeasuredWidth();
            float fM48215b = measuredWidth / AbstractC7807d.m48215b(getContext());
            this.f37757d = fM48215b;
            this.f37759f = (int) measuredWidth;
            AbstractC7185ho.m43818a("DomesticDsaView", "fitTvViewWidth: viewWidthPercent: %s, mViewWidth: %s", Float.valueOf(fM48215b), Integer.valueOf(this.f37759f));
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: d */
    public void mo50109d(Context context) {
        if (C7845x.m48605t(getContext())) {
            m50104h();
        } else {
            super.mo50109d(context);
        }
    }

    public int getLayoutId() {
        return C7845x.m48605t(getContext()) ? C6849R.layout.hiad_domestic_dsa_view_tv : C6849R.layout.hiad_domestic_dsa_view;
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    public void setAdContent(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        this.f37601q = contentRecord;
        m50099a(this.f37604t);
        m50102f();
        mo50094c();
        m50103g();
    }

    public void setDsaJumpListener(InterfaceC7179hi interfaceC7179hi) {
        this.f37604t = interfaceC7179hi;
    }

    public DomesticDsaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public void m50105a() {
        RelativeLayout relativeLayout = this.f37599o;
        if (relativeLayout == null || !relativeLayout.getGlobalVisibleRect(new Rect())) {
            return;
        }
        this.f37599o.setPressed(true);
    }

    /* renamed from: b */
    public void m50107b() {
        RelativeLayout relativeLayout = this.f37599o;
        if (relativeLayout == null || !relativeLayout.getGlobalVisibleRect(new Rect())) {
            return;
        }
        this.f37599o.setPressed(false);
        this.f37599o.performClick();
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: c */
    public void mo50094c() {
        try {
            AbstractC7185ho.m43821b("DomesticDsaView", "adapterView mFeedbackViewPaddingLeft = %s, mFeedbackViewPaddingRight= %s", Integer.valueOf(this.f37760g), Integer.valueOf(this.f37761h));
            if (m50257d()) {
                this.f37755b.setPadding(this.f37760g, 0, this.f37761h, 0);
                this.f37755b.requestLayout();
                this.f37755b.getViewTreeObserver().addOnGlobalLayoutListener(this.f37763j);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DomesticDsaView", "adapterView error, %s", th2.getClass().getSimpleName());
        }
    }

    public DomesticDsaView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: a */
    public void mo50092a(Context context) {
        try {
            View viewInflate = LayoutInflater.from(context).inflate(getLayoutId(), this);
            if (viewInflate == null) {
                return;
            }
            this.f37755b = viewInflate.findViewById(C6849R.id.dom_dsa_view_root);
            this.f37756c = viewInflate.findViewById(C6849R.id.dsa_scrollview);
            this.f37598n = viewInflate.findViewById(C6849R.id.splash_feedback_line);
            this.f37596l = (RelativeLayout) viewInflate.findViewById(C6849R.id.splash_feedback_btn);
            this.f37597m = (TextView) viewInflate.findViewById(C6849R.id.splash_feedback_tv);
            this.f37599o = (RelativeLayout) viewInflate.findViewById(C6849R.id.why_this_ad_btn);
            this.f37600p = (TextView) viewInflate.findViewById(C6849R.id.why_this_ad_tv);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DomesticDsaView", "initView error, %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: b */
    public void mo50093b(Context context) {
        if (AbstractC7811dd.m48315c()) {
            Bitmap bitmapM47693b = C7752az.m47693b(getResources().getDrawable(C6849R.drawable.hiad_feedback_right_arrow));
            ImageView imageView = (ImageView) findViewById(C6849R.id.why_this_ad_right_arrow);
            if (imageView != null) {
                imageView.setImageBitmap(bitmapM47693b);
            }
            ImageView imageView2 = (ImageView) findViewById(C6849R.id.splash_feedback_right_arrow);
            if (imageView2 != null) {
                imageView2.setImageBitmap(bitmapM47693b);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: c */
    public void mo50108c(Context context) {
        if (C7845x.m48587n(context) || (C7845x.m48595q(context) && C7845x.m48599r(context))) {
            this.f37757d = 0.4f;
        } else {
            this.f37757d = C7845x.m48605t(context) ? 0.18f : 0.56f;
        }
    }

    public DomesticDsaView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    /* renamed from: a */
    private void m50099a(final InterfaceC7179hi interfaceC7179hi) {
        this.f37599o.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.dsa.DomesticDsaView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean zM47548a = AbstractC7741ao.m47548a(DomesticDsaView.this.getContext(), DomesticDsaView.this.f37601q);
                AbstractC7185ho.m43818a("DomesticDsaView", "jump to dsa page: %s", Boolean.valueOf(zM47548a));
                if (zM47548a) {
                    InterfaceC7179hi interfaceC7179hi2 = interfaceC7179hi;
                    if (interfaceC7179hi2 != null) {
                        interfaceC7179hi2.mo38609a();
                    }
                    if (DomesticDsaView.this.f37603s != null) {
                        DomesticDsaView.this.f37603s.mo45173e();
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void m50106a(boolean z10, Integer num, InterfaceC7328jb interfaceC7328jb) {
        this.f37595k = Boolean.valueOf(z10);
        this.f37602r = num;
        this.f37603s = interfaceC7328jb;
    }
}
