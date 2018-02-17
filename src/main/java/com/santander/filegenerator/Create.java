package com.santander.filegenerator;

public class Create {

	private String baseName;
	private Integer size;
	private Integer count;
	private Long intitalWait;
	private Integer threads;

	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getIntitalWait() {
		return intitalWait;
	}

	public void setIntitalWait(Long intitalWait) {
		this.intitalWait = intitalWait;
	}

	public Integer getThreads() {
		return threads;
	}

	public void setThreads(Integer threads) {
		this.threads = threads;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseName == null) ? 0 : baseName.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((intitalWait == null) ? 0 : intitalWait.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((threads == null) ? 0 : threads.hashCode());
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
		Create other = (Create) obj;
		if (baseName == null) {
			if (other.baseName != null)
				return false;
		} else if (!baseName.equals(other.baseName))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (intitalWait == null) {
			if (other.intitalWait != null)
				return false;
		} else if (!intitalWait.equals(other.intitalWait))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (threads == null) {
			if (other.threads != null)
				return false;
		} else if (!threads.equals(other.threads))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Create [baseName=" + baseName + ", size=" + size + ", count=" + count + ", intitalWait=" + intitalWait
				+ ", threads=" + threads + "]";
	}

}