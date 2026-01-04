package com.huawei.android.backup.service.logic.calendar;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.calendar.CalendarConfigTable;
import com.huawei.android.backup.service.logic.calendar.DefaultCalendarConditionBuilder;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import p006a5.AbstractC0048c;

/* loaded from: classes.dex */
public class BackupCalendarImp extends BackupCalendar {
    public static final String AUTHORITY = "com.android.calendar";
    private static final String COLON = ":";
    private static final String NEW_LINE = "\r\n";
    private static final int PAGE_SIZE = 1000;
    private static final String PHONE = "Phone";
    private static final int READ_SIZE = 500;
    private static final String TAG = "BackupCalendarImp";
    private static Set<String> calendarFieldSet = new HashSet();
    private String[] eventProjection = null;
    private String[] extendedProjection = null;
    private String[] reminderProjection = null;
    private String[] attendeeProjection = null;
    private int eventBackupSuccess = 0;
    private int curRestoreIndex = 0;
    private Set<Integer> localEventsDataHash = null;

    public static class CalendarBuild {
        private String accessLevel;
        private String allDay;
        private String availability;
        private String deleted;
        private String description;
        private String dtend;
        private String dtstart;
        private String duration;
        private String eventColor;
        private String eventColorIndex;
        private String eventEndTimezone;
        private String eventLocation;
        private String eventStatus;
        private String eventTimezone;
        private String exdate;
        private String exrule;
        private String guestsCanInviteOthers;
        private String guestsCanModify;
        private String guestsCanSeeGuests;
        private String hasAlarm;
        private String hasAttendeeData;
        private String hasExtendedProperties;
        private String lastDate;
        private ArrayList<String> methodList;
        private ArrayList<String> minuteList;
        private ArrayList<String> nameList;
        private String organizer;
        private String originalAllDay;
        private String originalID;
        private String originalInstanceTime;
        private String originalSyncID;
        private String rdate;
        private String rrule;
        private String selfAttendeeStatus;
        private String syncAccount;
        private String syncAccountType;
        private String syncDirty;
        private String syncTime;
        private String title;
        private String transparency;
        private ArrayList<String> valueList;
        private String visibility;

        private void appendField(StringBuffer stringBuffer, String str, List<String> list) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                appendField(stringBuffer, str, it.next());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String formatCalendarBuild() {
            StringBuffer stringBuffer = new StringBuffer("BEGIN:VCALENDAR");
            stringBuffer.append(BackupCalendarImp.NEW_LINE);
            stringBuffer.append("VERSION:2.1");
            stringBuffer.append(BackupCalendarImp.NEW_LINE);
            appendField(stringBuffer, "title:", this.title);
            appendField(stringBuffer, "eventLocation:", this.eventLocation);
            appendField(stringBuffer, "description:", this.description);
            appendField(stringBuffer, "eventStatus:", this.eventStatus);
            appendField(stringBuffer, "selfAttendeeStatus:", this.selfAttendeeStatus);
            appendField(stringBuffer, "dtstart:", this.dtstart);
            appendField(stringBuffer, "dtend:", this.dtend);
            appendField(stringBuffer, "eventTimezone:", this.eventTimezone);
            appendField(stringBuffer, "duration:", this.duration);
            appendField(stringBuffer, "allDay:", this.allDay);
            appendField(stringBuffer, "visibility:", this.visibility);
            appendField(stringBuffer, "transparency:", this.transparency);
            appendField(stringBuffer, "hasAlarm:", this.hasAlarm);
            appendField(stringBuffer, "hasExtendedProperties:", this.hasExtendedProperties);
            appendField(stringBuffer, "rrule:", this.rrule);
            appendField(stringBuffer, "rdate:", this.rdate);
            appendField(stringBuffer, "exrule:", this.exrule);
            appendField(stringBuffer, "exdate:", this.exdate);
            appendField(stringBuffer, "originalEvent:", this.eventLocation);
            appendField(stringBuffer, "originalInstanceTime:", this.originalInstanceTime);
            appendField(stringBuffer, "originalAllDay:", this.originalAllDay);
            appendField(stringBuffer, "lastDate:", this.lastDate);
            appendField(stringBuffer, "hasAttendeeData:", this.hasAttendeeData);
            appendField(stringBuffer, "guestsCanModify:", this.guestsCanModify);
            appendField(stringBuffer, "guestsCanInviteOthers:", this.guestsCanInviteOthers);
            appendField(stringBuffer, "guestsCanSeeGuests:", this.guestsCanSeeGuests);
            appendField(stringBuffer, "organizer:", this.organizer);
            appendField(stringBuffer, "deleted:", this.deleted);
            appendField(stringBuffer, "accessLevel:", this.accessLevel);
            appendField(stringBuffer, "availability:", this.availability);
            appendField(stringBuffer, "originalSyncId:", this.originalSyncID);
            appendField(stringBuffer, "eventEndTimezone:", this.eventEndTimezone);
            appendField(stringBuffer, "eventColor:", this.eventColor);
            appendField(stringBuffer, "eventColorIndex:", this.eventColorIndex);
            appendField(stringBuffer, "originalId:", this.originalID);
            appendField(stringBuffer, "syncAccount:", this.syncAccount);
            appendField(stringBuffer, "syncAccountType:", this.syncAccountType);
            appendField(stringBuffer, "syncTime:", this.syncTime);
            appendField(stringBuffer, "syncDirty:", this.syncDirty);
            appendField(stringBuffer, CalendarConfigTable.CalendarTable.Events.REMINDERS_METHOD, this.minuteList);
            appendField(stringBuffer, CalendarConfigTable.CalendarTable.Events.REMINDERS_METHOD, this.methodList);
            appendField(stringBuffer, CalendarConfigTable.CalendarTable.ExtendedProperties.EXTENDED_PROPERTIES_NAME, this.nameList);
            appendField(stringBuffer, CalendarConfigTable.CalendarTable.ExtendedProperties.EXTENDED_PROPERTIES_VALUE, this.valueList);
            stringBuffer.append("END:VCALENDAR");
            stringBuffer.append(BackupCalendarImp.NEW_LINE);
            return new String(stringBuffer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setField(ContentValues contentValues) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                if (entry.getValue() != null) {
                    String key = entry.getKey();
                    if (BackupCalendarImp.calendarFieldSet.contains(key)) {
                        String string = entry.getValue().toString();
                        try {
                            Field declaredField = getClass().getDeclaredField(key);
                            Object obj = declaredField.get(this);
                            if (obj instanceof ArrayList) {
                                ((ArrayList) obj).add(string);
                            } else {
                                declaredField.set(this, string);
                            }
                        } catch (IllegalAccessException unused) {
                            C2111d.m12648d(BackupCalendarImp.TAG, "setField IllegalAccessException");
                        } catch (IllegalArgumentException unused2) {
                            C2111d.m12648d(BackupCalendarImp.TAG, "setField IllegalArgumentException");
                        } catch (NoSuchFieldException unused3) {
                            C2111d.m12648d(BackupCalendarImp.TAG, "setField NoSuchFieldException");
                        } catch (Exception unused4) {
                            C2111d.m12648d(BackupCalendarImp.TAG, "setField Exception error");
                        }
                    }
                }
            }
        }

