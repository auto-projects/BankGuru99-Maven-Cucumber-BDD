package pageUIs;

public class CommonPageUI {
    public static final String DYNAMIC_PAGE_BY_TEXT = "//a[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_TEXT = "//td[text()='%s']/following-sibling::td/input";
    public static final String DYNAMIC_TEXT_AREA_BY_TEXT = "//td[text()='%s']/following-sibling::td/textarea";
    public static final String DYNAMIC_DROPDOWN_BY_TEXT = "//td[text()='%s']/following-sibling::td/select";
    public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_VALUE = "//input[@type='radio' and @value='%s']";
    public static final String DYNAMIC_MESSAGE = "//p[@class='heading3' and text()='%s']";
    public static final String DYNAMIC_VALUE_AT_ROW_BY_TEXT = "//td[contains(text(),'%s')]/following-sibling::td";


}
