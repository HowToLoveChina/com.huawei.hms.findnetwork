package com.huawei.hicloud.request.appmashup.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.util.List;

/* renamed from: com.huawei.hicloud.request.appmashup.bean.c */
/* loaded from: classes6.dex */
public class C4984c {

    /* renamed from: a */
    @SerializedName("provider")
    private String f22801a;

    /* renamed from: b */
    @SerializedName("endpoint")
    private String f22802b;

    /* renamed from: c */
    @SerializedName("authType")
    private int f22803c;

    /* renamed from: d */
    @SerializedName("params")
    private List<String> f22804d;

    /* renamed from: e */
    @SerializedName(ParamConstants.Param.CONTEXT)
    private String f22805e;

    /* renamed from: a */
    public int m30014a() {
        return this.f22803c;
    }

    /* renamed from: b */
    public String m30015b() {
        return this.f22802b;
    }

    /* renamed from: c */
    public List<String> m30016c() {
        return this.f22804d;
    }

    /* renamed from: d */
    public String m30017d() {
        return this.f22801a;
    }

    /* renamed from: e */
    public String m30018e() {
        return this.f22805e;
    }

    /* renamed from: f */
    public void m30019f(int i10) {
        this.f22803c = i10;
    }

    /* renamed from: g */
    public void m30020g(String str) {
        this.f22802b = str;
    }

    /* renamed from: h */
    public void m30021h(List<String> list) {
        this.f22804d = list;
    }

    /* renamed from: i */
    public void m30022i(String str) {
        this.f22801a = str;
    }

    /* renamed from: j */
    public void m30023j(String str) {
        this.f22805e = str;
    }
}
