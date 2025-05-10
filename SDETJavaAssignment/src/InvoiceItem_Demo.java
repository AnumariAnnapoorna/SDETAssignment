
public class InvoiceItem_Demo {

	private String invoiceId;
	private String invoiceDesc;
	private int invoiceQty;
	private double invoiceItemPrice;


	public InvoiceItem_Demo(String invoiceId, String invoiceDesc, int invoiceQty, double invoiceItemPrice) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceDesc = invoiceDesc;
		this.invoiceQty = invoiceQty;
		this.invoiceItemPrice = invoiceItemPrice;
	}
	
	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceDesc() {
		return invoiceDesc;
	}

	public void setInvoiceDesc(String invoiceDesc) {
		this.invoiceDesc = invoiceDesc;
	}

	public int getInvoiceQty() {
		return invoiceQty;
	}

	public void setInvoiceQty(int invoiceQty) {
		this.invoiceQty = invoiceQty;
	}

	public double getInvoiceItemPrice() {
		return invoiceItemPrice;
	}

	public void setInvoiceItemPrice(double invoiceItemPrice) {
		this.invoiceItemPrice = invoiceItemPrice;
	}
	
	public double totalInvoicePrice(int invoiceQty, double itemPrice) {
		
		double total;
		if(invoiceQty==1) {
			total=itemPrice;
		}
		else {
			total=(double)invoiceQty * itemPrice;
		}
		return total;
	}
	
	public String toString() {
		return "Invoice Id: "+ invoiceId + "\n"
				+"Invoice Description: "+invoiceDesc+"\n"
				+"Invoice Qty: "+invoiceQty+"\n"
				+"Item Price: "+invoiceItemPrice+"\n";
				
	}

}
