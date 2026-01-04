package com.huawei.fastsdk;

import java.util.Map;

/* loaded from: classes5.dex */
public interface IElement {
    void actionResult(Map<String, Object> map, Map<Object, Object> map2, String str);

    Object execExpression(String str);

    void notifyDataChange();

    void notifyItemChanged(int i10);
}
