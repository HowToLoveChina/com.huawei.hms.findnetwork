package com.huawei.riemann.location.common.bean;

import java.util.Arrays;

/* loaded from: classes5.dex */
public class RoadLink {
    private RoadPoint[] curvePoints;
    private String[] endNearId;
    private RoadPoint endPoint;
    private String[] startNearId;
    private RoadPoint startPoint;
    private String linkID = "";
    private int linkType = 0;
    private int trackDirection = 0;
    private boolean isAccess = false;
    private double roadWidth = 0.0d;
    private double roadLength = 0.0d;
    private int speedCategory = 0;
    private boolean isTunnel = false;
    private double roadDirection = 0.0d;

    public RoadPoint[] getCurvePoints() {
        RoadPoint[] roadPointArr = this.curvePoints;
        return roadPointArr == null ? new RoadPoint[0] : (RoadPoint[]) Arrays.copyOf(roadPointArr, roadPointArr.length);
    }

    public String[] getEndNearId() {
        String[] strArr = this.endNearId;
        return strArr == null ? new String[0] : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public RoadPoint getEndPoint() {
        return this.endPoint;
    }

    public String getLinkID() {
        return this.linkID;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public double getRoadDirection() {
        return this.roadDirection;
    }

    public double getRoadLength() {
        return this.roadLength;
    }

    public double getRoadWidth() {
        return this.roadWidth;
    }

    public int getSpeedCategory() {
        return this.speedCategory;
    }

    public String[] getStartNearId() {
        String[] strArr = this.startNearId;
        return strArr == null ? new String[0] : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public RoadPoint getStartPoint() {
        return this.startPoint;
    }

    public int getTrackDirection() {
        return this.trackDirection;
    }

    public boolean isAccess() {
        return this.isAccess;
    }

    public boolean isTunnel() {
        return this.isTunnel;
    }

    public void setCurvePoints(RoadPoint... roadPointArr) {
        if (roadPointArr != null) {
            this.curvePoints = (RoadPoint[]) Arrays.copyOf(roadPointArr, roadPointArr.length);
        }
    }

    public void setEndNearId(String... strArr) {
        if (strArr != null) {
            this.endNearId = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    public void setEndPoint(RoadPoint roadPoint) {
        this.endPoint = roadPoint;
    }

    public void setIsAccess(boolean z10) {
        this.isAccess = z10;
    }

    public void setIsTunnel(boolean z10) {
        this.isTunnel = z10;
    }

    public void setLinkID(String str) {
        this.linkID = str;
    }

    public void setLinkType(int i10) {
        this.linkType = i10;
    }

    public void setRoadDirection(double d10) {
        this.roadDirection = d10;
    }

    public void setRoadLength(double d10) {
        this.roadLength = d10;
    }

    public void setRoadWidth(double d10) {
        this.roadWidth = d10;
    }

    public void setSpeedCategory(int i10) {
        this.speedCategory = i10;
    }

    public void setStartNearId(String... strArr) {
        if (strArr != null) {
            this.startNearId = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    public void setStartPoint(RoadPoint roadPoint) {
        this.startPoint = roadPoint;
    }

    public void setTrackDirection(int i10) {
        this.trackDirection = i10;
    }

    public String toString() {
        return "RoadLink{linkID=" + this.linkID + ", startPoint=" + this.startPoint + ", endPoint=" + this.endPoint + ", linkType=" + this.linkType + ", trackDirection=" + this.trackDirection + ", isAccess=" + this.isAccess + ", roadWidth=" + this.roadWidth + ", roadLength=" + this.roadLength + ", speedCategory=" + this.speedCategory + ", isTunnel=" + this.isTunnel + ", roadDirection=" + this.roadDirection + ", startNearId=" + Arrays.toString(this.startNearId) + ", endNearId=" + Arrays.toString(this.endNearId) + ", curvePoints=" + Arrays.toString(this.curvePoints) + '}';
    }
}