        private CalendarBuild() {
            this.title = "";
            this.eventLocation = "";
            this.description = "";
            this.eventStatus = "";
            this.selfAttendeeStatus = "";
            this.dtstart = "";
            this.dtend = "";
            this.eventTimezone = "";
            this.duration = "";
            this.allDay = "";
            this.visibility = "";
            this.transparency = "";
            this.hasAlarm = "";
            this.hasExtendedProperties = "";
            this.rrule = "";
            this.rdate = "";
            this.exrule = "";
            this.exdate = "";
            this.originalInstanceTime = "";
            this.originalAllDay = "";
            this.lastDate = "";
            this.hasAttendeeData = "";
            this.guestsCanModify = "";
            this.guestsCanInviteOthers = "";
            this.guestsCanSeeGuests = "";
            this.organizer = "";
            this.deleted = "";
            this.accessLevel = "";
            this.availability = "";
            this.originalSyncID = "";
            this.eventEndTimezone = "";
            this.eventColor = "";
            this.eventColorIndex = "";
            this.originalID = "";
            this.syncAccount = "";
            this.syncAccountType = "";
            this.syncTime = "";
            this.syncDirty = "";
            this.minuteList = new ArrayList<>();
            this.methodList = new ArrayList<>();
            this.nameList = new ArrayList<>();
            this.valueList = new ArrayList<>();
        }

        private void appendField(StringBuffer stringBuffer, String str, String str2) {
            if (C2157a.m13170E(str2)) {
                return;
            }
            stringBuffer.append(str);
            stringBuffer.append(str2);
            stringBuffer.append(BackupCalendarImp.NEW_LINE);
        }
    }

    public static class CalendarHashCallBack implements GetHashCallBack {
        private CalendarHashCallBack() {
        }

        @Override // com.huawei.android.backup.service.logic.calendar.BackupCalendarImp.GetHashCallBack
        public void callBack(Iterator<ContentValues> it, Set<Integer> set, int i10) {
            if (set != null) {
                set.add(Integer.valueOf(i10));
            }
            if (it != null) {
                it.remove();
            }
        }
    }

    public interface GetHashCallBack {
        void callBack(Iterator<ContentValues> it, Set<Integer> set, int i10);
    }

    static {
        for (Field field : CalendarBuild.class.getDeclaredFields()) {
            calendarFieldSet.add(field.getName());
        }
    }

    private void addOperations(List<ContentProviderOperation> list, Uri uri, Set<ContentValues> set) {
        for (ContentValues contentValues : set) {
            ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(uri);
            builderNewInsert.withValueBackReference("event_id", 0);
            if (contentValues != null) {
                builderNewInsert.withValues(contentValues);
                list.add(builderNewInsert.build());
            }
        }
    }

