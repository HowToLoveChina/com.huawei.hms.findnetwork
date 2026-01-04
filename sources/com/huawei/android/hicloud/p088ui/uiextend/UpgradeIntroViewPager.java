package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class UpgradeIntroViewPager extends ViewPager {
    private static final String TAG = "UpgradeIntroViewPager";
    private Scroller mDefaultScroller;
    private FixedSpeedCustomScroller mFixedScroller;

    public static class ViewPagerPrivilegedAction implements PrivilegedAction {
        private Field mField;

        public ViewPagerPrivilegedAction(Field field) {
            this.mField = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.mField.setAccessible(true);
            return null;
        }
    }

    public UpgradeIntroViewPager(Context context, AttributeSet attributeSet) throws NoSuchFieldException {
        super(context, attributeSet);
        initScroller();
    }

    private void initScroller() throws NoSuchFieldException {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            AccessController.doPrivileged(new ViewPagerPrivilegedAction(declaredField));
            this.mDefaultScroller = (Scroller) declaredField.get(this);
            this.mFixedScroller = new FixedSpeedCustomScroller(getContext(), new AccelerateInterpolator());
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "initScroller error: " + e10.toString());
        }
    }

    public void setDefaultScroller() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            AccessController.doPrivileged(new ViewPagerPrivilegedAction(declaredField));
            declaredField.set(this, this.mDefaultScroller);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "setDefaultScroller error: " + e10.toString());
        }
    }

    public void setFixedSpeedScroller() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            AccessController.doPrivileged(new ViewPagerPrivilegedAction(declaredField));
            declaredField.set(this, this.mFixedScroller);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "setFixedSpeedScroller error: " + e10.toString());
        }
    }
}
