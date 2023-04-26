package com.jjcompany.trans.dto;

public class CardDto {

		private String consumerid;
		private String amount;
		
		public CardDto(String consumerid, String amount) {
			super();
			this.consumerid = consumerid;
			this.amount = amount;
		}

		public CardDto() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getConsumerid() {
			return consumerid;
		}

		public void setConsumerid(String consumerid) {
			this.consumerid = consumerid;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}
		
}
