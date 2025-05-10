
public class InvoiceItem_Runner {
	public static void main(String args[]) {
		
		InvoiceItem_Demo item=new InvoiceItem_Demo("123","invoice",1,25.50);
		
		int qty=item.getInvoiceQty();
		if(qty<1) {
			System.out.println("Invoice Quantity always should be positive integer");
			System.exit(0);
		}
		double price=item.getInvoiceItemPrice();
		double invoiceTotal=item.totalInvoicePrice(qty, price);
		System.out.println(item);
		System.out.println("Total invoice Item price is: "+ invoiceTotal);
	}

}
