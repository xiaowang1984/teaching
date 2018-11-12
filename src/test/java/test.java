

import com.neuedu.service.workstudent.IworkstudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {
    @Resource
    IworkstudentService workstudentService;
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
         calendar.set(2018, 11, 1);
         Date date = calendar.getTime();
        System.out.println(date);
    }
    @Test
    public void handler() throws ParseException {
        workstudentService.batchload(new Date());
    }
}
