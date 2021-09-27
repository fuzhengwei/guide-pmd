package cn.itedus.demo.test;

import net.sourceforge.pmd.PMD;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_naming(){
        String[] str = {
                "-d",
                "E:\\itstack\\git\\github.com\\guide-pmd\\src\\test\\java\\cn\\itedus\\demo\\test\\TErrDto.java",
                "-f",
                "text",
                "-R",
                "E:\\itstack\\git\\github.com\\guide-pmd\\src\\main\\resources\\rule\\ali-naming.xml"
                // "category/java/codestyle.xml"
        };

        PMD.main(str);
    }

}
