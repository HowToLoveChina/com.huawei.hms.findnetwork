package com.huawei.hicloud.request.opengw.bean;

import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes6.dex */
public class MakeFileReq {
    private static final int OFFSET = 31;
    private Map<String, Object> attribute = new TreeMap();
    private String hash;
    private String path;

    public MakeFileReq(String str, String str2) {
        this.hash = str;
        this.path = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MakeFileReq makeFileReq = (MakeFileReq) obj;
        String str = this.hash;
        if (str == null ? makeFileReq.hash != null : !str.equals(makeFileReq.hash)) {
            return false;
        }
        String str2 = this.path;
        if (str2 == null ? makeFileReq.path != null : !str2.equals(makeFileReq.path)) {
            return false;
        }
        Map<String, Object> map = this.attribute;
        return map != null ? map.equals(makeFileReq.attribute) : makeFileReq.attribute == null;
    }

    public Map<String, Object> getAttribute() {
        return this.attribute;
    }

    public String getHash() {
        return this.hash;
    }

    public String getPath() {
        return this.path;
    }

    public int hashCode() {
        String str = this.hash;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.path;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, Object> map = this.attribute;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public void setAttribute(Map<String, Object> map) {
        this.attribute = map;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
