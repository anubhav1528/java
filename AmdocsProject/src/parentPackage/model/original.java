package parentPackage.model;

public class original {

	private int original_id;
	private String Message_code;
	private int BA;
	private int cycle;
	private String Message_is_valid;
	private String Message_text;
	private String BA_Language;

	public original() {
		super();
	}

	public original(int original_id, String message_code, int bA, int cycle, String message_is_valid,
			String message_text, String bA_Language) {
		super();
		this.original_id = original_id;
		Message_code = message_code;
		BA = bA;
		this.cycle = cycle;
		Message_is_valid = message_is_valid;
		Message_text = message_text;
		BA_Language = bA_Language;
	}

	@Override
	public String toString() {
		return "original [original_id=" + original_id + ", Message_code=" + Message_code + ", BA=" + BA + ", cycle="
				+ cycle + ", Message_is_valid=" + Message_is_valid + ", Message_text=" + Message_text + ", BA_Language="
				+ BA_Language + "]";
	}

	public int getOriginal_id() {
		return original_id;
	}

	public void setOriginal_id(int original_id) {
		this.original_id = original_id;
	}

	public String getMessage_code() {
		return Message_code;
	}

	public void setMessage_code(String message_code) {
		Message_code = message_code;
	}

	public int getBA() {
		return BA;
	}

	public void setBA(int bA) {
		BA = bA;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public String getMessage_is_valid() {
		return Message_is_valid;
	}

	public void setMessage_is_valid(String message_is_valid) {
		Message_is_valid = message_is_valid;
	}

	public String getMessage_text() {
		return Message_text;
	}

	public void setMessage_text(String message_text) {
		Message_text = message_text;
	}

	public String getBA_Language() {
		return BA_Language;
	}

	public void setBA_Language(String bA_Language) {
		BA_Language = bA_Language;
	}

}
