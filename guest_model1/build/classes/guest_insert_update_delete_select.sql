insert into guest values(guest_no_seq.nextval , '���ȣ1', sysdate, 'guard1@naver.com', 'http://', '���� ����1', '����ó�� ����Ͻø� �˴ϴ�1');
insert into guest values(guest_no_seq.nextval , '���ȣ2', sysdate, 'guard2@naver.com', 'http://', '���� ����2', '����ó�� ����Ͻø� �˴ϴ�2');
insert into guest values(guest_no_seq.nextval , '���ȣ3', sysdate, 'guard3@naver.com', 'http://', '���� ����3', '����ó�� ����Ͻø� �˴ϴ�3');
insert into guest values(guest_no_seq.nextval , '���ȣ4', sysdate, 'guard4@naver.com', 'http://', '���� ����4', '����ó�� ����Ͻø� �˴ϴ�4');
insert into guest values(guest_no_seq.nextval , '���ȣ5', sysdate, 'guard5@naver.com', 'http://', '���� ����5', '����ó�� ����Ͻø� �˴ϴ�5');
commit;

delete from guest where guest_no = 1;
update guest set guest_name='name����',
                 guest_email='email����',
                 guest_homepage='homepage����',
                 guest_title='title����',
                 guest_content='content����'
where guest_no = 3;

select * from guest;
select * from guest where guest_no = 3;
desc guest;
commit;


 	


