package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6936h;
import com.huawei.openalliance.p169ad.constant.NetworkTypeForControl;
import com.huawei.openalliance.p169ad.constant.ShowFlag;
import com.huawei.openalliance.p169ad.constant.VideoPlayFlag;
import com.huawei.openalliance.p169ad.constant.VideoShowMode;
import com.huawei.openalliance.p169ad.constant.VideoSoundFlag;

@DataKeep
/* loaded from: classes8.dex */
public class VideoInfo {

    @InterfaceC6936h(m39230e = {1, 100}, m39231f = 100)
    private Integer autoPlayAreaRatio;

    @InterfaceC6936h(m39230e = {0, 99}, m39231f = 90)
    private Integer autoStopPlayAreaRatio;
    private int checkSha256Flag;
    private String liveRoomName;
    private String sha256;
    private float splashSwitchTime;

    @InterfaceC6929a
    private String videoDownloadUrl;
    private int videoDuration;
    private int videoFileSize;
    private Float videoRatio;

    @InterfaceC6936h(m39227b = VideoPlayFlag.class, m39229d = "y")
    private String videoAutoPlayOnWifi = "y";

    @InterfaceC6936h(m39227b = VideoSoundFlag.class, m39229d = "n")
    private String videoAutoPlayWithSound = "n";
    private int timeBeforeVideoAutoPlay = 200;

    @InterfaceC6936h(m39227b = VideoShowMode.class, m39228c = 1)
    private int videoPlayMode = 1;

    @InterfaceC6936h(m39227b = NetworkTypeForControl.class, m39228c = 0)
    private int downloadNetwork = 0;

    @InterfaceC6936h(m39227b = ShowFlag.class, m39229d = "y")
    private String showSoundIcon = "y";
    private int videoType = 0;

    /* renamed from: a */
    public String m40471a() {
        return this.videoDownloadUrl;
    }

    /* renamed from: b */
    public int m40477b() {
        return this.videoDuration;
    }

    /* renamed from: c */
    public int m40481c() {
        return this.videoFileSize;
    }

    /* renamed from: d */
    public String m40484d() {
        return this.videoAutoPlayOnWifi;
    }

    /* renamed from: e */
    public String m40487e() {
        return this.videoAutoPlayWithSound;
    }

    /* renamed from: f */
    public int m40490f() {
        return this.timeBeforeVideoAutoPlay;
    }

    /* renamed from: g */
    public String m40493g() {
        return this.sha256;
    }

    /* renamed from: h */
    public int m40495h() {
        return this.videoPlayMode;
    }

    /* renamed from: i */
    public int m40496i() {
        return this.checkSha256Flag;
    }

    /* renamed from: j */
    public Integer m40497j() {
        return this.autoPlayAreaRatio;
    }

    /* renamed from: k */
    public Integer m40498k() {
        return this.autoStopPlayAreaRatio;
    }

    /* renamed from: l */
    public int m40499l() {
        return this.downloadNetwork;
    }

    /* renamed from: m */
    public Float m40500m() {
        return this.videoRatio;
    }

    /* renamed from: n */
    public String m40501n() {
        return this.showSoundIcon;
    }

    /* renamed from: o */
    public float m40502o() {
        return this.splashSwitchTime;
    }

    /* renamed from: a */
    public void m40472a(float f10) {
        this.splashSwitchTime = f10;
    }

    /* renamed from: b */
    public void m40478b(int i10) {
        this.videoFileSize = i10;
    }

    /* renamed from: c */
    public void m40482c(int i10) {
        this.timeBeforeVideoAutoPlay = i10;
    }

    /* renamed from: d */
    public void m40485d(int i10) {
        this.videoPlayMode = i10;
    }

    /* renamed from: e */
    public void m40488e(int i10) {
        this.checkSha256Flag = i10;
    }

    /* renamed from: f */
    public void m40491f(int i10) {
        this.downloadNetwork = i10;
    }

    /* renamed from: g */
    public void m40494g(int i10) {
        this.videoType = i10;
    }

    /* renamed from: a */
    public void m40473a(int i10) {
        this.videoDuration = i10;
    }

    /* renamed from: b */
    public void m40479b(Integer num) {
        this.autoStopPlayAreaRatio = num;
    }

    /* renamed from: c */
    public void m40483c(String str) {
        this.videoAutoPlayWithSound = str;
    }

    /* renamed from: d */
    public void m40486d(String str) {
        this.sha256 = str;
    }

    /* renamed from: e */
    public void m40489e(String str) {
        this.showSoundIcon = str;
    }

    /* renamed from: f */
    public void m40492f(String str) {
        this.liveRoomName = str;
    }

    /* renamed from: a */
    public void m40474a(Float f10) {
        this.videoRatio = f10;
    }

    /* renamed from: b */
    public void m40480b(String str) {
        this.videoAutoPlayOnWifi = str;
    }

    /* renamed from: a */
    public void m40475a(Integer num) {
        this.autoPlayAreaRatio = num;
    }

    /* renamed from: a */
    public void m40476a(String str) {
        this.videoDownloadUrl = str;
    }
}
