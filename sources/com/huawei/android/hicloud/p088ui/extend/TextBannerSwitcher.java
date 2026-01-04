package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.huawei.hicloud.sync.R$anim;
import com.huawei.hicloud.sync.R$styleable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import p514o9.C11839m;
import p514o9.C11842p;
import p815ym.AbstractC14026a;

/* loaded from: classes3.dex */
public class TextBannerSwitcher extends RelativeLayout {

    /* renamed from: a */
    public TextSwitcher f17973a;

    /* renamed from: b */
    public int f17974b;

    /* renamed from: c */
    public boolean f17975c;

    /* renamed from: d */
    public int f17976d;

    /* renamed from: e */
    public int f17977e;

    /* renamed from: f */
    public int f17978f;

    /* renamed from: g */
    public boolean f17979g;

    /* renamed from: h */
    public int f17980h;

    /* renamed from: i */
    public int f17981i;

    /* renamed from: j */
    public int f17982j;

    /* renamed from: k */
    public int f17983k;

    /* renamed from: l */
    public int f17984l;

    /* renamed from: m */
    public int f17985m;

    /* renamed from: n */
    public int f17986n;

    /* renamed from: o */
    public boolean f17987o;

    /* renamed from: p */
    public List<CharSequence> f17988p;

    /* renamed from: q */
    public int f17989q;

    /* renamed from: r */
    public CustomTextViewCallBack f17990r;

    /* renamed from: s */
    public boolean f17991s;

    /* renamed from: t */
    public Handler f17992t;

    /* renamed from: u */
    public int f17993u;

    public interface CustomTextViewCallBack {
        /* renamed from: a */
        TextView mo23906a();
    }

    /* renamed from: com.huawei.android.hicloud.ui.extend.TextBannerSwitcher$a */
    public class HandlerC3939a extends Handler {
        public HandlerC3939a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            super.handleMessage(message);
            if (TextBannerSwitcher.this.f17988p.isEmpty()) {
                return;
            }
            TextBannerSwitcher.this.m24026i();
            TextBannerSwitcher textBannerSwitcher = TextBannerSwitcher.this;
            textBannerSwitcher.m24029l(textBannerSwitcher.f17984l);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.extend.TextBannerSwitcher$b */
    public class C3940b implements ViewSwitcher.ViewFactory {
        public C3940b() {
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            CustomTextViewCallBack customTextViewCallBack = TextBannerSwitcher.this.f17990r;
            TextView textViewMo23906a = customTextViewCallBack != null ? customTextViewCallBack.mo23906a() : null;
            if (textViewMo23906a == null) {
                textViewMo23906a = new TextView(TextBannerSwitcher.this.getContext());
            }
            TextBannerSwitcher.this.setTextView(textViewMo23906a);
            C11839m.m70686d("TextBannerSwitcher", "makeView:" + textViewMo23906a);
            return textViewMo23906a;
        }
    }

    public TextBannerSwitcher(Context context) {
        this(context, null);
    }

