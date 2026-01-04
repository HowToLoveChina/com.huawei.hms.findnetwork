package com.huawei.openalliance.p169ad.beans.server;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.base.RspBean;
import com.huawei.openalliance.p169ad.beans.metadata.Permission;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class PermissionRsp extends RspBean {
    private List<Permission> permissions;
    private int retcode = -1;

    /* renamed from: a */
    public int m40956a() {
        return this.retcode;
    }

    /* renamed from: b */
    public List<Permission> m40957b() {
        return this.permissions;
    }
}
