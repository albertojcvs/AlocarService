package com.AlocaAi.AlocarService.services.calendar;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

@Component
public class GoogleCalendarService implements ICalendarService {
 private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    private final String a = "74257515fa7139831abad03a5b2c5522ce4cc43b8421d11c8fe131c1bba6e4ec@group.calendar.google.com"; 
   
   
      private static final List<String> SCOPES =
      Collections.singletonList(CalendarScopes.CALENDAR_READONLY);
  private static final String CREDENTIALS_FILE_PATH = "/credentials.json";


  private static final String TOKENS_DIRECTORY_PATH = "tokens";
   
  private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
      throws IOException {
    // Load client secrets.
    InputStream in = GoogleCalendarService.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
    if (in == null) {
      throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
    }
    GoogleClientSecrets clientSecrets =
        GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

    // Build flow and trigger user authorization request.
    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
        .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
        .setAccessType("offline")
        .build();
    LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
    Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    //returns an authorized Credential object.
    return credential;
  }

   
   
    public CalendarEvent saveEvent(String title, String description, Date startDate, Date endDate) {
        try {
          Credential credential = GoogleCalendarAuth.getCredentials();
          Calendar service = new Calendar.Builder(
          GoogleNetHttpTransport.newTrustedTransport(), GoogleCalendarAuth.JSON_FACTORY, credential)
          .setApplicationName(GoogleCalendarAuth.APPLICATION_NAME)
          .build();

            EventDateTime eventStartDate = new EventDateTime().setDate(new DateTime(startDate));  
            EventDateTime eventEndDate = new EventDateTime().setDate(new DateTime(endDate));  
            Event event = service.events().insert(a, new Event().setSummary(title).setDescription(description).setStart(eventStartDate).setEnd((eventEndDate))).execute() ;     
            return new CalendarEvent(event.getId());
        } catch (GeneralSecurityException | IOException e) {

            System.err.println(e);
            e.printStackTrace();
            return null;
        }
        
    }

}
