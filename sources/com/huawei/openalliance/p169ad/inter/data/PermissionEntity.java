package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.io.Serializable;

@OuterVisible
/* loaded from: classes2.dex */
public class PermissionEntity implements Serializable {

    /* renamed from: a */
    private String f33649a;

    /* renamed from: b */
    private int f33650b;

    @OuterVisible
    public PermissionEntity() {
    }

    public PermissionEntity(String str, int i10) {
        this.f33649a = str;
        this.f33650b = i10;
    }

    /* renamed from: a */
    public void m44542a(int i10) {
        this.f33650b = i10;
    }

    @OuterVisible
    public String getName() {
        return this.f33649a;
    }

    @OuterVisible
    public int getType() {
        return this.f33650b;
    }

    /* renamed from: a */
    public void m44543a(String str) {
        this.f33649a = str;
    }
}
