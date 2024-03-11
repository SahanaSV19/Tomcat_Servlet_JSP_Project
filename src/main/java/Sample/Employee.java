package Sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int eid;
	@Column(nullable=false)
private String ename;
	@Column(nullable=false)
private double esalary;
	@Column(nullable=false)
private String CompanyNmae;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getEsalary() {
		return esalary;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}
	public String getCompanyNmae() {
		return CompanyNmae;
	}
	public void setCompanyNmae(String companyNmae) {
		CompanyNmae = companyNmae;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	@Column(nullable=false)
private String address;
	@Column(nullable=false)
	@Lob
private byte[] resume;
}
