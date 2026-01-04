package com.huawei.android.hicloud.commonlib.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import p037bp.C1270a;
import p232dp.InterfaceC9283b;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class SpanClickText extends TextView {

    /* renamed from: a */
    public int f12052a;

    /* renamed from: b */
    public Context f12053b;

    /* renamed from: c */
    public int f12054c;

    /* renamed from: d */
    public boolean f12055d;

    /* renamed from: e */
    public String f12056e;

    /* renamed from: f */
    public int f12057f;

    /* renamed from: g */
    public C2776a f12058g;

    /* renamed from: h */
    public HashMap<String, ISpanClickListener> f12059h;

    /* renamed from: i */
    public HashSet<String> f12060i;

    /* renamed from: j */
    public HashSet<String> f12061j;

    /* renamed from: k */
    public int f12062k;

    public interface ISpanClickListener {
        void onClick();
    }

    public interface ISpanColorChange {
        void onColorChange(TextPaint textPaint, boolean z10);
    }

    /* renamed from: com.huawei.android.hicloud.commonlib.view.SpanClickText$a */
    public static class C2776a implements ISpanColorChange {

        /* renamed from: a */
        public SpanClickText f12063a;

        public C2776a(SpanClickText spanClickText) {
            this.f12063a = spanClickText;
        }

        @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanColorChange
        public void onColorChange(TextPaint textPaint, boolean z10) {
            SpanClickText spanClickText = this.f12063a;
            if (spanClickText == null) {
                return;
            }
            spanClickText.m15933f(textPaint, z10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.commonlib.view.SpanClickText$b */
    public class C2777b extends ClickableSpan {

        /* renamed from: a */
        public ISpanClickListener f12064a;

        /* renamed from: b */
        public ISpanColorChange f12065b;

        /* renamed from: c */
        public boolean f12066c;

        public C2777b(ISpanColorChange iSpanColorChange, ISpanClickListener iSpanClickListener) {
            this.f12064a = iSpanClickListener;
            this.f12065b = iSpanColorChange;
        }

        /* renamed from: a */
        public void m15937a(boolean z10) {
            this.f12066c = z10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ISpanClickListener iSpanClickListener = this.f12064a;
            if (iSpanClickListener == null) {
                return;
            }
            iSpanClickListener.onClick();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            ISpanColorChange iSpanColorChange = this.f12065b;
            if (iSpanColorChange == null) {
                return;
            }
            iSpanColorChange.onColorChange(textPaint, this.f12066c);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.commonlib.view.SpanClickText$c */
    public static class C2778c extends LinkMovementMethod {

        /* renamed from: a */
        public C2777b f12068a;

        /* renamed from: b */
        public boolean f12069b;

        public C2778c(boolean z10) {
            this.f12069b = z10;
        }

        /* renamed from: a */
        public final C2777b m15938a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int x10 = (int) motionEvent.getX();
            int y10 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
            int scrollY = y10 + textView.getScrollY();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            C2777b[] c2777bArr = (C2777b[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, C2777b.class);
            if (c2777bArr.length > 0) {
                return c2777bArr[0];
            }
            return null;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            if (2 == motionEvent.getAction()) {
                C2777b c2777bM15938a = m15938a(textView, spannable, motionEvent);
                C2777b c2777b = this.f12068a;
                if (c2777b != null && c2777bM15938a != c2777b) {
                    c2777b.m15937a(false);
                    this.f12068a = null;
                    Selection.removeSelection(spannable);
                }
            } else if (motionEvent.getAction() == 0) {
                C2777b c2777bM15938a2 = m15938a(textView, spannable, motionEvent);
                this.f12068a = c2777bM15938a2;
                if (c2777bM15938a2 != null) {
                    c2777bM15938a2.m15937a(true);
                    Selection.setSelection(spannable, spannable.getSpanStart(this.f12068a), spannable.getSpanEnd(this.f12068a));
                } else if (this.f12069b) {
                    return false;
                }
            } else {
                Selection.removeSelection(spannable);
                C2777b c2777b2 = this.f12068a;
                if (c2777b2 == null) {
                    return true;
                }
                c2777b2.m15937a(false);
                this.f12068a = null;
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    public SpanClickText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12055d = true;
        this.f12059h = new HashMap<>();
        this.f12060i = new HashSet<>();
        this.f12061j = new HashSet<>();
        this.f12062k = -1;
        this.f12053b = context;
        ColorStateList textColors = getTextColors();
        if (textColors == null) {
            return;
        }
        this.f12057f = textColors.getDefaultColor();
        this.f12058g = new C2776a(this);
        setHighlightColor(getResources().getColor(R$color.transparent));
        m15932d(attributeSet);
    }

    /* renamed from: e */
    public static boolean m15929e(int i10, int i11, int i12) {
        return i10 >= 0 && i10 < i11 && i11 <= i12;
    }

    /* renamed from: b */
    public void m15930b(String str) {
        HashSet<String> hashSet;
        if (!this.f12055d || (hashSet = this.f12060i) == null) {
            return;
        }
        hashSet.add(str);
    }

    /* renamed from: c */
    public void m15931c(String str, ISpanClickListener iSpanClickListener) {
        this.f12059h.put(str, iSpanClickListener);
    }

    /* renamed from: d */
    public final void m15932d(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.f12053b.obtainStyledAttributes(attributeSet, R$styleable.PfSpanClickText);
        this.f12056e = typedArrayObtainStyledAttributes.getString(R$styleable.PfSpanClickText_pf_spanFamily);
        this.f12052a = typedArrayObtainStyledAttributes.getColor(R$styleable.PfSpanClickText_pf_spanColor, this.f12057f);
        this.f12054c = typedArrayObtainStyledAttributes.getColor(R$styleable.PfSpanClickText_pf_spanBgColor, this.f12057f);
        this.f12055d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PfSpanClickText_needBold, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: f */
    public final void m15933f(TextPaint textPaint, boolean z10) {
        if (!TextUtils.isEmpty(this.f12056e)) {
            textPaint.setTypeface(Typeface.create(this.f12056e, textPaint.getTypeface().getStyle()));
        }
        textPaint.setColor(this.f12052a);
        if (z10) {
            textPaint.bgColor = this.f12054c;
        } else {
            textPaint.bgColor = getResources().getColor(R$color.transparent);
        }
    }

    /* renamed from: g */
    public void m15934g(String str, boolean z10) {
        m15936i(str, z10, false, getResources().getColor(R$color.emui_color_primary), false);
    }

    /* renamed from: h */
    public void m15935h(String str, boolean z10, boolean z11) {
        m15936i(str, z10, false, getResources().getColor(R$color.emui_color_primary), z11);
    }

    /* renamed from: i */
    public void m15936i(String str, boolean z10, boolean z11, int i10, boolean z12) {
        HashMap<String, ISpanClickListener> map;
        if (str == null || (map = this.f12059h) == null) {
            return;
        }
        boolean z13 = map.size() > 0;
        HashSet<String> hashSet = this.f12060i;
        boolean z14 = hashSet != null && hashSet.size() > 0;
        HashSet<String> hashSet2 = this.f12061j;
        boolean z15 = hashSet2 != null && hashSet2.size() > 0;
        if (!z13 && !z14 && !z15) {
            setText(str);
            return;
        }
        String str2 = str + " ";
        SpannableString spannableString = new SpannableString(str2);
        int length = str2.length();
        for (Map.Entry<String, ISpanClickListener> entry : this.f12059h.entrySet()) {
            String key = entry.getKey();
            ISpanClickListener value = entry.getValue();
            int iLastIndexOf = str2.lastIndexOf(key);
            int length2 = key.length() + iLastIndexOf;
            if (!m15929e(iLastIndexOf, length2, length)) {
                setText(str2);
                this.f12059h.clear();
                return;
            } else {
                if (!TextUtils.isEmpty(this.f12056e)) {
                    spannableString.setSpan(new TypefaceSpan(this.f12056e), iLastIndexOf, length2, 33);
                }
                spannableString.setSpan(new C2777b(this.f12058g, value), iLastIndexOf, length2, 33);
            }
        }
        if (z12) {
            spannableString = ((InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class)).mo58500c0(spannableString, getContext());
        }
        if (z14) {
            Iterator<String> it = this.f12060i.iterator();
            while (it.hasNext()) {
                String next = it.next();
                int iLastIndexOf2 = str2.lastIndexOf(next);
                if (z10) {
                    C11839m.m70688i("SpanClickText", "setBoldFrontToBack");
                    iLastIndexOf2 = str2.indexOf(next);
                }
                int length3 = next.length() + iLastIndexOf2;
                if (!m15929e(iLastIndexOf2, length3, length)) {
                    setText(str2);
                    this.f12060i.clear();
                    return;
                } else {
                    if (z11) {
                        spannableString.setSpan(new StyleSpan(1), iLastIndexOf2, length3, 33);
                    } else {
                        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iLastIndexOf2, length3, 33);
                    }
                    spannableString.setSpan(new ForegroundColorSpan(i10), iLastIndexOf2, length3, 33);
                }
            }
        }
        if (z15) {
            Iterator<String> it2 = this.f12061j.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                int iLastIndexOf3 = str2.lastIndexOf(next2);
                int length4 = next2.length() + iLastIndexOf3;
                if (!m15929e(iLastIndexOf3, length4, length)) {
                    setText(str2);
                    this.f12061j.clear();
                    return;
                } else if (this.f12062k != -1) {
                    spannableString.setSpan(new AbsoluteSizeSpan(this.f12062k), iLastIndexOf3, length4, 33);
                }
            }
        }
        setText(spannableString);
        if (z12) {
            setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            setMovementMethod(new C2778c(z14));
        }
        setFocusable(false);
        setClickable(false);
        setLongClickable(false);
        this.f12059h.clear();
        HashSet<String> hashSet3 = this.f12061j;
        if (hashSet3 != null) {
            hashSet3.clear();
        }
        HashSet<String> hashSet4 = this.f12060i;
        if (hashSet4 != null) {
            hashSet4.clear();
        }
    }

    public void setNeedBold(boolean z10) {
        this.f12055d = z10;
    }

    public void setSpanTextColor(int i10) {
        this.f12052a = i10;
    }
}
