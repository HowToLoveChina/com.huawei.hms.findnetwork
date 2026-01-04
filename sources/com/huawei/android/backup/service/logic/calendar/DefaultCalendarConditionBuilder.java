package com.huawei.android.backup.service.logic.calendar;

import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.utils.C2157a;
import p385j5.C10710b;
import p385j5.InterfaceC10709a;

/* loaded from: classes.dex */
public class DefaultCalendarConditionBuilder implements InterfaceC10709a {
    private static final String GMAIL_CALENDAR_SELECTION = "(account_type = 'com.google')";
    private static final String HUAWEI_CALENDAR_SELECTION = " (organizer is 'Phone' OR organizer is 'PC Sync')";
    private static final String OTHER_PHONE_CALENDAR_SELECTION = "(account_name != 'local.samsungholiday' AND account_type != 'com.samsung.android.exchange' AND (account_name not like '%@%' OR account_type in ('LOCAL', 'local')))";
    private static final String TAG = "DefaultCalendarConditionBuilder";
    private Context context;
    private InterfaceC10709a orConditionBuilder = new C10710b();

    public static class GmailCalendarConditionBuilder implements InterfaceC10709a {
        private Context context;
        private boolean isConditionIgnore;

        public GmailCalendarConditionBuilder(Context context, boolean z10) {
            this.context = context;
            this.isConditionIgnore = z10;
        }

        @Override // p385j5.InterfaceC10709a
        public InterfaceC10709a addBuilder(InterfaceC10709a interfaceC10709a) {
            return this;
        }

        @Override // p385j5.InterfaceC10709a
        public String build() {
            if ("com.huawei.hidisk".equals(this.context.getPackageName())) {
                C2111d.m12653i(DefaultCalendarConditionBuilder.TAG, "hidisk do not support gmail calendar.");
                return "";
            }
            if (this.isConditionIgnore) {
                return DefaultCalendarConditionBuilder.GMAIL_CALENDAR_SELECTION;
            }
            if (BackupObject.isOppositePhoneSupportGms() || !C2157a.m13173H(this.context)) {
                return "";
            }
            C2111d.m12653i(DefaultCalendarConditionBuilder.TAG, "need to backup calendar of gmail account.");
            return DefaultCalendarConditionBuilder.GMAIL_CALENDAR_SELECTION;
        }
    }

    public DefaultCalendarConditionBuilder(Context context) {
        this.context = context;
        initBuilder();
    }

    private void initBuilder() {
        InterfaceC10709a interfaceC10709a = new InterfaceC10709a() { // from class: com.huawei.android.backup.service.logic.calendar.DefaultCalendarConditionBuilder.1
            @Override // p385j5.InterfaceC10709a
            public InterfaceC10709a addBuilder(InterfaceC10709a interfaceC10709a2) {
                return this;
            }

            @Override // p385j5.InterfaceC10709a
            public String build() {
                return C2157a.m13166A(DefaultCalendarConditionBuilder.this.context) ? DefaultCalendarConditionBuilder.HUAWEI_CALENDAR_SELECTION : "";
            }
        };
        this.orConditionBuilder.addBuilder(interfaceC10709a).addBuilder(new InterfaceC10709a() { // from class: com.huawei.android.backup.service.logic.calendar.DefaultCalendarConditionBuilder.2
            @Override // p385j5.InterfaceC10709a
            public InterfaceC10709a addBuilder(InterfaceC10709a interfaceC10709a2) {
                return this;
            }

            @Override // p385j5.InterfaceC10709a
            public String build() {
                return !C2157a.m13166A(DefaultCalendarConditionBuilder.this.context) ? DefaultCalendarConditionBuilder.OTHER_PHONE_CALENDAR_SELECTION : "";
            }
        });
    }

    @Override // p385j5.InterfaceC10709a
    public InterfaceC10709a addBuilder(InterfaceC10709a interfaceC10709a) {
        if (interfaceC10709a != null) {
            this.orConditionBuilder.addBuilder(interfaceC10709a);
        }
        return this;
    }

    @Override // p385j5.InterfaceC10709a
    public String build() {
        return "(" + this.orConditionBuilder.build() + ") And deleted = 0";
    }
}
