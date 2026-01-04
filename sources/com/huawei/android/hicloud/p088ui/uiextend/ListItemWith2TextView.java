package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$styleable;
import p399jk.AbstractC10896a;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ListItemWith2TextView extends ConstraintLayout {
    private static final String TAG = "ListItemWith2TextView";
    private View dividerView;
    private TextView leftTextView;
    private TextView rightTextView;

    public ListItemWith2TextView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.list_item_with_2_textview, this);
        this.leftTextView = (TextView) viewInflate.findViewById(R$id.left_text);
        this.rightTextView = (TextView) viewInflate.findViewById(R$id.right_text);
        this.dividerView = viewInflate.findViewById(R$id.divider);
        final int iM70856r = C11842p.m70856r(getContext()) / 3;
        final Paint paint = new Paint();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.android.hicloud.ui.uiextend.ListItemWith2TextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ListItemWith2TextView.this.leftTextView.getLineCount() + ListItemWith2TextView.this.rightTextView.getLineCount() > 2) {
                    ListItemWith2TextView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AbstractC10896a.m65885d(ListItemWith2TextView.TAG, "lineCount > 2");
                    ListItemWith2TextView listItemWith2TextView = ListItemWith2TextView.this;
                    listItemWith2TextView.setTextViewMiniWidth(listItemWith2TextView.leftTextView, iM70856r);
                    ListItemWith2TextView listItemWith2TextView2 = ListItemWith2TextView.this;
                    listItemWith2TextView2.setTextViewMiniWidth(listItemWith2TextView2.rightTextView, iM70856r);
                    if (paint.measureText(ListItemWith2TextView.this.leftTextView.getText(), 0, ListItemWith2TextView.this.leftTextView.getText().length()) < paint.measureText(ListItemWith2TextView.this.rightTextView.getText(), 0, ListItemWith2TextView.this.rightTextView.getText().length())) {
                        ListItemWith2TextView listItemWith2TextView3 = ListItemWith2TextView.this;
                        listItemWith2TextView3.setTextViewMaxWidth(listItemWith2TextView3.leftTextView, iM70856r);
                    } else {
                        ListItemWith2TextView listItemWith2TextView4 = ListItemWith2TextView.this;
                        listItemWith2TextView4.setTextViewMaxWidth(listItemWith2TextView4.rightTextView, iM70856r);
                    }
                }
            }
        });
    }

    private void parseAttributes(Context context, TypedArray typedArray) {
        String string = typedArray.getString(R$styleable.list_item_with_2_textview_style_left_text);
        String string2 = typedArray.getString(R$styleable.list_item_with_2_textview_style_right_text);
        setTextStyle(typedArray, R$styleable.list_item_with_2_textview_style_left_text_style, this.leftTextView);
        setTextStyle(typedArray, R$styleable.list_item_with_2_textview_style_right_text_style, this.rightTextView);
        C12809f.m76841n(this.leftTextView, string);
        C12809f.m76841n(this.rightTextView, string2);
    }

    private void setTextStyle(TypedArray typedArray, int i10, TextView textView) {
        int resourceId = typedArray.getResourceId(i10, 0);
        if (resourceId <= 0 || textView == null) {
            return;
        }
        textView.setTextAppearance(resourceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextViewMaxWidth(TextView textView, int i10) {
        if (textView == null) {
            AbstractC10896a.m65886e(TAG, "setTextViewMaxWidth textView is null!");
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.f2969T = i10;
        textView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextViewMiniWidth(TextView textView, int i10) {
        if (textView == null) {
            AbstractC10896a.m65886e(TAG, "setTextViewMiniWidth textView is null!");
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.f2967R = i10;
        textView.setLayoutParams(layoutParams);
    }

    public void setLeftText(CharSequence charSequence) {
        C12809f.m76841n(this.leftTextView, charSequence);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        setBackgroundResource(R$drawable.hmos_list_selector);
        if (C11842p.m70765S0()) {
            this.rightTextView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.hicloud_list_arrow_gray, 0, 0, 0);
        } else {
            this.rightTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$drawable.hicloud_list_arrow_gray, 0);
        }
    }

    public void setRightText(CharSequence charSequence) {
        C12809f.m76841n(this.rightTextView, charSequence);
    }

    public void setText(String str) {
        this.rightTextView.setText(str);
    }

    public void setTextColor(int i10) {
        this.rightTextView.setTextColor(i10);
    }

    public void showDivider(boolean z10) {
        C12809f.m76843p(this.dividerView, z10);
    }

    public ListItemWith2TextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
        parseAttributes(context, context.obtainStyledAttributes(attributeSet, R$styleable.list_item_with_2_textview_style));
    }
}
