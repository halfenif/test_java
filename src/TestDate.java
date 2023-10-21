public class TestDate {

//    java.time.LocalDate - 날짜(시간 포함하지 않음), 타임존 사용하지 않음.
//    java.time.LocalTime - 시간(날짜 포함하지 않음), 타임존 사용하지 않음.
//    java.time.LocalDateTime - 날짜 및 시간, 타임존 사용하지 않음.
//    java.time.ZonedDateTime - 날짜 및 시간, 타임존 사용.
//    java.time.DateTimeFormatter - java.time에 대한 형식 (날짜 -> 텍스트), 변환 (텍스트 -> 날짜)
//    java.time.Duration - 시간을 초 단위 및 나노초 단위로 측정한다.
//    java.time.Period - 시간을 년, 월, 일로 측정한다.
//    java.time.TemporalAdjuster - 날짜를 조정한다.




//  CREATE TABLE "TEST"."T_DIFF"
//(	"C_KEY" VARCHAR2(100),
//  "C_BEGIN" DATE,
//  "C_END" DATE,
//    CONSTRAINT "T_DIFF_PK" PRIMARY KEY ("C_KEY")
//    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
//    STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
//            PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
//    TABLESPACE "TEST"  ENABLE
//   ) SEGMENT CREATION IMMEDIATE
//    PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
//    STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
//            PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
//    TABLESPACE "TEST" ;
//
//    CREATE UNIQUE INDEX "TEST"."T_DIFF_PK" ON "TEST"."T_DIFF" ("C_KEY")
//    PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
//    STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
//            PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
//    TABLESPACE "TEST" ;

//    SELECT  CAST (SYS_GUID() AS VARCHAR2(100)) FROM dual;



//    INSERT INTO TEST.T_DIFF (C_KEY, C_BEGIN, C_END)
//    SELECT CAST (SYS_GUID() AS VARCHAR2(100))
//            , SYSDATE
//      , SYSDATE + (10/(24 * 60 * 60) + 10/(24 * 60))
//    FROM DUAL;
//
//
//
//    SELECT T_EXTRACT.C_KEY
//        , T_EXTRACT.C_BEGIN
//        , T_EXTRACT.C_END
//        , CASE WHEN D > 0 THEN TO_CHAR(D) || '일 '   ELSE  '' END ||
//    CASE WHEN H > 0 THEN TO_CHAR(H) || '시간 ' ELSE '' END ||
//    CASE WHEN M > 0 THEN TO_CHAR(M) || '분 ' ELSE '' END ||
//    CASE WHEN S > 0 THEN TO_CHAR(S) || '초' ELSE '' END
//    AS DIFF
//    FROM (
//            SELECT T_SOURCE.C_KEY
//            , T_SOURCE.C_BEGIN
//            , T_SOURCE.C_END
//            , EXTRACT(day    FROM T_SOURCE.DIFF) AS D
//        , EXTRACT(hour   FROM T_SOURCE.DIFF) AS H
//        , EXTRACT(minute FROM T_SOURCE.DIFF) AS M
//        , EXTRACT(second FROM T_SOURCE.DIFF) AS S
//    FROM (
//            SELECT C_KEY
//            , C_BEGIN
//            , C_END
//            , (CAST(C_END AS TIMESTAMP) - CAST(C_BEGIN AS TIMESTAMP)) AS DIFF
//    FROM T_DIFF
//             ) T_SOURCE
//      ) T_EXTRACT
//    ;


    public static void main(String[] args) {
        //Java에서 처리하는 것 보다 SQL에서 처리하는 것이 바람직해보인다.
    }

}
