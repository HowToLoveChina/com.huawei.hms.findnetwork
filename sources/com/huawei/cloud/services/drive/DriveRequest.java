package com.huawei.cloud.services.drive;

import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import p614ri.AbstractC12513b;

/* loaded from: classes5.dex */
public abstract class DriveRequest<T> extends AbstractC12513b<T> {

    @InterfaceC4648p
    private String fields;

    @InterfaceC4648p
    private String form;

    @InterfaceC4648p
    private Boolean prettyPrint;

    @InterfaceC4648p
    private String quotaId;

    public DriveRequest(Drive drive, String str, String str2, Object obj, Class<T> cls) {
        super(drive, str, str2, obj, cls);
        setDisableGZip(true);
    }

    public String getFields() {
        return this.fields;
    }

    public String getForm() {
        return this.form;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public String getQuotaId() {
        return this.quotaId;
    }

    /* renamed from: setFields */
    public DriveRequest<T> setFields2(String str) {
        this.fields = str;
        return this;
    }

    /* renamed from: setForm */
    public DriveRequest<T> setForm2(String str) {
        this.form = str;
        return this;
    }

    /* renamed from: setPrettyPrint */
    public DriveRequest<T> setPrettyPrint2(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    /* renamed from: setQuotaId */
    public DriveRequest<T> setQuotaId2(String str) {
        this.quotaId = str;
        return this;
    }

    @Override // p614ri.AbstractC12513b, p579qi.AbstractC12361b
    public final Drive getAbstractClient() {
        return (Drive) super.getAbstractClient();
    }

    @Override // p614ri.AbstractC12513b, p579qi.AbstractC12361b
    public DriveRequest<T> setDisableGZip(boolean z10) {
        return (DriveRequest) super.setDisableGZip(z10);
    }

    @Override // p614ri.AbstractC12513b, p579qi.AbstractC12361b
    public DriveRequest<T> setHeaders(C4609l c4609l) {
        return (DriveRequest) super.setHeaders(c4609l);
    }

    @Override // p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
    public DriveRequest<T> set(String str, Object obj) {
        return (DriveRequest) super.set(str, obj);
    }
}
