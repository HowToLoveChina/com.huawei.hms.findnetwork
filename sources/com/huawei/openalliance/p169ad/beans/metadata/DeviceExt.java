package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class DeviceExt {
    private List<String> aVideoCodec;
    private String bootMark;
    private String updateMark;

    /* renamed from: a */
    public List<String> m40159a() {
        return this.aVideoCodec;
    }

    /* renamed from: b */
    public String m40162b() {
        return this.bootMark;
    }

    /* renamed from: c */
    public String m40164c() {
        return this.updateMark;
    }

    /* renamed from: a */
    public void m40160a(String str) {
        this.bootMark = str;
    }

    /* renamed from: b */
    public void m40163b(String str) {
        this.updateMark = str;
    }

    /* renamed from: a */
    public void m40161a(List<String> list) {
        this.aVideoCodec = list;
    }
}
