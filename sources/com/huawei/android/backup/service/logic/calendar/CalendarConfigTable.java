package com.huawei.android.backup.service.logic.calendar;

import android.net.Uri;
import com.huawei.hianalytics.core.storage.Event;
import java.util.HashMap;
import java.util.Map;
import p699v4.C13347p;

/* loaded from: classes.dex */
public class CalendarConfigTable {

    public static class CalendarTable {
        public static final String AUTHORITY = "com.android.calendar";
        public static final Uri CALENDAR_URI;
        public static final Uri CONTENT_URI;

        public static class Attendees {
            private static final Map<String, Integer> ATTENDEES_FIELDS;
            public static final String ATTENDEE_EMAIL = "attendeeEmail";
            public static final String ATTENDEE_NAME = "attendeeName";
            public static final String ATTENDEE_RELATIONSHIP = "attendeeRelationship";
            public static final String ATTENDEE_STATUS = "attendeeStatus";
            public static final String ATTENDEE_TYPE = "attendeeType";
            public static final String BACK_TABLE = "Attendees_tb";
            public static final String EVENT_ID = "event_id";
            public static final String TABLE_NAME = "Attendees";
            public static final Uri URI = C13347p.m80080c(CalendarTable.CONTENT_URI, "attendees");

            static {
                HashMap map = new HashMap(6);
                ATTENDEES_FIELDS = map;
                map.put("event_id", 3);
                map.put(ATTENDEE_NAME, 1);
                map.put(ATTENDEE_EMAIL, 1);
                map.put(ATTENDEE_STATUS, 2);
                map.put(ATTENDEE_RELATIONSHIP, 2);
                map.put(ATTENDEE_TYPE, 2);
            }

            public static Map<String, Integer> getAttendeesFields() {
                return ATTENDEES_FIELDS;
            }
        }

        public static class Events {
            public static final String ACCESS_LEVEL = "accessLevel";
            public static final String ACCOUNT = "_sync_account";
            public static final String ACCOUNT_TYPE = "syncAccountType";
            public static final String ALL_DAY = "allDay";
            public static final String AVAILABILITY = "availability";
            public static final String BACK_TABLE = "Events_tb";
            public static final String CALENDAR_ID = "calendar_id";
            public static final String COMMENTS_URI = "commentsUri";
            public static final String DELETED = "deleted";
            public static final String DESCRIPTION = "description";
            public static final String DIRTY = "syncDirty";
            public static final String DT_START = "dtstart";
            public static final String DURATION = "duration";
            public static final String D_TEND = "dtend";
            public static final String EVENT_CALENDAR_TYPE = "event_calendar_type";
            public static final String EVENT_COLOR = "eventColor";
            public static final String EVENT_COLOR_INDEX = "eventColorIndex";
            public static final String EVENT_COLOR_INDEX_UNDERLINE = "eventColor_index";
            public static final String EVENT_END_TIMEZONE = "eventEndTimezone";
            private static final Map<String, Integer> EVENT_FIELDS;
            public static final String EVENT_IMAGE_TYPE = "event_image_type";
            public static final String EVENT_LOCATION = "eventLocation";
            public static final String EVENT_STATUS = "eventStatus";
            public static final String EVENT_TIMEZONE = "eventTimezone";
            public static final String EVENT_UUID = "event_uuid";
            public static final String EX_DATE = "exdate";
            public static final String EX_RULE = "exrule";
            public static final String GUESTS_CAN_INVITE_OTHERS = "guestsCanInviteOthers";
            public static final String GUESTS_CAN_MODIFY = "guestsCanModify";
            public static final String GUESTS_CAN_SEE_GUESTS = "guestsCanSeeGuests";
            public static final String HAS_ALARM = "hasAlarm";
            public static final String HAS_ATTENDEE_DATA = "hasAttendeeData";
            public static final String HAS_EXTENDED_PROPERTIES = "hasExtendedProperties";
            public static final String HTML_URI = "htmlUri";

            /* renamed from: ID */
            public static final String f9602ID = "_id";
            public static final String IMPORTANT_EVENT_TYPE = "important_event_type";
            public static final String LAST_DATE = "lastDate";
            public static final String NOT_HUAWEI_PHONE_SELECTION = "account_name != 'local.samsungholiday' AND account_type != 'com.samsung.android.exchange' AND (account_name not like '%@%' OR account_type in ('LOCAL', 'local')) AND deleted = 0";
            public static final String ORGANIZER = "organizer";
            public static final String ORIGINAL_ALL_DAY = "originalAllDay";
            public static final String ORIGINAL_EVENT = "originalEvent";
            public static final String ORIGINAL_ID = "originalId";
            public static final String ORIGINAL_ID_UNDERLINE = "original_id";
            public static final String ORIGINAL_INSTANCE_TIME = "originalInstanceTime";
            public static final String ORIGINAL_SYNC_ID = "originalSyncId";
            public static final String ORIGINAL_SYNC_ID_UNDERLINE = "original_sync_id";
            public static final String REMINDERS_METHOD = "reminders;method:";
            public static final String R_DATE = "rdate";
            public static final String R_RULE = "rrule";
            public static final String SELECTION_WHERE = " (organizer is 'Phone' OR organizer is 'PC Sync') And deleted = 0 ";
            public static final String SELF_ATTENDEE_STATUS = "selfAttendeeStatus";
            public static final String SYNC_ACCOUNT = "syncAccount";
            public static final String SYNC_DIRTY = "_sync_dirty";
            public static final String SYNC_TIME = "_sync_time";
            public static final String TABLE_NAME = "Events";
            public static final String TIME = "syncTime";
            public static final String TITLE = "title";
            public static final String TRANSPARENCY = "transparency";
            public static final String TYPE = "_sync_account_type";
            public static final Uri URI = C13347p.m80080c(CalendarTable.CONTENT_URI, Event.EventConstants.EVENTS);
            public static final String VISIBILITY = "visibility";

