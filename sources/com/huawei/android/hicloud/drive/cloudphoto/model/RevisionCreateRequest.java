package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class RevisionCreateRequest extends C11707b {

    @InterfaceC4648p
    private MediaAssetAttribute attributes;

    @InterfaceC4648p
    private Cipher cipher;

    @InterfaceC4648p
    private String mimeType;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Resource resource;

    public MediaAssetAttribute getAttributes() {
        return this.attributes;
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public Resource getResource() {
        return this.resource;
    }

    public void setAttributes(MediaAssetAttribute mediaAssetAttribute) {
        this.attributes = mediaAssetAttribute;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
