package com.huawei.openalliance.p169ad.p171db.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6933e;
import com.huawei.openalliance.p169ad.beans.metadata.MediaFile;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import java.io.Serializable;
import java.util.List;

@DataKeep
/* loaded from: classes2.dex */
public class PlacementRecord extends C7013a implements Serializable {
    public static final String CONTENT_ID = "contentId";
    private static final long serialVersionUID = 30422300;
    private List<Integer> clickActionList;
    private String clickUrl;
    private String contentId;
    private String ctrlSwitchs;
    private long endTime;
    private String fileCachePriority;
    private String intentUri;
    private String landPageType;
    private int landingTitle;
    private MediaFile mediaFile;

    @InterfaceC6933e
    private List<MediaFile> mediaFiles;
    private String metaData;
    private EncryptionField<List<Monitor>> monitors;
    private EncryptionField<String> parameter;
    private int placementAdType;
    private int recordcreativetype;
    private int recordinteractiontype;
    private int sequence;
    private String slotId;
    private long startTime;
    private String taskId;
    private String webConfig;
    private int precontentFlag = 0;

    @InterfaceC6933e
    private boolean autoDownloadApp = false;

    /* renamed from: a */
    public String m41791a() {
        return this.contentId;
    }

    @Override // com.huawei.openalliance.p169ad.p171db.bean.C7013a
    /* renamed from: a_ */
    public String mo41475a_() {
        return "contentId";
    }

    /* renamed from: b */
    public String m41797b() {
        return this.metaData;
    }

    /* renamed from: c */
    public void m41802c(int i10) {
        this.landingTitle = i10;
    }

    /* renamed from: d */
    public void m41805d(int i10) {
        this.sequence = i10;
    }

    /* renamed from: e */
    public void m41807e(int i10) {
        this.precontentFlag = i10;
    }

    /* renamed from: f */
    public void m41809f(int i10) {
        this.placementAdType = i10;
    }

    /* renamed from: g */
    public void m41811g(String str) {
        this.webConfig = str;
    }

    /* renamed from: h */
    public void m41812h(String str) {
        this.ctrlSwitchs = str;
    }

    /* renamed from: i */
    public void m41813i(String str) {
        this.clickUrl = str;
    }

    /* renamed from: j */
    public void m41814j(String str) {
        this.landPageType = str;
    }

    /* renamed from: k */
    public void m41815k(String str) {
        this.fileCachePriority = str;
    }

    /* renamed from: a */
    public void m41792a(int i10) {
        this.recordinteractiontype = i10;
    }

    /* renamed from: b */
    public void m41798b(int i10) {
        this.recordcreativetype = i10;
    }

    /* renamed from: c */
    public void m41803c(String str) {
        if (this.parameter == null) {
            this.parameter = new EncryptionField<>(String.class);
        }
        this.parameter.m41655a((EncryptionField<String>) str);
    }

    /* renamed from: d */
    public void m41806d(String str) {
        this.intentUri = str;
    }

    /* renamed from: e */
    public void m41808e(String str) {
        this.metaData = str;
    }

    /* renamed from: f */
    public void m41810f(String str) {
        this.taskId = str;
    }

    /* renamed from: a */
    public void m41793a(long j10) {
        this.startTime = j10;
    }

    /* renamed from: b */
    public void m41799b(long j10) {
        this.endTime = j10;
    }

    /* renamed from: c */
    public void m41804c(List<MediaFile> list) {
        this.mediaFiles = list;
    }

    /* renamed from: a */
    public void m41794a(MediaFile mediaFile) {
        this.mediaFile = mediaFile;
    }

    /* renamed from: b */
    public void m41800b(String str) {
        this.contentId = str;
    }

    /* renamed from: a */
    public void m41795a(String str) {
        this.slotId = str;
    }

    /* renamed from: b */
    public void m41801b(List<Integer> list) {
        this.clickActionList = list;
    }

    /* renamed from: a */
    public void m41796a(List<Monitor> list) {
        EncryptionField<List<Monitor>> encryptionField = new EncryptionField<>(List.class, Monitor.class);
        encryptionField.m41655a((EncryptionField<List<Monitor>>) list);
        this.monitors = encryptionField;
    }
}
