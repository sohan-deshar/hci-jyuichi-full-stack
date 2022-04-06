package api.mongo.juichibackend.Menu;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import java.util.Locale;


public enum MenuType {
    DESSERT("DESSERT"),
    MAIN("MAIN"),
    DRINK("DRINK"),
    @JsonEnumDefaultValue
    UNKNOWN("UNKNOWN");

    private final String value;

    MenuType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static MenuType fromValue(String value){
        if (value != null){
            for(MenuType type : values()){
                if(type.value.equals(value.toUpperCase(Locale.ROOT))){
                    return type;
                }
            }
        }

        return getDefault();
    }

    public String toValue(){
        return value;
    }

    public static MenuType getDefault(){
        return UNKNOWN;
    }
}
