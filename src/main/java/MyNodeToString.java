import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.FromBaseTable;
import com.foundationdb.sql.unparser.NodeToString;

/**
 * @Author chenxl
 * @Date 2016/11/16 22:19
 * @Describle
 */
public class MyNodeToString extends NodeToString{

    @Override
    protected String fromBaseTable(FromBaseTable node) throws StandardException {
        String tn = "数据库类型." + toString(node.getOrigTableName());
        String n = node.getCorrelationName();
        if (n == null)
            return tn;
        else
            return tn + " AS " + n;
    }
}
