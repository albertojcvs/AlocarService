package com.AlocaAi.AlocarService.services.calendar;

import java.util.Date;

public interface ICalendarService {
    public CalendarEvent saveEvent(String title, String description, Date startDate, Date endDate);
}
