package com.huawei.fastengine.fastview.weakup;

import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;

/* loaded from: classes5.dex */
public class WeakUpManagement {
    private static final int REPEAT_CALL_TIME = 2000;
    private static final Object SHORT_CUT_LOCKER = new Object();
    private static volatile WeakUpManagement weakUpManagement;
    private WeakUpCallback weakUpCallback = null;
    private Long lastWeakUpTime = 0L;

    public static WeakUpManagement getInstance() {
        if (weakUpManagement == null) {
            synchronized (SHORT_CUT_LOCKER) {
                try {
                    if (weakUpManagement == null) {
                        weakUpManagement = new WeakUpManagement();
                    }
                } finally {
                }
            }
        }
        return weakUpManagement;
    }

    public boolean isRepeatCall() {
        return Math.abs(this.lastWeakUpTime.longValue() - System.currentTimeMillis()) <= RippleView.SINGLE_RIPPLE_TIME;
    }

    public void jumpActivityCallback(boolean z10) {
        WeakUpCallback weakUpCallback = this.weakUpCallback;
        if (weakUpCallback != null) {
            weakUpCallback.onResult(z10);
        }
    }

    public void registerCallback(WeakUpCallback weakUpCallback) {
        this.weakUpCallback = weakUpCallback;
        this.lastWeakUpTime = Long.valueOf(System.currentTimeMillis());
    }
}
