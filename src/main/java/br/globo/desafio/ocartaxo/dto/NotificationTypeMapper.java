package br.globo.desafio.ocartaxo.dto;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import br.globo.desafio.ocartaxo.dto.NotificationType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationTypeMapper {

    default NotificationType fromDTO(JsonObject notification) {
        Gson gson = new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();


        return gson.fromJson(notification, NotificationType.class);
    }


}
