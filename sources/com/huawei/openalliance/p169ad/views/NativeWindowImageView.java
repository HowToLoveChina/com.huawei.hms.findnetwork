package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.views.gif.C8101b;
import com.huawei.openalliance.p169ad.views.gif.GifPlayView;
import com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d;
import com.huawei.openalliance.p169ad.views.interfaces.INativeWindowImageView;
import java.util.Iterator;

@OuterVisible
/* loaded from: classes2.dex */
public class NativeWindowImageView extends AutoScaleSizeRelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, C7752az.a, INativeWindowImageView {

    /* renamed from: a */
    private View f36482a;

    /* renamed from: b */
    private GifPlayView f36483b;

    /* renamed from: c */
    private ProgressBar f36484c;

    /* renamed from: d */
    private INativeAd f36485d;

    /* renamed from: e */
    private Drawable f36486e;

    /* renamed from: f */
    private Rect f36487f;

    /* renamed from: g */
    private Rect f36488g;

    /* renamed from: h */
    private float f36489h;

    /* renamed from: i */
    private int f36490i;

    /* renamed from: j */
    private boolean f36491j;

    /* renamed from: com.huawei.openalliance.ad.views.NativeWindowImageView$1 */
    public class C79131 implements InterfaceC8103d {
        public C79131() {
        }

        @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
        /* renamed from: a */
        public void mo48916a() {
            NativeWindowImageView.this.m48915k();
        }

        @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
        /* renamed from: b */
        public void mo48917b() {
        }

        @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
        /* renamed from: c */
        public void mo48918c() {
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.NativeWindowImageView$2 */
    public class RunnableC79142 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Drawable f36493a;

        public RunnableC79142(Drawable drawable) {
            drawable = drawable;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeWindowImageView.this.f36486e = drawable;
            NativeWindowImageView nativeWindowImageView = NativeWindowImageView.this;
            nativeWindowImageView.setImageDrawable(nativeWindowImageView.f36486e);
        }
    }

    @OuterVisible
    public NativeWindowImageView(Context context) {
        super(context);
        this.f36488g = new Rect();
        this.f36489h = 1.3007812f;
        this.f36490i = 0;
        this.f36491j = true;
        m48900a(context);
    }

    /* renamed from: c */
    private void m48907c() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.removeOnGlobalLayoutListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: d */
    private void m48908d() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: e */
    private void m48909e() {
        if (m48910f()) {
            m48905b();
            m48912h();
            m48913i();
            m48914j();
            m48911g();
        }
    }

    /* renamed from: f */
    private boolean m48910f() {
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        return rect.width() > 0 && rect.height() > 0;
    }

    /* renamed from: g */
    private void m48911g() {
        if (this.f36486e == null) {
            return;
        }
        this.f36483b.setScaleType(ImageView.ScaleType.MATRIX);
        int intrinsicWidth = this.f36486e.getIntrinsicWidth();
        float width = intrinsicWidth != 0 ? getWidth() / intrinsicWidth : 1.0f;
        Matrix matrix = new Matrix();
        matrix.setScale(width, width);
        matrix.postTranslate(0.0f, this.f36490i);
        this.f36483b.setImageMatrix(matrix);
        this.f36483b.invalidate();
    }

    /* renamed from: h */
    private void m48912h() {
        Object parent = this.f36482a.getParent();
        if (parent == null) {
            AbstractC7185ho.m43826d("NativeWindowImageView", "invalid parent obj");
        } else {
            ((View) parent).getGlobalVisibleRect(this.f36487f);
        }
    }

    /* renamed from: i */
    private void m48913i() {
        Rect rect = new Rect();
        getLocalVisibleRect(rect);
        Rect rect2 = new Rect();
        getGlobalVisibleRect(rect2);
        Rect rect3 = this.f36488g;
        int i10 = rect2.left - rect.left;
        rect3.left = i10;
        rect3.right = i10 + getWidth();
        Rect rect4 = this.f36488g;
        int i11 = rect2.top - rect.top;
        rect4.top = i11;
        rect4.bottom = i11 + getHeight();
    }

    /* renamed from: j */
    private void m48914j() {
        int width = (int) (getWidth() * this.f36489h);
        if (m48902a(width)) {
            int iHeight = (this.f36487f.height() - width) / 2;
            Rect rect = this.f36488g;
            int i10 = rect.top;
            Rect rect2 = this.f36487f;
            int i11 = rect2.top;
            if (i10 - i11 <= iHeight) {
                this.f36490i = 0;
            } else if (rect2.bottom - rect.bottom <= iHeight) {
                this.f36490i = rect.height() - width;
            } else {
                this.f36490i = (i11 + iHeight) - i10;
            }
        }
    }

