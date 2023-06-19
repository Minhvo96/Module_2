package CaseStudy.Utils;
import java.util.regex.Pattern;

public class ValidateUtils {
    private static final String REGEX_NAME = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*";
    public static final String REGEX_PHONE = "^[0][1-9][0-9]{8,9}$";
    public static final String REGEX_DOB ="^(0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-((19|20)\\d{2})$";

//    public static final String REGEX_ID = "^\\d+$";

    public static boolean isValidCollaboratorName(String name) {
        return Pattern.matches(REGEX_NAME, name);
    }
    public static boolean isValidCollaboratorPhone(String phone) {
        return Pattern.matches(REGEX_PHONE, phone);
    }
    public static boolean isValidCollaboratorDoB(String dob) {
        return Pattern.matches(REGEX_DOB, dob);
    }

//    public static boolean isValidCollaboratorID(String id) {
//        return Pattern.matches(REGEX_ID, id);
//    }
}
