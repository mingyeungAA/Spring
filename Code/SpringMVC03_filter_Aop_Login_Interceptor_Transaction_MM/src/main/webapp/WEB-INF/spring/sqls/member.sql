DROP SEQUENCE MEMNOSEQ;
DROP TABLE MEMBER;

CREATE SEQUENCE MEMNOSEQ;

CREATE TABLE MEMBER(
	MEMNO NUMBER PRIMARY KEY,
	MEMID VARCHAR2(500) NOT NULL,
	MEMPW VARCHAR2(500) NOT NULL,
	MEMNAME VARCHAR2(500) NOT NULL
);

INSERT INTO MEMBER
VALUES (MEMNOSEQ.NEXTVAL, 'admin', 'admin1234', '관리자');

SELECT MEMNO, MEMID, MEMPW, MEMNAME
FROM MEMBER
ORDER BY MEMNO DESC;

