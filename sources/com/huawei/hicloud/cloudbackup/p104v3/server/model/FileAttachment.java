package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class FileAttachment extends C11707b {

    @InterfaceC4648p
    private String packageName;

    @InterfaceC4648p
    private String packageOriginHash;

    @InterfaceC4648p
    private String packageOriginHashType;

    @InterfaceC4648p
    private String packageOriginLength;

    @InterfaceC4648p
    private String packageSsha2;

    @InterfaceC4648p
    private String packageVersion;

    public String getPackageName() {
        return this.packageName;
    }

    public String getPackageOriginHash() {
        return this.packageOriginHash;
    }

    public String getPackageOriginHashType() {
        return this.packageOriginHashType;
    }

    public String getPackageOriginLength() {
        return this.packageOriginLength;
    }

    public String getPackageSsha2() {
        return this.packageSsha2;
    }

    public String getPackageVersion() {
        return this.packageVersion;
    }

    public FileAttachment setPackageName(String str) {
        this.packageName = str;
        return this;
    }

    public FileAttachment setPackageOriginHash(String str) {
        this.packageOriginHash = str;
        return this;
    }

    public FileAttachment setPackageOriginHashType(String str) {
        this.packageOriginHashType = str;
        return this;
    }

    public FileAttachment setPackageOriginLength(String str) {
        this.packageOriginLength = str;
        return this;
    }

    public FileAttachment setPackageSsha2(String str) {
        this.packageSsha2 = str;
        return this;
    }

    public FileAttachment setPackageVersion(String str) {
        this.packageVersion = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public FileAttachment set(String str, Object obj) {
        return (FileAttachment) super.set(str, obj);
    }
}
