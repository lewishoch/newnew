package protocol;

public class AccountStatusProtocol {
	// Status Type
	public static final int ACCEPTED = 0;
	public static final int PENDING = 2;
	public static final int REJECTED = 3;
	public static final int FROZEN = 4;
	
	public static String getStatus(int statusNum) {
		switch (statusNum) {
		case ACCEPTED:
			return "accepted";
		case PENDING:
			return "pending";
		case REJECTED:
			return "rejected";
		case FROZEN:
			return "frozen";
		}
		return "invalid status";
	}
}