    private void setInAnimation(int i10) throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), i10);
        animationLoadAnimation.setDuration(this.f17984l);
        this.f17973a.setInAnimation(animationLoadAnimation);
    }

    private void setOutAnimation(int i10) throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), i10);
        animationLoadAnimation.setDuration(this.f17984l);
        this.f17973a.setOutAnimation(animationLoadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextView(TextView textView) {
        int i10;
        textView.setSingleLine(this.f17975c);
        if (!this.f17975c && (i10 = this.f17976d) != 0) {
            textView.setMaxLines(i10);
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.f17977e);
        textView.setTextSize(this.f17978f);
        textView.getPaint().setFlags(this.f17985m);
        textView.setTypeface(null, this.f17986n);
        int i11 = this.f17993u;
        if (i11 > 0) {
            textView.setTextAppearance(i11);
        }
        int i12 = this.f17980h;
        if (i12 == 1) {
            textView.setGravity(i12);
        }
    }

    /* renamed from: e */
    public final void m24022e(Context context, AttributeSet attributeSet, int i10) {
        int i11;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TextBannerViewStyle, i10, 0);
        this.f17974b = typedArrayObtainStyledAttributes.getInteger(R$styleable.TextBannerViewStyle_setInterval, this.f17974b);
        this.f17975c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TextBannerViewStyle_setSingleLine, false);
        this.f17977e = typedArrayObtainStyledAttributes.getColor(R$styleable.TextBannerViewStyle_setTextColor, this.f17977e);
        int i12 = R$styleable.TextBannerViewStyle_setTextSize;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            int dimension = (int) typedArrayObtainStyledAttributes.getDimension(i12, this.f17978f);
            this.f17978f = dimension;
            this.f17978f = C11842p.m70814g1(context, dimension);
            Resources resources = context.getResources();
            if (resources != null) {
                float f10 = resources.getConfiguration().fontScale;
                if (f10 > 1.0f) {
                    this.f17978f = (int) ((this.f17978f * 1.0f) / f10);
                }
            }
        }
        this.f17984l = typedArrayObtainStyledAttributes.getInt(R$styleable.TextBannerViewStyle_setAnimDuration, this.f17984l);
        int i13 = R$styleable.TextBannerViewStyle_setDirection;
        this.f17979g = typedArrayObtainStyledAttributes.hasValue(i13);
        this.f17981i = typedArrayObtainStyledAttributes.getInt(i13, this.f17981i);
        this.f17980h = typedArrayObtainStyledAttributes.getInt(R$styleable.TextBannerViewStyle_setGravity, this.f17980h);
        this.f17976d = typedArrayObtainStyledAttributes.getInt(R$styleable.TextBannerViewStyle_maxLine, this.f17976d);
        this.f17993u = typedArrayObtainStyledAttributes.getResourceId(R$styleable.TextBannerViewStyle_textStyleId, this.f17993u);
        if (!this.f17979g || (i11 = this.f17981i) == 0) {
            this.f17982j = R$anim.anim_bottom_in;
            this.f17983k = R$anim.anim_top_out;
        } else if (i11 == 1) {
            this.f17982j = R$anim.anim_top_in;
            this.f17983k = R$anim.anim_bottom_out;
        } else if (i11 == 2) {
            this.f17982j = R$anim.anim_right_in;
            this.f17983k = R$anim.anim_left_out;
        } else if (i11 == 3) {
            this.f17982j = R$anim.anim_left_in;
            this.f17983k = R$anim.anim_right_out;
        }
        this.f17985m = typedArrayObtainStyledAttributes.getInt(R$styleable.TextBannerViewStyle_setFlags, this.f17985m);
        m24025h();
        this.f17986n = typedArrayObtainStyledAttributes.getInt(R$styleable.TextBannerViewStyle_setTypeface, this.f17986n);
        m24024g();
    }

    /* renamed from: f */
    public final void m24023f(int i10) {
        this.f17991s = false;
        Handler handler = this.f17992t;
        handler.sendMessageDelayed(handler.obtainMessage(this.f17989q), i10);
    }

    /* renamed from: g */
    public final void m24024g() {
        int i10 = this.f17986n;
        if (i10 == 1) {
            this.f17986n = 1;
            return;
        }
        if (i10 == 2) {
            this.f17986n = 2;
        } else if (i10 != 3) {
            this.f17986n = 0;
        } else {
            this.f17986n = 3;
        }
    }

    /* renamed from: h */
    public final void m24025h() {
        int i10 = this.f17985m;
        if (i10 == 0) {
            this.f17985m = 17;
        } else if (i10 != 1) {
            this.f17985m = 1;
        } else {
            this.f17985m = 9;
        }
    }

    /* renamed from: i */
    public final void m24026i() {
        C11839m.m70686d("TextBannerSwitcher", "setSwitcherText mTextSwitcher settext = " + ((Object) this.f17988p.get(this.f17989q)));
        this.f17973a.setText(this.f17988p.get(this.f17989q));
        int i10 = this.f17989q + 1;
        this.f17989q = i10;
        if (i10 >= this.f17988p.size()) {
            this.f17989q = 0;
        }
    }

    /* renamed from: j */
    public void m24027j(String str, int i10) {
        List<CharSequence> list = this.f17988p;
        if (list == null || list.size() < i10 + 1) {
            return;
        }
        this.f17988p.set(i10, str);
    }

    /* renamed from: k */
    public final void m24028k() {
        if (this.f17973a != null) {
            return;
        }
        TextSwitcher textSwitcher = new TextSwitcher(getContext());
        this.f17973a = textSwitcher;
        textSwitcher.setFactory(new C3940b());
        this.f17973a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        addView(this.f17973a);
    }

    /* renamed from: l */
    public void m24029l(int i10) throws Resources.NotFoundException {
        C11839m.m70686d("TextBannerSwitcher", "startViewAnimator , animDuration = " + i10 + " , isDetachedFromWindow = " + this.f17987o);
        if (this.f17988p == null || this.f17987o) {
            return;
        }
        if (this.f17973a.getOutAnimation() == null) {
            setOutAnimation(this.f17983k);
        }
        if (this.f17973a.getInAnimation() == null) {
            setInAnimation(this.f17982j);
        }
        this.f17991s = false;
        m24023f(this.f17974b + i10);
    }

    /* renamed from: m */
    public void m24030m() {
        if (this.f17973a == null) {
            return;
        }
        this.f17991s = true;
        this.f17992t.removeCallbacksAndMessages(null);
        this.f17973a.setOutAnimation(null);
        this.f17973a.setInAnimation(null);
        if (this.f17988p.isEmpty()) {
            return;
        }
        TextSwitcher textSwitcher = this.f17973a;
        List<CharSequence> list = this.f17988p;
        textSwitcher.setText(list.get(list.size() - 1));
    }

    /* renamed from: n */
    public void m24031n(List<CharSequence> list) {
        if (list == null) {
            C11839m.m70688i("TextBannerSwitcher", "updateData fail: data is null");
            return;
        }
        this.f17992t.removeCallbacksAndMessages(null);
        this.f17988p.clear();
        setDataIfNotNull(list);
    }

    /* renamed from: o */
    public void m24032o(List<CharSequence> list) {
        if (list == null) {
            C11839m.m70688i("TextBannerSwitcher", "updateDataIfNeed fail: data is null");
            return;
        }
        if (AbstractC14026a.m84159a(this.f17988p)) {
            setDataIfNotNull(list);
            return;
        }
        List list2 = (List) this.f17988p.stream().map(new Function() { // from class: com.huawei.android.hicloud.ui.extend.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((CharSequence) obj).toString();
            }
        }).collect(Collectors.toList());
        List list3 = (List) list.stream().map(new Function() { // from class: com.huawei.android.hicloud.ui.extend.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((CharSequence) obj).toString();
            }
        }).collect(Collectors.toList());
        Collections.sort(list2);
        Collections.sort(list3);
        if (!list2.equals(list3) || this.f17991s) {
            m24031n(list);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C11839m.m70686d("TextBannerSwitcher", "onAttached");
        this.f17987o = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C11839m.m70686d("TextBannerSwitcher", "onDetached");
        this.f17987o = true;
        m24030m();
    }

    public void setCustomTextViewCallBack(CustomTextViewCallBack customTextViewCallBack) {
        this.f17990r = customTextViewCallBack;
    }

    public void setDataIfNotNull(List<CharSequence> list) {
        m24028k();
        if (this.f17988p.isEmpty() && !list.isEmpty()) {
            this.f17988p.addAll(list);
            C11839m.m70686d("TextBannerSwitcher", "startViewAnimator mTextSwitcher settext = " + ((Object) this.f17988p.get(0)));
        }
        this.f17989q = 0;
        this.f17973a.setOutAnimation(null);
        this.f17973a.setInAnimation(null);
        this.f17973a.setText(this.f17988p.get(this.f17989q));
        if (this.f17988p.size() > 1) {
            m24023f(0);
        }
    }

    public TextBannerSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17974b = 3000;
        this.f17975c = false;
        this.f17977e = -16777216;
        this.f17978f = 16;
        this.f17979g = false;
        this.f17981i = 0;
        this.f17982j = R$anim.anim_right_in;
        this.f17983k = R$anim.anim_left_out;
        this.f17984l = 1500;
        this.f17985m = -1;
        this.f17986n = 0;
        this.f17988p = new ArrayList();
        this.f17989q = 0;
        this.f17990r = null;
        this.f17992t = new HandlerC3939a();
        this.f17993u = -1;
        m24022e(context, attributeSet, 0);
    }
}
