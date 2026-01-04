package com.huawei.uikit.hwrecyclerview.widget;

import android.content.Context;
import com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManager;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: classes4.dex */
public class HwDeviceAdapter {

    /* renamed from: a */
    private static final int f43490a = 9;

    public HwDeviceAdapter() {
    }

    public static HwDeviceAdapter instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwDeviceAdapter.class, HwWidgetInstantiator.getCurrentType(context, 9, 1)), HwDeviceAdapter.class);
        if (objInstantiate instanceof HwDeviceAdapter) {
            return (HwDeviceAdapter) objInstantiate;
        }
        return null;
    }

    public HwLinearLayoutManager.LayoutCallback getScaleLayoutCallback(Context context) {
        return null;
    }

    public HwDeviceAdapter(Context context) {
    }
}
