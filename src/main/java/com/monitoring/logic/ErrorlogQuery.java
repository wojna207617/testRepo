package com.monitoring.logic;

/**
 * Created by dawid.wojna on 31.10.2016.
 */
public class ErrorlogQuery {

    private String query="DECLARE " +
            "tmp VARCHAR(32000); " +
            "CURSOR checkLog IS " +
            "SELECT * FROM errorlog WHERE datum>SYSDATE-240/(24*60) ORDER BY datum DESC; " +
            "BEGIN " +
            "tmp := '';" +
            "FOR error IN checkLog " +
            "LOOP " +
            "tmp := tmp || error.jobid || '<next>' || TO_CHAR(error.datum, 'DD.MM.YYYY HH24:MI:SS')  || '<next>' " +
            "|| error.counter || '<next>' || error.programmname || '<next>' || error.funktion " +
            "|| '<next>' || error.userid || '<next>' || error.parameter || '<next>' || error.fehlertext || '<next><eol>'; " +
            "END LOOP; " +
            ":1 := tmp; " +
            "END;";

    //TODO
    private String initiateQueryForLast24h="";

    public String getQuery()
    {
        return this.query;
    }
}
