USE lis;
/*1. Display information on books issued for more than two months.
the information should include member_nm, member_id, title-nm, 
accession_no, issue_dt, due_dt, and issued for how many months
and be sorted on member_nm and within member_nm on title-nm*/

SELECT m.member_nm, bi.member_id, t.title_nm, bi.accession_no, bi.issue_dt, bi.due_dt, 

PERIOD_DIFF(DATE_FORMAT(curdate(),'%Y%m'),DATE_FORMAT(bi.issue_dt,'%Y%m')) AS Issued_Months

FROM book_issue bi

INNER JOIN members m

ON  bi.member_id = m.member_id

INNER JOIN books b

ON bi.accession_no = b.accession_no

INNER JOIN titles t

ON b.title_id = t.title_id

WHERE(PERIOD_DIFF(DATE_FORMAT(curdate(),'%Y%m'), DATE_FORMAT(bi.issue_dt,'%Y%m'))>=2);


/*2. Display those rows from members table having max length for member_nm.
Information should contain member_nm and length of member_nm.*/

SELECT  member_nm, LENGTH(member_nm) AS Length FROM members 
WHERE LENGTH(member_nm) = (SELECT  MAX(LENGTH(member_nm)) FROM members);


/*3. Display count of number of books issued so far.*/

SELECT COUNT(accession_no) AS number_of_book_issued FROM book_issue; 