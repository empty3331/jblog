--DB계정 생성
create user jblog identified by jblog;
grant resource, connect to jblog;
drop user jblog cascade;


--테이블 생성
CREATE TABLE users (
  userNo	   NUMBER,
  id	   VARCHAR2(50) NOT NULL UNIQUE,
  userName VARCHAR2(100) NOT NULL,
  password  VARCHAR2(50) NOT NULL,
  joinDate   DATE NOT NULL,
  PRIMARY 	KEY(userNo)	
);

CREATE TABLE blog (
  id	   VARCHAR2(50),
  blogTitle  VARCHAR2(200) NOT NULL,
  logoFile   VARCHAR2(200),
  PRIMARY 	KEY(id),
  CONSTRAINT c_id_fk FOREIGN KEY (id)
  REFERENCES users(id)
);

CREATE TABLE category (
  cateNo	   NUMBER,
  id           VARCHAR2(50),
  cateName   VARCHAR2(200) NOT NULL,
  description VARCHAR2(500),
  regDate     DATE NOT NULL,
  PRIMARY 	KEY(cateNo),
  CONSTRAINT c_cateid_fk FOREIGN KEY (id)
  REFERENCES blog(id)
);

CREATE TABLE post (
  postNo	  NUMBER,
  cateNo      NUMBER,
  postTitle   VARCHAR2(300) NOT NULL,
  postContent VARCHAR2(4000),
  regDate     DATE NOT NULL,
  PRIMARY 	KEY(postNo),
  CONSTRAINT c_cateNo_fk FOREIGN KEY (cateNo)
  REFERENCES category(cateNo)
);

CREATE TABLE comments (
  cmtNo	  NUMBER,
  postNo  NUMBER,
  userNo  NUMBER,
  cmtContent VARCHAR2(1000) NOT NULL,
  regDate     DATE NOT NULL,
  PRIMARY 	KEY(cmtNo),
  CONSTRAINT c_postNo_fk FOREIGN KEY (postNo)
  REFERENCES post(postNo),
  CONSTRAINT c_userNo_fk FOREIGN KEY (userNo)
  REFERENCES users(userNo)
);


--시퀀스 생성
CREATE SEQUENCE seq_users_no
INCREMENT BY 1
START WITH 1 
NOCACHE ;

CREATE SEQUENCE seq_category_no
INCREMENT BY 1
START WITH 1 
NOCACHE ;

CREATE SEQUENCE seq_post_no
INCREMENT BY 1
START WITH 1 
NOCACHE ;

CREATE SEQUENCE seq_comments_no
INCREMENT BY 1
START WITH 1 
NOCACHE ;


--테이블,시퀀스 삭제
drop table users;
drop table blog;
drop table category;
drop table post;
drop table comments;
drop sequence seq_users_no;
drop sequence seq_category_no;
drop sequence seq_post_no;
drop sequence seq_comments_no;


--테스트용 내용추가
INSERT INTO users
VALUES (seq_users_no.nextval,'testid','테스트','testpw',sysdate);

INSERT INTO blog
VALUES ('testid','테스트제목','임시경로');


--테이블 확인
SELECT userno,id,username,password,joindate
FROM users;

SELECT id,blogtitle,logofile
FROM blog;

SELECT u.id,u.username,b.blogtitle,b.logofile
FROM users u,blog b
WHERE u.id = b.id;

--업데이트,삭제
update users
set userName = '김김김'
where userNo = 1;

delete from users
where userNo = 3;

--롤백,커밋
ROLLBACK;

COMMIT;