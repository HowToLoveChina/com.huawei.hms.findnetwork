package com.huawei.hwcloudjs.core;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcloudjs.p164f.C6659d;

/* renamed from: com.huawei.hwcloudjs.core.b */
/* loaded from: classes8.dex */
public class C6624b {

    /* renamed from: a */
    private static final String f30806a = "JsArguments";

    /* renamed from: a */
    public <T> T m37769a(String str, Class<T> cls) {
        if (str != null && cls != null) {
            try {
                return (T) new GsonBuilder().create().fromJson(str, (Class) cls);
            } catch (JsonSyntaxException unused) {
                C6659d.m37881b(f30806a, "JsonSyntaxException", true);
            }
        }
        return null;
    }

    /* renamed from: a */
    public <T> String m37770a(T t10) {
        return new GsonBuilder().setExclusionStrategies(new C6621a()).create().toJson(t10);
    }
}
