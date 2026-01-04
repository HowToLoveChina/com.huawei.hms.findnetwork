package com.huawei.openalliance.p169ad.beans.metadata.p170v3;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Data;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Image;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Title;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Video;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class Asset implements Serializable {
    private static final long serialVersionUID = 1094499159973642680L;
    private String alias;
    private String context;
    private Data data;
    private String filePath;

    /* renamed from: id */
    private int f32014id;
    private Image img;
    private Title title;
    private Video video;

    /* renamed from: a */
    public int m40505a() {
        return this.f32014id;
    }

    /* renamed from: b */
    public String m40512b() {
        return this.alias;
    }

    /* renamed from: c */
    public Data m40514c() {
        return this.data;
    }

    /* renamed from: d */
    public Image m40516d() {
        return this.img;
    }

    /* renamed from: e */
    public Video m40517e() {
        return this.video;
    }

    /* renamed from: f */
    public Title m40518f() {
        return this.title;
    }

    /* renamed from: g */
    public String m40519g() {
        return this.filePath;
    }

    /* renamed from: h */
    public String m40520h() {
        return this.context;
    }

    /* renamed from: a */
    public void m40506a(int i10) {
        this.f32014id = i10;
    }

    /* renamed from: b */
    public void m40513b(String str) {
        this.filePath = str;
    }

    /* renamed from: c */
    public void m40515c(String str) {
        this.context = str;
    }

    /* renamed from: a */
    public void m40507a(Data data) {
        this.data = data;
    }

    /* renamed from: a */
    public void m40508a(Image image) {
        this.img = image;
    }

    /* renamed from: a */
    public void m40509a(Title title) {
        this.title = title;
    }

    /* renamed from: a */
    public void m40510a(Video video) {
        this.video = video;
    }

    /* renamed from: a */
    public void m40511a(String str) {
        this.alias = str;
    }
}
