USE lis;
/*1. display the bookwise information have status as 'N' 
information include subject name, subject id, accession no of book*/

SELECT  s.subject_nm, t.subject_id,  b.accession_no FROM books b

INNER JOIN titles t

ON b.title_id = t.title_id

INNER JOIN subjects s

ON s.subject_id = t.subject_id

WHERE (b.status) = 'N'; 


/*2. Display those rows from book issue table where difference between issue
date and due date is greater than 2 */

SELECT * FROM book_issue bi

WHERE PERIOD_DIFF(DATE_FORMAT(bi.due_dt,'%Y%m'), DATE_FORMAT(bi.issue_dt,'%Y%m'))>=2;


/*3. display the name of books have price greater then minimum price book*/

SELECT s.subject_nm FROM books b

INNER JOIN titles t

ON b.title_id = t.title_id

INNER JOIN subjects s

ON s.subject_id = t.subject_id

WHERE (b.price) > (SELECT MIN(PRICE) FROM books);