            static {
                HashMap map = new HashMap(50);
                EVENT_FIELDS = map;
                map.put("_id", 3);
                map.put(ACCOUNT, 1);
                map.put(TYPE, 1);
                map.put(SYNC_TIME, 1);
                map.put(SYNC_DIRTY, 2);
                map.put(CALENDAR_ID, 3);
                map.put(HTML_URI, 1);
                map.put("title", 1);
                map.put(EVENT_LOCATION, 1);
                map.put("description", 1);
                map.put(EVENT_STATUS, 2);
                map.put(SELF_ATTENDEE_STATUS, 2);
                map.put(COMMENTS_URI, 1);
                map.put(DT_START, 3);
                map.put(D_TEND, 8);
                map.put(EVENT_TIMEZONE, 1);
                map.put("duration", 1);
                map.put(ALL_DAY, 2);
                map.put("visibility", 2);
                map.put(TRANSPARENCY, 2);
                map.put(HAS_ALARM, 2);
                map.put(HAS_EXTENDED_PROPERTIES, 2);
                map.put(R_RULE, 1);
                map.put(R_DATE, 1);
                map.put(EX_RULE, 1);
                map.put(EX_DATE, 1);
                map.put(ORIGINAL_EVENT, 1);
                map.put(ORIGINAL_INSTANCE_TIME, 2);
                map.put(ORIGINAL_ALL_DAY, 2);
                map.put(LAST_DATE, 8);
                map.put(HAS_ATTENDEE_DATA, 2);
                map.put(GUESTS_CAN_MODIFY, 2);
                map.put(GUESTS_CAN_INVITE_OTHERS, 2);
                map.put(GUESTS_CAN_SEE_GUESTS, 2);
                map.put(ORGANIZER, 1);
                map.put(DELETED, 2);
                map.put(ACCESS_LEVEL, 2);
                map.put(AVAILABILITY, 2);
                map.put(ORIGINAL_SYNC_ID_UNDERLINE, 1);
                map.put(EVENT_END_TIMEZONE, 1);
                map.put(EVENT_COLOR, 7);
                map.put(EVENT_COLOR_INDEX_UNDERLINE, 1);
                map.put(ORIGINAL_ID_UNDERLINE, 8);
                map.put(EVENT_CALENDAR_TYPE, 2);
                map.put(EVENT_IMAGE_TYPE, 1);
                map.put(IMPORTANT_EVENT_TYPE, 2);
                map.put(EVENT_UUID, 1);
            }

            public static Map<String, Integer> getEventFields() {
                return EVENT_FIELDS;
            }
        }

        public static class ExtendedProperties {
            public static final String BACK_TABLE = "ExtendedProperties_tb";
            public static final String EVENT_ID = "event_id";
            private static final Map<String, Integer> EXTENDED_PROPERTIES_FIELDS;
            public static final String EXTENDED_PROPERTIES_NAME = "ExtendedProperties;name:";
            public static final String EXTENDED_PROPERTIES_VALUE = "ExtendedProperties;value:";
            public static final String NAME = "name";
            public static final String TABLE_NAME = "ExtendedProperties";
            public static final Uri URI = C13347p.m80080c(CalendarTable.CONTENT_URI, "extendedproperties");
            public static final String VALUE = "value";

            static {
                HashMap map = new HashMap(3);
                EXTENDED_PROPERTIES_FIELDS = map;
                map.put("event_id", 3);
                map.put("name", 1);
                map.put("value", 1);
            }

            public static Map<String, Integer> getExtendedPropertiesFields() {
                return EXTENDED_PROPERTIES_FIELDS;
            }
        }

        public static class Reminds {
            public static final String BACK_TABLE = "Reminds_tb";
            public static final String EVENT_ID = "event_id";
            public static final String METHOD = "method";
            public static final String MINUTES = "minutes";
            private static final Map<String, Integer> REMINDS_FIELDS;
            public static final String TABLE_NAME = "Reminds";
            public static final Uri URI = C13347p.m80080c(CalendarTable.CONTENT_URI, "reminders");

            static {
                HashMap map = new HashMap(3);
                REMINDS_FIELDS = map;
                map.put("event_id", 3);
                map.put(MINUTES, 2);
                map.put("method", 2);
            }

            public static Map<String, Integer> getRemindsFields() {
                return REMINDS_FIELDS;
            }
        }

        static {
            Uri uriM80079b = C13347p.m80079b("content://com.android.calendar");
            CONTENT_URI = uriM80079b;
            CALENDAR_URI = C13347p.m80080c(uriM80079b, "calendars");
        }
    }
}
