USE lis;

/*1. Display all the columns of members table*/
SELECT * FROM members;

/*2. Display member_nm, member_id and category columns of members table*/
SELECT member_nm,member_id,catagory FROM members;

/*3. Display member_nm, member_id and category columns of members table where catagory is teacher*/
SELECT member_nm,member_id,catagory FROM members
WHERE catagory = "teacher";

/*4. Display various catagories of members*/
SELECT DISTINCT catagory FROM members;

/*5. Display member name and there catagory in the descending order of their name*/
SELECT member_nm, catagory FROM members
ORDER BY member_nm DESC;

/*6. Display all the titles, subjects and publishers*/
SELECT t.title_nm, s.subject_nm, p.publisher_nm
FROM
    titles AS t
        INNER JOIN
    subjects AS s
        ON t.subject_id = s.subject_id
        INNER JOIN
    publishers AS p
        ON t.publisher_id = p.publisher_id;		

/*7. Display no of members in each catagory along with their catagory*/
SELECT catagory, count(*) FROM members GROUP BY catagory;		

/*8. Display the name of those members who belong to the catagory as to which member "manish"*/
SELECT M1.member_nm 
FROM 
	members AS M1
		INNER JOIN 
	members AS M2
		ON M1.catagory = M2.catagory
		WHERE M2.member_nm ="manish";		

/*9 Display the status of return book and if not returned then place blank*/		
SELECT  bi.issue_dt,bi.accession_no,bi.member_id,ifnull(br.return_dt,"") AS Return_date 
FROM book_issue bi LEFT OUTER JOIN book_return br ON bi.accession_no=br.accession_no AND bi.member_id=br.member_id; 