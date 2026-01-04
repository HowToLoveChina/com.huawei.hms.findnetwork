package com.huawei.hiar.listener;

import com.huawei.hiar.common.FaceHealthCheckState;
import java.util.EventObject;

/* loaded from: classes5.dex */
public class FaceHealthCheckStateEvent extends EventObject {
    private static final long serialVersionUID = 6806281968676571564L;
    private FaceHealthCheckState mFaceHealthCheckState;

    public FaceHealthCheckStateEvent(Object obj, FaceHealthCheckState faceHealthCheckState) {
        super(obj);
        this.mFaceHealthCheckState = faceHealthCheckState;
    }

    public FaceHealthCheckState getFaceHealthCheckState() {
        return this.mFaceHealthCheckState;
    }
}
