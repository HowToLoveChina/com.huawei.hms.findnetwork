package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* loaded from: classes8.dex */
public class ConnectInfo implements IMessageEntity {

    /* renamed from: a */
    @Packed
    private List<String> f29785a;

    /* renamed from: b */
    @Packed
    private List<Scope> f29786b;

    /* renamed from: c */
    @Packed
    private String f29787c;

    /* renamed from: d */
    @Packed
    private String f29788d;

    public ConnectInfo() {
    }

    public List<String> getApiNameList() {
        return this.f29785a;
    }

    public String getFingerprint() {
        return this.f29787c;
    }

    public List<Scope> getScopeList() {
        return this.f29786b;
    }

    public String getSubAppID() {
        return this.f29788d;
    }

    public void setApiNameList(List<String> list) {
        this.f29785a = list;
    }

    public void setFingerprint(String str) {
        this.f29787c = str;
    }

    public void setScopeList(List<Scope> list) {
        this.f29786b = list;
    }

    public void setSubAppID(String str) {
        this.f29788d = str;
    }

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.f29785a = list;
        this.f29786b = list2;
        this.f29787c = str;
        this.f29788d = str2;
    }
}
