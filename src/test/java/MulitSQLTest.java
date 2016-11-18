import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.SQLParser;
import com.foundationdb.sql.parser.StatementNode;

/**
 * @Author chenxl
 * @Date 2016/11/17 13:28
 * @Describle
 */
public class MulitSQLTest {

    public static void main(String[] args) throws StandardException {

        String sql = "";


        SQLParser parser = new SQLParser();
        StatementNode statementNode = parser.parseStatement(sql);
        MyNodeToString myNodeToString = new MyNodeToString();
        String result = myNodeToString.toString(statementNode);
        System.out.println(result);


    }


}
