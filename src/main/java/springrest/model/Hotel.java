package springrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="hotels")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="hotel_name")
	private String hotelName;
	
	@Column(name="hotel_description")
	private String hotelDescription;
	
	@Column(name="hotel_image")
	private String hotelImage;
	
	@Column(name="hotel_ratings")
	private Integer hotelRatings;

	public Hotel() {
		super();
	}

	public Hotel(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getHotelImage() {
		return hotelImage;
	}

	public void setHotelImage(String hotelImage) {
		this.hotelImage = hotelImage;
	}

	public Integer getHotelRatings() {
		return hotelRatings;
	}

	public void setHotelRatings(Integer hotelRatings) {
		this.hotelRatings = hotelRatings;
	}
}
