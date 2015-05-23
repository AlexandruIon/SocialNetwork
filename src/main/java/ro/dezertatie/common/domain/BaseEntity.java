package ro.dezertatie.common.domain;


import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<I extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private I id;

	protected BaseEntity() {
	}

	protected BaseEntity(I Id) {
		this.id = id;
	}

	public I getId() {
		return id;
	}

	public void setId(I id) {
		this.id = id;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (id == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BaseEntity<?> other = (BaseEntity<?>) obj;
		return id.equals(other.getId());
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [ID=" + id + "]";
	}
}
