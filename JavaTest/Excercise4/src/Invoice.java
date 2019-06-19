public class Invoice implements Payable {
	private String partNumber, partDesctiption;
	private int quanlity;
	private double pricePerItem;
	public Invoice() {
		super();
	}
	public Invoice(String partNumber, String partDesctiption, int quanlity, double pricePerItem) {
		this.setPartNumber(partNumber);
		this.setPartDesctiption(partDesctiption);
		this.setQuanlity(quanlity);
		this.setPricePerItem(pricePerItem);
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getPartDesctiption() {
		return partDesctiption;
	}
	public void setPartDesctiption(String partDesctiption) {
		this.partDesctiption = partDesctiption;
	}
	public int getQuanlity() {
		return quanlity;
	}
	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	@Override
	public void getPaymentAmount() {
		// TODO Auto-generated method stub
		
	}
}
