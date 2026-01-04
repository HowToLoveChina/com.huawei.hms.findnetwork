package com.huawei.android.hicloud.p088ui.uiextend.bean;

import com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class SecondaryRetentionContent implements Serializable {
    private static final long serialVersionUID = 1846863058117648887L;
    private int dialogType = 1;
    private String message;
    private NotEnoughDialogDataV5.DialogGoto negativeGoto;
    private String negativeText;
    private NotEnoughDialogDataV5.DialogGoto positiveGoto;
    private String positiveText;
    private String resourceId;
    private String title;

    public int getDialogType() {
        return this.dialogType;
    }

    public String getMessage() {
        return this.message;
    }

    public NotEnoughDialogDataV5.DialogGoto getNegativeGoto() {
        return this.negativeGoto;
    }

    public String getNegativeText() {
        return this.negativeText;
    }

    public NotEnoughDialogDataV5.DialogGoto getPositiveGoto() {
        return this.positiveGoto;
    }

    public String getPositiveText() {
        return this.positiveText;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDialogType(int i10) {
        this.dialogType = i10;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setNegativeGoto(NotEnoughDialogDataV5.DialogGoto dialogGoto) {
        this.negativeGoto = dialogGoto;
    }

    public void setNegativeText(String str) {
        this.negativeText = str;
    }

    public void setPositiveGoto(NotEnoughDialogDataV5.DialogGoto dialogGoto) {
        this.positiveGoto = dialogGoto;
    }

    public void setPositiveText(String str) {
        this.positiveText = str;
    }

    public void setResourceId(String str) {
        this.resourceId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
