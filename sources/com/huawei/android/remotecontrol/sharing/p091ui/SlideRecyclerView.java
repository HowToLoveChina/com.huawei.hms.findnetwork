package com.huawei.android.remotecontrol.sharing.p091ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import p783xp.C13843a;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class SlideRecyclerView extends RecyclerView {
    private static final int CHILD_COUNT = 2;
    private static final int INVALID_CHILD_WIDTH = -1;
    private static final int INVALID_POSITION = -1;
    private static final int SNAP_VELOCITY = 600;
    private static final String TAG = "SlideRecyclerView";
    private final boolean isRtl;
    private ViewGroup mChildView;
    private float mFirstX;
    private float mFirstY;
    private boolean mIsSlide;
    private float mLastX;
    private int mMenuViewWidth;
    private final Scroller mScroller;
    private Rect mTouchFrame;
    private int mTouchPosition;
    private VelocityTracker mVelocityTracker;
    private final int touchMinDistance;

    public SlideRecyclerView(Context context) {
        this(context, null);
    }

    private int getPositionByAxis(int i10, int i11) {
        if (getLayoutManager() == null) {
            C13981a.m83988e(TAG, "getLayoutManager null");
            return -1;
        }
        int iFindFirstVisibleItemPosition = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            rect = new Rect();
            this.mTouchFrame = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i10, i11)) {
                    return iFindFirstVisibleItemPosition + childCount;
                }
            }
        }
        return -1;
    }

    private boolean isLateralSlide(float f10, float f11, int i10, int i11) {
        if (Math.abs(f10) <= 600.0f || Math.abs(f10) <= Math.abs(f11)) {
            float f12 = i10;
            if (Math.abs(f12 - this.mFirstX) < this.touchMinDistance || Math.abs(f12 - this.mFirstX) <= Math.abs(i11 - this.mFirstY)) {
                return false;
            }
        }
        return true;
    }

    private void obtainVelocity(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void scrollChild(float f10) {
        if (this.isRtl) {
            if (this.mChildView.getScrollX() + f10 < (-this.mMenuViewWidth) || this.mChildView.getScrollX() + f10 >= 0.0f) {
                return;
            }
            this.mChildView.scrollBy((int) f10, 0);
            return;
        }
        if (this.mChildView.getScrollX() + f10 > this.mMenuViewWidth || this.mChildView.getScrollX() + f10 <= 0.0f) {
            return;
        }
        this.mChildView.scrollBy((int) f10, 0);
    }

    private void startScroll(int i10) {
        if (this.mVelocityTracker.getXVelocity() < -600.0f) {
            Scroller scroller = this.mScroller;
            int i11 = this.mMenuViewWidth;
            scroller.startScroll(i10, 0, i11 - i10, 0, Math.abs(i11 - i10));
        } else {
            if (this.mVelocityTracker.getXVelocity() >= 600.0f) {
                this.mScroller.startScroll(i10, 0, -i10, 0, Math.abs(i10));
                return;
            }
            int i12 = this.mMenuViewWidth;
            if (i10 >= i12 / 2) {
                this.mScroller.startScroll(i10, 0, i12 - i10, 0, Math.abs(i12 - i10));
            } else {
                this.mScroller.startScroll(i10, 0, -i10, 0, Math.abs(i10));
            }
        }
    }

    private void startScrollInRtl(int i10) {
        if (this.mVelocityTracker.getXVelocity() > 600.0f) {
            Scroller scroller = this.mScroller;
            int i11 = this.mMenuViewWidth;
            scroller.startScroll(i10, 0, (-i11) - i10, 0, Math.abs(i11 - i10));
        } else {
            if (this.mVelocityTracker.getXVelocity() <= -600.0f) {
                this.mScroller.startScroll(i10, 0, -i10, 0, Math.abs(i10));
                return;
            }
            int i12 = this.mMenuViewWidth;
            if (i10 <= (-i12) / 2) {
                this.mScroller.startScroll(i10, 0, (-i12) - i10, 0, Math.abs(i12 - i10));
            } else {
                this.mScroller.startScroll(i10, 0, -i10, 0, Math.abs(i10));
            }
        }
    }

    public void closeMenu() {
        ViewGroup viewGroup = this.mChildView;
        if (viewGroup == null || viewGroup.getScrollX() == 0) {
            return;
        }
        this.mChildView.scrollTo(0, 0);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.mChildView.scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            invalidate();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        obtainVelocity(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            float f10 = x10;
            this.mLastX = f10;
            this.mFirstX = f10;
            this.mFirstY = y10;
            int positionByAxis = getPositionByAxis(x10, y10);
            this.mTouchPosition = positionByAxis;
            if (positionByAxis != -1) {
                ViewGroup viewGroup = this.mChildView;
                View childAt = getChildAt(positionByAxis - ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition());
                if (childAt instanceof ViewGroup) {
                    this.mChildView = (ViewGroup) childAt;
                }
                if (viewGroup != null && this.mChildView != viewGroup && viewGroup.getScrollX() != 0) {
                    viewGroup.scrollTo(0, 0);
                }
                if (this.mChildView.getChildCount() == 2) {
                    this.mMenuViewWidth = this.mChildView.getChildAt(1).getWidth();
                } else {
                    this.mMenuViewWidth = -1;
                }
            }
        } else if (action == 1) {
            releaseVelocityTracker();
        } else if (action == 2) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            if (isLateralSlide(this.mVelocityTracker.getXVelocity(), this.mVelocityTracker.getYVelocity(), x10, y10)) {
                this.mIsSlide = true;
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsSlide || this.mTouchPosition == -1) {
            closeMenu();
            releaseVelocityTracker();
            return super.onTouchEvent(motionEvent);
        }
        float x10 = motionEvent.getX();
        obtainVelocity(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            if (this.mMenuViewWidth != -1) {
                int scrollX = this.mChildView.getScrollX();
                this.mVelocityTracker.computeCurrentVelocity(1000);
                if (this.isRtl) {
                    startScrollInRtl(scrollX);
                } else {
                    startScroll(scrollX);
                }
                invalidate();
            }
            this.mMenuViewWidth = -1;
            this.mIsSlide = false;
            this.mTouchPosition = -1;
            releaseVelocityTracker();
        } else if (action == 2 && this.mMenuViewWidth != -1) {
            scrollChild(this.mLastX - x10);
            this.mLastX = x10;
        }
        return true;
    }

    public SlideRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mScroller = new Scroller(context);
        this.touchMinDistance = ViewConfiguration.get(context).getScaledTouchSlop();
        this.isRtl = C13843a.m83071W(context);
    }
}
