package com.huawei.fastsdk;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class AbsQuickCardAction {
    public static final String FUNCTION_CALLBACK = "callback";
    public static final String FUNCTION_FAIL = "fail";
    public static final String FUNCTION_SUCCESS = "success";
    public Object data;
    public IElement element;
    protected QuickCardExtraInfo extraInfo;
    protected Map<String, Object> nativeApiMap = new HashMap();
    public Context refContext;
    public View targetView;

    public void bindTargetContext(Context context, View view, Object obj, IElement iElement) {
        this.refContext = context;
        this.data = obj;
        this.targetView = view;
        this.element = iElement;
    }

    public abstract String getName();

    public Map<String, Object> getNativeApi() {
        return this.nativeApiMap;
    }

    public QuickCardExtraInfo getQuickCardExtraInfo() {
        return this.extraInfo;
    }

    public void onActionCallback(Map<String, Object> map, Map<Object, Object> map2) {
        this.element.actionResult(map, map2, "callback");
    }

    public void onActionFail(Map<String, Object> map, Map<Object, Object> map2) {
        this.element.actionResult(map, map2, "fail");
    }

    public void onActionResult(Map<String, Object> map, Map<Object, Object> map2, String str) {
        this.element.actionResult(map, map2, str);
    }

    public void onActionSuccess(Map<String, Object> map, Map<Object, Object> map2) {
        this.element.actionResult(map, map2, "success");
    }

    public void setQuickCardExtraInfo(QuickCardExtraInfo quickCardExtraInfo) {
        this.extraInfo = quickCardExtraInfo;
    }

    public boolean shouldTriggerListener() {
        return false;
    }
}
