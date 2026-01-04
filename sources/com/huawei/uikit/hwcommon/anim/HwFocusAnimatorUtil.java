package com.huawei.uikit.hwcommon.anim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import com.huawei.uikit.hwcommon.C8709R;

/* loaded from: classes7.dex */
public class HwFocusAnimatorUtil {

    /* renamed from: a */
    private static final String f42009a = "HwFocusAnimatorUtil";

    /* renamed from: b */
    private static final int f42010b = 0;

    /* renamed from: c */
    private static int f42011c;

    private HwFocusAnimatorUtil() {
    }

    public static void disableViewClipChildren(ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    public static int getFocusedPathPadding(Context context) throws Resources.NotFoundException {
        int i10 = f42011c;
        if (i10 != 0) {
            return i10;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C8709R.dimen.hwcommon_focused_path_padding);
        f42011c = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public static void resetOutlinePath(Context context, ViewOutlineProvider viewOutlineProvider, View view, Rect rect, Path path) {
        resetOutlinePath(viewOutlineProvider, view, getFocusedPathPadding(context), rect, path);
    }

    public static void resetOutlinePath(ViewOutlineProvider viewOutlineProvider, View view, int i10, Rect rect, Path path) {
        if (viewOutlineProvider != null && view != null && path != null && rect != null) {
            Outline outline = new Outline();
            viewOutlineProvider.getOutline(view, outline);
            float radius = outline.getRadius();
            Rect rect2 = new Rect();
            outline.getRect(rect2);
            Rect rect3 = new Rect(rect2.left - i10, rect2.top - i10, rect2.right + i10, rect2.bottom + i10);
            if (rect3.equals(rect)) {
                return;
            }
            RectF rectF = new RectF(rect3.left, rect3.top, rect3.right, rect3.bottom);
            if (Float.compare(radius, 0.0f) != 0) {
                radius += i10;
            }
            path.reset();
            path.addRoundRect(rectF, radius, radius, Path.Direction.CW);
            rect.left = rect3.left;
            rect.top = rect3.top;
            rect.right = rect3.right;
            rect.bottom = rect3.bottom;
            return;
        }
        Log.e(f42009a, "HwFocusAnimatorUtil::resetOutlinePath: params is null");
    }
}
