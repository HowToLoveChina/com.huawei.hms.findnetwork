package com.huawei.hicloud.base.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class KeyChain extends C11707b {
    public static final int TYPE_EFEK = 1;
    public static final int TYPE_SERVERKEY = 4;
    public static final int TYPE_SFEK = 3;
    public static final int TYPE_ZFEK = 2;

    @InterfaceC4648p
    private String algorithm;

    @InterfaceC4648p
    private String ekey;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22147id;

    @InterfaceC4648p
    private Integer type;

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getEkey() {
        return this.ekey;
    }

    public String getId() {
        return this.f22147id;
    }

    public Integer getType() {
        return this.type;
    }

    public void setAlgorithm(String str) {
        this.algorithm = str;
    }

    public void setEkey(String str) {
        this.ekey = str;
    }

    public void setId(String str) {
        this.f22147id = str;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
