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

        String sql = "select distinct a.pk, a.surgeryName, a.clerkName, a.customerName, a.orderTime, b.forecastTime, b.pk surgery_pk,\n" +
                "case\n" +
                "    when c.pk is not null then  (select group_concat(d.pk) from surgery_arrange d where d.surgery_order_fk=a.pk) \n" +
                "    else null end surgery_arrange_pk \n" +
                "from (surgery_order a left join surgery b on a.surgery_fk=b.pk) left join surgery_arrange c on a.pk=c.surgery_order_fk \n" +
                "order by surgery_arrange_pk desc, a.orderTime asc\n" +
                "limit 0,10";


        SQLParser parser = new SQLParser();
        StatementNode statementNode = parser.parseStatement(sql);
        MyNodeToString myNodeToString = new MyNodeToString();
        String result = myNodeToString.toString(statementNode);
        System.out.println(result);


    }


}
