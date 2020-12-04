package app.constants;

public class ConstantNameFromJsp {
    public static final String SIGNIN_PAGE_URI = "WEB-INF/views/signin.jsp";
    public static final String MAIN_PAGE_URI = "WEB-INF/views/main.jsp";
    public static final String SIGNUP_PAGE_URI = "WEB-INF/views/signup.jsp";
    public static final String ERROR_PAGE_URI = "WEB-INF/views/errorPage.jsp";

    public static final String REQUEST_PARAMETER_COMMAND = "command";
    public static final String LAST_REQUEST_PARAM = "lastRequest";

    public static final String CHARACTER_ENCODING_ATTR = "characterEncoding";
    public static final String REQUEST_PARAMETER_USERNAME = "username";
    public static final String REQUEST_PARAMETER_LOGIN = "password";
    public static final String REDIRECT_COMMAND_SUCCESS = "Controller?command=go_to_main&login=success";
    public static final String REDIRECT_COMMAND_ERROR = "Controller?command=go_to_login&login=fail";
    public static final String ORDER_ID_SESSION_ATTR = "orderId";
    public static final String USER_SESSION_ATTR = "user";

}
