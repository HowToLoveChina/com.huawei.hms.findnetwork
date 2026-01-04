package com.huawei.hms.ads.uiengine.common;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.download.app.AppStatus;

@OuterVisible
/* loaded from: classes8.dex */
public interface IProgressButton {

    public interface ProgressButtonResetListener {
        void onSizeReset(int i10, int i11);
    }

    int getCancelBtnHeight(int i10);

    int getProgress();

    View getProgressBtn();

    Drawable getProgressDrawable();

    Rect getPromptRect();

    AppStatus getStatus();

    CharSequence getText();

    void incrementProgressBy(int i10);

    boolean isFastClick();

    void setCancelBtnHeight(int i10);

    void setFixedWidth(boolean z10);

    void setFontFamily(String str);

    void setMax(int i10);

    void setMaxWidth(int i10);

    void setMinWidth(int i10);

    void setPaintTypeface(Typeface typeface);

    void setPaintTypeface(Typeface typeface, int i10);

    void setProgress(int i10);

    void setProgressDrawable(Drawable drawable);

    void setProgressDrawable(Drawable drawable, int i10);

    void setResetListener(ProgressButtonResetListener progressButtonResetListener);

    void setResetWidth(boolean z10);

    void setShowCancelBtn(boolean z10);

    void setText(CharSequence charSequence);

    void setTextColor(int i10);

    void setTextInner(CharSequence charSequence, boolean z10);

    void setTextSize(float f10);

    void updateLayoutHeight();
}
