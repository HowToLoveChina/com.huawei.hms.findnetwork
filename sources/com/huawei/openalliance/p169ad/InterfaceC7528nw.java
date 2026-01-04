package com.huawei.openalliance.p169ad;

import android.location.Location;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.inter.data.BannerSize;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8115h;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.nw */
/* loaded from: classes8.dex */
public interface InterfaceC7528nw<V extends InterfaceC8115h> {
    /* renamed from: a */
    void mo45904a(Location location);

    /* renamed from: a */
    void mo45905a(RequestOptions requestOptions);

    /* renamed from: a */
    void mo45906a(C7302e c7302e);

    /* renamed from: a */
    void mo45907a(Integer num);

    /* renamed from: a */
    void mo45908a(String str, int i10, List<String> list, int i11);

    /* renamed from: a */
    boolean mo45909a();

    /* renamed from: a */
    boolean mo45910a(BannerSize bannerSize, float f10);

    /* renamed from: b */
    void mo45911b(Integer num);

    /* renamed from: b */
    void mo45912b(String str);
}
