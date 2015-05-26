package org.fenixedu.academic.api.json;

import com.google.gson.*;
import org.fenixedu.academic.domain.Person;
import org.fenixedu.academic.domain.Photograph;
import org.fenixedu.academic.dto.externalServices.PersonInformationBean;
import org.fenixedu.academic.util.ContentType;
import org.fenixedu.bennu.core.json.JsonBuilder;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Base64;

public class PersonExtendedAdapter extends PersonMinimalAdapter {
    public static final DateTimeFormatter formatDay = DateTimeFormat.forPattern("dd/MM/yyyy");

    @Override
    public JsonElement view(Person person, JsonBuilder jsonBuilder) {
        JsonObject json = new JsonObject();

        json.addProperty("username", person.getUsername());
        json.addProperty("name", person.getName());


        PersonInformationBean pib = new PersonInformationBean(person, true);

        json.addProperty("name", pib.getName());
        json.addProperty("gender", person.getGender().name());
        json.addProperty("birthday", person.getDateOfBirthYearMonthDay().toString(formatDay));
        json.addProperty("username", person.getUsername());
        json.addProperty("campus", pib.getCampus());
        json.addProperty("email",person.getEmailForSendingEmails());
        json.add("workEmails", getWorkEmails(pib));
        json.add("personalEmails", getPersonalEmails(pib));
        json.add("photo", getPhoto(person));

        return json;
    }


    private JsonArray getPersonalEmails(PersonInformationBean pib) {
        JsonArray personalEmails = new JsonArray();
        for(String personalEmail : pib.getPersonalEmails()) {
            personalEmails.add(new JsonPrimitive(personalEmail));
        }
        return personalEmails;
    }

    private JsonArray getWorkEmails(PersonInformationBean pib) {
        JsonArray workEmails = new JsonArray();
        for(String workEmail : pib.getWorkEmails()) {
            workEmails.add(new JsonPrimitive(workEmail));
        }
        return workEmails;
    }

    private JsonElement getPhoto(final Person person) {
        JsonObject photo = new JsonObject();
        try {
            final Photograph personalPhoto = person.getPersonalPhoto();
            if (!person.isPhotoAvailableToCurrentUser()) {
                return JsonNull.INSTANCE;
            }

            final byte[] avatar = personalPhoto.getDefaultAvatar();
            String type = ContentType.PNG.getMimeType();
            String data = Base64.getEncoder().encodeToString(avatar);

            photo.addProperty("type", type);
            photo.addProperty("data", data);

            return photo;

        } catch (Exception npe) {
            return JsonNull.INSTANCE;
        }
    }
}
