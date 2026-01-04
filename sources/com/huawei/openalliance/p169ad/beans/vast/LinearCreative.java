package com.huawei.openalliance.p169ad.beans.vast;

import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class LinearCreative {
    private int duration;
    private List<VastIcon> icons;
    private List<VastMediaFile> mediaFiles;
    private Map<String, List<Tracking>> trackingEvents;
    private VideoClicks videoClicks;

    /* renamed from: a */
    public int m40978a() {
        return this.duration;
    }

    /* renamed from: b */
    public List<VastMediaFile> m40983b() {
        return this.mediaFiles;
    }

    /* renamed from: c */
    public Map<String, List<Tracking>> m40985c() {
        return this.trackingEvents;
    }

    /* renamed from: d */
    public List<VastIcon> m40986d() {
        return this.icons;
    }

    /* renamed from: e */
    public VideoClicks m40987e() {
        return this.videoClicks;
    }

    /* renamed from: a */
    public void m40979a(int i10) {
        this.duration = i10;
    }

    /* renamed from: b */
    public void m40984b(List<VastIcon> list) {
        this.icons = list;
    }

    /* renamed from: a */
    public void m40980a(VideoClicks videoClicks) {
        this.videoClicks = videoClicks;
    }

    /* renamed from: a */
    public void m40981a(List<VastMediaFile> list) {
        this.mediaFiles = list;
    }

    /* renamed from: a */
    public void m40982a(Map<String, List<Tracking>> map) {
        this.trackingEvents = map;
    }
}
