package com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import p578qh.C12355a;
import p578qh.C12356b;
import p578qh.C12357c;
import p613rh.AbstractC12511b;
import p679uh.C13175c;
import p708vh.AbstractC13445a;

/* loaded from: classes4.dex */
public abstract class RequestBean {
    public static final int CHINA = 0;
    public static final int GLOBAL = 1;

    /* renamed from: a */
    public Context f21011a;

    /* renamed from: b */
    public String f21012b;

    @InstallerNetTransmission
    public String brand;

    @InstallerNetTransmission
    private String buildNumber;

    @InstallerNetTransmission
    private String code;

    @InstallerNetTransmission
    private String density;

    @InstallerNetTransmission
    private int deviceType;

    @InstallerNetTransmission
    private int emuiApiLevel;

    @InstallerNetTransmission
    private String emuiVer;

    @InstallerNetTransmission
    private int firmwareVersion;

    @InstallerNetTransmission
    private int international;

    @InstallerNetTransmission
    private String lang;

    @InstallerNetTransmission
    public int magicApiLevel;

    @InstallerNetTransmission
    public String magicVer;

    @InstallerNetTransmission
    private String manufacturer;

    @InstallerNetTransmission
    private String method;

    @InstallerNetTransmission
    private int net;

    @InstallerNetTransmission
    private int odm;

    @InstallerNetTransmission
    private String phoneType;

    @InstallerNetTransmission
    private String sdkVersion;

    @InstallerNetTransmission
    private String subsystem;

    @InstallerNetTransmission
    private int sysBits;

    /* renamed from: ts */
    @InstallerNetTransmission
    private long f21013ts;

    @InstallerNetTransmission
    private String ver;

    public RequestBean() {
        this.code = "0500";
        this.ver = "8.0";
        this.emuiApiLevel = 0;
        this.international = 0;
        this.manufacturer = Build.MANUFACTURER;
        this.odm = 0;
        this.f21012b = "";
        this.brand = Build.BRAND;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m28071a(java.lang.reflect.Field r8) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r7 = this;
            java.lang.String r0 = r8.getName()
            java.lang.Class r1 = r8.getType()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "boolean"
            boolean r1 = r2.equals(r1)
            java.lang.String r0 = p775xh.C13813a.m82851a(r0, r1)
            java.lang.String r1 = "getValue:Can not find getMethod:"
            java.lang.String r2 = "RequestBean"
            r3 = 0
            if (r0 != 0) goto L34
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r1)
            java.lang.String r8 = r8.getName()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            th.C13012a.m78317c(r2, r7)
            return r3
        L34:
            java.lang.Class r4 = r7.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L46 java.lang.SecurityException -> L5f java.lang.NoSuchMethodException -> L67
            r5 = 0
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L46 java.lang.SecurityException -> L5f java.lang.NoSuchMethodException -> L67
            java.lang.reflect.Method r0 = r4.getMethod(r0, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L46 java.lang.SecurityException -> L5f java.lang.NoSuchMethodException -> L67
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L46 java.lang.SecurityException -> L5f java.lang.NoSuchMethodException -> L67
            java.lang.Object r7 = r0.invoke(r7, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L46 java.lang.SecurityException -> L5f java.lang.NoSuchMethodException -> L67
            goto L71
        L46:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "getValue:GetMethod can not invocation:"
        L4d:
            r7.append(r0)
        L50:
            java.lang.String r8 = r8.getName()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            th.C13012a.m78317c(r2, r7)
            goto L70
        L5f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "getValue:GetMethod can not access:"
            goto L4d
        L67:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r1)
            goto L50
        L70:
            r7 = r3
        L71:
            boolean r8 = r7 instanceof com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean
            if (r8 == 0) goto L7c
            com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean r7 = (com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean) r7
            java.lang.String r7 = r7.toJson()
            return r7
        L7c:
            boolean r8 = r7 instanceof java.util.List
            if (r8 == 0) goto L87
            java.util.List r7 = (java.util.List) r7
            java.lang.String r7 = com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean.listToJson(r7)
            return r7
        L87:
            boolean r8 = r7 instanceof java.lang.reflect.Array
            if (r8 == 0) goto L92
            java.lang.reflect.Array r7 = (java.lang.reflect.Array) r7
            java.lang.String r7 = com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean.arrayToJson(r7)
            return r7
        L92:
            boolean r8 = r7 instanceof java.util.Map
            if (r8 == 0) goto L9d
            java.util.Map r7 = (java.util.Map) r7
            java.lang.String r7 = com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean.mapToJson(r7)
            return r7
        L9d:
            if (r7 == 0) goto La4
            java.lang.String r7 = java.lang.String.valueOf(r7)
            return r7
        La4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean.m28071a(java.lang.reflect.Field):java.lang.String");
    }

