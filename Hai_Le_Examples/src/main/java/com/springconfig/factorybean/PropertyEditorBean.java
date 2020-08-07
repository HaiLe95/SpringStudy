package com.springconfig.factorybean;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

public class PropertyEditorBean {

    private byte[] bytes;
    private Class cls;
    private Boolean trueOrFalse;
    private List<String> stringList;
    private Date date;
    private Float floatValue;
    private File file;
    private InputStream stream;
    private Locale locale;
    private Pattern pattern;
    private Properties properties;
    private String trimString;
    private URL url;

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
    public void setCls(Class cls) {
        this.cls = cls;
    }
    public void setTrueOrFalse(Boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
    }
    public void setFile(File file) {
        this.file = file;
    }
    public void setStream(InputStream stream) {
        this.stream = stream;
    }
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    public void setTrimString(String trimString) {
        this.trimString = trimString;
    }
    public void setUrl(URL url) {
        this.url = url;
    }

    public static class CustomPropertyEditorRegistar implements PropertyEditorRegistrar {
        @Override
        public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/DD/YYYY");
            propertyEditorRegistry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, true));
            propertyEditorRegistry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        }
    }

    public static void main(String[] args) throws Exception {
        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("blah blah blah");
        context.refresh();
        PropertyEditorBean bean = (PropertyEditorBean) context.getBean("builtInSample");
    }

}
