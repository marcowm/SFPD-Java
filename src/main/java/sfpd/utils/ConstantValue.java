package sfpd.utils;

import java.math.BigDecimal;
import java.sql.Date;

public final class ConstantValue {

    public static final Long NUM_LONG = 1L;
    public static final Integer ID_LONG = 1;
    public static final Integer NUM_INTEGER = 1;
    public static final String STRING_VAZIA = "";
    public static final String STRING_TESTE = "TESTE";
    public static final BigDecimal NUM_BIGDECIMAL = BigDecimal.valueOf (1.01d);
    public static final Date DATE_SQL = Date.valueOf("2021-01-01");

    public ConstantValue() {
    }
}
