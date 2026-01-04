package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class ScrollViewToBottom extends ScrollView {
    private static final String TAG = "ScrollViewToBottom";
    private boolean isScrollToBottom;
    private OnScrollViewChangeListener mOnScrollViewChangeListener;

    public interface OnScrollViewChangeListener {
        void onScrollToBottom();
    }

    public ScrollViewToBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrollToBottom = false;
    }

    private void notifyScrollChangeListener() {
        OnScrollViewChangeListener onScrollViewChangeListener;
        if (!this.isScrollToBottom || (onScrollViewChangeListener = this.mOnScrollViewChangeListener) == null) {
            return;
        }
        onScrollViewChangeListener.onScrollToBottom();
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        super.onOverScrolled(i10, i11, z10, z11);
        C11839m.m70688i(TAG, "scrollY" + i11);
        if (z11) {
            C11839m.m70688i(TAG, "scrollview scroll to bottom");
        }
        if (i11 == 0) {
            this.isScrollToBottom = false;
        } else {
            this.isScrollToBottom = z11;
        }
        notifyScrollChangeListener();
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
    }

    public void setOnScrollViewChangeListener(OnScrollViewChangeListener onScrollViewChangeListener) {
        this.mOnScrollViewChangeListener = onScrollViewChangeListener;
    }
}
