package com.huawei.hicloud.base.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Cipher extends C11707b {

    @InterfaceC4648p
    private String algorithm;

    @InterfaceC4648p
    private Integer dataType;

    /* renamed from: iv */
    @InterfaceC4648p
    private String f22146iv;

    @InterfaceC4648p
    private List<KeyChain> keychains;

    public String getAlgorithm() {
        return this.algorithm;
    }

    public Integer getDataType() {
        return this.dataType;
    }

    public String getIv() {
        return this.f22146iv;
    }

    public List<KeyChain> getKeyChains() {
        return this.keychains;
    }

    public void setAlgorithm(String str) {
        this.algorithm = str;
    }

    public void setDataType(Integer num) {
        this.dataType = num;
    }

    public void setIv(String str) {
        this.f22146iv = str;
    }

    public void setKeyChains(List<KeyChain> list) {
        this.keychains = list;
    }
}
