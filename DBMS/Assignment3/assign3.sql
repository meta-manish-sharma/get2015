USE lis;
/*1. Display total no of students and total no of teachers in a single row*/

SELECT catagory, COUNT(catagory) FROM members

GROUP BY (catagory)

ORDER BY catagory DESC;


/*2. Display the information of those titles that have been issed more than 2 times */

SELECT t.title_nm, bi.accession_no, s.subject_nm FROM book_issue bi

INNER JOIN books b

ON b.accession_no = bi.accession_no

INNER JOIN titles t

ON b.title_id = t.title_id

INNER JOIN subjects s

ON s.subject_id = t.subject_id

GROUP BY (bi.accession_no)

having count(bi.accession_no) >= 2;


/*3. Display information on books issued to members of catagory other than teacher*/

SELECT  m.member_nm, m.member_id, t.title_nm, bi.accession_no, s.subject_nm FROM book_issue bi

INNER JOIN  members m

ON bi.member_id = m.member_id AND m.catagory NOT IN("teacher")

INNER JOIN books b

ON b.accession_no = bi.accession_no

INNER JOIN titles t

ON b.title_id = t.title_id

INNER JOIN subjects s

ON s.subject_id = t.subject_id;


/*4. Display information on those authors for which at least one book has been purchased*/

SELECT a.author_nm, ta.author_id, b.title_id FROM books b

INNER JOIN title_author ta

ON b.title_id = ta.title_id

INNER JOIN authors a

ON a.author_id = ta.author_id

WHERE b.status = "N";