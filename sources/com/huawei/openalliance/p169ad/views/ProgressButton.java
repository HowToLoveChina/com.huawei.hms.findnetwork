package com.huawei.openalliance.p169ad.views;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.uiengine.common.IProgressButton;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ProgressButton extends View implements View.OnClickListener, IProgressButton {

    /* renamed from: A */
    private Drawable f37276A;

    /* renamed from: B */
    private long f37277B;

    /* renamed from: C */
    private Paint f37278C;

    /* renamed from: D */
    private boolean f37279D;

    /* renamed from: E */
    private IProgressButton.ProgressButtonResetListener f37280E;

    /* renamed from: F */
    private int f37281F;

    /* renamed from: a */
    protected Rect f37282a;

    /* renamed from: b */
    protected Paint f37283b;

    /* renamed from: c */
    protected CharSequence f37284c;

    /* renamed from: d */
    String f37285d;

    /* renamed from: e */
    int f37286e;

    /* renamed from: f */
    int f37287f;

    /* renamed from: g */
    protected Drawable f37288g;

    /* renamed from: h */
    protected final byte[] f37289h;

    /* renamed from: i */
    protected int f37290i;

    /* renamed from: j */
    protected int f37291j;

    /* renamed from: k */
    protected int f37292k;

    /* renamed from: l */
    protected boolean f37293l;

    /* renamed from: m */
    protected boolean f37294m;

    /* renamed from: n */
    protected int f37295n;

    /* renamed from: o */
    private final String f37296o;

    /* renamed from: p */
    private int f37297p;

    /* renamed from: q */
    private boolean f37298q;

    /* renamed from: r */
    private boolean f37299r;

    /* renamed from: s */
    private int f37300s;

    /* renamed from: t */
    private int f37301t;

    /* renamed from: u */
    private int f37302u;

    /* renamed from: v */
    private int f37303v;

    /* renamed from: w */
    private float f37304w;

    /* renamed from: x */
    private Float f37305x;

    /* renamed from: y */
    private int f37306y;

    /* renamed from: z */
    private int f37307z;

    public ProgressButton(Context context) {
        this(context, null);
        m49840b();
    }

    /* renamed from: a */
    private float m49830a(CharSequence charSequence, float f10) {
        AbstractC7185ho.m43818a(this.f37296o, "startSize:%s", Float.valueOf(f10));
        int paddingSize = getPaddingSize();
        int buttonSize = getButtonSize();
        int iM47570d = AbstractC7741ao.m47570d(getContext(), f10);
        while (iM47570d > 9 && !m49839a(charSequence, iM47570d, paddingSize, buttonSize)) {
            iM47570d--;
        }
        float fM47565c = AbstractC7741ao.m47565c(getContext(), iM47570d);
        AbstractC7185ho.m43818a(this.f37296o, "resultSize:%s", Float.valueOf(fM47565c));
        return fM47565c;
    }

    /* renamed from: b */
    private void m49840b() {
        Paint paint = new Paint();
        this.f37283b = paint;
        paint.setAntiAlias(true);
        this.f37283b.setTextSize(this.f37304w);
        this.f37283b.setColor(this.f37303v);
        Paint paint2 = new Paint();
        this.f37278C = paint2;
        paint2.setTextSize(this.f37304w);
        int i10 = this.f37287f;
        if (i10 != -1) {
            this.f37285d = null;
        }
        m49837a(this.f37285d, this.f37286e, i10);
        setClickable(true);
        Paint paint3 = new Paint();
        paint3.setTextSize(this.f37304w);
        Rect rect = new Rect();
        paint3.getTextBounds("...", 0, 3, rect);
        this.f37297p = rect.width();
        this.f37279D = AbstractC7811dd.m48332h();
        this.f37281F = AbstractC7741ao.m47535a(getContext(), 40.0f);
    }

    /* renamed from: c */
    private void m49843c() {
        if (this.f37293l) {
            int measuredHeight = this.f37302u;
            if (measuredHeight <= 0) {
                measuredHeight = getMeasuredHeight();
            }
            if (measuredHeight <= 0) {
                return;
            }
            boolean z10 = measuredHeight < this.f37281F;
            this.f37290i = AbstractC7741ao.m47535a(getContext(), z10 ? 24 : 36);
            this.f37291j = AbstractC7741ao.m47535a(getContext(), z10 ? 8 : 16);
            this.f37292k = (measuredHeight / 2) + (AbstractC7741ao.m47535a(getContext(), 12) / 2) + AbstractC7741ao.m47535a(getContext(), z10 ? 4 : 8);
            AbstractC7185ho.m43818a(this.f37296o, "update text safe padding, start: %s, end: %s", Integer.valueOf(this.f37291j), Integer.valueOf(this.f37292k));
        }
    }

    /* renamed from: d */
    private void m49844d() {
        Paint paint = new Paint();
        paint.setTextSize(this.f37304w);
        Rect rect = new Rect();
        paint.getTextBounds("...", 0, 3, rect);
        this.f37297p = rect.width();
    }

    /* renamed from: e */
    private void m49845e() {
        synchronized (this.f37289h) {
            try {
                int[] drawableState = getDrawableState();
                Drawable drawable = this.f37288g;
                if (drawable != null && drawable.isStateful()) {
                    this.f37288g.setState(drawableState);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private int getButtonSize() {
        if (!this.f37298q) {
            return this.f37300s;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int width = getWidth();
        return width <= 0 ? layoutParams.width : width;
    }

    private int getPaddingSize() {
        return m49831a(getPaddingStart(), getPaddingLeft(), this.f37291j) + m49831a(getPaddingEnd(), getPaddingRight(), this.f37292k);
    }

    private void setOriginTextSize(Float f10) {
        if (f10 != null) {
            Float f11 = this.f37305x;
            if (f11 == null || f11.floatValue() == 0.0f) {
                this.f37305x = f10;
            }
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        AbstractC7185ho.m43817a(this.f37296o, "drawableStateChanged");
        super.drawableStateChanged();
        m49845e();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public int getCancelBtnHeight(int i10) {
        return i10;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public int getProgress() {
        int i10;
        synchronized (this.f37289h) {
            i10 = this.f37306y;
        }
        return i10;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public View getProgressBtn() {
        return this;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public Drawable getProgressDrawable() {
        Drawable drawable;
        synchronized (this.f37289h) {
            drawable = this.f37288g;
        }
        return drawable;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public Rect getPromptRect() {
        Rect rect;
        synchronized (this.f37289h) {
            rect = this.f37282a;
        }
        return rect;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public AppStatus getStatus() {
        return null;
    }

    public CharSequence getText() {
        CharSequence charSequence;
        synchronized (this.f37289h) {
            charSequence = this.f37284c;
        }
        return charSequence;
    }

    public int getTextStart() {
        if (AbstractC7811dd.m48332h()) {
            return this.f37292k;
        }
        int width = ((getWidth() - this.f37282a.width()) - this.f37290i) / 2;
        int i10 = this.f37291j;
        if (width < i10) {
            width = i10;
        }
        AbstractC7185ho.m43818a(this.f37296o, "safeTextStart: %s", Integer.valueOf(width));
        return width;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public final void incrementProgressBy(int i10) {
        synchronized (this.f37289h) {
            setProgress(this.f37306y + i10);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public boolean isFastClick() {
        if (System.currentTimeMillis() - this.f37277B < 500) {
            return true;
        }
        this.f37277B = System.currentTimeMillis();
        return false;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        synchronized (this.f37289h) {
            try {
                super.jumpDrawablesToCurrentState();
                Drawable drawable = this.f37288g;
                if (drawable != null) {
                    drawable.jumpToCurrentState();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this.f37289h) {
            try {
                super.onDraw(canvas);
                Drawable drawable = this.f37276A;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                if (m49838a(drawable)) {
                    canvas.scale(-1.0f, 1.0f, getWidth() / 2.0f, getHeight() / 2.0f);
                }
                mo49850a(canvas);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.f37310a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedStateM49851a;
        synchronized (this.f37289h) {
            savedStateM49851a = SavedState.m49851a(super.onSaveInstanceState());
            savedStateM49851a.f37310a = this.f37306y;
        }
        return savedStateM49851a;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        mo49848a(i10, i11);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setCancelBtnHeight(int i10) {
        this.f37295n = i10;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setFixedWidth(boolean z10) {
        this.f37298q = z10;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setFontFamily(String str) {
        this.f37285d = str;
        m49837a(str, this.f37286e, this.f37287f);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMax(int i10) {
        synchronized (this.f37289h) {
            if (i10 < 0) {
                i10 = 0;
            }
            try {
                if (i10 != this.f37307z) {
                    this.f37307z = i10;
                    postInvalidate();
                    if (this.f37306y > i10) {
                        this.f37306y = i10;
                    }
                    m49842b(this.f37306y, false);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMaxWidth(int i10) {
        synchronized (this.f37289h) {
            this.f37300s = i10;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMinWidth(int i10) {
        synchronized (this.f37289h) {
            this.f37301t = i10;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setPaintTypeface(Typeface typeface) {
        synchronized (this.f37289h) {
            this.f37283b.setTypeface(typeface);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgress(int i10) {
        synchronized (this.f37289h) {
            m49849a(i10, false);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgressDrawable(Drawable drawable) {
        setProgressDrawable(drawable, 0);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setResetListener(IProgressButton.ProgressButtonResetListener progressButtonResetListener) {
        this.f37280E = progressButtonResetListener;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setResetWidth(boolean z10) {
        this.f37299r = z10;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setShowCancelBtn(boolean z10) {
        this.f37294m = z10;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setText(CharSequence charSequence) {
        AbstractC7185ho.m43818a(this.f37296o, "setText:%s, need safepadding: %s", charSequence, Boolean.valueOf(this.f37293l));
        synchronized (this.f37289h) {
            try {
                m49843c();
                this.f37284c = String.valueOf(charSequence).toUpperCase(Locale.getDefault());
                Float f10 = this.f37305x;
                float fM49830a = m49830a(this.f37284c, f10 != null ? f10.floatValue() : this.f37304w);
                if (!TextUtils.isEmpty(charSequence) && Math.abs(fM49830a - this.f37304w) >= 0.5f) {
                    setTextSize(fM49830a);
                }
                if (getWidth() > 0 || this.f37299r) {
                    m49846a();
                } else {
                    post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ProgressButton.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AbstractC7185ho.m43819a()) {
                                AbstractC7185ho.m43817a(ProgressButton.this.f37296o, "view post, resetButtonSize");
                            }
                            ProgressButton.this.m49846a();
                        }
                    });
                }
                postInvalidate();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setTextColor(int i10) {
        this.f37303v = i10;
        Paint paint = this.f37283b;
        if (paint != null) {
            paint.setColor(i10);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextInner(CharSequence charSequence, boolean z10) {
        this.f37293l = z10;
        setText(charSequence);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextSize(float f10) {
        this.f37304w = f10;
        setOriginTextSize(Float.valueOf(f10));
        Paint paint = this.f37283b;
        if (paint != null) {
            paint.setAntiAlias(true);
            this.f37283b.setTextSize(this.f37304w);
        }
        m49844d();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void updateLayoutHeight() {
        this.f37302u = ((int) this.f37304w) + getPaddingTop() + getPaddingBottom();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        boolean z10;
        synchronized (this.f37289h) {
            try {
                z10 = drawable == this.f37288g || super.verifyDrawable(drawable);
            } finally {
            }
        }
        return z10;
    }

    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.huawei.openalliance.ad.views.ProgressButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };

        /* renamed from: b */
        private static SavedState f37309b;

        /* renamed from: a */
        int f37310a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f37310a = parcel.readInt();
        }

        /* renamed from: a */
        public static SavedState m49851a(Parcelable parcelable) {
            if (f37309b == null) {
                f37309b = new SavedState(parcelable);
            }
            return f37309b;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f37310a);
        }

        private SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.progressBarStyle);
        m49836a(context, attributeSet);
        m49840b();
    }

    /* renamed from: a */
    private int m49831a(int i10, int i11, int i12) {
        if (i10 <= 0) {
            i10 = i11;
        }
        return (!this.f37293l || i12 <= 0 || i10 >= i12) ? i10 : i12;
    }

    /* renamed from: b */
    private void m49841b(int i10, ViewGroup.LayoutParams layoutParams) {
        int width = getWidth();
        if (width <= 0 && this.f37299r) {
            width = layoutParams.width;
        }
        if (i10 > width && width > 0) {
            CharSequence charSequenceM49832a = m49832a(this.f37284c, i10, width);
            this.f37284c = charSequenceM49832a;
            this.f37283b.getTextBounds(charSequenceM49832a.toString(), 0, this.f37284c.length(), this.f37282a);
        } else {
            if (width > 0 || !this.f37299r) {
                return;
            }
            layoutParams.width = i10;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setPaintTypeface(Typeface typeface, int i10) {
        if (i10 <= 0) {
            this.f37283b.setFakeBoldText(false);
            this.f37283b.setTextSkewX(0.0f);
            setPaintTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i10) : Typeface.create(typeface, i10);
            setPaintTypeface(typefaceDefaultFromStyle);
            int i11 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i10;
            this.f37283b.setFakeBoldText((i11 & 1) != 0);
            this.f37283b.setTextSkewX((i11 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgressDrawable(Drawable drawable, int i10) {
        boolean z10;
        synchronized (this.f37289h) {
            try {
                Drawable drawable2 = this.f37288g;
                if (drawable2 == null || drawable == drawable2) {
                    z10 = false;
                } else {
                    drawable2.setCallback(null);
                    this.f37288g.setState(new int[0]);
                    z10 = true;
                }
                if (drawable != null) {
                    drawable.setCallback(this);
                }
                this.f37288g = drawable;
                this.f37276A = drawable;
                if (z10) {
                    mo49848a(getWidth(), getHeight());
                    if (i10 < 0) {
                        i10 = 0;
                    }
                    int i11 = this.f37307z;
                    if (i10 > i11) {
                        i10 = i11;
                    }
                    this.f37306y = i10;
                    m49835a(i10, false, false);
                } else {
                    setProgress(i10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        m49836a(context, attributeSet);
        m49840b();
    }

    /* renamed from: a */
    private CharSequence m49832a(CharSequence charSequence, int i10, int i11) {
        int length = getText().length();
        int iCeil = (int) Math.ceil(((i10 - i11) / getPromptRect().width()) * length);
        int iCeil2 = (int) Math.ceil((this.f37297p * length) / getPromptRect().width());
        int i12 = length - iCeil;
        if (i12 - iCeil2 <= 0) {
            return i12 > 0 ? charSequence.toString().substring(0, i12) : charSequence;
        }
        return charSequence.toString().substring(0, length - (iCeil + iCeil2)) + "...";
    }

    /* renamed from: b */
    private void m49842b(int i10, boolean z10) {
        synchronized (this.f37289h) {
            m49835a(i10, z10, true);
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.f37296o = "ProgressBtn_" + hashCode();
        this.f37282a = new Rect();
        this.f37298q = false;
        this.f37299r = true;
        this.f37303v = -1;
        this.f37304w = 12.0f;
        this.f37305x = null;
        this.f37285d = null;
        this.f37286e = -1;
        this.f37287f = -1;
        this.f37306y = 0;
        this.f37307z = 100;
        this.f37289h = new byte[0];
        this.f37293l = false;
        setOnClickListener(this);
        m49836a(context, attributeSet);
        m49840b();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0081 A[Catch: all -> 0x004f, TryCatch #0 {all -> 0x004f, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000f, B:11:0x004d, B:15:0x0051, B:17:0x0055, B:18:0x0057, B:20:0x005b, B:21:0x006a, B:23:0x006e, B:24:0x0071, B:28:0x007d, B:30:0x0081, B:31:0x0088, B:25:0x0075, B:27:0x0079, B:33:0x008a), top: B:37:0x0003 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m49846a() {
        /*
            r6 = this;
            byte[] r0 = r6.f37289h
            monitor-enter(r0)
            java.lang.CharSequence r1 = r6.f37284c     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L8a
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto Lf
            goto L8a
        Lf:
            android.graphics.Paint r1 = r6.f37283b     // Catch: java.lang.Throwable -> L4f
            java.lang.CharSequence r2 = r6.f37284c     // Catch: java.lang.Throwable -> L4f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L4f
            java.lang.CharSequence r3 = r6.f37284c     // Catch: java.lang.Throwable -> L4f
            int r3 = r3.length()     // Catch: java.lang.Throwable -> L4f
            android.graphics.Rect r4 = r6.f37282a     // Catch: java.lang.Throwable -> L4f
            r5 = 0
            r1.getTextBounds(r2, r5, r3, r4)     // Catch: java.lang.Throwable -> L4f
            int r1 = r6.getPaddingStart()     // Catch: java.lang.Throwable -> L4f
            int r2 = r6.getPaddingLeft()     // Catch: java.lang.Throwable -> L4f
            int r3 = r6.f37291j     // Catch: java.lang.Throwable -> L4f
            int r1 = r6.m49831a(r1, r2, r3)     // Catch: java.lang.Throwable -> L4f
            int r2 = r6.getPaddingEnd()     // Catch: java.lang.Throwable -> L4f
            int r3 = r6.getPaddingRight()     // Catch: java.lang.Throwable -> L4f
            int r4 = r6.f37292k     // Catch: java.lang.Throwable -> L4f
            int r2 = r6.m49831a(r2, r3, r4)     // Catch: java.lang.Throwable -> L4f
            android.graphics.Rect r3 = r6.f37282a     // Catch: java.lang.Throwable -> L4f
            int r3 = r3.width()     // Catch: java.lang.Throwable -> L4f
            int r3 = r3 + r1
            int r3 = r3 + r2
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto L51
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            return
        L4f:
            r6 = move-exception
            goto L8c
        L51:
            int r2 = r6.f37302u     // Catch: java.lang.Throwable -> L4f
            if (r2 <= 0) goto L57
            r1.height = r2     // Catch: java.lang.Throwable -> L4f
        L57:
            int r2 = r1.height     // Catch: java.lang.Throwable -> L4f
            if (r2 > 0) goto L6a
            float r2 = r6.f37304w     // Catch: java.lang.Throwable -> L4f
            int r2 = (int) r2     // Catch: java.lang.Throwable -> L4f
            int r4 = r6.getPaddingTop()     // Catch: java.lang.Throwable -> L4f
            int r2 = r2 + r4
            int r4 = r6.getPaddingBottom()     // Catch: java.lang.Throwable -> L4f
            int r2 = r2 + r4
            r1.height = r2     // Catch: java.lang.Throwable -> L4f
        L6a:
            boolean r2 = r6.f37298q     // Catch: java.lang.Throwable -> L4f
            if (r2 == 0) goto L75
            r6.m49841b(r3, r1)     // Catch: java.lang.Throwable -> L4f
        L71:
            r6.setLayoutParams(r1)     // Catch: java.lang.Throwable -> L4f
            goto L7d
        L75:
            int r2 = r1.width     // Catch: java.lang.Throwable -> L4f
            if (r3 == r2) goto L7d
            r6.m49834a(r3, r1)     // Catch: java.lang.Throwable -> L4f
            goto L71
        L7d:
            com.huawei.hms.ads.uiengine.common.IProgressButton$ProgressButtonResetListener r6 = r6.f37280E     // Catch: java.lang.Throwable -> L4f
            if (r6 == 0) goto L88
            int r2 = r1.width     // Catch: java.lang.Throwable -> L4f
            int r1 = r1.height     // Catch: java.lang.Throwable -> L4f
            r6.onSizeReset(r2, r1)     // Catch: java.lang.Throwable -> L4f
        L88:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            return
        L8a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            return
        L8c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.ProgressButton.m49846a():void");
    }

    /* renamed from: a */
    public void m49847a(float f10, boolean z10) {
    }

    /* renamed from: a */
    public void mo49848a(int i10, int i11) {
        synchronized (this.f37289h) {
            try {
                Drawable drawable = this.f37288g;
                if (drawable != null) {
                    drawable.setBounds(0, 0, i10, i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private void m49834a(int i10, ViewGroup.LayoutParams layoutParams) {
        int i11 = this.f37300s;
        if (i10 <= i11 || i11 <= 0) {
            int i12 = this.f37301t;
            if (i10 < i12) {
                i10 = i12;
            }
        } else {
            CharSequence charSequenceM49832a = m49832a(this.f37284c, i10, i11);
            this.f37284c = charSequenceM49832a;
            this.f37283b.getTextBounds(charSequenceM49832a.toString(), 0, this.f37284c.length(), this.f37282a);
            i10 = this.f37300s;
        }
        layoutParams.width = i10;
    }

    /* renamed from: a */
    public void m49849a(int i10, boolean z10) {
        synchronized (this.f37289h) {
            if (i10 < 0) {
                i10 = 0;
            }
            try {
                int i11 = this.f37307z;
                if (i10 > i11) {
                    i10 = i11;
                }
                if (i10 != this.f37306y) {
                    this.f37306y = i10;
                    m49842b(i10, z10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private void m49835a(int i10, boolean z10, boolean z11) {
        synchronized (this.f37289h) {
            try {
                int i11 = this.f37307z;
                float f10 = i11 > 0 ? i10 / i11 : 0.0f;
                Drawable drawable = this.f37276A;
                if (drawable != null) {
                    drawable.setLevel((int) (10000.0f * f10));
                } else {
                    invalidate();
                }
                if (z11) {
                    m49847a(f10, z10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private void m49836a(Context context, AttributeSet attributeSet) {
        synchronized (this.f37289h) {
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.hiad_progress_button);
                TypedArray typedArrayObtainStyledAttributes2 = null;
                try {
                    typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.layout_height});
                    int dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -2);
                    this.f37302u = dimensionPixelSize;
                    AbstractC7185ho.m43818a(this.f37296o, "layoutHeight: %s", Integer.valueOf(dimensionPixelSize));
                } catch (Throwable th2) {
                    try {
                        AbstractC7185ho.m43824c(this.f37296o, "get layout height ex: %s", th2.getClass().getSimpleName());
                    } finally {
                        if (typedArrayObtainStyledAttributes2 != null) {
                            typedArrayObtainStyledAttributes2.recycle();
                        }
                    }
                }
                try {
                    try {
                        try {
                            this.f37298q = typedArrayObtainStyledAttributes.getBoolean(C6849R.styleable.hiad_progress_button_hiad_fixedWidth, false);
                            this.f37299r = typedArrayObtainStyledAttributes.getBoolean(C6849R.styleable.hiad_progress_button_hiad_resetWidth, true);
                            this.f37300s = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6849R.styleable.hiad_progress_button_hiad_maxWidth, 0);
                            this.f37301t = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6849R.styleable.hiad_progress_button_hiad_minWidth, 0);
                            float dimension = typedArrayObtainStyledAttributes.getDimension(C6849R.styleable.hiad_progress_button_hiad_textSize, 0.0f);
                            this.f37304w = dimension;
                            setOriginTextSize(Float.valueOf(dimension));
                            this.f37303v = typedArrayObtainStyledAttributes.getColor(C6849R.styleable.hiad_progress_button_hiad_textColor, -1);
                            this.f37285d = typedArrayObtainStyledAttributes.getString(C6849R.styleable.hiad_progress_button_hiad_fontFamily);
                            this.f37287f = typedArrayObtainStyledAttributes.getInt(C6849R.styleable.hiad_progress_button_hiad_styleIndex, -1);
                            this.f37286e = typedArrayObtainStyledAttributes.getInt(C6849R.styleable.hiad_progress_button_hiad_typefaceIndex, -1);
                        } catch (RuntimeException unused) {
                            AbstractC7185ho.m43823c(this.f37296o, "initButtonAttr RuntimeException");
                        }
                    } catch (Exception unused2) {
                        AbstractC7185ho.m43823c(this.f37296o, "initButtonAttr error");
                    }
                    if (this.f37302u <= 0) {
                        this.f37302u = ((int) this.f37304w) + getPaddingTop() + getPaddingBottom();
                    }
                } finally {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo49850a(Canvas canvas) {
        Rect rect;
        synchronized (this.f37289h) {
            try {
                CharSequence charSequence = this.f37284c;
                if (charSequence != null && charSequence.length() > 0) {
                    if (this.f37283b != null && (rect = this.f37282a) != null && rect.width() <= 0) {
                        this.f37283b.getTextBounds(this.f37284c.toString(), 0, this.f37284c.length(), this.f37282a);
                    }
                    String strIntern = this.f37284c.toString().intern();
                    int width = (getWidth() / 2) - this.f37282a.centerX();
                    if (this.f37293l && width < this.f37290i) {
                        width = getTextStart();
                    }
                    canvas.drawText((CharSequence) strIntern, 0, strIntern.length(), width, (getHeight() / 2) - this.f37282a.centerY(), this.f37283b);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private void m49837a(String str, int i10, int i11) {
        Typeface typefaceCreate;
        AbstractC7185ho.m43817a(this.f37296o, "setTypefaceFromAttrs");
        if (str != null) {
            typefaceCreate = Typeface.create(str, i11);
            if (typefaceCreate != null) {
                AbstractC7185ho.m43817a(this.f37296o, "setTypeface");
                setPaintTypeface(typefaceCreate);
                this.f37283b.setTypeface(typefaceCreate);
                return;
            }
        } else {
            typefaceCreate = null;
        }
        if (i10 == 1) {
            typefaceCreate = Typeface.SANS_SERIF;
        } else if (i10 == 2) {
            typefaceCreate = Typeface.SERIF;
        } else if (i10 == 3) {
            typefaceCreate = Typeface.MONOSPACE;
        }
        setPaintTypeface(typefaceCreate, i11);
    }

    /* renamed from: a */
    private boolean m49838a(Drawable drawable) {
        Drawable drawableFindDrawableByLayerId;
        if (drawable == null || !(drawable instanceof LayerDrawable) || (drawableFindDrawableByLayerId = ((LayerDrawable) drawable).findDrawableByLayerId(R.id.progress)) == null) {
            return false;
        }
        if ((drawableFindDrawableByLayerId instanceof PPSFlickerDrawable) || (drawableFindDrawableByLayerId instanceof AbstractC8146p)) {
            return this.f37279D;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m49839a(CharSequence charSequence, int i10, int i11, int i12) {
        float fM47565c = AbstractC7741ao.m47565c(getContext(), i10);
        AbstractC7185ho.m43818a(this.f37296o, "currentSize:%s", Float.valueOf(fM47565c));
        AbstractC7185ho.m43818a(this.f37296o, "buttonSize:%s", Integer.valueOf(i12));
        if (i12 < 0) {
            return true;
        }
        this.f37278C.setTextSize(fM47565c);
        this.f37278C.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.f37282a);
        int iWidth = this.f37282a.width() + i11;
        AbstractC7185ho.m43818a(this.f37296o, "textWidth:%s, btnWidth:%s", Integer.valueOf(iWidth), Integer.valueOf(i12));
        return iWidth <= i12;
    }
}
