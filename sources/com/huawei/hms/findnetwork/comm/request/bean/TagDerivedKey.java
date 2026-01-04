package com.huawei.hms.findnetwork.comm.request.bean;

import java.util.List;

/* loaded from: classes8.dex */
public class TagDerivedKey {
    private List<PubKeyHash> mPubKeyList;
    private String pairingKeyData;

    /* renamed from: sn */
    private String f24744sn;

    public TagDerivedKey(String str, List<PubKeyHash> list, String str2) {
        this.f24744sn = str;
        this.mPubKeyList = list;
        this.pairingKeyData = str2;
    }

    public String getPairingKeyData() {
        return this.pairingKeyData;
    }

    public List<PubKeyHash> getPubKeyList() {
        return this.mPubKeyList;
    }

    public String getSn() {
        return this.f24744sn;
    }

    public void setPairingKeyData(String str) {
        this.pairingKeyData = str;
    }

    public void setPubKeyList(List<PubKeyHash> list) {
        this.mPubKeyList = list;
    }

    public void setSn(String str) {
        this.f24744sn = str;
    }
}
