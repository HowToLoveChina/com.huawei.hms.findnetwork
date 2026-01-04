package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class CustomViewPager extends ViewPager {
    private static final String TAG = "CustomViewPager";
    private boolean enableScroll;
    private boolean isMainRecommendTwoCards;
    private boolean isOnLayout;
    private ViewPager.InterfaceC0980i mOnPageChangeListener;
    private final UpdateItemHandler mUpdateItemHandler;

    public class UpdateItemHandler extends Handler {
        private static final int DELAYED_TIME = 100;
        private static final int MSG_UPDATE_ITEM = 100;

        private UpdateItemHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            if (message.what == 100) {
                int i10 = message.arg1;
                boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                C11839m.m70686d(CustomViewPager.TAG, "handleMessage setCurrentItem item" + i10 + " smoothScroll:" + zBooleanValue);
                CustomViewPager.this.setViewPagerCurrentItem(i10, zBooleanValue);
            }
        }

        public void sendUpdateItemMsg(int i10, boolean z10) {
            removeMessages(100);
            Message messageObtainMessage = obtainMessage(100);
            messageObtainMessage.arg1 = i10;
            messageObtainMessage.obj = Boolean.valueOf(z10);
            sendMessageDelayed(messageObtainMessage, 100L);
        }
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enableScroll = false;
        this.mUpdateItemHandler = new UpdateItemHandler();
        this.isOnLayout = false;
        this.isMainRecommendTwoCards = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewPagerCurrentItem(int i10, boolean z10) throws Resources.NotFoundException {
        super.setCurrentItem(i10, z10);
        C11839m.m70686d(TAG, "setViewPagerCurrentItem isOnLayout:" + this.isOnLayout + "|item:" + i10);
        if (this.isOnLayout) {
            return;
        }
        ViewPager.InterfaceC0980i interfaceC0980i = this.mOnPageChangeListener;
        if (interfaceC0980i != null) {
            interfaceC0980i.onPageScrolled(i10, 0.0f, 0);
        } else {
            C11839m.m70686d(TAG, "setViewPagerCurrentItem mOnPageChangeListener is null.");
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10 = true;
        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            z10 = false;
        }
        if ((this.isMainRecommendTwoCards && z10) || this.enableScroll) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws Resources.NotFoundException {
        super.onLayout(z10, i10, i11, i12, i13);
        this.isOnLayout = true;
        C11839m.m70686d(TAG, "onLayout:" + this.isOnLayout);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        setMeasuredDimension(i10, i11);
        super.onMeasure(i10, i11);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        super.onRestoreInstanceState(parcelable);
        C11839m.m70686d(TAG, "onRestoreInstanceState Current item:" + getCurrentItem());
        ViewPager.InterfaceC0980i interfaceC0980i = this.mOnPageChangeListener;
        if (interfaceC0980i != null) {
            interfaceC0980i.onPageScrolled(getCurrentItem(), 0.0f, 0);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10 = true;
        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            z10 = false;
        }
        if ((this.isMainRecommendTwoCards && z10) || this.enableScroll) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setCurrentItem(int i10, boolean z10, boolean z11) throws Resources.NotFoundException {
        if (z11) {
            this.mUpdateItemHandler.sendUpdateItemMsg(i10, z10);
            return;
        }
        C11839m.m70686d(TAG, "setCurrentItem item:" + i10);
        setViewPagerCurrentItem(i10, z10);
    }

    public void setMainRecommendTwoCards(boolean z10) {
        this.isMainRecommendTwoCards = z10;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.InterfaceC0980i interfaceC0980i) {
        this.mOnPageChangeListener = interfaceC0980i;
        super.setOnPageChangeListener(interfaceC0980i);
    }

    public void setScrollDisable() {
        this.enableScroll = false;
    }

    public void setScrollEnable() {
        this.enableScroll = true;
    }
}
