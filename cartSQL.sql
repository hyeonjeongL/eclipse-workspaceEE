--카트넣기 (있으면 update, 없으면 insert)
 insert into cart(c_no,c_qty,u_id,b_no) values (cart_c_no.seq.nextval, ?,?,?);
 update cart set c_no=?, c_qty=?, u_id=?, b_no=?;

--카트 수량변경 보류
 update cart set c_qty=c_qty+? where u_id=? and b_no=?;
    
--카트 선택 삭제
 delete * from cart where u_id=? and p_no=?;

--카트 전체삭제
 delete * from cart where u_id;
    
--카트리스트
 select * from cart c join book b on c.b_no=b.b_no where c.u_id=?;
 
 --수량
 select count(*) c_cnt from cart where u_id=? and b_no=?;
 
 
 
 
 