    /* renamed from: b */
    public Map<String, Field> m28072b() {
        HashMap map = new HashMap();
        for (Field field : AbstractC13445a.m80776c(getClass())) {
            if (field.isAnnotationPresent(InstallerNetTransmission.class)) {
                map.put(field.getName(), field);
            }
        }
        return map;
    }

    /* renamed from: c */
    public void m28073c() {
        this.net = C13175c.m79221d(this.f21011a);
        this.f21013ts = System.currentTimeMillis();
        this.emuiVer = C12356b.m74377e().m74380c();
        this.emuiApiLevel = C12356b.m74377e().m74378a();
    }

    public String genBody() {
        String strM28071a;
        m28073c();
        Map<String, Field> mapM28072b = m28072b();
        int size = mapM28072b.size();
        String[] strArr = new String[size];
        mapM28072b.keySet().toArray(strArr);
        Arrays.sort(strArr);
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        do {
            Field field = mapM28072b.get(strArr[i10]);
            if (field != null && (strM28071a = m28071a(field)) != null) {
                String strM75108a = AbstractC12511b.m75108a(strM28071a);
                sb2.append(strArr[i10]);
                sb2.append('=');
                sb2.append(strM75108a);
                sb2.append('&');
            }
            i10++;
        } while (i10 < size);
        int length = sb2.length();
        if (length > 0) {
            int i11 = length - 1;
            if (sb2.charAt(i11) == '&') {
                sb2.deleteCharAt(i11);
            }
        }
        return sb2.toString();
    }

    public String getBrand() {
        return this.brand;
    }

    public String getBuildNumber() {
        return this.buildNumber;
    }

    public String getCode() {
        return this.code;
    }

    public Context getContext() {
        return this.f21011a;
    }

    public String getDensity() {
        return this.density;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getEmuiApiLevel() {
        return this.emuiApiLevel;
    }

    public String getEmuiVer() {
        return this.emuiVer;
    }

    public int getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public int getInternational() {
        return this.international;
    }

    public String getLang() {
        return this.lang;
    }

    public int getMagicApiLevel() {
        return this.magicApiLevel;
    }

    public String getMagicVer() {
        return this.magicVer;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getMethod() {
        return this.method;
    }

    public int getNet() {
        return this.net;
    }

    public int getOdm() {
        return this.odm;
    }

    public String getPhoneType() {
        return this.phoneType;
    }

    public ResponseBean getResponseBean() {
        return new ResponseBean();
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getServiceUrl() {
        return this.f21012b;
    }

    public String getSubsystem() {
        return this.subsystem;
    }

    public int getSysBits() {
        return this.sysBits;
    }

    public long getTs() {
        return this.f21013ts;
    }

    public String getVer() {
        return this.ver;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setBuildNumber(String str) {
        this.buildNumber = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setContext(Context context) {
        this.f21011a = context;
    }

    public void setDensity(String str) {
        this.density = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setEmuiApiLevel(int i10) {
        this.emuiApiLevel = i10;
    }

    public void setEmuiVer(String str) {
        this.emuiVer = str;
    }

    public void setFirmwareVersion(int i10) {
        this.firmwareVersion = i10;
    }

    public void setInternational(int i10) {
        this.international = i10;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setMagicApiLevel(int i10) {
        this.magicApiLevel = i10;
    }

    public void setMagicVer(String str) {
        this.magicVer = str;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setNet(int i10) {
        this.net = i10;
    }

    public void setOdm(int i10) {
        this.odm = i10;
    }

    public void setPhoneType(String str) {
        this.phoneType = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setServiceUrl(String str) {
        this.f21012b = str;
    }

    public void setSubsystem(String str) {
        this.subsystem = str;
    }

    public void setSysBits(int i10) {
        this.sysBits = i10;
    }

    public void setTs(long j10) {
        this.f21013ts = j10;
    }

    public void setVer(String str) {
        this.ver = str;
    }

    public RequestBean(Context context) {
        this.code = "0500";
        this.ver = "8.0";
        this.emuiApiLevel = 0;
        this.international = 0;
        this.manufacturer = Build.MANUFACTURER;
        this.odm = 0;
        this.f21012b = "";
        this.brand = Build.BRAND;
        this.f21011a = context;
        this.firmwareVersion = C12355a.m74371k();
        this.density = C12355a.m74368h(context);
        this.phoneType = C12355a.m74369i();
        this.buildNumber = C12355a.m74364d();
        this.lang = C12357c.m74382a();
        this.sysBits = C12355a.m74373m();
        this.deviceType = C12355a.m74361a(context);
        this.international = C12357c.m74383b() ? 1 : 0;
        if (C12355a.m74376p()) {
            this.odm = 1;
        }
        this.sdkVersion = "11.5.1.300";
        this.magicVer = C12355a.m74367g();
        this.magicApiLevel = C12355a.m74365e();
    }
}
