package com.huawei.android.remotecontrol.sharing.p091ui.widgte;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$plurals;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.uikit.hwtimepicker.widget.HwTimePicker;
import java.util.GregorianCalendar;
import sk.C12809f;

/* loaded from: classes4.dex */
public class ShareTimePickerDialog extends AlertDialog {
    private View customView;
    private HwTimePicker hwTimePicker;
    private TextView timeUnitHour;
    private TextView timeUnitMinute;

    public ShareTimePickerDialog(final Context context) {
        super(context);
        View viewInflate = View.inflate(context, R$layout.time_picker_dialog, null);
        this.customView = viewInflate;
        this.timeUnitHour = (TextView) C12809f.m76831d(viewInflate, R$id.time_unit_hour);
        this.timeUnitMinute = (TextView) C12809f.m76831d(this.customView, R$id.time_unit_minute);
        HwTimePicker hwTimePicker = (HwTimePicker) C12809f.m76831d(this.customView, R$id.hwtimepicker);
        this.hwTimePicker = hwTimePicker;
        hwTimePicker.setIsMinuteIntervalFiveMinute(false);
        this.hwTimePicker.setIs24HoursSystem(true);
        this.hwTimePicker.setCurrentTime(0, 0);
        this.timeUnitHour.setText(context.getResources().getQuantityString(R$plurals.share_unit_hour, 0, 0));
        this.timeUnitMinute.setText(context.getResources().getQuantityString(R$plurals.share_unit_minute, 0, 0));
        this.hwTimePicker.setOnTimeChangedListener(new HwTimePicker.OnTimeChangedListener() { // from class: yf.a
            @Override // com.huawei.uikit.hwtimepicker.widget.HwTimePicker.OnTimeChangedListener
            public final void onTimeChanged(HwTimePicker hwTimePicker2, GregorianCalendar gregorianCalendar, String str) {
                this.f62666a.lambda$new$0(context, hwTimePicker2, gregorianCalendar, str);
            }
        });
        setView(this.customView);
        setTitle(context.getString(R$string.set_share_time));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Context context, HwTimePicker hwTimePicker, GregorianCalendar gregorianCalendar, String str) {
        int minute = hwTimePicker.getMinute();
        int hour = hwTimePicker.getHour();
        this.timeUnitHour.setText(context.getResources().getQuantityString(R$plurals.share_unit_hour, hour, Integer.valueOf(hour)));
        this.timeUnitMinute.setText(context.getResources().getQuantityString(R$plurals.share_unit_minute, minute, Integer.valueOf(minute)));
        getButton(-1).setEnabled((minute == 0 && hour == 0) ? false : true);
    }

    public int getHour() {
        HwTimePicker hwTimePicker = this.hwTimePicker;
        if (hwTimePicker == null) {
            return 0;
        }
        return hwTimePicker.getHour();
    }

    public int getMinute() {
        HwTimePicker hwTimePicker = this.hwTimePicker;
        if (hwTimePicker == null) {
            return 0;
        }
        return hwTimePicker.getMinute();
    }

    @Override // android.app.Dialog
    public void show() {
        this.hwTimePicker.setCurrentTime(0, 0);
        super.show();
    }
}
