package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Phone {
    private final String name;
    private final boolean nfc;
    private final int ram;
    private final Cpu cpu;
    private final String[] options;

    public Phone(String name, boolean nfc, int ram, Cpu cpu, String... options) {
        this.name = name;
        this.nfc = nfc;
        this.ram = ram;
        this.cpu = cpu;
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public boolean isNfc() {
        return nfc;
    }

    public int getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return "Phone{"
                + "name='" + name + '\''
                + ", nfc=" + nfc
                + ", ram=" + ram
                + ", cpu=" + cpu
                + ", options=" + Arrays.toString(options)
                + '}';
    }

    public static void main(String[] args) {
        final Phone phone = new Phone("Xiaomi", true, 4, new Cpu("Snapdragon"), "wifi", "gps");

        JSONObject jsonCpu = new JSONObject("{\"name\":\"Snapdragon\"}");
        List<String> list = new ArrayList<>();
        list.add("wifi");
        list.add("gps");
        JSONArray jsonOptions = new JSONArray(list);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", phone.getName());
        jsonObject.put("nfc", phone.isNfc());
        jsonObject.put("ram", phone.getRam());
        jsonObject.put("cpu", jsonCpu);
        jsonObject.put("options", jsonOptions);
        System.out.println(jsonObject.toString());

        final JSONObject jsonObject1 = new JSONObject(phone);
        jsonObject1.put("options", new JSONArray(phone.options));
        jsonObject1.put("cpu", jsonCpu);
        System.out.println(jsonObject1.toString());

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(phone));

        final String phoneJson =
                "{"
                        + "\"name\":Xiaomi,"
                        + "\"nfc\":true,"
                        + "\"ram\":4,"
                        + "\"cpu\":"
                        + "{"
                            + "\"name\":\"Snapdragon\""
                        + "},"
                        + "\"options\":"
                            + "[\"wifi\",\"gps\"]"
                + "}";

        final Phone phoneMod = gson.fromJson(phoneJson, Phone.class);
        System.out.println(phoneMod);
    }
}
