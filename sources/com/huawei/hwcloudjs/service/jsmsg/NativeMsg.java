package com.huawei.hwcloudjs.service.jsmsg;

import com.huawei.hwcloudjs.annotation.JSField;
import com.huawei.hwcloudjs.annotation.JSNativeMsg;
import com.huawei.hwcloudjs.p160e.p163b.AbstractC6655d;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.support.enables.INoProguard;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class NativeMsg extends AbstractC6655d implements INoProguard {
    private static final String TAG = "NativeMsg";

    private void setField(Field field, JSONObject jSONObject) throws IllegalAccessException, JSONException, SecurityException, IllegalArgumentException {
        String name = field.getName();
        boolean zIsAccessible = field.isAccessible();
        field.setAccessible(true);
        Object obj = field.get(this);
        if (obj != null) {
            try {
                jSONObject.put(name, obj.toString());
            } catch (JSONException unused) {
                C6659d.m37881b(TAG, "setField json error", true);
            }
        }
        field.setAccessible(zIsAccessible);
    }

    public String getPermission() {
        JSNativeMsg jSNativeMsg = (JSNativeMsg) getClass().getAnnotation(JSNativeMsg.class);
        return jSNativeMsg != null ? jSNativeMsg.permission() : "";
    }

    public String getType() {
        JSNativeMsg jSNativeMsg = (JSNativeMsg) getClass().getAnnotation(JSNativeMsg.class);
        return jSNativeMsg != null ? jSNativeMsg.type() : "";
    }

    public boolean isOpen() {
        JSNativeMsg jSNativeMsg = (JSNativeMsg) getClass().getAnnotation(JSNativeMsg.class);
        if (jSNativeMsg != null) {
            return jSNativeMsg.isOpen();
        }
        return false;
    }

    public String toJsonString() throws JSONException, SecurityException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", getType());
            for (Field field : getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(JSField.class)) {
                    try {
                        setField(field, jSONObject);
                    } catch (IllegalAccessException unused) {
                        C6659d.m37881b(TAG, "setField error", true);
                    }
                }
            }
            return jSONObject.toString();
        } catch (JSONException unused2) {
            return "";
        }
    }
}
