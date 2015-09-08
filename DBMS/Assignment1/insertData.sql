USE lis;

/*Insert data into members table*/

INSERT INTO members (
	`member_id`, `member_nm`, `addressline1`, `addressline2`, `catagory`)
 	VALUES ('student1', 'manish', 'EPIP', 'jaipur, rajasthan', 'student'
);

INSERT INTO members (
	`member_id`, `member_nm`, `addressline1`, `addressline2`, `catagory`)
 	VALUES ('teacher1', 'rohit', 'Malviya nagar', 'jaipur, rajasthan', 'teacher'
);

INSERT INTO members (
	`member_id`, `member_nm`, `addressline1`, `addressline2`, `catagory`)
 	VALUES ('student2', 'jignesh', 'EPIP', 'kota', 'student'
);

INSERT INTO members (
	`member_id`, `member_nm`, `addressline1`, `addressline2`, `catagory`)
 	VALUES ('teacher2', 'prakash', 'Civil lines', 'delhi', 'teacher'
);


/*Insert data into subjects table*/

INSERT INTO subjects (
	`subject_id`, `subject_nm`)
	 VALUES ('dbms1', 'dbms'
);

INSERT INTO subjects (
	`subject_id`, `subject_nm`)
	 VALUES ('dbms2', 'rdbms'
);

INSERT INTO subjects (
	`subject_id`, `subject_nm`)
	 VALUES ('oops1', 'oops'
);


/*Insert data into publishers table*/
INSERT INTO publishers (
	`publisher_id`, `publisher_nm`)
	 VALUES ('publisher1', 'jaipur books'
);

INSERT INTO publishers (
	`publisher_id`, `publisher_nm`)
	 VALUES ('publisher2', 'delhi books'
);

INSERT INTO publishers (
	`publisher_id`, `publisher_nm`)
	 VALUES ('publisher3', 'Ajmer books'
);



/*Insert into authors table*/

INSERT INTO authors (
	`author_id`, `author_nm`)
	 VALUES ('author1', 'mehul'
);

INSERT INTO authors (
	`author_id`, `author_nm`)
	 VALUES ('author2', 'manish'
);

INSERT INTO authors (
	`author_id`, `author_nm`)
	 VALUES ('author3', 'suman'
);


/*insert data into titles*/

INSERT INTO titles (
	`title_id`, `title_nm`, `subject_id`, `publisher_id`)
	 VALUES ('title1', 'first title', 'dbms1', 'publisher1'
);
INSERT INTO titles (
	`title_id`, `title_nm`, `subject_id`, `publisher_id`)
	 VALUES ('title2', 'second title', 'dbms2', 'publisher2'
);

INSERT INTO titles (
	`title_id`, `title_nm`, `subject_id`, `publisher_id`)
	 VALUES ('title3', 'thrird title', 'oops1', 'publisher3'
);
/*Insert data into title_author*/

INSERT INTO title_author (
	`title_id`, `author_id`) 
	VALUES ('title1', 'author1'
);

INSERT INTO title_author (
	`title_id`, `author_id`) 
	VALUES ('title2', 'author2'
);

INSERT INTO title_author (
	`title_id`, `author_id`) 
	VALUES ('title3', 'author3'
);


/*Insert into books*/

INSERT INTO books (
	`accession_no`, `title_id`, `purchase_dt`, `price`, `status`)
	VALUES (100, 'title1', '2015-03-12', 20, 'F'
);

INSERT INTO books (
	`accession_no`, `title_id`, `purchase_dt`, `price`, `status`)
	VALUES (101, 'title2', '2015-04-12', 22, 'N'
);

INSERT INTO books (
	`accession_no`, `title_id`, `purchase_dt`, `price`, `status`)
	VALUES (102, 'title3', '2015-05-12', 32, 'N'
);

/*Insert into book_issue*/

INSERT INTO book_issue (
	`issue_dt`, `accession_no`, `member_id`, `due_dt`) 
	VALUES ('2015-08-01', 101, 'student1', '2015-08-16'
);
INSERT INTO book_issue (
	`issue_dt`, `accession_no`, `member_id`, `due_dt`) 
	VALUES ('2015-08-15', 102, 'teacher1', '2015-08-31'
);
/*Insert into book_return*/
INSERT INTO book_return (
	`return_dt`, `accession_no`, `member_id`, `issue_dt`) 
	VALUES ('2015-08-31', 100, 'student2', '2015-08-15'
);



/*Change value of addressLine2 column of Members table with “Jaipur”*/
UPDATE  members SET addressline2 = "Jaipur";



/*Change value of addressLine1 column of Members table with value “EPIP, Sitapura” for the members belonging to category “Student”.*/
Update  members set addressline1 = "EPIP, Sitapura"
where catagory = "student";



/*Delete all the rows from Publishers table.*/

/*store table data into temporary tables*/
CREATE TEMPORARY TABLE tempPublisher ENGINE=MEMORY  AS (SELECT * FROM publishers);
CREATE TEMPORARY TABLE tempTitle ENGINE=MEMORY  AS (SELECT * FROM titles);
CREATE TEMPORARY TABLE temptitle_authors ENGINE=MEMORY  AS (SELECT * FROM title_authors);
CREATE TEMPORARY TABLE tempbooks ENGINE=MEMORY  AS (SELECT * FROM books);
CREATE TEMPORARY TABLE tempbook_issue ENGINE=MEMORY  AS (SELECT * FROM book_issue);
CREATE TEMPORARY TABLE tempbook_return ENGINE=MEMORY  AS (SELECT * FROM book_return);

/*Delete all rows of publishers tables*/
DELETE FROM publishers;

/*Insert the sample data back in Publishers table using substitution variables.*/
INSERT INTO publishers SELECT * FROM tempPublisher;
INSERT INTO titles SELECT * FROM tempTitle;
INSERT INTO title_authors SELECT * FROM temptitle_authors;
INSERT INTO books SELECT * FROM tempbooks;
INSERT INTO book_issue SELECT * FROM tempbook_issue;
INSERT INTO book_return SELECT * FROM tempbook_return;




/*Delete those rows of Titles table belonging to Publisher with publisher_id = publisher2*/
DELETE FROM titles WHERE publisher_id='publisher2';