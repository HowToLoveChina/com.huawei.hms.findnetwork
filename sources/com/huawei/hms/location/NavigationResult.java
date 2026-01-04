package com.huawei.hms.location;

import android.os.Parcel;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationBaseResponse;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import hu.C10343b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class NavigationResult extends LocationBaseResponse {
    public static final int MAG_POSITION_IS_SUPPORT = 21;
    public static final int MAG_POSITION_NOT_SUPPORT = 22;
    private Map<String, Object> extras;
    private int possibility;
    private int state;

    public NavigationResult() {
        this.state = -1;
        this.possibility = -1;
    }

    private Map<String, Object> getExtras() {
        return this.extras;
    }

    private void setExtras(Map<String, Object> map) {
        this.extras = map;
    }

    public final int getPossibility() {
        return this.possibility;
    }

    public final int getState() {
        return this.state;
    }

    public void setPossibility(int i10) throws ApiException {
        if (i10 > 100 || i10 < 0) {
            throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        }
        this.possibility = i10;
    }

    public void setState(int i10) {
        this.state = i10;
    }

    public NavigationResult(Parcel parcel) {
        this.state = -1;
        this.possibility = -1;
        this.state = parcel.readInt();
        this.possibility = parcel.readInt();
        this.extras = new HashMap();
        C10343b c10343b = new C10343b(parcel.readBundle(getClass().getClassLoader()));
        for (String str : c10343b.m63697s()) {
            Object objM63680b = c10343b.m63680b(str);
            if (objM63680b != null) {
                this.extras.put(str, objM63680b);
            }
        }
    }
}
