package com.huawei.fastengine.fastview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

/* loaded from: classes5.dex */
public class FastView extends FrameLayout {
    private static final String TAG = "FastSDKEngine";
    private FastViewInstance mFastViewInstance;

    public FastView(Context context) {
        super(context);
    }

    public void render(FastViewInstance fastViewInstance) {
        render(fastViewInstance, null);
    }

    public FastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void render(FastViewInstance fastViewInstance, String str) {
        Log.i(TAG, "begin render");
        this.mFastViewInstance = fastViewInstance;
        fastViewInstance.attachRootView(this);
        this.mFastViewInstance.render(str);
    }

    public FastView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
