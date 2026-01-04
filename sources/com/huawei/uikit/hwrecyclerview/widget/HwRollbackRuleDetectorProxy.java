package com.huawei.uikit.hwrecyclerview.widget;

import android.view.MotionEvent;
import android.view.View;
import com.huawei.uikit.hwrecyclerview.widget.HwRollbackRuleDetector;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class HwRollbackRuleDetectorProxy {

    /* renamed from: a */
    private HwRollbackRuleDetector f43917a;

    public HwRollbackRuleDetectorProxy(HwRollbackRuleDetector.RollBackScrollListener rollBackScrollListener) {
        this.f43917a = new HwRollbackRuleDetector(rollBackScrollListener);
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        HwRollbackRuleDetector hwRollbackRuleDetector = this.f43917a;
        if (hwRollbackRuleDetector != null) {
            hwRollbackRuleDetector.onTouchEvent(motionEvent);
        }
    }

    public void postScrollUsedEvent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HwRollbackRuleDetector hwRollbackRuleDetector = this.f43917a;
        if (hwRollbackRuleDetector != null) {
            hwRollbackRuleDetector.postEvent(HwRollbackRuleDetector.ROLLBACK_USED_EVENT);
        }
    }

    public void start(View view) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        HwRollbackRuleDetector hwRollbackRuleDetector = this.f43917a;
        if (hwRollbackRuleDetector != null) {
            hwRollbackRuleDetector.start(view);
        }
    }

    public void stop() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HwRollbackRuleDetector hwRollbackRuleDetector = this.f43917a;
        if (hwRollbackRuleDetector != null) {
            hwRollbackRuleDetector.stop();
        }
    }
}
