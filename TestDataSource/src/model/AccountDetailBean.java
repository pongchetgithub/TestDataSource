package model;

public class AccountDetailBean {
	private String accountName = "Hello";
	private String accountNumber = "0123456789";
	private String accountStatus = "OK";
	private String resultCode = "00" ;
	private String resultDescription = "Success" ;
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultDescription() {
		return resultDescription;
	}
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
	
}
