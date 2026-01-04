package com.huawei.openalliance.p169ad.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.huawei.android.backup.service.logic.calendar.CalendarConfigTable;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.beans.AgendaBean;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.views.PPSWebView;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: com.huawei.openalliance.ad.utils.av */
/* loaded from: classes2.dex */
public class C7748av {

    /* renamed from: a */
    private static String[] f35848a = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};

    /* renamed from: b */
    private static String[] f35849b = {"android.permission.READ_CALENDAR"};

    /* renamed from: c */
    private static String[] f35850c;

    /* renamed from: d */
    private static String[] f35851d;

    /* renamed from: e */
    private Context f35852e;

    /* renamed from: f */
    private ContentRecord f35853f;

    /* renamed from: g */
    private PPSWebView f35854g;

    /* renamed from: h */
    private C6928i f35855h;

    /* renamed from: i */
    private String f35856i;

    /* renamed from: j */
    private AgendaBean f35857j;

    /* renamed from: k */
    private String f35858k;

    /* renamed from: l */
    private String f35859l;

    /* renamed from: m */
    private boolean f35860m = false;

    /* renamed from: com.huawei.openalliance.ad.utils.av$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7748av c7748av = C7748av.this;
            c7748av.f35860m = AbstractC7784cd.m47889b(c7748av.f35852e, "android.permission.READ_CALENDAR");
            if (C7748av.this.f35860m) {
                String[] unused = C7748av.f35851d = C7748av.f35848a;
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.av$10 */
    public class AnonymousClass10 implements Runnable {
        public AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7748av c7748av = C7748av.this;
            if (c7748av.m47620a(c7748av.f35859l)) {
                C7748av.this.f35854g.getWebView().loadUrl("javascript:" + C7748av.this.f35859l + "(5)");
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.av$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f35863a;

        /* renamed from: b */
        final /* synthetic */ int f35864b;

        /* renamed from: c */
        final /* synthetic */ int f35865c;

        public AnonymousClass2(String str, int i10, int i11) {
            str = str;
            i = i10;
            i = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7748av.this.m47620a(str)) {
                C7748av.this.f35854g.getWebView().loadUrl("javascript:" + str + "(" + i + ")");
            }
            C7748av c7748av = C7748av.this;
            if (c7748av.m47616a(c7748av.f35853f)) {
                return;
            }
            Toast.makeText(C7748av.this.f35852e.getApplicationContext(), i, 0).show();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.av$3 */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7748av.this.m47628d();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.av$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7748av.this.m47633f();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.av$5 */
    public class AnonymousClass5 implements DialogInterface.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C7748av.this.m47630e();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.av$6 */
    public class AnonymousClass6 implements DialogInterface.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "cancel failed: not allowed");
            C7748av c7748av = C7748av.this;
            c7748av.m47614a(c7748av.f35859l, 4, C6849R.string.hiad_calender_cancel_failed);
            C7748av.this.f35855h.m39215c(C7748av.this.f35853f, 4);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.av$7 */
    public class AnonymousClass7 implements DialogInterface.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C7748av.this.m47635g();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.av$8 */
    public class AnonymousClass8 implements DialogInterface.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "appoint failed: not allowed");
            C7748av c7748av = C7748av.this;
            c7748av.m47614a(c7748av.f35856i, 4, C6849R.string.hiad_calender_appoint_failed);
            C7748av.this.f35855h.m39199a(C7748av.this.f35853f, 4);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.av$9 */
    public class AnonymousClass9 implements Runnable {
        public AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7748av c7748av = C7748av.this;
            if (c7748av.m47620a(c7748av.f35856i)) {
                C7748av.this.f35854g.getWebView().loadUrl("javascript:" + C7748av.this.f35856i + "(5)");
            }
        }
    }

    static {
        String[] strArr = {"android.permission.WRITE_CALENDAR"};
        f35850c = strArr;
        f35851d = strArr;
    }

    public C7748av(Context context, ContentRecord contentRecord, PPSWebView pPSWebView) {
        AbstractC7185ho.m43820b("IPPSAppointJs", "IPPSAppointJs init");
        this.f35852e = context;
        this.f35853f = contentRecord;
        this.f35854g = pPSWebView;
        this.f35855h = new C6928i(context);
        m47626c();
    }

    /* renamed from: a */
    private long m47611a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    /* renamed from: b */
    private void m47622b(String str) {
        try {
            Uri uri = Uri.parse("content://com.android.calendar/events");
            if (!AbstractC7741ao.m47563b(this.f35852e, uri)) {
                AbstractC7185ho.m43823c("IPPSAppointJs", "provider uri invalid.");
                m47614a(this.f35859l, 9, C6849R.string.hiad_calender_cancel_failed);
                this.f35855h.m39215c(this.f35853f, 9);
            } else if (this.f35852e.getContentResolver().delete(uri, "title=?", new String[]{str}) == -1) {
                AbstractC7185ho.m43823c("IPPSAppointJs", "cancel failed: delete error");
                m47614a(this.f35859l, 7, C6849R.string.hiad_calender_cancel_failed);
                this.f35855h.m39215c(this.f35853f, 7);
            } else {
                AbstractC7185ho.m43820b("IPPSAppointJs", "cancel success");
                m47614a(this.f35859l, 0, C6849R.string.hiad_calender_cancel_success);
                this.f35855h.m39210b(this.f35853f, 0);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "cancel failed: delete error= " + th2.getClass().getSimpleName());
            m47614a(this.f35859l, 7, C6849R.string.hiad_calender_cancel_failed);
            this.f35855h.m39215c(this.f35853f, 7);
        }
    }

    /* renamed from: c */
    private void m47626c() {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.av.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C7748av c7748av = C7748av.this;
                c7748av.f35860m = AbstractC7784cd.m47889b(c7748av.f35852e, "android.permission.READ_CALENDAR");
                if (C7748av.this.f35860m) {
                    String[] unused = C7748av.f35851d = C7748av.f35848a;
                }
            }
        });
    }

    /* renamed from: d */
    public void m47628d() {
        new AlertDialog.Builder(this.f35852e).setTitle(C6849R.string.hiad_calender_dialog).setMessage(C6849R.string.hiad_calender_cancel_dialog_message).setNegativeButton(C6849R.string.hiad_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.utils.av.6
            public AnonymousClass6() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                AbstractC7185ho.m43823c("IPPSAppointJs", "cancel failed: not allowed");
                C7748av c7748av = C7748av.this;
                c7748av.m47614a(c7748av.f35859l, 4, C6849R.string.hiad_calender_cancel_failed);
                C7748av.this.f35855h.m39215c(C7748av.this.f35853f, 4);
            }
        }).setPositiveButton(C6849R.string.hiad_calender_delete, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.utils.av.5
            public AnonymousClass5() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                C7748av.this.m47630e();
            }
        }).setCancelable(false).create().show();
    }

    /* renamed from: e */
    public void m47630e() {
        if (AbstractC7784cd.m47888a(this.f35852e, f35851d)) {
            m47622b(this.f35858k);
        } else {
            AbstractC7185ho.m43820b("IPPSAppointJs", "cancel, request permissions");
            AbstractC7784cd.m47884a((Activity) this.f35852e, f35851d, 12);
        }
    }

    /* renamed from: h */
    private int m47636h() {
        Cursor cursorQuery = this.f35852e.getContentResolver().query(Uri.parse("content://com.android.calendar/calendars"), null, null, null, null);
        if (cursorQuery == null) {
            if (cursorQuery != null) {
            }
            return -1;
        }
        try {
            if (cursorQuery.getCount() <= 0) {
                return -1;
            }
            cursorQuery.moveToFirst();
            return cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
        } finally {
            cursorQuery.close();
        }
    }

    /* renamed from: i */
    private long m47638i() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", NotifyConstants.HICLOUD_PPS);
            contentValues.put("account_type", "com.android.huawei");
            contentValues.put("account_name", NotifyConstants.HICLOUD_PPS);
            contentValues.put("calendar_displayName", "PPS账户");
            contentValues.put("calendar_color", (Integer) (-16776961));
            contentValues.put("visible", (Integer) 1);
            contentValues.put("calendar_access_level", Integer.valueOf(ErrorCode.ERROR_NATIVE_AD_NO));
            contentValues.put("ownerAccount", NotifyConstants.HICLOUD_PPS);
            contentValues.put("sync_events", (Integer) 1);
            contentValues.put("calendar_timezone", timeZone.getID());
            contentValues.put("canOrganizerRespond", (Integer) 0);
            Uri uriBuild = Uri.parse("content://com.android.calendar/calendars").buildUpon().appendQueryParameter("caller_is_syncadapter", FaqConstants.DISABLE_HA_REPORT).appendQueryParameter("account_type", "com.android.huawei").appendQueryParameter("account_name", NotifyConstants.HICLOUD_PPS).build();
            if (!AbstractC7741ao.m47563b(this.f35852e, uriBuild)) {
                AbstractC7185ho.m43823c("IPPSAppointJs", "provider uri invalid.");
                return -1L;
            }
            Uri uriInsert = this.f35852e.getContentResolver().insert(uriBuild, contentValues);
            if (uriInsert == null) {
                return -1L;
            }
            return ContentUris.parseId(uriInsert);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "addCalendarAccount error: " + th2.getClass().getSimpleName());
            return -1L;
        }
    }

    /* renamed from: j */
    private int m47640j() {
        if (!this.f35860m) {
            return 1;
        }
        int iM47636h = m47636h();
        if (iM47636h >= 0) {
            return iM47636h;
        }
        if (m47638i() >= 0) {
            return m47636h();
        }
        return -1;
    }

    /* renamed from: k */
    private Cursor m47642k() {
        try {
            Uri uri = Uri.parse("content://com.android.calendar/events");
            if (!AbstractC7741ao.m47563b(this.f35852e, uri)) {
                AbstractC7185ho.m43823c("IPPSAppointJs", "provider uri invalid.");
                return null;
            }
            if (this.f35857j.m39250e() == 0) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(this.f35857j.m39248c());
                long time = calendar.getTime().getTime();
                calendar.setTimeInMillis(this.f35857j.m39249d());
                return this.f35852e.getContentResolver().query(uri, null, "title=? and dtstart=? and dtend=?", new String[]{this.f35857j.m39245a(), String.valueOf(time), String.valueOf(calendar.getTime().getTime())}, null);
            }
            long jM47611a = m47611a(new Date(this.f35857j.m39248c()));
            long jM47611a2 = m47611a(new Date(this.f35857j.m39249d()));
            if (jM47611a == jM47611a2 || this.f35857j.m39249d() >= jM47611a2) {
                AbstractC7185ho.m43817a("IPPSAppointJs", "add one day");
                jM47611a2 += 86400000;
            }
            AbstractC7185ho.m43824c("IPPSAppointJs", "startTime = %s   endTime= %s", Long.valueOf(jM47611a), Long.valueOf(jM47611a2));
            return this.f35852e.getContentResolver().query(uri, null, "title=? and dtstart=? and dtend=?", new String[]{this.f35857j.m39245a(), String.valueOf(jM47611a), String.valueOf(jM47611a2)}, null);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "query failed: error= " + th2.getClass().getSimpleName());
            return null;
        }
    }

    @JavascriptInterface
    public void appoint(String str, String str2) {
        AbstractC7185ho.m43820b("IPPSAppointJs", "call appoint from js");
        if (AbstractC7806cz.m48165b(str)) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "appoint failed: missing required parameters");
            m47614a(str2, 1, C6849R.string.hiad_calender_appoint_failed);
            this.f35855h.m39199a(this.f35853f, 1);
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("IPPSAppointJs", "appoint info= %s", str);
        }
        if (AbstractC7806cz.m48165b(str2)) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "appoint, recall funcName is empty.");
        }
        AgendaBean agendaBean = (AgendaBean) AbstractC7758be.m47739b(str, AgendaBean.class, new Class[0]);
        if (agendaBean == null) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "appoint failed: missing required parameters");
            m47614a(str2, 1, C6849R.string.hiad_calender_appoint_failed);
            this.f35855h.m39199a(this.f35853f, 1);
            return;
        }
        if (m47623b(agendaBean) || m47615a(agendaBean)) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "appoint failed: missing required parameters");
            m47614a(str2, 1, C6849R.string.hiad_calender_appoint_failed);
            this.f35855h.m39199a(this.f35853f, 1);
        } else {
            if (agendaBean.m39248c() < System.currentTimeMillis()) {
                AbstractC7185ho.m43823c("IPPSAppointJs", "appoint failed: date start time before now");
                m47614a(str2, 2, C6849R.string.hiad_calender_appoint_failed);
                this.f35855h.m39199a(this.f35853f, 2);
                return;
            }
            if (agendaBean.m39250e() != 1 && agendaBean.m39250e() != 0) {
                agendaBean.m39246a(0);
            }
            this.f35857j = agendaBean;
            this.f35856i = str2;
            if (m47616a(this.f35853f)) {
                m47635g();
            } else {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.av.4
                    public AnonymousClass4() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7748av.this.m47633f();
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void cancel(String str, String str2) {
        if (AbstractC7806cz.m48165b(str)) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "cancel failed, title is empty.");
            m47614a(str2, 1, C6849R.string.hiad_calender_cancel_failed);
            this.f35855h.m39215c(this.f35853f, 1);
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("IPPSAppointJs", "cancel title= %s", str);
        }
        if (AbstractC7806cz.m48165b(str2)) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "cancel, recall funcName is empty.");
        }
        this.f35859l = str2;
        this.f35858k = str;
        if (m47616a(this.f35853f)) {
            m47630e();
        } else {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.av.3
                public AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7748av.this.m47628d();
                }
            });
        }
    }

    /* renamed from: f */
    public void m47633f() {
        new AlertDialog.Builder(this.f35852e).setTitle(C6849R.string.hiad_calender_dialog).setMessage(C6849R.string.hiad_calender_appoint_dialog_message).setNegativeButton(C6849R.string.hiad_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.utils.av.8
            public AnonymousClass8() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                AbstractC7185ho.m43823c("IPPSAppointJs", "appoint failed: not allowed");
                C7748av c7748av = C7748av.this;
                c7748av.m47614a(c7748av.f35856i, 4, C6849R.string.hiad_calender_appoint_failed);
                C7748av.this.f35855h.m39199a(C7748av.this.f35853f, 4);
            }
        }).setPositiveButton(C6849R.string.hiad_calender_add, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.utils.av.7
            public AnonymousClass7() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                C7748av.this.m47635g();
            }
        }).setCancelable(false).create().show();
    }

    /* renamed from: g */
    public void m47635g() {
        if (!AbstractC7784cd.m47888a(this.f35852e, f35851d)) {
            AbstractC7185ho.m43820b("IPPSAppointJs", "request permissions");
            AbstractC7784cd.m47884a((Activity) this.f35852e, f35851d, 11);
        } else {
            if (!m47646a()) {
                m47644a(this.f35857j, this.f35856i);
                return;
            }
            AbstractC7185ho.m43823c("IPPSAppointJs", "appoint failed: already appointed");
            m47614a(this.f35856i, 3, C6849R.string.hiad_calender_already_appoint);
            this.f35855h.m39199a(this.f35853f, 3);
        }
    }

    /* renamed from: b */
    public void m47647b(boolean z10, boolean z11) {
        if (z10) {
            m47622b(this.f35858k);
            return;
        }
        AbstractC7185ho.m43823c("IPPSAppointJs", "cancel failed, not allowed permissions");
        if (z11) {
            m47614a(this.f35859l, 5, C6849R.string.hiad_calender_cancel_failed);
        } else {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.av.10
                public AnonymousClass10() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7748av c7748av = C7748av.this;
                    if (c7748av.m47620a(c7748av.f35859l)) {
                        C7748av.this.f35854g.getWebView().loadUrl("javascript:" + C7748av.this.f35859l + "(5)");
                    }
                }
            });
        }
        this.f35855h.m39215c(this.f35853f, 5);
    }

    /* renamed from: b */
    private boolean m47623b(AgendaBean agendaBean) {
        return AbstractC7806cz.m48165b(agendaBean.m39245a()) || AbstractC7806cz.m48165b(agendaBean.m39253h());
    }

    /* renamed from: a */
    public void m47644a(AgendaBean agendaBean, String str) {
        String strM39251f;
        int iM47640j = m47640j();
        if (iM47640j < 0) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "appoint failed: get calendar account error");
            m47614a(this.f35856i, 6, C6849R.string.hiad_calender_appoint_failed);
            this.f35855h.m39199a(this.f35853f, 6);
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", agendaBean.m39245a());
            contentValues.put("description", agendaBean.m39253h());
            contentValues.put(CalendarConfigTable.CalendarTable.Events.EVENT_LOCATION, agendaBean.m39247b());
            contentValues.put(CalendarConfigTable.CalendarTable.Events.CALENDAR_ID, Integer.valueOf(iM47640j));
            if (agendaBean.m39250e() == 0) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(agendaBean.m39248c());
                contentValues.put(CalendarConfigTable.CalendarTable.Events.DT_START, Long.valueOf(calendar.getTime().getTime()));
                calendar.setTimeInMillis(agendaBean.m39249d());
                contentValues.put(CalendarConfigTable.CalendarTable.Events.D_TEND, Long.valueOf(calendar.getTime().getTime()));
                strM39251f = agendaBean.m39251f();
            } else {
                long jM47611a = m47611a(new Date(agendaBean.m39248c()));
                long jM47611a2 = m47611a(new Date(agendaBean.m39249d()));
                if (jM47611a == jM47611a2 || agendaBean.m39249d() >= jM47611a2) {
                    AbstractC7185ho.m43817a("IPPSAppointJs", "add one day");
                    jM47611a2 += 86400000;
                }
                contentValues.put(CalendarConfigTable.CalendarTable.Events.DT_START, Long.valueOf(jM47611a));
                contentValues.put(CalendarConfigTable.CalendarTable.Events.D_TEND, Long.valueOf(jM47611a2));
                strM39251f = "UTC";
            }
            contentValues.put(CalendarConfigTable.CalendarTable.Events.EVENT_TIMEZONE, strM39251f);
            contentValues.put(CalendarConfigTable.CalendarTable.Events.ALL_DAY, Integer.valueOf(agendaBean.m39250e()));
            contentValues.put(CalendarConfigTable.CalendarTable.Events.HAS_ALARM, (Integer) 1);
            contentValues.put(CalendarConfigTable.CalendarTable.Events.GUESTS_CAN_MODIFY, (Integer) 1);
            Uri uri = Uri.parse("content://com.android.calendar/events");
            if (!AbstractC7741ao.m47563b(this.f35852e, uri)) {
                AbstractC7185ho.m43823c("IPPSAppointJs", "provider uri invalid.");
                m47614a(this.f35856i, 9, C6849R.string.hiad_calender_appoint_failed);
                this.f35855h.m39199a(this.f35853f, 9);
                return;
            }
            Uri uriInsert = this.f35852e.getContentResolver().insert(uri, contentValues);
            if (uriInsert == null) {
                AbstractC7185ho.m43823c("IPPSAppointJs", "appoint failed: insert error");
                m47614a(this.f35856i, 7, C6849R.string.hiad_calender_appoint_failed);
                this.f35855h.m39199a(this.f35853f, 7);
                return;
            }
            AbstractC7185ho.m43820b("IPPSAppointJs", "appoint success");
            m47614a(this.f35856i, 0, C6849R.string.hiad_calender_appoint_success);
            this.f35855h.m39223g(this.f35853f);
            if (agendaBean.m39252g() == null || agendaBean.m39252g().intValue() < 0) {
                return;
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("event_id", Long.valueOf(ContentUris.parseId(uriInsert)));
            contentValues2.put(CalendarConfigTable.CalendarTable.Reminds.MINUTES, agendaBean.m39252g());
            contentValues2.put("method", (Integer) 1);
            Uri uri2 = Uri.parse("content://com.android.calendar/reminders");
            if (!AbstractC7741ao.m47563b(this.f35852e, uri2)) {
                AbstractC7185ho.m43823c("IPPSAppointJs", "provider uri invalid.");
            } else if (this.f35852e.getContentResolver().insert(uri2, contentValues2) == null) {
                AbstractC7185ho.m43823c("IPPSAppointJs", "add reminds error");
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "addCalendarEvent error: " + th2.getClass().getSimpleName());
            m47614a(this.f35856i, 7, C6849R.string.hiad_calender_appoint_failed);
            this.f35855h.m39199a(this.f35853f, 7);
        }
    }

    /* renamed from: a */
    public void m47614a(String str, int i10, int i11) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.av.2

            /* renamed from: a */
            final /* synthetic */ String f35863a;

            /* renamed from: b */
            final /* synthetic */ int f35864b;

            /* renamed from: c */
            final /* synthetic */ int f35865c;

            public AnonymousClass2(String str2, int i102, int i112) {
                str = str2;
                i = i102;
                i = i112;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C7748av.this.m47620a(str)) {
                    C7748av.this.f35854g.getWebView().loadUrl("javascript:" + str + "(" + i + ")");
                }
                C7748av c7748av = C7748av.this;
                if (c7748av.m47616a(c7748av.f35853f)) {
                    return;
                }
                Toast.makeText(C7748av.this.f35852e.getApplicationContext(), i, 0).show();
            }
        });
    }

    /* renamed from: a */
    public void m47645a(boolean z10, boolean z11) {
        if (!z10) {
            AbstractC7185ho.m43823c("IPPSAppointJs", "appoint failed: not allowed permissions");
            if (z11) {
                m47614a(this.f35856i, 5, C6849R.string.hiad_calender_appoint_failed);
            } else {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.av.9
                    public AnonymousClass9() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7748av c7748av = C7748av.this;
                        if (c7748av.m47620a(c7748av.f35856i)) {
                            C7748av.this.f35854g.getWebView().loadUrl("javascript:" + C7748av.this.f35856i + "(5)");
                        }
                    }
                });
            }
            this.f35855h.m39199a(this.f35853f, 5);
            return;
        }
        if (!m47646a()) {
            m47644a(this.f35857j, this.f35856i);
            return;
        }
        AbstractC7185ho.m43823c("IPPSAppointJs", "appoint failed: already appointed");
        m47614a(this.f35856i, 3, C6849R.string.hiad_calender_already_appoint);
        this.f35855h.m39199a(this.f35853f, 3);
    }

    /* renamed from: a */
    public boolean m47646a() {
        if (!this.f35860m) {
            return false;
        }
        Cursor cursorM47642k = m47642k();
        if (cursorM47642k != null) {
            try {
                if (cursorM47642k.getCount() > 0) {
                    cursorM47642k.close();
                    return true;
                }
            } finally {
                cursorM47642k.close();
            }
        }
        if (cursorM47642k != null) {
        }
        return false;
    }

    /* renamed from: a */
    private boolean m47615a(AgendaBean agendaBean) {
        return agendaBean.m39248c() <= 0 || agendaBean.m39249d() <= 0 || agendaBean.m39248c() > agendaBean.m39249d() || AbstractC7806cz.m48165b(agendaBean.m39251f());
    }

    /* renamed from: a */
    public boolean m47616a(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return false;
        }
        return "2".equals(contentRecord.m41483ae()) || "1".equals(contentRecord.m41483ae());
    }

    /* renamed from: a */
    public boolean m47620a(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return false;
        }
        return str.matches("^[0-9a-zA-Z_]+$");
    }
}
