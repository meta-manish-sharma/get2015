/*1. Create a View which can be used to display member name and
all issue details of the member using a simple SELECT command.*/

USE lis;
CREATE VIEW member_issue AS
SELECT m.member_nm, m.member_id, m.addressline1, m.addressline2, m.catagory,
bi.issue_dt, bi.accession_no, bi.due_dt FROM book_issue bi
INNER JOIN members AS m
ON m.member_id = bi.member_id;

SELECT * FROM member_issue;


/*2. Create a View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O.*/

CREATE VIEW member_details AS
SELECT m.member_nm AS member_name, m.member_id AS member_id,
if ( m.catagory = 'o' ,'Other',if ( m.catagory = 's' ,'Student',if ( m.catagory = 't' ,'teacher',m.catagory)))  AS catagory FROM members m;
SELECT * FROM member_details;

SELECT * FROM member_details;


/*3. Create a View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date.*/

CREATE VIEW book_details AS
SELECT m.member_nm, m.catagory, s.subject_nm, t.title_nm, bi.issue_dt, bi.due_dt, br.return_dt
FROM members m, books b, titles t, subjects s, book_issue bi
LEFT JOIN book_return br
ON bi.accession_no=br.accession_no AND bi.member_id=br.member_id
WHERE m.member_id = bi.member_id AND bi.accession_no = b.accession_no AND b.title_id = t.title_id
AND  t.subject_id = s.subject_id;