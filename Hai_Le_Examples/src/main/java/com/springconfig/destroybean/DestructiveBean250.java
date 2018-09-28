package com.springconfig.destroybean;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBean250 {

    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropSet() throws Exception {
        System.out.println("Initializing Bean");

        if(filePath == null) {
            throw new IllegalArgumentException("Reason: " + DestructiveBean250.class);
        }
        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean");

        if(!file.delete()) {
            System.err.println("Error: failed to delete file.");
        }

        System.out.println("File exists: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) throws Exception {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/springconfig/META-INF/destructive-bean-250.xml");
        context.refresh();
        DestructiveBean250 bean250 = (DestructiveBean250) context.getBean("destructiveBean");
        System.out.println("Calling destroy()");
        context.destroy();
        System.out.println("Called destroy()");
    }
}
