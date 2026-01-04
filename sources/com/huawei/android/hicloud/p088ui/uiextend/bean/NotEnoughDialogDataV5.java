package com.huawei.android.hicloud.p088ui.uiextend.bean;

import android.text.TextUtils;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.DataItems;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class NotEnoughDialogDataV5 {
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private int activityType;
    private BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData;
    private DialogMainShowContentV5 dialogMainShowContentV5 = new DialogMainShowContentV5();
    private DialogNoRemindShowData dialogNoRemindShowData = new DialogNoRemindShowData();
    private SecondaryRetentionContent secondaryRetentionContent;
    private int taskId;
    private V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData;

    public static class DialogButtonV5 {
        private String buttonContent;
        private DialogGoto buttonGoto;
        private String buttonType;

        public DialogButtonV5(String str, DialogGoto dialogGoto) {
            this.buttonContent = str;
            this.buttonGoto = dialogGoto;
            if (dialogGoto != null) {
                this.buttonType = dialogGoto.popupUri;
            }
        }

        public String getButtonContent() {
            return NotEnoughDialogDataV5.checkNullStr(this.buttonContent);
        }

        public DialogGoto getButtonGoto() {
            return this.buttonGoto;
        }

        public String getButtonType() {
            return this.buttonType;
        }

        public DialogButtonV5 setButtonContent(String str) {
            this.buttonContent = str;
            return this;
        }

        public DialogButtonV5 setButtonGoto(DialogGoto dialogGoto) {
            this.buttonGoto = dialogGoto;
            return this;
        }

        public DialogButtonV5 setButtonType(String str) {
            this.buttonType = str;
            return this;
        }
    }

    public static class DialogGoto implements Serializable {
        private static final long serialVersionUID = 8498982254479382743L;
        private String popupType;
        private String popupUri;
        private Integer position;

        public String getPopupType() {
            return NotEnoughDialogDataV5.checkNullStr(this.popupType);
        }

        public String getPopupUri() {
            return NotEnoughDialogDataV5.checkNullStr(this.popupUri);
        }

        public Integer getPosition() {
            return this.position;
        }

        public void setPopupType(String str) {
            this.popupType = str;
        }

        public void setPopupUri(String str) {
            this.popupUri = str;
        }

        public void setPosition(Integer num) {
            this.position = num;
        }
    }

    public static class DialogMainShowContentV5 {
        List<DialogButtonV5> buttonList;
        private String content;
        List<DataItems> dataItemsList;
        private boolean enableDataItem;
        private String reminderId;
        private String title;

        public DialogButtonV5 getButton(int i10) {
            List<DialogButtonV5> list = this.buttonList;
            if (list == null || list.size() <= i10 || i10 < 0) {
                return null;
            }
            return this.buttonList.get(i10);
        }

        public String getButtonContent(int i10) {
            DialogButtonV5 button = getButton(i10);
            return button == null ? "" : NotEnoughDialogDataV5.checkNullStr(button.getButtonContent());
        }

        public List<DialogButtonV5> getButtonList() {
            return this.buttonList;
        }

        public String getContent() {
            return NotEnoughDialogDataV5.checkNullStr(this.content);
        }

        public List<DataItems> getDataItemsList() {
            return this.dataItemsList;
        }

        public String getReminderId() {
            return this.reminderId;
        }

        public String getTitle() {
            return NotEnoughDialogDataV5.checkNullStr(this.title);
        }

        public boolean isEnableDataItem() {
            return this.enableDataItem;
        }

        public DialogMainShowContentV5 setButtonList(List<DialogButtonV5> list) {
            this.buttonList = list;
            return this;
        }

        public DialogMainShowContentV5 setContent(String str) {
            this.content = str;
            return this;
        }

        public void setDataItemsList(List<DataItems> list) {
            this.dataItemsList = list;
        }

        public void setEnableDataItem(boolean z10) {
            this.enableDataItem = z10;
        }

        public void setReminderId(String str) {
            this.reminderId = str;
        }

        public DialogMainShowContentV5 setTitle(String str) {
            this.title = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String checkNullStr(String str) {
        return str == null ? "" : str;
    }

    public boolean checkDataValid() {
        return (TextUtils.isEmpty(this.dialogMainShowContentV5.getTitle()) || TextUtils.isEmpty(this.dialogMainShowContentV5.getButtonContent(0)) || TextUtils.isEmpty(this.dialogMainShowContentV5.getButtonContent(1)) || TextUtils.isEmpty(this.dialogMainShowContentV5.getContent())) ? false : true;
    }

    public int getActivityType() {
        return this.activityType;
    }

    public BackupSpaceNotEnoughNeedData getBackupSpaceNotEnoughNeedData() {
        return this.backupSpaceNotEnoughNeedData;
    }

    public SecondaryRetentionContent getSecondaryRetentionContent() {
        return this.secondaryRetentionContent;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public V5DailogActivityAreaNeedData getV5DailogActivityAreaNeedData() {
        return this.v5DailogActivityAreaNeedData;
    }

    public DialogMainShowContentV5 getV5DialogMainShowContent() {
        return this.dialogMainShowContentV5;
    }

    public DialogNoRemindShowData getV5DialogNoRemindShowContent() {
        return this.dialogNoRemindShowData;
    }

    public void setActivityType(int i10) {
        this.activityType = i10;
    }

    public void setBackupSpaceNotEnoughNeedData(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        this.backupSpaceNotEnoughNeedData = backupSpaceNotEnoughNeedData;
    }

    public void setSecondaryRetentionContent(SecondaryRetentionContent secondaryRetentionContent) {
        this.secondaryRetentionContent = secondaryRetentionContent;
    }

    public void setTaskId(int i10) {
        this.taskId = i10;
    }

    public void setV5DailogActivityAreaNeedData(V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData) {
        this.v5DailogActivityAreaNeedData = v5DailogActivityAreaNeedData;
    }

    public void setV5DialogMainShowContent(DialogMainShowContentV5 dialogMainShowContentV5) {
        this.dialogMainShowContentV5 = dialogMainShowContentV5;
    }

    public void setV5DialogNoRemindShowContent(DialogNoRemindShowData dialogNoRemindShowData) {
        this.dialogNoRemindShowData = dialogNoRemindShowData;
    }
}
