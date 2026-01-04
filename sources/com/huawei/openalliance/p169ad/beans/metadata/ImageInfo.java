package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6933e;
import com.huawei.openalliance.p169ad.constant.MetaCreativeType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class ImageInfo implements Serializable {
    private static final long serialVersionUID = 30414300;
    private int checkSha256Flag;

    @InterfaceC6933e
    private String fileKey;
    private String sha256;

    @InterfaceC6929a
    private String url;
    private int width = 0;
    private int height = 0;
    private String imageType = MetaCreativeType.IMG;
    private int fileSize = 0;

    @InterfaceC6933e
    private List<String> attachments = new ArrayList();

    /* renamed from: a */
    public String m40174a() {
        return this.sha256;
    }

    /* renamed from: b */
    public String m40177b() {
        return this.imageType;
    }

    /* renamed from: c */
    public String m40180c() {
        return this.url;
    }

    /* renamed from: d */
    public int m40183d() {
        return this.width;
    }

    /* renamed from: e */
    public int m40185e() {
        return this.height;
    }

    /* renamed from: f */
    public int m40186f() {
        return this.fileSize;
    }

    /* renamed from: g */
    public int m40187g() {
        return this.checkSha256Flag;
    }

    /* renamed from: a */
    public void m40175a(int i10) {
        this.width = i10;
    }

    /* renamed from: b */
    public void m40178b(int i10) {
        this.height = i10;
    }

    /* renamed from: c */
    public void m40181c(int i10) {
        this.fileSize = i10;
    }

    /* renamed from: d */
    public void m40184d(int i10) {
        this.checkSha256Flag = i10;
    }

    /* renamed from: a */
    public void m40176a(String str) {
        this.sha256 = str;
    }

    /* renamed from: b */
    public void m40179b(String str) {
        this.imageType = str;
    }

    /* renamed from: c */
    public void m40182c(String str) {
        this.url = str;
    }
}
