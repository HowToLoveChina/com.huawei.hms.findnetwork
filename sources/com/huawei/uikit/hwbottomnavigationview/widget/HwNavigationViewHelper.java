package com.huawei.uikit.hwbottomnavigationview.widget;

import android.content.Context;
import android.view.Menu;
import android.view.View;
import com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class HwNavigationViewHelper {
    public static void changeItem(HwBottomNavigationView.BottomNavigationItemView bottomNavigationItemView, boolean z10, boolean z11, HwBottomNavigationView.BottomNavListener bottomNavListener, Menu menu) {
        if (bottomNavigationItemView == null || menu == null) {
            return;
        }
        int itemIndex = bottomNavigationItemView.getItemIndex();
        boolean isChecked = bottomNavigationItemView.getIsChecked();
        if (z10) {
            if (isChecked) {
                bottomNavigationItemView.setChecked(false, false);
                if (bottomNavListener != null) {
                    bottomNavListener.onBottomNavItemUnselected(menu.getItem(itemIndex), itemIndex);
                    return;
                }
                return;
            }
            bottomNavigationItemView.setChecked(true, false);
            if (bottomNavListener != null) {
                bottomNavListener.onBottomNavItemSelected(menu.getItem(itemIndex), itemIndex);
                return;
            }
            return;
        }
        if (z11) {
            bottomNavigationItemView.setChecked(true, false);
            if (isChecked || bottomNavListener == null) {
                return;
            }
            bottomNavListener.onBottomNavItemSelected(menu.getItem(itemIndex), itemIndex);
            return;
        }
        bottomNavigationItemView.setChecked(false, false);
        if (!isChecked || bottomNavListener == null) {
            return;
        }
        bottomNavListener.onBottomNavItemUnselected(menu.getItem(itemIndex), itemIndex);
    }

    public static void setValueFromPlume(Context context, HwBottomNavigationView hwBottomNavigationView) {
        if (context == null || hwBottomNavigationView == null) {
            return;
        }
        Method method = HwReflectUtil.getMethod("getBoolean", new Class[]{Context.class, View.class, String.class, Boolean.TYPE}, "huawei.android.widget.HwPlume");
        if (method == null) {
            hwBottomNavigationView.setExtendedNextTabEnabled(true, true);
            hwBottomNavigationView.setExtendedNextTabEnabled(false, true);
            return;
        }
        Boolean bool = Boolean.TRUE;
        Object objInvokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{context, hwBottomNavigationView, "switchTabEnabled", bool});
        if (objInvokeMethod instanceof Boolean) {
            hwBottomNavigationView.setExtendedNextTabEnabled(true, ((Boolean) objInvokeMethod).booleanValue());
        } else {
            hwBottomNavigationView.setExtendedNextTabEnabled(true, true);
        }
        Object objInvokeMethod2 = HwReflectUtil.invokeMethod(null, method, new Object[]{context, hwBottomNavigationView, "switchTabWhenFocusedEnabled", bool});
        if (objInvokeMethod2 instanceof Boolean) {
            hwBottomNavigationView.setExtendedNextTabEnabled(false, ((Boolean) objInvokeMethod2).booleanValue());
        } else {
            hwBottomNavigationView.setExtendedNextTabEnabled(false, true);
        }
    }
}
