package com.huawei.riemann.location.common.bean;

import com.huawei.location.C6769i;
import java.util.Arrays;

/* loaded from: classes5.dex */
public class RoadArea {
    private String[] nearRoadIDList;
    private RoadLink[] roadInfoList;
    private String[] roadStart2End;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !(obj instanceof RoadArea)) {
            return false;
        }
        RoadArea roadArea = (RoadArea) obj;
        if (Arrays.equals(this.roadStart2End, roadArea.roadStart2End) && Arrays.equals(this.nearRoadIDList, roadArea.nearRoadIDList)) {
            return Arrays.equals(this.roadInfoList, roadArea.roadInfoList);
        }
        return false;
    }

    public String[] getNearRoadIDList() {
        String[] strArr = this.nearRoadIDList;
        return strArr == null ? new String[0] : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public RoadLink[] getRoadInfoList() {
        RoadLink[] roadLinkArr = this.roadInfoList;
        return roadLinkArr == null ? new RoadLink[0] : (RoadLink[]) Arrays.copyOf(roadLinkArr, roadLinkArr.length);
    }

    public String[] getRoadStart2End() {
        String[] strArr = this.roadStart2End;
        return strArr == null ? new String[0] : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public int hashCode() {
        String[] strArr = this.roadStart2End;
        int iHashCode = (strArr != null ? Arrays.hashCode(strArr) : 0) * 31;
        String[] strArr2 = this.nearRoadIDList;
        int iHashCode2 = (iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31;
        RoadLink[] roadLinkArr = this.roadInfoList;
        return iHashCode2 + (roadLinkArr != null ? Arrays.hashCode(roadLinkArr) : 0);
    }

    public void setNearRoadIDList(String... strArr) {
        if (strArr != null) {
            this.nearRoadIDList = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    public void setRoadInfoArea(RoadLink... roadLinkArr) {
        if (roadLinkArr != null) {
            this.roadInfoList = (RoadLink[]) Arrays.copyOf(roadLinkArr, roadLinkArr.length);
        }
    }

    public void setRoadStart2End(String... strArr) {
        if (strArr != null) {
            this.roadStart2End = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("RoadArea{roadStart2End.length=");
        String[] strArr = this.roadStart2End;
        return C6769i.m38373a(sb2, strArr == null ? 0 : strArr.length, '}');
    }
}
