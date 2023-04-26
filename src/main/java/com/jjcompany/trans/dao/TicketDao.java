package com.jjcompany.trans.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.jjcompany.trans.dto.CardDto;
import com.jjcompany.trans.dto.TicketDto;

public class TicketDao {
	
	JdbcTemplate template;
	
	TransactionTemplate transactionTemplate;
	
	

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
//	public void buyTicket(final CardDto dto) { // 트랜잭션 미적용
//		
//		this.template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				// TODO Auto-generated method stub
//				String sql = "INSERT INTO card (consumerid, amount) values (?,?)";
//				PreparedStatement pstmt =con.prepareStatement(sql);
//				pstmt.setString(1, dto.getConsumerid());
//				pstmt.setString(2, dto.getAmount());
//				
//				return pstmt;
//				
//			}
//		});
//		
//		this.template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				// TODO Auto-generated method stub
//				String sql = "INSERT INTO ticket (consumerid, countnum) values (?,?)";
//				PreparedStatement pstmt =con.prepareStatement(sql);
//				pstmt.setString(1, dto.getConsumerid());
//				pstmt.setString(2, dto.getAmount());
//				
//				return pstmt;
//				
//			}
//		});
//	}
	
public void buyTicket(final CardDto dto) { //트랜잭션 적용
	
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						// TODO Auto-generated method stub
						String sql = "INSERT INTO card (consumerid, amount) values (?,?)";
						PreparedStatement pstmt =con.prepareStatement(sql);
						pstmt.setString(1, dto.getConsumerid());
						pstmt.setString(2, dto.getAmount());
						
						return pstmt;
						
					}
				});
			
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						// TODO Auto-generated method stub
						String sql = "INSERT INTO ticket (consumerid, countnum) values (?,?)";
						PreparedStatement pstmt =con.prepareStatement(sql);
						pstmt.setString(1, dto.getConsumerid());
						pstmt.setString(2, dto.getAmount());
						
						return pstmt;
						
					}
				});
				
			}
		});
		
		
		
		
	}
	

}
