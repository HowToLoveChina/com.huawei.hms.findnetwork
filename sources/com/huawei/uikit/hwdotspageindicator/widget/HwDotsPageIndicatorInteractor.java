package com.huawei.uikit.hwdotspageindicator.widget;

/* loaded from: classes7.dex */
public class HwDotsPageIndicatorInteractor {
    public static final int INDICATOR_DRAGGING = 1;
    public static final int INDICATOR_IDLE = 3;

    @Deprecated
    public static final int INDICATOR_SETTLING = 2;
    public static final int VISIBLE_ANIMATION_FINISH = 2;
    public static final int VISIBLE_ANIMATION_RUNNING = 1;
    public static final int VISIBLE_ANIMATION_WAITING = 0;

    public interface OnClickListener {
        void onClick(int i10, int i11);
    }

    public interface OnGestureListener {
        void onDragging(float f10, int i10, int i11);

        void onLongPress(int i10);

        void onOverDrag(float f10);
    }

    public interface OnMouseOperationListener {
        void onDotClick(int i10, int i11);

        void onFocusAnimationProgress(float f10);

        void onMoveInHotZone(int i10);
    }
}
