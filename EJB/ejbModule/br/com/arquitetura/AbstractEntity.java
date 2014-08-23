package br.com.arquitetura;

public abstract class AbstractEntity extends AbstractState implements IIdentifier<Long> {
	
	private static final long serialVersionUID = 1L; //

	public AbstractEntity() {
	}
	
	public AbstractEntity(EntityState entityState) {
		this();
		this.setEntityState(entityState);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractEntity)) {
			return false;
		}

		AbstractEntity other = (AbstractEntity) obj;

		Long myId = getId();
		Long otherId = other.getId();
		
		if (myId == null || otherId == null) {
		
			if(myId == null && otherId == null){
				if(this.getClientId() != null && other.getClientId() != null){
					return this.getClientId().equals(other.getClientId());
				}
			}
			
			return false;
		}
		
		return myId.longValue() == otherId.longValue();
		
	}

	@Override
	public int hashCode() {				
		Long id = getId();
		return (id == null) ? super.hashCode() : id.hashCode();
	}

	public void validate(){
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[ID:" + getId() + " State:" + getEntityState()+" ClientId: "+getClientId()+" super.hashCode="+super.hashCode()+" ]";
	}

}
