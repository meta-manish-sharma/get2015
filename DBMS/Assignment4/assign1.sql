/*1. Write a SELECT command to display name of those members
who belong to the category as to which member
“Keshav Sharma” belongs.
Note: Solve the problem using subquery.*/

USE lis;
SELECT member_nm FROM members 
WHERE catagory = (SELECT catagory FROM members WHERE member_nm = "manish");


/*2. Write a SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date.
Note: Use Correlated Subquery.*/

SELECT m.member_nm, m.member_id, t.title_nm, bi.issue_dt, bi.due_dt 
FROM book_issue bi, members m, books b, titles t
WHERE bi.accession_no = b.accession_no AND b.title_id = t.title_id
AND bi.member_id = m.member_id AND (bi.accession_no, bi.member_id)
NOT EXISTS(SELECT accession_no ,member_id FROM book_return);


/*3. Write a SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due
date.
Note: Use Correlated Subquery.*/

SELECT m.member_id, m.member_nm, b.accession_no ,t.title_id ,t.title_nm ,bi.issue_dt ,bi.due_dt 
FROM members m,books b,titles t,book_issue bi
WHERE m.member_id = bi.member_id AND b.accession_no = bi.accession_no AND t.title_id = b.title_id AND
(DATEDIFF( (SELECT br.return_dt FROM book_return br WHERE br.accession_no = bi.accession_no
AND bi.member_id = bi.member_id AND DATEDIFF(bi.issue_dt, br.issue_dt) = 0) ,bi.due_dt)>0);


/*4. Write a SELECT command to display information of those books
whose price is equal to the most expensive book purchase so far.*/

SELECT s.subject_nm, b.title_id, t.title_nm, a.author_nm, p.publisher_nm, b.purchase_dt 
FROM books b, titles t,title_author ta, authors a, subjects s, publishers p
WHERE b.title_id = t.title_id AND t.subject_id = s.subject_id AND t.title_id = ta.title_id
AND ta.author_id = a.author_id AND t.publisher_id = p.publisher_id AND b.price =
(SELECT MAX(price) FROM books);


/*5. Write a SELECT command to display the second maximum price
of a book.*/

SELECT MAX(price) FROM books 
WHERE price NOT IN 
(SELECT MAX(price) FROM books);