package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class RevisionCreate extends C11707b {

    @InterfaceC4648p
    private Cipher cipher;

    @InterfaceC4648p
    private String mimeType;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private ResourceCreate resource;

    public Cipher getCipher() {
        return this.cipher;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public ResourceCreate getResource() {
        return this.resource;
    }

    public RevisionCreate setCipher(Cipher cipher) {
        this.cipher = cipher;
        return this;
    }

    public RevisionCreate setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public RevisionCreate setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public RevisionCreate setResource(ResourceCreate resourceCreate) {
        this.resource = resourceCreate;
        return this;
    }

    public static class ResourceCreate extends C11707b {

        @InterfaceC4648p
        private String hash;

        @InterfaceC4648p
        private Long length;

        @InterfaceC4648p
        private Map<String, String> properties;

        @InterfaceC4648p
        private String sha256;

        public String getHash() {
            return this.hash;
        }

        public Long getLength() {
            return this.length;
        }

        public Map<String, String> getProperties() {
            return this.properties;
        }

        public String getSha256() {
            return this.sha256;
        }

        public ResourceCreate setHash(String str) {
            this.hash = str;
            return this;
        }

        public ResourceCreate setLength(Long l10) {
            this.length = l10;
            return this;
        }

        public ResourceCreate setProperties(Map<String, String> map) {
            this.properties = map;
            return this;
        }

        public ResourceCreate setSha256(String str) {
            this.sha256 = str;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public ResourceCreate set(String str, Object obj) {
            return (ResourceCreate) super.set(str, obj);
        }
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public RevisionCreate set(String str, Object obj) {
        return (RevisionCreate) super.set(str, obj);
    }
}
