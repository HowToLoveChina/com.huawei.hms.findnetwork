package com.google.android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C0523e0;
import androidx.appcompat.widget.C0524f;
import androidx.appcompat.widget.C0544s;
import androidx.core.content.ContextCompat;
import androidx.core.widget.C0669j;
import androidx.customview.view.AbsSavedState;
import androidx.transition.C0956q;
import androidx.transition.Fade;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1771b;
import com.google.android.material.internal.C1773d;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p211d.C8968a;
import p212d0.C8969a;
import p273f0.C9582a;
import p273f0.C9603h0;
import p273f0.C9620q;
import p276f3.C9649c;
import p304g0.C9832l;
import p356i3.C10427h;
import p356i3.C10432m;
import p416k3.C10981a;
import p666u2.C13110a;
import p757x.C13669a;
import p760x2.C13689a;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: I0 */
    public static final int f8800I0 = R$style.Widget_Design_TextInputLayout;

    /* renamed from: A */
    public CharSequence f8801A;

    /* renamed from: A0 */
    public int f8802A0;

    /* renamed from: B */
    public final TextView f8803B;

    /* renamed from: B0 */
    public boolean f8804B0;

    /* renamed from: C */
    public boolean f8805C;

    /* renamed from: C0 */
    public final C1771b f8806C0;

    /* renamed from: D */
    public CharSequence f8807D;

    /* renamed from: D0 */
    public boolean f8808D0;

    /* renamed from: E */
    public boolean f8809E;

    /* renamed from: E0 */
    public boolean f8810E0;

    /* renamed from: F */
    public C10427h f8811F;

    /* renamed from: F0 */
    public ValueAnimator f8812F0;

    /* renamed from: G */
    public C10427h f8813G;

    /* renamed from: G0 */
    public boolean f8814G0;

    /* renamed from: H */
    public C10427h f8815H;

    /* renamed from: H0 */
    public boolean f8816H0;

    /* renamed from: I */
    public C10432m f8817I;

    /* renamed from: J */
    public boolean f8818J;

    /* renamed from: K */
    public final int f8819K;

    /* renamed from: L */
    public int f8820L;

    /* renamed from: M */
    public int f8821M;

    /* renamed from: N */
    public int f8822N;

    /* renamed from: O */
    public int f8823O;

    /* renamed from: P */
    public int f8824P;

    /* renamed from: Q */
    public int f8825Q;

    /* renamed from: R */
    public int f8826R;

    /* renamed from: S */
    public final Rect f8827S;

    /* renamed from: T */
    public final Rect f8828T;

    /* renamed from: U */
    public final RectF f8829U;

    /* renamed from: V */
    public Typeface f8830V;

    /* renamed from: W */
    public Drawable f8831W;

    /* renamed from: a */
    public final FrameLayout f8832a;

    /* renamed from: a0 */
    public int f8833a0;

    /* renamed from: b */
    public final StartCompoundLayout f8834b;

    /* renamed from: b0 */
    public final LinkedHashSet<InterfaceC1860f> f8835b0;

    /* renamed from: c */
    public final LinearLayout f8836c;

    /* renamed from: c0 */
    public int f8837c0;

    /* renamed from: d */
    public final FrameLayout f8838d;

    /* renamed from: d0 */
    public final SparseArray<AbstractC1866e> f8839d0;

    /* renamed from: e */
    public EditText f8840e;

    /* renamed from: e0 */
    public final CheckableImageButton f8841e0;

    /* renamed from: f */
    public CharSequence f8842f;

    /* renamed from: f0 */
    public final LinkedHashSet<InterfaceC1861g> f8843f0;

    /* renamed from: g */
    public int f8844g;

    /* renamed from: g0 */
    public ColorStateList f8845g0;

    /* renamed from: h */
    public int f8846h;

    /* renamed from: h0 */
    public PorterDuff.Mode f8847h0;

    /* renamed from: i */
    public int f8848i;

    /* renamed from: i0 */
    public Drawable f8849i0;

    /* renamed from: j */
    public int f8850j;

    /* renamed from: j0 */
    public int f8851j0;

    /* renamed from: k */
    public final C1868g f8852k;

    /* renamed from: k0 */
    public Drawable f8853k0;

    /* renamed from: l */
    public boolean f8854l;

    /* renamed from: l0 */
    public View.OnLongClickListener f8855l0;

    /* renamed from: m */
    public int f8856m;

    /* renamed from: m0 */
    public View.OnLongClickListener f8857m0;

    /* renamed from: n */
    public boolean f8858n;

    /* renamed from: n0 */
    public final CheckableImageButton f8859n0;

    /* renamed from: o */
    public TextView f8860o;

    /* renamed from: o0 */
    public ColorStateList f8861o0;

    /* renamed from: p */
    public int f8862p;

    /* renamed from: p0 */
    public PorterDuff.Mode f8863p0;

    /* renamed from: q */
    public int f8864q;

    /* renamed from: q0 */
    public ColorStateList f8865q0;

    /* renamed from: r */
    public CharSequence f8866r;

    /* renamed from: r0 */
    public ColorStateList f8867r0;

    /* renamed from: s */
    public boolean f8868s;

    /* renamed from: s0 */
    public int f8869s0;

    /* renamed from: t */
    public TextView f8870t;

    /* renamed from: t0 */
    public int f8871t0;

    /* renamed from: u */
    public ColorStateList f8872u;

    /* renamed from: u0 */
    public int f8873u0;

    /* renamed from: v */
    public int f8874v;

    /* renamed from: v0 */
    public ColorStateList f8875v0;

    /* renamed from: w */
    public Fade f8876w;

    /* renamed from: w0 */
    public int f8877w0;

    /* renamed from: x */
    public Fade f8878x;

    /* renamed from: x0 */
    public int f8879x0;

    /* renamed from: y */
    public ColorStateList f8880y;

    /* renamed from: y0 */
    public int f8881y0;

    /* renamed from: z */
    public ColorStateList f8882z;

    /* renamed from: z0 */
    public int f8883z0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1854a();

        /* renamed from: d */
        public CharSequence f8884d;

        /* renamed from: e */
        public boolean f8885e;

        /* renamed from: f */
        public CharSequence f8886f;

        /* renamed from: g */
        public CharSequence f8887g;

        /* renamed from: h */
        public CharSequence f8888h;

        /* renamed from: com.google.android.material.textfield.TextInputLayout$SavedState$a */
        public class C1854a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f8884d) + " hint=" + ((Object) this.f8886f) + " helperText=" + ((Object) this.f8887g) + " placeholderText=" + ((Object) this.f8888h) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            TextUtils.writeToParcel(this.f8884d, parcel, i10);
            parcel.writeInt(this.f8885e ? 1 : 0);
            TextUtils.writeToParcel(this.f8886f, parcel, i10);
            TextUtils.writeToParcel(this.f8887g, parcel, i10);
            TextUtils.writeToParcel(this.f8888h, parcel, i10);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.f8884d = (CharSequence) creator.createFromParcel(parcel);
            this.f8885e = parcel.readInt() == 1;
            this.f8886f = (CharSequence) creator.createFromParcel(parcel);
            this.f8887g = (CharSequence) creator.createFromParcel(parcel);
            this.f8888h = (CharSequence) creator.createFromParcel(parcel);
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$a */
    public class C1855a implements TextWatcher {
        public C1855a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.m11257w0(!r0.f8816H0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f8854l) {
                textInputLayout.m11238m0(editable.length());
            }
            if (TextInputLayout.this.f8868s) {
                TextInputLayout.this.m11193A0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$b */
    public class RunnableC1856b implements Runnable {
        public RunnableC1856b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f8841e0.performClick();
            TextInputLayout.this.f8841e0.jumpDrawablesToCurrentState();
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$c */
    public class RunnableC1857c implements Runnable {
        public RunnableC1857c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f8840e.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$d */
    public class C1858d implements ValueAnimator.AnimatorUpdateListener {
        public C1858d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f8806C0.m10664u0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$e */
    public static class C1859e extends C9582a {

        /* renamed from: b */
        public final TextInputLayout f8893b;

        public C1859e(TextInputLayout textInputLayout) {
            this.f8893b = textInputLayout;
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            EditText editText = this.f8893b.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f8893b.getHint();
            CharSequence error = this.f8893b.getError();
            CharSequence placeholderText = this.f8893b.getPlaceholderText();
            int counterMaxLength = this.f8893b.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f8893b.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean z10 = !zIsEmpty;
            boolean z11 = true;
            boolean z12 = !TextUtils.isEmpty(hint);
            boolean z13 = !this.f8893b.m11210N();
            boolean z14 = !TextUtils.isEmpty(error);
            if (!z14 && TextUtils.isEmpty(counterOverflowDescription)) {
                z11 = false;
            }
            String string = z12 ? hint.toString() : "";
            this.f8893b.f8834b.m11177v(c9832l);
            if (z10) {
                c9832l.m61114w0(text);
            } else if (!TextUtils.isEmpty(string)) {
                c9832l.m61114w0(string);
                if (z13 && placeholderText != null) {
                    c9832l.m61114w0(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                c9832l.m61114w0(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                c9832l.m61084g0(string);
                c9832l.m61106s0(zIsEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            c9832l.m61087i0(counterMaxLength);
            if (z11) {
                if (!z14) {
                    error = counterOverflowDescription;
                }
                c9832l.m61076c0(error);
            }
            View viewM11366s = this.f8893b.f8852k.m11366s();
            if (viewM11366s != null) {
                c9832l.m61085h0(viewM11366s);
            }
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$f */
    public interface InterfaceC1860f {
        /* renamed from: a */
        void mo11267a(TextInputLayout textInputLayout);
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$g */
    public interface InterfaceC1861g {
        /* renamed from: a */
        void mo11268a(TextInputLayout textInputLayout, int i10);
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    /* renamed from: T */
    public static void m11181T(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                m11181T((ViewGroup) childAt, z10);
            }
        }
    }

    /* renamed from: a0 */
    public static void m11183a0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zM59859O = C9603h0.m59859O(checkableImageButton);
        boolean z10 = onLongClickListener != null;
        boolean z11 = zM59859O || z10;
        checkableImageButton.setFocusable(z11);
        checkableImageButton.setClickable(zM59859O);
        checkableImageButton.setPressable(zM59859O);
        checkableImageButton.setLongClickable(z10);
        C9603h0.m59833A0(checkableImageButton, z11 ? 1 : 2);
    }

    /* renamed from: b0 */
    public static void m11185b0(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        m11183a0(checkableImageButton, onLongClickListener);
    }

    /* renamed from: c0 */
    public static void m11187c0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        m11183a0(checkableImageButton, onLongClickListener);
    }

    private AbstractC1866e getEndIconDelegate() {
        AbstractC1866e abstractC1866e = this.f8839d0.get(this.f8837c0);
        return abstractC1866e != null ? abstractC1866e : this.f8839d0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.f8859n0.getVisibility() == 0) {
            return this.f8859n0;
        }
        if (m11205I() && m11207K()) {
            return this.f8841e0;
        }
        return null;
    }

    /* renamed from: n0 */
    public static void m11191n0(Context context, TextView textView, int i10, int i11, boolean z10) {
        textView.setContentDescription(context.getString(z10 ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    private void setEditText(EditText editText) {
        if (this.f8840e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.f8837c0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f8840e = editText;
        int i10 = this.f8844g;
        if (i10 != -1) {
            setMinEms(i10);
        } else {
            setMinWidth(this.f8848i);
        }
        int i11 = this.f8846h;
        if (i11 != -1) {
            setMaxEms(i11);
        } else {
            setMaxWidth(this.f8850j);
        }
        m11213Q();
        setTextInputAccessibilityDelegate(new C1859e(this));
        this.f8806C0.m10607H0(this.f8840e.getTypeface());
        this.f8806C0.m10658r0(this.f8840e.getTextSize());
        this.f8806C0.m10648m0(this.f8840e.getLetterSpacing());
        int gravity = this.f8840e.getGravity();
        this.f8806C0.m10636g0((gravity & (-113)) | 48);
        this.f8806C0.m10656q0(gravity);
        this.f8840e.addTextChangedListener(new C1855a());
        if (this.f8865q0 == null) {
            this.f8865q0 = this.f8840e.getHintTextColors();
        }
        if (this.f8805C) {
            if (TextUtils.isEmpty(this.f8807D)) {
                CharSequence hint = this.f8840e.getHint();
                this.f8842f = hint;
                setHint(hint);
                this.f8840e.setHint((CharSequence) null);
            }
            this.f8809E = true;
        }
        if (this.f8860o != null) {
            m11238m0(this.f8840e.getText().length());
        }
        m11247r0();
        this.f8852k.m11353f();
        this.f8834b.bringToFront();
        this.f8836c.bringToFront();
        this.f8838d.bringToFront();
        this.f8859n0.bringToFront();
        m11194B();
        m11197C0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        m11259x0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f8807D)) {
            return;
        }
        this.f8807D = charSequence;
        this.f8806C0.m10603F0(charSequence);
        if (this.f8804B0) {
            return;
        }
        m11214R();
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.f8868s == z10) {
            return;
        }
        if (z10) {
            m11229i();
        } else {
            m11219X();
            this.f8870t = null;
        }
        this.f8868s = z10;
    }

    /* renamed from: A */
    public final boolean m11192A() {
        return this.f8805C && !TextUtils.isEmpty(this.f8807D) && (this.f8811F instanceof C1864c);
    }

    /* renamed from: A0 */
    public final void m11193A0(int i10) {
        if (i10 != 0 || this.f8804B0) {
            m11206J();
        } else {
            m11228h0();
        }
    }

    /* renamed from: B */
    public final void m11194B() {
        Iterator<InterfaceC1860f> it = this.f8835b0.iterator();
        while (it.hasNext()) {
            it.next().mo11267a(this);
        }
    }

    /* renamed from: B0 */
    public final void m11195B0(boolean z10, boolean z11) {
        int defaultColor = this.f8875v0.getDefaultColor();
        int colorForState = this.f8875v0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f8875v0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z10) {
            this.f8825Q = colorForState2;
        } else if (z11) {
            this.f8825Q = colorForState;
        } else {
            this.f8825Q = defaultColor;
        }
    }

    /* renamed from: C */
    public final void m11196C(int i10) {
        Iterator<InterfaceC1861g> it = this.f8843f0.iterator();
        while (it.hasNext()) {
            it.next().mo11268a(this, i10);
        }
    }

    /* renamed from: C0 */
    public final void m11197C0() {
        if (this.f8840e == null) {
            return;
        }
        C9603h0.m59839D0(this.f8803B, getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.f8840e.getPaddingTop(), (m11207K() || m11208L()) ? 0 : C9603h0.m59840E(this.f8840e), this.f8840e.getPaddingBottom());
    }

    /* renamed from: D */
    public final void m11198D(Canvas canvas) {
        C10427h c10427h;
        if (this.f8815H == null || (c10427h = this.f8813G) == null) {
            return;
        }
        c10427h.draw(canvas);
        if (this.f8840e.isFocused()) {
            Rect bounds = this.f8815H.getBounds();
            Rect bounds2 = this.f8813G.getBounds();
            float fM10598D = this.f8806C0.m10598D();
            int iCenterX = bounds2.centerX();
            bounds.left = C13110a.m78886c(iCenterX, bounds2.left, fM10598D);
            bounds.right = C13110a.m78886c(iCenterX, bounds2.right, fM10598D);
            this.f8815H.draw(canvas);
        }
    }

    /* renamed from: D0 */
    public final void m11199D0() {
        int visibility = this.f8803B.getVisibility();
        int i10 = (this.f8801A == null || m11210N()) ? 8 : 0;
        if (visibility != i10) {
            getEndIconDelegate().mo11274c(i10 == 0);
        }
        m11251t0();
        this.f8803B.setVisibility(i10);
        m11245q0();
    }

    /* renamed from: E */
    public final void m11200E(Canvas canvas) {
        if (this.f8805C) {
            this.f8806C0.m10645l(canvas);
        }
    }

    /* renamed from: E0 */
    public void m11201E0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.f8811F == null || this.f8820L == 0) {
            return;
        }
        boolean z10 = false;
        boolean z11 = isFocused() || ((editText2 = this.f8840e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f8840e) != null && editText.isHovered())) {
            z10 = true;
        }
        if (!isEnabled()) {
            this.f8825Q = this.f8802A0;
        } else if (this.f8852k.m11359l()) {
            if (this.f8875v0 != null) {
                m11195B0(z11, z10);
            } else {
                this.f8825Q = this.f8852k.m11363p();
            }
        } else if (!this.f8858n || (textView = this.f8860o) == null) {
            if (z11) {
                this.f8825Q = this.f8873u0;
            } else if (z10) {
                this.f8825Q = this.f8871t0;
            } else {
                this.f8825Q = this.f8869s0;
            }
        } else if (this.f8875v0 != null) {
            m11195B0(z11, z10);
        } else {
            this.f8825Q = textView.getCurrentTextColor();
        }
        m11253u0();
        m11217V();
        m11218W();
        m11216U();
        if (getEndIconDelegate().mo11322d()) {
            m11230i0(this.f8852k.m11359l());
        }
        if (this.f8820L == 2) {
            int i10 = this.f8822N;
            if (z11 && isEnabled()) {
                this.f8822N = this.f8824P;
            } else {
                this.f8822N = this.f8823O;
            }
            if (this.f8822N != i10) {
                m11215S();
            }
        }
        if (this.f8820L == 1) {
            if (!isEnabled()) {
                this.f8826R = this.f8879x0;
            } else if (z10 && !z11) {
                this.f8826R = this.f8883z0;
            } else if (z11) {
                this.f8826R = this.f8881y0;
            } else {
                this.f8826R = this.f8877w0;
            }
        }
        m11235l();
    }

    /* renamed from: F */
    public final void m11202F(boolean z10) {
        ValueAnimator valueAnimator = this.f8812F0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f8812F0.cancel();
        }
        if (z10 && this.f8810E0) {
            m11233k(0.0f);
        } else {
            this.f8806C0.m10664u0(0.0f);
        }
        if (m11192A() && ((C1864c) this.f8811F).m11280q0()) {
            m11258x();
        }
        this.f8804B0 = true;
        m11206J();
        this.f8834b.m11164i(true);
        m11199D0();
    }

    /* renamed from: G */
    public final int m11203G(int i10, boolean z10) {
        int compoundPaddingLeft = i10 + this.f8840e.getCompoundPaddingLeft();
        return (getPrefixText() == null || z10) ? compoundPaddingLeft : (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    /* renamed from: H */
    public final int m11204H(int i10, boolean z10) {
        int compoundPaddingRight = i10 - this.f8840e.getCompoundPaddingRight();
        return (getPrefixText() == null || !z10) ? compoundPaddingRight : compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    }

    /* renamed from: I */
    public final boolean m11205I() {
        return this.f8837c0 != 0;
    }

    /* renamed from: J */
    public final void m11206J() {
        TextView textView = this.f8870t;
        if (textView == null || !this.f8868s) {
            return;
        }
        textView.setText((CharSequence) null);
        C0956q.m5832a(this.f8832a, this.f8878x);
        this.f8870t.setVisibility(4);
    }

    /* renamed from: K */
    public boolean m11207K() {
        return this.f8838d.getVisibility() == 0 && this.f8841e0.getVisibility() == 0;
    }

    /* renamed from: L */
    public final boolean m11208L() {
        return this.f8859n0.getVisibility() == 0;
    }

    /* renamed from: M */
    public boolean m11209M() {
        return this.f8852k.m11335A();
    }

    /* renamed from: N */
    public final boolean m11210N() {
        return this.f8804B0;
    }

    /* renamed from: O */
    public boolean m11211O() {
        return this.f8809E;
    }

    /* renamed from: P */
    public final boolean m11212P() {
        return this.f8820L == 1 && this.f8840e.getMinLines() <= 1;
    }

    /* renamed from: Q */
    public final void m11213Q() {
        m11240o();
        m11221Z();
        m11201E0();
        m11232j0();
        m11231j();
        if (this.f8820L != 0) {
            m11255v0();
        }
    }

    /* renamed from: R */
    public final void m11214R() {
        if (m11192A()) {
            RectF rectF = this.f8829U;
            this.f8806C0.m10651o(rectF, this.f8840e.getWidth(), this.f8840e.getGravity());
            m11239n(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f8822N);
            ((C1864c) this.f8811F).m11284t0(rectF);
        }
    }

    /* renamed from: S */
    public final void m11215S() {
        if (!m11192A() || this.f8804B0) {
            return;
        }
        m11258x();
        m11214R();
    }

    /* renamed from: U */
    public void m11216U() {
        C1867f.m11327c(this, this.f8841e0, this.f8845g0);
    }

    /* renamed from: V */
    public void m11217V() {
        C1867f.m11327c(this, this.f8859n0, this.f8861o0);
    }

    /* renamed from: W */
    public void m11218W() {
        this.f8834b.m11165j();
    }

    /* renamed from: X */
    public final void m11219X() {
        TextView textView = this.f8870t;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* renamed from: Y */
    public void m11220Y(float f10, float f11, float f12, float f13) {
        boolean zM10788i = C1788s.m10788i(this);
        this.f8818J = zM10788i;
        float f14 = zM10788i ? f11 : f10;
        if (!zM10788i) {
            f10 = f11;
        }
        float f15 = zM10788i ? f13 : f12;
        if (!zM10788i) {
            f12 = f13;
        }
        C10427h c10427h = this.f8811F;
        if (c10427h != null && c10427h.m63985J() == f14 && this.f8811F.m63986K() == f10 && this.f8811F.m64028s() == f15 && this.f8811F.m64029t() == f12) {
            return;
        }
        this.f8817I = this.f8817I.m64066v().m64087E(f14).m64091I(f10).m64101v(f15).m64105z(f12).m64093m();
        m11235l();
    }

    /* renamed from: Z */
    public final void m11221Z() {
        if (m11226g0()) {
            C9603h0.m59910t0(this.f8840e, this.f8811F);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i10, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f8832a.addView(view, layoutParams2);
        this.f8832a.setLayoutParams(layoutParams);
        m11255v0();
        setEditText((EditText) view);
    }

    /* renamed from: d0 */
    public void m11222d0(TextView textView, int i10) {
        try {
            C0669j.m4080n(textView, i10);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        C0669j.m4080n(textView, R$style.TextAppearance_AppCompat_Caption);
        textView.setTextColor(ContextCompat.getColor(getContext(), R$color.design_error));
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i10) {
        EditText editText = this.f8840e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.f8842f != null) {
            boolean z10 = this.f8809E;
            this.f8809E = false;
            CharSequence hint = editText.getHint();
            this.f8840e.setHint(this.f8842f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
                return;
            } finally {
                this.f8840e.setHint(hint);
                this.f8809E = z10;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i10);
        onProvideAutofillVirtualStructure(viewStructure, i10);
        viewStructure.setChildCount(this.f8832a.getChildCount());
        for (int i11 = 0; i11 < this.f8832a.getChildCount(); i11++) {
            View childAt = this.f8832a.getChildAt(i11);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i11);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i10);
            if (childAt == this.f8840e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f8816H0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f8816H0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        m11200E(canvas);
        m11198D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f8814G0) {
            return;
        }
        this.f8814G0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        C1771b c1771b = this.f8806C0;
        boolean zM10601E0 = c1771b != null ? c1771b.m10601E0(drawableState) : false;
        if (this.f8840e != null) {
            m11257w0(C9603h0.m59864T(this) && isEnabled());
        }
        m11247r0();
        m11201E0();
        if (zM10601E0) {
            invalidate();
        }
        this.f8814G0 = false;
    }

    /* renamed from: e0 */
    public final boolean m11223e0() {
        return (this.f8859n0.getVisibility() == 0 || ((m11205I() && m11207K()) || this.f8801A != null)) && this.f8836c.getMeasuredWidth() > 0;
    }

    /* renamed from: f0 */
    public final boolean m11224f0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f8834b.getMeasuredWidth() > 0;
    }

    /* renamed from: g */
    public void m11225g(InterfaceC1860f interfaceC1860f) {
        this.f8835b0.add(interfaceC1860f);
        if (this.f8840e != null) {
            interfaceC1860f.mo11267a(this);
        }
    }

    /* renamed from: g0 */
    public final boolean m11226g0() {
        EditText editText = this.f8840e;
        return (editText == null || this.f8811F == null || editText.getBackground() != null || this.f8820L == 0) ? false : true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f8840e;
        return editText != null ? editText.getBaseline() + getPaddingTop() + m11252u() : super.getBaseline();
    }

    public C10427h getBoxBackground() {
        int i10 = this.f8820L;
        if (i10 == 1 || i10 == 2) {
            return this.f8811F;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f8826R;
    }

    public int getBoxBackgroundMode() {
        return this.f8820L;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f8821M;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return C1788s.m10788i(this) ? this.f8817I.m64055j().mo63966a(this.f8829U) : this.f8817I.m64057l().mo63966a(this.f8829U);
    }

    public float getBoxCornerRadiusBottomStart() {
        return C1788s.m10788i(this) ? this.f8817I.m64057l().mo63966a(this.f8829U) : this.f8817I.m64055j().mo63966a(this.f8829U);
    }

    public float getBoxCornerRadiusTopEnd() {
        return C1788s.m10788i(this) ? this.f8817I.m64062r().mo63966a(this.f8829U) : this.f8817I.m64064t().mo63966a(this.f8829U);
    }

    public float getBoxCornerRadiusTopStart() {
        return C1788s.m10788i(this) ? this.f8817I.m64064t().mo63966a(this.f8829U) : this.f8817I.m64062r().mo63966a(this.f8829U);
    }

    public int getBoxStrokeColor() {
        return this.f8873u0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f8875v0;
    }

    public int getBoxStrokeWidth() {
        return this.f8823O;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f8824P;
    }

    public int getCounterMaxLength() {
        return this.f8856m;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f8854l && this.f8858n && (textView = this.f8860o) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f8880y;
    }

    public ColorStateList getCounterTextColor() {
        return this.f8880y;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f8865q0;
    }

    public EditText getEditText() {
        return this.f8840e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f8841e0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f8841e0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f8837c0;
    }

    public CheckableImageButton getEndIconView() {
        return this.f8841e0;
    }

    public CharSequence getError() {
        if (this.f8852k.m11373z()) {
            return this.f8852k.m11362o();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f8852k.m11361n();
    }

    public int getErrorCurrentTextColors() {
        return this.f8852k.m11363p();
    }

    public Drawable getErrorIconDrawable() {
        return this.f8859n0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.f8852k.m11363p();
    }

    public CharSequence getHelperText() {
        if (this.f8852k.m11335A()) {
            return this.f8852k.m11365r();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f8852k.m11367t();
    }

    public CharSequence getHint() {
        if (this.f8805C) {
            return this.f8807D;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f8806C0.m10657r();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.f8806C0.m10665v();
    }

    public ColorStateList getHintTextColor() {
        return this.f8867r0;
    }

    public int getMaxEms() {
        return this.f8846h;
    }

    public int getMaxWidth() {
        return this.f8850j;
    }

    public int getMinEms() {
        return this.f8844g;
    }

    public int getMinWidth() {
        return this.f8848i;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f8841e0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f8841e0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f8868s) {
            return this.f8866r;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f8874v;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f8872u;
    }

    public CharSequence getPrefixText() {
        return this.f8834b.m11156a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f8834b.m11157b();
    }

    public TextView getPrefixTextView() {
        return this.f8834b.m11158c();
    }

    public CharSequence getStartIconContentDescription() {
        return this.f8834b.m11159d();
    }

    public Drawable getStartIconDrawable() {
        return this.f8834b.m11160e();
    }

    public CharSequence getSuffixText() {
        return this.f8801A;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f8803B.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f8803B;
    }

    public Typeface getTypeface() {
        return this.f8830V;
    }

    /* renamed from: h */
    public void m11227h(InterfaceC1861g interfaceC1861g) {
        this.f8843f0.add(interfaceC1861g);
    }

    /* renamed from: h0 */
    public final void m11228h0() {
        if (this.f8870t == null || !this.f8868s || TextUtils.isEmpty(this.f8866r)) {
            return;
        }
        this.f8870t.setText(this.f8866r);
        C0956q.m5832a(this.f8832a, this.f8876w);
        this.f8870t.setVisibility(0);
        this.f8870t.bringToFront();
        announceForAccessibility(this.f8866r);
    }

    /* renamed from: i */
    public final void m11229i() {
        TextView textView = this.f8870t;
        if (textView != null) {
            this.f8832a.addView(textView);
            this.f8870t.setVisibility(0);
        }
    }

    /* renamed from: i0 */
    public final void m11230i0(boolean z10) {
        if (!z10 || getEndIconDrawable() == null) {
            C1867f.m11325a(this, this.f8841e0, this.f8845g0, this.f8847h0);
            return;
        }
        Drawable drawableMutate = C13669a.m82231l(getEndIconDrawable()).mutate();
        C13669a.m82227h(drawableMutate, this.f8852k.m11363p());
        this.f8841e0.setImageDrawable(drawableMutate);
    }

    /* renamed from: j */
    public final void m11231j() {
        if (this.f8840e == null || this.f8820L != 1) {
            return;
        }
        if (C9649c.m60274j(getContext())) {
            EditText editText = this.f8840e;
            C9603h0.m59839D0(editText, C9603h0.m59842F(editText), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top), C9603h0.m59840E(this.f8840e), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (C9649c.m60273i(getContext())) {
            EditText editText2 = this.f8840e;
            C9603h0.m59839D0(editText2, C9603h0.m59842F(editText2), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top), C9603h0.m59840E(this.f8840e), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    /* renamed from: j0 */
    public final void m11232j0() {
        if (this.f8820L == 1) {
            if (C9649c.m60274j(getContext())) {
                this.f8821M = getResources().getDimensionPixelSize(R$dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (C9649c.m60273i(getContext())) {
                this.f8821M = getResources().getDimensionPixelSize(R$dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    /* renamed from: k */
    public void m11233k(float f10) {
        if (this.f8806C0.m10598D() == f10) {
            return;
        }
        if (this.f8812F0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f8812F0 = valueAnimator;
            valueAnimator.setInterpolator(C13110a.f59598b);
            this.f8812F0.setDuration(167L);
            this.f8812F0.addUpdateListener(new C1858d());
        }
        this.f8812F0.setFloatValues(this.f8806C0.m10598D(), f10);
        this.f8812F0.start();
    }

    /* renamed from: k0 */
    public final void m11234k0(Rect rect) {
        C10427h c10427h = this.f8813G;
        if (c10427h != null) {
            int i10 = rect.bottom;
            c10427h.setBounds(rect.left, i10 - this.f8823O, rect.right, i10);
        }
        C10427h c10427h2 = this.f8815H;
        if (c10427h2 != null) {
            int i11 = rect.bottom;
            c10427h2.setBounds(rect.left, i11 - this.f8824P, rect.right, i11);
        }
    }

    /* renamed from: l */
    public final void m11235l() {
        C10427h c10427h = this.f8811F;
        if (c10427h == null) {
            return;
        }
        C10432m c10432mM63980E = c10427h.m63980E();
        C10432m c10432m = this.f8817I;
        if (c10432mM63980E != c10432m) {
            this.f8811F.setShapeAppearanceModel(c10432m);
            m11243p0();
        }
        if (m11254v()) {
            this.f8811F.m64015j0(this.f8822N, this.f8825Q);
        }
        int iM11242p = m11242p();
        this.f8826R = iM11242p;
        this.f8811F.m64002b0(ColorStateList.valueOf(iM11242p));
        if (this.f8837c0 == 3) {
            this.f8840e.getBackground().invalidateSelf();
        }
        m11237m();
        invalidate();
    }

    /* renamed from: l0 */
    public final void m11236l0() {
        if (this.f8860o != null) {
            EditText editText = this.f8840e;
            m11238m0(editText == null ? 0 : editText.getText().length());
        }
    }

    /* renamed from: m */
    public final void m11237m() {
        if (this.f8813G == null || this.f8815H == null) {
            return;
        }
        if (m11256w()) {
            this.f8813G.m64002b0(this.f8840e.isFocused() ? ColorStateList.valueOf(this.f8869s0) : ColorStateList.valueOf(this.f8825Q));
            this.f8815H.m64002b0(ColorStateList.valueOf(this.f8825Q));
        }
        invalidate();
    }

    /* renamed from: m0 */
    public void m11238m0(int i10) {
        boolean z10 = this.f8858n;
        int i11 = this.f8856m;
        if (i11 == -1) {
            this.f8860o.setText(String.valueOf(i10));
            this.f8860o.setContentDescription(null);
            this.f8858n = false;
        } else {
            this.f8858n = i10 > i11;
            m11191n0(getContext(), this.f8860o, i10, this.f8856m, this.f8858n);
            if (z10 != this.f8858n) {
                m11241o0();
            }
            this.f8860o.setText(C8969a.m56746c().m56753j(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(i10), Integer.valueOf(this.f8856m))));
        }
        if (this.f8840e == null || z10 == this.f8858n) {
            return;
        }
        m11257w0(false);
        m11201E0();
        m11247r0();
    }

    /* renamed from: n */
    public final void m11239n(RectF rectF) {
        float f10 = rectF.left;
        int i10 = this.f8819K;
        rectF.left = f10 - i10;
        rectF.right += i10;
    }

    /* renamed from: o */
    public final void m11240o() {
        int i10 = this.f8820L;
        if (i10 == 0) {
            this.f8811F = null;
            this.f8813G = null;
            this.f8815H = null;
            return;
        }
        if (i10 == 1) {
            this.f8811F = new C10427h(this.f8817I);
            this.f8813G = new C10427h();
            this.f8815H = new C10427h();
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException(this.f8820L + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.f8805C || (this.f8811F instanceof C1864c)) {
                this.f8811F = new C10427h(this.f8817I);
            } else {
                this.f8811F = new C1864c(this.f8817I);
            }
            this.f8813G = null;
            this.f8815H = null;
        }
    }

    /* renamed from: o0 */
    public final void m11241o0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f8860o;
        if (textView != null) {
            m11222d0(textView, this.f8858n ? this.f8862p : this.f8864q);
            if (!this.f8858n && (colorStateList2 = this.f8880y) != null) {
                this.f8860o.setTextColor(colorStateList2);
            }
            if (!this.f8858n || (colorStateList = this.f8882z) == null) {
                return;
            }
            this.f8860o.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f8806C0.m10620V(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f8840e;
        if (editText != null) {
            Rect rect = this.f8827S;
            C1773d.m10677a(this, editText, rect);
            m11234k0(rect);
            if (this.f8805C) {
                this.f8806C0.m10658r0(this.f8840e.getTextSize());
                int gravity = this.f8840e.getGravity();
                this.f8806C0.m10636g0((gravity & (-113)) | 48);
                this.f8806C0.m10656q0(gravity);
                this.f8806C0.m10628c0(m11244q(rect));
                this.f8806C0.m10646l0(m11250t(rect));
                this.f8806C0.m10623Y();
                if (!m11192A() || this.f8804B0) {
                    return;
                }
                m11214R();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        boolean zM11249s0 = m11249s0();
        boolean zM11245q0 = m11245q0();
        if (zM11249s0 || zM11245q0) {
            this.f8840e.post(new RunnableC1857c());
        }
        m11261y0();
        m11197C0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f8884d);
        if (savedState.f8885e) {
            this.f8841e0.post(new RunnableC1856b());
        }
        setHint(savedState.f8886f);
        setHelperText(savedState.f8887g);
        setPlaceholderText(savedState.f8888h);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = false;
        boolean z11 = i10 == 1;
        boolean z12 = this.f8818J;
        if (z11 != z12) {
            if (z11 && !z12) {
                z10 = true;
            }
            float fMo63966a = this.f8817I.m64062r().mo63966a(this.f8829U);
            float fMo63966a2 = this.f8817I.m64064t().mo63966a(this.f8829U);
            float fMo63966a3 = this.f8817I.m64055j().mo63966a(this.f8829U);
            float fMo63966a4 = this.f8817I.m64057l().mo63966a(this.f8829U);
            float f10 = z10 ? fMo63966a : fMo63966a2;
            if (z10) {
                fMo63966a = fMo63966a2;
            }
            float f11 = z10 ? fMo63966a3 : fMo63966a4;
            if (z10) {
                fMo63966a3 = fMo63966a4;
            }
            m11220Y(f10, fMo63966a, f11, fMo63966a3);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f8852k.m11359l()) {
            savedState.f8884d = getError();
        }
        savedState.f8885e = m11205I() && this.f8841e0.isChecked();
        savedState.f8886f = getHint();
        savedState.f8887g = getHelperText();
        savedState.f8888h = getPlaceholderText();
        return savedState;
    }

    /* renamed from: p */
    public final int m11242p() {
        return this.f8820L == 1 ? C13689a.m82293g(C13689a.m82291e(this, R$attr.colorSurface, 0), this.f8826R) : this.f8826R;
    }

    /* renamed from: p0 */
    public final void m11243p0() {
        if (this.f8837c0 == 3 && this.f8820L == 2) {
            ((C1865d) this.f8839d0.get(3)).m11320O((AutoCompleteTextView) this.f8840e);
        }
    }

    /* renamed from: q */
    public final Rect m11244q(Rect rect) {
        if (this.f8840e == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f8828T;
        boolean zM10788i = C1788s.m10788i(this);
        rect2.bottom = rect.bottom;
        int i10 = this.f8820L;
        if (i10 == 1) {
            rect2.left = m11203G(rect.left, zM10788i);
            rect2.top = rect.top + this.f8821M;
            rect2.right = m11204H(rect.right, zM10788i);
            return rect2;
        }
        if (i10 != 2) {
            rect2.left = m11203G(rect.left, zM10788i);
            rect2.top = getPaddingTop();
            rect2.right = m11204H(rect.right, zM10788i);
            return rect2;
        }
        rect2.left = rect.left + this.f8840e.getPaddingLeft();
        rect2.top = rect.top - m11252u();
        rect2.right = rect.right - this.f8840e.getPaddingRight();
        return rect2;
    }

    /* renamed from: q0 */
    public boolean m11245q0() {
        boolean z10;
        if (this.f8840e == null) {
            return false;
        }
        boolean z11 = true;
        if (m11224f0()) {
            int measuredWidth = this.f8834b.getMeasuredWidth() - this.f8840e.getPaddingLeft();
            if (this.f8831W == null || this.f8833a0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f8831W = colorDrawable;
                this.f8833a0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrM4067a = C0669j.m4067a(this.f8840e);
            Drawable drawable = drawableArrM4067a[0];
            Drawable drawable2 = this.f8831W;
            if (drawable != drawable2) {
                C0669j.m4075i(this.f8840e, drawable2, drawableArrM4067a[1], drawableArrM4067a[2], drawableArrM4067a[3]);
                z10 = true;
            }
            z10 = false;
        } else {
            if (this.f8831W != null) {
                Drawable[] drawableArrM4067a2 = C0669j.m4067a(this.f8840e);
                C0669j.m4075i(this.f8840e, null, drawableArrM4067a2[1], drawableArrM4067a2[2], drawableArrM4067a2[3]);
                this.f8831W = null;
                z10 = true;
            }
            z10 = false;
        }
        if (m11223e0()) {
            int measuredWidth2 = this.f8803B.getMeasuredWidth() - this.f8840e.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + C9620q.m60124b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] drawableArrM4067a3 = C0669j.m4067a(this.f8840e);
            Drawable drawable3 = this.f8849i0;
            if (drawable3 == null || this.f8851j0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f8849i0 = colorDrawable2;
                    this.f8851j0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = drawableArrM4067a3[2];
                Drawable drawable5 = this.f8849i0;
                if (drawable4 != drawable5) {
                    this.f8853k0 = drawable4;
                    C0669j.m4075i(this.f8840e, drawableArrM4067a3[0], drawableArrM4067a3[1], drawable5, drawableArrM4067a3[3]);
                } else {
                    z11 = z10;
                }
            } else {
                this.f8851j0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                C0669j.m4075i(this.f8840e, drawableArrM4067a3[0], drawableArrM4067a3[1], this.f8849i0, drawableArrM4067a3[3]);
            }
        } else {
            if (this.f8849i0 == null) {
                return z10;
            }
            Drawable[] drawableArrM4067a4 = C0669j.m4067a(this.f8840e);
            if (drawableArrM4067a4[2] == this.f8849i0) {
                C0669j.m4075i(this.f8840e, drawableArrM4067a4[0], drawableArrM4067a4[1], this.f8853k0, drawableArrM4067a4[3]);
            } else {
                z11 = z10;
            }
            this.f8849i0 = null;
        }
        return z11;
    }

    /* renamed from: r */
    public final int m11246r(Rect rect, Rect rect2, float f10) {
        return m11212P() ? (int) (rect2.top + f10) : rect.bottom - this.f8840e.getCompoundPaddingBottom();
    }

    /* renamed from: r0 */
    public void m11247r0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f8840e;
        if (editText == null || this.f8820L != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (C0544s.m3140a(background)) {
            background = background.mutate();
        }
        if (this.f8852k.m11359l()) {
            background.setColorFilter(C0524f.m2969e(this.f8852k.m11363p(), PorterDuff.Mode.SRC_IN));
        } else if (this.f8858n && (textView = this.f8860o) != null) {
            background.setColorFilter(C0524f.m2969e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            C13669a.m82220a(background);
            this.f8840e.refreshDrawableState();
        }
    }

    /* renamed from: s */
    public final int m11248s(Rect rect, float f10) {
        return m11212P() ? (int) (rect.centerY() - (f10 / 2.0f)) : rect.top + this.f8840e.getCompoundPaddingTop();
    }

    /* renamed from: s0 */
    public final boolean m11249s0() {
        int iMax;
        if (this.f8840e == null || this.f8840e.getMeasuredHeight() >= (iMax = Math.max(this.f8836c.getMeasuredHeight(), this.f8834b.getMeasuredHeight()))) {
            return false;
        }
        this.f8840e.setMinimumHeight(iMax);
        return true;
    }

    public void setBoxBackgroundColor(int i10) {
        if (this.f8826R != i10) {
            this.f8826R = i10;
            this.f8877w0 = i10;
            this.f8881y0 = i10;
            this.f8883z0 = i10;
            m11235l();
        }
    }

    public void setBoxBackgroundColorResource(int i10) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i10));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f8877w0 = defaultColor;
        this.f8826R = defaultColor;
        this.f8879x0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f8881y0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f8883z0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        m11235l();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 == this.f8820L) {
            return;
        }
        this.f8820L = i10;
        if (this.f8840e != null) {
            m11213Q();
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.f8821M = i10;
    }

    public void setBoxStrokeColor(int i10) {
        if (this.f8873u0 != i10) {
            this.f8873u0 = i10;
            m11201E0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f8869s0 = colorStateList.getDefaultColor();
            this.f8802A0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f8871t0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f8873u0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f8873u0 != colorStateList.getDefaultColor()) {
            this.f8873u0 = colorStateList.getDefaultColor();
        }
        m11201E0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f8875v0 != colorStateList) {
            this.f8875v0 = colorStateList;
            m11201E0();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.f8823O = i10;
        m11201E0();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.f8824P = i10;
        m11201E0();
    }

    public void setBoxStrokeWidthFocusedResource(int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f8854l != z10) {
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f8860o = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.f8830V;
                if (typeface != null) {
                    this.f8860o.setTypeface(typeface);
                }
                this.f8860o.setMaxLines(1);
                this.f8852k.m11352e(this.f8860o, 2);
                C9620q.m60126d((ViewGroup.MarginLayoutParams) this.f8860o.getLayoutParams(), getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                m11241o0();
                m11236l0();
            } else {
                this.f8852k.m11336B(this.f8860o, 2);
                this.f8860o = null;
            }
            this.f8854l = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        if (this.f8856m != i10) {
            if (i10 > 0) {
                this.f8856m = i10;
            } else {
                this.f8856m = -1;
            }
            if (this.f8854l) {
                m11236l0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.f8862p != i10) {
            this.f8862p = i10;
            m11241o0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f8882z != colorStateList) {
            this.f8882z = colorStateList;
            m11241o0();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.f8864q != i10) {
            this.f8864q = i10;
            m11241o0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f8880y != colorStateList) {
            this.f8880y = colorStateList;
            m11241o0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f8865q0 = colorStateList;
        this.f8867r0 = colorStateList;
        if (this.f8840e != null) {
            m11257w0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        m11181T(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f8841e0.setActivated(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f8841e0.setCheckable(z10);
    }

    public void setEndIconContentDescription(int i10) {
        setEndIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setEndIconDrawable(int i10) {
        setEndIconDrawable(i10 != 0 ? C8968a.m56743b(getContext(), i10) : null);
    }

    public void setEndIconMode(int i10) {
        int i11 = this.f8837c0;
        if (i11 == i10) {
            return;
        }
        this.f8837c0 = i10;
        m11196C(i11);
        setEndIconVisible(i10 != 0);
        if (getEndIconDelegate().mo11321b(this.f8820L)) {
            getEndIconDelegate().mo11273a();
            C1867f.m11325a(this, this.f8841e0, this.f8845g0, this.f8847h0);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.f8820L + " is not supported by the end icon mode " + i10);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        m11185b0(this.f8841e0, onClickListener, this.f8855l0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f8855l0 = onLongClickListener;
        m11187c0(this.f8841e0, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.f8845g0 != colorStateList) {
            this.f8845g0 = colorStateList;
            C1867f.m11325a(this, this.f8841e0, colorStateList, this.f8847h0);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.f8847h0 != mode) {
            this.f8847h0 = mode;
            C1867f.m11325a(this, this.f8841e0, this.f8845g0, mode);
        }
    }

    public void setEndIconVisible(boolean z10) {
        if (m11207K() != z10) {
            this.f8841e0.setVisibility(z10 ? 0 : 8);
            m11251t0();
            m11197C0();
            m11245q0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f8852k.m11373z()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f8852k.m11369v();
        } else {
            this.f8852k.m11349O(charSequence);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f8852k.m11338D(charSequence);
    }

    public void setErrorEnabled(boolean z10) {
        this.f8852k.m11339E(z10);
    }

    public void setErrorIconDrawable(int i10) {
        setErrorIconDrawable(i10 != 0 ? C8968a.m56743b(getContext(), i10) : null);
        m11217V();
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        m11185b0(this.f8859n0, onClickListener, this.f8857m0);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f8857m0 = onLongClickListener;
        m11187c0(this.f8859n0, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        if (this.f8861o0 != colorStateList) {
            this.f8861o0 = colorStateList;
            C1867f.m11325a(this, this.f8859n0, colorStateList, this.f8863p0);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        if (this.f8863p0 != mode) {
            this.f8863p0 = mode;
            C1867f.m11325a(this, this.f8859n0, this.f8861o0, mode);
        }
    }

    public void setErrorTextAppearance(int i10) {
        this.f8852k.m11340F(i10);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f8852k.m11341G(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.f8808D0 != z10) {
            this.f8808D0 = z10;
            m11257w0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (m11209M()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!m11209M()) {
                setHelperTextEnabled(true);
            }
            this.f8852k.m11350P(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f8852k.m11344J(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        this.f8852k.m11343I(z10);
    }

    public void setHelperTextTextAppearance(int i10) {
        this.f8852k.m11342H(i10);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f8805C) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.f8810E0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.f8805C) {
            this.f8805C = z10;
            if (z10) {
                CharSequence hint = this.f8840e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f8807D)) {
                        setHint(hint);
                    }
                    this.f8840e.setHint((CharSequence) null);
                }
                this.f8809E = true;
            } else {
                this.f8809E = false;
                if (!TextUtils.isEmpty(this.f8807D) && TextUtils.isEmpty(this.f8840e.getHint())) {
                    this.f8840e.setHint(this.f8807D);
                }
                setHintInternal(null);
            }
            if (this.f8840e != null) {
                m11255v0();
            }
        }
    }

    public void setHintTextAppearance(int i10) {
        this.f8806C0.m10630d0(i10);
        this.f8867r0 = this.f8806C0.m10653p();
        if (this.f8840e != null) {
            m11257w0(false);
            m11255v0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f8867r0 != colorStateList) {
            if (this.f8865q0 == null) {
                this.f8806C0.m10634f0(colorStateList);
            }
            this.f8867r0 = colorStateList;
            if (this.f8840e != null) {
                m11257w0(false);
            }
        }
    }

    public void setMaxEms(int i10) {
        this.f8846h = i10;
        EditText editText = this.f8840e;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxEms(i10);
    }

    public void setMaxWidth(int i10) {
        this.f8850j = i10;
        EditText editText = this.f8840e;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxWidth(i10);
    }

    public void setMaxWidthResource(int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.f8844g = i10;
        EditText editText = this.f8840e;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinEms(i10);
    }

    public void setMinWidth(int i10) {
        this.f8848i = i10;
        EditText editText = this.f8840e;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinWidth(i10);
    }

    public void setMinWidthResource(int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i10) {
        setPasswordVisibilityToggleContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i10) {
        setPasswordVisibilityToggleDrawable(i10 != 0 ? C8968a.m56743b(getContext(), i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        if (z10 && this.f8837c0 != 1) {
            setEndIconMode(1);
        } else {
            if (z10) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f8845g0 = colorStateList;
        C1867f.m11325a(this, this.f8841e0, colorStateList, this.f8847h0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f8847h0 = mode;
        C1867f.m11325a(this, this.f8841e0, this.f8845g0, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f8870t == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f8870t = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_placeholder);
            C9603h0.m59833A0(this.f8870t, 2);
            Fade fadeM11262z = m11262z();
            this.f8876w = fadeM11262z;
            fadeM11262z.mo5736g0(67L);
            this.f8878x = m11262z();
            setPlaceholderTextAppearance(this.f8874v);
            setPlaceholderTextColor(this.f8872u);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f8868s) {
                setPlaceholderTextEnabled(true);
            }
            this.f8866r = charSequence;
        }
        m11263z0();
    }

    public void setPlaceholderTextAppearance(int i10) {
        this.f8874v = i10;
        TextView textView = this.f8870t;
        if (textView != null) {
            C0669j.m4080n(textView, i10);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f8872u != colorStateList) {
            this.f8872u = colorStateList;
            TextView textView = this.f8870t;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f8834b.m11166k(charSequence);
    }

    public void setPrefixTextAppearance(int i10) {
        this.f8834b.m11167l(i10);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f8834b.m11168m(colorStateList);
    }

    public void setStartIconCheckable(boolean z10) {
        this.f8834b.m11169n(z10);
    }

    public void setStartIconContentDescription(int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(int i10) {
        setStartIconDrawable(i10 != 0 ? C8968a.m56743b(getContext(), i10) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f8834b.m11172q(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f8834b.m11173r(onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f8834b.m11174s(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f8834b.m11175t(mode);
    }

    public void setStartIconVisible(boolean z10) {
        this.f8834b.m11176u(z10);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f8801A = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f8803B.setText(charSequence);
        m11199D0();
    }

    public void setSuffixTextAppearance(int i10) {
        C0669j.m4080n(this.f8803B, i10);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f8803B.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(C1859e c1859e) {
        EditText editText = this.f8840e;
        if (editText != null) {
            C9603h0.m59902p0(editText, c1859e);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f8830V) {
            this.f8830V = typeface;
            this.f8806C0.m10607H0(typeface);
            this.f8852k.m11346L(typeface);
            TextView textView = this.f8860o;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* renamed from: t */
    public final Rect m11250t(Rect rect) {
        if (this.f8840e == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f8828T;
        float fM10594B = this.f8806C0.m10594B();
        rect2.left = rect.left + this.f8840e.getCompoundPaddingLeft();
        rect2.top = m11248s(rect, fM10594B);
        rect2.right = rect.right - this.f8840e.getCompoundPaddingRight();
        rect2.bottom = m11246r(rect, rect2, fM10594B);
        return rect2;
    }

    /* renamed from: t0 */
    public final void m11251t0() {
        this.f8838d.setVisibility((this.f8841e0.getVisibility() != 0 || m11208L()) ? 8 : 0);
        this.f8836c.setVisibility(m11207K() || m11208L() || !((this.f8801A == null || m11210N()) ? 8 : false) ? 0 : 8);
    }

    /* renamed from: u */
    public final int m11252u() {
        float fM10657r;
        if (!this.f8805C) {
            return 0;
        }
        int i10 = this.f8820L;
        if (i10 == 0) {
            fM10657r = this.f8806C0.m10657r();
        } else {
            if (i10 != 2) {
                return 0;
            }
            fM10657r = this.f8806C0.m10657r() / 2.0f;
        }
        return (int) fM10657r;
    }

    /* renamed from: u0 */
    public final void m11253u0() {
        this.f8859n0.setVisibility(getErrorIconDrawable() != null && this.f8852k.m11373z() && this.f8852k.m11359l() ? 0 : 8);
        m11251t0();
        m11197C0();
        if (m11205I()) {
            return;
        }
        m11245q0();
    }

    /* renamed from: v */
    public final boolean m11254v() {
        return this.f8820L == 2 && m11256w();
    }

    /* renamed from: v0 */
    public final void m11255v0() {
        if (this.f8820L != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8832a.getLayoutParams();
            int iM11252u = m11252u();
            if (iM11252u != layoutParams.topMargin) {
                layoutParams.topMargin = iM11252u;
                this.f8832a.requestLayout();
            }
        }
    }

    /* renamed from: w */
    public final boolean m11256w() {
        return this.f8822N > -1 && this.f8825Q != 0;
    }

    /* renamed from: w0 */
    public void m11257w0(boolean z10) {
        m11259x0(z10, false);
    }

    /* renamed from: x */
    public final void m11258x() {
        if (m11192A()) {
            ((C1864c) this.f8811F).m11282r0();
        }
    }

    /* renamed from: x0 */
    public final void m11259x0(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f8840e;
        boolean z12 = false;
        boolean z13 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f8840e;
        if (editText2 != null && editText2.hasFocus()) {
            z12 = true;
        }
        boolean zM11359l = this.f8852k.m11359l();
        ColorStateList colorStateList2 = this.f8865q0;
        if (colorStateList2 != null) {
            this.f8806C0.m10634f0(colorStateList2);
            this.f8806C0.m10654p0(this.f8865q0);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f8865q0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f8802A0) : this.f8802A0;
            this.f8806C0.m10634f0(ColorStateList.valueOf(colorForState));
            this.f8806C0.m10654p0(ColorStateList.valueOf(colorForState));
        } else if (zM11359l) {
            this.f8806C0.m10634f0(this.f8852k.m11364q());
        } else if (this.f8858n && (textView = this.f8860o) != null) {
            this.f8806C0.m10634f0(textView.getTextColors());
        } else if (z12 && (colorStateList = this.f8867r0) != null) {
            this.f8806C0.m10634f0(colorStateList);
        }
        if (z13 || !this.f8808D0 || (isEnabled() && z12)) {
            if (z11 || this.f8804B0) {
                m11260y(z10);
                return;
            }
            return;
        }
        if (z11 || !this.f8804B0) {
            m11202F(z10);
        }
    }

    /* renamed from: y */
    public final void m11260y(boolean z10) {
        ValueAnimator valueAnimator = this.f8812F0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f8812F0.cancel();
        }
        if (z10 && this.f8810E0) {
            m11233k(1.0f);
        } else {
            this.f8806C0.m10664u0(1.0f);
        }
        this.f8804B0 = false;
        if (m11192A()) {
            m11214R();
        }
        m11263z0();
        this.f8834b.m11164i(false);
        m11199D0();
    }

    /* renamed from: y0 */
    public final void m11261y0() {
        EditText editText;
        if (this.f8870t == null || (editText = this.f8840e) == null) {
            return;
        }
        this.f8870t.setGravity(editText.getGravity());
        this.f8870t.setPadding(this.f8840e.getCompoundPaddingLeft(), this.f8840e.getCompoundPaddingTop(), this.f8840e.getCompoundPaddingRight(), this.f8840e.getCompoundPaddingBottom());
    }

    /* renamed from: z */
    public final Fade m11262z() {
        Fade fade = new Fade();
        fade.mo5727a0(87L);
        fade.mo5731c0(C13110a.f59597a);
        return fade;
    }

    /* renamed from: z0 */
    public final void m11263z0() {
        EditText editText = this.f8840e;
        m11193A0(editText == null ? 0 : editText.getText().length());
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f8841e0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f8841e0.setImageDrawable(drawable);
        if (drawable != null) {
            C1867f.m11325a(this, this.f8841e0, this.f8845g0, this.f8847h0);
            m11216U();
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f8834b.m11170o(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f8834b.m11171p(drawable);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v82 */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i10) {
        int i11;
        ?? r32;
        boolean z10;
        int iM2960n;
        int i12 = f8800I0;
        super(C10981a.m66348c(context, attributeSet, i10, i12), attributeSet, i10);
        this.f8844g = -1;
        this.f8846h = -1;
        this.f8848i = -1;
        this.f8850j = -1;
        this.f8852k = new C1868g(this);
        this.f8827S = new Rect();
        this.f8828T = new Rect();
        this.f8829U = new RectF();
        this.f8835b0 = new LinkedHashSet<>();
        this.f8837c0 = 0;
        SparseArray<AbstractC1866e> sparseArray = new SparseArray<>();
        this.f8839d0 = sparseArray;
        this.f8843f0 = new LinkedHashSet<>();
        C1771b c1771b = new C1771b(this);
        this.f8806C0 = c1771b;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f8832a = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f8838d = frameLayout2;
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f8836c = linearLayout;
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.f8803B = appCompatTextView;
        linearLayout.setVisibility(8);
        frameLayout2.setVisibility(8);
        appCompatTextView.setVisibility(8);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context2);
        int i13 = R$layout.design_text_input_end_icon;
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflaterFrom.inflate(i13, (ViewGroup) linearLayout, false);
        this.f8859n0 = checkableImageButton;
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) layoutInflaterFrom.inflate(i13, (ViewGroup) frameLayout2, false);
        this.f8841e0 = checkableImageButton2;
        frameLayout.setAddStatesFromChildren(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = C13110a.f59597a;
        c1771b.m10605G0(timeInterpolator);
        c1771b.m10597C0(timeInterpolator);
        c1771b.m10636g0(8388659);
        int[] iArr = R$styleable.TextInputLayout;
        int i14 = R$styleable.TextInputLayout_counterTextAppearance;
        int i15 = R$styleable.TextInputLayout_counterOverflowTextAppearance;
        int i16 = R$styleable.TextInputLayout_errorTextAppearance;
        int i17 = R$styleable.TextInputLayout_helperTextTextAppearance;
        int i18 = R$styleable.TextInputLayout_hintTextAppearance;
        C0523e0 c0523e0M10771i = C1784o.m10771i(context2, attributeSet, iArr, i10, i12, i14, i15, i16, i17, i18);
        StartCompoundLayout startCompoundLayout = new StartCompoundLayout(this, c0523e0M10771i);
        this.f8834b = startCompoundLayout;
        this.f8805C = c0523e0M10771i.m2947a(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(c0523e0M10771i.m2962p(R$styleable.TextInputLayout_android_hint));
        this.f8810E0 = c0523e0M10771i.m2947a(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.f8808D0 = c0523e0M10771i.m2947a(R$styleable.TextInputLayout_expandedHintEnabled, true);
        int i19 = R$styleable.TextInputLayout_android_minEms;
        if (c0523e0M10771i.m2965s(i19)) {
            i11 = -1;
            setMinEms(c0523e0M10771i.m2957k(i19, -1));
        } else {
            i11 = -1;
            int i20 = R$styleable.TextInputLayout_android_minWidth;
            if (c0523e0M10771i.m2965s(i20)) {
                setMinWidth(c0523e0M10771i.m2952f(i20, -1));
            }
        }
        int i21 = R$styleable.TextInputLayout_android_maxEms;
        if (c0523e0M10771i.m2965s(i21)) {
            setMaxEms(c0523e0M10771i.m2957k(i21, i11));
        } else {
            int i22 = R$styleable.TextInputLayout_android_maxWidth;
            if (c0523e0M10771i.m2965s(i22)) {
                setMaxWidth(c0523e0M10771i.m2952f(i22, i11));
            }
        }
        this.f8817I = C10432m.m64049e(context2, attributeSet, i10, i12).m64093m();
        this.f8819K = context2.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.f8821M = c0523e0M10771i.m2951e(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.f8823O = c0523e0M10771i.m2952f(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.f8824P = c0523e0M10771i.m2952f(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.f8822N = this.f8823O;
        float fM2950d = c0523e0M10771i.m2950d(R$styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fM2950d2 = c0523e0M10771i.m2950d(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fM2950d3 = c0523e0M10771i.m2950d(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fM2950d4 = c0523e0M10771i.m2950d(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        C10432m.b bVarM64066v = this.f8817I.m64066v();
        if (fM2950d >= 0.0f) {
            bVarM64066v.m64087E(fM2950d);
        }
        if (fM2950d2 >= 0.0f) {
            bVarM64066v.m64091I(fM2950d2);
        }
        if (fM2950d3 >= 0.0f) {
            bVarM64066v.m64105z(fM2950d3);
        }
        if (fM2950d4 >= 0.0f) {
            bVarM64066v.m64101v(fM2950d4);
        }
        this.f8817I = bVarM64066v.m64093m();
        ColorStateList colorStateListM60266b = C9649c.m60266b(context2, c0523e0M10771i, R$styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateListM60266b != null) {
            int defaultColor = colorStateListM60266b.getDefaultColor();
            this.f8877w0 = defaultColor;
            this.f8826R = defaultColor;
            if (colorStateListM60266b.isStateful()) {
                this.f8879x0 = colorStateListM60266b.getColorForState(new int[]{-16842910}, -1);
                this.f8881y0 = colorStateListM60266b.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f8883z0 = colorStateListM60266b.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f8881y0 = this.f8877w0;
                ColorStateList colorStateListM56742a = C8968a.m56742a(context2, R$color.mtrl_filled_background_color);
                this.f8879x0 = colorStateListM56742a.getColorForState(new int[]{-16842910}, -1);
                this.f8883z0 = colorStateListM56742a.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f8826R = 0;
            this.f8877w0 = 0;
            this.f8879x0 = 0;
            this.f8881y0 = 0;
            this.f8883z0 = 0;
        }
        int i23 = R$styleable.TextInputLayout_android_textColorHint;
        if (c0523e0M10771i.m2965s(i23)) {
            ColorStateList colorStateListM2949c = c0523e0M10771i.m2949c(i23);
            this.f8867r0 = colorStateListM2949c;
            this.f8865q0 = colorStateListM2949c;
        }
        int i24 = R$styleable.TextInputLayout_boxStrokeColor;
        ColorStateList colorStateListM60266b2 = C9649c.m60266b(context2, c0523e0M10771i, i24);
        this.f8873u0 = c0523e0M10771i.m2948b(i24, 0);
        this.f8869s0 = ContextCompat.getColor(context2, R$color.mtrl_textinput_default_box_stroke_color);
        this.f8802A0 = ContextCompat.getColor(context2, R$color.mtrl_textinput_disabled_color);
        this.f8871t0 = ContextCompat.getColor(context2, R$color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListM60266b2 != null) {
            setBoxStrokeColorStateList(colorStateListM60266b2);
        }
        int i25 = R$styleable.TextInputLayout_boxStrokeErrorColor;
        if (c0523e0M10771i.m2965s(i25)) {
            setBoxStrokeErrorColor(C9649c.m60266b(context2, c0523e0M10771i, i25));
        }
        if (c0523e0M10771i.m2960n(i18, -1) != -1) {
            r32 = 0;
            setHintTextAppearance(c0523e0M10771i.m2960n(i18, 0));
        } else {
            r32 = 0;
        }
        int iM2960n2 = c0523e0M10771i.m2960n(i16, r32);
        CharSequence charSequenceM2962p = c0523e0M10771i.m2962p(R$styleable.TextInputLayout_errorContentDescription);
        boolean zM2947a = c0523e0M10771i.m2947a(R$styleable.TextInputLayout_errorEnabled, r32);
        checkableImageButton.setId(R$id.text_input_error_icon);
        if (C9649c.m60273i(context2)) {
            C9620q.m60126d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), r32);
        }
        int i26 = R$styleable.TextInputLayout_errorIconTint;
        if (c0523e0M10771i.m2965s(i26)) {
            this.f8861o0 = C9649c.m60266b(context2, c0523e0M10771i, i26);
        }
        int i27 = R$styleable.TextInputLayout_errorIconTintMode;
        if (c0523e0M10771i.m2965s(i27)) {
            this.f8863p0 = C1788s.m10789j(c0523e0M10771i.m2957k(i27, -1), null);
        }
        int i28 = R$styleable.TextInputLayout_errorIconDrawable;
        if (c0523e0M10771i.m2965s(i28)) {
            setErrorIconDrawable(c0523e0M10771i.m2953g(i28));
        }
        checkableImageButton.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        C9603h0.m59833A0(checkableImageButton, 2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int iM2960n3 = c0523e0M10771i.m2960n(i17, 0);
        boolean zM2947a2 = c0523e0M10771i.m2947a(R$styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceM2962p2 = c0523e0M10771i.m2962p(R$styleable.TextInputLayout_helperText);
        int iM2960n4 = c0523e0M10771i.m2960n(R$styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence charSequenceM2962p3 = c0523e0M10771i.m2962p(R$styleable.TextInputLayout_placeholderText);
        int iM2960n5 = c0523e0M10771i.m2960n(R$styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence charSequenceM2962p4 = c0523e0M10771i.m2962p(R$styleable.TextInputLayout_suffixText);
        boolean zM2947a3 = c0523e0M10771i.m2947a(R$styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(c0523e0M10771i.m2957k(R$styleable.TextInputLayout_counterMaxLength, -1));
        this.f8864q = c0523e0M10771i.m2960n(i14, 0);
        this.f8862p = c0523e0M10771i.m2960n(i15, 0);
        setBoxBackgroundMode(c0523e0M10771i.m2957k(R$styleable.TextInputLayout_boxBackgroundMode, 0));
        if (C9649c.m60273i(context2)) {
            C9620q.m60126d((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        int iM2960n6 = c0523e0M10771i.m2960n(R$styleable.TextInputLayout_endIconDrawable, 0);
        sparseArray.append(-1, new C1863b(this, iM2960n6));
        sparseArray.append(0, new C1869h(this));
        if (iM2960n6 == 0) {
            z10 = zM2947a2;
            iM2960n = c0523e0M10771i.m2960n(R$styleable.TextInputLayout_passwordToggleDrawable, 0);
        } else {
            z10 = zM2947a2;
            iM2960n = iM2960n6;
        }
        sparseArray.append(1, new C1870i(this, iM2960n));
        sparseArray.append(2, new C1862a(this, iM2960n6));
        sparseArray.append(3, new C1865d(this, iM2960n6));
        int i29 = R$styleable.TextInputLayout_passwordToggleEnabled;
        if (!c0523e0M10771i.m2965s(i29)) {
            int i30 = R$styleable.TextInputLayout_endIconTint;
            if (c0523e0M10771i.m2965s(i30)) {
                this.f8845g0 = C9649c.m60266b(context2, c0523e0M10771i, i30);
            }
            int i31 = R$styleable.TextInputLayout_endIconTintMode;
            if (c0523e0M10771i.m2965s(i31)) {
                this.f8847h0 = C1788s.m10789j(c0523e0M10771i.m2957k(i31, -1), null);
            }
        }
        int i32 = R$styleable.TextInputLayout_endIconMode;
        if (c0523e0M10771i.m2965s(i32)) {
            setEndIconMode(c0523e0M10771i.m2957k(i32, 0));
            int i33 = R$styleable.TextInputLayout_endIconContentDescription;
            if (c0523e0M10771i.m2965s(i33)) {
                setEndIconContentDescription(c0523e0M10771i.m2962p(i33));
            }
            setEndIconCheckable(c0523e0M10771i.m2947a(R$styleable.TextInputLayout_endIconCheckable, true));
        } else if (c0523e0M10771i.m2965s(i29)) {
            int i34 = R$styleable.TextInputLayout_passwordToggleTint;
            if (c0523e0M10771i.m2965s(i34)) {
                this.f8845g0 = C9649c.m60266b(context2, c0523e0M10771i, i34);
            }
            int i35 = R$styleable.TextInputLayout_passwordToggleTintMode;
            if (c0523e0M10771i.m2965s(i35)) {
                this.f8847h0 = C1788s.m10789j(c0523e0M10771i.m2957k(i35, -1), null);
            }
            setEndIconMode(c0523e0M10771i.m2947a(i29, false) ? 1 : 0);
            setEndIconContentDescription(c0523e0M10771i.m2962p(R$styleable.TextInputLayout_passwordToggleContentDescription));
        }
        appCompatTextView.setId(R$id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        C9603h0.m59906r0(appCompatTextView, 1);
        setErrorContentDescription(charSequenceM2962p);
        setCounterOverflowTextAppearance(this.f8862p);
        setHelperTextTextAppearance(iM2960n3);
        setErrorTextAppearance(iM2960n2);
        setCounterTextAppearance(this.f8864q);
        setPlaceholderText(charSequenceM2962p3);
        setPlaceholderTextAppearance(iM2960n4);
        setSuffixTextAppearance(iM2960n5);
        int i36 = R$styleable.TextInputLayout_errorTextColor;
        if (c0523e0M10771i.m2965s(i36)) {
            setErrorTextColor(c0523e0M10771i.m2949c(i36));
        }
        int i37 = R$styleable.TextInputLayout_helperTextTextColor;
        if (c0523e0M10771i.m2965s(i37)) {
            setHelperTextColor(c0523e0M10771i.m2949c(i37));
        }
        int i38 = R$styleable.TextInputLayout_hintTextColor;
        if (c0523e0M10771i.m2965s(i38)) {
            setHintTextColor(c0523e0M10771i.m2949c(i38));
        }
        int i39 = R$styleable.TextInputLayout_counterTextColor;
        if (c0523e0M10771i.m2965s(i39)) {
            setCounterTextColor(c0523e0M10771i.m2949c(i39));
        }
        int i40 = R$styleable.TextInputLayout_counterOverflowTextColor;
        if (c0523e0M10771i.m2965s(i40)) {
            setCounterOverflowTextColor(c0523e0M10771i.m2949c(i40));
        }
        int i41 = R$styleable.TextInputLayout_placeholderTextColor;
        if (c0523e0M10771i.m2965s(i41)) {
            setPlaceholderTextColor(c0523e0M10771i.m2949c(i41));
        }
        int i42 = R$styleable.TextInputLayout_suffixTextColor;
        if (c0523e0M10771i.m2965s(i42)) {
            setSuffixTextColor(c0523e0M10771i.m2949c(i42));
        }
        setEnabled(c0523e0M10771i.m2947a(R$styleable.TextInputLayout_android_enabled, true));
        c0523e0M10771i.m2966w();
        C9603h0.m59833A0(this, 2);
        C9603h0.m59835B0(this, 1);
        frameLayout2.addView(checkableImageButton2);
        linearLayout.addView(appCompatTextView);
        linearLayout.addView(checkableImageButton);
        linearLayout.addView(frameLayout2);
        frameLayout.addView(startCompoundLayout);
        frameLayout.addView(linearLayout);
        addView(frameLayout);
        setHelperTextEnabled(z10);
        setErrorEnabled(zM2947a);
        setCounterEnabled(zM2947a3);
        setHelperText(charSequenceM2962p2);
        setSuffixText(charSequenceM2962p4);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f8859n0.setImageDrawable(drawable);
        m11253u0();
        C1867f.m11325a(this, this.f8859n0, this.f8861o0, this.f8863p0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f8841e0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f8841e0.setImageDrawable(drawable);
    }

    public void setHint(int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }
}
