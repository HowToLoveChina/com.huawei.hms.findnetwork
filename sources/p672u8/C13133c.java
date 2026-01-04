package p672u8;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.android.backup.service.logic.calendar.CalendarConfigTable;
import com.huawei.android.hicloud.cloudspace.campaign.bean.CalendarEventBean;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;
import java.util.function.Function;
import p514o9.C11829c;
import p514o9.C11839m;

/* renamed from: u8.c */
/* loaded from: classes2.dex */
public class C13133c {
    /* renamed from: c */
    public static long m78992c(Context context) {
        Uri uriInsert;
        C11839m.m70688i("CalendarReminderUtils", "addCalendarAccount");
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "Cloud");
        contentValues.put("ownerAccount", "Cloud");
        contentValues.put("account_name", "Cloud");
        contentValues.put("account_type", "com.huawei.hidisk");
        contentValues.put("calendar_displayName", "Cloud");
        contentValues.put("calendar_access_level", Integer.valueOf(ErrorCode.ERROR_NATIVE_AD_NO));
        contentValues.put("calendar_timezone", TimeZone.getDefault().getID());
        contentValues.put("calendar_color", (Integer) (-16776961));
        contentValues.put("visible", (Integer) 1);
        contentValues.put("sync_events", (Integer) 1);
        contentValues.put("canOrganizerRespond", (Integer) 0);
        try {
            uriInsert = context.getContentResolver().insert(Uri.parse("content://com.android.calendar/calendars").buildUpon().appendQueryParameter("caller_is_syncadapter", FaqConstants.DISABLE_HA_REPORT).appendQueryParameter("account_type", "com.huawei.hidisk").appendQueryParameter("account_name", "Cloud").build(), contentValues);
        } catch (Exception e10) {
            C11839m.m70687e("CalendarReminderUtils", "addCalendarAccount e :" + e10.toString());
            uriInsert = null;
        }
        if (uriInsert == null) {
            return -1L;
        }
        return ContentUris.parseId(uriInsert);
    }

    /* renamed from: d */
    public static boolean m78993d(Context context, CalendarEventBean calendarEventBean) {
        if (context == null) {
            C11839m.m70687e("CalendarReminderUtils", "addCalendarEvent context null");
            return false;
        }
        if (calendarEventBean == null) {
            C11839m.m70687e("CalendarReminderUtils", "addCalendarEvent eventBean null");
            return false;
        }
        int iM78994e = m78994e(context);
        if (iM78994e < 0) {
            C11839m.m70687e("CalendarReminderUtils", "addCalendarEvent calId error");
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(CalendarConfigTable.CalendarTable.Events.CALENDAR_ID, Integer.valueOf(iM78994e));
        contentValues.put("title", calendarEventBean.getTitle());
        contentValues.put("description", calendarEventBean.getDescription());
        contentValues.put(CalendarConfigTable.CalendarTable.Events.DT_START, Long.valueOf(calendarEventBean.getStartTime()));
        contentValues.put(CalendarConfigTable.CalendarTable.Events.D_TEND, Long.valueOf(calendarEventBean.getStartTime() + C5863b6.g.f26453g));
        contentValues.put(CalendarConfigTable.CalendarTable.Events.HAS_ALARM, (Integer) 1);
        contentValues.put(CalendarConfigTable.CalendarTable.Events.EVENT_TIMEZONE, TimeZone.getDefault().getID());
        if ("1".equals(calendarEventBean.getRepeatPeriod())) {
            contentValues.put(CalendarConfigTable.CalendarTable.Events.R_RULE, "FREQ=DAILY;UNTIL=" + calendarEventBean.getEndDate());
        } else if ("2".equals(calendarEventBean.getRepeatPeriod())) {
            contentValues.put(CalendarConfigTable.CalendarTable.Events.R_RULE, "FREQ=WEEKLY;UNTIL=" + calendarEventBean.getEndDate());
        } else if ("3".equals(calendarEventBean.getRepeatPeriod())) {
            contentValues.put(CalendarConfigTable.CalendarTable.Events.R_RULE, "FREQ=MONTHLY;UNTIL=" + calendarEventBean.getEndDate());
        } else {
            contentValues.put(CalendarConfigTable.CalendarTable.Events.R_RULE, "FREQ=DAILY;UNTIL=" + calendarEventBean.getEndDate());
        }
        Uri uriInsert = context.getContentResolver().insert(Uri.parse("content://com.android.calendar/events"), contentValues);
        if (uriInsert == null) {
            C11839m.m70687e("CalendarReminderUtils", "addCalendarEvent failed");
            return false;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("event_id", Long.valueOf(ContentUris.parseId(uriInsert)));
        contentValues2.put(CalendarConfigTable.CalendarTable.Reminds.MINUTES, (Integer) 0);
        contentValues2.put("method", (Integer) 1);
        if (context.getContentResolver().insert(Uri.parse("content://com.android.calendar/reminders"), contentValues2) == null) {
            C11839m.m70687e("CalendarReminderUtils", "addCalendarEvent reminder failed");
            return false;
        }
        C11839m.m70688i("CalendarReminderUtils", "addCalendarEvent success");
        return true;
    }

    /* renamed from: e */
    public static int m78994e(Context context) {
        int iM78995f = m78995f(context);
        if (iM78995f >= 0) {
            return iM78995f;
        }
        if (m78992c(context) >= 0) {
            return m78995f(context);
        }
        return -1;
    }

    /* renamed from: f */
    public static int m78995f(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.android.calendar/calendars"), null, null, null, null);
            try {
                if (cursorQuery == null) {
                    C11839m.m70688i("CalendarReminderUtils", "userCursor null");
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return -1;
                }
                if (cursorQuery.getCount() <= 0) {
                    C11839m.m70687e("CalendarReminderUtils", "userCursor count < 0");
                    cursorQuery.close();
                    return -1;
                }
                cursorQuery.moveToFirst();
                int i10 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                cursorQuery.close();
                return i10;
            } finally {
            }
        } catch (Exception e10) {
            C11839m.m70687e("CalendarReminderUtils", "userCursor count: " + e10.getMessage());
            return -1;
        }
    }

    /* renamed from: g */
    public static String m78996g(String str) {
        return (String) Optional.ofNullable(str).map(new Function() { // from class: u8.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C13133c.m78998i((String) obj);
            }
        }).map(new Function() { // from class: u8.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C13133c.m78999j((Date) obj);
            }
        }).orElse(null);
    }

    /* renamed from: h */
    public static long m78997h() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 9);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    /* renamed from: i */
    public static /* synthetic */ Date m78998i(String str) {
        return C11829c.m70576f1("yyyy-MM-dd HH:mm:ss", str);
    }

    /* renamed from: j */
    public static /* synthetic */ String m78999j(Date date) {
        return C11829c.m70622v("yyyyMMdd'T'HHmmss", date.getTime());
    }

    /* renamed from: k */
    public static boolean m79000k(Context context, CalendarEventBean calendarEventBean) {
        Cursor cursorQuery;
        if (context == null) {
            C11839m.m70687e("CalendarReminderUtils", "queryCalendarEvent context null");
            return false;
        }
        String title = calendarEventBean.getTitle();
        String description = calendarEventBean.getDescription();
        if (title == null || description == null) {
            C11839m.m70687e("CalendarReminderUtils", "title or description is null");
            return false;
        }
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.android.calendar/events"), null, "(title = ?) AND (description = ?)", new String[]{title, description}, null);
        } catch (Throwable th2) {
            C11839m.m70687e("CalendarReminderUtils", "queryCalendarEvent Exception:" + th2.getMessage());
        }
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        int columnIndex = cursorQuery.getColumnIndex("title");
                        int columnIndex2 = cursorQuery.getColumnIndex("description");
                        String string = cursorQuery.getString(columnIndex);
                        String string2 = cursorQuery.getString(columnIndex2);
                        if (title.equals(string) && description.equals(string2)) {
                            C11839m.m70687e("CalendarReminderUtils", "queryCalendarEvent found:" + string + " " + string2);
                            cursorQuery.close();
                            return true;
                        }
                    }
                    cursorQuery.close();
                    C11839m.m70688i("CalendarReminderUtils", "queryCalendarEvent false");
                    return false;
                }
            } finally {
            }
        }
        C11839m.m70687e("CalendarReminderUtils", "queryCalendarEvent eventCursor null");
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }
}
