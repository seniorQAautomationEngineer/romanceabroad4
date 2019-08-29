package com.romanceabroad.ui;

import org.openqa.selenium.By;

public class Locators {

    public static  final By H1_TITLE = By.xpath("//h1");

    //Main Page
    public static final By MOBILE_MENU = By.xpath("//span[@class='navbar-toggler-icon']");
    public static final By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static  final By BUTTON_REGISTRATION = By.xpath("//button[@id='show-registration-block']");
    public static  final By LINK_MEDIA = By.cssSelector("a[href='https://romanceabroad.com/media/index']");
    public static final By LINK_SIGN_IN = By.xpath("//a[@href='https://romanceabroad.com/users/login_form'][@id='ajax_login_link']");
    public static final By TEXT_FIELD_EMAIL_SIGN_IN = By.xpath("//div[@class='col-xs-8']//input[@id='email']");
    public static final By TEXT_FIELD_PASSWORD_SIGN_IN = By.xpath("//div[@class='col-xs-8']//input[@id='password']");
    public static final By BUTTON_SUBMIT_SIGN_IN = By.xpath("//button[@name='logbtn']");
    public static final By ALERT_WRONG_PASSWORD = By.xpath("//div[@class='error alert-danger alert-warning_pop_']");
    //Photos page

    public static  final By LINK_TAB_USER_PROFILE = By.xpath("//ul[@id = 'gallery_filters']//a");


    //Registration

    public static  final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static  final By TOOLTIP_ERROR = By.xpath("//div[@class='tooltip']");
    public static  final By TEXT_FIELD_EMAIL_REGISTRATION = By.cssSelector("input#email");
    public static  final By TEXT_FIELD_PASSWORD_REGISTRATION = By.cssSelector("input#password");
    public static  final By TEXT_FIELD_NICKNAME = By.cssSelector("#nickname");
    public static  final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");
    public static  final By LIST_DAYS = By.cssSelector("#daySelect");
    public static  final By LIST_MONTHS = By.cssSelector("#monthSelect");
    public static  final By LIST_YEARS = By.cssSelector("#yearSelect");
    public static  final By LIST_VALUE_DAY = By.xpath("//li[@data-handler='selectDay']");
    public static  final By LIST_VALUE_MONTH = By.xpath("//li[@data-handler='selectMonth']");
    public static  final By LIST_VALUE_YEAR =By.xpath("//li[@data-handler='selectYear']");
    public static  final By CHECKBOX_CONFIRMATION =By.cssSelector("input#confirmation");
    public static  final By AUTOFILLING_FORM_LOCATION =By.xpath("//input[@name='region_name']");
    public static  final By LIST_VALUE_LOCATION =By.xpath("//div[@class='dropdown dropdown_location']//ul//li");


    //Search page

    public static final By DROP_DOWN_LIST_SORT_BY = By.xpath("//div[@class='form-inline']//select");
    public static final By DROP_DOWN_MAX_AGE = By.cssSelector("select#age_max");
    public static final By DROP_DOWN_MIN_AGE = By.cssSelector("select#age_min");
    public static final By BUTTON_SEARCH = By.cssSelector("#main_search_button_user_advanced");
    public static final By TEXT_USER_INFO = By.xpath("//div[@class='text-overflow']");
    public static final By MOBILE_LINK_SEARCH_PARAMETERS = By.xpath("//div[@class='search-param-button mb10']//a");


    //Blog page
    public static final By LINKS_OF_ACRTICLES = By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li");



}
