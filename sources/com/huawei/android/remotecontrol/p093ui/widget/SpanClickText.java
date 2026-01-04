package com.huawei.android.remotecontrol.p093ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$styleable;
import java.lang.ref.WeakReference;
import java.util.Map;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class SpanClickText extends TextView {
    private static final String TAG = "SpanClickText";
    private ColorChangeListen mColorListen;
    private int normalColor;
    private int spanClickColor;
    private int spanColor;
    private String spanFamily;

    public static class ColorChangeListen implements ISpanColorChange {
        private WeakReference<SpanClickText> mTextView;

        public ColorChangeListen(SpanClickText spanClickText) {
            this.mTextView = new WeakReference<>(spanClickText);
        }

        @Override // com.huawei.android.remotecontrol.ui.widget.SpanClickText.ISpanColorChange
        public void onColorChange(int i10, TextPaint textPaint, boolean z10) {
            SpanClickText spanClickText = this.mTextView.get();
            if (spanClickText == null) {
                return;
            }
            spanClickText.onSpaColorChange(i10, textPaint, z10);
        }
    }

    public interface ISpanClickListem {
        void onClick(int i10);
    }

    public interface ISpanColorChange {
        void onColorChange(int i10, TextPaint textPaint, boolean z10);
    }

    public static class LinkClickSpan extends ClickableSpan {
        private boolean isPressed;
        private WeakReference<ISpanClickListem> mClickListen;
        private WeakReference<ISpanColorChange> mColorChangeListen;
        private int position;

        public LinkClickSpan(int i10, ISpanColorChange iSpanColorChange, ISpanClickListem iSpanClickListem) {
            this.position = i10;
            this.mClickListen = new WeakReference<>(iSpanClickListem);
            this.mColorChangeListen = new WeakReference<>(iSpanColorChange);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ISpanClickListem iSpanClickListem = this.mClickListen.get();
            if (iSpanClickListem == null) {
                return;
            }
            iSpanClickListem.onClick(this.position);
        }

        public void setPressed(boolean z10) {
            this.isPressed = z10;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            ISpanColorChange iSpanColorChange = this.mColorChangeListen.get();
            if (iSpanColorChange == null) {
                return;
            }
            iSpanColorChange.onColorChange(this.position, textPaint, this.isPressed);
            textPaint.setUnderlineText(false);
        }
    }

    public static class LinkTouchMovementMethod extends LinkMovementMethod {
        private LinkClickSpan mClickSpan;

        private LinkClickSpan getPressedSpan(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
            int totalPaddingTop = y10 - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            LinkClickSpan[] linkClickSpanArr = (LinkClickSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, LinkClickSpan.class);
            if (linkClickSpanArr.length > 0) {
                return linkClickSpanArr[0];
            }
            return null;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                LinkClickSpan pressedSpan = getPressedSpan(textView, spannable, motionEvent);
                this.mClickSpan = pressedSpan;
                if (pressedSpan != null) {
                    pressedSpan.setPressed(true);
                    Selection.setSelection(spannable, spannable.getSpanStart(this.mClickSpan), spannable.getSpanEnd(this.mClickSpan));
                }
            } else if (2 == motionEvent.getAction()) {
                LinkClickSpan pressedSpan2 = getPressedSpan(textView, spannable, motionEvent);
                LinkClickSpan linkClickSpan = this.mClickSpan;
                if (linkClickSpan != null && pressedSpan2 != linkClickSpan) {
                    linkClickSpan.setPressed(false);
                    this.mClickSpan = null;
                    Selection.removeSelection(spannable);
                }
            } else {
                Selection.removeSelection(spannable);
                LinkClickSpan linkClickSpan2 = this.mClickSpan;
                if (linkClickSpan2 == null) {
                    return true;
                }
                linkClickSpan2.setPressed(false);
                this.mClickSpan = null;
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    public SpanClickText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (getTextColors() == null) {
            return;
        }
        this.normalColor = getResources().getColor(R$color.color_0A59F7);
        this.mColorListen = new ColorChangeListen(this);
        setHighlightColor(getResources().getColor(R$color.transparent));
        initAttrs(context, attributeSet);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PfSpanClickText);
        this.spanFamily = typedArrayObtainStyledAttributes.getString(R$styleable.PfSpanClickText_pf_spanFamily);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.PfSpanClickText_pf_spanColor, this.normalColor);
        this.spanColor = color;
        this.spanClickColor = typedArrayObtainStyledAttributes.getColor(R$styleable.PfSpanClickText_pf_spanClickColor, color);
        typedArrayObtainStyledAttributes.recycle();
    }

    private static boolean isSpanValued(int i10, int i11, int i12) {
        return i10 >= 0 && i10 < i11 && i11 <= i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSpaColorChange(int i10, TextPaint textPaint, boolean z10) {
        if (!TextUtils.isEmpty(this.spanFamily)) {
            textPaint.setTypeface(Typeface.create(this.spanFamily, textPaint.getTypeface().getStyle()));
        }
        if (z10) {
            textPaint.setColor(this.spanClickColor);
            textPaint.bgColor = getResources().getColor(R$color.emui9_list_seletor_color);
        } else {
            textPaint.setColor(this.spanColor);
            textPaint.bgColor = getResources().getColor(R$color.transparent);
        }
    }

    public void initText(String str, ISpanClickListem iSpanClickListem, Map<Integer, String> map) throws Resources.NotFoundException {
        initText(str, iSpanClickListem, map, null);
    }

    public void initText(String str, ISpanClickListem iSpanClickListem, Map<Integer, String> map, Map<String, Integer> map2) throws Resources.NotFoundException {
        if (str == null) {
            return;
        }
        if (map == null) {
            setText(str);
            return;
        }
        String str2 = str + " ";
        SpannableString spannableString = new SpannableString(str2);
        int length = str2.length();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            String value = entry.getValue();
            int iLastIndexOf = str2.lastIndexOf(value);
            int length2 = value.length() + iLastIndexOf;
            if (!isSpanValued(iLastIndexOf, length2, length)) {
                setText(str2);
                return;
            }
            spannableString.setSpan(new LinkClickSpan(iIntValue, this.mColorListen, iSpanClickListem), iLastIndexOf, length2, 33);
        }
        if (map2 != null) {
            C13981a.m83989i(TAG, "initText:imageSpans=" + map2);
            for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
                String key = entry2.getKey();
                int iIntValue2 = entry2.getValue().intValue();
                if (getResources().getDrawable(iIntValue2) == null) {
                    C13981a.m83988e(TAG, "initText error:drawable = null");
                } else {
                    try {
                        getResources().getDrawable(iIntValue2);
                        int iLastIndexOf2 = str2.lastIndexOf(key);
                        int length3 = key.length() + iLastIndexOf2;
                        if (isSpanValued(iLastIndexOf2, length3, length)) {
                            spannableString.setSpan(new ImageSpan(getContext(), iIntValue2), iLastIndexOf2, length3, 33);
                        } else {
                            C13981a.m83988e(TAG, "initText error:isSpanValued false--startM=" + iLastIndexOf2 + "--endM=" + length3 + "--allLenght=" + length);
                        }
                    } catch (Exception e10) {
                        C13981a.m83988e(TAG, "getDrawable error:e" + e10.getMessage());
                    }
                }
            }
        }
        setText(spannableString);
        setMovementMethod(new LinkTouchMovementMethod());
        setFocusable(false);
        setClickable(false);
        setLongClickable(false);
    }
}
