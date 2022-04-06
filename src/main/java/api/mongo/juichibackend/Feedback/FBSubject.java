package api.mongo.juichibackend.Feedback;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import java.util.Locale;

public enum FBSubject {
    FOOD("FOOD"),
    SERVICE("SERVICE"),
    WEBSITE("WEBSITE"),
    @JsonEnumDefaultValue
    OTHER("OTHER");

    private final String value;

    FBSubject(String value) {
        this.value = value;
    }

    public String toValue(){
        return this.value;
    }

    @JsonCreator
    public static FBSubject fromValue(String value){
        if(value != null){
            for(FBSubject sub: values()){
                if(sub.value.equals(value.toUpperCase(Locale.ROOT))){
                    return sub;
                }
            }
        }
        return FOOD.getDefault();
    }

    private FBSubject getDefault(){
        return OTHER;
    }
}
