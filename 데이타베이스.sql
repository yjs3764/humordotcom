---------------<���� �����Ѱ�>---------------

------------�Խ��� ���̺�------------

create table board 
(
boardnum number constraint board_boardnum_pk primary key, -- �Խù� ��ȣ
usernick varchar2(15), -- ���ۼ���
boardtitle varchar2(100) constraint board_boardtitle_nn not null, -- ����
boardcontent varchar2(3000), -- ����
boardfile varchar2(100), -- ÷������
boardpass varchar2(12), -- ��й�ȣ
recomm number default 0, -- ��õ��
ipnum varchar2(15), -- ip�ּ�
readcount number default 0, -- ��ȸ��
boarddate date default sysdate, -- �ۼ�����
ismember number constraint board_ismember_ck check(ismember in(0, 1)) -- ȸ������üũ(1�� ȸ��, 0�� ��ȸ��)
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
insert into boarduser values(user_seq.nextval, 'jaehwanspin', 'j19016427', '�������ھ�', '����ȯ', 01040589050, 'jaehwanspin@gmail.com', sysdate, 1);
commit;

alter table board_comment add constraint board_comment_board_fk foreign key(comment_board) references board(boardnum) on delete cascade;
alter table board_comment drop constraint board_comment_board_fk;
commit;
create table board_comment
(
comment_num number constraint board_comment_num_pk primary key, --��۹�ȣ
comment_board number constraint board_comment_board_fk references board(boardnum) on delete cascade, --��ӵ� �Խ��� ��ȣ
comment_usernick varchar2(15) not null, --�г���
comment_content varchar2(100) not null,  --��۳���
comment_ismember number constraint board_comment_ismember_ck check(comment_ismember in(0,1)), --ȸ������
comment_pass varchar2(15) constraint board_comment_pass_nn not null --��ۺ�й�ȣ
);
create sequence comment_seq start with 1 increment by 1; 

alter table board_comment modify comment_usernick varchar2(30);

delete from board where boardnum = 23 on delete cascade;
commit;
create table banipnum
(
  ipnum varchar2(15) constraint banipnum_ipnum_pk primary key
);