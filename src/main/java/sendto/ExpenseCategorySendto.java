package sendto;

import javax.xml.bind.annotation.XmlTransient;

public class ExpenseCategorySendto {

	private Long id;
	private String name_key;
	private String code;

	public ExpenseCategorySendto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_key() {
		return name_key;
	}

	public void setName_key(String name_key) {
		setName_keySet(true);
		this.name_key = name_key;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isName_keySet;

	@XmlTransient
	public boolean isName_keySet() {
		return isName_keySet;
	}

	@XmlTransient
	public void setName_keySet(boolean isName_keySet) {
		this.isName_keySet = isName_keySet;
	}

}
