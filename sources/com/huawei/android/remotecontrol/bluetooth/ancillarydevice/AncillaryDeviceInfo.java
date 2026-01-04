package com.huawei.android.remotecontrol.bluetooth.ancillarydevice;

import android.util.ArrayMap;
import com.huawei.android.bluetooth.HwFindDevice;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.util.Objects;
import java.util.Optional;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p738we.InterfaceC13595b;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class AncillaryDeviceInfo {
    private static final String TAG = "AncillaryDeviceInfo";
    private int componentType;
    private String connectivity;
    private String deviceBtMac;
    private String deviceId;
    private JSONArray deviceList;
    private String deviceName;
    private String deviceSn;
    private String deviceType;
    private JSONArray findCapability;
    private String goodsType;
    private String hbkp;
    private String irk;
    private String modelId;
    private String parentSn;
    private String perDeviceType;
    private int sequence;
    private String subDeviceType;
    private String subModelId;
    private String timeStamp;
    private String wearDetect;
    private transient Optional<InterfaceC13595b> callbackOpt = Optional.empty();
    private boolean isConnected = false;

    private ArrayMap<String, String> mapDeviceList(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        ArrayMap<String, String> arrayMap = new ArrayMap<>(jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                arrayMap.put(jSONObject.getString(VastAttribute.SEQUENCE), jSONObject.has("deviceID") ? jSONObject.getString("deviceID") : jSONObject.getString("deviceId"));
            } catch (JSONException e10) {
                C13981a.m83988e(TAG, "get device info error:" + e10.getMessage());
            }
        }
        return arrayMap;
    }

    public HwFindDevice encaseFindDevice() {
        HwFindDevice hwFindDevice = new HwFindDevice(this.deviceBtMac);
        hwFindDevice.setDeviceId(this.deviceId);
        hwFindDevice.setConnectivity(this.connectivity);
        hwFindDevice.setIrk(this.irk);
        hwFindDevice.setHbkP(this.hbkp);
        return hwFindDevice;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AncillaryDeviceInfo ancillaryDeviceInfo = (AncillaryDeviceInfo) obj;
        if (Objects.equals(mapDeviceList(this.deviceList), mapDeviceList(ancillaryDeviceInfo.deviceList))) {
            return this.deviceId.equals(ancillaryDeviceInfo.getDeviceID());
        }
        return false;
    }

    public Optional<InterfaceC13595b> getCallback() {
        return this.callbackOpt;
    }

    public int getComponentType() {
        return this.componentType;
    }

    public String getConnectivity() {
        return this.connectivity;
    }

    public String getDeviceBtMac() {
        return this.deviceBtMac;
    }

    public String getDeviceID() {
        return this.deviceId;
    }

    public JSONArray getDeviceList() {
        return this.deviceList;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceSn() {
        return this.deviceSn;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public JSONArray getFindCapability() {
        return this.findCapability;
    }

    public String getGoodsType() {
        return this.goodsType;
    }

    public String getHbkp() {
        return this.hbkp;
    }

    public String getIrk() {
        return this.irk;
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getParentSn() {
        return this.parentSn;
    }

    public String getPerDeviceType() {
        return this.perDeviceType;
    }

    public int getSequence() {
        return this.sequence;
    }

    public String getSubDeviceType() {
        return this.subDeviceType;
    }

    public String getSubModelId() {
        return this.subModelId;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public String getWearDetect() {
        return this.wearDetect;
    }

    public int hashCode() throws JSONException {
        if (this.deviceId == null) {
            return 0;
        }
        ArrayMap<String, String> arrayMapMapDeviceList = mapDeviceList(this.deviceList);
        return arrayMapMapDeviceList != null ? Objects.hash(this.deviceId, arrayMapMapDeviceList) : this.deviceId.hashCode();
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public void setCallback(InterfaceC13595b interfaceC13595b) {
        this.callbackOpt = Optional.of(interfaceC13595b);
    }

    public void setComponentType(int i10) {
        this.componentType = i10;
    }

    public void setConnected(boolean z10) {
        this.isConnected = z10;
    }

    public void setConnectivity(String str) {
        this.connectivity = str;
    }

    public void setDeviceBtMac(String str) {
        this.deviceBtMac = str;
    }

    public void setDeviceID(String str) {
        this.deviceId = str;
    }

    public void setDeviceList(JSONArray jSONArray) {
        this.deviceList = jSONArray;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceSn(String str) {
        this.deviceSn = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setFindCapability(JSONArray jSONArray) {
        this.findCapability = jSONArray;
    }

    public void setGoodsType(String str) {
        this.goodsType = str;
    }

    public void setHbkp(String str) {
        this.hbkp = str;
    }

    public void setIrk(String str) {
        this.irk = str;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }

    public void setParentSn(String str) {
        this.parentSn = str;
    }

    public void setPerDeviceType(String str) {
        this.perDeviceType = str;
    }

    public void setSequence(int i10) {
        this.sequence = i10;
    }

    public void setSubDeviceType(String str) {
        this.subDeviceType = str;
    }

    public void setSubModelId(String str) {
        this.subModelId = str;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public void setWearDetect(String str) {
        this.wearDetect = str;
    }
}
