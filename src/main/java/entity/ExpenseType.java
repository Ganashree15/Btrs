package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "expense_types")
public class ExpenseType extends AbstractEntity {
	private static final long serialVersionUID = 7711505597348200997L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expenseCategory", cascade = CascadeType.REMOVE)
	private Set<ExpenseCateType> expenseCateType = new HashSet<ExpenseCateType>(0);

	@Column(name = "value")
	private String value;

	@Column(name = "tax_percent")
	private Double taxPercent;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expenseType", cascade = CascadeType.REMOVE)
	private Set<Expense> expenses = new HashSet<Expense>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expenseType", cascade = CascadeType.REMOVE)
	private Set<ExpenseTypePara> expenseTypePara = new HashSet<ExpenseTypePara>(0);

	public ExpenseType() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Double getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(Double taxPercent) {
		this.taxPercent = taxPercent;
	}

	public Set<ExpenseCateType> getExpenseCateType() {
		return expenseCateType;
	}

	public void setExpenseCateType(Set<ExpenseCateType> expenseCateType) {
		this.expenseCateType = expenseCateType;
	}

	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	public Set<ExpenseTypePara> getExpenseTypePara() {
		return expenseTypePara;
	}

	public void setExpenseTypePara(Set<ExpenseTypePara> expenseTypePara) {
		this.expenseTypePara = expenseTypePara;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ExpenseType other = (ExpenseType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
