package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class TextState implements Serializable {
    private static final long serialVersionUID = 30420300;
    private int defaultTextFlag;
    private String language;
    private int showPosition;
    private int state;
    private String text;

    /* renamed from: com.huawei.openalliance.ad.beans.metadata.TextState$1 */
    public static /* synthetic */ class C69581 {
        static final /* synthetic */ int[] $SwitchMap$com$huawei$openalliance$ad$download$app$AppStatus;

        static {
            int[] iArr = new int[AppStatus.values().length];
            $SwitchMap$com$huawei$openalliance$ad$download$app$AppStatus = iArr;
            try {
                iArr[AppStatus.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$huawei$openalliance$ad$download$app$AppStatus[AppStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$huawei$openalliance$ad$download$app$AppStatus[AppStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$huawei$openalliance$ad$download$app$AppStatus[AppStatus.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$huawei$openalliance$ad$download$app$AppStatus[AppStatus.INSTALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$huawei$openalliance$ad$download$app$AppStatus[AppStatus.INSTALLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: a */
    public int m40460a() {
        return this.showPosition;
    }

    /* renamed from: b */
    public int m40463b() {
        return this.state;
    }

    /* renamed from: c */
    public String m40466c() {
        return this.language;
    }

    /* renamed from: d */
    public String m40468d() {
        return this.text;
    }

    /* renamed from: e */
    public int m40469e() {
        return this.defaultTextFlag;
    }

    /* renamed from: a */
    public static int m40459a(AppStatus appStatus) {
        switch (C69581.$SwitchMap$com$huawei$openalliance$ad$download$app$AppStatus[appStatus.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 2;
            case 4:
                return 6;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                return -1;
        }
    }

    /* renamed from: b */
    public void m40464b(int i10) {
        this.state = i10;
    }

    /* renamed from: c */
    public void m40467c(int i10) {
        this.defaultTextFlag = i10;
    }

    /* renamed from: a */
    public void m40461a(int i10) {
        this.showPosition = i10;
    }

    /* renamed from: b */
    public void m40465b(String str) {
        this.text = str;
    }

    /* renamed from: a */
    public void m40462a(String str) {
        this.language = str;
    }
}
