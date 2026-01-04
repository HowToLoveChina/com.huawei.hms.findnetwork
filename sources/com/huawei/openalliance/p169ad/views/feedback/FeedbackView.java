package com.huawei.openalliance.p169ad.views.feedback;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7730ad;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7822do;
import com.huawei.openalliance.p169ad.views.AbstractC8104h;
import java.util.List;

/* loaded from: classes2.dex */
public class FeedbackView extends AbstractC8104h implements InterfaceC8097g, InterfaceC8098h {

    /* renamed from: k */
    private LinearLayout f37623k;

    /* renamed from: l */
    private LinearLayout f37624l;

    /* renamed from: m */
    private FlowLayoutView f37625m;

    /* renamed from: n */
    private FlowLayoutView f37626n;

    /* renamed from: o */
    private ViewStub f37627o;

    /* renamed from: p */
    private InterfaceC8092b f37628p;

    /* renamed from: q */
    private boolean f37629q;

    /* renamed from: r */
    private boolean f37630r;

    /* renamed from: s */
    private C8094d f37631s;

    /* renamed from: t */
    private C8088a f37632t;

    /* renamed from: u */
    private C8090c f37633u;

    /* renamed from: com.huawei.openalliance.ad.views.feedback.FeedbackView$a */
    public static class C8088a extends AbstractViewOnClickListenerC8089b {

        /* renamed from: c */
        private AbstractC8104h.a f37639c;

        public C8088a(Context context) {
            super(context);
        }

        /* renamed from: a */
        public void m50133a(AbstractC8104h.a aVar) {
            this.f37639c = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f37640a == null) {
                AbstractC7185ho.m43820b("FeedbackView", "feedback presenter is null.");
                return;
            }
            if (AbstractC7811dd.m48310b(this.f37641b)) {
                this.f37639c.mo38623l();
                return;
            }
            boolean zM50159f = this.f37640a.m50159f();
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("FeedbackView", "click to complain: %s", Boolean.valueOf(zM50159f));
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.feedback.FeedbackView$b */
    public static abstract class AbstractViewOnClickListenerC8089b implements View.OnClickListener {

        /* renamed from: a */
        protected C8094d f37640a;

        /* renamed from: b */
        protected final Context f37641b;

        public AbstractViewOnClickListenerC8089b(Context context) {
            this.f37641b = context;
        }

