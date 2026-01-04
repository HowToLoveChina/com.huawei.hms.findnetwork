package com.huawei.skytone.servicehub.model.schema;

import java.util.function.Supplier;

/* renamed from: com.huawei.skytone.servicehub.model.schema.b */
/* loaded from: classes5.dex */
public class C8690b {
    protected Class<? extends Supplier> creator;
    protected Class<?> group;
    protected Class<?> impl;
    protected boolean isSingleton;

    public C8690b() {
    }

    public Class<? extends Supplier> getCreator() {
        return this.creator;
    }

    public Class<?> getGroup() {
        return this.group;
    }

    public Class<?> getImpl() {
        return this.impl;
    }

    public boolean isSingleton() {
        return this.isSingleton;
    }

    public C8690b(Class<?> cls, Class<?> cls2, boolean z10, Class<? extends Supplier> cls3) {
        this.group = cls;
        this.impl = cls2;
        this.isSingleton = z10;
        this.creator = cls3;
    }
}
