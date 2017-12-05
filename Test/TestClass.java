import com.pinker.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class TestClass {

    @Test
    public void testGetConn(){

        Connection conn= JDBCUtils.getConnection();
        System.out.println(conn);

    }

}
