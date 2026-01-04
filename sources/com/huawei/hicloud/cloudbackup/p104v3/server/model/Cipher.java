package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import android.text.TextUtils;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Cipher extends C11707b {

    @InterfaceC4648p
    private String algorithm;

    @InterfaceC4648p
    private Integer dataType;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22589id;

    /* renamed from: iv */
    @InterfaceC4648p
    private String f22590iv;

    @InterfaceC4648p("keychains")
    private List<KeyChain> keyChains;

    public Cipher copyCipherAndClearUid() {
        Cipher cipher = new Cipher();
        cipher.setAlgorithm(this.algorithm);
        cipher.setDataType(this.dataType);
        cipher.setId(this.f22589id);
        cipher.setIv(this.f22590iv);
        cipher.setKeyChains(this.keyChains);
        resetOriginalUid(cipher);
        return cipher;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public Integer getDataType() {
        return this.dataType;
    }

    public String getId() {
        return this.f22589id;
    }

    public String getIv() {
        return this.f22590iv;
    }

    public List<KeyChain> getKeyChains() {
        return this.keyChains;
    }

    public void resetOriginalUid(Cipher cipher) {
        if (cipher != null) {
            for (KeyChain keyChain : cipher.getKeyChains()) {
                if (!TextUtils.isEmpty(keyChain.getOriginalUid())) {
                    keyChain.setOriginalUid("");
                }
            }
        }
    }

    public Cipher setAlgorithm(String str) {
        this.algorithm = str;
        return this;
    }

    public Cipher setDataType(Integer num) {
        this.dataType = num;
        return this;
    }

    public Cipher setId(String str) {
        this.f22589id = str;
        return this;
    }

    public Cipher setIv(String str) {
        this.f22590iv = str;
        return this;
    }

    public Cipher setKeyChains(List<KeyChain> list) {
        this.keyChains = list;
        return this;
    }

    public static class KeyChain extends C11707b {

        @InterfaceC4648p
        private String algorithm;

        @InterfaceC4648p
        private String ekey;

        /* renamed from: id */
        @InterfaceC4648p
        private String f22591id;

        @InterfaceC4648p
        private String originalUid;

        @InterfaceC4648p
        private String seed;

        @InterfaceC4648p
        private Integer type;

        public String getAlgorithm() {
            return this.algorithm;
        }

        public String getEkey() {
            return this.ekey;
        }

        public String getId() {
            return this.f22591id;
        }

        public String getOriginalUid() {
            return this.originalUid;
        }

        public String getSeed() {
            return this.seed;
        }

        public Integer getType() {
            return this.type;
        }

        public KeyChain setAlgorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public KeyChain setEkey(String str) {
            this.ekey = str;
            return this;
        }

        public KeyChain setId(String str) {
            this.f22591id = str;
            return this;
        }

        public KeyChain setOriginalUid(String str) {
            this.originalUid = str;
            return this;
        }

        public KeyChain setSeed(String str) {
            this.seed = str;
            return this;
        }

        public KeyChain setType(Integer num) {
            this.type = num;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public KeyChain set(String str, Object obj) {
            return (KeyChain) super.set(str, obj);
        }
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Cipher set(String str, Object obj) {
        return (Cipher) super.set(str, obj);
    }
}
