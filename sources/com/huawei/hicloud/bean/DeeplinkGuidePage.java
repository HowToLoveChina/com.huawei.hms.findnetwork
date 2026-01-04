package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class DeeplinkGuidePage {

    @SerializedName("actionPackageRoute")
    private DeeplinkRoute[] actionPackageRoute;

    @SerializedName("actionRoute")
    private DeeplinkRoute[] actionRoute;

    @SerializedName("deeplinkRoute")
    private DeeplinkRoute[] deeplinkRoute;

    public DeeplinkRoute[] getActionPackageRoute() {
        return this.actionPackageRoute;
    }

    public DeeplinkRoute[] getActionRoute() {
        return this.actionRoute;
    }

    public DeeplinkRoute[] getDeeplinkRoute() {
        return this.deeplinkRoute;
    }

    public void setActionPackageRoute(DeeplinkRoute[] deeplinkRouteArr) {
        this.actionPackageRoute = deeplinkRouteArr;
    }

    public void setActionRoute(DeeplinkRoute[] deeplinkRouteArr) {
        this.actionRoute = deeplinkRouteArr;
    }

    public void setDeeplinkRoute(DeeplinkRoute[] deeplinkRouteArr) {
        this.deeplinkRoute = deeplinkRouteArr;
    }
}