    private boolean applyBatchRestore(Context context, ContentValues contentValues, Set<ContentValues> set, Set<ContentValues> set2, Set<ContentValues> set3) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        contentValues.remove("_id");
        arrayList.add(ContentProviderOperation.newInsert(CalendarConfigTable.CalendarTable.Events.URI).withValues(contentValues).build());
        if (set2 != null) {
            addOperations(arrayList, CalendarConfigTable.CalendarTable.Reminds.URI, set2);
        }
        try {
            return context.getContentResolver().applyBatch("com.android.calendar", arrayList) != null;
        } catch (RemoteException e10) {
            C2111d.m12649e(TAG, "calendar restore failed RemoteException ", e10.getMessage());
            return false;
        } catch (IllegalArgumentException e11) {
            C2111d.m12649e(TAG, "calendar restore failed IllegalArgumentException ", e11.getMessage());
            return false;
        } catch (Exception unused) {
            C2111d.m12648d(TAG, "calendar restore failed.");
            return false;
        }
    }

    private void backupEvents(Context context, AbstractC0048c abstractC0048c, ContentValues[] contentValuesArr, Handler.Callback callback, Object obj) {
        C2111d.m12653i(TAG, "backupEvents begin.");
        int length = contentValuesArr.length;
        for (int i10 = 0; i10 < length && !BackupObject.isAbort(); i10++) {
            try {
                if (!C2157a.m13166A(context) && TextUtils.isEmpty(contentValuesArr[i10].getAsString("duration")) && contentValuesArr[i10].getAsInteger(CalendarConfigTable.CalendarTable.Events.D_TEND) == null) {
                    C2111d.m12653i(TAG, "calendar is not HwPhone, duration and dtend both null");
                } else if (abstractC0048c.m185A(CalendarConfigTable.CalendarTable.Events.BACK_TABLE, contentValuesArr[i10]) == 1) {
                    sendMsg(0, i10 + 1, length, callback, obj);
                    this.eventBackupSuccess++;
                } else {
                    sendMsg(2, i10 + 1, length, callback, obj);
                }
            } catch (Exception unused) {
                C2111d.m12648d(TAG, "calendar write events values failed.");
                sendMsg(2, i10 + 1, length, callback, obj);
            }
        }
    }

    private String[] backupProjection(String[] strArr, Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private void buildLocalMap(ContentValues[] contentValuesArr, Map<Long, LinkedHashSet<ContentValues>> map, String str) {
        for (ContentValues contentValues : contentValuesArr) {
            if (contentValues != null && contentValues.get(str) != null) {
                Long asLong = contentValues.getAsLong(str);
                if (map.containsKey(asLong)) {
                    map.get(asLong).add(contentValues);
                } else {
                    LinkedHashSet<ContentValues> linkedHashSet = new LinkedHashSet<>();
                    linkedHashSet.add(contentValues);
                    map.put(asLong, linkedHashSet);
                }
            }
        }
    }

    private Map<Long, LinkedHashSet<ContentValues>> buildMap(ContentValues[] contentValuesArr, String str) {
        HashMap map = new HashMap();
        for (ContentValues contentValues : contentValuesArr) {
            Long asLong = contentValues.getAsLong(str);
            asLong.longValue();
            if (map.containsKey(asLong)) {
                ((LinkedHashSet) map.get(asLong)).add(contentValues);
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.add(contentValues);
                map.put(asLong, linkedHashSet);
            }
        }
        return map;
    }

    private void buildSet(Set<Integer> set, CalendarTableSet calendarTableSet, GetHashCallBack getHashCallBack) {
        Iterator<LinkedHashSet<ContentValues>> it = calendarTableSet.getEventMap().values().iterator();
        while (it.hasNext()) {
            Iterator<ContentValues> it2 = it.next().iterator();
            while (it2.hasNext()) {
                ContentValues next = it2.next();
                if (getCalendarContractId(next)) {
                    getHashCallBack.callBack(it2, set, getCalendarBuildHash(next.getAsLong("_id"), next, calendarTableSet.getExtendedMap(), calendarTableSet.getRemindMap(), calendarTableSet.getAttendeesMap()));
                }
            }
        }
    }

    private ContentValues[] changeEvent(ContentValues[] contentValuesArr) {
        C2111d.m12653i(TAG, "checkCalendar getduration or getrrule begin");
        ArrayList arrayList = new ArrayList(contentValuesArr.length);
        for (ContentValues contentValues : contentValuesArr) {
            try {
                String asString = contentValues.getAsString("duration");
                String asString2 = contentValues.getAsString(CalendarConfigTable.CalendarTable.Events.R_RULE);
                if (TextUtils.isEmpty(contentValues.getAsString(CalendarConfigTable.CalendarTable.Events.D_TEND)) && TextUtils.isEmpty(asString)) {
                    arrayList.add(contentValues);
                    C2111d.m12653i(TAG, "changeEvent D_TEND and DURATION is null");
                } else if (!TextUtils.isEmpty(asString) || !TextUtils.isEmpty(asString2)) {
                    if (TextUtils.isEmpty(asString) || TextUtils.isEmpty(asString2)) {
                        C2111d.m12653i(TAG, "checkCalendar getduration or getrrule begin change duration");
                        contentValues.put("duration", (Long) null);
                        contentValues.put(CalendarConfigTable.CalendarTable.Events.R_RULE, (Long) null);
                    } else {
                        C2111d.m12646b(TAG, "checkCalendar getduration or getrrule begin change dtend");
                        contentValues.put(CalendarConfigTable.CalendarTable.Events.D_TEND, (Long) null);
                    }
                }
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d(TAG, "checkCalendar getduration or getrrule failed:IllegalArgumentException");
            } catch (Exception unused2) {
                C2111d.m12648d(TAG, "checkCalendar getduration or getrrule failed:Exception");
            }
        }
        if (arrayList.isEmpty()) {
            return contentValuesArr;
        }
        ArrayList arrayList2 = new ArrayList(contentValuesArr.length);
        Collections.addAll(arrayList2, contentValuesArr);
        arrayList2.removeAll(arrayList);
        ContentValues[] contentValuesArr2 = (ContentValues[]) arrayList2.toArray(new ContentValues[arrayList2.size()]);
        C2111d.m12653i(TAG, "changeEvent D_TEND and DURATION is null, resultList size: " + arrayList2.size() + ",eventValues size: " + contentValuesArr2.length);
        return contentValuesArr2;
    }

    private void changeValuesToPhoneCalendar(Context context, ContentValues[] contentValuesArr) {
        if (C2157a.m13166A(context)) {
            return;
        }
        C2111d.m12657m(TAG, "not HwPhone,so change organizer to phone");
        for (ContentValues contentValues : contentValuesArr) {
            contentValues.put(CalendarConfigTable.CalendarTable.Events.ORGANIZER, PHONE);
        }
    }

    private boolean checkCalendarAccount(Context context, String[] strArr, String str) {
        Cursor cursorM12618d = null;
        try {
            try {
                cursorM12618d = C2108a.m12618d(context, CalendarConfigTable.CalendarTable.CALENDAR_URI, strArr, str, null, null);
                if (cursorM12618d != null) {
                    if (cursorM12618d.moveToFirst()) {
                        cursorM12618d.close();
                        return true;
                    }
                }
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
                return false;
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d(TAG, "checkPhoneAccount query failed IllegalArgumentException.");
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
                return false;
            } catch (Exception unused2) {
                C2111d.m12648d(TAG, "checkPhoneAccount query failed.");
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
                return false;
            }
        } catch (Throwable th2) {
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
            throw th2;
        }
    }

    private boolean checkNetWorkCalendar(Context context, ContentValues contentValues) {
        try {
            String asString = contentValues.getAsString(CalendarConfigTable.CalendarTable.Events.ORGANIZER);
            int accountId = getCalenderId(context) ? getAccountId() : 1;
            if (asString == null) {
                contentValues.put(CalendarConfigTable.CalendarTable.Events.CALENDAR_ID, Integer.valueOf(accountId));
                return true;
            }
            if (PHONE.equals(asString)) {
                contentValues.put(CalendarConfigTable.CalendarTable.Events.CALENDAR_ID, Integer.valueOf(accountId));
                return true;
            }
            Cursor cursor = null;
            try {
                try {
                    Cursor cursorM12618d = C2108a.m12618d(context, CalendarConfigTable.CalendarTable.CALENDAR_URI, null, "account_name = '" + asString + "'", null, null);
                    if (cursorM12618d != null && cursorM12618d.getCount() > 0) {
                        cursorM12618d.moveToFirst();
                        contentValues.put(CalendarConfigTable.CalendarTable.Events.CALENDAR_ID, Long.valueOf(cursorM12618d.getLong(cursorM12618d.getColumnIndex("_id"))));
                        cursorM12618d.close();
                        return true;
                    }
                    contentValues.put(CalendarConfigTable.CalendarTable.Events.CALENDAR_ID, Integer.valueOf(accountId));
                    contentValues.put(CalendarConfigTable.CalendarTable.Events.ORGANIZER, PHONE);
                    if (cursorM12618d != null) {
                        cursorM12618d.close();
                    }
                    return true;
                } catch (IllegalArgumentException unused) {
                    C2111d.m12648d(TAG, "checkCalendar getid failed! IllegalArgumentException");
                    contentValues.put(CalendarConfigTable.CalendarTable.Events.CALENDAR_ID, Integer.valueOf(accountId));
                    if (0 != 0) {
                        cursor.close();
                    }
                    return false;
                } catch (Exception unused2) {
                    C2111d.m12648d(TAG, "checkCalendar getid failed!");
                    contentValues.put(CalendarConfigTable.CalendarTable.Events.CALENDAR_ID, Integer.valueOf(accountId));
                    if (0 != 0) {
                        cursor.close();
                    }
                    return false;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th2;
            }
        } catch (Exception unused3) {
            C2111d.m12648d(TAG, "checkCalendar getOrganizer failed!");
            return false;
        }
    }

    private void clearData(Map map) {
        if (map != null) {
            map.clear();
        }
    }

    private void getAndWriteValues(Context context, AbstractC0048c abstractC0048c, CalendarTableType calendarTableType) {
        String backupTable = calendarTableType.getBackupTable();
        Uri uri = calendarTableType.getUri();
        String[] projection = calendarTableType.getProjection();
        C2111d.m12653i(TAG, "getAndWriteValues begin, backupTable:" + backupTable);
        Cursor cursorM12618d = null;
        try {
            try {
                cursorM12618d = C2108a.m12618d(context, uri, projection, null, null, null);
            } catch (Exception unused) {
                C2111d.m12648d(TAG, "write values failed.");
                if (0 == 0) {
                    return;
                }
            }
            if (cursorM12618d != null && cursorM12618d.moveToFirst()) {
                int count = cursorM12618d.getCount();
                int i10 = 0;
                C2111d.m12654j(TAG, "Total count of ", backupTable, " is:", Integer.valueOf(count));
                ContentValues[] contentValuesArr = new ContentValues[count];
                while (!BackupObject.isAbort()) {
                    if (i10 >= 0 && i10 < count) {
                        try {
                            ContentValues contentValuesM13213u = C2157a.m13213u(cursorM12618d, calendarTableType.getFields());
                            contentValuesArr[i10] = contentValuesM13213u;
                            if (contentValuesM13213u != null) {
                                abstractC0048c.m185A(backupTable, contentValuesM13213u);
                            }
                        } catch (Exception unused2) {
                            C2111d.m12648d(TAG, "get and write values failed.");
                        }
                    }
                    i10++;
                    if (!cursorM12618d.moveToNext()) {
                        break;
                    }
                }
                cursorM12618d.close();
                return;
            }
            C2111d.m12648d(TAG, "Backup BackupCalendarImp uri is null.");
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursorM12618d.close();
            }
            throw th2;
        }
    }

    private int getCalendarBuildHash(ContentValues contentValues, Set<ContentValues> set, Set<ContentValues> set2, Set<ContentValues> set3) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        CalendarBuild calendarBuild = new CalendarBuild();
        if (contentValues != null) {
            calendarBuild.setField(contentValues);
        }
        setOtherField(set, calendarBuild);
        setOtherField(set2, calendarBuild);
        setOtherField(set3, calendarBuild);
        return C2157a.m13214v(calendarBuild.formatCalendarBuild());
    }

    private boolean getCalendarContractId(ContentValues contentValues) {
        return (contentValues == null || !contentValues.containsKey("_id") || contentValues.get("_id") == null) ? false : true;
    }

    private StringBuffer getCalendarTable() {
        StringBuffer stringBuffer = new StringBuffer(CalendarConfigTable.CalendarTable.Events.TABLE_NAME);
        stringBuffer.append(";");
        stringBuffer.append(CalendarConfigTable.CalendarTable.ExtendedProperties.TABLE_NAME);
        stringBuffer.append(";");
        stringBuffer.append(CalendarConfigTable.CalendarTable.Reminds.TABLE_NAME);
        stringBuffer.append(";");
        stringBuffer.append(CalendarConfigTable.CalendarTable.Attendees.TABLE_NAME);
        return stringBuffer;
    }

    private CalendarTableSet getCalendarTableSet(Context context, ContentValues[] contentValuesArr, Map<Long, LinkedHashSet<ContentValues>> map, Map<Long, LinkedHashSet<ContentValues>> map2) throws Throwable {
        int[] iArr = {contentValuesArr[0].getAsInteger("_id").intValue(), contentValuesArr[contentValuesArr.length - 1].getAsInteger("_id").intValue()};
        buildLocalMap(contentValuesArr, map, CalendarConfigTable.CalendarTable.Events.CALENDAR_ID);
        ContentValues[] otherRestoreValue = getOtherRestoreValue(context, CalendarConfigTable.CalendarTable.Reminds.URI, this.reminderProjection, CalendarConfigTable.CalendarTable.Reminds.getRemindsFields(), iArr);
        if (otherRestoreValue.length > 0) {
            buildLocalMap(otherRestoreValue, map2, "event_id");
        }
        return new CalendarTableSet(null, map, null, map2, null);
    }

    private ContentValues[] getEventBackupValues(Context context, String[] strArr, Map<String, Integer> map) throws Throwable {
        DefaultCalendarConditionBuilder defaultCalendarConditionBuilder = new DefaultCalendarConditionBuilder(context);
        defaultCalendarConditionBuilder.addBuilder(new DefaultCalendarConditionBuilder.GmailCalendarConditionBuilder(context, false));
        try {
            Cursor cursorM12618d = C2108a.m12618d(context, CalendarConfigTable.CalendarTable.Events.URI, strArr, defaultCalendarConditionBuilder.build(), null, null);
            try {
                ContentValues[] data = readData(cursorM12618d, map);
                changeValuesToPhoneCalendar(context, data);
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
                return data;
            } finally {
            }
        } catch (Exception unused) {
            C2111d.m12648d(TAG, "calendar read values failed.Exception");
            return new ContentValues[0];
        }
    }

    private ContentValues[] getEventValue(Context context, String[] strArr, Map<String, Integer> map, int i10) throws Throwable {
        String str = "_id ASC limit 500 offset " + (i10 * 500);
        DefaultCalendarConditionBuilder defaultCalendarConditionBuilder = new DefaultCalendarConditionBuilder(context);
        defaultCalendarConditionBuilder.addBuilder(new DefaultCalendarConditionBuilder.GmailCalendarConditionBuilder(context, false));
        try {
            Cursor cursorM12618d = C2108a.m12618d(context, CalendarConfigTable.CalendarTable.Events.URI, strArr, defaultCalendarConditionBuilder.build(), null, str);
            try {
                ContentValues[] data = readData(cursorM12618d, map);
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
                return data;
            } finally {
            }
        } catch (SQLiteException unused) {
            C2111d.m12648d(TAG, "calendar read values failed. Exception");
            return new ContentValues[0];
        }
    }

    private Set<Integer> getLocalData(Context context) throws Throwable {
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            ContentValues[] eventValue = getEventValue(context, this.eventProjection, CalendarConfigTable.CalendarTable.Events.getEventFields(), i10);
            C2111d.m12654j(TAG, "get events num = ", Integer.valueOf(eventValue.length));
            if (eventValue.length == 0) {
                C2111d.m12648d(TAG, "There is no event values found!");
                return hashSet;
            }
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            buildSet(hashSet, getCalendarTableSet(context, eventValue, map, map2), new CalendarHashCallBack());
            clearData(map);
            clearData(map2);
            if (eventValue.length != 500) {
                return hashSet;
            }
            i10 = i11;
        }
    }

    private Map<Long, LinkedHashSet<ContentValues>> getOtherMap(AbstractC0048c abstractC0048c, String str, String[] strArr, String str2) {
        ContentValues[] contentValuesArrM200s = abstractC0048c.m200s(str, strArr, null, null, null);
        HashMap map = new HashMap();
        return (contentValuesArrM200s == null || contentValuesArrM200s.length < 1) ? map : buildMap(contentValuesArrM200s, str2);
    }

    private ContentValues[] getOtherRestoreValue(Context context, Uri uri, String[] strArr, Map<String, Integer> map, int[] iArr) throws Throwable {
        ContentValues[] contentValuesArr = new ContentValues[0];
        try {
            Cursor cursorM12618d = C2108a.m12618d(context, uri, strArr, String.format(Locale.ROOT, "event_id >= ? AND event_id <= ?", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])), new String[]{iArr[0] + "", iArr[1] + ""}, null);
            try {
                ContentValues[] data = readData(cursorM12618d, map);
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
                return data;
            } finally {
            }
        } catch (SQLiteException unused) {
            C2111d.m12648d(TAG, "calendar read values failed.Exception");
            return contentValuesArr;
        }
    }

    private boolean init(Context context, int i10, AbstractC0048c abstractC0048c) {
        if (!initEvent(context, i10, abstractC0048c)) {
            C2111d.m12648d(TAG, "Backup Failed at init event!");
            return false;
        }
        if (!initExtended(context, i10, abstractC0048c)) {
            C2111d.m12648d(TAG, "Backup Failed at init extendedproperties!");
            return false;
        }
        if (!initReminder(context, i10, abstractC0048c)) {
            C2111d.m12648d(TAG, "Backup Failed at init reminders!");
            return false;
        }
        if (initAttendee(context, i10, abstractC0048c)) {
            return true;
        }
        C2111d.m12648d(TAG, "Backup Failed at init attendees!");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001b A[PHI: r1 r9
  0x001b: PHI (r1v6 java.lang.String[]) = (r1v13 java.lang.String[]), (r1v15 java.lang.String[]), (r1v10 java.lang.String[]) binds: [B:17:0x002c, B:19:0x0032, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE]
  0x001b: PHI (r9v7 android.database.Cursor) = (r9v3 android.database.Cursor), (r9v4 android.database.Cursor), (r9v8 android.database.Cursor) binds: [B:17:0x002c, B:19:0x0032, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean initAttendee(android.content.Context r9, int r10, p006a5.AbstractC0048c r11) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "BackupCalendarImp"
            r1 = 0
            android.net.Uri r3 = com.huawei.android.backup.service.logic.calendar.CalendarConfigTable.CalendarTable.Attendees.URI     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21 java.security.InvalidParameterException -> L23
            java.lang.String r5 = "attendees._id = 0"
            r6 = 0
            r7 = 0
            r4 = 0
            r2 = r9
            android.database.Cursor r9 = com.huawei.android.backup.filelogic.utils.C2108a.m12618d(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21 java.security.InvalidParameterException -> L23
            if (r9 == 0) goto L19
            java.lang.String[] r1 = r9.getColumnNames()     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L25 java.security.InvalidParameterException -> L2d
            goto L19
        L16:
            r8 = move-exception
            r1 = r9
            goto L72
        L19:
            if (r9 == 0) goto L35
        L1b:
            r9.close()
            goto L35
        L1f:
            r8 = move-exception
            goto L72
        L21:
            r9 = r1
            goto L25
        L23:
            r9 = r1
            goto L2d
        L25:
            java.lang.String r2 = "initAttendee fail, Exception"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r2)     // Catch: java.lang.Throwable -> L16
            if (r9 == 0) goto L35
            goto L1b
        L2d:
            java.lang.String r2 = "initAttendee fail, InvalidParameterException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r2)     // Catch: java.lang.Throwable -> L16
            if (r9 == 0) goto L35
            goto L1b
        L35:
            r9 = 0
            if (r1 == 0) goto L71
            int r2 = r1.length
            r3 = 1
            if (r2 >= r3) goto L3d
            goto L71
        L3d:
            if (r10 != r3) goto L4a
            java.util.Map r10 = com.huawei.android.backup.service.logic.calendar.CalendarConfigTable.CalendarTable.Attendees.getAttendeesFields()
            java.lang.String[] r10 = r8.backupProjection(r1, r10)
            r8.attendeeProjection = r10
            goto L69
        L4a:
            r2 = 2
            if (r10 != r2) goto L5c
            if (r11 == 0) goto L5c
            java.util.Map r10 = com.huawei.android.backup.service.logic.calendar.CalendarConfigTable.CalendarTable.Attendees.getAttendeesFields()
            java.lang.String r0 = "Attendees_tb"
            java.lang.String[] r10 = r8.restoreProjection(r1, r11, r10, r0)
            r8.attendeeProjection = r10
            goto L69
        L5c:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r11 = "initAttendee flags: "
            java.lang.Object[] r10 = new java.lang.Object[]{r11, r10}
            com.huawei.android.backup.filelogic.utils.C2111d.m12647c(r0, r10)
        L69:
            java.lang.String[] r8 = r8.attendeeProjection
            if (r8 == 0) goto L71
            int r8 = r8.length
            if (r8 <= 0) goto L71
            r9 = r3
        L71:
            return r9
        L72:
            if (r1 == 0) goto L77
            r1.close()
        L77:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.service.logic.calendar.BackupCalendarImp.initAttendee(android.content.Context, int, a5.c):boolean");
    }

    private boolean initEvent(Context context, int i10, AbstractC0048c abstractC0048c) {
        String[] strArrM13202j = C2157a.m13202j(context, CalendarConfigTable.CalendarTable.Events.URI);
        C2111d.m12654j(TAG, "colFields length:", Integer.valueOf(strArrM13202j.length));
        if (strArrM13202j.length < 1) {
            C2111d.m12653i(TAG, "initEvent colFields length: < 1");
            return false;
        }
        if (i10 == 1) {
            this.eventProjection = backupProjection(strArrM13202j, CalendarConfigTable.CalendarTable.Events.getEventFields());
        } else if (i10 != 2 || abstractC0048c == null) {
            C2111d.m12647c(TAG, "initEvent flags: ", Integer.valueOf(i10));
        } else {
            this.eventProjection = restoreProjection(strArrM13202j, abstractC0048c, CalendarConfigTable.CalendarTable.Events.getEventFields(), CalendarConfigTable.CalendarTable.Events.BACK_TABLE);
        }
        String[] strArr = this.eventProjection;
        return strArr != null && strArr.length > 0;
    }

    private boolean initExtended(Context context, int i10, AbstractC0048c abstractC0048c) {
        String[] strArrM13202j = C2157a.m13202j(context, CalendarConfigTable.CalendarTable.ExtendedProperties.URI);
        if (strArrM13202j.length < 1) {
            return false;
        }
        if (i10 == 1) {
            this.extendedProjection = backupProjection(strArrM13202j, CalendarConfigTable.CalendarTable.ExtendedProperties.getExtendedPropertiesFields());
        } else if (i10 != 2 || abstractC0048c == null) {
            C2111d.m12647c(TAG, "initExtended flags: ", Integer.valueOf(i10));
        } else {
            this.extendedProjection = restoreProjection(strArrM13202j, abstractC0048c, CalendarConfigTable.CalendarTable.ExtendedProperties.getExtendedPropertiesFields(), CalendarConfigTable.CalendarTable.ExtendedProperties.BACK_TABLE);
        }
        String[] strArr = this.extendedProjection;
        return strArr != null && strArr.length > 0;
    }

    private boolean initReminder(Context context, int i10, AbstractC0048c abstractC0048c) {
        String[] strArrM13202j = C2157a.m13202j(context, CalendarConfigTable.CalendarTable.Reminds.URI);
        if (strArrM13202j.length < 1) {
            return false;
        }
        if (i10 == 1) {
            this.reminderProjection = backupProjection(strArrM13202j, CalendarConfigTable.CalendarTable.Reminds.getRemindsFields());
        } else if (i10 != 2 || abstractC0048c == null) {
            C2111d.m12647c(TAG, "initReminder flags: ", Integer.valueOf(i10));
        } else {
            this.reminderProjection = restoreProjection(strArrM13202j, abstractC0048c, CalendarConfigTable.CalendarTable.Reminds.getRemindsFields(), CalendarConfigTable.CalendarTable.Reminds.BACK_TABLE);
        }
        String[] strArr = this.reminderProjection;
        return strArr != null && strArr.length > 0;
    }

    private boolean isDataDuplicate(ContentValues contentValues, Set<ContentValues> set, Set<ContentValues> set2, Set<ContentValues> set3, Set<Integer> set4) {
        if (set4.isEmpty()) {
            return false;
        }
        return set4.contains(Integer.valueOf(getCalendarBuildHash(contentValues, set, set2, set3)));
    }

    private boolean isDuplicateDataThenSkip(ContentValues contentValues, Set<ContentValues> set, Set<ContentValues> set2, Set<ContentValues> set3, Context context) throws Throwable {
        if (this.localEventsDataHash == null) {
            Set<Integer> localData = getLocalData(context);
            this.localEventsDataHash = localData;
            C2111d.m12654j(TAG, "localEventsDataHash size is:", Integer.valueOf(localData.size()));
        }
        return isDataDuplicate(contentValues, set, set2, set3, this.localEventsDataHash);
    }

    private ContentValues[] readData(Cursor cursor, Map<String, Integer> map) {
        int i10 = 0;
        if (cursor == null || !cursor.moveToFirst()) {
            C2111d.m12648d(TAG, "read uri is null.");
            return new ContentValues[0];
        }
        ContentValues[] contentValuesArr = new ContentValues[cursor.getCount()];
        while (!BackupObject.isAbort()) {
            int i11 = i10 + 1;
            try {
                contentValuesArr[i10] = C2157a.m13213u(cursor, map);
            } catch (SQLiteException unused) {
                C2111d.m12648d(TAG, "Get from cursor failed.");
            }
            if (!cursor.moveToNext()) {
                break;
            }
            i10 = i11;
        }
        return contentValuesArr;
    }

    private Map<Long, ContentValues> rebuildEventMap(Set<ContentValues> set) {
        HashMap map = new HashMap(set.size());
        for (ContentValues contentValues : set) {
            if (contentValues != null) {
                Long asLong = contentValues.getAsLong("_id");
                asLong.longValue();
                map.put(asLong, contentValues);
            }
        }
        return map;
    }

    private int restoreCalendar(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        ContentValues[] contentValuesArr;
        int i10;
        AbstractC0048c abstractC0048c2 = abstractC0048c;
        C2111d.m12653i(TAG, "restoreCalendar begin");
        if (BackupConstant.LocalPhoneInfo.IS_I_VERSION && !checkCalendarAccount(context, new String[]{"_id"}, null)) {
            sendMsg(101, C2111d.m12652h(TAG, "calendar", "restoreCalendar", "checkCalendarAccount fail"), callback, obj);
            return 5;
        }
        if (abstractC0048c2 == null) {
            return 5;
        }
        ContentValues[] contentValuesArrM200s = abstractC0048c.m200s(CalendarConfigTable.CalendarTable.Events.BACK_TABLE, this.eventProjection, "deleted = 0", null, "limit0,1000");
        int i11 = 0;
        while (contentValuesArrM200s != null && contentValuesArrM200s.length >= 1) {
            C2111d.m12654j(TAG, "The count of events to restore is:", Integer.valueOf(contentValuesArrM200s.length));
            ContentValues[] contentValuesArrChangeEvent = changeEvent(contentValuesArrM200s);
            Map<Long, LinkedHashSet<ContentValues>> mapBuildMap = buildMap(contentValuesArrChangeEvent, CalendarConfigTable.CalendarTable.Events.CALENDAR_ID);
            Map<Long, LinkedHashSet<ContentValues>> otherMap = getOtherMap(abstractC0048c2, CalendarConfigTable.CalendarTable.Reminds.BACK_TABLE, this.reminderProjection, "event_id");
            for (Map.Entry<Long, LinkedHashSet<ContentValues>> entry : mapBuildMap.entrySet()) {
                if (BackupObject.isAbort()) {
                    break;
                }
                LinkedHashSet<ContentValues> value = entry.getValue();
                if (value != null) {
                    Map<Long, ContentValues> mapRebuildEventMap = rebuildEventMap(value);
                    value.clear();
                    if (mapRebuildEventMap.size() >= 1) {
                        contentValuesArr = contentValuesArrChangeEvent;
                        i10 = i11;
                        restoreEvent(context, callback, obj, i11 + contentValuesArrChangeEvent.length, new CalendarTableSet(mapRebuildEventMap, null, null, otherMap, null));
                        addModuleUriInfo(String.valueOf(CalendarConfigTable.CalendarTable.Events.URI), true, true, contentValuesArr.length, this.curRestoreIndex);
                        reportModuleRestoreFinish(str);
                    } else {
                        contentValuesArr = contentValuesArrChangeEvent;
                        i10 = i11;
                    }
                    contentValuesArrChangeEvent = contentValuesArr;
                    i11 = i10;
                }
            }
            int i12 = i11 + 1000;
            contentValuesArrM200s = abstractC0048c.m200s(CalendarConfigTable.CalendarTable.Events.BACK_TABLE, this.eventProjection, "deleted = 0", null, "limit" + i12 + ",1000");
            i11 = i12;
            abstractC0048c2 = abstractC0048c;
        }
        if (i11 != 0) {
            return 4;
        }
        C2111d.m12648d(TAG, "eventValues is null");
        sendMsg(101, C2111d.m12652h(TAG, "calendar", "restoreCalendar", " eventValues is null"), callback, obj);
        return 5;
    }

    private void restoreEvent(Context context, Handler.Callback callback, Object obj, int i10, CalendarTableSet calendarTableSet) {
        C2111d.m12653i(TAG, "restoreEvent begin");
        for (Map.Entry<Long, ContentValues> entry : calendarTableSet.getEventMapValues().entrySet()) {
            if (BackupObject.isAbort()) {
                return;
            }
            this.curRestoreIndex++;
            Long key = entry.getKey();
            key.longValue();
            ContentValues value = entry.getValue();
            if (value == null) {
                sendMsg(5, this.curRestoreIndex, i10, callback, obj);
            } else if (checkNetWorkCalendar(context, value)) {
                LinkedHashSet<ContentValues> linkedHashSet = calendarTableSet.getRemindMap().get(key);
                if (isDuplicateDataThenSkip(value, null, linkedHashSet, null, context)) {
                    sendMsg(3, this.curRestoreIndex, i10, callback, obj);
                } else if (applyBatchRestore(context, value, null, linkedHashSet, null)) {
                    sendMsg(3, this.curRestoreIndex, i10, callback, obj);
                } else {
                    C2111d.m12648d(TAG, "calendar restore event failed.");
                    sendMsg(5, this.curRestoreIndex, i10, callback, obj);
                }
            } else {
                C2111d.m12653i(TAG, "checkNetWorkCalendar false, continue");
            }
        }
    }

    private String[] restoreProjection(String[] strArr, AbstractC0048c abstractC0048c, Map<String, Integer> map, String str) {
        Set<String> setMo202u = abstractC0048c.mo202u(str);
        ArrayList arrayList = new ArrayList();
        if (setMo202u != null && setMo202u.size() > 0) {
            for (String str2 : strArr) {
                if (map.containsKey(str2) && setMo202u.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private void setOtherField(Set<ContentValues> set, CalendarBuild calendarBuild) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (set == null || calendarBuild == null) {
            return;
        }
        Iterator<ContentValues> it = set.iterator();
        while (it.hasNext()) {
            calendarBuild.setField(it.next());
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        return C2157a.m13166A(context) && init(context, 1, null);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) throws Throwable {
        C2111d.m12653i(TAG, "Backup BackupCalendarImp begin");
        if (abstractC0048c == null || !init(context, 1, null)) {
            C2111d.m12648d(TAG, "Backup Failed at init!");
            sendMsg(100, C2111d.m12652h(TAG, "calendar", "onBackup", "Backup Failed at init"), callback, obj);
            return 2;
        }
        ContentValues[] eventBackupValues = getEventBackupValues(context, this.eventProjection, CalendarConfigTable.CalendarTable.Events.getEventFields());
        C2111d.m12654j(TAG, "Total count of events table to backup is:", Integer.valueOf(eventBackupValues.length));
        if (eventBackupValues.length == 0) {
            C2111d.m12648d(TAG, "There is no event values found!");
            return 1;
        }
        abstractC0048c.mo169a();
        backupEvents(context, abstractC0048c, eventBackupValues, callback, obj);
        getAndWriteValues(context, abstractC0048c, new CalendarTableType(CalendarConfigTable.CalendarTable.ExtendedProperties.URI, this.extendedProjection, CalendarConfigTable.CalendarTable.ExtendedProperties.getExtendedPropertiesFields(), CalendarConfigTable.CalendarTable.ExtendedProperties.BACK_TABLE));
        getAndWriteValues(context, abstractC0048c, new CalendarTableType(CalendarConfigTable.CalendarTable.Reminds.URI, this.reminderProjection, CalendarConfigTable.CalendarTable.Reminds.getRemindsFields(), CalendarConfigTable.CalendarTable.Reminds.BACK_TABLE));
        getAndWriteValues(context, abstractC0048c, new CalendarTableType(CalendarConfigTable.CalendarTable.Attendees.URI, this.attendeeProjection, CalendarConfigTable.CalendarTable.Attendees.getAttendeesFields(), CalendarConfigTable.CalendarTable.Attendees.BACK_TABLE));
        abstractC0048c.mo171c();
        if (this.eventBackupSuccess == 0) {
            C2111d.m12648d(TAG, "No event backup success!");
            sendMsg(100, C2111d.m12652h(TAG, "calendar", "onBackup", ":No event backup sucess"), callback, obj);
            return 2;
        }
        addModuleUriInfo(String.valueOf(CalendarConfigTable.CalendarTable.Events.URI), true, true, eventBackupValues.length, this.eventBackupSuccess);
        reportModuleBackupFinish(str, callback, obj);
        this.backupFileModuleInfo.updateModuleInfo(this.eventBackupSuccess, 8, getCalendarTable().toString());
        if (!this.backupFileModuleInfo.hasRecord()) {
            abstractC0048c.m190h();
        }
        return storeHandlerMsgToObjectMsg(1);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) throws Throwable {
        C2111d.m12653i(TAG, "Restore calendar.");
        initEvent(context, 2, abstractC0048c);
        initExtended(context, 2, abstractC0048c);
        initReminder(context, 2, abstractC0048c);
        initAttendee(context, 2, abstractC0048c);
        return restoreCalendar(context, abstractC0048c, callback, obj, str);
    }

    private void setOtherField(Map<Long, LinkedHashSet<ContentValues>> map, Long l10, CalendarBuild calendarBuild) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (map == null || !map.containsKey(l10)) {
            return;
        }
        Iterator<ContentValues> it = map.get(l10).iterator();
        while (it.hasNext()) {
            ContentValues next = it.next();
            if (next != null) {
                calendarBuild.setField(next);
            }
        }
    }

    private int getCalendarBuildHash(Long l10, ContentValues contentValues, Map<Long, LinkedHashSet<ContentValues>> map, Map<Long, LinkedHashSet<ContentValues>> map2, Map<Long, LinkedHashSet<ContentValues>> map3) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        CalendarBuild calendarBuild = new CalendarBuild();
        if (contentValues != null) {
            calendarBuild.setField(contentValues);
        }
        setOtherField(map, l10, calendarBuild);
        setOtherField(map2, l10, calendarBuild);
        setOtherField(map3, l10, calendarBuild);
        return C2157a.m13214v(calendarBuild.formatCalendarBuild());
    }
}