        /* renamed from: a */
        public void m50134a(C8094d c8094d) {
            this.f37640a = c8094d;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.feedback.FeedbackView$c */
    public static class C8090c extends AbstractViewOnClickListenerC8089b {
        public C8090c(Context context) {
            super(context);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C8094d c8094d = this.f37640a;
            if (c8094d == null) {
                return;
            }
            boolean zM50154a = c8094d.m50154a(this.f37641b);
            AbstractC7185ho.m43818a("FeedbackView", "click to why this ad:%s", Boolean.valueOf(zM50154a));
            if (zM50154a) {
                Context context = this.f37641b;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
        }
    }

    public FeedbackView(Context context) {
        super(context);
        this.f37629q = true;
        this.f37630r = true;
    }

    /* renamed from: f */
    private boolean m50131f() {
        C8094d c8094d = this.f37631s;
        return (c8094d == null || !c8094d.m50157d() || AbstractC7806cz.m48165b(this.f37631s.m50158e())) ? false : true;
    }

    private void setArrowBitMap(ImageView imageView) throws Resources.NotFoundException {
        if (imageView != null) {
            Drawable drawable = getResources().getDrawable(C6849R.drawable.hiad_feedback_right_arrow);
            if (AbstractC7811dd.m48315c()) {
                imageView.setImageBitmap(C7752az.m47693b(drawable));
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.feedback.InterfaceC8098h
    /* renamed from: a */
    public void mo46265a() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.feedback.FeedbackView.2
            @Override // java.lang.Runnable
            public void run() {
                if (FeedbackView.this.f37628p != null) {
                    FeedbackView.this.f37628p.mo38621a(3, FeedbackView.this.f37631s.m50156c());
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: e */
    public void mo50132e() {
        C8094d c8094d = this.f37631s;
        if (c8094d == null) {
            AbstractC7185ho.m43820b("FeedbackView", "feedback presenter is null");
            return;
        }
        boolean zM50159f = c8094d.m50159f();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("FeedbackView", "click to complain: %s", Boolean.valueOf(zM50159f));
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    public void setAdContent(ContentRecord contentRecord) {
        C8094d c8094d = this.f37631s;
        if (c8094d != null) {
            c8094d.m50153a(getContext().getApplicationContext(), contentRecord, this);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    public void setFeedbackListener(InterfaceC8092b interfaceC8092b) {
        this.f37628p = interfaceC8092b;
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    public void setScreenLockCallBack(AbstractC8104h.a aVar) {
        this.f37632t.m50133a(aVar);
    }

    public FeedbackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37629q = true;
        this.f37630r = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50123a(int i10, FeedbackInfo feedbackInfo) {
        InterfaceC8092b interfaceC8092b = this.f37628p;
        if (interfaceC8092b != null) {
            interfaceC8092b.mo38621a(i10, feedbackInfo);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.feedback.InterfaceC8098h
    /* renamed from: b */
    public void mo46266b() {
        Context context = getContext();
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: c */
    public void mo50094c() {
        try {
            this.f37630r = C6982bz.m41148a(getContext()).mo41175d();
            AbstractC7185ho.m43821b("FeedbackView", "adapterView mFeedbackViewPaddingLeft = %s, mFeedbackViewPaddingRight= %s", Integer.valueOf(this.f37760g), Integer.valueOf(this.f37761h));
            if (m50257d()) {
                this.f37755b.setPadding(this.f37760g, 0, this.f37761h, 0);
                C8094d c8094d = this.f37631s;
                if (c8094d != null) {
                    List<FeedbackInfo> listM50152a = c8094d.m50152a();
                    List<FeedbackInfo> listM50155b = this.f37631s.m50155b();
                    FeedbackInfo feedbackInfoM50156c = this.f37631s.m50156c();
                    if (C7730ad.m47435a(listM50152a)) {
                        C7822do.m48384a((View) this.f37623k, true);
                        m50126a(this.f37625m, listM50152a, 2);
                    } else {
                        C7822do.m48384a((View) this.f37623k, false);
                    }
                    if (C7730ad.m47435a(listM50155b)) {
                        C7822do.m48384a((View) this.f37624l, true);
                        m50126a(this.f37626n, listM50155b, 1);
                    } else {
                        C7822do.m48384a((View) this.f37624l, false);
                    }
                    m50124a(feedbackInfoM50156c);
                }
                this.f37755b.requestLayout();
                this.f37755b.getViewTreeObserver().addOnGlobalLayoutListener(this.f37763j);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("FeedbackView", "adapterView error, %s", th2.getClass().getSimpleName());
        }
    }

    public FeedbackView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37629q = true;
        this.f37630r = true;
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: a */
    public void mo50092a(Context context) {
        try {
            View viewInflate = LayoutInflater.from(context).inflate(C6849R.layout.hiad_feedback_view, this);
            this.f37754a = viewInflate;
            this.f37623k = (LinearLayout) viewInflate.findViewById(C6849R.id.feedback_positive_ll);
            this.f37624l = (LinearLayout) this.f37754a.findViewById(C6849R.id.feedback_negative_ll);
            this.f37755b = this.f37754a.findViewById(C6849R.id.feedback_view_root);
            this.f37756c = this.f37754a.findViewById(C6849R.id.feedback_scrollview);
            this.f37625m = (FlowLayoutView) this.f37754a.findViewById(C6849R.id.feedback_positive_flv);
            this.f37626n = (FlowLayoutView) this.f37754a.findViewById(C6849R.id.feedback_negative_flv);
            this.f37627o = (ViewStub) this.f37754a.findViewById(C6849R.id.feedback_viewstub);
            this.f37631s = new C8094d(this);
            this.f37632t = new C8088a(getContext());
            this.f37633u = new C8090c(getContext());
            this.f37632t.m50134a(this.f37631s);
            this.f37633u.m50134a(this.f37631s);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("FeedbackView", "initView error, %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: b */
    public void mo50093b(Context context) throws Resources.NotFoundException {
        boolean zMo41175d = C6982bz.m41148a(context).mo41175d();
        this.f37630r = zMo41175d;
        AbstractC7185ho.m43818a("FeedbackView", "isChinaRom = %s", Boolean.valueOf(zMo41175d));
        ViewStub viewStub = this.f37627o;
        if (viewStub == null) {
            return;
        }
        viewStub.setLayoutResource(C6849R.layout.hiad_feedback_viewstub);
        this.f37627o.inflate();
        ImageView imageView = (ImageView) this.f37754a.findViewById(C6849R.id.right_arrow);
        ImageView imageView2 = (ImageView) this.f37754a.findViewById(C6849R.id.dsa_right_arrow);
        setArrowBitMap(imageView);
        setArrowBitMap(imageView2);
    }

    @SuppressLint({"NewApi"})
    public FeedbackView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f37629q = true;
        this.f37630r = true;
    }

    /* renamed from: a */
    private void m50124a(FeedbackInfo feedbackInfo) {
        View viewFindViewById = this.f37754a.findViewById(C6849R.id.complain_extra_area);
        View viewFindViewById2 = this.f37754a.findViewById(C6849R.id.dsa_extra_area);
        if (this.f37630r) {
            if (viewFindViewById != null) {
                if (feedbackInfo == null || !feedbackInfo.m44468b()) {
                    viewFindViewById.setVisibility(8);
                } else {
                    viewFindViewById.setVisibility(0);
                    ((TextView) this.f37754a.findViewById(C6849R.id.complain_tv)).setText(feedbackInfo.getLabel());
                    viewFindViewById.setOnClickListener(this.f37632t);
                }
            }
            if (viewFindViewById2 == null) {
                return;
            }
            if (!m50131f()) {
                viewFindViewById2.setVisibility(8);
                return;
            }
        } else {
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            if (viewFindViewById2 == null) {
                return;
            }
        }
        viewFindViewById2.setVisibility(0);
        viewFindViewById2.setOnClickListener(this.f37633u);
    }

    /* renamed from: a */
    private void m50126a(FlowLayoutView flowLayoutView, List<FeedbackInfo> list, final int i10) {
        flowLayoutView.removeAllViews();
        if (AbstractC7760bg.m47767a(list)) {
            AbstractC7185ho.m43820b("FeedbackView", "feedbackInfoList is null");
            return;
        }
        AbstractC7185ho.m43821b("FeedbackView", "initFlowLayout, feedType: %s, feedbackList.size: %s", Integer.valueOf(i10), Integer.valueOf(list.size()));
        for (final FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null && !TextUtils.isEmpty(feedbackInfo.getLabel())) {
                String label = feedbackInfo.getLabel();
                View viewInflate = LayoutInflater.from(getContext()).inflate(C6849R.layout.hiad_unlike_label_item, (ViewGroup) flowLayoutView, false);
                if (viewInflate instanceof TextView) {
                    TextView textView = (TextView) viewInflate;
                    textView.setText(label);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.feedback.FeedbackView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                if (FeedbackView.this.f37629q) {
                                    FeedbackView.this.f37629q = false;
                                    view.setSelected(!view.isSelected());
                                    view.postDelayed(new Runnable() { // from class: com.huawei.openalliance.ad.views.feedback.FeedbackView.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            FeedbackView.this.f37629q = true;
                                            ViewOnClickListenerC80861 viewOnClickListenerC80861 = ViewOnClickListenerC80861.this;
                                            FeedbackView.this.m50123a(i10, feedbackInfo);
                                        }
                                    }, 200L);
                                }
                            } catch (Throwable th2) {
                                AbstractC7185ho.m43824c("FeedbackView", "onClick error, %s", th2.getClass().getSimpleName());
                            }
                        }
                    });
                    flowLayoutView.addView(textView);
                }
            }
        }
        flowLayoutView.setDefaultDisplayMode(AbstractC7811dd.m48315c() ? -1 : 1);
    }
}
