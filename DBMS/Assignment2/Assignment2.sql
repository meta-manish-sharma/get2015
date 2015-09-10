USE lis;
/*Modify the SELECT command written for Question 9 to display results in ascending order of issue date and within issue date in ascending order of members name.*/
SELECT m.member_nm ,bi.issue_dt,bi.accession_no,bi.member_id,IFNULL(br.return_dt,"") AS Return_date 
FROM book_issue bi LEFT OUTER JOIN book_return br ON bi.accession_no=br.accession_no AND bi.member_id=br.member_id ,members m 
WHERE m.member_id=bi.member_id 
ORDER BY bi.issue_dt ,member_nm ASC; 