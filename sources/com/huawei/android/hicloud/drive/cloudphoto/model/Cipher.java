package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.model.KeyChain;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Cipher extends C11707b {
    public static final int DATA_TYPE_BACKUP = 1;
    public static final int DATA_TYPE_CLOUD_PHOTO = 12;
    public static final int DATA_TYPE_FIND_DEVICE = 10;
    public static final int DATA_TYPE_SYNC = 0;
    public static final int DATA_TYPE_SYNC_DISK = 11;
    public static final String ENCRYPTED_DATA_CONTENT_SEPARATOR = "|";
    public static final String ENCRYPTED_DATA_PREFIX = "#";
    public static final int ENCRYPTED_DATA_VERSION_TYPE_CLIENT_AES_CBC = 3;

    @InterfaceC4648p
    private String algorithm;

    @InterfaceC4648p
    private Integer dataType;

    /* renamed from: iv */
    @InterfaceC4648p
    private String f12220iv;

    @InterfaceC4648p
    private List<KeyChain> keychains;

    public String getAlgorithm() {
        return this.algorithm;
    }

    public Integer getDataType() {
        return this.dataType;
    }

    public String getIv() {
        return this.f12220iv;
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
        this.f12220iv = str;
    }

    public void setKeyChains(List<KeyChain> list) {
        this.keychains = list;
    }
}
