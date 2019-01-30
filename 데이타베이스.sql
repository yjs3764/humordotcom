---------------<쿼리 정리한것>---------------

------------게시판 테이블------------

create table board 
(
boardnum number constraint board_boardnum_pk primary key, -- 게시물 번호
usernick varchar2(15), -- 글작성자
boardtitle varchar2(100) constraint board_boardtitle_nn not null, -- 제목
boardcontent varchar2(3000), -- 내용
boardfile varchar2(100), -- 첨부파일
boardpass varchar2(12), -- 비밀번호
recomm number default 0, -- 추천수
ipnum varchar2(15), -- ip주소
readcount number default 0, -- 조회수
boarddate date default sysdate, -- 작성일자
ismember number constraint board_ismember_ck check(ismember in(0, 1)) -- 회원여부체크(1은 회원, 0은 비회원)
);
create sequence board_seq start with 1 increment by 1;
update boarduser set userclass=0 where userid='sorry';
commit;
select * from board_comment;
select * from board;
select * from boarduser;
delete from boarduser;
desc boarduser;
delete from board;
delete from board_comment;
commit;
insert into boarduser values(user_seq.nextval, 'jaehwanspin', 'j19016427', '난관리자야', '진재환', 01040589050, 'jaehwanspin@gmail.com', sysdate, 1);
commit;

alter table board_comment add constraint board_comment_board_fk foreign key(comment_board) references board(boardnum) on delete cascade;
alter table board_comment drop constraint board_comment_board_fk;
commit;
create table board_comment
(
comment_num number constraint board_comment_num_pk primary key, --댓글번호
comment_board number constraint board_comment_board_fk references board(boardnum) on delete cascade, --상속된 게시판 번호
comment_usernick varchar2(15) not null, --닉네임
comment_content varchar2(100) not null,  --댓글내용
comment_ismember number constraint board_comment_ismember_ck check(comment_ismember in(0,1)), --회원여부
comment_pass varchar2(15) constraint board_comment_pass_nn not null --댓글비밀번호
);
create sequence comment_seq start with 1 increment by 1; 

alter table board_comment modify comment_usernick varchar2(30);

delete from board where boardnum = 23 on delete cascade;
commit;
create table banipnum
(
  ipnum varchar2(15) constraint banipnum_ipnum_pk primary key
);