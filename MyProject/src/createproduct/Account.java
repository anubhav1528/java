package createproduct;

public class Account {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AccountBalance;
		result = prime * result + ((AccountHolderName == null) ? 0 : AccountHolderName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (AccountBalance != other.AccountBalance)
			return false;
		if (AccountHolderName == null) {
			if (other.AccountHolderName != null)
				return false;
		} else if (!AccountHolderName.equals(other.AccountHolderName))
			return false;
		return true;
	}

	private String AccountHolderName;
	private int AccountBalance;
	private static int count = 0;

	public Account() {
		count++;
		System.out.println("No. of count is:-" + count);
	}

	public Account(String AccountHolderName, int AccountBalance) {
		this.AccountHolderName = AccountHolderName;
		this.AccountBalance = AccountBalance;
	}

	public boolean checkEquality(Account object) {
		if (this.AccountBalance == object.AccountBalance && this.AccountHolderName == object.AccountHolderName) {
			return true;
		} else {
			return false;
		}
	}
}
