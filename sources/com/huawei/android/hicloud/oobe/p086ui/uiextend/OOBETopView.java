package com.huawei.android.hicloud.oobe.p086ui.uiextend;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.R$drawable;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$raw;
import com.huawei.android.hicloud.oobe.R$styleable;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p399jk.AbstractC10896a;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OOBETopView extends RelativeLayout {

    /* renamed from: a */
    public ImageView f12691a;

    /* renamed from: b */
    public Drawable f12692b;

    /* renamed from: c */
    public TextView f12693c;

    /* renamed from: d */
    public String f12694d;

    /* renamed from: e */
    public TextView f12695e;

    /* renamed from: f */
    public String f12696f;

    /* renamed from: g */
    public boolean f12697g;

    /* renamed from: h */
    public Context f12698h;

    /* renamed from: i */
    public VideoView f12699i;

    /* renamed from: j */
    public boolean f12700j;

    /* renamed from: k */
    public boolean f12701k;

    /* renamed from: com.huawei.android.hicloud.oobe.ui.uiextend.OOBETopView$a */
    public class C2867a implements MediaPlayer.OnPreparedListener {

        /* renamed from: com.huawei.android.hicloud.oobe.ui.uiextend.OOBETopView$a$a */
        public class a implements MediaPlayer.OnInfoListener {
            public a() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
                if (i10 != 3) {
                    return false;
                }
                OOBETopView.this.f12691a.setVisibility(8);
                OOBETopView.this.f12699i.setVisibility(0);
                return true;
            }
        }

        public C2867a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.setOnInfoListener(new a());
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.uiextend.OOBETopView$b */
    public class C2868b implements MediaPlayer.OnCompletionListener {
        public C2868b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                OOBETopView.this.f12699i.setVisibility(0);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("OOBETopView", "onCompletion failed " + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.uiextend.OOBETopView$c */
    public class C2869c implements MediaPlayer.OnErrorListener {
        public C2869c() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            AbstractC10896a.m65888w("OOBETopView", "videoView onError: " + i10 + ", " + i11);
            OOBETopView.this.f12691a.setVisibility(0);
            OOBETopView.this.f12699i.setVisibility(8);
            return true;
        }
    }

    public OOBETopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.oobe_top_attr);
        this.f12698h = context;
        if (attributeSet != null) {
            this.f12701k = typedArrayObtainStyledAttributes.getBoolean(R$styleable.oobe_top_attr_is_uniform_layout, false);
        }
        m17055e();
        m17052b(typedArrayObtainStyledAttributes);
    }

    /* renamed from: a */
    public void mo17035a() {
        if (C0219i.m1463a() <= 14) {
            View.inflate(this.f12698h, R$layout.oobe_top_view_emui8, this);
            return;
        }
        if (C0219i.m1463a() >= 15 && C0219i.m1463a() < 17) {
            if (C0209d.m1202Q0()) {
                View.inflate(this.f12698h, R$layout.oobe_top_view_cn_emui81, this);
                return;
            } else {
                View.inflate(this.f12698h, R$layout.oobe_top_view_foreign, this);
                return;
            }
        }
        if (C0219i.m1463a() >= 17 && C0219i.m1463a() < 21) {
            View.inflate(this.f12698h, R$layout.oobe_top_view_emui9, this);
            return;
        }
        if (C0219i.m1463a() >= 21 && C0219i.m1463a() < 27) {
            View.inflate(this.f12698h, R$layout.oobe_top_view_emui1101, this);
            return;
        }
        if (C0209d.m1269j1()) {
            View.inflate(this.f12698h, R$layout.oobe_top_view_honor, this);
        } else if (this.f12701k) {
            View.inflate(this.f12698h, R$layout.oobe_top_view_uniform, this);
        } else {
            View.inflate(this.f12698h, R$layout.oobe_top_view, this);
        }
    }

    /* renamed from: b */
    public final void m17052b(TypedArray typedArray) {
        if (typedArray != null) {
            this.f12694d = typedArray.getString(R$styleable.oobe_top_attr_top_title);
            this.f12696f = typedArray.getString(R$styleable.oobe_top_attr_top_sub_title);
            this.f12697g = typedArray.getBoolean(R$styleable.oobe_top_attr_top_img_region_diff, false);
            this.f12700j = typedArray.getBoolean(R$styleable.oobe_top_attr_top_need_video, false);
            if (!this.f12697g || C0209d.m1202Q0()) {
                this.f12692b = typedArray.getDrawable(R$styleable.oobe_top_attr_top_img);
            } else {
                this.f12692b = typedArray.getDrawable(R$styleable.oobe_top_attr_top_img_foreign);
            }
            if (this.f12692b == null) {
                this.f12691a.setVisibility(8);
            } else {
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a != null && this.f12701k && C0209d.m1293p1()) {
                    this.f12692b = contextM1377a.getDrawable(R$drawable.welcom_gif_bg_ink);
                }
                this.f12691a.setImageDrawable(this.f12692b);
            }
            this.f12693c.setText(this.f12694d);
            if (TextUtils.isEmpty(this.f12696f)) {
                this.f12695e.setVisibility(8);
            } else {
                this.f12695e.setText(this.f12696f);
            }
            typedArray.recycle();
        }
    }

    /* renamed from: c */
    public void m17053c(Context context) {
        C11842p.m70827j2(this.f12691a, (int) (C11842p.m70789a0(context) + C11842p.m70844o(context, C0209d.m1202Q0() ? 24 : 40)));
    }

    /* renamed from: d */
    public void m17054d(Context context, int i10) {
        C11842p.m70827j2(this.f12691a, (int) C11842p.m70844o(context, i10));
    }

    /* renamed from: e */
    public final void m17055e() {
        mo17035a();
        this.f12691a = (ImageView) C12809f.m76831d(this, R$id.oobe_top_icon);
        this.f12693c = (TextView) C12809f.m76831d(this, R$id.oobe_top_title);
        this.f12695e = (TextView) C12809f.m76831d(this, R$id.oobe_top_subtitle);
        this.f12699i = (VideoView) C12809f.m76831d(this, R$id.videoView);
    }

    /* renamed from: f */
    public void m17056f(Context context) {
        C11842p.m70827j2(this.f12691a, (int) (((int) (C11842p.m70876w(context).widthPixels * 0.268f)) * 0.13f));
    }

    /* renamed from: g */
    public void m17057g(Context context) {
        C11842p.m70827j2(this.f12691a, (int) (((int) (C11842p.m70876w(context).widthPixels * 0.62f)) * 0.38f));
    }

    public ImageView getIconView() {
        return this.f12691a;
    }

    public TextView getSubTitleView() {
        return this.f12695e;
    }

    public TextView getTitleView() {
        return this.f12693c;
    }

    /* renamed from: h */
    public void m17058h(Context context) {
        C11842p.m70827j2(this.f12691a, (int) (((int) (C11842p.m70876w(context).widthPixels * 0.8f)) * 0.16f));
    }

    /* renamed from: i */
    public void m17059i(Context context) {
        C11842p.m70827j2(this.f12691a, (int) (((int) (C11842p.m70876w(context).heightPixels * 0.5d)) * 0.15f));
    }

    /* renamed from: j */
    public void m17060j(Context context) {
        C11842p.m70827j2(this.f12691a, (int) (((int) (C11842p.m70876w(context).heightPixels * 0.5d)) * 0.25f));
    }

    /* renamed from: k */
    public void m17061k() {
        Context context;
        if (!this.f12700j || !C0209d.m1269j1()) {
            AbstractC10896a.m65887i("OOBETopView", "no Need Video");
            this.f12691a.setVisibility(0);
            VideoView videoView = this.f12699i;
            if (videoView != null) {
                videoView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f12699i == null || (context = this.f12698h) == null) {
            AbstractC10896a.m65885d("OOBETopView", "welcomeVideo null");
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null || audioManager.isMusicActive()) {
            AbstractC10896a.m65885d("OOBETopView", "isMusicActive");
            return;
        }
        this.f12699i.setOnPreparedListener(new C2867a());
        this.f12699i.setOnCompletionListener(new C2868b());
        this.f12699i.setOnErrorListener(new C2869c());
        try {
            this.f12699i.setVideoURI(Uri.parse("android.resource://" + this.f12698h.getPackageName() + "/" + R$raw.hicloud));
            this.f12691a.setVisibility(8);
            this.f12699i.setVisibility(0);
            this.f12699i.setZOrderOnTop(true);
            AbstractC10896a.m65887i("OOBETopView", "welcomeVideo start");
            this.f12699i.start();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("OOBETopView", "start failed " + e10.toString());
        }
    }

    /* renamed from: l */
    public void m17062l() throws Resources.NotFoundException {
        if (this.f12691a == null || this.f12693c == null) {
            AbstractC10896a.m65886e("OOBETopView", "mIconView || mTitleView is null");
            return;
        }
        AbstractC10896a.m65887i("OOBETopView", "setNewMargin");
        this.f12691a.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.oobe_img_new_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.oobe_new_top_margin);
        C11842p.m70739J1(this.f12691a, dimensionPixelSize);
        C11842p.m70727F1(this.f12691a, dimensionPixelSize);
        C11842p.m70736I1(this.f12691a, dimensionPixelSize2);
        C11842p.m70736I1(this.f12693c, dimensionPixelSize2);
        C12809f.m76843p(this.f12695e, false);
    }

    /* renamed from: m */
    public void m17063m() {
        VideoView videoView = this.f12699i;
        if (videoView != null) {
            videoView.stopPlayback();
        }
    }

    public void setIconView(Drawable drawable) {
        ImageView imageView = this.f12691a;
        if (imageView == null || drawable == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    public void setSubTitleText(String str) {
        this.f12695e.setText(str);
    }

    public void setTitleText(String str) {
        this.f12693c.setText(str);
    }
}
