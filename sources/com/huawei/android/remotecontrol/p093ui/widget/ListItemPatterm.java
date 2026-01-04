package com.huawei.android.remotecontrol.p093ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.sdk.R$style;
import com.huawei.android.remotecontrol.sdk.R$styleable;
import com.huawei.cloud.base.util.C4633d0;
import p015ak.C0219i;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes4.dex */
public class ListItemPatterm extends LinearLayout {
    public static final int ITEM_HAS_SUBTEXT_HEIGHT = 64;
    private static final int ITEM_NO_SUBTEXT_HEIGHT = 48;
    private static final int ITEM_PADDING = 4;
    private CompoundButton mArrowExpland;
    private View mDiliverAbove;
    private View mDiliverBottom;
    private View mListMainText;
    private RelativeLayout mListState;
    private AutoSizeButton mListStateText;
    private SpanClickText mSecongText;
    private UnionSwitch mSwitch;
    private ProgressBar mSwitchProgress;
    private TextView mText;

    public ListItemPatterm(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$style.Pf_Emui9_List_Patterm);
    }

    private void initArrowExpland(boolean z10) {
        CompoundButton compoundButton = this.mArrowExpland;
        if (compoundButton == null) {
            return;
        }
        compoundButton.setVisibility(z10 ? 0 : 8);
    }

    private void initItemState(boolean z10, boolean z11) {
        RelativeLayout relativeLayout = this.mListState;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setVisibility(z10 ? 0 : 8);
        setListState(z11);
    }

    private void initSwitch(boolean z10) {
        UnionSwitch unionSwitch = this.mSwitch;
        if (unionSwitch == null) {
            return;
        }
        unionSwitch.setVisibility(z10 ? 0 : 8);
    }

    private void setMainLayoutParams(boolean z10, boolean z11) {
        LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(this, R$id.list_main);
        ViewGroup.LayoutParams layoutParamsM76834g = C12809f.m76834g(linearLayout);
        if (layoutParamsM76834g instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutParamsM76834g;
            int iM70840n = z10 ? C11842p.m70840n(getContext(), 4) : 0;
            int iM70840n2 = z11 ? C11842p.m70840n(getContext(), 4) : 0;
            setMinimumHeight(getMinimumHeight() + (((iM70840n - layoutParams.topMargin) + iM70840n2) - layoutParams.bottomMargin));
            layoutParams.setMargins(layoutParams.leftMargin, iM70840n, layoutParams.rightMargin, iM70840n2);
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    public boolean getSwitchStatus() {
        UnionSwitch unionSwitch = this.mSwitch;
        if (unionSwitch == null) {
            return false;
        }
        return unionSwitch.isChecked();
    }

    public void initSubText(boolean z10, String str) {
        SpanClickText spanClickText = this.mSecongText;
        if (spanClickText == null) {
            return;
        }
        spanClickText.setVisibility(z10 ? 0 : 8);
        this.mSecongText.setText(str);
    }

    public void setCheckedProgrammatically(boolean z10) {
        this.mSwitch.setCheckedProgrammatically(z10);
    }

    public void setDiliverAboveVisible(boolean z10) {
        View view = this.mDiliverAbove;
        if (view == null) {
            return;
        }
        view.setVisibility(z10 ? 0 : 8);
    }

    public void setDiliverBottomVisible(boolean z10) {
        View view = this.mDiliverBottom;
        if (view == null) {
            return;
        }
        view.setVisibility(z10 ? 0 : 8);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        UnionSwitch unionSwitch = this.mSwitch;
        if (unionSwitch != null) {
            unionSwitch.setEnabled(z10);
        }
    }

    public void setListBottomItemHeight() {
        setMainLayoutParams(false, true);
    }

    public void setListCenterItemHeight() {
        setMainLayoutParams(false, false);
    }

    public void setListMainTextFocusable() {
        View view = this.mListMainText;
        if (view != null) {
            view.setFocusable(true);
        }
    }

    public void setListSingleItemHeight() {
        setMainLayoutParams(true, true);
    }

    public void setListState(boolean z10) {
        AutoSizeButton autoSizeButton = this.mListStateText;
        if (autoSizeButton == null) {
            return;
        }
        autoSizeButton.setText(z10 ? R$string.cloudalbum_switch_open : R$string.sync_switch_button_close);
        this.mListStateText.setContentDescription(z10 ? getContext().getString(R$string.cloudalbum_switch_open) : getContext().getString(R$string.sync_switch_button_close));
    }

    public void setListTopItemHeight() {
        setMainLayoutParams(true, false);
    }

    public void setMainLayoutMinHeight(String str) {
        LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(this, R$id.list_main);
        if (C4633d0.m28404a(str)) {
            linearLayout.setMinimumHeight(C11842p.m70840n(getContext(), 48));
        } else {
            linearLayout.setMinimumHeight(C11842p.m70840n(getContext(), 64));
        }
    }

    public void setPatternEnabled(boolean z10) {
        setEnabled(z10);
        if (z10) {
            this.mText.setAlpha(1.0f);
            this.mSecongText.setAlpha(1.0f);
            this.mListStateText.setAlpha(1.0f);
        } else {
            this.mText.setAlpha(0.4f);
            this.mSecongText.setAlpha(0.4f);
            this.mListStateText.setAlpha(0.4f);
        }
    }

    public void setSubText(CharSequence charSequence) {
        SpanClickText spanClickText = this.mSecongText;
        if (spanClickText == null) {
            return;
        }
        spanClickText.setText(charSequence);
    }

    public void setSwitchListen(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        UnionSwitch unionSwitch = this.mSwitch;
        if (unionSwitch == null) {
            return;
        }
        unionSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setSwitchLoading(boolean z10) {
        UnionSwitch unionSwitch = this.mSwitch;
        if (unionSwitch == null || this.mSwitchProgress == null) {
            return;
        }
        if (z10) {
            unionSwitch.setVisibility(4);
            this.mSwitchProgress.setVisibility(0);
        } else {
            unionSwitch.setVisibility(0);
            this.mSwitchProgress.setVisibility(4);
        }
    }

    public void setSwitchStatus(boolean z10) {
        UnionSwitch unionSwitch = this.mSwitch;
        if (unionSwitch == null) {
            return;
        }
        boolean zIsEnabled = unionSwitch.isEnabled();
        this.mSwitch.setEnabled(false);
        this.mSwitch.setCheckedProgrammatically(z10);
        this.mSwitch.setEnabled(zIsEnabled);
    }

    public void setSwitchTag(String str) {
        UnionSwitch unionSwitch = this.mSwitch;
        if (unionSwitch == null) {
            return;
        }
        unionSwitch.setTag(str);
    }

    public void setText(CharSequence charSequence) {
        TextView textView = this.mText;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // android.view.View
    public void setTextAlignment(int i10) {
        TextView textView = this.mText;
        if (textView == null) {
            return;
        }
        textView.setTextAlignment(i10);
    }

    @Override // android.view.View
    public void setTextDirection(int i10) {
        TextView textView = this.mText;
        if (textView == null) {
            return;
        }
        textView.setTextDirection(i10);
    }

    public ListItemPatterm(Context context, AttributeSet attributeSet, int i10) {
        Boolean bool;
        String string;
        super(context, attributeSet, i10);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PfItem);
        String string2 = typedArrayObtainStyledAttributes.getString(R$styleable.PfItem_pf_text);
        int i11 = R$styleable.PfItem_pf_subtext;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            bool = Boolean.TRUE;
            string = typedArrayObtainStyledAttributes.getString(i11);
        } else {
            bool = Boolean.FALSE;
            string = "";
        }
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PfItem_pf_diliver_above_visible, false);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PfItem_pf_diliver_bottom_visible, true);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PfItem_pf_switch_visible, false);
        boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PfItem_pf_arrow_expland_visible, false);
        boolean z14 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PfItem_pf_oobe, false);
        boolean z15 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PfItem_pf_show_state, false);
        boolean z16 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PfItem_pf_show_state_text, false);
        boolean z17 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PfItem_pf_text_single, true);
        typedArrayObtainStyledAttributes.recycle();
        if (C0219i.m1463a() < 27 || !z14) {
            View.inflate(getContext(), R$layout.pf_view_itempatterm, this);
        } else {
            View.inflate(getContext(), R$layout.pf_view_itempatterm_emui111, this);
        }
        TextView textView = (TextView) C12809f.m76831d(this, R$id.list_text);
        this.mText = textView;
        if (textView != null) {
            textView.setSingleLine(z17);
        }
        this.mSecongText = (SpanClickText) C12809f.m76831d(this, R$id.list_subtext);
        this.mSwitch = (UnionSwitch) C12809f.m76831d(this, R$id.list_switch);
        this.mArrowExpland = (CompoundButton) C12809f.m76831d(this, R$id.list_arrow_expland);
        this.mDiliverAbove = C12809f.m76831d(this, R$id.item_diliver_above);
        this.mDiliverBottom = C12809f.m76831d(this, R$id.item_diliver_bottom);
        this.mSwitchProgress = (ProgressBar) C12809f.m76831d(this, R$id.list_switch_progress);
        this.mListState = (RelativeLayout) C12809f.m76831d(this, R$id.list_item_status);
        this.mListStateText = (AutoSizeButton) C12809f.m76831d(this, R$id.list_item_status_text);
        this.mListMainText = C12809f.m76831d(this, R$id.list_main_text);
        TextView textView2 = this.mText;
        if (textView2 != null) {
            textView2.setText(string2);
            this.mText.setTextAppearance(R$style.Emui10_textSizeBody1Medium);
        }
        initSubText(bool.booleanValue(), string);
        setDiliverAboveVisible(z10);
        setDiliverBottomVisible(z11);
        initSwitch(z12);
        initArrowExpland(z13);
        initItemState(z15, z16);
    }
}
