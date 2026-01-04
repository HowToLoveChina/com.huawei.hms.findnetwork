package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.beans.base.RspBean;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class Ad30 extends RspBean {
    private String brsetting;
    private String configMap;
    private List<Content> content;

    @InterfaceC6934f
    private List<Content> contentFiltered;

    /* renamed from: fc */
    private FlowControl f32006fc;
    private List<ImpEX> impEXs;
    private String slotid;
    private int retcode30 = -1;
    private int adtype = -1;

    /* renamed from: a */
    public String m39419a() {
        return this.slotid;
    }

    /* renamed from: b */
    public int m39424b() {
        return this.retcode30;
    }

    /* renamed from: c */
    public List<Content> m39428c() {
        return this.content;
    }

    /* renamed from: d */
    public int m39431d() {
        return this.adtype;
    }

    /* renamed from: e */
    public String m39432e() {
        return this.brsetting;
    }

    /* renamed from: f */
    public List<ImpEX> m39433f() {
        return this.impEXs;
    }

    /* renamed from: g */
    public String m39434g() {
        return this.configMap;
    }

    /* renamed from: h */
    public List<Content> m39435h() {
        return this.contentFiltered;
    }

    /* renamed from: i */
    public FlowControl m39436i() {
        return this.f32006fc;
    }

    /* renamed from: a */
    public void m39420a(int i10) {
        this.retcode30 = i10;
    }

    /* renamed from: b */
    public void m39425b(int i10) {
        this.adtype = i10;
    }

    /* renamed from: c */
    public void m39429c(String str) {
        this.configMap = str;
    }

    /* renamed from: a */
    public void m39421a(FlowControl flowControl) {
        this.f32006fc = flowControl;
    }

    /* renamed from: b */
    public void m39426b(String str) {
        this.brsetting = str;
    }

    /* renamed from: c */
    public void m39430c(List<Content> list) {
        this.contentFiltered = list;
    }

    /* renamed from: a */
    public void m39422a(String str) {
        this.slotid = str;
    }

    /* renamed from: b */
    public void m39427b(List<ImpEX> list) {
        this.impEXs = list;
    }

    /* renamed from: a */
    public void m39423a(List<Content> list) {
        this.content = list;
    }
}