    /* renamed from: k */
    public void m48915k() {
        int intrinsicWidth = this.f36486e.getIntrinsicWidth();
        int intrinsicHeight = this.f36486e.getIntrinsicHeight();
        if (intrinsicHeight != 0 && intrinsicWidth != 0) {
            this.f36489h = intrinsicHeight / intrinsicWidth;
        }
        m48909e();
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof C8101b) {
                ((C8101b) drawable).m50248a(new InterfaceC8103d() { // from class: com.huawei.openalliance.ad.views.NativeWindowImageView.1
                    public C79131() {
                    }

                    @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
                    /* renamed from: a */
                    public void mo48916a() {
                        NativeWindowImageView.this.m48915k();
                    }

                    @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
                    /* renamed from: b */
                    public void mo48917b() {
                    }

                    @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
                    /* renamed from: c */
                    public void mo48918c() {
                    }
                });
            } else {
                m48915k();
            }
            this.f36483b.setImageDrawable(drawable);
            this.f36484c.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m48907c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m48908d();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        m48909e();
    }

    @Override // com.huawei.openalliance.p169ad.views.AutoScaleSizeRelativeLayout, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        GifPlayView gifPlayView = this.f36483b;
        gifPlayView.layout(0, 0, gifPlayView.getMeasuredWidth(), this.f36483b.getMeasuredHeight());
    }

    @Override // com.huawei.openalliance.p169ad.views.AutoScaleSizeRelativeLayout, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = getMeasuredWidth();
        this.f36483b.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (measuredWidth * this.f36489h), 1073741824));
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        m48909e();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeWindowImageView
    public void setDisplayView(View view) {
        if (view != null) {
            this.f36491j = false;
            this.f36482a = view;
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeWindowImageView
    public void setNativeAd(INativeAd iNativeAd) {
        this.f36485d = iNativeAd;
        if (iNativeAd != null) {
            Iterator<ImageInfo> it = iNativeAd.getImageInfos().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ImageInfo next = it.next();
                if (next != null) {
                    String url = next.getUrl();
                    if (AbstractC7806cz.m48181j(url)) {
                        C7653sb c7653sb = new C7653sb();
                        c7653sb.m47187d(url);
                        c7653sb.m47184c(next.getSha256());
                        c7653sb.m47181b(next.isCheckSha256());
                        c7653sb.m47183c(next.m44470a());
                        c7653sb.m47180b(Constants.NATIVE_WINDOW_SUB_DIR);
                        C7752az.m47689a(getContext(), c7653sb, this);
                    } else {
                        C7752az.m47690a(getContext(), url, this);
                    }
                }
            }
            requestLayout();
        }
    }

    @OuterVisible
    public NativeWindowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36488g = new Rect();
        this.f36489h = 1.3007812f;
        this.f36490i = 0;
        this.f36491j = true;
        m48900a(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private void m48905b() {
        if (this.f36491j) {
            ViewParent parent = this.f36482a.getParent();
            while (parent != 0 && !m48903a(parent)) {
                parent = parent.getParent();
            }
            if (m48903a(parent)) {
                this.f36482a = (View) parent;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
    /* renamed from: a */
    public void mo30231a() {
        AbstractC7185ho.m43826d("NativeWindowImageView", "load image fail");
    }

    @OuterVisible
    public NativeWindowImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36488g = new Rect();
        this.f36489h = 1.3007812f;
        this.f36490i = 0;
        this.f36491j = true;
        m48900a(context);
    }

    /* renamed from: a */
    private void m48900a(Context context) {
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_window_image_layout, this);
        this.f36482a = this;
        this.f36483b = (GifPlayView) findViewById(C6849R.id.window_image_content);
        this.f36484c = (ProgressBar) findViewById(C6849R.id.window_image_progress);
        setRatio(Float.valueOf(1.7777778f));
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f36487f = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    @OuterVisible
    public NativeWindowImageView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f36488g = new Rect();
        this.f36489h = 1.3007812f;
        this.f36490i = 0;
        this.f36491j = true;
        m48900a(context);
    }

    @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
    /* renamed from: a */
    public void mo30232a(Drawable drawable) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.NativeWindowImageView.2

            /* renamed from: a */
            final /* synthetic */ Drawable f36493a;

            public RunnableC79142(Drawable drawable2) {
                drawable = drawable2;
            }

            @Override // java.lang.Runnable
            public void run() {
                NativeWindowImageView.this.f36486e = drawable;
                NativeWindowImageView nativeWindowImageView = NativeWindowImageView.this;
                nativeWindowImageView.setImageDrawable(nativeWindowImageView.f36486e);
            }
        });
    }

    /* renamed from: a */
    private boolean m48902a(int i10) {
        return this.f36487f.height() >= i10;
    }

    /* renamed from: a */
    private boolean m48903a(Object obj) {
        return obj instanceof PPSNativeView;
    }
}
