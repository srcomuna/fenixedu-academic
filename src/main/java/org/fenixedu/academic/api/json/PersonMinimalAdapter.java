package org.fenixedu.academic.api.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.fenixedu.academic.domain.Person;
import org.fenixedu.bennu.core.annotation.DefaultJsonAdapter;
import org.fenixedu.bennu.core.json.JsonAdapter;
import org.fenixedu.bennu.core.json.JsonBuilder;

@DefaultJsonAdapter(Person.class)
public class PersonMinimalAdapter implements JsonAdapter<Person> {

    @Override
    public Person create(JsonElement jsonElement, JsonBuilder jsonBuilder) {
        return null;
    }

    @Override
    public Person update(JsonElement jsonElement, Person person, JsonBuilder jsonBuilder) {
        return null;
    }

    @Override
    public JsonElement view(Person person, JsonBuilder jsonBuilder) {
        JsonObject json = new JsonObject();
        json.addProperty("name", person.getName());
        json.addProperty("email", person.getEmailForSendingEmails());
        json.addProperty("username", person.getUsername());
        return json;
    }
}
