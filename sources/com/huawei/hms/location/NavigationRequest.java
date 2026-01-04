package com.huawei.hms.location;

import android.os.Parcel;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.location.C6769i;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class NavigationRequest implements IMessageEntity {
    public static final int IS_SUPPORT_EX = 2;
    public static final int OVERPASS = 1;

    @Packed
    private Map<String, String> extras;

    @Packed
    private int type;

    public NavigationRequest(int i10) {
        this.type = i10;
    }

    private Map<String, String> getExtras() {
        return this.extras;
    }

    public int getType() {
        return this.type;
    }

    public void setExtras(Map<String, String> map) {
        this.extras = map;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public String toString() {
        return C6769i.m38373a(new StringBuilder("NavigationRequest{type = "), this.type, '}');
    }

    public NavigationRequest(Parcel parcel) {
        this.type = parcel.readInt();
        HashMap map = new HashMap();
        this.extras = map;
        parcel.readMap(map, NavigationRequest.class.getClassLoader());
    }
}
