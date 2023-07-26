package persistence;

import org.json.JSONObject;

//Credit: The program is greatly based off of JsonSerializationDemo, CPSC210, UBC
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();

}
