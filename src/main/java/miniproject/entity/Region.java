package miniproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the regions database table.
 * 
 */
@Entity
@Table(name="regions")
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="REGION_ID")
	private Long regionId;

	@Column(name="REGION_NAME")
	private String regionName;

	//bi-directional many-to-one association to Country
	@OneToMany(mappedBy="region")
	private List<Country> countries;

	public Region() {
	}

	public Region(long regionId) {
		this.regionId = regionId;
	}

	public Long getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public List<Country> getCountries() {
		return this.countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public Country addCountry(Country country) {
		getCountries().add(country);
		country.setRegion(this);

		return country;
	}

	public Country removeCountry(Country country) {
		getCountries().remove(country);
		country.setRegion(null);

		return country;
	}

}