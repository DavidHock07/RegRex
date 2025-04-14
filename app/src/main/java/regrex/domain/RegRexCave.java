package regrex.domain;

public class RegRexCave {
    static String eMailRegEx = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    static String internationalTelephoneNumberRegEx = "^(\\+|00)[1-9][0-9 \\-\\(\\)\\.]{7,32}$";
    static String urlRegEx = "^https?:\\/\\/[^\\s/$.?#].[^\\s]*$";
    static String iPv4RegEx = "^(\\d{1,3}\\.){3}\\d{1,3}$";
    static String userNameRegEx = "^[a-zA-Z0-9_-]{3,16}$";
    static String weakPasswordRegEx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    static String macAdressRegEx = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";

}
