package com.huawei.hms.location;

import com.huawei.hms.core.aidl.IMessageEntity;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class LocationSceneRequest implements IMessageEntity {
    public static final int SCENE_CAR_BT_STATUS = 1;
    public static final int SCENE_CHECK_SUPPORT_MAG = 102;
    public static final int SCENE_GET_MAG_LOADING_PROGRESS = 103;
    public static final int SCENE_PARKING_LOCATION = 101;
    private int sceneMode;
    private HashMap<String, String> sceneParam;

    public LocationSceneRequest(int i10) {
        this.sceneMode = i10;
    }

    public int getSceneMode() {
        return this.sceneMode;
    }

    public HashMap<String, String> getSceneParam() {
        return this.sceneParam;
    }

    public void setSceneMode(int i10) {
        this.sceneMode = i10;
    }

    public void setSceneParam(HashMap<String, String> map) {
        this.sceneParam = map;
    }
}
