package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.AccountDetailBean;

@WebService()
public class AcctInq {

	@WebMethod(operationName="accountInquiryWS")
	public AccountDetailBean accountInquiryWS(@WebParam(name="AccountNumber") String number) {
	    System.out.println("Hello World");
	    return new AccountDetailBean();
	}
}

