package com.google.gson.annotations;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class JsonAdapter implements JsonSerializer<LocalDate> {

	@Override
	public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
		 return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
	}

}
